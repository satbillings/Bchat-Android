package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreatePINScreen2 extends ActionsClass {
	AndroidDriver driver;
	public CreatePINScreen2(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(xpath="//android.view.View[@index='9']")
	private WebElement btn_Enter_0;
	
	@AndroidFindBy(xpath="//android.view.View[@index='0']")
	private WebElement btn_Enter_1;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Next']")
	private WebElement btnNext;
	
	//@AndroidFindBy(className ="android.widget.Button")
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement btnOk;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement BackArrow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Verify PIN']")
	private WebElement VerifyPINScreenTitle;
	
	public String getVerifyPINScreenTitle() {
		return VerifyPINScreenTitle.getText();
	}
	
	public void ClickBackArrow () {
		BackArrow.click();	
	}
	
	public void click1() {
		btn_Enter_1.click();
	}

	public void click0() {
		btn_Enter_0.click();
	}
	public void clickOk() {
		btnOk.click();
	}
	
	public void clickNext() {
		btnNext.click();
	}
	public void setPassword_0() {
		
		
		for(int i=0;i<4;i++) {
		btn_Enter_0.click();
	}
		
	}
public void setPassword_1() {
			
				for(int i=0;i<4;i++) {
				btn_Enter_1.click();
			}						
			}	

}
