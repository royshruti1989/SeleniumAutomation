package tests;

import org.testng.annotations.Test;


import base.BaseTest;
import pages.Login;
import utils.ConfigReader;

import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void verifyLogin() {
		
		Log.info("Login Test case started");
		Login login=new Login(driver);
		
		login.login(ConfigReader.prop.getProperty("username"),ConfigReader.prop.getProperty("password"));
		String title = driver.getTitle();
		
		System.out.println(title);
		
		
	}
 
	}


