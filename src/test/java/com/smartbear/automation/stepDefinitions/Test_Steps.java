package com.smartbear.automation.stepDefinitions;

import org.junit.Assert;

import com.smartbear.automation.helper.WaitHelper;
import com.smartbear.automation.pageObjects.WebOrdersPage;
import com.smartbear.automation.pageObjects.LoginPage;
import com.smartbear.automation.pageObjects.ProcessOrderPage;
import com.smartbear.automation.testBase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps extends TestBase {

	WaitHelper waitHelper;
	LoginPage loginPage;
	WebOrdersPage webOrdersPage;
	ProcessOrderPage processOrderPage;

	@Given("^User navigates to smartbear homepage$")
	public void user_navigates_to_smartbear_homepage() {
		getBrowser("firefox");
		driver.get(
				"http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");
	}

	@When("^User enters username$")
	public void user_enters_username() {
		loginPage = new LoginPage(driver);
		loginPage.enterUsername();
	}

	@And("^User enters password$")
	public void user_enters_password() {
		loginPage.enterPassword();
	}

	@And("^User clicks on login button$")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("^User should land on weborders page$")
	public void user_should_land_on_weborders_page() throws Throwable {

		webOrdersPage = new WebOrdersPage(driver);
		Boolean headerWebOrders = webOrdersPage.getWebOrdersHeader().equalsIgnoreCase("Web Orders");
		Boolean listOfAllOreders = webOrdersPage.getListOfAllOreders().contains("List of All Orders");
		if (headerWebOrders && listOfAllOreders) {
			System.out.println("Homepage landed Successfully....");
			Assert.assertTrue(true);
		} else {
			System.out.println("Homepage didn't landed Successfully....");
			Assert.assertFalse(true);
		}
	}

	@Given("^User navigates to Process Order page$")
	public void user_navigates_to_process_order_page() throws Throwable {
		processOrderPage = new ProcessOrderPage(driver);
		processOrderPage.clickOrder();
	}

	@When("^User enters Product Information$")
	public void user_enters_product_information() throws Throwable {
		processOrderPage.productInformation();
	}

	@And("^User enters Address Information$")
	public void user_enters_address_information() throws Throwable {
		processOrderPage.addressInformation();
	}

	@And("^User enters Payment Information$")
	public void user_enters_payment_information() throws Throwable {
		processOrderPage.paymentInformation();
	}

	@And("^User clicks on Process Button$")
	public void user_clicks_on_process_button() throws Throwable {
		processOrderPage.clickProcessButton();
	}

	@Then("^Orders should be able to process successfully$")
	public void orders_should_be_able_to_process_successfully() throws Throwable {

		Boolean orderSuccessfullyOrdered = processOrderPage.getOrderSuccessfullyOrderedMessage()
				.equalsIgnoreCase("New order has been successfully added.");
		webOrdersPage = new WebOrdersPage(driver);
		webOrdersPage.clickViewAllOrders();

		Boolean customerName = webOrdersPage.getCustomerName().equalsIgnoreCase("Robert");
		if (orderSuccessfullyOrdered && customerName) {
			System.out.println("Order Processed Successfully....");
			Assert.assertTrue(true);
		} else {
			System.out.println("Order didn't Processed Successfully....");
			Assert.assertFalse(true);
		}
	}

	@Given("^User should be on the weborders page$")
	public void user_should_be_on_the_weborders_page() throws Throwable {
		webOrdersPage = new WebOrdersPage(driver);
	}

	@When("^User selects the current order$")
	public void user_selects_the_current_order() throws Throwable {
		webOrdersPage.clickCurrentProcessedOrder();
	}

	@When("^User clicks on delete selected$")
	public void user_clicks_on_delete_selected() throws Throwable {
		webOrdersPage.clickDeleteButton();
	}

	@Then("^order should be successfully deleted$")
	public void order_should_be_successfully_deleted() throws Throwable {
		Boolean existingCustomer = webOrdersPage.getOldCustomerName().equalsIgnoreCase("Robert");
		if (!existingCustomer) {
			System.out.println("Order Deleted Successfully....");
			Assert.assertTrue(true);
		} else {
			System.out.println("Order didn't Deleted Successfully....");
			Assert.assertFalse(true);
		}
	}
}
