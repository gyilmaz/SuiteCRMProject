package com.app.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateContactPage {

	private WebDriver driver;
	
	public SuiteCRMCreateContactPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	public WebElement firsName;

	@FindBy(id = "last_name")
	public WebElement lastName;

	@FindBy(id = "phone_work")
	public WebElement officePhoneNumber;

	@FindBy(id = "department")
	public WebElement department;

	@FindBy(id = "SAVE")
	public WebElement save;

	@FindBy(xpath = "//input[@title='Save']")
	public WebElement saveConfirmation;
	
	@FindBy(xpath="//h2[.='Save Contact']")
	public WebElement saveContactText; 

	@FindBy(id = "phone_mobile")
	public WebElement cellPhone;

	public void save() {
		
		save.click();
		try {
			if (saveContactText.isDisplayed()){
				saveConfirmation.click();
				}
		} catch (NoSuchElementException e) {
			e.printStackTrace();		
			}
		
		

	}
}