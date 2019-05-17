package com.smartbear.automation.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	private WebDriver driver;
	public WebDriverWait wait;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebDriver driver, long time, WebElement element) {
		wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
