package com.smartbear.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smartbear.automation.helper.WaitHelper;
import com.smartbear.automation.testBase.TestBase;

public class WebOrdersPage {

	TestBase tb = new TestBase();
	WebDriver driver;
	// public static Properties OR;
	WaitHelper waitHelper = new WaitHelper(driver);

	@FindBy(xpath = "//h1[text()='Web Orders']")
	private WebElement headerWebOrders;

	@FindBy(xpath = "//*[@class='cornerLeft']/following-sibling::h2")
	private WebElement listOfAllOreders;

	@FindBy(xpath = "//a[contains(@href,'Default')]")
	private WebElement viewAllOrders;

	@FindBy(xpath = "//*[text()='Robert']")
	private WebElement customerName;
	
	@FindBy(xpath = "//*[text()='Paul Brown']")
	private WebElement oldCustomer;
	
	@FindBy(xpath = "//*[@class='SampleTable']/tbody/tr[2]/td[1]/input")
	private WebElement currentProcessedOrder;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement deleteButton;

	public WebOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getWebOrdersHeader() {
		waitHelper.waitForElement(driver, 10, headerWebOrders);
		return headerWebOrders.getText();
	}

	public String getListOfAllOreders() {
		waitHelper.waitForElement(driver, 10, listOfAllOreders);
		return listOfAllOreders.getText();
	}

	public void clickViewAllOrders() {
		waitHelper.waitForElement(driver, 10, viewAllOrders);
		viewAllOrders.click();
	}

	public String getCustomerName() {
		return customerName.getText();
	}
	
	public String getOldCustomerName() {
		return oldCustomer.getText();
	}	
	
	public void clickCurrentProcessedOrder() {
		waitHelper.waitForElement(driver, 10, currentProcessedOrder);
		currentProcessedOrder.click();
	}
	
	public void clickDeleteButton() {
		waitHelper.waitForElement(driver, 10, deleteButton);
		deleteButton.click();
	}
}
