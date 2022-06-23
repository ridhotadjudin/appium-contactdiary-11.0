package com.contactdiary.appium.pom;

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
	
	public void callTouch(int x, int y) {
		TouchAction touchMain = new TouchAction(driver);
		touchMain.tap(PointOption.point(x, y)).perform();
	}
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/fab")
	public WebElement btnUtama;
	
	@AndroidFindBy(id = "//android.widget.TextView")
	public WebElement listMain;
	
	
	public void clickBtnUtama() {
		btnUtama.click();
		System.out.println("Tombol ditekan");
	}
	
	public void clickNewEvent() {
		callTouch(953, 1821);
	}
	
	public void clickNewContact() {
		touch.callTouch(953, 2017);
	}
	
	public boolean getMainEventText() {
		boolean check = true;
		if(listMain.equals(null)){
			check = false;
		}
		return check;
	}
}
