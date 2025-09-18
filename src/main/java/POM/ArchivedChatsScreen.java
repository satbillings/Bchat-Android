package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ArchivedChatsScreen extends ActionsClass {
	AndroidDriver driver;
	public ArchivedChatsScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Archived Chats']")
	private WebElement ArchivedChatsScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='io.beldex.bchat:id/title' and @text='Unarchive Chat']")
	private WebElement UnarchiveChatOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='testgroup']")
	private WebElement ArchivedChatsScreenContactorGroup;
	
	public void ClickUnarchiveChatOption() {
		UnarchiveChatOption.click();
	}
	
	public void ClickArchivedChatsScreenContact() {
		ArchivedChatsScreenContactorGroup.click();
	}
	
	
	public String getArchivedChatsScreenTitle() {
   	 return ArchivedChatsScreenTitle.getText();
   }

}
