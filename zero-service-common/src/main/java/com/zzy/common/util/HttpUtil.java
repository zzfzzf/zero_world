/**
 * @author zeus
 * @date 2016年7月24日
 * @version 1.0
 * @describe:用一句话描述该类是干嘛的
 */
package com.zzy.common.util;

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

    private OutputStream getOutStream(HttpURLConnection connection){
        try{
            return connection.getOutputStream();
        }catch (Exception e){
            log.error("获取输出流失败");return null;
        }
    }

    private InputStream getInputStream(HttpURLConnection connection){
        try{
            return connection.getInputStream();
        }catch (Exception e){
            log.error("获取输入流失败");return null;
        }
    }
    /**
     * 初始化connect设置
     */
    private static HttpURLConnection initConnection(String method, String url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
        } catch (Exception e) {
            log.error(method + "连接异常----" + e.getMessage());
        }


        return connection;
    }

    public static JSONObject postJson(String hurl, JSONObject json) throws Exception {
        HttpURLConnection connection = initConnection("POST", hurl);
        sent(json, connection.getOutputStream());
        return JSONObject.parseObject(receive(connection.getInputStream()));
    }

    public static JSONObject getJson(String hurl) throws Exception {
        return JSONObject.parseObject(receive(initConnection("GET", hurl).getInputStream()));
    }

    /**
     * get请求获取json数据,带json
     * @param hurl
     * @return
     */
    public static JSONObject getJson(String hurl, JSONObject json) throws Exception{
        json.putAll(JSONObject.parseObject(receive(initConnection("GET", hurl).getInputStream())));
        return json;
    }


    public static JSONObject putJson(String hurl, JSONObject json) throws Exception{
        HttpURLConnection connection = initConnection("PUT", hurl);
        sent(json, connection.getOutputStream());
        return JSONObject.parseObject(receive(connection.getInputStream()));
    }


    public static JSONObject deleteJson(String hurl) throws Exception{
        return JSONObject.parseObject(receive(initConnection("DELETE", hurl).getInputStream()));
    }

    private static void sent(JSONObject json, OutputStream os) {
        try{
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
            dos.writeUTF(json == null ? "" : json.toString());
            dos.flush();
            dos.close();
        }catch (Exception e){
            log.error("Http请求消息发送错误------"+e.getMessage());
        }

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

    public static Object getDataToJson(String url) throws Exception{
        return getJson(url);
    }
}
