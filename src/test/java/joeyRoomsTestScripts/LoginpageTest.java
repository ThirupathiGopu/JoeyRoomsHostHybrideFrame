package joeyRoomsTestScripts;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.joeyroomHost.pages.loginpage;
import com.joeyroomhost.utils.Browser;
import com.joeyroomhost.utils.ExtentReportManager;
import com.joeyroomhost.utils.PropertyReader;


public class LoginpageTest
{

	WebDriver driver;
	loginpage login;
	String url;
	String email,pass;
	@BeforeMethod
	public void SetUp() throws Exception
	{
	  	List<String>info=PropertyReader.getdata("browser", 1);
	   	String browsername=info.get(0),drivername=info.get(1),url=info.get(2);
	   	driver=Browser.LanchBrowser(browsername, drivername);
	   	driver=Browser.openUrl(url);
	   	Browser.TakeSelfi("image1");
	   	//Thread.sleep(3000);
	   //	ExtentReportManager.startTest("Joeyrooms", "test case description", "test case pass");   	
	}
	@AfterMethod
	public void close()
	{
		driver=Browser.closebrowser();
		ExtentReportManager.stopReport();
	}
	@Test(enabled=true)
	public void VerifuFunctionalityJoeyRoomsHostLoginwithValidaData() throws Exception
	{
		ExtentReportManager.startTest("VerifuFunctionalityJoeyRoomsHostLoginwithValidaData", "test case description", "test case pass");   	
	
		ExtentReportManager.startReport();
		List<String> info=PropertyReader.getdata("loginpage", 1);
		 email=info.get(0);
		 pass=info.get(1);  
		 login=new loginpage(driver);
		 //Browser.TakeSelfi("image1");
		 login.isdisplaymsg();
		 
		 Browser.TakeSelfi("image2");
		 //Thread.sleep(2000);
		 login.joeyroomlogin(email, pass);
		 Thread.sleep(2000);
		 login.IsDisplayTitle();
		 Browser.TakeSelfi("image3");
		 ExtentReportManager.logInfo("lanch to Chrome Browser");
		 ExtentReportManager.logInfo("Navigate to URl");
		 ExtentReportManager.logInfo("enter to user name="+email+"");
		 ExtentReportManager.logInfo("enter to user password"+pass);
		 ExtentReportManager.logInfo("click to login button ");
		 ExtentReportManager.logInfo("open to dashboard successfully");
		// ExtentReportManager.stopReport();
	}
	@Test(enabled=false)
	public void VerifuFunctionalityJoeyRoomsHostLoginwithInValidaData() throws Exception
	{
		ExtentReportManager.startReport();
		List<String> info=PropertyReader.getdata("loginpage", 2);
		String email=info.get(0),pass=info.get(1);  
		 login=new loginpage(driver);
		 //Browser.TakeSelfi("image1");
		 login.isdisplaymsg();
		 
		 Browser.TakeSelfi("image2");
		 //Thread.sleep(2000);
		 login.joeyroomlogin(email, pass);
		 Thread.sleep(2000);
		login.isdisplayerrormsg();
		 Browser.TakeSelfi("image3");
		
		 ExtentReportManager.stopReport();
	}
	@DataProvider(name="logininfo")
	public  String[][]	GetLoginMultipleData() throws Exception
	{
		String data[][]=PropertyReader.getdata("loginpage");
		return data;		
	}
	@Test(enabled=false,dataProvider="logininfo")
	public void LogingMultipletimesValidAndInvalidData(String email,String pass) throws Exception
	
	{
		ExtentReportManager.startReport();
		  
		 login=new loginpage(driver);
		
		 login.isdisplaymsg();
		 
		 Browser.TakeSelfi("image2");
		
		 login.joeyroomlogin(email, pass);
		 Thread.sleep(2000);
		 login.IsDisplayTitle();
		
	}
	
	
	
	
}
