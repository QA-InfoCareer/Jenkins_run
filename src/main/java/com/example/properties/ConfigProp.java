package com.example.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProp {

	private Properties properties = new Properties();

	public void initiatizeConfigProperties() throws FileNotFoundException {

		FileInputStream stream = new FileInputStream("config.properties");

		try {

			properties.load(stream);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getProperty(String key) {

		return properties.getProperty(key);
	}

	
	
}
