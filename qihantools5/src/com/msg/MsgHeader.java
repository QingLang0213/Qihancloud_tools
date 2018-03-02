package com.msg;

import java.io.Serializable;

/**
 * ÏûÏ¢Í·
 *
 * @author Administrator *
 */
public class MsgHeader implements Serializable {
	/***/
	private static final long serialVersionUID = 9137822241416086189L;
	private int flags;
	private int command;
	private int length;
	private short version;
	private short frag_cnt;
	private short frag_index;
	private short frag_len;
	private int app_id;
	private long msg_seq;
	private short dst_set_id;
	private short src_set_id;
	private short dst_svr_type;
	private short src_svr_type;
	private short dst_svr_seq;
	private short src_svr_seq;
	private int dst_user_id;
	private int src_user_id;
	private int dst_group_id;
	private int src_group_id;
	private int src_user_ip;
	private int conn_id;
	private int reason_code;

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	public short getFrag_cnt() {
		return frag_cnt;
	}

	public void setFrag_cnt(short frag_cnt) {
		this.frag_cnt = frag_cnt;
	}

	public short getFrag_index() {
		return frag_index;
	}

	public void setFrag_index(short frag_index) {
		this.frag_index = frag_index;
	}

	public short getFrag_len() {
		return frag_len;
	}

	public void setFrag_len(short frag_len) {
		this.frag_len = frag_len;
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public long getMsg_seq() {
		return msg_seq;
	}

	public void setMsg_seq(long msg_seq) {
		this.msg_seq = msg_seq;
	}

	public short getDst_set_id() {
		return dst_set_id;
	}

	public void setDst_set_id(short dst_set_id) {
		this.dst_set_id = dst_set_id;
	}

	public short getSrc_set_id() {
		return src_set_id;
	}

	public void setSrc_set_id(short src_set_id) {
		this.src_set_id = src_set_id;
	}

	public short getDst_svr_type() {
		return dst_svr_type;
	}

	public void setDst_svr_type(short dst_svr_type) {
		this.dst_svr_type = dst_svr_type;
	}

	public short getSrc_svr_type() {
		return src_svr_type;
	}

	public void setSrc_svr_type(short src_svr_type) {
		this.src_svr_type = src_svr_type;
	}

	public short getDst_svr_seq() {
		return dst_svr_seq;
	}

	public void setDst_svr_seq(short dst_svr_seq) {
		this.dst_svr_seq = dst_svr_seq;
	}

	public short getSrc_svr_seq() {
		return src_svr_seq;
	}

	public void setSrc_svr_seq(short src_svr_seq) {
		this.src_svr_seq = src_svr_seq;
	}

	public int getDst_user_id() {
		return dst_user_id;
	}

	public void setDst_user_id(int dst_user_id) {
		this.dst_user_id = dst_user_id;
	}

	public int getSrc_user_id() {
		return src_user_id;
	}

	public void setSrc_user_id(int src_user_id) {
		this.src_user_id = src_user_id;
	}

	public int getDst_group_id() {
		return dst_group_id;
	}

	public void setDst_group_id(int dst_group_id) {
		this.dst_group_id = dst_group_id;
	}

	public int getSrc_group_id() {
		return src_group_id;
	}

	public void setSrc_group_id(int src_group_id) {
		this.src_group_id = src_group_id;
	}

	public int getSrc_user_ip() {
		return src_user_ip;
	}

	public void setSrc_user_ip(int src_user_ip) {
		this.src_user_ip = src_user_ip;
	}

	public int getConn_id() {
		return conn_id;
	}

	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}

	public int getReason_code() {
		return reason_code;
	}

	public void setReason_code(int reason_code) {
		this.reason_code = reason_code;
	}
}