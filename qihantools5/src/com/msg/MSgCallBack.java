package com.msg;public interface MSgCallBack {	/**	 * 处理服务器返回的消息	 * 	 * @param commands	 *            服务器返回的命令字	 * @param msg_body	 *            消息体	 */	public void call(MsgHeader msg_header, byte[] msg_body);}