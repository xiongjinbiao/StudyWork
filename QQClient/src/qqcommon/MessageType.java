package qqcommon;

public interface MessageType {

	String MESSAGE_LOGIN_SUCCEED = "1"; //登录成功
	String MESSAGE_LOGIN_FAIL = "2"; //登录失败
	String MESSAGE_COMM_MES = "3"; //发送私聊消息
	String MESSAGE_GET_ONLINE_FRIEND = "4"; //要求返回在线用户列表
	String MESSAGE_RET_ONLINE_FRIEND = "5"; //返回在线用户列表
	String MESSAGE_CLIENT_EXIT = "6"; //退出
	String MESSAGE_SEND_TO_ALL = "7"; //群发消息
	String MESSAGE_SEND_FILE = "8"; //发送文件

}
