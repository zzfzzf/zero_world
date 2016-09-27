package com.zzy.service.gate;

import com.alibaba.dubbo.common.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月19日 
* @decript:
*/
public class Test extends A {
	public static void main(String[] args) throws IOException {
		new Test().init();
	}
	public void init() throws IOException{
        JSONObject json=new JSONObject();
        Object[][] objs = new Object[2][2] ;
        objs[0][0] = 0;
        objs[0][1] = 1;
        json.put("arr",objs);
        System.out.println(json.getArray("arr"));
	}
	public void K(String test){
		test+="c";
	}

}
class A{
	public void getMessage(String connectUrl) throws Exception{
		URL url = new URL(connectUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type","application/json");
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
        	System.out.println("循环次数");
            lines = new String(lines.getBytes(), "utf-8");
            sb.append(lines);
        }
        System.out.println(sb);
	}
}
