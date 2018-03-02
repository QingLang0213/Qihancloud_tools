package com.test.tools;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import javafx.application.Platform;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.common.Common;
import com.constant.Commands;
import com.constant.Parameter;
import com.qihancloud.QiHanServer;
import com.qihancloud.proto.MsgDefine;
import com.qihancloud.proto.MsgDefine.account_relationship_add_ask_online_send_2_peer_req;
import com.qihancloud.proto.MsgDefine.account_relationship_add_ask_rsp;
import com.qihancloud.proto.MsgDefine.friend_base_info;

public class ToolsLogic implements Runnable {
	private static Logger logger = Logger.getLogger(ToolsLogic.class);
	public static int req_delay;
	public int loop_delay;
	public int uid_start;
	public int uid_end;
	public int send_msg_times;
	public String modify_remarks;
	public static int seq;
	public String f_account;
	public String f_pwd;
	public String admin;
	public String admin_pwd;
	public int devUid;
	public static QiHanServer server1;
	public static boolean flag;
	public static JedisPool pool = null;  
	public int f_type;//1=qlink_id,2=device
	
	
	public void getPool(String ip,int port){  
        //创建jedis连接池配置  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxWait(10000);
        config.setMaxIdle(10);  
        config.setMaxActive(100);
        //创建redis连接池  
        pool = new JedisPool(config,ip,port,5000,"qhkj_redis_987");  
       
    }  
	
	public void login(){
		if (flag){
			if(Login.my_type==1){
				server1= new QiHanServer(Login.myaccount, "qlink_id");
				server1.login(Login.md5_pwd);
			}
			else{
				server1= new QiHanServer(Login.myaccount, "device");
				server1.login();
			}
			
			flag=false;
			Tools.secondaryStage.setTitle("Welcome, "+Login.myaccount);
			logger.debug(Login.myaccount+" is login\n ");
			appendText(Login.myaccount+" is login\n ");
		}
		else{
			logger.debug(Login.myaccount+" already login \n ");
			appendText(Login.myaccount+" already login \n ");
		}
		
	}
	
	public void logout(){
		if (!flag){
			server1.logout();
			flag=true;
			Tools.secondaryStage.setTitle("ByeBye, "+Login.myaccount); 
			appendText(Login.myaccount+" is logout \n");
			logger.debug(Login.myaccount+" is logout \n");
		}
		else{
		appendText(Login.myaccount+" already logout \n");
		logger.debug(Login.myaccount+" already logout \n");
		}
	}
	
