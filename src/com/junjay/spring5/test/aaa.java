package com.junjay.spring5.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class aaa {
	 public static String HTTP_POST(String URL, String Data) throws Exception { 
	        BufferedReader In = null;
	        PrintWriter Out = null;   
	        HttpURLConnection HttpConn = null;
	        try {
		        URL url=new URL(URL);
		        HttpConn=(HttpURLConnection)url.openConnection();
		        HttpConn.setRequestMethod("POST");
		        HttpConn.setDoInput(true);
		        HttpConn.setDoOutput(true);
		     
		        Out=new PrintWriter(HttpConn.getOutputStream());
		        Out.println(Data);
		        Out.flush();
		        
		        if(HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK){
			        StringBuffer content = new StringBuffer();
			        String tempStr = "";
			        In = new BufferedReader(new InputStreamReader(HttpConn.getInputStream()));
			        while((tempStr = In.readLine()) != null){
			        	content.append(tempStr);
			        }
			        In.close();
			        return content.toString();
		        }
		        else
		        {
		        	throw new Exception("HTTP_POST_ERROR_RETURN_STATUS��" + HttpConn.getResponseCode());
		        }
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }finally{
		        Out.close();
		        HttpConn.disconnect();
	        }
	        return null;
	}
	           
	 public static void main(String[] args) throws Exception{
			String HTTP_BACK_MESSAGE = "";
			HTTP_BACK_MESSAGE = HTTP_POST("https://service.winic.org/sys_port/gateway/index.asp", "id=JunJay&pwd=niuJunJay&to=17600211647&content=" + URLEncoder.encode("���ã�������֤����2��������ͨ�š�", "gb2312") + "&time=");
			System.out.println(HTTP_BACK_MESSAGE); 
		}

	    
	
}
