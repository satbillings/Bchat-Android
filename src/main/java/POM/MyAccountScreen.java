package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyAccountScreen extends ActionsClass {
	AndroidDriver driver;
	public MyAccountScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(id = "io.beldex.bchat:id/title")
	private WebElement pagetitle;
	
	@AndroidFindBy(xpath ="//android.view.View[@index='3']")
	private WebElement bchatidcopyicon;
	
	@AndroidFindBy(xpath ="//android.view.View[@index='6']")
	private WebElement beldexaddresscopyicon;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/share")
	private WebElement shareqrcodebutton;
	
	@AndroidFindBy(id ="android:id/button2")
	private WebElement sharescreencancelbutton;
	
	@AndroidFindBy(id ="miui:id/alertTitle")
	private WebElement sharescreentitle;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/back")
	private WebElement backarrow;
	
	public void ClickBackArrow () {
		backarrow.click();	
	}
	
	public void ClickShareQRButton () {
		shareqrcodebutton.click();	
	}
	
	public void ClickShareScreenCancelButton () {
		sharescreencancelbutton.click();	
	}
	
	public String getShareScreenTitle () {
		return sharescreentitle.getText();
	}
	public void ClickBchatIDCopyIcon () {
		bchatidcopyicon.click();	
	}
	
	public void ClickBeldexAddressCopyIcon () {
		beldexaddresscopyicon.click();	
	}
	
	public String getPageTitle () {
		return pagetitle.getText();
	}
}
