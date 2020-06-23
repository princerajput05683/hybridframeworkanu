package com.odoo.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLib {
	WebDriver driver;
	
	public PageLib(WebDriver driver){
		this.driver=driver;
	}
	public void jsClick(String xpath){
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", driver.findElement(By.xpath(xpath)));
	}
	public void jsScrollIntoView(String xpath){
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", driver.findElement(By.xpath(xpath)));
	}
	public void jsSetAttribute(String xpath,String input){
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].setAttribute('value','"+input+"')", driver.findElement(By.xpath(xpath)));
	}
	public void selectOptionByText(WebElement dropDown, String text){
		Select sel=new Select(dropDown);
	    sel.selectByVisibleText(text);
	}
	public void selectOptionByIndex(WebElement dropDown, int index){
		Select sel=new Select(dropDown);
		sel.selectByIndex(index);
	}
	public void mouseHover(WebElement element){
		Actions ac=new Actions(driver);
		ac.moveToElement(element);
	}
	public void dargAndDrop(WebElement source, WebElement target){
		Actions ac=new Actions(driver);
		ac.clickAndHold(target).perform();
		ac.dragAndDrop(source, target).perform();
		ac.release().perform();
	}
	public void eWaitForElementPresent(int seconds, String xpath){
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	public void eWaitForElementVisible(int seconds, String xpath){
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public void eWaitForElementframeToBeAvailable(int seconds, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

}
