package com.odoo.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.odoo.features.LoginFeature;
import com.odoo.generic.Driver;
import com.odoo.webutils.OdooListeners;

public class BaseAbstractTest {
	public static EventFiringWebDriver driver;
	LoginFeature lf;
	
	@BeforeClass
	public void setUp(){
		driver=new EventFiringWebDriver(Driver.getDriver());
		driver.register(new OdooListeners());
		driver.manage().window().maximize();
		lf=new LoginFeature(driver);
	}
	
	@BeforeMethod
	public void preCondition(){
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(System.getProperty("url"));
	}

}
