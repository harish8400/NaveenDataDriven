package com.stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class Stepdefinitions {
	WebDriver driver = null;
	@Given("^user is already on Login Page$")
	public void user_is_already_on_login_page() {
		String ProjectPath = System.getProperty("user.dir");
		  System.setProperty("webdriver.chrome.driver",ProjectPath+"/src/test/resources/Drivers/chromedriver.exe"); 
		  driver = new ChromeDriver();
		  driver.get("https://www.freecrm.com/index.html");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();   
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_crm() {
		String title = driver.getTitle();
		  System.out.println(title); 
		  Assert.assertEquals("#1 Free CRM customer relationship management software cloud",title); 
	}
	@Then("^click on login$")
	  public void click_on_login() {
		driver.findElement(By.cssSelector(".btn-xs-2")).click();
	  }
	
	@Then("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys(username);
		  driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		 driver.findElement(By.cssSelector(".fluid")).click();
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		String title = driver.getTitle(); 
		  System.out.println("Cogmento CRM "+ title);
	  Assert.assertEquals("Cogmento CRM", title);   
	}

	@Then("^user moves to new contact page$")
	public void user_moves_to_new_contact_page() {
	    WebElement element = driver.findElement(By.cssSelector(".users"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	      driver.findElement(By.cssSelector(".menu-item-wrapper:nth-child(3) .plus")).click();
	}

	@Then("^user enters contact details (.*) and (.*) and (.*)$")
	public void user_enters_contact_details_and_and(String firstname, String lastname, String position)  {
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	      driver.findElement(By.name("first_name")).sendKeys(firstname);
	      driver.findElement(By.name("middle_name")).sendKeys(lastname);
	      driver.findElement(By.name("last_name")).sendKeys(position);
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}
}
