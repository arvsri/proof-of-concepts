package com.anucana.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.thoughtworks.xstream.XStream;

public class WebsiteToolboxSSOService {

	public static void main(String[] args) {
		WebsiteToolboxSSOService service = new WebsiteToolboxSSOService();
		try {
			XStream xstream = new XStream();
			xstream.alias("response", Response.class);
			
			//Response response = (Response)xstream.fromXML(service.readHTML(new URL("http://disqus.websitetoolbox.com/register/setauthtoken?apikey=XXXXXXX&user=disqus")));
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(service.readHTML(new URL(
					"http://disqus.websitetoolbox.com/register/create_account?apikey=XXXXXXX"
					+ "&member=" + service.getEscapedString("ArvindSrivastava")
					+ "&pw=" + "Blah"
					+ "&email=" + "blah@gmail.com"
					+ "&name=" + service.getEscapedString("ArvindSrivastava")))));
			
			String line;
			StringBuilder builder = new StringBuilder();
	        while ((line = reader.readLine()) != null){
	        	builder.append(line);
	        }
			
			System.out.println(builder);
	        
			DataResponse dataResponse = (DataResponse) xstream.fromXML(builder.toString());
			System.out.println("Registration Error : " + dataResponse.getError());
			System.out.println("Registration Message : " + dataResponse.getMessage());
			System.out.println("Registration User Id : "+ dataResponse.getUserid());
			
			
//			System.out.println("--------------- Auth Token ---------------");
//			System.out.println(response.getAuthtoken());
//			
//			System.out.println("---------------- Error Message --------------");
//			System.out.println(response.getErrormessage());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private InputStream readHTML(URL url) throws IOException{
		URLConnection yc = url.openConnection();
		yc.setConnectTimeout(10000);
		return yc.getInputStream();
	}

	private String getEscapedString(String str) throws UnsupportedEncodingException{
		String esacpedURL = URLEncoder.encode(str, "utf-8").replaceAll("\\+", "%20"); 
		System.out.println(esacpedURL);
		return esacpedURL;
	}
	
}
