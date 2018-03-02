package com.constant;

public class Commands {

	public static final int CMD_TCP_CONNECTED = 1;
	public static final int CMD_TCP_CLOSED = 2;

	public static final int dev_qlink_type = 3; // 3��ʾqlink 4��ʾdevice

	public static final int CMD_SERVER_DOWN = 1001;

	public static final int CMD_ACCESS_ECHO = 2001;
	public static final int CMD_LOGIC_ECHO = 2002;
	public static final int CMD_DATA_ECHO = 2003;
	public static final int CMD_MSG_ECHO = 2004;

	public static final int CMD_CLIENT_GREETING = 3001;
	public static final int CMD_ACCESS_GREETING = 3002;
	public static final int CMD_SUPER_GREETING = 3003;
	public static final int CMD_LOGIC_GREETING = 3004;
	public static final int CMD_DATA_GREETING = 3005;
	public static final int CMD_MSG_GREETING = 3006;

	public static final int CMD_CLIENT_TRANS_U2U = 0x100001;
	public static final int CMD_RSP_U2U_TO_CLIENT = 0x100002;

	public static final int CMD_TRANS_U2U_TO_CLIENT = 0x100003;
	public static final int CMD_CLIENT_RSP_U2U = 0x100004;

	public static final int CMD_TRANS_U2U_TO_MSG_SVR = 0x100005;
	public static final int CMD_MSG_SVR_RSP_U2U = 0x100006;

	public static final int CMD_MSG_SVR_TRANS_U2U = 0x100007;
	public static final int CMD_RSP_U2U_TO_MSG_SVR = 0x100008;;
	public static final int CMD_CLIENT_DISCONN = 0x100009;
	public static final int CMD_SHUT_CLIENT_CONN = 0x10000a;;

	public static final int CMD_SEL_P2P_SVR = 0x10000b;
	public static final int CMD_RSP_SEL_P2P_SVR = 0x10000c;

	public static final int CMD_SEL_ACCESS = 0x10000d;
	public static final int CMD_RSP_SEL_ACCESS = 0x10000e;

	// ��Ϣ��ʷ��¼

	public static final int CMD_ADD_SEND_HIST_REQ = 0x10101;
	public static final int CMD_ADD_SEND_HIST_RSP = 0x10102;

	public static final int CMD_ADD_RECV_HIST_REQ = 0x10103;
	public static final int CMD_ADD_RECV_HIST_RSP = 0x10104;

	public static final int CMD_DEL_SEND_HIST_REQ = 0x10105;
	public static final int CMD_DEL_SEND_HIST_RSP = 0x10106;

	public static final int CMD_DEL_RECV_HIST_REQ = 0x10207;
	public static final int CMD_DEL_RECV_HIST_RSP = 0x10208;

	public static final int CMD_GET_SEND_HIST_REQ = 0x10209;
	public static final int CMD_GET_SEND_HIST_RSP = 0x1020a;

	public static final int CMD_GET_RECV_HIST_REQ = 0x1020b;
	public static final int CMD_GET_RECV_HIST_RSP = 0x1020c;

	public static final int CMD_INCR_P2P_USER_REQ = 0x10201;
	public static final int CMD_INCR_P2P_USER_RSP = 0x10202;

	public static final int CMD_DECR_P2P_USER_REQ = 0x10203;
	public static final int CMD_DECR_P2P_USER_RSP = 0x10204;

	public static final int CMD_INCR_ONLINE_USER_REQ = 0x10207;
	public static final int CMD_INCR_ONLINE_USER_RSP = 0x10208;

	public static final int CMD_DECR_ONLINE_USER_REQ = 0x10209;
	public static final int CMD_DECR_ONLINE_USER_RSP = 0x1020a;

	public static final int CMD_CLIENT_CHAT_MSG_REQ = 0x10401;
	public static final int CMD_CLIENT_CHAT_MSG_RSP = 0x10402;
	public static final int CMD_MSG_CHAT_CLIENT_REQ = 0x10403;
	public static final int CMD_MSG_CHAT_CLIENT_RSP = 0x10404;

