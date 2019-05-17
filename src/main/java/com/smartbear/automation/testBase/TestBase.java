package com.smartbear.automation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;

	@Before
	public WebDriver launchBrowser() {
		try {
			loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Config config = new Config(OR);
		getBrowser(config.getBrowser());
		return driver;
	}

	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Window")) {
			System.out.println(System.getProperty("os.name"));
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
	}
	
	public void loadProperties() throws IOException {
		OR = new Properties();
		f1 = new File(
				System.getProperty("user.dir") + "/src/main/java/com/smartbear/automation/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);

		f1 = new File(System.getProperty("user.dir") + "/src/main/java/com/smartbear/automation/config/or.properties");
		file = new FileInputStream(f1);
		OR.load(file);
	}

}
