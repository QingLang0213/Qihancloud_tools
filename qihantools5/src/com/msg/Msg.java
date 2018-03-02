package com.msg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.FileAppender;

import com.common.ByteUtil;
import com.common.Common;
import com.constant.Commands;
import com.factory.MsgFactory;
import com.qihancloud.QiHanServer;
import com.test.tools.ToolsLogic;

public class Msg {
	public Socket socket;
	InputStream in;
	OutputStream outputStream;
	DataInputStream dataInputStream;
	DataInputStream dataOutputStream;
	public QiHanServer qiHanServer;
	boolean dong;
	public byte[]head_from_s;
	public byte[]body_from_s;
	

	public FileAppender appender;

	public Msg(QiHanServer qiHanServer) {

		this.qiHanServer = qiHanServer;
		this.socket = qiHanServer.tcpSocket;
		dong = true;
		try {
			in = this.socket.getInputStream();
			outputStream = this.socket.getOutputStream();
			dataInputStream = new DataInputStream(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void receive(){
		byte[]len_bytes=new byte[4];
		head_from_s=new byte[72];
		body_from_s=null;
		try {
			if((in.read(len_bytes)!=-1)) {
				int length=ByteUtil.byte4ToInt(len_bytes);
				byte[]msg_bytes= new byte[length];
				int readBytes=0;  
				while (readBytes < length) {  
					int read = in.read(msg_bytes, readBytes, length - readBytes);  
					 if (read == -1) {
						 break; //判断是不是读到了数据流的末尾 ，防止出现死循环。  
					 }  
					 readBytes += read;  
				} 
				body_from_s=new byte[length-72];
				System.arraycopy(msg_bytes,0,head_from_s,0,72);
				System.arraycopy(msg_bytes,72,body_from_s,0,length-72);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receiveMsg() {
		
		while (dong){
			receive();
			MsgHeader head=MsgFactory.byteArrayToMsgHeader(head_from_s);
			qiHanServer.call(head,body_from_s);
			if (head.getCommand()== Commands.CMD_GW_ACCOUNT_LOGOUT_RSP) {
				dong = false;
				close();
				break;
			}
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param msg
	 * @param wait
	 *            消息发送后等待的时间（毫秒）需大于100
	 */
	public void sendMsg(byte[] msg, int wait) {

		if (dong && !(this.socket.isOutputShutdown()) && socket.isConnected()) {
			try {
				outputStream.write(msg);
				outputStream.flush();
				Common.sleepTime(wait);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	/**
	 * 发送消息默认等待350毫秒
	 * 
	 * @param msg
	 */
	public void sendMsg(byte[] msg) {
		if (dong && !(this.socket.isOutputShutdown())) {

			try {
				outputStream.write(msg);
				outputStream.flush();
				Common.sleepTime(ToolsLogic.req_delay);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("socket异常关闭");
				
			}
		}

	}

	public void stop(){
		this.dong=false;
		close();
	}
	
	
	public void close() {
		try {
			outputStream.close();
			in.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
