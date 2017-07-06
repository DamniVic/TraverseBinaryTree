package com.damnivic.utlity;

public class Config {
	/** 鏈哄櫒浜烘湇鍔″櫒鍦板潃 */
	public static final String ROBOT_COMMUNICATION_IP="192.168.1.88";
	/** 鏈哄櫒浜烘湇鍔″櫒绔彛鍙� */
	public static final int ROBOT_COMMUNICATION_PORT=9527;
	
	public static final String BINDING_ROBOT="binding";
	/** 鍚姩鏈哄櫒浜� */
	public static final String OPEN_ROBOT="open";
	/** 鍏抽棴鏈哄櫒浜� */
	public static final String CLOSE_ROBOT="close";
	/** 閲嶅惎鏈哄櫒浜� */
	public static final String REBOOT_ROBOT="reboot";
	
	public static final int BINDING=1;
	
	public static final int OPEN=2;
	
	public static final int CLOSE=3;
	
	public static final int CODE_SEND=5;
	
	public static final int RECEIVE_WECHAT_INFO=6;
	
	public static final int OTHER=9;
	
	public static final int UNBOUNDED=0;
	
	public static final int ISBINDING=1;
	
	public static final int INVALID=-1;
}
