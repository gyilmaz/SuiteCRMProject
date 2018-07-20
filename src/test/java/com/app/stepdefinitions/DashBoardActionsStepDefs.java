package com.app.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardActionsStepDefs {
	private WebDriver driver = Driver.getDriver();

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	
	@When("^I post \"([^\"]*)\"$")
	public void i_post(String note) {
		dashboardPage.postNote(note);
	}

	@Then("^Post should be displayed$")
	public void post_should_be_displayed() {
	   
	}
	
	@Then("^I logout from application$")
	public void i_logout_from_application() {
		dashboardPage.logout();
	}


}
