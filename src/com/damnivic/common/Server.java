package com.damnivic.common;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.damnivic.utlity.Config;

public class Server {
	
	public final static List<ConnObject> objectList = new ArrayList<ConnObject>();
	public final static Map<String,ConnObject> objectMap=new HashMap<String,ConnObject>();
	
	public void startWork() throws IOException {
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				ServerSocket serverSocket=null;
				try {
					serverSocket = new ServerSocket(Config.ROBOT_COMMUNICATION_PORT);
					System.out.println(" the server launch success , waiting for connecting ");
					Socket socket = null;
					while (true) {
						socket = serverSocket.accept();
//						Recevier recevier=new Recevier(socket,"");
//						Thread t1=new Thread(new Runnable() {
//							@Override
//							public void run() {
//								recevier.receive();
//							}
//						});
//						t1.start();
						System.out.println("--------------------------------------------------------");
						System.out.println(" recive connect application from "+socket.getInetAddress().getHostAddress());
						ConnObject connObject=null;
						try {
							connObject=new ConnObject(socket);
							objectList.add(connObject);
							objectMap.put(connObject.getId(),connObject);
							System.out.println("the current num of connect "+objectList.size());
						} catch (Exception e) {
							System.out.println("ERROR: can't connect ");
						}
						System.out.println("--------------------------------------------------------");
					}
				} catch (Exception e) {
//					try {
//						serverSocket.close();
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}
//					e.printStackTrace();
				}
			}
		});
		thread.start();
	}

	public static void destory(String id){
		objectMap.get(id).destory();
		objectMap.remove(id);
		System.out.println("the current connect "+objectList.size());
	}
	
	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("begin execet the main method");
		Server chatServer = new Server();
		chatServer.startWork();
		while(true){
			if(objectList.size()==0){
				Thread.sleep(500);
				continue;
			}
			System.out.println("please input the message ");
			@SuppressWarnings("resource")
			Scanner scanner=new Scanner(System.in);
			String meString=scanner.nextLine();
			Collections.sort(objectList); 
			for(int i=0;i<objectList.size();i++){
				objectList.get(i).getSender().addMessage(meString);
			}
		}
	}
}
