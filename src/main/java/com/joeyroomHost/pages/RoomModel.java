package com.joeyroomHost.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.joeyroomhost.utils.Browser;
import com.joeyroomhost.utils.DataConfiguration;
import com.joeyroomhost.utils.PropertyReader;

public class RoomModel 
{
	private  WebDriver driver;
	Actions action;
	public RoomModel(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void IsDisplayTitle() throws Exception
	{
		String titlemsg=PropertyReader.getLocater("RoomModel", "dashboad");
	    By titlemsgl=By.xpath(titlemsg);
	    WebElement titlemsgls=driver.findElement(titlemsgl);
	    Browser.Waitmethod(titlemsgls);
	    String msg=titlemsgls.getText();
	    System.out.println(msg);
	    
	    Assert.assertEquals(msg, DataConfiguration.validateofTitletext,"login successfully test case pass");
	    Browser.TakeSelfi("image001");
	}
	public void clickonRoomModel() throws Exception
	{
	String roommodel=PropertyReader.getLocater("RoomModel", "roomMoedel");
	By roommodelL=By.xpath(roommodel);
	WebElement roommodels=driver.findElement(roommodelL);
	roommodels.click();
	System.out.println("clicked room model ");
	}
	public void clickonaddproperty() throws Exception
	{
		String addpropertl=PropertyReader.getLocater("RoomModel", "addproperty");
		By addproperty=By.xpath(addpropertl);
		WebElement addpropl=driver.findElement(addproperty);
		addpropl.isDisplayed();
		addpropl.click();
	}
	public void clickonNextbtn() throws Exception
	{

    JavascriptExecutor js = (JavascriptExecutor) driver;
	

		String nextbtnl=PropertyReader.getLocater("RoomModel", "nextbtn");
		
		By nextbt=By.xpath(nextbtnl);
	
		WebElement nextbtl=driver.findElement(nextbt);

    js.executeScript("arguments[0].scrollIntoView();", nextbtl);

		//boolean status=nextbtl.isDisplayed();
		String data=nextbtl.getText();
		System.out.println("text name ="+data);
		action=new Actions(driver);
		action.click();
		//nextbtl.click();
	}
	public void isdisplayErrormessage() throws Exception
	{
		String errormsgl=PropertyReader.getLocater("RoomModel", "errormsg");
		By errormsg=By.xpath(errormsgl);
		WebElement errormg=driver.findElement(errormsg);
		String msg=errormg.getText();
		Assert.assertEquals(msg,DataConfiguration.validateofErrormsg,"test case pass" );
		
	}
	
}
