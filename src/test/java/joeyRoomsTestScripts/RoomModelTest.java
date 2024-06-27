package joeyRoomsTestScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.joeyroomHost.pages.RoomModel;
import com.joeyroomHost.pages.loginpage;
import com.joeyroomhost.utils.Browser;
import com.joeyroomhost.utils.ExtentReportManager;
import com.joeyroomhost.utils.PropertyReader;

public class RoomModelTest 
{
	WebDriver driver;
	loginpage login;
	RoomModel model;
	@BeforeMethod
	public void SetUp() throws Exception
	{
	   	List<String>info=PropertyReader.getdata("browser", 1);
	   	String browsername=info.get(0),drivername=info.get(1),url=info.get(2);
	   	driver=Browser.LanchBrowser(browsername, drivername);
	   	driver=Browser.openUrl(url);
	   	Browser.TakeSelfi("image1");
	   	//Thread.sleep(3000);
	   	ExtentReportManager.startTest("Joeyrooms", "test case description", "test case pass");   	
	}
	@AfterMethod
	public void close()
	{
		driver=Browser.closebrowser();
		ExtentReportManager.stopReport();
	}
	@Test
	public void VerifuFunctionalityJoeyRoomsHostLoginwithValidaDataclickonroommodel() throws Exception
	{
		ExtentReportManager.startReport();
		List<String> info=PropertyReader.getdata("loginpage", 1);
		String email=info.get(0),pass=info.get(1);  
		 login=new loginpage(driver);
		 model=new RoomModel(driver);
		 //Browser.TakeSelfi("image1");
		 login.isdisplaymsg();
		 Browser.TakeSelfi("image2");
		 login.joeyroomlogin(email, pass);
		 model.IsDisplayTitle();
		 Thread.sleep(5000);
		 Browser.TakeSelfi("image3");
		 model.clickonaddproperty();
		 //model.clickonRoomModel();
		 Browser.TakeSelfi("image004");
		 Thread.sleep(3000);
	
		
	}
	

}
