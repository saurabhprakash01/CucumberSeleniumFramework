package com.smartbear.automation.testBase;

import java.util.Properties;

public class Config extends TestBase{

	private Properties OR;
	
	public Config(Properties OR){
		this.OR = OR;
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}
	
	public String getBrowser() {
		return OR.getProperty("Browser");
	}	
	
	public String getWebsite() {
		return OR.getProperty("Website");
	}
}
