package com.config;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseConfig {
	
	public static String getconfig(String key) throws Throwable {
		
		
		Properties pro = new Properties();// how to read config /note pad or text file?
		
		//config file location
		String path ="./config.properties";
		FileInputStream fis = new FileInputStream(path);
		
		//connection of both
		pro.load(fis);
		
		System.out.println(pro.get(key));
		
	}
	public static void main(String[] args) throws Throwable {
		BaseConfig.getconfig("pass");
	}

}