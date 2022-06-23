package com.contactdiary.appium.utility;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class CallTouch {
	
	protected AndroidDriver driver;
	
	public CallTouch(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void callTouch(int x, int y) {
		TouchAction touchNew = new TouchAction(driver);
		touchNew.tap(PointOption.point(x, y)).perform();
	}
	
	public void callSwipe(int a, int b,int x, int y) {
		TouchAction dateSwipe = new TouchAction(driver);
		dateSwipe.press(PointOption.point(a, b)).moveTo(PointOption.point(x, y)).release().perform();
	}
	
}