	public static final int CMD_CLIENT_PULL_MSG_REQ = 0x10405;
	public static final int CMD_CLIENT_PULL_MSG_RSP = 0x10406;
	public static final int CMD_CLIENT_UPDATE_MSG_REQ = 0x10407;
	public static final int CMD_CLIENT_UPDATE_MSG_RSP = 0x10408;

	public static final int CMD_MSG_SEND_MSG_REQ = 0x10409;
	public static final int CMD_MSG_SEND_MSG_RSP = 0x1040A;

	public static final int CMD_MSG_SEND_OFFLINE_REQ = 0x1040B;
	public static final int CMD_MSG_SEND_OFFLINE_RSP = 0x1040C;

	public static final int CMD_CLIENT_GROUP_MSG_REQ = 0x1040D;
	public static final int CMD_CLIENT_GROUP_MSG_RSP = 0x1040E;

	public static final int CMD_CLIENT_CTRL_MSG_REQ = 0x10501;
	public static final int CMD_CLIENT_CTRL_MSG_RSP = 0x10502;
	public static final int CMD_MSG_CTRL_DEVICE_REQ = 0x10503;
	public static final int CMD_MSG_CTRL_DEVICE_RSP = 0x10504;
	public static final int CMD_CLIENT_ONE_MSG_REQ = 0x10505;
	public static final int CMD_MSG_ONE_DEVICE_REQ = 0x10507;

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public static final int CMD_GET_USER_INFO_REQ = 0x20101;
	public static final int CMD_GET_USER_INFO_RSP = 0x20102;

	public static final int CMD_GET_FRND_INFO_REQ = 0x20203;
	public static final int CMD_GET_FRND_INFO_RSP = 0x20204;

	public static final int CMD_GET_FRND_LIST_REQ = 0x20301;
	public static final int CMD_GET_FRND_LIST_RSP = 0x20302;

	public static final int CMD_GET_GROUP_INFO_REQ = 0x20401;
	public static final int CMD_GET_GROUP_INFO_RSP = 0x20402;

	///////////////////////////////////////////////////
	// �ʺ� ��ʼ
	///////////////////////////////////////////////////
	// �ʺţ��������߼���֮��
	// public static final int CMD_GW_ACCOUNT_REG_REQ =0x20601 // TODO:�Ѿ���д��Ҫȥ��
	// public static final int CMD_GW_ACCOUNT_REG_RSP =0x20602

	public static final int CMD_GW_ACCOUNT_REG_REQ_THIRD_PARTY = 0x20607;
	public static final int CMD_GW_ACCOUNT_REG_RSP_THIRD_PARTY = 0x20608;

	public static final int CMD_GW_ACCOUNT_QUERY_REQ = 0x20609;
	public static final int CMD_GW_ACCOUNT_QUERY_RSP = 0x20610;

	public static final int CMD_GW_ACCOUNT_QUERY_REQ_THIRD_PARTY = 0x20611;
	public static final int CMD_GW_ACCOUNT_QUERY_RSP_THIRD_PARTY = 0x20612;

	public static final int CMD_GW_ACCOUNT_SN_BIND_REQ = 0x20613;
	public static final int CMD_GW_ACCOUNT_SN_BIND_RSP = 0x20614;

	public static final int CMD_GW_ACCOUNT_CHECK_REQ = 0x20615;
	public static final int CMD_GW_ACCOUNT_CHECK_RSP = 0x20616;

	public static final int CMD_GW_ACCOUNT_MODIFY_REQ = 0x20617;
	public static final int CMD_GW_ACCOUNT_MODIFY_RSP = 0x20618;

	public static final int CMD_GW_ACCOUNT_MODIFY_REQ_THIRD_PARTY = 0x20619;
	public static final int CMD_GW_ACCOUNT_MODIFY_RSP_THIRD_PARTY = 0x20620;

	public static final int CMD_GW_ACCOUNT_AUTHENTICATE_REQ = 0x20621;
	public static final int CMD_GW_ACCOUNT_AUTHENTICATE_RSP = 0x20622;

	public static final int CMD_GW_ACCOUNT_SMS_WRITE_REQ = 0x20623;
	public static final int CMD_GW_ACCOUNT_SMS_WRITE_RSP = 0x20624;

