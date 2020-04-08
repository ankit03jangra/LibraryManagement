package com.jangra.library.librarybookservice.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class CommonUtil {
	
	private static Properties props = new Properties();
	
	public static void configurelog() {
		try {
			System.out.println("Inside the log config method");
			File properties = new File("log4j.properties");
			if(properties.exists()) {
				props.load(new FileInputStream(properties));
				PropertyConfigurator.configure(props);
			}
			else
				System.out.println("File not found : "+properties.getAbsolutePath());
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
