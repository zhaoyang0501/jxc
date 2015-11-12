package com.jxc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class HttpClientUtil {

	public static String doGet(String url) throws Exception {  
        DefaultHttpClient client = new DefaultHttpClient(); 
        List<NameValuePair> list = new ArrayList<NameValuePair>(); 
        NameValuePair pair1 = new BasicNameValuePair("name", ""); 
        list.add(pair1); 
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8"); 
        HttpPost post = new HttpPost(Constant.BASE_URL+url); 
        post.setEntity(entity); 
        HttpResponse response = client.execute(post);
        String str="";
        if(response.getStatusLine().getStatusCode()==200){ 
            InputStream in = response.getEntity().getContent();//接收服务器的数据，并在Toast上显示 
            str = readString(in); 
            Log.i("fuck-->", str);
        }
		return str; 
    } 
	
	 protected static String readString(InputStream in) throws Exception { 
	        byte[]data = new byte[1024]; 
	        int length = 0; 
	        ByteArrayOutputStream bout = new ByteArrayOutputStream(); 
	        while((length=in.read(data))!=-1){ 
	            bout.write(data,0,length); 
	        } 
	        return new String(bout.toByteArray(),"UTF-8"); 
	    } 
 }
