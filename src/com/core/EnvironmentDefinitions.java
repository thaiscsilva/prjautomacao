package com.core;

public class EnvironmentDefinitions {
	
	public static String URL = "TO BE DEFINED";
	
	public static void defineEnvironment() {
		String environment = Settings.getProperty("environment");
		
		switch (environment.toUpperCase().trim()) {
		case "TEST":
			setTestEnvironmentDefinition();
			break;

		default:
			//TO BE DONE
			break;
		}
	}

	private static void setTestEnvironmentDefinition() {
		URL = "https://automation-sandbox.herokuapp.com/";
	}

}
