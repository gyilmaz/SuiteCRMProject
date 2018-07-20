package com.app.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests; 

@CucumberOptions(
		plugin={"pretty","html:target/cucumber-report", "json:target/cucumber.json"},
		tags="@report",
		features="src/test/resources/com/app/features",
		glue="com/app/stepdefinitions",
		dryRun=false //this will run without running test, just tell you what steps needs to be implemented
		)
public class CukesRunner extends AbstractTestNGCucumberTests{

	
	
}
