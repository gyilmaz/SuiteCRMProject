package com.app.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.app.beans.ContactBean;
import com.app.pages.SuiteCRMContactInformationPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.utilities.Driver;

import cucumber.api.java.en.When;

public class CreateContactsUsingBeansStepDefs {
	
	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	SuiteCRMCreateContactPage createContactPage= new SuiteCRMCreateContactPage();
	SuiteCRMContactInformationPage contactInformationPage= new SuiteCRMContactInformationPage();
	
	@When("^I save a new contact:$")
	public void i_save_a_new_contact(List<ContactBean> contacts) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc).
	    // Field names for YourType must match the column names in 
	    // your feature file (except for spaces and capitalization).
		
		System.out.println(contacts.size());
		ContactBean contactBean=contacts.get(0); 
		//open the create contact page
		dashboardPage.createLink.click();
		dashboardPage.createContact.click();
		//enter data
		createContactPage.firsName.sendKeys(contactBean.getFirstName());
		createContactPage.lastName.sendKeys(contactBean.getLastName());
		createContactPage.officePhoneNumber.sendKeys(contactBean.getOfficePhone());
		createContactPage.cellPhone.sendKeys(contactBean.getCellPhone());
		createContactPage.department.sendKeys(contactBean.getDepartment());

		//save
		createContactPage.save();
		
		
		
	    
	}
	
	
}
