package com.contactdiary.appium.popup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Mitigation {
	
	protected AndroidDriver driver;
	
	public Mitigation(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
	public WebElement distance;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
	public WebElement maskMe;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[3]")
	public WebElement maskOther;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[4]")
	public WebElement ventilate;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement btnOK;
	
	public void clickBoxDistance() {
		distance.click();
	}
	
	public void clickBoxMaskMe() {
		maskMe.click();
	}
	
	public void clickBoxMaskOther() {
		maskOther.click();
	}
	
	public void clickBoxVentilate() {
		ventilate.click();
	}
	
	public void clickOK() {
		btnOK.click();
	}
	
	
	
	
}
