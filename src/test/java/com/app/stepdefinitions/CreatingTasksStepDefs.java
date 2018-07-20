package com.app.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingTasksStepDefs {

	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	LocalDateTime now= LocalDateTime.now(); 
	List <String> expTaskList= new ArrayList<>(); 
	List <String> actTaskList= new ArrayList<>(); 
	
	@When("^I click on create task$")
	public void i_click_on_create_task() {
	    dashboardPage.createLink.click();
	    dashboardPage.createTask.click();
	    assertTrue(createTaskPage.subject.isDisplayed()); 
	    assertTrue(createTaskPage.status.isDisplayed());
	    assertTrue(createTaskPage.startDate.isDisplayed());
	
	
	}

	@When("^Set subject as \"([^\"]*)\"$")
	public void set_subject_as(String arg1) {
		createTaskPage.subject.sendKeys(arg1);
		expTaskList.add(arg1.toLowerCase());
	}

	@When("^Set status as \"([^\"]*)\"$")
	public void set_status_as(String arg1) {
		BrowserUtils.dropDownSelect(createTaskPage.status, arg1 ); 
		expTaskList.add(arg1);
	}

	@When("^Start date is todays date$")
	public void start_date_is_todays_date() {
		String date=BrowserUtils.dateModifier(now ,"MM/dd/yyyy"); 
		createTaskPage.startDate.sendKeys(  date);
		expTaskList.add(date);
	}

	@When("^Due date is (\\d+) days after todays date$")
	public void due_date_is_days_after_todays_date(int arg1) {
	    LocalDateTime dueDate= now.plusDays(arg1);
	    String dueDateStr=BrowserUtils.dateModifier(dueDate, "MM/dd/yyyy");
		createTaskPage.dueDate.sendKeys(dueDateStr);
		expTaskList.add(dueDateStr);
	}

	@When("^Set \"([^\"]*)\" priority$")
	public void set_priority(String arg1) {
		BrowserUtils.dropDownSelect(createTaskPage.priority, arg1); 
		expTaskList.add(arg1); 
	}

	@When("^Set description as \"([^\"]*)\"$")
	public void set_description_as(String arg1) {
	   createTaskPage.description.sendKeys(arg1);
	   expTaskList.add(arg1); 
	}

	@When("^Save the task$")
	public void save_the_task() {
	 createTaskPage.save.click();
	}

	@Then("^Task details page should be displayed$")
	public void task_details_page_should_be_displayed() {
	String expTaskTitle= expTaskList.get(0).toUpperCase(); 
	WebElement titleElement=createTaskPage.tasksTitle; 
	BrowserUtils.waitForVisibility(titleElement, 5); 
	System.out.println(titleElement.getText());
	assertEquals(titleElement.getText(),expTaskTitle ); 
	//actTaskList.add(titleElement.getText().toLowerCase());
	}

	@Then("^Data should match with created task data$")
	public void data_should_match_with_created_task_data() {
	    System.out.println(expTaskList);
	    actTaskList.add(createTaskPage.subject.getText().toLowerCase());
	    actTaskList.add(createTaskPage.status.getAttribute("value")); 
	    actTaskList.add(createTaskPage.overViewStartDate.getText().substring(0, 10)); 
	    actTaskList.add(createTaskPage.overViewDueDate.getText().substring(0, 10)); 
	    actTaskList.add(createTaskPage.overViewPriority.getAttribute("value")); 
	    actTaskList.add(createTaskPage.description.getText()); 
	    System.out.println(actTaskList);
	    assertTrue(actTaskList.containsAll(expTaskList));
	}
	
	
	
}
