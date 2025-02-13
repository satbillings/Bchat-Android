package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;

public class RecoveryPhraseScreen extends ActionsClass {
	AndroidDriver driver;
	public RecoveryPhraseScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/copyButton")
	private WebElement CopyIconButton;
	
	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	private WebElement CotinueButton;
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement TextPageTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_button")
	private WebElement BackButton;
	
	public void BackButtonClick() {
		BackButton.click();
	}
	
	
	public String pageTitle() {
		String PageTitle = TextPageTitle.getText();
		return PageTitle;
	}
	
	public void ClickContinue() {
		CotinueButton.click();
	}
	
	public void clickCopyIcon() {
		CopyIconButton.click();
	}

}
