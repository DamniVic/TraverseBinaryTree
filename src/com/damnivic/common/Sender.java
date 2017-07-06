package com.damnivic.common;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import com.damnivic.utlity.Config;

public class Sender {
	private boolean status = true;
	private List<String> messages=new ArrayList<String>();
	private Socket socket;

	public Sender(){}
	
	public Sender(String  ip) throws UnknownHostException,IOException{
		System.out.println("try to connect the server");
		try {
			this.socket=new Socket(ip,Config.ROBOT_COMMUNICATION_PORT);
		} catch (Exception e) {
			System.out.println("ERROR:can't connect to "+ip+":"+Config.ROBOT_COMMUNICATION_PORT);
			throw e;
		}
	}
	
	public void send(){
		while(status){
			if(messages.size()==0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			String message=messages.get(0);
			messages.remove(0);
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(socket.getOutputStream());
				writer.println(message+"\r\n");
				writer.flush();
				System.out.println("to "+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+" send "+message);
			} catch (Exception e) {
				e.printStackTrace();
				writer.close();
			}
		}
	}
	
	public void send(String message){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			writer.println(message);
			writer.flush();
			System.out.println("to "+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+" send "+message);
		} catch (Exception e) {
			e.printStackTrace();
			writer.close();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void addMessage(String message) {
		messages.add(message);
	}
	
	public void destory() {
		status=false;
		try {
			if(!socket.isClosed()){
				socket.close();
			}
			messages.clear();
			messages=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
