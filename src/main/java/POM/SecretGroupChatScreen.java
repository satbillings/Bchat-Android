package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SecretGroupChatScreen extends ActionsClass{
	AndroidDriver driver;
	public SecretGroupChatScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(accessibility="More options")
	public WebElement MoreOption;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='4']")
	public WebElement EditGroupOption;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='5']")
	public WebElement LeaveGroupOption;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='6']")
	public WebElement NotificationSettingsOption;
	
	//@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']")
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='io.beldex.bchat:id/actionIndicatorImageView']")
	public WebElement RemovableContact;
	
	@AndroidFindBy(id="io.beldex.bchat:id/removeFromGroup")
	public WebElement RemoveUserFromGroupOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	public WebElement GroupChatTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/applyChangesBtn")
	public WebElement ApplyChangesButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='You removed Testapk from the group']")
	public WebElement RemovedMemberContent;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='You added Testapk to the group']")
	public WebElement AddedMemberContent;
	
	@AndroidFindBy(accessibility="Apply")
	public WebElement ApplyOption;
	
	//@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']")
	//@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='io.beldex.bchat:id/actionIndicatorImageView']")
	@AndroidFindBy(id="io.beldex.bchat:id/contentView")
	public WebElement ContactList;
	
	@AndroidFindBy(id="io.beldex.bchat:id/addButton")
	public WebElement AddButton;
	
	@AndroidFindBy(id="io.beldex.bchat:id/lblGroupNameEditImageview")
	public WebElement GroupNameEditIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/edtGroupName")
	public WebElement GroupNameEditTextBox;
	
	@AndroidFindBy(accessibility="Navigate up")
	public WebElement CloseIconInEditGroupScreen;
	
	@AndroidFindBy(id="io.beldex.bchat:id/btnSaveGroupNameEdit")
	public WebElement TickIcon;
	
	@AndroidFindBy(xpath="//android.view.View[@index='2']")
	public WebElement CancelButtonInLeavePopup;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	public WebElement LeaveButtonInLeavePopup;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='1']")
	public WebElement CloseIconInNotificationSettingsPopup;
	
	@AndroidFindBy(xpath="//android.view.View[@index='0']")
	public WebElement AllOptionInNotificationSettingsPopup;
	
	@AndroidFindBy(xpath="//android.view.View[@index='1']")
	public WebElement MentionsOptionInNotificationSettingsPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_to_home_Btn")
	public WebElement BackArrow;
	
	@AndroidFindBy(id="io.beldex.bchat:id/inputBarEditText")
	private WebElement messageTextbox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/attachmentsButtonContainer")
	private WebElement btnattachments;
	
	@AndroidFindBy(id="io.beldex.bchat:id/microphoneOrSendButtonContainer")
	private WebElement btnSend;
	
	@AndroidFindBy(accessibility = "Message delivery status")
	private WebElement MessageStatus;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement messageCard;
	
	@AndroidFindBy(accessibility = "Delete message")
	private WebElement btnDelete;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete for everyone']")
	private WebElement optionDeleteForEveryone;
	
	@AndroidFindBy(xpath = "io.beldex.bchat:id/deleteForMeTextView")
	private WebElement OptionDeleteForMe;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Delete']")
	private WebElement btndeleteInpopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/cameraButton")
	private WebElement cameraicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/camera_capture_button")
	private WebElement cameracaptureicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mediasend_send_button")
	private WebElement mediasendbutton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter a new group name']")
	private WebElement GroupNamePlaceHolder;
	
	@AndroidFindBy(id="io.beldex.bchat:id/noLongerParticipantTextView")
	private WebElement LeaveGroupContent;
	
	 public WebElement getLeaveGroupContent() {
			return LeaveGroupContent;
		}
	
	public void LeaveGroup() {
		MoreOption.click();
		LeaveGroupOption.click();
		LeaveButtonInLeavePopup.click();
		}
	
	public void ClearGroupNameText() {
	MoreOption.click();
	EditGroupOption.click();
	GroupNameEditIcon.click();
	GroupNameEditTextBox.clear();
	}
	
	 public String getGroupNamePlaceHolder() {
			return GroupNamePlaceHolder.getText();
		}
	
	public void ClickApplyChangesButton () {
		ApplyChangesButton.click();	
	}
	
	public void SendImage () {
		btnattachments.click();	
		cameraicon.click();
		cameracaptureicon.click();
		mediasendbutton.click();
	}
	
	public void delete_Send_Message () {
		longPress(messageCard);
		btnDelete.click();
		OptionDeleteForMe.click();
		//btndeleteInpopup.click();
	}
    public void click_DeleteForEveryone () {
		optionDeleteForEveryone.click();
		}
	
	public WebElement getMessageStatus() {
		return MessageStatus;
	}
	
	public void ClickSendButton() {
		btnSend.click();
	}
	
	public void Record_Voice_Msg () {
		longPress(btnSend);
		swipeGesture(950, 2260 , 100, 150, "up");
	}
	
	public void Set_Values_In_Message_textbox (String value) {
		   messageTextbox.sendKeys(value);
		}
	
	public void ClickBackArrow() {
		BackArrow.click();
	}
	public void SetAllOptionInNotificationSettingsPopup() {
		MoreOption.click();
		NotificationSettingsOption.click();
		AllOptionInNotificationSettingsPopup.click();
	}
	public void SetMentionsOptionInNotificationSettingsPopup() {
		MoreOption.click();
		NotificationSettingsOption.click();
		MentionsOptionInNotificationSettingsPopup.click();
	}
	public void ClickCancelButtonInLeaveGroupPopup() {
		MoreOption.click();
		LeaveGroupOption.click();
		CancelButtonInLeavePopup.click();
	}
	
	public void ClickCloseIconInNotificationSettingsPopup() {
		MoreOption.click();
		NotificationSettingsOption.click();
		CloseIconInNotificationSettingsPopup.click();
	}
	
	public void ClickCloseIconInEditGroupcreen() {
		MoreOption.click();
		EditGroupOption.click();
		CloseIconInEditGroupScreen.click();
	}
	
	
	public void ChangeGroupName (String value) {
		MoreOption.click();
		EditGroupOption.click();
		GroupNameEditIcon.click();
		GroupNameEditTextBox.sendKeys(value);
		TickIcon.click();
		ApplyChangesButton.click();
		}
	
	
	 public String getRemovedMemberContent() {
			return RemovedMemberContent.getText();
		}
	 
	 public String getAddedMemberContent() {
			return AddedMemberContent.getText();
		}
	
	
    public String getGroupChatTitle() {
		return GroupChatTitle.getText();
	}

	public void RemoveMemberFromGroup() {
		MoreOption.click();
		EditGroupOption.click();
		RemovableContact.click();
		RemoveUserFromGroupOption.click();
		ApplyChangesButton.click();
	}
	public void AddMemberToGroup() {
		MoreOption.click();
		EditGroupOption.click();
		ApplyOption.click();
		ContactList.click();
		AddButton.click();
		ApplyChangesButton.click();
	}
}
