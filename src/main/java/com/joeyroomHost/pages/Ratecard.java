package com.joeyroomHost.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.joeyroomhost.utils.DataConfiguration;
import com.joeyroomhost.utils.PropertyReader;

public class Ratecard
{
	private  WebDriver driver;
	Select select;
	public Ratecard(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickonRatecard() throws Exception
	{
		String ratecardl=PropertyReader.getLocater("Ratecard", "ratecardl");
		By ratecardTl=By.xpath(ratecardl);
		WebElement ratecardS=driver.findElement(ratecardTl);
		String test=ratecardS.getText();
	    System.out.println(test);
		ratecardS.click();
		
	}
	public void isdispalyTitel() throws Exception
	{
		String ratecardTitel=PropertyReader.getLocater("Ratecard", "ratecardTitle");
		By ratecardTl=By.xpath(ratecardTitel);
		WebElement ratecardTi=driver.findElement(ratecardTl);
		String test=ratecardTi.getText();
	    System.out.println(test);
	    ratecardTi.click();
	    Assert.assertEquals(test, DataConfiguration.validateOfRatecardtitletext,"test case pass");
		
	}
	public void ClickonAddratecard() throws Exception
	{
		String clickonaddratecard=PropertyReader.getLocater("Ratecard", "addcardbutton");
		By addratecardbtn=By.xpath(clickonaddratecard);
		WebElement ratecardl=driver.findElement(addratecardbtn);
		String textdata=ratecardl.getText();
		ratecardl.click();
		
	}
	public void clickonokbutton() throws Exception
	{
		String pleaseselect =PropertyReader.getLocater("Ratecard", "pleasetextdata");
		By pleasetxt=By.xpath(pleaseselect);
		WebElement pleasetxtl=driver.findElement(pleasetxt);
		if(pleasetxtl.isDisplayed())
		{
			String plstext=  pleasetxtl.getText();
			System.out.println(plstext);
			String okbutton =PropertyReader.getLocater("Ratecard", "okbutton");
			By okbtn=By.xpath(okbutton);
			WebElement okbtnl=driver.findElement(okbtn);
		    String text=okbtnl.getText();
		    System.out.println(text); 
		    okbtnl.click();	
		    Assert.assertEquals(plstext, DataConfiguration.validateofpleaseselecttext,"test case pass");
		    Assert.assertEquals(text, DataConfiguration.validateOfOkbtntext,"test case pass");
		    
		}
	}
	public void clickondropdownAndselectproperty() throws Exception
	{
		String drodownl=PropertyReader.getLocater("Ratecard", "clickondropdwon");
		By dropdown=By.xpath(drodownl);
		WebElement dropdn=driver.findElement(dropdown);
		select =new Select((WebElement) dropdn);
		select.selectByVisibleText("NovaHotel");
		
	}
	public void selectdailyLink() throws Exception
	{
		String daily=PropertyReader.getLocater("Ratecard", "daily");
		By dailyL=By.xpath(daily);
		WebElement dailytl=driver.findElement(dailyL);
		String weekly=PropertyReader.getLocater("Ratecard", "weekly");
		By weeklyl=By.xpath(weekly);
		WebElement weeklytl=driver.findElement(weeklyl);
		String monthly=PropertyReader.getLocater("Ratecard", "monthly");
		By monthlyl=By.xpath(monthly);
		WebElement monthlytl=driver.findElement(monthlyl);
		if(dailytl.isDisplayed())
		{
			String text=dailytl.getText();
			dailytl.click();
			System.out.println("clicked to daily and text is visible to="+text);
			String clickondefaultroom=PropertyReader.getLocater("Ratecard", "clickonDefaultRoombutton");
			By clickonDefaultrooml=By.xpath(clickondefaultroom);
			WebElement clickondefaultl=driver.findElement(clickonDefaultrooml);
			if(clickondefaultl.isDisplayed())
			{
				clickondefaultl.click();
				String title=PropertyReader.getLocater("Ratecard", "Roomtitle");
				By titlel=By.xpath(title);
				WebElement titleL=driver.findElement(titlel);
				String data=titleL.getText();
				System.out.println("RoomTitle="+data);
				Assert.assertEquals(data, DataConfiguration.validateofRoomTitle,"test case pass");
			}
			
		}
		else if(weeklytl.equals("WEEKLY"))
		{
			String text=weeklytl.getText();
			weeklytl.click();
			System.out.println("clicked to daily and text is visible to="+text);
			String clickondefaultroom=PropertyReader.getLocater("Ratecard", "clickonDefaultRoombutton");
			By clickonDefaultrooml=By.xpath(clickondefaultroom);
			WebElement clickondefaultl=driver.findElement(clickonDefaultrooml);
			if(clickondefaultl.isDisplayed())
			{
				clickondefaultl.click();
				String title=PropertyReader.getLocater("Ratecard", "");
				By titlel=By.xpath(title);
				WebElement titleL=driver.findElement(titlel);
				String data=titleL.getText();
				System.out.println("RoomTitle="+data);
				Assert.assertEquals(data, DataConfiguration.validateofRoomTitle,"test case pass");
			}
			
		}
		else
		{
			String text=monthlytl.getText();
			monthlytl.click();
			System.out.println("clicked to daily and text is visible to="+text);
			String clickondefaultroom=PropertyReader.getLocater("Ratecard", "clickonDefaultRoombutton");
			By clickonDefaultrooml=By.xpath(clickondefaultroom);
			WebElement clickondefaultl=driver.findElement(clickonDefaultrooml);
			if(clickondefaultl.isDisplayed())
			{
				clickondefaultl.click();
				String title=PropertyReader.getLocater("Ratecard", "");
				By titlel=By.xpath(title);
				WebElement titleL=driver.findElement(titlel);
				String data=titleL.getText();
				System.out.println("RoomTitle="+data);
				Assert.assertEquals(data, DataConfiguration.validateofRoomTitle,"test case pass");
			}
			
			
		}
	}
	
}
