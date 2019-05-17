package com.smartbear.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smartbear.automation.helper.WaitHelper;

public class LoginPage {

	public WebDriver driver;
	// public static Properties OR;
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[contains(@id, 'username')]")
	public WebElement username;

	@FindBy(xpath = "//*[contains(@id, 'password')]")
	public WebElement password;

	@FindBy(xpath = "//*[contains(@id, 'login_button')]")
	public WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void enterUsername() {
		waitHelper.waitForElement(driver, 10, username);
		username.sendKeys("Tester");
	}

	public void enterPassword() {
		waitHelper.waitForElement(driver, 10, password);
		password.sendKeys("test");
	}

	public void clickLoginButton() {
		waitHelper.waitForElement(driver, 10, password);
		loginButton.click();
	}
}
