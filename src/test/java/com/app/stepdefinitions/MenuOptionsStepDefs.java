package com.app.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepDefs {
	
	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	
	@When("^I hover over the (Collaboration|Sales|Marketing|Support|Activities) menu$")
	public void i_hover_over_the_Collaboration_menu(String menu) {
		
		switch (menu){
		
		case "Sales":
			BrowserUtils.hover(dashboardPage.sales);
			break; 
		case "Marketing":
			BrowserUtils.hover(dashboardPage.marketing);
			break;
		case "Collaboration":
			BrowserUtils.hover(dashboardPage.collaboration);
			break;
		case "Support":
			BrowserUtils.hover(dashboardPage.support);
			break;
		case "Activities":
			BrowserUtils.hover(dashboardPage.activities);
			break;
		}
		
	}
		
		
			

	@Then("^following menu options should be visible for (Collaboration|Sales|Marketing|Support|Activities):$")
	public void following_menu_options_should_be_visible_for_Collaboration(String menu, List<String> options) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, 
		//List<List<E>>, 
		//List<Map<K,V>> or 
		//Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc).
	    // Field names for YourType must match the column names in 
	    // your feature file (except for spaces and capitalization).
		for (String each : options) {
			System.out.println(each);
		}
		List<String> actual=BrowserUtils.listMaker(dashboardPage.topMenuOptions(menu)); 
		
		assertEquals(options.size(), actual.size(), "Number of menu options did not match"); 
	   for (int i = 0; i < options.size(); i++) {
		assertEquals(options.get(i), actual.get(i)); 
	}
	}

	
}