	public static final int CMD_GW_ACCOUNT_LOGIN_REQ = 0x20625;
	public static final int CMD_GW_ACCOUNT_LOGIN_RSP = 0x20626;

	public static final int CMD_GW_ACCOUNT_LOGOUT_REQ = 0x20627;
	public static final int CMD_GW_ACCOUNT_LOGOUT_RSP = 0x20628;

	public static final int CMD_GW_ACCOUNT_LOGIN_SMS_QUERY_REQ = 0x20633;
	public static final int CMD_GW_ACCOUNT_LOGIN_SMS_QUERY_RSP = 0x20634;

	public static final int CMD_GW_ACCOUNT_SMS_LOGIN_REQ = 0x20635;
	public static final int CMD_GW_ACCOUNT_SMS_LOGIN_RSP = 0x20636;

	public static final int CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_REQ = 0x20701;
	public static final int CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_RSP = 0x20702;

	public static final int CMD_ACCOUNT_RELATIONSHIP_DELETE_REQ = 0x20703;
	public static final int CMD_ACCOUNT_RELATIONSHIP_DELETE_RSP = 0x20704;

	public static final int CMD_ACCOUNT_RELATIONSHIP_QUERY_REQ = 0x20705;
	public static final int CMD_ACCOUNT_RELATIONSHIP_QUERY_RSP = 0x20706;

	public static final int CMD_ACCOUNT_RELATIONSHIP_MESSAGE_ADD_ASK_QUERY_REQ = 0x20707;
	public static final int CMD_ACCOUNT_RELATIONSHIP_MESSAGE_ADD_ASK_QUERY_RSP = 0x20708;

	public static final int CMD_ACCOUNT_RELATIONSHIP_2USERS_QUERY_REQ = 0x20709;
	public static final int CMD_ACCOUNT_RELATIONSHIP_2USERS_QUERY_RSP = 0x20710;

	public static final int CMD_ACCOUNT_UID_QUERY_REQ = 0x20711;
	public static final int CMD_ACCOUNT_UID_QUERY_RSP = 0x20712;

	public static final int CMD_GW_ACCOUNT_FRI_VERSION_REQ = 0x20713;
	public static final int CMD_GW_ACCOUNT_FRI_VERSION_RSP = 0x20714;

	public static final int CMD_GW_ACCOUNT_FRI_BASE_INFO_QUERY_REQ = 0x20715;
	public static final int CMD_GW_ACCOUNT_FRI_BASE_INFO_QUERY_RSP = 0x20716;

	public static final int CMD_GW_ACCOUNT_FRI_REMARKS_INFO_QUERY_REQ = 0x20717;
	public static final int CMD_GW_ACCOUNT_FRI_REMARKS_INFO_QUERY_RSP = 0x20718;

	public static final int CMD_GW_ACCOUNT_FRI_REMARKS_DATA_WRITE_REQ = 0x20719;
	public static final int CMD_GW_ACCOUNT_FRI_REMARKS_DATA_WRITE_RSP = 0x20720;

	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ASK_DELETE_REQ = 0x20721;
	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ASK_DELETE_RSP = 0x20722;

	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_QUERY_REQ = 0x20723;
	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_QUERY_RSP = 0x20724;

	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_DELETE_REQ = 0x20725;
	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_DELETE_RSP = 0x20726;

	public static final int CMD_GW_DEV_ACCOUNT_LOGIN_REQ = 0x20727;
	public static final int CMD_GW_DEV_ACCOUNT_LOGIN_RSP = 0x20728;

	public static final int CMD_ACCOUNT_RELATIONSHIP_2USERS_QUERY_EXT_REQ = 0x20729;
	public static final int CMD_ACCOUNT_RELATIONSHIP_2USERS_QUERY_EXT_RSP = 0x20730;

	public static final int CMD_GW_DEV_ACCOUNT_QUERY_REQ = 0x20731;
	public static final int CMD_GW_DEV_ACCOUNT_QUERY_RSP = 0x20732;

