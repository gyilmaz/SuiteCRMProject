package com.app.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMContactInformationPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingContactStepDefs {
	
	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	SuiteCRMCreateContactPage createContactPage= new SuiteCRMCreateContactPage();
	SuiteCRMContactInformationPage contactInformationPage= new SuiteCRMContactInformationPage();
	
	@Given("^I open the create contact page$")
	public void i_open_the_create_contact_page() {
		BrowserUtils.hover(dashboardPage.createLink);
		dashboardPage.createContact.click();
	}

	@Given("^I enter the first name \"([^\"]*)\" and the last name \"([^\"]*)\"$")
	public void i_enter_the_first_name_and_the_last_name(String firstname, String lastname) {
	
		createContactPage.firsName.sendKeys(firstname);
		createContactPage.lastName.sendKeys(lastname);
	}

	@Given("^I enter the phone number \"([^\"]*)\"$")
	public void i_enter_the_phone_number(String phonenumber) {
		createContactPage.cellPhone.sendKeys(phonenumber);
	}

	@Given("^I enter the department \"([^\"]*)\"$")
	public void i_enter_the_department(String department) {
		createContactPage.department.sendKeys(department);
	}

	@When("^click on the save button$")
	public void click_on_the_save_button() {
		createContactPage.save();
	}

	@Then("^I should see contact information for \"([^\"]*)\"$")
	public void i_should_see_contact_information_for(String fullname) {
		
		assertEquals(contactInformationPage.firstName.getText(), fullname.split(" ")[0]);
		assertEquals(contactInformationPage.lastName.getText(), fullname.split(" ")[1]);
	}

}
