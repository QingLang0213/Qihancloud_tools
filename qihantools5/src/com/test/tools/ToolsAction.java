package com.test.tools;

import java.io.File;

import com.constant.Parameter;

import redis.clients.jedis.Jedis;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class ToolsAction {
	
	ToolsLogic tools_logic=new ToolsLogic();
	
	
	
	
	public boolean check_uid(){
		
		try{
			tools_logic.uid_start=Integer.valueOf(Tools.friUidStart.getText());
		  }catch(NumberFormatException e){
			  ToolsLogic.appendText("uid_start should be digit\n");
		 	  return false;
		  }
		try{
			tools_logic.uid_end=Integer.valueOf(Tools.friUidEnd.getText())+1;
		  }catch(NumberFormatException e){
			  ToolsLogic.appendText("uid_end should be digit\n");
			  return false;
		  }
		if (tools_logic.uid_end<tools_logic.uid_start){
			ToolsLogic.appendText("uid_end must greater than uid_start\n");
			return false;
		}
		return true;
	}
	
	public boolean check_send_times(){
		try{
			tools_logic.send_msg_times=Integer.valueOf(Tools.MsgTestTimes.getText());
		  }catch(NumberFormatException e){
			  ToolsLogic.appendText("send_msg_times should be digit\n");
			  return false;
		  }
		return true;
	}
	
	public boolean check_remarks(){
		
		tools_logic.modify_remarks=Tools.ModifyRemarks.getText();
		if(tools_logic.modify_remarks.trim().isEmpty()){
			ToolsLogic.appendText("remarks should not be empty\n");
			return false;
		}
		if(tools_logic.modify_remarks.length()>20){
			ToolsLogic.appendText("remarks should less than 20 character\n");
			return false;
		}
		return true;
	}

	public boolean get_data(int seq){
		
		ToolsLogic.req_delay=(int) Tools.req_group.getSelectedToggle().getUserData();
		tools_logic.loop_delay=(int) Tools.loop_group.getSelectedToggle().getUserData();
		
		if (!check_uid()){
			return false;
		}
		
		switch (seq){
			case 1:
				break;
			case 2:
				break;
			case 3:
				if(!check_send_times()){return false;}
				break;
			case 4:
				if(!check_send_times()){return false;}
				break;
			case 5:
				if(!check_send_times()){return false;}
				break;
			case 6:
				if(!check_remarks()){return false;}
				break;
			case 7:
				break;
			case 8:
				try{
					tools_logic.devUid=Integer.valueOf(Tools.DevUid.getText());
				  }catch(NumberFormatException e){
					  ToolsLogic.appendText("dev uid should be digit\n");
				 	  return false;
				  }
				break;
			case 9:
				break;
		}
		
		
		if (tools_logic.uid_start<10000000){
			tools_logic.getPool(Parameter.QIHANYUNIP_A, Parameter.REDIS_A);
		}
		else{
			tools_logic.getPool(Parameter.QIHANYUNIP_B, Parameter.REDIS_B);
		}
		
        return true;
	}
	
	
	public static void set_disable(boolean flag){
		Tools.fri_add_btn.setDisable(flag);
		Tools.fri_del_btn.setDisable(flag);
		Tools.send_text_msg_btn.setDisable(flag);
		Tools.send_voice_msg_btn.setDisable(flag);
		Tools.send_pic_msg_btn.setDisable(flag);
		Tools.modify_remarks_btn.setDisable(flag);
		Tools.modify_avatar_btn.setDisable(flag);
	}
	
	public int set_handle(int seq){
		if(ToolsLogic.flag&&seq!=8){
			ToolsLogic.appendText(Login.myaccount+" login other device,please login again\n");
			return -1;
		}
		
		if (get_data(seq)){
      	  set_disable(true);
      	  tools_logic.seq=seq;
      	  
      	  Thread thread = new Thread(tools_logic); 
      	  thread.setDaemon(true);
      	  thread.start();
        }
		return 0;
	}
	
	
	
	public void set_action(){
		
		Tools.fri_add_btn.setOnAction(new EventHandler<ActionEvent>() {  
	         @Override  
	         public void handle(ActionEvent event) {  
	        	 set_handle(1);
	         }  
	     });  
	     
		Tools.fri_del_btn.setOnAction(new EventHandler<ActionEvent>() {  
	         @Override  
	         public void handle(ActionEvent event) {  
	        	 set_handle(2);
	         }  
	     });  
	     
		Tools.send_text_msg_btn.setOnAction(new EventHandler<ActionEvent>() {  
	         @Override  
	         public void handle(ActionEvent event) {  
	        	 set_handle(3);
	         }  
	     }); 
	     
		Tools.send_voice_msg_btn.setOnAction(new EventHandler<ActionEvent>() {  
	         @Override  
	         public void handle(ActionEvent event) {  
	        	 set_handle(4);
	         }  
	     });  
	     
		Tools.send_pic_msg_btn.setOnAction(new EventHandler<ActionEvent>() {  
	         @Override  
	         public void handle(ActionEvent event) {  
	        	  set_handle(5);
	              
	         }  
	     });  
	    
		Tools.modify_remarks_btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
	        	  set_handle(6);
	              
	         }  
		});
		
		Tools.modify_avatar_btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
	        	  set_handle(7);
	              
	         }  
		});
		
		
		Tools.login.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
	        	  tools_logic.login();
	        	  
	              
	         }  
		});
		
		Tools.logout.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
	        	
	        	  tools_logic.logout();
	              
	         }  
		});
		
		
		Tools.viewlog.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
				open_file("logs");
	         }  
		});
		
		Tools.viewimg.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
				open_file("img");
	         }  
		});
		
		Tools.viewamr.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
				open_file("amr");
	         }  
		});
	
		Tools.reset.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) {  
				set_disable(false);
				tools_logic.logout();
	         }  
		});

		Tools.readMe.setOnAction(new EventHandler<ActionEvent>(){
			@Override  
	         public void handle(ActionEvent event) { 
				tools_logic.readMe();
			}
		});
	}
	
	public void open_file(String name){
		
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        
        File file=new File(System.getProperty("user.dir")+"\\"+name+"\\");
        if(file.exists() && file.isDirectory())      
        {  
        fileChooser.setInitialDirectory(file);
        fileChooser.showOpenDialog(Tools.secondaryStage);
        }
	}

	
}