	public static final int CMD_GW_DEV_ACCOUNT_MODIFY_REQ = 0x20733;
	public static final int CMD_GW_DEV_ACCOUNT_MODIFY_RSP = 0x20734;

	public static final int CMD_GW_REGISTER_SMS_CHECK_REQ = 0x20735;
	public static final int CMD_GW_REGISTER_SMS_CHECK_RSP = 0x20736;
	// Ȩ�����
	public static final int CMD_ACCOUNT_USR_PERMISSION_QUERY_REQ = 0x20741;
	public static final int CMD_ACCOUNT_USR_PERMISSION_QUERY_RSP = 0x20742;

	public static final int CMD_ACCOUNT_USR_PERMISSION_UPDATE_REQ = 0x20743;
	public static final int CMD_ACCOUNT_USR_PERMISSION_UPDATE_RSP = 0x20744;

	public static final int CMD_ACCOUNT_USR_PERMISSION_DEL_REQ = 0x20745;
	public static final int CMD_ACCOUNT_USR_PERMISSION_DEL_RSP = 0x20746;

	public static final int CMD_ACCOUNT_FRI_PERM_MODIFY_REQ = 0x20747;
	public static final int CMD_ACCOUNT_FRI_PERM_MODIFY_RSP = 0x20748;

	public static final int CMD_ACCOUNT_FRI_PERM_QUERY_REQ = 0x20749;
	public static final int CMD_ACCOUNT_FRI_PERM_QUERY_RSP = 0x20750;

	public static final int CMD_GW_ACCOUNT_APNS_ID_UPDATE_REQ = 0x20751; // apns��������
	public static final int CMD_GW_ACCOUNT_APNS_ID_UPDATE_RSP = 0x20752; // apns������Ӧ

	public static final int CMD_ACCOUNT_MODIFY_PASSWD_REQ = 0x20753; // ͨ���˻������޸�����
	public static final int CMD_ACCOUNT_MODIFY_PASSWD_RSP = 0x20754; // ͨ���˻������޸���Ӧ

	public static final int CMD_GW_FIND_PASSWD_SMS_QUERY_REQ = 0x20755; // �һ�������֤������
	public static final int CMD_GW_FIND_PASSWD_SMS_QUERY_RSP = 0x20756; // �һ�������֤����Ӧ

	public static final int CMD_ACCOUNT_TEL_FIND_PASSWD_REQ = 0x20757; // ͨ���ֻ����һ���������
	public static final int CMD_ACCOUNT_TEL_FIND_PASSWD_RSP = 0x20758;// ͨ���ֻ����һ�������Ӧ

	///////////////////////////////////////////////////
	// Ⱥ�飺�������߼���֮��
	public static final int CMD_ACCOUNT_GROUP_CREATE_REQ = 0x20801;
	public static final int CMD_ACCOUNT_GROUP_CREATE_RSP = 0x20802;

	public static final int CMD_ACCOUNT_GROUP_QUERY_REQ = 0x20803;
	public static final int CMD_ACCOUNT_GROUP_QUERY_RSP = 0x20804;

	public static final int CMD_ACCOUNT_GROUP_UPDATE_REQ = 0x20805;
	public static final int CMD_ACCOUNT_GROUP_UPDATE_RSP = 0x20806;

	public static final int CMD_ACCOUNT_GROUP_DELETE_REQ = 0x20807;
	public static final int CMD_ACCOUNT_GROUP_DELETE_RSP = 0x20808;

	public static final int CMD_ACCOUNT_GROUP_MEMBER_INSERT_REQ = 0x20811;
	public static final int CMD_ACCOUNT_GROUP_MEMBER_INSERT_RSP = 0x20812;

	public static final int CMD_ACCOUNT_GROUP_MEMBER_QUERY_REQ = 0x20813;
	public static final int CMD_ACCOUNT_GROUP_MEMBER_QUERY_RSP = 0x20814;

	public static final int CMD_ACCOUNT_GROUP_MEMBER_DELETE_REQ = 0x20815;
	public static final int CMD_ACCOUNT_GROUP_MEMBER_DELETE_RSP = 0x20816;

