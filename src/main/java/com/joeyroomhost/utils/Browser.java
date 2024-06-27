package com.joeyroomhost.utils;

import java.io.File;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browser 
{
	static WebDriver driver;
	static WebDriverWait wait;
	public static WebDriver LanchBrowser(String browsername,String drivername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(browsername.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
	public static WebDriver openUrl(String url)
	{
		driver.get(url);
		return driver;
	}
	public static WebDriver closebrowser()
	{
		driver.close();
		return driver;
	}
	public static void TakeSelfi(String imageName) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE) ,new File(".//screenshot//"+imageName+".png"));	
	}
	public static void scrolldown(WebElement element) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", element);
	}
	public static void Waitmethod(WebElement element) 
	{
	    wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element)); 
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void verifyurl()
	{
		String actuallurl=driver.getCurrentUrl();
		//Assert.assertEquals(actuallurl,DataConfig.validateofExpectedUrl,"test case pass");
	}
	
}
