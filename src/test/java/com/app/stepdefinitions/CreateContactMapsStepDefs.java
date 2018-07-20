package com.app.stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMContactInformationPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.When;

public class CreateContactMapsStepDefs {

	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	SuiteCRMCreateContactPage createContactPage= new SuiteCRMCreateContactPage();
	SuiteCRMContactInformationPage contactInformationPage= new SuiteCRMContactInformationPage();
	
	@When("^I create a new contact:$")
	public void i_create_a_new_contact(Map<String,String> contact) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc).
	    // Field names for YourType must match the column names in 
	    // your feature file (except for spaces and capitalization).
		
		BrowserUtils.hover(dashboardPage.createLink);
	   dashboardPage.createContact.click();
	   //enter information
	   if(contact.get("first_name")!=null){
		   createContactPage.firsName.sendKeys(contact.get("first_name"));
	   }
	   if(contact.get("last_name")!=null){
		   createContactPage.lastName.sendKeys(contact.get("last_name"));
	   }
	   if(contact.get("office_phone")!=null){
		   createContactPage.officePhoneNumber.sendKeys(contact.get("office_phone"));
	   }
	   if(contact.get("cell_phone")!=null){
		   createContactPage.officePhoneNumber.sendKeys(contact.get("cell_phone"));
	   }
	   //save
	   createContactPage.save();
	}
	
}
