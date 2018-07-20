package com.app.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.pages.SuiteCSRMSearchResultsPage;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchContactsDefs {

	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCSRMSearchResultsPage searchResultsPage = new SuiteCSRMSearchResultsPage();
	
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTerm) {
		dashboardPage.searchButton.click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
		wait.until(ExpectedConditions.attributeContains(dashboardPage.searchButton, "aria-expanded", "true")); 
		Actions action=new Actions(driver); 
		action.moveToElement(dashboardPage.searchInput).sendKeys(searchTerm +Keys.ENTER); 
		
		//dashboardPage.searchInput.sendKeys();
	}
	
	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
		assertTrue(searchResultsPage.resultLink(searchTerm).isDisplayed(), searchTerm + " was not displayed");
	}

	@Then("^there should be (\\d+) result for \"([^\"]*)\"$")
	public void there_should_be_result_for(int count, String searchTerm) {
		int actual = searchResultsPage.resultsLink(searchTerm).size();
		assertEquals(actual, count, "number of results did not match");
	}
}