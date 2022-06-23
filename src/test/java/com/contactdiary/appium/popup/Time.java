package com.contactdiary.appium.popup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.contactdiary.appium.pom.EventActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class Time {
	
	protected AndroidDriver driver;
	public EventActivity eventActivity;
	
	public Time(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void delay(int input) {
		driver.manage().timeouts().implicitlyWait(input, TimeUnit.SECONDS);
	}
	
	public void callTouch(int x, int y) {
		TouchAction touchNew = new TouchAction(driver);
		touchNew.tap(PointOption.point(x, y)).perform();
	}
	
	@AndroidFindBy(id = "android:id/input_hour")
	public WebElement hour;
	
	@AndroidFindBy(id = "android:id/input_minute")
	public WebElement minute;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement btnOK;

	public void setTimeStart() {
		callTouch(243,1697);
		callTouch(243,1697);
		delay(5);
		hour.clear();
		hour.sendKeys("08");
		delay(5);
		minute.clear();
		minute.sendKeys("09");
		delay(5);
		btnOK.click();
	}
	
	public void setTimeEnd() {
		callTouch(243,1697);
		callTouch(243,1697);
		delay(5);
		hour.clear();
		hour.sendKeys("10");
		delay(5);
		minute.clear();
		minute.sendKeys("11");
		delay(5);
		btnOK.click();
	}

}
