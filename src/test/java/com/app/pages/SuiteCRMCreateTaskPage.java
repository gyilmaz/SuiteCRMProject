package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateTaskPage {


	private WebDriver driver;
	
	public SuiteCRMCreateTaskPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="name")
	public WebElement subject; 
	
	@FindBy (id="status")
	public WebElement status;
	
	@FindBy (id="date_start_date")
	public WebElement startDate;
	
	@FindBy (id="date_due_date")
	public WebElement dueDate;
	
	@FindBy (id="priority")
	public WebElement priority;
	
	@FindBy (id="description")
	public WebElement description;
	
	@FindBy (xpath="(//input[@title='Save'])[1]")
	public WebElement save;
	
	@FindBy (xpath="//div[@class='moduleTitle']/h2")
	public WebElement tasksTitle; 
	
	@FindBy (id="date_start")
	public WebElement overViewStartDate; 
	
	@FindBy (id="date_due")
	public WebElement overViewDueDate; 

	@FindBy (xpath="//input[@id='priority']")
	public WebElement overViewPriority; 
}	
