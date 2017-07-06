package com.damnivic.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
	public static void main(String[] args) throws IOException {
		File input=new File("C:\\Users\\DAMNICOMNIPLUSVIC\\workspacej2ee\\BinaryTree\\src\\com\\damnivic\\common\\first");
		File output=new File("C:\\Users\\DAMNICOMNIPLUSVIC\\workspacej2ee\\BinaryTree\\src\\com\\damnivic\\common\\secret");
		@SuppressWarnings("resource")
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(input)));
		FileWriter  fw = new FileWriter(output);
        @SuppressWarnings("resource")
		BufferedWriter  writer = new BufferedWriter(fw);
		String key=null;
		String value=null;
		String str=null;
		while ((str = reader.readLine()) != null) {
			if(key==null){
				key=str;
			}else if(value==null){
				value=str;
			}else if("".equals(str.trim())){
				writer.write("{\"key\":\""+key+"\",\"value\":\""+value+"\"}");
                writer.newLine();// enter
				key=null;
				value=null;
			}
		}
	}
	
	
	/**
	 * 读取文件为字符串
	 * @param file
	 * @return
	 */
	public static String readFile(File file){
		StringBuffer sb=new StringBuffer();
		FileInputStream fileInputStream=null;
		try {
			fileInputStream=new FileInputStream(file);
			int len=0;
			byte[] data=new byte[1024];
			while((len=fileInputStream.read(data))!=-1){
				if(len==data.length){
					sb.append(new String(data,"utf-8"));
				}else{
					byte[] temp=new byte[len];
					System.arraycopy(data,0,temp,0,len);
					sb.append(new String(temp,"utf-8"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString().replaceAll("\n","").replaceAll("\r","").replaceAll("\t","");
	}

}
