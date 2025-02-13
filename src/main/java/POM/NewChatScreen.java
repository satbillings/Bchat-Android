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
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New Chat']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement BchatIDOrBNSNameTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='1']")
	private WebElement btnLetsBChat;
	
	@AndroidFindBy(xpath="//android.view.View[@index='0']")
	private WebElement plusicon;
	
	@AndroidFindBy(xpath="//android.view.View[@index='0']")
	private WebElement Newchatoption;
	
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
	
	@AndroidFindBy(accessibility="Photo, November 29, 2024 11:47:43")
	private WebElement validQRcodeimage;
	
	@AndroidFindBy(accessibility="Photo, November 28, 2024 12:36:00")
	private WebElement normalimage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan QR']")
	private WebElement ScanQRscreentitle;
	
	@AndroidFindBy(accessibility="Photo, November 29, 2024 16:47:36")
	private WebElement InvalidQRcodeimage;
	
	
	public String getScanQRScreenTitle() {
		 return ScanQRscreentitle.getText();
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
