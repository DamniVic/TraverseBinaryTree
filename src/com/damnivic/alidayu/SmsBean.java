package com.damnivic.alidayu;

import java.util.HashMap;
import java.util.Map;

public class SmsBean {
	private String[] phonenumbers;
	private String SignName;
	private String TemplateCode;
	private Map<String,String> TemplateParams;
	public SmsBean(String[] phonenumbers, String signName, String templateCode, Map<String, String> templateParams) {
		super();
		this.phonenumbers = phonenumbers;
		SignName = signName;
		TemplateCode = templateCode;
		TemplateParams = templateParams;
	}
	public String[] getPhonenumbers() {
		return phonenumbers;
	}
	public void setPhonenumbers(String[] phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	public String getSignName() {
		return SignName;
	}
	public void setSignName(String signName) {
		SignName = signName;
	}
	public String getTemplateCode() {
		return TemplateCode;
	}
	public void setTemplateCode(String templateCode) {
		TemplateCode = templateCode;
	}
	public Map<String, String> getTemplateParams() {
		return TemplateParams;
	}
	public void setTemplateParams(HashMap<String, String> templateParams) {
		TemplateParams = templateParams;
	}
	
}
