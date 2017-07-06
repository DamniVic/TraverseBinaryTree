package com.damnivic.alidayu;

import java.util.HashMap;
import java.util.Map;

import com.aliyuncs.exceptions.ClientException;

public class Test {
	public static void main(String[] args) {
		String[] numbers=new String[]{"13260591003","18571352048"};//需要发送的电话号码集合
		String signName="武汉化神科技有限公司";  //在阿里大于添加的短信签名名称
		String templateCode="SMS_74265181";  //在阿里大于添加的短信模板的模板CODE
		Map<String,String> templateParam=new HashMap<String,String>();  //短信模板里面对应的变量键值对
		templateParam.put("customer", "DamniVic");
		SmsBean bean=new SmsBean(numbers,signName,templateCode,templateParam);
		try {
			SmsTask.sendSms(bean);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
