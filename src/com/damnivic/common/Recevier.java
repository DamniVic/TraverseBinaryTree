package com.damnivic.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.damnivic.Json;
import net.sf.json.JSONObject;

public class Recevier {
	private String id;
	private boolean status = true;
	private Socket socket;
	private JSONObject message;
	public static final Map<Integer,Json> resultMap=new HashMap<Integer,Json>();
	
	public Recevier(){}
	
	public Recevier(Socket socket,String id) {
		System.out.println("listen"+socket.getInetAddress().getHostAddress()+"port:"+socket.getPort());
		this.socket=socket;
		this.id=id;
	}

	public void receive(){
		BufferedReader reader = null;
		try {
			if(!socket.isClosed()){
				while (status) {
					reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String msg = reader.readLine();
					System.out.println(msg);
					if(msg==null||"null".equals(msg)||"".equals(msg)){
						continue;
					}
					try {	
						Json json=objectToJson(JSONObject.fromObject(msg));
						resultMap.put(json.getId(),json);
					} catch (Exception e) {
						System.out.println("parse failure "+msg);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("client "+socket.getInetAddress().getHostAddress()+" exception"+e.getMessage());
			Server.destory(id);
		}
	}
	
	
	
	public Json getMessage(Integer id) {
		Json json=new Json();
		try {
			if(resultMap.get(id)==null){
				boolean flag=true;
				for(int i=0;i<10;i++){
					Thread.sleep(2000);
					if(resultMap.get(id)!=null){
						json=resultMap.get(id);
						resultMap.remove(id);
						flag=false;
						break;
					}
				}
				if(flag){
					json=initJSONObject();
				}
			}else{
				json=resultMap.get(id);
				resultMap.remove(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			json=initJSONObject();
		}
		System.out.println();
		return json;
	}

	
	public JSONObject getMessage() {
		return message;
	}

	public void setMessage(JSONObject message) {
		this.message = message;
	}

	public Json objectToJson(JSONObject jsonObject){
		Json json=new Json();
		json.setId(jsonObject.getInt("id"));
		json.setCode(jsonObject.getInt("code"));
		json.setMessage(jsonObject.getString("message"));
		json.setTime(jsonObject.getString("time"));
		json.setData(jsonObject.getString("data"));
		return json;
	}
	
	public Json initJSONObject(){
		Json json=new Json();
		json.setCode(0);
		json.setMessage("the robot is broken ");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		json.setTime(format.format(new Date()));
		return json;
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void destory() {
		status=false;
		try {
			if(!socket.isClosed()){
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
