package com.contactdiary.appium.popup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class Calendar {
	
	protected AndroidDriver driver;
	
	public Calendar(AndroidDriver driver) {
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
	
	public void delay(int input) {
		driver.manage().timeouts().implicitlyWait(input, TimeUnit.SECONDS);
	}
	
	@AndroidFindBy(id = "android:id/date_picker_header_year")
	public WebElement headerYear;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement btnOK;
	
	public void clickDateStart() {
		delay(3);
		headerYear.click();
		headerYear.click();
		delay(3);
		callSwipe(771,956,771,1700);	//swipe
		delay(3);
		callTouch(540, 1047);			//tahun
		delay(3);
		callTouch(737, 1358);			//tanggal
		delay(3);
		btnOK.click();
	}
	
	public void clickDateEnd() {
		delay(3);
//		headerYear.click();
//		headerYear.click();
//		delay(3);
//		callTouch(540, 900);			//tahun
		delay(3);
		callTouch(737, 1458);			//tanggal
		delay(3);
		btnOK.click();
	}
}