	public static final int CMD_ACCOUNT_GROUP_MEMBER_CHECK_REQ = 0x20817;
	public static final int CMD_ACCOUNT_GROUP_MEMBER_CHECK_RSP = 0x20818;

	public static final int CMD_ACCOUNT_GROUP_SET_ADMIN_REQ = 0x20819;
	public static final int CMD_ACCOUNT_GROUP_SET_ADMIN_RSP = 0x20820;;

	///////////////////////////////////////////////////
	// ע�᣺�������߼���֮��
	public static final int CMD_GW_REGISTER_SMS_QUERY_REQ = 0x21001;
	public static final int CMD_GW_REGISTER_SMS_QUERY_RSP = 0x21002;

	public static final int CMD_GW_REGISTER_REG_REQ = 0x21003;
	public static final int CMD_GW_REGISTER_REG_RSP = 0x21004;

	// �ʺţ������ר��
	public static final int CMD_GW_ACCOUNT_ONLINE_STATUS_QUERY_REQ = 0x20629;
	public static final int CMD_GW_ACCOUNT_ONLINE_STATUS_QUERY_RSP = 0x20630;

	public static final int CMD_ACCOUNT_ONLINE_STATUS_UPDATE_REQ = 0x20631;
	public static final int CMD_ACCOUNT_ONLINE_STATUS_UPDATE_RSP = 0x20632;

	public static final int CMD_ACCOUNT_FORCE_LOGOUT_REQ = 0x20637;
	public static final int CMD_ACCOUNT_FORCE_LOGOUT_RSP = 0x20638;

	public static final int CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_REQ = 0x20641;
	public static final int CMD_ACCOUNT_RELATIONSHIP_ADD_ASK_ONLINE_SEND_2_PEER_RSP = 0x20642;

	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_REQ = 0x20643;
	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_RSP = 0x20644;

	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_SEND_2_PEER_REQ = 0x20645;
	public static final int CMD_ACCOUNT_MSG_RELATIONSHIP_ADD_ANSWER_SEND_2_PEER_RSP = 0x20646;

	// �ʺţ��߼���֮��
	public static final int CMD_LOGIC_ACCOUNT_QUERY_REQ = 0x20605;
	public static final int CMD_LOGIC_ACCOUNT_QUERY_RSP = 0x20606;

	public static final int CMD_BILL_RECORD_REQ = 0x22221;
	public static final int CMD_BILL_RECORD_RSP = 0x22222;

	//////////////////////////////////////////////////////////
	// file server
	public static final int CMD_CLIENT_STARTUP_FILE_REQ = 0x23001;
	public static final int CMD_CLIENT_STARTUP_FILE_RSP = 0x23002;
	public static final int CMD_CLIENT_Upload_FILE_REQ = 0x23003;
	public static final int CMD_CLIENT_Upload_FILE_RSP = 0x23004;
	public static final int CMD_CLIENT_FINISHUP_FILE_REQ = 0x23005;
	public static final int CMD_CLIENT_FINISHUP_FILE_RSP = 0x23006;

	public static final int CMD_CLIENT_STARTDOWN_FILE_REQ = 0x23007;
	public static final int CMD_CLIENT_STARTDOWN_FILE_RSP = 0x23008;
	public static final int CMD_CLIENT_DOWNLOAD_FILE_REQ = 0x23009;
	public static final int CMD_CLIENT_DOWNLOAD_FILE_RSP = 0x2300A;
	public static final int CMD_CLIENT_FINISHDOWN_FILE_REQ = 0x2300B;
	public static final int CMD_CLIENT_FINISHDOWN_FILE_RSP = 0x2300C;

	// �ʺţ��߼��������ݲ�֮��
	public static final int CMD_DATA_ACCOUNT_READ_REQ = 0x30001;
	public static final int CMD_DATA_ACCOUNT_READ_RSP = 0x30002;

	public static final int CMD_DATA_ACCOUNT_WRITE_REQ = 0x30003;
	public static final int CMD_DATA_ACCOUNT_WRITE_RSP = 0x30004;

