package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class NoteToSelfChatScreen extends ActionsClass {
	AndroidDriver driver;
	public NoteToSelfChatScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	private WebElement pageTitle; 
	
	@AndroidFindBy(id="io.beldex.bchat:id/inputBarEditText")
	private WebElement messageTextbox;
	
	@AndroidFindBy(accessibility = "Message delivery status")
	private WebElement messageStatus;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement sendMessageCard;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_to_home_Btn")
	private WebElement btnbackArrow ;
	
	@AndroidFindBy(accessibility ="Media message")
	private WebElement linkPreview;
	
	@AndroidFindBy(id="io.beldex.bchat:id/microphoneOrSendButtonContainer")
	private WebElement btnSend;
	
	@AndroidFindBy(accessibility = "Delete message")
	private WebElement DeleteButton;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/deleteForMeTextView")
	private WebElement optionDeleteForMe;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Delete']")
	private WebElement DeleteButtonInPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement messageCard;
	
	public void Delete_Link() {
		longPress(linkPreview);
		DeleteButton.click();
		DeleteButtonInPopup.click();	
	}
	
	public void click_send_Button () {
		btnSend.click();
	}
	public void clickTextBox () {
		messageTextbox.click();
	}
	public void click_Back_Arrow () {
		btnbackArrow.click();
	}
	
	public WebElement SendMessageCard () {
		return messageStatus;
	}
	
	public String get_Send_Message_Value () {
		return sendMessageCard.getText();
	}
	
	
	public void Set_Values_In_Message_textbox (String value) {
	   messageTextbox.sendKeys(value);
	}
	
	public WebElement Link_Preview () {
		return linkPreview;
	}

}
