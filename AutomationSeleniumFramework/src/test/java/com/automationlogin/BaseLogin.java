package com.automationlogin;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Wait;

import com.config.BaseConfig;
import com.util.Highlighter;

public class BaseLogin {

public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();//upcasting
		
		driver.manage().window().maximize();//maximum or full size
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		
		LoginPage login =new LoginPage(driver);
		System.out.println(driver.getTitle());
		//new Highlighter().getcolor(driver, login.getLogin());
		login.getLogin().click();// click
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		Wait.getExplicitWaitClicable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		
		new Highlighter().getcolor(driver, login.getPass(),"black");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		Thread.sleep(3000);

		login.getSubmit().click();

		System.out.println(driver.getTitle());
		
		driver.quit();//= all browser tab + Chrome driver
		
	}

}

