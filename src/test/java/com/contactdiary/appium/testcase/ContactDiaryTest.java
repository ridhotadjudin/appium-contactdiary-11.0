package com.contactdiary.appium.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.contactdiary.appium.pom.EventActivity;
import com.contactdiary.appium.pom.MainActivity;
import com.contactdiary.appium.pom.NewContactActivity;

import io.appium.java_client.android.AndroidDriver;


public class ContactDiaryTest {

	protected AndroidDriver driver;
	public MainActivity mainActivity;
	public EventActivity eventActivity;
	public NewContactActivity contactAct;
	
	public void delay(int input){
		try {
			Thread.sleep(input*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void init() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appPackage", "com.apozas.contactdiary");
		capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		mainActivity = new MainActivity(driver);
		eventActivity = new EventActivity(driver);
		contactAct = new NewContactActivity(driver);
		
	}
	
	@Test(priority = 1,enabled=false)
	public void test_addNewEvent() {
		System.out.println("addNewEvent started...");
		mainActivity.clickBtnUtama();
		
		delay(3);
		mainActivity.clickNewEvent();
		
//		delay(3);
//		eventActivity.clickStartDate();
//		
//		delay(3);
//		eventActivity.clickEndDate();
		
		delay(3);
		eventActivity.boxOutdoor.click();
		
		delay(3);
		eventActivity.clickMitigation();
		
		delay(3);
		eventActivity.addEvent("Trip Pantai", "Pulau Pari",
				"Barudaks", "08212121", "logika tanpa logistik = anarki");
		
		delay(3);
		eventActivity.save();
		
		delay(3);
//		assertEquals(, "");
		
		delay(10);
		System.out.println("addNewEvent ended");
	}
	
	@Test(priority = 2)
	public void test_gotoContactActivity() {
		System.out.println("addNewContact started...");
		mainActivity.clickBtnUtama();
		
		delay(2);
		mainActivity.clickNewContact();	//click new contact
		
		delay(2);
		eventActivity.clickStartDate();
		
		delay(3);
		eventActivity.clickEndDate();

//		delay(3);
//		contactAct.setTxtDate("02072022");
		
		List<String> choice = new ArrayList<String>();
		choice.add("1");
		choice.add("2");
		contactAct.setMitigation(choice);
		
//		contactAct.setTxtEndDate("05072022");
//		
//		contactAct.setTxtTime("08", "20", "am");
//		
//		contactAct.setTxtEndTime("10", "30", "pm");
		
		contactAct.txtName.sendKeys("Ridho");
		contactAct.txtPlace.sendKeys("Pantai");
		contactAct.cYes.click();
		contactAct.cOutdoor.click();
		contactAct.txtNote.sendKeys("Ini Testing");
		contactAct.save();
		
		List<WebElement> lstElement =driver.findElements(By.id("com.apozas.contactdiary:id/diarytable"));
		
		String unknownChar ="👤   ";
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String nama = webElement.getText().replace(unknownChar,"");
			if (nama.equalsIgnoreCase("Ridho")) {
				checkData = true;
				break;
			}
		}
		assertTrue(checkData);
		
		System.out.println("addNewContact ended");
	}

}
