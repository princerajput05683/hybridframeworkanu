package com.odoo.webutils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;


public class OdooListeners implements ITestListener,WebDriverEventListener {
	
	public static int executionCount, passCount, failCount, skipCount=0;
	public static Logger log;
	long startTime;
	
	public void beforeFindBy(By by, WebElement ele, WebDriver arg2) {
		log.info("Finding element with locator: "+by);
		log.info("Finding Element: "+ele);
	}
	
	public void onStart(ITestContext context) {
		startTime=System.currentTimeMillis();  // start time in millis rtype is long.
		
		System.setProperty("logpath", GenericLib.dir+"/reports/logfiles");
		System.setProperty("htmlpath", GenericLib.dir+"/reports/htmlreports");
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.setProperty("timestamp", sdf.format(new Date()));
		PropertyConfigurator.configure("log4j.properties");
		
		log=Logger.getLogger(OdooListeners.class);
		log.info("suite execution starts");
		
		String platformName = System.getProperty("platform");
		String browserName = System.getProperty("browser");
		String headless = System.getProperty("headless");
		
		WebDriver driver=BrowserFactory.launchBrowser(platformName, browserName, headless);
		Driver.setDriver(driver);
	}
	
    public void onException(Throwable t, WebDriver driver) {
		log.fatal(t.getMessage());
	}
    
    public void onFinish(ITestContext context) {
		long stopTime=System.currentTimeMillis();
		double totalTime=(stopTime-startTime)/1000;
		log.info("Total suite execution time: "+totalTime+"seconds");
		log.info("suite execution ends");
		Driver.getDriver().close();
		log.info("Browser closed");
		log.info("Total scripts exectuted: "+executionCount);
		log.info("Total scripts exectuted: "+passCount);
		log.info("Total scripts exectuted: "+failCount);
		log.info("Total scripts exectuted: "+skipCount);
	}
	
	public void onTestFailure(ITestResult result) {
		failCount++;
		log.error(result.getName()+"script is failed");
		TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(GenericLib.dir+"/screenshot/"+result.getName()+".png");
		
		try{
			Files.copy(src, des);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		skipCount++;
		log.warn(result.getName()+"script is skipped");
	}

	public void onTestStart(ITestResult result) {
		executionCount++;
		log.info(result.getName()+" script execution starts");
	}

	public void onTestSuccess(ITestResult result) {
		passCount++;
		log.info(result.getName()+"script is passed");
	}
	public void afterAlertAccept(WebDriver arg0) {
		
	}
	public void afterAlertDismiss(WebDriver arg0) {
		
	}
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
	}
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		
	}
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
	}
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		
	}
	public void afterNavigateBack(WebDriver arg0) {
		
	}
	public void afterNavigateForward(WebDriver arg0) {
		
	}
	public void afterNavigateRefresh(WebDriver arg0) {
		
	}
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		
	}
	public void afterScript(String arg0, WebDriver arg1) {
		
	}
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		
	}
	public void beforeAlertAccept(WebDriver arg0) {
		
	}
	public void beforeAlertDismiss(WebDriver arg0) {
		
	}
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		
	}
	
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		
	}
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		
	}
	public void beforeNavigateBack(WebDriver arg0) {
		
	}
	public void beforeNavigateForward(WebDriver arg0) {
			
	}
	public void beforeNavigateRefresh(WebDriver arg0) {
		
	}
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		
	}
	public void beforeScript(String arg0, WebDriver arg1) {
		
	}
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	

}
