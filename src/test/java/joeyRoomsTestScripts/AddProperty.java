package joeyRoomsTestScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.joeyroomHost.pages.AddPropertypage;
import com.joeyroomHost.pages.loginpage;
import com.joeyroomhost.utils.Browser;
import com.joeyroomhost.utils.ExtentReportManager;
import com.joeyroomhost.utils.PropertyReader;

public class AddProperty
{
	WebDriver driver;
	loginpage login;
	AddPropertypage proper;
	@BeforeMethod
	public void setup() throws Exception
	{
		
		List<String> info=PropertyReader.getdata("browser", 1);
		String browsername=info.get(0),drivername=info.get(1),url=info.get(2);
		driver=Browser.LanchBrowser(browsername, drivername);
		driver=Browser.openUrl(url);
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
		ExtentReportManager.stopReport();
	}
	@Test
	public void VerifyLoginFunctionalityAndAddproperty() throws Exception
	{
		
		ExtentReportManager.startTest("VerifuFunctionalityJoeyRoomsHostLoginwithValidaDataAndAddProperty", "test case description", "test case pass");   	
		ExtentReportManager.startReport();
		login  =new loginpage(driver);
		proper=new AddPropertypage(driver);
	List<String>info=	PropertyReader.getdata("loginpage", 1);
	String username=info.get(0),password=info.get(1);
		
		login.joeyroomlogin(username, password);
		login.IsDisplayTitle();
		proper.clickoneditproperty();
		proper.clikconimagesIcon();
		Thread.sleep(3000);
		proper.clickonUploadfile();
		Thread.sleep(3000);
		proper.clickonsavebutton();
		ExtentReportManager.logInfo("lanch to chrome browser successfully");
		ExtentReportManager.logInfo("navigate to url");
		ExtentReportManager.logInfo("enter user name ");
		ExtentReportManager.logInfo("enter to password");
		ExtentReportManager.logInfo("clicked to login button");
		ExtentReportManager.logInfo("login succesully and dipslay to dashborad propertys ");
		ExtentReportManager.logInfo("clicked to edit button");
		ExtentReportManager.logInfo("clicked edit to imgaes&vidoes icon ");
		ExtentReportManager.logInfo("clicked to  upload to file button ");
		ExtentReportManager.logPass("file upload successufully");
		//ExtentReportManager.logFail("file upload failed");
		
		
	}

}
