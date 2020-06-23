package com.odoo.scripts;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseAbstractTest {
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Performing valid login")
	public void validLogin(){
		lf.login("anuragkrgupta.corp15@gmail.com","Aadn943020202020");
	}

}
