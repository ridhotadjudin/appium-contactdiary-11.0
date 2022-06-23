package com.contactdiary.appium.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.contactdiary.appium.pom.EventActivity;
import com.contactdiary.appium.pom.MainActivity;

import io.appium.java_client.android.AndroidDriver;


public class ContactDiaryTest {

	protected AndroidDriver driver;
	public MainActivity mainActivity;
	public EventActivity eventActivity;
	
	public void delay(int input) {
		int mili = input*1000;
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.manage().timeouts().implicitlyWait(input, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void init() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appPackage", "com.apozas.contactdiary");
		capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		mainActivity = new MainActivity(driver);
		eventActivity = new EventActivity(driver);
		
		mainActivity.clickBtnUtama();
	}
	
	@Test(priority = 1)
	public void test_addNewEvent() {
		delay(5);
		mainActivity.clickNewEvent();
		
//		delay(5);
//		eventActivity.clickStartDate();
//		
//		delay(5);
//		eventActivity.clickEndDate();
		
		delay(5);
		eventActivity.boxOutdoor.click();
		
		delay(5);
		eventActivity.clickMitigation();
		
		delay(5);
		eventActivity.addEvent("Trip Pantai", "Pulau Pari",
				"Barudaks", "08212121", "logika tanpa logistik = anarki");
		
		delay(5);
		eventActivity.save();
		
		delay(5);
		assertNotNull(false, "event tidak ditemukan");
	}
	
	@Test(priority = 2,enabled = false)
	public void test_gotoEventActivity() {
		delay(5);
		mainActivity.clickBtnUtama();
		
		delay(5);
		mainActivity.clickNewContact();
	}

}
