package com.contactdiary.appium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.contactdiary.appium.popup.Calendar;
import com.contactdiary.appium.popup.CalendarView;
import com.contactdiary.appium.popup.Mitigation;
import com.contactdiary.appium.popup.Time;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class EventActivity {
	
	public AndroidDriver driver;
	public Calendar calendar;
//	public CalendarView calendar;
	public Time time;
	public Mitigation mitigation;
	
	public EventActivity(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void callTouch(int x, int y) {
		TouchAction touchEvent = new TouchAction(driver);
		touchEvent.tap(PointOption.point(x, y)).perform();
	}
	
	public void delay(int input) {
		try {
			Thread.sleep(input*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AndroidFindBy(xpath = "//android.widget.TextView")
	public WebElement getHeader;
	
	//element event activity
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventname_input")
	public WebElement inputName;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventplace_input")
	public WebElement inputPlace;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventdate_input")
	public WebElement inStartDate;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventinittime_input")
	public WebElement inStartTime;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/endeventdate_input")	
	public WebElement inEndDate;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventendtime_input")
	public WebElement inEndTime;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_outdoors")
	public WebElement boxOutdoor;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_indoors")
	public WebElement boxIndoor;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventpeople_input" )
	public WebElement inputPeople;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventphone_input" )
	public WebElement inputPhone;
	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventnotes_input" )
	public WebElement inputNote;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[3]" )
	public WebElement btnMitigation;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/okButton_AddEvent")
	public WebElement btnSave;
	
	public void clickStartDate() {
		inStartDate.click();
		
		calendar = new Calendar(driver);
		calendar.clickDateStart();
		
		delay(3);
		inStartTime.click();
		time = new Time(driver);
		time.setTimeStart();
	}
	
	public void clickEndDate() {
		inEndDate.click();
		calendar = new Calendar(driver);
		calendar.clickDateStart();
		delay(3);
		inEndTime.click();
		time = new Time(driver);
		time.setTimeEnd();
	}
	
	public void addEvent(String nama, String place,String people, String phone, String note) {
		inputName.sendKeys(nama);
		inputPlace.sendKeys(place);
		inputPeople.sendKeys(people);
		inputPhone.sendKeys(phone);
		inputNote.sendKeys(note);
	}
	
	public void boxOutdoor() {
		boxOutdoor.click();
	}
	public void boxIndoor() {
		boxIndoor.click();
	}
	
	public void clickMitigation() {
		delay(3);
		btnMitigation.click();
		delay(3);
		mitigation = new Mitigation(driver);
		mitigation.clickBoxDistance();
		mitigation.clickBoxMaskMe();
		mitigation.clickBoxMaskOther();
		mitigation.clickBoxVentilate();
		mitigation.clickOK();
	}
	
	public void save() {
//		callTouch(949,2256);
		btnSave.click();
	}
	
}
