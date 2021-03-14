package com.stepdef;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/resources/Features/contacts.feature",
glue={"com.stepdef"}, 
dryRun = false,
monochrome = true,

plugin = {"pretty","html:target/reports/HtmlReports/Result.html",
"json:target/reports/jsonReports/Resultr.json",
"junit:target/reports/cucumber/cucumber.xml"}
	
		)
public class TestRunner {

}
