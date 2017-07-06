package com.damnivic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Json {
	private Integer id;
	private int code;
	private String message;
	private String time;
	private Object data;
	
	public Json() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.code=0;
		this.time=dateFormat.format(new Date());
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Json [id=" + id + ", code=" + code + ", message=" + message + ", time=" + time + ", data=" + data + "]";
	}
}
