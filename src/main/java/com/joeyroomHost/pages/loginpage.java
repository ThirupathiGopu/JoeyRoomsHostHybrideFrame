package com.joeyroomHost.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.joeyroomhost.utils.Browser;
import com.joeyroomhost.utils.DataConfiguration;
import com.joeyroomhost.utils.PropertyReader;

public class loginpage
{
	private  WebDriver driver;
	public loginpage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public  void isdisplaymsg() throws Exception
	{
		
		String signintextmsgl=PropertyReader.getLocater("Loginpage", "signIntext");
		//PropertyReader.getLocater("Loginpage", "signIntext");
		By signintextmsg=By.xpath(signintextmsgl);
		WebElement signintextmsgt=driver.findElement(signintextmsg);
		//Browser.Waitmethod(signintextmsgt);
		String msg=signintextmsgt.getText();
		System.out.println(msg);
	    Assert.assertEquals(msg,DataConfiguration.validateOfsearchtext, "Test case pass");
		Browser.TakeSelfi("image000");
	}
	
	/*public void clickonloginwithpassword() throws Exception
	{
		String loginwithpwd=PropertyReader.getLocater("Loginpage", "loginwithpassword");
		By loginwithpswd=By.xpath(loginwithpwd);
		WebElement loginpwd=driver.findElement(loginwithpswd);
		loginpwd.click();
		Browser.TakeSelfi("image002");
	}
	*/
	private void SetEmail(String email) throws Exception
	{
		String emailTextl=PropertyReader.getLocater("Loginpage", "username");
		By emailtxtboxL=By.xpath(emailTextl);
		WebElement emailtxtL=driver.findElement(emailtxtboxL);
		Browser.Waitmethod(emailtxtL);
		emailtxtL.sendKeys(email);
	}
	private void SetPassword(String pass) throws Exception
	{
		String passwordl=PropertyReader.getLocater("Loginpage", "password");
		By passwordtxtL=By.xpath(passwordl);
		WebElement passwordTextL=driver.findElement(passwordtxtL);
		Browser.Waitmethod(passwordTextL);
		passwordTextL.sendKeys(pass);
	}
	private void clikonloginBtn() throws Exception
	{
		String loginbtnl=PropertyReader.getLocater("Loginpage", "loginbutn");
		By loginbtnL=By.xpath(loginbtnl);
		WebElement Loginbtnl=driver.findElement(loginbtnL);
		Browser.Waitmethod(Loginbtnl);
		Loginbtnl.click();
	}
	public void isdisplayerrormsg() throws Exception
	{
		String errormsg=PropertyReader.getLocater("Loginpage", "errormsg");
		By errormsgl=By.xpath(errormsg);
		WebElement errorText=driver.findElement(errormsgl);
		Browser.Waitmethod(errorText);
		String msg=errorText.getText();
		System.out.println(msg);
		Assert.assertEquals(msg, DataConfiguration.validateofErrorMesage,"test case pass");
	}
	
//	public  void isdisplayGobutton() throws Exception
//	{
//		String gobutton=PropertyReader.getLocater("Loginpage", "gobutton");
//		By gobuttonl=By.xpath(gobutton);
//		WebElement gobuttontext=driver.findElement(gobuttonl);
//		Browser.Waitmethod(gobuttontext);
//		String text=gobuttontext.getText();
//		System.out.println(text);
//		gobuttontext.click();
//		//Assert.assertEquals(text,DataConfig.validateOfLoginToAudioDigestmsg, "Test case pass");
//	}
	public void IsDisplayTitle() throws Exception
	{
		String titlemsg=PropertyReader.getLocater("Loginpage", "dashboad");
	    By titlemsgl=By.xpath(titlemsg);
	    WebElement titlemsgls=driver.findElement(titlemsgl);
	    Browser.Waitmethod(titlemsgls);
	    String msg=titlemsgls.getText();
	    System.out.println(msg);
	    
	    Assert.assertEquals(msg, DataConfiguration.validateofTitletext,"login successfully test case pass");
	    Browser.TakeSelfi("image001");
	}
	
	public  void joeyroomlogin(String email,String pass) throws Exception
	{
		this.SetEmail(email);
		this.SetPassword(pass);
		this.clikonloginBtn();
	}

}