	public static final int CMD_DATA_ACCOUNT_SINGLE_READ_REQ = 0x30005;
	public static final int CMD_DATA_ACCOUNT_SINGLE_READ_RSP = 0x30006;

	public static final int CMD_DATA_ACCOUNT_SINGLE_WRITE_REQ = 0x30007;
	public static final int CMD_DATA_ACCOUNT_SINGLE_WRITE_RSP = 0x30008;

	public static final int CMD_DATA_ACCOUNT_SINGLE_READ_EXPIRE_REQ = 0x30009;
	public static final int CMD_DATA_ACCOUNT_SINGLE_READ_EXPIRE_RSP = 0x30010;

	public static final int CMD_DATA_ACCOUNT_SINGLE_WRITE_EXPIRE_REQ = 0x30011;
	public static final int CMD_DATA_ACCOUNT_SINGLE_WRITE_EXPIRE_RSP = 0x30012;

	public static final int CMD_HIS_REV_DATA_WRITE_REQ = 0x30013;
	public static final int CMD_HIS_REV_DATA_WRITE_RSP = 0x30014;

	public static final int CMD_HIS_REV_DATA_READ_REQ = 0x30015;
	public static final int CMD_HIS_REV_DATA_READ_RSP = 0x30016;

	public static final int CMD_HIS_REV_CLS_DATA_REQ = 0x30017;
	public static final int CMD_HIS_REV_CLS_DATA_RSP = 0x30018;

	public static final int CMD_HIS_SEN_DATA_WRITE_REQ = 0x30019;
	public static final int CMD_HIS_SEN_DATA_WRITE_RSP = 0x30020;

	public static final int CMD_HIS_SEN_DATA_READ_REQ = 0x30021;
	public static final int CMD_HIS_SEN_DATA_READ_RSP = 0x30022;

	public static final int CMD_DATA_FRI_LIST_DATA_CHECK_REQ = 0x30023;
	public static final int CMD_DATA_FRI_LIST_DATA_CHECK_RSP = 0x30024;

	public static final int CMD_DATA_FRI_LIST_DATA_WRITE_REQ = 0x30025;
	public static final int CMD_DATA_FRI_LIST_DATA_WRITE_RSP = 0x30026;

	public static final int CMD_DATA_FRI_LIST_DATA_DEL_REQ = 0x30027;
	public static final int CMD_DATA_FRI_LIST_DATA_DEL_RSP = 0x30028;

	public static final int CMD_DATA_FRI_LIST_DATA_QUERY_REQ = 0x30029;
	public static final int CMD_DATA_FRI_LIST_DATA_QUERY_RSP = 0x30030;

	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ANSWER_INSERT_REQ = 0x30031; // 1Ӧ����Ϣ
																						// INSERT/DEL/QUERY
	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ANSWER_INSERT_RSP = 0x30032;

	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ANSWER_DELETE_REQ = 0x30033;
	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ANSWER_DELETE_RSP = 0x30034;

	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ANSWER_QUERY_REQ = 0x30035;
	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ANSWER_QUERY_RSP = 0x30036;

	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ASK_INSERT_REQ = 0x30042; // 2������Ϣ
	// INSERT/DEL/QUERY
	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ASK_INSERT_RSP = 0x30043;

	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ASK_DELETE_REQ = 0x30044;
	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ASK_DELETE_RSP = 0x30045;

	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ASK_QUERY_REQ = 0x30046;
	public static final int CMD_DATA_MSG_RELATIONSHIP_ADD_ASK_QUERY_RSP = 0x30047;

	public static final int CMD_DATA_FRI_REMARKS_DATA_WRITE_REQ = 0x30048;
	public static final int CMD_DATA_FRI_REMARKS_DATA_WRITE_RSP = 0x30049;

	public static final int CMD_DATA_FRI_REMARKS_DATA_QUERY_REQ = 0x30050;
	public static final int CMD_DATA_FRI_REMARKS_DATA_QUERY_RSP = 0x30051;

	public static final int CMD_DATA_FRI_BASE_VERSION_DATA_WRITE_REQ = 0x30052;
	public static final int CMD_DATA_FRI_BASE_VERSION_DATA_WRITE_RSP = 0x30053;

