package com.damnivic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
	public static void main(String[] args) {
		String serverName = "192.168.1.88";
	      int port = 9527;
	      try
	      {
	         System.out.println("Connecting to " + serverName
	                             + " on port " + port);
	         Socket client = new Socket(serverName, port);
	         System.out.println("Just connected to "
	                      + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out =
	                       new DataOutputStream(outToServer);
	         while(true){
	         out.writeUTF("Hello from "
	                      + client.getLocalSocketAddress());
	         Thread.sleep(1000);
	         }
	      }
	      catch(IOException e)
	      {
	         e.printStackTrace();
	      } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