	public static void appendText(final String text){
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	Tools.ta.appendText(text);
	        }
	    });
	}
	
	
	public void get_account(int uid){
		
		Jedis jedis = pool.getResource();
		String account=jedis.hget("user_info:"+uid,"account");
		f_pwd=jedis.hgetAll("user_info:"+uid).get("pass_word");
		if (account.startsWith("qlink_id_")){
			f_account=account.substring(9, account.length());
			f_type=1;
		}
		else{
			f_account=account.substring(7, account.length());
			f_type=2;
		}
		pool.returnResource(jedis);    
	}
	
	
	
	
	public boolean get_manager(int devUid){
		
		int manager_uid = 0;
		String redis_ip=Parameter.QIHANYUNIP_A;
		int redis_port=Parameter.REDIS_A;
		if (devUid>=10000000){
			redis_ip=Parameter.QIHANYUNIP_B;
			redis_port=Parameter.REDIS_B;
		}
		Jedis jedis = new Jedis(redis_ip, redis_port);
		jedis.auth("qhkj_redis_987");
		Set<String> friend_list=jedis.smembers("friend_list:"+devUid);
		Map<String, String> map=jedis.hgetAll("network_perm:"+devUid);
		
		if (map.isEmpty()){
			logger.debug(devUid+"device no manager");
			appendText(devUid+"device no manager \n");
			return false;
		}
		for (String f_uid : friend_list) {  
		      String per=map.get("permission:"+f_uid);  
		      if(per==null){continue;}
		      if (per.equals("1")){
		    	  
		    	  manager_uid=Integer.parseInt(f_uid);
		    	
		    	  if (manager_uid<10000000){
		    		  redis_ip=Parameter.QIHANYUNIP_A;
			    	  redis_port=Parameter.REDIS_A;
			    	  }
		    	  else{
		    		  redis_ip=Parameter.QIHANYUNIP_B;
		    		  redis_port=Parameter.REDIS_B;
			    	  }
		    	  jedis = new Jedis(redis_ip, redis_port);
			      jedis.auth("qhkj_redis_987");
			      String account=jedis.hget("user_info:"+manager_uid, "account");
			      admin=account.substring(9, account.length());
			      admin_pwd=jedis.hget("user_info:"+manager_uid, "pass_word");
			      appendText(devUid+"device manager is "+admin+"\n");
			      logger.debug(devUid+"device manager is "+admin+"\n");
			      return true; 
		      }   
		}  
		logger.debug(devUid+"device no manager");
		appendText(devUid+"device no manager \n");
		return false;
	}
	
	
	public boolean dev_add_friend(){
		for (int uid = uid_start; uid<uid_end; uid++) {
			if(flag){return false;}
			if (server1.account_relationship_query(uid)){
				logger.debug(server1.srcUid+"和"+uid+"已经是好友关系，无法再次添加\n");
				appendText(server1.srcUid+"和"+uid+"已经是好友关系，无法再次添加\n");
				continue;
			}
			get_account(uid);
			if(f_type==2){
				appendText(uid+" is device, device can't add device\n");
				logger.debug(uid+" is device, device can't add device");
				continue;
			}
			dev_add_qlink();
			Common.sleepTime(loop_delay);	
		}
		return true;
		
	}
	
	public boolean qlink_add_friend(){
		
		for (int uid = uid_start; uid<uid_end; uid++) {
			if(flag){return false;}
			if (server1.account_relationship_query(uid)){
				logger.debug(server1.srcUid+"和"+uid+"已经是好友关系，无法再次添加\n");
				appendText(server1.srcUid+"和"+uid+"已经是好友关系，无法再次添加\n");
				continue;
			}
			get_account(uid);
			if(f_type==1){
				qlink_add_qlink();
			}
			else{
				logger.debug(uid+" is device\n");
				appendText(uid+" is device\n");
				qlink_add_dev(uid);
				
			}
			Common.sleepTime(loop_delay);
		}
		return true;
		
	}
	
	
	public void qlink_add_qlink(){
		
		QiHanServer server2 = new QiHanServer(f_account, "qlink_id");
		server2.login(f_pwd);
		
		server2.account_relationship_add_ask_req(server1.srcUid, "hello");
		
		MsgDefine.account_relationship_add_ask_rsp rsp=null;
		int i=0;
		while(rsp==null){
			rsp=(account_relationship_add_ask_rsp) server2.map.get(Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_RSP);
			i++;
			if (i>100){
				logger.error("\n"+server2.srcUid+"add friend"+server1.srcUid+" failed, add_ask_rsp is null\n");
				appendText("\n"+server2.srcUid+"add friend"+server1.srcUid+" failed,add_ask_rsp is null\n");
				break;
			}
			Common.sleepTime(100);
		}
			
		if(rsp!=null){
			MsgDefine.account_relationship_add_ask_online_send_2_peer_req req = (account_relationship_add_ask_online_send_2_peer_req)server1.map
				.get(Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ);
			server1.account_msg_relationship_add_answer_req(1, req.getAskUid(), server1.srcUid,req.getMsgId(),0);
		}
		
		server2.logout();
		
	}
	
	
	public void qlink_add_dev(int uid){
		
		if(get_manager(uid)){
			QiHanServer server=new QiHanServer(admin, "qlink_id");
			server.login(admin_pwd);
			server1.account_relationship_add_ask_req(uid, "hello");
			MsgDefine.account_relationship_add_ask_online_send_2_peer_req req = (account_relationship_add_ask_online_send_2_peer_req) server.map
					.get(Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ);
			server.account_msg_relationship_add_answer_req(1, req.getAskUid(),req.getAskedUid(), req.getMsgId(),uid);
			server.logout();
		}
		else{
			QiHanServer server2 = new QiHanServer(f_account, "device");
			server2.login();
			server1.account_relationship_add_ask_req(uid, "hello");
			MsgDefine.account_relationship_add_ask_online_send_2_peer_req req = (account_relationship_add_ask_online_send_2_peer_req) server2.map
					.get(Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ);
			server2.account_msg_relationship_add_answer_req(1, req.getAskUid(),req.getAskedUid(), req.getMsgId(),uid);
			server2.logout();
		}
		
	}
	
	
	
	public void dev_add_qlink(){
		if(get_manager(server1.srcUid)){
			QiHanServer server=new QiHanServer(admin, "qlink_id");
			server.login(admin_pwd);
			QiHanServer server2=new QiHanServer(f_account, "qlink_id");
			server2.login(f_pwd);
			server2.account_relationship_add_ask_req(server1.srcUid, "hello");
			MsgDefine.account_relationship_add_ask_online_send_2_peer_req req =null;
			int i=0;
			while (req==null){
				req = (account_relationship_add_ask_online_send_2_peer_req) server.map.get(Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ);
				if (i>100){
					logger.error("\n"+server.srcUid+"didn't recv add_friend_req(0x20641)\n");
					appendText("\n"+server.srcUid+"didn't recv add_friend_req(0x20641)\n");
					break;
				}
				Common.sleepTime(100);
			}
			server.account_msg_relationship_add_answer_req(1, req.getAskUid(),req.getAskedUid(), req.getMsgId(),server1.srcUid);
			server2.logout();
			server.logout();
			
		}
		else{
			QiHanServer server2=new QiHanServer(f_account, "qlink_id");
			server2.login(f_pwd);
			server2.account_relationship_add_ask_req(server1.srcUid, "hello");
			MsgDefine.account_relationship_add_ask_online_send_2_peer_req req = (account_relationship_add_ask_online_send_2_peer_req) server1.map
					.get(Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ);	
			server1.account_msg_relationship_add_answer_req(1, req.getAskUid(),req.getAskedUid(), req.getMsgId(),server1.srcUid);
			server2.logout();
			}
		
	}
	
	public void add_friend(){
		
		if (Login.my_type==2){
			dev_add_friend();
		}
		else{
			qlink_add_friend();
		}
	}
	
	public  boolean del_friend(){
		
		for (int uid = uid_start; uid<uid_end; uid++) {
			if(flag){return false;}
			if (!server1.account_relationship_query(uid)){
				logger.info(server1.srcUid+"和"+uid+"不是好友关系,无法进行删除操作\n");
				appendText(server1.srcUid+"和"+uid+"不是好友关系,无法进行删除操作\n");
				continue;
			}
			server1.account_relationship_delete_req(uid);
			//Common.sleepTime(loop_delay);
			if (!server1.account_relationship_query(uid)){
				logger.info(server1.srcUid+"和"+uid+"已经不是好友关系\n");
				appendText(server1.srcUid+"和"+uid+"已经不是好友关系\n");
			}
			Common.sleepTime(loop_delay);
		}
		return true;
	}
	
	
	public  boolean send_text_msg(){
		
		QiHanServer server2;

		for(int uid=uid_start;uid<uid_end;uid++){
			if(flag){return false;}
			if (!server1.account_relationship_query(uid)){
				appendText(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				logger.info(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				continue;
			}
			get_account(uid);
			if (f_type==1){ 
				server2= new QiHanServer(f_account, "qlink_id");
				server2.login(f_pwd);	
			}
			else{
				server2= new QiHanServer(f_account, "device");
				server2.login();
			}
			server1.recv_offline_message();
			server2.recv_offline_message();
			server1.sendUid=server2.srcUid;
			server2.sendUid=server1.srcUid;
			for(int i=1;i<send_msg_times+1;i++){
				server1.client_chat_msg_req(0, "test message "+i,uid);
				Common.sleepTime(loop_delay);
				server2.client_chat_msg_req(0, "test message "+i,server1.srcUid);
			}
			compare_size(server2,"text");
			server2.logout();
		}
		Common.sleepTime(loop_delay);
		return true;
	}
	
	
	public File inputstreamtofile(InputStream ins,File file) throws IOException{
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
		os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
		return file;
		}
	
	
	public  boolean send_voice_msg(){
		//有时候，我们需要加载文本资源或音乐资源，而文本在Java中是以流对象存在的
		InputStream in = this.getClass().getResourceAsStream("/up1.amr");
		String up_path=System.getProperty("user.dir")+"\\up1.amr";
		File file1=new File(up_path);
		String up_file_path = null;
		try {
			up_file_path = inputstreamtofile(in,file1).getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String down_path=System.getProperty("user.dir")+"\\amr\\";
		File file=new File(down_path);
		if  (!file.exists() && !file.isDirectory())      
        {       
        	file .mkdir();    
        }
		QiHanServer server2;
		for(int uid=uid_start;uid<uid_end;uid++){
			if(flag){return false;}
			if (!server1.account_relationship_query(uid)){
				appendText(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				logger.info(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				continue;
			}
			get_account(uid);
			if (f_type==1){ 
				server2= new QiHanServer(f_account, "qlink_id");
				server2.login(f_pwd);	
			}
			else{
				server2= new QiHanServer(f_account, "device");
				server2.login();
			}
			long file_id=server1.up_file_to_server(up_file_path, 3,server2.srcUid);
			appendText(server1.srcUid+" upload voice file to OSS,file_id:"+file_id+"\n");
			String down_file_path=down_path+"down"+file_id+".amr"; 
			String voice_id=String.valueOf(file_id);
			
			server1.recv_offline_message();
			server2.recv_offline_message();
			server1.sendUid=server2.srcUid;
			server2.sendUid=server1.srcUid;
			
			for(int i=0;i<send_msg_times;i++){
				server1.client_chat_msg_req(4,voice_id,uid);
				Common.sleepTime(loop_delay);
				server2.client_chat_msg_req(4, voice_id,server1.srcUid);
			}
		server2.down_file_from_server(file_id,3,down_file_path);
		appendText(server2.srcUid+" download voice file from OSS,file_id:"+file_id+"\n");
		
		compare_size(server2,"voice");
		server2.logout();
		Common.sleepTime(loop_delay);
		}
		
		return true;

	}
	
	public  boolean send_pic_msg(){
		
		
		QiHanServer server2;
		for(int uid=uid_start;uid<uid_end;uid++){
			
			if(flag){return false;}
			if (!server1.account_relationship_query(uid)){
				appendText(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				logger.info(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				continue;
			}
			get_account(uid);
			if (f_type==1){ 
				server2= new QiHanServer(f_account, "qlink_id");
				server2.login(f_pwd);	
			}
			else{
				server2= new QiHanServer(f_account, "device");
				server2.login();
			}
			String up_file_path=CreatImage.create(600, 600);
			long file_id=server1.up_file_to_server(up_file_path,2,server2.srcUid);
			appendText(server1.srcUid+" upload pic file to OSS,file_id:"+file_id+"\n");
			String down_file_path=CreatImage.image_path+"down"+file_id+".jpg"; 
			String pic_id=String.valueOf(file_id);
			
			server1.recv_offline_message();
			server2.recv_offline_message();
			server1.sendUid=server2.srcUid;
			server2.sendUid=server1.srcUid;
			
			for(int i=0;i<send_msg_times;i++){
				server1.client_chat_msg_req(2,pic_id,uid);
				Common.sleepTime(loop_delay);
				server2.client_chat_msg_req(2, pic_id,server1.srcUid);
			}
		server2.down_file_from_server(file_id,3,down_file_path);
		appendText(server2.srcUid+" download pic file from OSS,file_id:"+file_id+"\n");
		
		compare_size(server2,"pic");
		server2.logout();
		Common.sleepTime(loop_delay);
		
		}
		return true;
	}
	
	public void compare_size(QiHanServer server2,String type){
		
		int size1=server1.msg_list.size();
		int size2=server2.msg_list.size();
		logger.info(server1.srcUid+" recv "+type+" msg from "+server2.srcUid+"------msg count:"+size1);
		logger.info(server2.srcUid+" recv "+type+" msg from "+server1.srcUid+"------msg count:"+size2+"\n");
		
		appendText("\n"+server1.srcUid+" recv "+type+" msg from "+server2.srcUid+"------msg count:"+size1+"\n");
		appendText(server2.srcUid+" recv "+type+" msg from "+server1.srcUid+"------msg count:"+size2+"\n\n");
		
		if (size1!=send_msg_times){
			logger.error(server1.srcUid+"recv "+type+" msg count:"+size1+"not equeal"+server2.srcUid+"send_msg_times"+send_msg_times);
		}
		else if(size2!=send_msg_times){
			logger.error(server1.srcUid+"recv "+type+" msg count:"+size1+"not equeal"+server2.srcUid+"send_msg_times"+send_msg_times);
		}
		server1.msg_list.clear();
	}
	
	
	
	public boolean modify_remarks() {
		
		for(int uid=uid_start;uid<uid_end;uid++){
			if(flag){return false;}
			if (!server1.account_relationship_query(uid)){
				appendText(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				logger.info(server1.srcUid+"和"+uid+"不是好友关系，无法操作，请先添加好友\n");
				continue;
			}
			//write remark
			server1.gw_account_fri_remarks_data_write_req(uid, modify_remarks);
			logger.info(server1.srcUid+"请求服务器修改好友"+uid+"昵称为:"+modify_remarks+"\n");
			appendText(server1.srcUid+"请求服务器修改好友"+uid+"昵称为:"+modify_remarks+"\n");
			//qurey remark
			int []fuid_list={uid};
			server1.gw_account_fri_remarks_info_query_req(fuid_list);
			String remark=server1.remark_map.get(uid);
			logger.info(server1.srcUid+"查询到好友"+uid+"昵称为:"+remark+"\n");
			appendText(server1.srcUid+"查询到好友"+uid+"昵称为:"+remark+"\n");
			Common.sleepTime(loop_delay);
		}
		appendText("\n");
		return true;
		
	}
 
	public boolean modify_avatar() {
		// TODO Auto-generated method stub
		
		
		for(int uid=uid_start;uid<uid_end;uid++){
			if(flag){return false;}
			String up_file_path=CreatImage.create(500, 500);
			get_account(uid);
			if (f_type==2){
				logger.debug(uid+" is  device,not support modify avatar \n");
				appendText(uid+" is  device,not support modify avatar \n");
				continue;
			}
	        QiHanServer server2 = new QiHanServer(f_account, "qlink_id");
	        if(!server2.login(f_pwd)){
				appendText(uid+" login failed\n");
				continue;
			}
			long file_id=server1.up_file_to_server(up_file_path,1,server1.srcUid);
	        String avatar_id=String.valueOf(file_id);
	        server2.gw_account_modify_req("url",avatar_id);
	        logger.debug(server2.srcUid+"请求服务器修改头像为file_id:"+avatar_id+"\n");
	        appendText(server2.srcUid+"请求服务器修改头像为file_id:"+avatar_id+"\n");
	        int[] uid_list={server2.srcUid};
	        server1.base_info_query_req(uid_list);
			ArrayList base_info_list=(ArrayList) server1.map.get(Commands.CMD_GW_ACCOUNT_FRI_BASE_INFO_QUERY_RSP);
			MsgDefine.friend_base_info base_info=(friend_base_info) base_info_list.get(0);
			String url=base_info.getUrl();
			logger.debug(server1.srcUid+"查询到好友"+server2.srcUid+"的头像file_id为:"+url+"\n");
			appendText(server1.srcUid+"查询到好友"+server2.srcUid+"的头像file_id为:"+url+"\n");
			server2.logout();
			Common.sleepTime(loop_delay);
		}
		appendText("\n");
		return true;
	}

	public void readMe(){
		appendText("1.支持qlink账号和机器人设备id登陆\n");
		appendText("2.qlink登陆支持加好友(包括qlink和device)，删好友，发消息，修改好友昵称，修改个人头像\n");
		appendText("3.设备登陆支持加好友(仅qlink)，删好友，发消息，修改好友昵称\n");
		appendText("4.Add Friend，加好友，需要输入添加好友uid范围\n");
		appendText("5.Del Friend，删好友，需要输入删除好友uid范围\n");
		appendText("6.Send Text Msg，发送文本消息，需要输入好友uid范围，以及和每个好友互发消息次数\n");
		appendText("7.Send Voice Msg，发送语音消息，需要输入好友uid范围，以及每个好友互发消息次数\n");
		appendText("8.Send Pic Msg，发送图片消息，需要输入好友uid范围，以及每个好友互发消息次数\n");
		appendText("9.Modify Remarks，修改好友昵称，需要输入修改昵称的好友uid范围和昵称\n");
		appendText("10.Modify Avatar，修改个人头像，需要输入修改头像的好友uid范围\n");
		appendText("11.生成的图片在img目录下，日志在logs目录下，需手动清除\n");
		appendText("12.req_delay 表示每个socket请求延时，loop_delay表示不同uid用户测试延时\n");
		appendText("13.使用真实机器人登陆测试时，请将原机器人关闭网络或者关机，否则会强制登出\n\n");
		
	}
	
	
	@Override
	public void run() {
		try{
			switch (seq){
				case 1:
					logger.debug("add_friend pressed");
					add_friend();
					break;
				case 2:
					logger.debug("del_friend pressed");
					del_friend();
					break;
				case 3:
					logger.debug("send_text_msg pressed");
					send_text_msg();
					break;
				case 4:
					logger.debug("send_voice_msg pressed");
					send_voice_msg();
					break;
				case 5:
					logger.debug("send_pic_msg pressed");
					send_pic_msg();
					break;
				case 6:
					logger.debug("modify_remarks pressed");
					modify_remarks();
					break;	
				case 7:
					logger.debug("modify_avatar pressed");
					modify_avatar();
					break;	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			ToolsAction.set_disable(false);
			logger.error("catch exception:", e);
			StringWriter sw = new StringWriter();    
			PrintWriter pw = new PrintWriter(sw);    
			e.printStackTrace(pw);    
			String msg=sw.toString();
			appendText(msg+"\n");
			
		}
		
		ToolsAction.set_disable(false);
		
	}

	
	
}
