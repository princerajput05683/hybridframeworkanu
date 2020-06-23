package com.odoo.webutils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxCapabilities {
	
public static FirefoxOptions geFirefoxSettings(String headless){
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setHeadless(Boolean.parseBoolean(headless));
		options.merge(cap);
		
		return options;
	}

}