	public static final int CMD_DATA_FRI_VERSION_DATA_QUERY_REQ = 0x30054;
	public static final int CMD_DATA_FRI_VERSION_DATA_QUERY_RSP = 0x30055;

	public static final int CMD_DATA_FRI_BASEINFO_DATA_QUERY_REQ = 0x30056;
	public static final int CMD_DATA_FRI_BASEINFO_DATA_QUERY_RSP = 0x30057;

	// public static final int CMD_DATA_ACCOUNT_STATUS_WRITE_REQ =0x30058 //
	// �˻�״̬д��
	// public static final int CMD_DATA_ACCOUNT_STATUS_WRITE_RSP =0x30059

	// public static final int CMD_DATA_ACCOUNT_STATUS_READ_REQ =0x30060 //
	// �˻�״̬��ѯ
	// public static final int CMD_DATA_ACCOUNT_STATUS_READ_RSP =0x30061

	// �ļ���������
	public static final int CMD_FILE_COMMON_QUERY_REQ = 0x30101;
	public static final int CMD_FILE_COMMON_QUERY_RSP = 0x30102;
	public static final int CMD_FILE_ICON_QUERY_REQ = 0x30103;

	public static final int CMD_FILE_ICON_QUERY_RSP = 0x30104;

	public static final int CMD_FILE_GET_DATA_REQ = 0x31100;
	public static final int CMD_FILE_GET_DATA_RSP = 0x31101;
	public static final int CMD_FILE_ADD_DATA_REQ = 0x31102;
	public static final int CMD_FILE_ADD_DATA_RSP = 0x31103;
	public static final int CMD_FILE_SET_DATA_REQ = 0x31104;
	public static final int CMD_FILE_SET_DATA_RSP = 0x31105;
	public static final int CMD_FILE_DEL_DATA_REQ = 0x31106;
	public static final int CMD_FILE_DEL_DATA_RSP = 0x31107;

	// ���ѱ�ע
	public static final int CMD_DATA_FRI_INFO_DATA_WRITE_REQ = 0x31108;
	public static final int CMD_DATA_FRI_INFO_DATA_WRITE_RSP = 0x31109;
	public static final int CMD_DATA_FRI_INFO_DATA_SINGLE_READ_REQ = 0x31110;
	public static final int CMD_DATA_FRI_INFO_DATA_SINGLE_READ_RSP = 0x31111;
	public static final int CMD_DATA_FRI_INFO_DATA_READ_REQ = 0x31112;
	public static final int CMD_DATA_FRI_INFO_DATA_READ_RSP = 0x31113;

	// �˻�״̬
	public static final int CMD_DATA_ACCOUNT_STATUS_WRITE_REQ = 0x31115;
	public static final int CMD_DATA_ACCOUNT_STATUS_WRITE_RSP = 0x31114;
	public static final int CMD_DATA_ACCOUNT_STATUS_READ_REQ = 0x31117;
	public static final int CMD_DATA_ACCOUNT_STATUS_READ_RSP = 0x31116;

	// Ⱥ��
	public static final int CMD_DATA_GROUP_WRITE_REQ = 0x31200;
	public static final int CMD_DATA_GROUP_WRITE_RSP = 0x31201;
	public static final int CMD_DATA_GROUP_UPDATE_REQ = 0x31202;
	public static final int CMD_DATA_GROUP_UPDATE_RSP = 0x31203;
	public static final int CMD_DATA_GROUP_DELETE_REQ = 0x31204;
	public static final int CMD_DATA_GROUP_DELETE_RSP = 0x31205;
	public static final int CMD_DATA_GROUP_QUERY_REQ = 0x31206;
	public static final int CMD_DATA_GROUP_QUERY_RSP = 0x31207;
	public static final int CMD_DATA_GROUP_USER_WRITE_REQ = 0x31208;
	public static final int CMD_DATA_GROUP_USER_WRITE_RSP = 0x31209;
	public static final int CMD_DATA_GROUP_USER_DELETE_REQ = 0x31210;
	public static final int CMD_DATA_GROUP_USER_DELETE_RSP = 0x31211;
	public static final int CMD_DATA_GROUP_USER_ADMIN_REQ = 0x31212;
	public static final int CMD_DATA_GROUP_USER_ADMIN_RSP = 0x31213;
	public static final int CMD_DATA_GROUP_USER_QUERY_REQ = 0x31214;
	public static final int CMD_DATA_GROUP_USER_QUERY_RSP = 0x31215;
	public static final int CMD_DATA_GROUP_USER_CHECK_REQ = 0x31216;
	public static final int CMD_DATA_GROUP_USER_CHECK_RSP = 0x31217;
	public static final int CMD_DATA_GROUP_USER_CREATE_NUM_REQ = 0x31219;
	public static final int CMD_DATA_GROUP_USER_CREATE_NUM_RSP = 0x31218;

