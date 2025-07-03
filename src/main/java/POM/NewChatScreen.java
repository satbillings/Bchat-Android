package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class NewChatScreen extends ActionsClass {
	AndroidDriver driver;
	public NewChatScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement BchatIDOrBNSNameTextBox;
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement SearchTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='1']")
	private WebElement btnLetsBChat;
	
	@AndroidFindBy(xpath="//android.view.View[@index='0']")
	private WebElement plusicon;
	
	//@AndroidFindBy(xpath="//android.view.View[@index='0']")
	@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]")
	private WebElement Newchatoption;
	
	@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[7]/android.view.View[2]/android.widget.Button")
	//@AndroidFindBy(className="android.widget.Button")
	private WebElement Searchoption;
	
	@AndroidFindBy(accessibility ="Back")
	private WebElement BackArrow;
	
	@AndroidFindBy(accessibility ="Navigate up")
	private WebElement ScanQrBackArrow;
	
	@AndroidFindBy(xpath="//android.view.View[@index='4']")
	private WebElement YourChatID;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='1']")
	private WebElement QRcodeoption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/uploadFromGallery_Layout")
	private WebElement uploadfromgalleryoption;
	
	//@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gallery']")
	private WebElement galleryoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search people and groups']")
	private WebElement PlaceHolderOfSearchTextBox;
	
	@AndroidFindBy(accessibility="Photo, November 29, 2024 11:47:43")
	private WebElement validQRcodeimage;
	
	@AndroidFindBy(accessibility="Photo, November 28, 2024 12:36:00")
	private WebElement normalimage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan QR']")
	private WebElement ScanQRscreentitle;
	
	@AndroidFindBy(accessibility="Photo, November 29, 2024 16:47:36")
	private WebElement InvalidQRcodeimage;
	
	@AndroidFindBy(accessibility="clear search text")
	private WebElement SearchCloseIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Invite a Friend']")
	private WebElement optionInviteFriend;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Copy']")
	private WebElement ElementofInviteScreen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='BChat Messenger']")
	private WebElement BchatOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Forward']")
	private WebElement ForwardScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Secret Group']")
	private WebElement SecretGroupOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Social Group']")
	private WebElement SocialGroupOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Note to Self']")
	private WebElement NoteToSelfOption;
	
	@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View[2]")
	private WebElement ContactorGroup;
	
	@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
	private WebElement QRCodeIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='aravind']")
	private WebElement ContactAndGroupList;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
	private WebElement CancelButtonInNewChatPopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New Chat']")
	private WebElement NewChatPopupTitle;
	
	public WebElement getContactAndGroupList() {
		return ContactAndGroupList;
	}
	
	public String getNewChatPopupTitle() {
		return NewChatPopupTitle.getText();
	}

	public void ClickQRCodeIcon() {
		QRCodeIcon.click();
    }
	
	public void ClickCancelButtonInNewChatPopup() {
		CancelButtonInNewChatPopup.click();
    }
	
	public void ClickContactorGroup() {
		ContactorGroup.click();
    }
	
	public void ClickSecretGroupOption() {
		SecretGroupOption.click();
    }
	
	public void ClickSocialGroupOption() {
		SocialGroupOption.click();
    }
	public void ClickNoteToSelfOption() {
		NoteToSelfOption.click();
    }
	
	public String getForwardScreenTitle() {
		return ForwardScreenTitle.getText();
	}
	
	public void InviteToBchat() {
		 BchatOption.click();
		 }
	
	public void ClickOptionInviteFriend() {
		optionInviteFriend.click();
    }
	 public WebElement getElementofInviteScreen () {
			return ElementofInviteScreen;	
	    }
	
	public void ClickCloseIconInSearchTextBox(){
		SearchCloseIcon.click();
		}
	
	public String getScanQRScreenTitle() {
		 return ScanQRscreentitle.getText();
	}
	
	public String getPlaceHolderOfSearchTextBox() {
		 return PlaceHolderOfSearchTextBox.getText();
	}
	
	public void UploadValidQRCode(){
		QRcodeoption.click();
		uploadfromgalleryoption.click();
		galleryoption.click();
		validQRcodeimage.click();
	}
	public void UploadInValidQRCode(){
		QRcodeoption.click();
		uploadfromgalleryoption.click();
		galleryoption.click();
		InvalidQRcodeimage.click();
	}
	
	public void UploadNormalImage(){
		QRcodeoption.click();
		uploadfromgalleryoption.click();
		galleryoption.click();
		normalimage.click();
	}

	public void PasteValuesInTextbox (String value) {
		Copy_And_Paste_Values(value, BchatIDOrBNSNameTextBox);
	}
	public void PasteValuesInSearchTextbox (String value) {
		Copy_And_Paste_Values(value, SearchTextBox);
	}
	
	public void ClearTextbox(){
		BchatIDOrBNSNameTextBox.clear();
		}
	public String get_Values_from_TextBox () {
		 return BchatIDOrBNSNameTextBox.getText();
	}
	
	public void Check_with_Valid_BNS_Name(){
		BchatIDOrBNSNameTextBox.sendKeys("bnstest.bdx");
		btnLetsBChat.click();
	}
	//public void Check_with_Valid_BNS_Name_2(){
	//	BchatIDOrBNSNameTextBox.sendKeys("gcchub.bdx");
	//	btnLetsBChat.click();
	//}
	
	public void Check_with_InValid_BNS_name(){
		BchatIDOrBNSNameTextBox.sendKeys("bd3586.bdx");
		btnLetsBChat.click();
	}
	public void Check_with_empty_space_value(){
		BchatIDOrBNSNameTextBox.sendKeys("   ");
		btnLetsBChat.click();
	}
	public void Check_with_special_characters(){
		BchatIDOrBNSNameTextBox.sendKeys("@#$%*.bdx");
		btnLetsBChat.click();
	}
	public void Check_with_InValid_BNS_name_without_bdx(){
		BchatIDOrBNSNameTextBox.sendKeys("test");
		btnLetsBChat.click();
	}
	public void Check_with_InValid_Bchat_ID(){
		BchatIDOrBNSNameTextBox.sendKeys("bd358637121dd13b56aaea9bd13cbac223a2ddd9ef4ad60a87411a09f4804b3a");
		btnLetsBChat.click();
	}
	
	public void ClickLetsBchatButton () {
		btnLetsBChat.click();
	}
	
	public void OpenNewChat () {
		plusicon.click();
		Newchatoption.click();
	}
	public void OpenAndCloseSearchOption () {
		plusicon.click();
		Searchoption.click();
		Searchoption.click();
	}
	
	public void ClickSearchIcon () {
		Searchoption.click();
	}
	
	public void ClickNewChatOption () {
		Newchatoption.click();
	}
	
	public void EnterSearchValue(String value) {
		//SearchTextBox.click();
		SearchTextBox.sendKeys(value);
	}
	public void EnterTextInSearchTextBox(){
		SearchTextBox.sendKeys("bd3586");
	}
	public void ClickSearchTextBox () {
		SearchTextBox.click();
	}
	public void ClearSearchTextBox () {
		SearchTextBox.clear();
	}
	
	public void EnterValuesInBchatIDOrBNSNameTextBox(String value) {
		BchatIDOrBNSNameTextBox.sendKeys(value);
	}
	public void PasteValuesInBchatIDOrBNSNameTextBox (String value) {
		Copy_And_Paste_Values(value, BchatIDOrBNSNameTextBox);
	}
	public void ClickBchatIDOrBNSNameTextBox () {
		BchatIDOrBNSNameTextBox.click();
	}
	public void ClearBchatIDOrBNSNameTextBox () {
		BchatIDOrBNSNameTextBox.clear();
	}
	
	public String getValuesFromBchatIDOrBNSNameTextBox() {
		return BchatIDOrBNSNameTextBox.getText();
		
	}
	
	public String getValuesFromSearchTextBox() {
		return SearchTextBox.getText();
		
	}
	

	public void EnterValidTextInSearchTextBox(){
		SearchTextBox.sendKeys("Aravind");
	}
	
	public void ClickBackArrow () {
		BackArrow.click();
	}
	public void ClickScanQRBackArrow () {
		ScanQrBackArrow.click();
	}
	public void ClickChatID () {
		YourChatID.click();
	}
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}

	public void Check_with_ValidId_1 () {
		BchatIDOrBNSNameTextBox.sendKeys("bd358637121dd13b56aaea9bd13cbac223a2ddd9ef4ad60a87411a09f4804b3a24");
		btnLetsBChat.click();
	}
	
	public void Check_with_ValidId_2 () {
		BchatIDOrBNSNameTextBox.sendKeys("bdd01e84c363afbe4d1bb88e6b2028316d9acd422b6ae3f08c520f2642272d8014");
		btnLetsBChat.click();
	}

}
