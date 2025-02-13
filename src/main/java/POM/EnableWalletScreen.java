package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnableWalletScreen extends ActionsClass {
	AndroidDriver driver;
	public EnableWalletScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Wallet']")
	private WebElement WalletOption;
	
	@AndroidFindBy(xpath ="//android.widget.CheckBox")
	private WebElement EnableWalletCheckBox;
	
	@AndroidFindBy(xpath ="//android.view.View[@index='10']")
	private WebElement EnableWalletButton;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Wallet']")
	private WebElement EnableWalletScreenTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Create PIN']")
	private WebElement CreatePinScreentitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify PIN']")
	private WebElement VerifyPinScreentitle;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement BackArrow;
	
	public void ClickEnableWalletCheckBox () {
		EnableWalletCheckBox.click();	
	}
	public void ClickBackArrow () {
		BackArrow.click();	
	}
	
	public void ClickEnableWalletButton () {
		EnableWalletButton.click();	
	}
	public WebElement ElementofEnableWalletButton() {
		return EnableWalletButton;
	}
	
	public String getEnableWalletScreenTitle() {
		return EnableWalletScreenTitle.getText();
	}
	
	public String getCreatePinScreenTitle() {
		return CreatePinScreentitle.getText();
	}
}
