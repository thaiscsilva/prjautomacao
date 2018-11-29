package com.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {

	public static Properties prop;
	public static boolean loaded = false;

	public static void loadConfiguration() {
		loadLocalProperties();
		loadCommandLineParameters();

		loaded = true;
	}

	public static void loadLocalProperties() {
		try {
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(".//config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadCommandLineParameters() {
		String[] parameters = new String[] { "browser", "environment" };

		for (String key : parameters) {
			setCommandLineParameters(key);
		}
	}

	public static void setCommandLineParameters(String key) {
		String value;

		if (System.getProperties().containsKey("automation." + key)) {
			value = System.getProperty("automation." + key);

			if (prop.containsKey(key)) {
				prop.replace(key, value);
			} else {

			}
		}
	}

	public static String getProperty(String key) {
		if (!loaded) {
			loadConfiguration();
		}

		if (prop.containsKey(key)) {
			return prop.getProperty(key);
		}

		throw new RuntimeException("Property not found, please, check the property name in the confi.properties file!");

	}

}