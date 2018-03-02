package com.msg;



import org.apache.log4j.Logger;

import com.common.Common;
import com.constant.Commands;
import com.qihancloud.QiHanServer;
import com.test.tools.Login;
import com.test.tools.Tools;
import com.test.tools.ToolsLogic;

public class HandleMsg {
	
	private static Logger logger = Logger.getLogger(HandleMsg.class);
	
	public static boolean handle(MsgHeader header, byte[] msg_body, QiHanServer qh) {

		int command = header.getCommand();
		int reason_code=header.getReason_code();
		if (command!=3001){
			logger.info(qh.srcUid+"rsp commands:"+command);
		}
		if(reason_code!=0&&reason_code!=3){
			logger.error(qh.srcUid+"reason_code:"+reason_code);
			ToolsLogic.appendText(qh.srcUid+"reason_code:"+reason_code+"\n");
			return false;
		}
		
		switch (command) {
		case Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_RSP:	
			qh.account_relationship_add_ask_rsp(msg_body);
			break;
		case Commands.CMD_ACCOUNT_RELATIONSHIP_MESSAGE_ADD_ASK_QUERY_RSP:
			qh.account_relationship_message_add_ask_query_rsp(msg_body);
			break;
		case Commands.CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ASK_DELETE_RSP:
			qh.account_msg_relationship_add_ask_delete_rsp(msg_body);
			break;
		case Commands.CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ:
			qh.account_relationship_add_ask_online_send_2_peer_req(msg_body);
			break;
		case Commands.CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_RSP:
			qh.account_msg_relationship_add_answer_rsp(msg_body);
			break;
		case Commands.CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_SEND_2_PEER_REQ:
			qh.account_msg_relationship_add_answer_send_2_peer_req(msg_body);
			break;
		case Commands.CMD_ACCOUNT_RELATIONSHIP_QUERY_RSP:
			qh.account_relationship_query_rsp(msg_body);
			break;
		case Commands.CMD_ACCOUNT_RELATIONSHIP_DELETE_RSP:
			qh.account_relationship_delete_rsp(msg_body);
			break;
		case Commands.CMD_GW_ACCOUNT_FRI_BASE_INFO_QUERY_RSP:
			qh.account_friend_base_info_query_rsp(msg_body);
			break;
		case Commands.CMD_GW_ACCOUNT_FRI_REMARKS_DATA_WRITE_RSP:
			qh.gw_account_fri_remarks_data_write_rsp(msg_body);
			break;
		case Commands.CMD_GW_ACCOUNT_FRI_REMARKS_INFO_QUERY_RSP:
			qh.gw_account_fri_remarks_info_query_rsp(msg_body);
			break;
		case Commands.CMD_CLIENT_CHAT_MSG_RSP:
			logger.info("send message success");
			break;
		case Commands.CMD_CLIENT_PULL_MSG_RSP:
			qh.client_pull_msg_rsp(msg_body);
			break;
		case Commands.CMD_MSG_CHAT_CLIENT_REQ:
			qh.msg_chat_client_req( header, msg_body);
			break;
		case Commands.CMD_ACCOUNT_UID_QUERY_RSP:
			qh.account_uid_query_rsp(msg_body);
			break;
		case Commands.CMD_GW_ACCOUNT_LOGOUT_RSP:
			qh.gw_account_logout_rsp(msg_body);
			break;
		case Commands.CMD_GW_ACCOUNT_QUERY_RSP:
			qh.gw_account_query_rsp(msg_body);
			break;
		case Commands.CMD_GW_ACCOUNT_MODIFY_RSP:
			qh.gw_account_modify_rsp(msg_body);
			break;
		case Commands.CMD_GW_DEV_ACCOUNT_MODIFY_RSP:
			qh.gw_dev_account_modify_rsp(msg_body);
			break;
		case Commands.CMD_UP_FILE_RSP:
			qh.cmd_up_file_rsp(msg_body);
			break;
		case Commands.CMD_FINISH_UP_FILE_RSP:
			qh.cmd_finish_up_file_rsp(msg_body);
			break;
		case Commands.CMD_DOWN_FILE_RSP:
			qh.cmd_down_file_rsp(msg_body);
			break;
		case Commands.CMD_FINISH_DOWN_FILE_RSP:
			qh.cmd_finish_down_file_rsp(header);
			break;
		case Commands.CMD_ACCOUNT_FORCE_LOGOUT_REQ:
			qh.account_force_logout_rsp();
			logger.error(qh.account+" login other device");
			ToolsLogic.appendText(qh.account +" login other device,please login again\n");
			if (qh.account.equals(Login.myaccount)){
				ToolsLogic.flag=true;
				Tools.secondaryStage.setTitle("ByeBye, "+Login.myaccount); 
			}
			qh.keepHeartThread.stop();
			qh.reciveThread.stop();
			break;
		case 0:
			logger.error(qh.account+"rsp command 0");
			ToolsLogic.appendText(qh.account +" rsp command 0, login other device\n");
			if (qh.account.equals(Login.myaccount)){
				ToolsLogic.flag=true;
				Tools.secondaryStage.setTitle("ByeBye, "+Login.myaccount); 
			}
			qh.keepHeartThread.stop();
			qh.reciveThread.stop();
			Common.sleepTime(1000);
			break;
		default:
			break;
		}
		return true;
	}
}
