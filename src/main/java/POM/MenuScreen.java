package POM;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class MenuScreen extends ActionsClass {
	AndroidDriver driver;
	public MenuScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_settings_title")
	private WebElement pagetitle;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/drawer_profile_name")
	private WebElement profileName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_close_icon")
	private WebElement Closeicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_qrcode_img")
	private WebElement Qrcode;
	
	@AndroidFindBy(id="com.google.android.gm:id/spinner_account_address")
	private WebElement GmailElement;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Account Settings']")
	private WebElement optionAccountSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	private WebElement optionSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Notification']")
	private WebElement optionNotification;
	
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Message Requests']")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='io.beldex.bchat:id/navigation_title' and @text='Message Requests']")
	private WebElement optionMessageRequest;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Recovery Seed']")
	private WebElement optionRecoverySeed;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wallet']")
	private WebElement optionWallet;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Report Issue']")
	private WebElement optionsReportIssue;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Help']")
	private WebElement optionHelp;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Invite']")
	private WebElement optionInvite;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Copy']")
	private WebElement ElementofInviteScreen;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='About']")
	private WebElement optionAbout;
	
	@AndroidFindBy(className="android.widget.Switch")
	private WebElement ThemeChangeButton;
	
	@AndroidFindBy(accessibility ="support beldex, support@beldex.io")
	private WebElement SupportMailId;
	    
	public void LongpressOnHelpOption () {
		 longPress(optionHelp);
		 }
	
	public String getSupportMailId() {
		return SupportMailId.getText();
	}
	
	 public void ClickCloseIcon () {
		 Closeicon.click();
		 }
	
	public String pagetitle() {
	String title =	pagetitle.getText();
	return title;
	}
	
     public void click_My_Account_option () {
		Qrcode.click();
	 }
	
    public String getProfileName () {
		return profileName.getText();	
    }
    public WebElement getElementofGmailScreen () {
		return GmailElement;	
    }
    
    public WebElement getElementofInviteScreen () {
		return ElementofInviteScreen;	
    }
    public void click_Account_Settings () {
    	optionAccountSettings.click();
    }
     
   /*public void Scroll_the_Screen (WebElement Element) {
	   scrollgesture_Using_WebElement(Element);
    	}*/
    
    public String contentAbout () {
		return optionAbout.getText();
    	
    }

    public void click_Notification_option() {
		optionNotification.click();
	}
    
    public void click_option_Wallet () {
    	optionWallet.click();
    }
     
    public void click_option_Settings () {
    	optionSettings.click();
    }
    
    public void ClickThemeChangeButton () {
    	ThemeChangeButton.click();
    }
    
    public void click_option_Message_requests () {
    	optionMessageRequest.click();
    }
    
    public void click_option_Recovery_Seed () {
    	optionRecoverySeed.click();
    }
    public void click_option_Report_Issue () {
    	optionsReportIssue.click();
    }
    public void ClickOptionHelp () {
    	optionHelp.click();
    }
    public void ClickOptionInvite () {
    	optionInvite.click();
    }
}
