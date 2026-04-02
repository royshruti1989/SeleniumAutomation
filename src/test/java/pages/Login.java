//page object model-structuring the page into locators and actions
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	//I have to call the Webdriver from the basseTest here
	WebDriver driver;
	//defining all locators in login page
	//unmae is a username reference to actual usernme locator
	By uname= By.id("username");//locator for username
	//pwd is a username reference
	By pwd= By.id("password");//locator for password
	By lbtn= By.id("login-button");//id locator
	
	public Login(WebDriver driver) {//Constructor
		this.driver=driver;
		
	}
	
     public void login(String user, String pwrd) {
		
		driver.findElement(uname).sendKeys(user);
		driver.findElement(pwd).sendKeys(pwrd);
		driver.findElement(lbtn).click();
	}
 
}
 
	
	


