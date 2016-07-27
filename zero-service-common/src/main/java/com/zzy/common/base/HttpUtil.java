/**
* @author zeus
* @date 2016年7月24日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
package com.zzy.common.base;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
	private static Logger log = Logger.getLogger(HttpUtil.class);

	public static JSONObject postJson(String hurl,JSONObject json) {
		String result = null;
		try {
			URL url = new URL(hurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			initConnection(connection, "POST");
			connection.connect();
			sent(json,connection.getOutputStream());
			result = receive(connection.getInputStream());
		} catch (Exception e) {
			log.error("POST连接异常----" + e.getMessage());
		}
		return JSONObject.parseObject(result);
	}
	
	public static JSONObject getJson(String hurl) {
		String result = null;
		try {
			URL url = new URL(hurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			initConnection(connection, "GET");
			connection.connect();
			result = receive(connection.getInputStream());
		} catch (Exception e) {
			log.error("GET连接异常----" + e.getMessage());
		}
		return JSONObject.parseObject(result);
	}
	
	public static JSONObject putJson(String hurl,JSONObject json) {
		String result = null;  
		try {
			URL url = new URL(hurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			initConnection(connection, "PUT");
			connection.connect();
			sent(json,connection.getOutputStream());
			result = receive(connection.getInputStream());
		} catch (Exception e) {
			log.error("PUT连接异常----" + e.getMessage());
		}
		return JSONObject.parseObject(result);
	}
	
	public static JSONObject deleteJson(String hurl) {
		String result = null;
		try {
			URL url = new URL(hurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			initConnection(connection, "DELETE");
			connection.connect();
			result = receive(connection.getInputStream());
		} catch (Exception e) {
			log.error("DELETE连接异常----" + e.getMessage());
		}
		return JSONObject.parseObject(result);
	}
	/**
	 * 初始化connect设置
	 */
	private static void initConnection(HttpURLConnection connection, String method) throws Exception {
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod(method);
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type", "application/json");
	}
	
	private static void sent(JSONObject json,OutputStream os) throws Exception{
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
		dos.writeBytes(json==null?"":json.toString());
		dos.writeUTF(json==null?"":json.toString());
		dos.flush();
		dos.close();
	}
	/**
	 * 处理返回结果
	 */
	private static String receive(InputStream is) throws Exception {
		StringBuffer sb = new StringBuffer("");
		String lines;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), "utf-8");
			sb.append(lines);
		}
		reader.close();
		return sb == null ? "" : sb.toString();
	}
}
