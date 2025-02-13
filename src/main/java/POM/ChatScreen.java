package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ChatScreen extends ActionsClass {
	AndroidDriver driver;
	public ChatScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	//private WebElement profileName; 
	//@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	private WebElement profileNameOrId; 
	
	@AndroidFindBy(id="io.beldex.bchat:id/inputBarEditText")
	//@AndroidFindBy(xpath="//android.widget.EditText[@text='Write a message....']")
	private WebElement messageTextbox;
	
	@AndroidFindBy(accessibility = "Message delivery status")
	private WebElement messageStatus;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Message delivery status\"])[1]")
	private WebElement messagestatusofFirstMessage;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Message delivery status\"])[2]")
	private WebElement messagestatusofSecondMessage;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement sendMessageCard;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_to_home_Btn")
	private WebElement btnbackArrow ;
	
	@AndroidFindBy(id="io.beldex.bchat:id/microphoneOrSendButtonContainer")
	private WebElement btnSend;
	
	@AndroidFindBy(id="io.beldex.bchat:id/acceptMessageRequestButton")
	private WebElement btnAccept;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnAcceptInPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement messageCard;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/bodyTextView\"])[2]")
	private WebElement SecondMessageCard;
	
	@AndroidFindBy(accessibility = "Delete message")
	private WebElement btnDelete;
	
	//@AndroidFindBy(id = "io.beldex.bchat:id/deleteForEveryoneTextView")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete for everyone']")
	private WebElement optionDeleteForEveryone;
	
	//@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Delete']")
	private WebElement btndeleteInpopup;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
	private WebElement btnMoreoptions;
	
	@AndroidFindBy(className = "android.widget.ListView")
	private WebElement moreOptionsList;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/imageButton")
	private WebElement optionGallery;
	
	@AndroidFindBy(id="io.beldex.bchat:id/attachmentsButtonContainer")
	private WebElement btnattachments;
	
	@AndroidFindBy(id="io.beldex.bchat:id/blockedBanner")
	private WebElement Elementblocked;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	private WebElement deletemessagepopupcancelbutton;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	private WebElement chatscreentopbar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='All Media']")
	private WebElement AllMediaTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/no_images")
	private WebElement Allmediaemptyscreenimage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search']")
	private WebElement Searchoption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/search_query")
	private WebElement searchtextbox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchDown")
	private WebElement searchdownarrow;
	
	@AndroidFindBy(id="io.beldex.bchat:id/close_search")
	private WebElement Searchcloseicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/noMatchesFoundTextview")
	private WebElement NoMatchesFoundtext;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add to home screen']")
	private WebElement Addhomescreenoption;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='9']")
	private WebElement homescreenshorcut;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Copy text']")
	private WebElement copytextoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Message details']")
	private WebElement messagedetailsoption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/expirationTimerViewContainer")
	private WebElement messageunselectoption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/menu_context_reply")
	private WebElement replyoption;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']")
	private WebElement replycard;
	
	@AndroidFindBy(id="io.beldex.bchat:id/cameraButton")
	private WebElement cameraicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/camera_capture_button")
	private WebElement cameracaptureicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mediasend_send_button")
	private WebElement mediasendbutton;
	
	@AndroidFindBy(id="io.beldex.bchat:id/connectedStatus")
	private WebElement networkstatus;
	
	@AndroidFindBy(xpath="//androidx.cardview.widget.CardView[@index='2']")
	private WebElement messagecardview;
	
	@AndroidFindBy(xpath="//android.view.View[@index='2']")
	private WebElement cancelbuttoninacceptpopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/declineMessageRequestButton")
	private WebElement Declinebutton;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement DeclineButtonInDeclinePopup;
	
	@AndroidFindBy(xpath="//android.view.View[@index='2']")
	private WebElement cancelbuttonindeclinepopup;
	
	//@AndroidFindBy(id="io.beldex.bchat:id/delete_view")
	@AndroidFindBy(xpath="//androidx.cardview.widget.CardView[@index='1']")
	private WebElement deletevoicemessage;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']")
	private WebElement ElemntsofAttachments;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mute notifications']")
	private WebElement mutenotificationsoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Unmute']")
	private WebElement Unmutenotificationsoption;
	
	@AndroidFindBy(accessibility ="Call")
	private WebElement callicon;
	
	@AndroidFindBy(xpath ="//android.view.View[@index='3']")
	private WebElement Declinebuttoninpopup;
	
	@AndroidFindBy(xpath ="//android.view.View[@index='0']")
	private WebElement Elementofmutenotification;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/settingsDialogBoxButton")
	private WebElement settingsbutton;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement OkButtonInMuteNotificationpopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Block']")
	private WebElement BlockOption;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement YesButtonInBlockPopup;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/unblockButton")
	private WebElement UnblockButton;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement UnblockButtonInUnBlockPopup;
	
	@AndroidFindBy(xpath="//android.view.View[@index='2']")
	private WebElement CancelButtonInUnBlockPopup;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/deleteForMeTextView")
	private WebElement Deleteformeoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Disappearing messages']")
	private WebElement DisappearingMessagesOption;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement OkButtonInPopup;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/menu_expiring_messages")
	private WebElement DisappearingMessageIcon;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/textView")
	private WebElement DisappearingMessageEnableContent;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='You disabled disappearing messages']")
	private WebElement DisappearingMessagesDisableContent;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='5 seconds']")
	private WebElement TimerSelectFive;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='off']")
	private WebElement TimerSelectoff;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement FirstMessageCard;
	
	@AndroidFindBy(id="io.beldex.bchat:id/untrustedView")
	private WebElement Receivemedia;
	
	@AndroidFindBy(id="io.beldex.bchat:id/downloadButton")
	private WebElement downloadmediabutton;
	
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id='io.beldex.bchat:id/expirationTimerViewContainer'])[4]")
	private WebElement VoiceMessage;
	
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id='io.beldex.bchat:id/expirationTimerViewContainer'])[4]")
	private WebElement Image;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Delete message']")
	private WebElement DeleteMessageOption;
	
	@AndroidFindBy(accessibility="end call")
	private WebElement CallEndButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Voice Call']")
	private WebElement CallScreenTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/inChatBDX")
	private WebElement beldexIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/tooltip")
	private WebElement tooltip;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/slideToPayButton")
	private WebElement btnSlideToPay;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement btnOkInPayAsYouChat;
	
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='jnkvg']")
	//private WebElement ReceiveMessage;
	
	public String getCallScreenTitle () {
		return CallScreenTitle.getText();
	}
	
	public void ClickCallEndButton () {
		CallEndButton.click();
	}
	
	public void ClickDeleteImage () {
		longPress(Image);
		btnMoreoptions.click();
		DeleteMessageOption.click();
		Deleteformeoption.click();
	}
	public void ClickDeleteAudioMessage() {
		longPress(VoiceMessage);
		btnMoreoptions.click();
		DeleteMessageOption.click();
		Deleteformeoption.click();
	}
	
	public void DownloadMedia () {
		Receivemedia.click();
		downloadmediabutton.click();
	}
	
	
	public void delete_Send_And_Received_Message () {
		longPress(FirstMessageCard);
		longPress(SecondMessageCard);
		btnDelete.click();
		Deleteformeoption.click();
	}
	
	public void delete_Received_Message () {
		longPress(FirstMessageCard);
		btnDelete.click();
		try{
			btndeleteInpopup.click();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			Deleteformeoption.click();
		}
	}
	
	public void ReplyReceivedMessage (String value) {
		longPress(messageCard);
		replyoption.click();	
		messageTextbox.sendKeys(value);
		btnSend.click();
	}
	
	public String getDisappearingMessageEnableContent () {
		return DisappearingMessageEnableContent.getText();
	}
	
	public String getDisappearingMessagesDisableContent () {
		return DisappearingMessagesDisableContent.getText();
	}
	
	
	public void Disable_Disappearing_message () throws InterruptedException {
		DisappearingMessageIcon.click();
	     Thread.sleep(1000);
	     OkButtonInPopup.click();
	}
	
	public void set_Disappearing_Message () {
		btnMoreoptions.click();
		DisappearingMessagesOption.click();
		//longPress(TimerSelectoff);
		//swipeGesture(950, 2260 , 100, 150, "up");
		//clickGesture(1005, 180);
		//swipeGesture(100, 100, 200, 200, "UP");
		//scroll_the_page(800, 1500, 150, "down");
		//scrollgesture_Using_text("5 seconds");
		scrollgesture_Using_WebElement(TimerSelectoff);
		OkButtonInPopup.click();
	}
	
	public void ClickDeleteForMeOption () {
		Deleteformeoption.click();
	}
	
	
	public void ClickBlockOption () {
		btnMoreoptions.click();
		BlockOption.click();
		YesButtonInBlockPopup.click();
	}
	public void ClickUnBlockOption () {
		UnblockButton.click();
		UnblockButtonInUnBlockPopup.click();
	}
	public void ClickCancelButtonInUnblockPopup () {
		CancelButtonInUnBlockPopup.click();
	}
	
	public void ClickCallIcon () {
		callicon.click();
	}
	
	public void ClickSettingsButton () {
		settingsbutton.click();
	}
	
	
	public void ClickMuteNotificationOption () {
		btnMoreoptions.click();
		mutenotificationsoption.click();	
		OkButtonInMuteNotificationpopup.click();
	}
	public void ClickUnMuteNotificationOption () {
		btnMoreoptions.click();
		Unmutenotificationsoption.click();	
	}
	
	public WebElement getElementOfMuteNotification(){
		return Elementofmutenotification;
	}
	
	public void ClickDecline () {
		Declinebutton.click();	
		DeclineButtonInDeclinePopup.click();
	}
	
	public WebElement getElementOfCallIcon(){
		return callicon;
	}
	
	public void ClickDeleteVoiceMessage () {
		deletevoicemessage.click();	
	}
	
	public WebElement getElementOfAttachment(){
		return ElemntsofAttachments;
	}
	public void ClickCancelInAcceptPopup () {
		btnAccept.click();	
		cancelbuttoninacceptpopup.click();
	}
	
	public void ClickCancelInDeclinePopup () {
		Declinebutton.click();	
		cancelbuttonindeclinepopup.click();
	}
	public WebElement getMessageCardView () {
		return messagecardview;
	}
	
	public String getNetworkStatus () {
		return networkstatus.getText();
	}
	
	public void SendImage () {
		btnattachments.click();	
		cameraicon.click();
		cameracaptureicon.click();
		mediasendbutton.click();
	}
	
	public WebElement ReplyCardView () {
		return replycard;
	}
	
	public void ReplyMessage (String value) {
		longPress(messageCard);
		replyoption.click();	
		messageTextbox.sendKeys(value);
		btnSend.click();
	}
	
	
	public void UnselectMessage () {
		longPress(messageCard);
		messageunselectoption.click();	
	}
	
	public void ClickCopyTextOption () {
		longPress(messageCard);
		btnMoreoptions.click();
		copytextoption.click();	
	}
	public void ClickMessageDetailsOption () {
		longPress(messageCard);
		btnMoreoptions.click();
		messagedetailsoption.click();	
	}
	public String getMessageDetailsScreenTitleText () {
		return messagedetailsoption.getText();
	}
	
	public void ClickHomeScreenShortcut () {
		homescreenshorcut.click();
	}
	
	public void ClickAddtoHomeScreen () {
		btnMoreoptions.click();
		Addhomescreenoption.click();
	}
	
	public String getNoMatchesFoundText () {
		 return NoMatchesFoundtext.getText();
	}
	
	public void ClickSearchCloseIcon () {
		Searchcloseicon.click();
	}
	
	public void Set_Values_In_Search_textbox (String value) {
		   btnMoreoptions.click();
		   Searchoption.click();
		   searchtextbox.sendKeys(value);
		}
	public WebElement Element_Down_arrow () {
		return searchdownarrow;
	}
	public WebElement getMessageStatus () {
		return messageStatus;
	}
	
	public WebElement get_Element_of_Empty_media_Screen () {
		return Allmediaemptyscreenimage;
	}
	
	public void OpenAllMedia () {
		chatscreentopbar.click();
	}
	
	public String get_AllMedia_Title_Text () {
		return AllMediaTitle.getText();
	}
	
	
	public void clickTextBox () {
		messageTextbox.click();
	}
	public void cancelbuttonclick () {
		deletemessagepopupcancelbutton.click();
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
	
	public String get_Second_Message_Value() {
		return SecondMessageCard.getText();
	}
	
	public void Set_Values_In_Message_textbox (String value) {
	   messageTextbox.sendKeys(value);
	}
	
	public void click_Send_Button () {
		btnSend.click();
	}
	
	public String get_profile_NameOr_Id () {
		 return profileNameOrId.getText();
	}
 
	public void click_Accept () {
		btnAccept.click();
		btnAcceptInPopup.click();
	}
	
	public String get_Values_from_TextBox () {
		 return messageTextbox.getText();
	}
	
	public void clear_textBox () {
		messageTextbox.clear();
	}
	
	public void delete_Send_Message () {
		longPress(messageCard);
		btnDelete.click();
		
	}
	public void delete_Second_Message () {
		longPress(SecondMessageCard);
		btnDelete.click();
		
	}
    public void click_DeleteForEveryone () {
		optionDeleteForEveryone.click();
		}
  
	public void click_Textbox () {
		messageTextbox.click();
	}
	
	
	public void paste_values (String value) {
		Copy_And_Paste_Values(value, messageTextbox);
	}

	public void Record_Voice_Msg () {
		longPress(btnSend);
		swipeGesture(950, 2260 , 100, 150, "up");
	}
	
	public WebElement get_Element_of_MoreOptions () {
		return moreOptionsList;
	}
	
	public WebElement get_Element_Gallery () {
		return optionGallery;
	}
	
	public void click_Moreoption () {
		btnMoreoptions.click();
	}
	
	public void click_Attachments () {
		btnattachments.click();
	}
	
	public void click_delete_In_Popup () {
		btndeleteInpopup.click();
	}
	
	public void Send_one_msg () {
		Set_Values_In_Message_textbox("Hii");
		click_Send_Button();
		click_Back_Arrow();
	}
	
	public WebElement Element_of_Blocked_Banner () {
		return Elementblocked;
	}
	public void enable_Pay_as_youChat () {
		longPress(beldexIcon);
		try{
			btnOkInPayAsYouChat.click();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			longPress(beldexIcon);
			btnOkInPayAsYouChat.click();
		}
	
	}
	
	public String tooltip () {
		 return tooltip.getText();
	}
	
	public WebElement Btn_Slide_to_pay () {
		return btnSlideToPay;
	}
}
