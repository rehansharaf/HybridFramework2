package com.medflow.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medflow.base.BrowserFactory;
import com.medflow.base.TestBase;
import com.medflow.dataproviders.DataProviders;
import com.medflow.pages.HomePage;
import com.medflow.pages.LoginPage;
import com.medflow.utils.Log;

public class VerifySuccessfulLogin extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	
	@BeforeMethod
	public void beforeTest() {
		
		browserIntialization();
		
	}
	
	
	@Test
	public void verifySuccessLogin() {
		
		Log.startTestCase("Verify Successful Login Only");
		lp = new LoginPage(driver);
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp.verifyHomePageHeading();
		Assert.assertEquals(hp.verifyHomePageHeading(), "Welcome docs, upload");
		Log.endTestCase("Verify Successful Login Only");

		
		
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyLogin(String username, String password) {
		
		Log.startTestCase("Verify Login Functionality");
		lp = new LoginPage(driver);
		hp = lp.login(username, password);
		hp.verifyHomePageHeading();
		Assert.assertEquals(hp.verifyHomePageHeading(), "Welcome docs, upload");
		Log.endTestCase("Verify Login Functionality");
		
	}
	
	@AfterMethod
	public void afterTest() {
		
		driver.get("https://khi.medicallienmgt.com/logout.aspx");
		BrowserFactory.getInstance().removeDriver();
		
	}
	
	

}
