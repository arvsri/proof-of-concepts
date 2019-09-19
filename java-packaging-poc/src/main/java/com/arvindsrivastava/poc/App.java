package com.arvindsrivastava.poc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;

public class App {

	private static Properties properties = null;
	
	public App() {
		if (properties == null) {
			properties = new Properties();
			try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
				properties.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
	
	
    public String sha256hex(String input) {
    	if(Boolean.valueOf(properties.getProperty("sha2hex.enabled", "false"))) {
            return DigestUtils.sha256Hex(input);
    	}else {
    		System.out.println("SHA to hex disabled !!");
    		return null;
    	}
    }

}