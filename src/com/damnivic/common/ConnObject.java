package com.damnivic.common;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

public class ConnObject implements Comparable<ConnObject>{
	private String id;
	private int processes;
	private String ip;
	private Recevier recevier;
	private Sender sender;
	
	
	public ConnObject() {
		
	}
	
	public ConnObject(Socket socket) throws UnknownHostException, IOException {
		this.id=UUID.randomUUID().toString();
		this.recevier=new Recevier(socket,id);
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				recevier.receive();
			}
		});
		this.ip=socket.getInetAddress().getHostAddress();
		this.sender=new Sender(this.ip);
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				sender.send();
			}
		});
		this.processes=0;
		t1.start();
		t2.start();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProcesses() {
		return processes;
	}
	public void setProcesses(int processes) {
		this.processes = processes;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Recevier getRecevier() {
		return recevier;
	}
	public void setRecevier(Recevier recevier) {
		this.recevier = recevier;
	}
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	public void destory(){
		if(recevier!=null){
			recevier.destory();
		}
		if(sender!=null){
			sender.destory();
		}
		System.out.println("disconnect:"+ip);
		Server.objectList.remove(this);
	}

	@Override
	public int compareTo(ConnObject o) {
		return this.processes<=o.processes?1:0;
	}
}
