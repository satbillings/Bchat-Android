package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DisplayNameScreen extends ActionsClass {
	AndroidDriver driver;
	public DisplayNameScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(id="io.beldex.bchat:id/displayNameEditText")
	public WebElement TxtBoxDisplayName;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"io.beldex.bchat:id/registerButton\"]")
	private WebElement ContinueButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint='Enter a display name']")
	private WebElement ElementPlacholder;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement textPageTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_button")
	private WebElement BackArrow;
	
	public void clickBackArrow() {
		super.click(BackArrow);
	}
	public String setDisplayName(String displayname) {
		TxtBoxDisplayName.click();
		TxtBoxDisplayName.sendKeys(displayname);
	    //super.Send_keys(txtboxDisplayName, displayname);	
		return displayname;
	}

	
	public void clickContinue() {
		super.click(ContinueButton);
	}
	public void clickTextBox() {
		TxtBoxDisplayName.click();
	}
	
	public WebElement textboxWebElement() {
		WebElement element = TxtBoxDisplayName;
		return element;
	}
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	public void cleardisplayname() {
		TxtBoxDisplayName.clear();
	}
	
   public void pasteDisplayName(String DisplayName) {
	  // txtboxDisplayName.
	   Copy_And_Paste_Values(DisplayName, TxtBoxDisplayName);
	   
   }
   
   public  String gettextvalue() {
	   String Displayname=TxtBoxDisplayName.getText();
	   return Displayname;
   }
   
	public String NameTextBoxPlachoder() {
		
		String text = ElementPlacholder.getText();
		return text;
	}
	/*public  String ToastMessage() {
		  return super.Toast();
	   }*/
}
