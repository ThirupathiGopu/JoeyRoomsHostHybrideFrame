package com.joeyroomHost.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.joeyroomhost.utils.PropertyReader;

public class AddPropertypage {
	private WebDriver driver;

	public AddPropertypage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickoneditproperty() throws Exception {
		String editbtnl = PropertyReader.getLocater("Addpropertys", "editprobtn");
		By editbtnL = By.xpath(editbtnl);
		WebElement editbtnls = driver.findElement(editbtnL);
		editbtnls.click();
	}

	public void clikconimagesIcon() throws Exception {
		String imgaesiconl = PropertyReader.getLocater("Addpropertys", "clickonimagebtn");
		By imgiconl = By.xpath(imgaesiconl);
		WebElement imgiconls = driver.findElement(imgiconl);
		imgiconls.click();
	}

	public void clickonUploadfile() throws Exception {
		String uploadfileiconl = PropertyReader.getLocater("Addpropertys", "clickuploadbtn");
		By uploadfileicons = By.xpath(uploadfileiconl);
		WebElement imgiconls = driver.findElement(uploadfileicons);
		imgiconls.click();
		Thread.sleep(4000);
//imgiconls.sendKeys("/home/tvisha/Downloads/Joeyroom/roomimages.jpg");
		Robot rb = new Robot();

// copying File path to Clipboard
		StringSelection str = new StringSelection("/home/tvisha/Downloads/Joeyroom/roomimages.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public void clickonsavebutton() throws Exception
	{
		String savebtn=PropertyReader.getLocater("Addpropertys", "savebtn");
		By savebtnl=By.xpath(savebtn);
		WebElement savebtnL=driver.findElement(savebtnl);
		savebtnL.click();
	}

}
