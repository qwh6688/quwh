package com.citydo.quwh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetUrlPostResult {
    public static String requestPostResult(String url,String param){
        String resultStr="";
        BufferedReader in = null;
        try {
            URL urlObject=new URL(url);
            URLConnection urlConnection = urlObject.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            // 发送请求参数
            printWriter.print(param);
            // flush输出流的缓冲
            printWriter.flush();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                resultStr += line;
            }
        } catch (MalformedURLException e) {
            System.out.println("创建urlObject错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("打开链接错误！");
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("关闭流时发生错误！");
                e.printStackTrace();
            }
        }
        return resultStr;
    }


}
