package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.LoginSteps;

import io.qameta.allure.Feature;

public class LoginFeature {
	LoginSteps ls;
	
	public LoginFeature(WebDriver driver){
		ls=new LoginSteps(driver);
	}
	@Feature("Performing login using credentials {0} and {1}")
	public void login(String username, String password){
		ls.enterUsername(username);
		ls.enterPassword(password);
		ls.clickLoginBtn();
	}

}