package com.smartbear.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.smartbear.automation.helper.WaitHelper;

public class ProcessOrderPage {

	public WebDriver driver;
	// public static Properties OR;
	WaitHelper waitHelper;

	@FindBy(xpath = "//a[contains(@href,'Process')]")
	public WebElement order;

	@FindBy(xpath = "//*[contains(@id,'Product')]")
	public WebElement product;

	@FindBy(xpath = "//*[contains(@id,'Quantity')]")
	public WebElement quantity;

	@FindBy(xpath = "//*[contains(@id,'UnitPrice')]")
	public WebElement unitPrice;

	@FindBy(xpath = "//*[contains(@id,'txtName')]")
	public WebElement customerName;

	@FindBy(xpath = "//*[contains(@id,'TextBox2')]")
	public WebElement street;

	@FindBy(xpath = "//*[contains(@id,'TextBox3')]")
	public WebElement city;

	@FindBy(xpath = "//*[contains(@id,'TextBox4')]")
	public WebElement state;

	@FindBy(xpath = "//*[contains(@id,'TextBox5')]")
	public WebElement zip;

	@FindBy(xpath = "//*[@value='Visa']")
	public WebElement visaCard;

	@FindBy(xpath = "//*[contains(@id,'TextBox6')]")
	public WebElement cardNo;

	@FindBy(xpath = "//*[contains(@id,'TextBox1')]")
	public WebElement expiryDate;

	@FindBy(xpath = "//*[contains(@id,'InsertButton')]")
	public WebElement processButton;

	@FindBy(xpath = "//*[contains(text(),'successfully')]")
	public WebElement orderSuccessfullyOrdered;

	public ProcessOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void clickOrder() {
		waitHelper.waitForElement(driver, 10, order);
		order.click();
	}

	public void productInformation() {
		Select select = new Select(product);
		select.selectByValue("FamilyAlbum");
		quantity.clear();
		waitHelper.waitForElement(driver, 10, quantity);
		quantity.sendKeys("20");
		unitPrice.clear();
		waitHelper.waitForElement(driver, 10, unitPrice);
		unitPrice.sendKeys("100");
	}

	public void addressInformation() {
		waitHelper.waitForElement(driver, 10, customerName);
		customerName.sendKeys("Robert");
		waitHelper.waitForElement(driver, 10, street);
		street.sendKeys("Street");
		waitHelper.waitForElement(driver, 10, city);
		city.sendKeys("Los Angeles");
		state.sendKeys("California");
		zip.sendKeys("90001");
	}

	public void paymentInformation() {
		waitHelper.waitForElement(driver, 10, visaCard);
		visaCard.click();
		waitHelper.waitForElement(driver, 10, cardNo);
		cardNo.sendKeys("5222222222");
		expiryDate.sendKeys("01/25");
	}

	public void clickProcessButton() {
		waitHelper.waitForElement(driver, 10, processButton);
		processButton.click();
	}

	public String getOrderSuccessfullyOrderedMessage() {
		waitHelper.waitForElement(driver, 10, orderSuccessfullyOrdered);
		return orderSuccessfullyOrdered.getText();
	}
}