	// Ȩ����Ϣ
	// public static final int CMD_DATA_MSG_PERMISSION_QUERY_REQ = 0x31303;
	// public static final int CMD_DATA_MSG_PERMISSION_QUERY_RSP = 0x31302;
	// public static final int CMD_DATA_MSG_PERMISSION_UPDATE_REQ = 0x31305;
	// public static final int CMD_DATA_MSG_PERMISSION_UPDATE_RSP = 0x31304;
	// public static final int CMD_DATA_MSG_PERMISSION_DEL_REQ = 0x31307;
	// public static final int CMD_DATA_MSG_PERMISSION_DEL_RSP = 0x31306;

	// �ƶ˱��ر���
	public static final int CMD_DATA_MSG_PERMISSION_QUERY_REQ = 0x31303;
	public static final int CMD_DATA_MSG_PERMISSION_QUERY_RSP = 0x31302;
	public static final int CMD_DATA_MSG_PERMISSION_UPDATE_REQ = 0x31305;
	public static final int CMD_DATA_MSG_PERMISSION_UPDATE_RSP = 0x31304;
	public static final int CMD_DATA_MSG_PERMISSION_DEL_REQ = 0x31307;
	public static final int CMD_DATA_MSG_PERMISSION_DEL_RSP = 0x31306;

	public static final int CMD_DATA_FRI_PERM_WRITE_REQ = 0x31309;
	public static final int CMD_DATA_FRI_PERM_WRITE_RSP = 0x31308;
	public static final int CMD_DATA_FRI_PERM_QUERY_REQ = 0x31311;
	public static final int CMD_DATA_FRI_PERM_QUERY_RSP = 0x31310;

	// ��·��
	// public static final int CMD_DATA_FRI_PERM_WRITE_REQ = 0x31309;
	// public static final int CMD_DATA_FRI_PERM_WRITE_RSP = 0x31308;
	// public static final int CMD_DATA_FRI_PERM_QUERY_REQ = 0x31311;
	// public static final int CMD_DATA_FRI_PERM_QUERY_RSP = 0x31310;

	public static final int CMD_STORAGE_DATA_INSERT_REQ = 0x31029;
	public static final int CMD_STORAGE_DATA_UPDATE_REQ = 0x31030;

	public static final int CMD_STORAGE_DATA_INSERT_RSP = 0x31031;
	public static final int CMD_STORAGE_DATA_UPDATE_RSP = 0x31032;

	public static final int CMD_UP_FILE_REQ = 0x2300D; // client����file�ϴ�
	public static final int CMD_UP_FILE_RSP = 0x2300E; // fileӦ��client�ϴ�
	public static final int CMD_FINISH_UP_FILE_REQ = 0x2300F;// client����file����ϴ�
	public static final int CMD_FINISH_UP_FILE_RSP = 0x23010;// fileӦ��client����ϴ�

	public static final int CMD_DOWN_FILE_REQ = 0x23011;// client����file����
	public static final int CMD_DOWN_FILE_RSP = 0x23012;// fileӦ��client����

	public static final int CMD_FINISH_DOWN_FILE_REQ = 0x23013; // client�������file����
	public static final int CMD_FINISH_DOWN_FILE_RSP = 0x23014;// Ӧ��client�������

	///////////////////////////////////////////////////
	// �ʺ� ����
	///////////////////////////////////////////////////

}
