package com.factory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.common.ByteUtil;
import com.msg.MsgHeader;

public class MsgFactory {

	/**
	 * 将消息头转换成byte数组
	 * 
	 * @param msgHeader
	 * @return
	 */
	public static byte[] toByteArray(MsgHeader msgHeader) {
		ByteArrayOutputStream oos = new ByteArrayOutputStream();
		DataOutputStream bos = new DataOutputStream(oos);
		try {
			bos.writeInt(msgHeader.getFlags());
			bos.writeInt(msgHeader.getCommand());
			bos.writeInt(msgHeader.getLength());
			bos.writeShort(msgHeader.getVersion());
			bos.writeShort(msgHeader.getFrag_cnt());
			bos.writeShort(msgHeader.getFrag_index());
			bos.writeShort(msgHeader.getFrag_len());
			bos.writeInt(msgHeader.getApp_id());
			bos.writeLong(msgHeader.getMsg_seq());
			bos.writeShort(msgHeader.getDst_set_id());
			bos.writeShort(msgHeader.getSrc_set_id());
			bos.writeShort(msgHeader.getDst_svr_type());
			bos.writeShort(msgHeader.getSrc_svr_type());
			bos.writeShort(msgHeader.getDst_svr_seq());
			bos.writeShort(msgHeader.getSrc_svr_seq());
			bos.writeInt(msgHeader.getDst_user_id());
			bos.writeInt(msgHeader.getSrc_user_id());
			bos.writeInt(msgHeader.getDst_group_id());
			bos.writeInt(msgHeader.getSrc_group_id());
			bos.writeInt(msgHeader.getSrc_user_ip());
			bos.writeInt(msgHeader.getConn_id());
			bos.writeInt(msgHeader.getReason_code());
			bos.flush();
		} catch (Exception e) {

		}

		return oos.toByteArray();

	}

	/**
	 * 发送消息是将各个参数组合配置成消息头MsgHeader对象 生成默认的消息头部,具体消息根据消息类型做个别参数配置
	 * 
	 * @return msh
	 */
	public static MsgHeader setMsgHeader() {
		MsgHeader msh = new MsgHeader();
		msh.setFlags(0x51484b4a);
		msh.setCommand(0x10000d);
		msh.setLength(0);
		msh.setVersion((short) 2);
		msh.setFrag_cnt((short) 1);
		msh.setFrag_index((short) 1);
		msh.setFrag_len((short) 0);
		msh.setApp_id(0);
		msh.setMsg_seq((long) 1);
		msh.setDst_set_id((short) 1);
		msh.setSrc_set_id((short) 1);
		msh.setDst_svr_type((short) 0);
		msh.setSrc_svr_type((short) 0);
		msh.setDst_svr_seq((short) 0);
		msh.setSrc_svr_seq((short) 0);
		msh.setDst_user_id(0);
		msh.setSrc_user_id(0);
		msh.setDst_group_id(0);
		msh.setSrc_group_id(0);
		msh.setSrc_user_ip(0);
		msh.setConn_id(0);
		msh.setReason_code(0);
		return msh;
	}

	/**
	 * 合并TCP包中的消息头和消息体
	 * 
	 * @param msg_body
	 *            消息头部
	 * @param msgh_bytes
	 *            消息体
	 * @return 完整的消息
	 */
	public static byte[] commbindhead_body(byte[] msg_body, byte msgh_bytes[]) {

		int len = msgh_bytes.length + msg_body.length;
		byte lens[] = ByteUtil.IntTobyte4(len);
		int lsl = lens.length; // 4个字节

		// 合并消息头和消息体
		byte[] msg = new byte[msgh_bytes.length + msg_body.length + lsl];

		System.arraycopy(lens, 0, msg, 0, lens.length);
		System.arraycopy(msgh_bytes, 0, msg, 4, msgh_bytes.length);
		System.arraycopy(msg_body, 0, msg, 4 + msgh_bytes.length, msg_body.length);
		return msg;

	}

	/**
	 * 将二进制(网络字节序)消息头转成 MsgHeader 对象
	 * 
	 * @param msg_header
	 *            接收到的消息头二进制数据
	 * @return MsgHeader
	 */
	public static MsgHeader byteArrayToMsgHeader(byte[] msg_header) {
		MsgHeader msgheader = new MsgHeader();
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(msg_header);
		DataInputStream dataInputStream = new DataInputStream(arrayInputStream);
		try {
			msgheader.setFlags(dataInputStream.readInt());
			msgheader.setCommand(dataInputStream.readInt());
			msgheader.setLength(dataInputStream.readInt());
			msgheader.setVersion(dataInputStream.readShort());
			msgheader.setFrag_cnt(dataInputStream.readShort());
			msgheader.setFrag_index(dataInputStream.readShort());
			msgheader.setFrag_len(dataInputStream.readShort());
			msgheader.setApp_id(dataInputStream.readInt());
			msgheader.setMsg_seq(dataInputStream.readLong());
			msgheader.setDst_set_id(dataInputStream.readShort());
			msgheader.setSrc_set_id(dataInputStream.readShort());
			msgheader.setDst_svr_type(dataInputStream.readShort());
			msgheader.setSrc_svr_type(dataInputStream.readShort());
			msgheader.setDst_svr_seq(dataInputStream.readShort());
			msgheader.setSrc_svr_seq(dataInputStream.readShort());
			msgheader.setDst_user_id(dataInputStream.readInt());
			msgheader.setSrc_user_id(dataInputStream.readInt());
			msgheader.setDst_group_id(dataInputStream.readInt());
			msgheader.setSrc_group_id(dataInputStream.readInt());
			msgheader.setSrc_user_ip(dataInputStream.readInt());
			msgheader.setConn_id(dataInputStream.readInt());
			msgheader.setReason_code(dataInputStream.readInt());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msgheader;

	}
}
