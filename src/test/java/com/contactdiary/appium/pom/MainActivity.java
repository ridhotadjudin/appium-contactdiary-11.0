package com.contactdiary.appium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.contactdiary.appium.utility.CallTouch;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class MainActivity {
	
	public AndroidDriver driver;
	public CallTouch touch;
	
	public MainActivity(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

//	@AndroidFindBy(id = "//android.widget.TextView")
//	public WebElement listMain;
	
	public void clickBtnUtama() {
		System.out.println("Tombol ditekan");
		driver.findElement(By.id("com.apozas.contactdiary:id/fab")).click();
	}
	
	public void clickNewEvent() {
		TouchAction touch = new TouchAction(driver);
		touch.tap(PointOption.point(953, 1821)).perform();
	}
	
	public void clickNewContact() {
		System.out.println("click new contact");
		TouchAction touch = new TouchAction(driver);
		touch.tap(PointOption.point(969, 2022)).perform();
	}
}
