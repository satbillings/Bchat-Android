package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatScreen;
import POM.CreatePINScreen;
import POM.CreatePINScreen2;
import POM.CreatePasswordScreen;
import POM.CreateSecretGroupScreen;
import POM.DisplayNameScreen;
import POM.EnableWalletScreen;
import POM.HomeScreen;
import POM.JoinSocialGroupScreen;
import POM.MenuScreen;
import POM.MyAccountScreen;
import POM.NewChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class New_Chat_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	DisplayNameScreen displaynamepage;
	RegisterScreen registerpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	NewChatScreen newchatpage;
	ChatScreen chatpage;
	MyAccountScreen myaccountpage;
	SeedScreen Seedpage;
	RestoreFromSeedScreen restorefromseedpage;
	CreateSecretGroupScreen createsecretgrouppage;
	JoinSocialGroupScreen joinsocialgrouppage;
	WebDriverWait wait;

	@Test(priority = 0)
	public void PreSetup() throws InterruptedException {
		/*
		 * wait = new WebDriverWait(driver, Duration.ofSeconds(10)); Openingpage = new
		 * OpeningPage(driver); Openingpage.clickCreateAccount(); displaynamepage = new
		 * DisplayNameScreen(driver); Assert.assertEquals(displaynamepage.pageTitle(),
		 * "Display Name"); displaynamepage.setDisplayName("Sat");
		 * displaynamepage.clickContinue(); registerpage = new RegisterScreen(driver);
		 * wait.until(ExpectedConditions.visibilityOf(registerpage.TextPageTitle));
		 * Assert.assertEquals(registerpage.pageTitle(), "Register"); // wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(20)); Thread.sleep(20000);
		 * registerpage.clickNext(); createpasswordpage = new
		 * CreatePasswordScreen(driver);
		 * Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		 * createpasswordpage.setValidPassword(); // createpasswordpage.clickOk();
		 * createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		 * recoveryphrasepage = new RecoveryPhraseScreen(driver);
		 * Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		 * recoveryphrasepage.clickCopyIcon(); recoveryphrasepage.ClickContinue();
		 * Thread.sleep(5000); homepage = new HomeScreen(driver);
		 * Assert.assertEquals(homepage.Pagetitle(), "Chats"); homepage.OpenNewScreen();
		 */

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Openingpage = new OpeningPage(driver);
		Openingpage.clickSignIn();
		Seedpage = new SeedScreen(driver);
		Assert.assertTrue(Seedpage.SeedTextBox().isDisplayed());
		Seedpage.pasteSeedValue();
		Seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedScreen(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.paste_Value_In_DisplayName("Sathish");
		restorefromseedpage.paste_Value_In_Blockheight("4000000");
		restorefromseedpage.clickBtnRestore();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		createpasswordpage.setValidPassword();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		// Thread.sleep(10000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "Chats");
		// restrictNotification();
		Thread.sleep(59000);
		homepage.OpenNewScreen();

	}
	/*
	 * Validate whether able to navigate back to the home screen from new chat
	 * screen
	 */

	
	  @Test(priority = 1) public void
	  To_Validate_whether_able_to_navigate_back_to_home_screen_from_new_chat_screen
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.ClickBackArrow(); homepage = new HomeScreen(driver);
	  Assert.assertEquals(homepage.Pagetitle(),"BChat"); homepage.OpenNewChat(); 
	  }
	  
	/*  Validate the working of your bchat id option in the new chat screen */
	  
	  
	  @Test(priority = 2) public void
	  To_Validate_the_working_of_your_bchatId_option_in_new_chat_screen () {
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.ClickChatID(); myaccountpage = new MyAccountScreen(driver);
	  Assert.assertEquals(myaccountpage.getPageTitle(),"My Account"); }
	  
	  
	  /*Validate whether able to copy BChat id and beldex address*/
	  
	  
	  @Test(priority = 3) public void
	  To_validate_whether_able_to_copy_BChatId_and_beldexAddress_in_my_account_screen
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.ClickChatID(); myaccountpage =new MyAccountScreen(driver);
	  Assert.assertEquals(myaccountpage.getPageTitle(),"My Account");
	  myaccountpage.ClickBchatIDCopyIcon(); Assert.assertEquals(Toast(),
	  "Copied to clip board"); myaccountpage.ClickBeldexAddressCopyIcon();
	  Assert.assertEquals(Toast(), "Copied to clip board"); }
	  
	  /*Validate the working of the share button QR code Functionality*/
	  
	  
	  @Test(priority = 4) public void
	  To_Validate_Working_of_Share_QR_code_functionality_in_my_account_screen () {
	  myaccountpage =new MyAccountScreen(driver);
	  Assert.assertEquals(myaccountpage.getPageTitle(),"My Account");
	  //myaccountpage.scroll_the_page(450, 1400, 100, "down");
	  myaccountpage.ClickShareQRButton();
	  Assert.assertEquals(myaccountpage.getShareScreenTitle(),"Share QR Code");
	  myaccountpage.ClickShareScreenCancelButton();;
	  Assert.assertEquals(myaccountpage.getPageTitle(),"My Account");
	  myaccountpage.ClickBackArrow(); }
	  
	  /*Validate Whether Let's Bchat button is enable without enter a value in the
	  Enter BChat ID field in the new chat screen.*/
	  
	  @Test(priority = 5) public void
	  To_Validate_Whether_Lets_Bchat_button_is_enable_without_enter_a_value_in_BChatID_field_in_the_new_chat_screen
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.ClickLetsBchatButton();
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat"); }
	  
	  /*Validate the New Chat by entering a Invalid BChat ID in the new chat screen*/
	  
	  @Test(priority = 6) public void
	  To_Validate_the_NewChat_by_entering_a_Invalid_BChat_ID_in_the_new_chat_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.Check_with_InValid_Bchat_ID(); wait = new
	  WebDriverWait(driver,Duration.ofSeconds(10)); Assert.assertEquals(Toast(),
	  "Please check the BChat ID or BNS name and try again.");
	  //Thread.sleep(5000); }
	  
	  /*Validate the New Chat by entering a Invalid BNS name in the new chat screen.*/
	  
	 /* @Test(priority = 7) public void
	  To_Validate_the_NewChat_by_entering_a_Invalid_BNS_name_in_the_new_chat_screen
	  () throws InterruptedException { 
		  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.Check_with_InValid_BNS_name(); wait = new
	  WebDriverWait(driver,Duration.ofSeconds(10)); Assert.assertEquals(Toast(),
	  "Please check the BChat ID or BNS name and try again.");
	  //Thread.sleep(5000); 
	  }
	  
	  /*Validate the New Chat by entering a Invalid BNS name without .bdx in the new
	  chat screen.*/
	  
	  @Test(priority = 8) public void
	  To_Validate_the_NewChat_by_entering_a_Invalid_BNS_name_without_bdx_in_the_new_chat_screen
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.Check_with_InValid_BNS_name_without_bdx(); wait = new
	  WebDriverWait(driver, Duration.ofSeconds(20)); Assert.assertEquals(Toast(),
	  "Please check the BChat ID or BNS name and try again."); }
	  
	 /* Validate the new chat with empty space value in the new chat screen */
	  
	  @Test(priority = 9) public void
	  To_validate_the_new_chat_with_empty_space_value_in_the_new_chat_screen () {
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.Check_with_empty_space_value(); wait = new WebDriverWait(driver,
	  Duration.ofSeconds(20)); Assert.assertEquals(Toast(),
	  "Please check the BChat ID or BNS name and try again."); }
	  
	  /*Validate the new chat with special characters in the new chat screen*/
	  
	  
	  @Test(priority = 10) public void
	  To_validate_the_new_chat_with_special_characters_in_the_new_chat_screen () {
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat"); wait = new
	  WebDriverWait(driver, Duration.ofSeconds(5));
	  newchatpage.Check_with_special_characters(); wait = new
	  WebDriverWait(driver,Duration.ofSeconds(20)); Assert.assertEquals(Toast(),
	  "Please check the BChat ID or BNS name and try again."); }
	  
	 /* Validate the new chat function without internet connection in the new chat
	  screen*/
	  
	  @Test(priority = 11) public void
	  To_validate_the_new_chat_function_without_internet_connection_in_the_new_chat_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  turnOff_Mobile_Wifi(); Thread.sleep(5000);
	  newchatpage.Check_with_Valid_BNS_Name();
	  Assert.assertEquals(Toast(),"Please check your internet connection");
	  newchatpage.ClearTextbox(); newchatpage.Check_with_ValidId_1();
	  Assert.assertEquals(Toast(),"Please check your internet connection");
	  turnOn_Mobile_Wifi(); newchatpage.ClearTextbox(); }
	  
	  /*Validate whether able to paste values in the text box in the new chat screen.*/
	  
	  @Test(priority = 12) public void
	  To_validate_whether_able_to_paste_values_in_text_box_in_the_new_chat_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.PasteValuesInTextbox("Bnstest.bdx");
	  Assert.assertEquals(newchatpage.get_Values_from_TextBox(), "Bnstest.bdx");
	  newchatpage.ClearTextbox(); newchatpage.PasteValuesInTextbox(
	  "bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
	  Assert.assertEquals(newchatpage.get_Values_from_TextBox(),
	  "bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
	  newchatpage.ClearTextbox(); }
	  
	  /*Validate the New Chat by entering a valid BChat ID in the new chat screen.*/
	  
	  @Test(priority = 13) public void
	  To_Validate_the_New_Chat_by_entering_a_valid_BChat_ID_in_the_new_chat_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.Check_with_ValidId_1(); wait = new WebDriverWait(driver,
	  Duration.ofSeconds(20)); chatpage = new ChatScreen(driver);
	  Assert.assertEquals(chatpage.get_profile_NameOr_Id(),
	  "Bd358637121dd13b56aaea9bd13cbac223a2ddd9ef4ad60a87411a09f4804b3a24");
	  chatpage.click_Back_Arrow();
	  Assert.assertEquals(homepage.Pagetitle(),"BChat"); homepage.OpenNewChat();
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat"); }
	  
	 /* Validate the New Chat by entering a valid BNS name in the new chat screen.*/
	  
	  @Test(priority = 14) public void
	  To_Validate_the_New_Chat_by_entering_a_valid_BNS_name_in_the_new_chat_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.Check_with_Valid_BNS_Name(); wait = new WebDriverWait(driver,
	  Duration.ofSeconds(20)); chatpage = new ChatScreen(driver);
	  Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bnstest.bdx");
	  chatpage.click_Back_Arrow();
	  Assert.assertEquals(homepage.Pagetitle(),"BChat"); homepage.OpenNewChat();
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat"); }
	  
	  /*Validate the working of upload from gallery option with valid QR code image.*/
	  
	  @Test(priority = 15) public void
	  To_Validate_the_working_of_upload_from_gallery_option_with_valid_QR_code_image
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.UploadValidQRCode(); chatpage = new ChatScreen(driver);
	  Assert.assertEquals(chatpage.get_profile_NameOr_Id(),
	  "Bddc02ccce9664b29d3abdeb16da109d74e5ed75bec7b2f4e1eae14155bdf03614");
	  chatpage.click_Back_Arrow();
	  Assert.assertEquals(homepage.Pagetitle(),"BChat"); homepage.OpenNewChat();
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat"); }
	  
	  /*Validate the working of upload from gallery option with normal QR code image.*/
	  
	  @Test(priority = 16) public void
	  To_validate_the_working_of_upload_from_gallery_option_with_normal_QR_code_image
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.UploadNormalImage(); Assert.assertEquals(Toast(),
	  "Unable to recognized a valid code from uploaded image");
	  Assert.assertEquals(newchatpage.getScanQRScreenTitle(),"Scan QR");
	  newchatpage.ClickScanQRBackArrow(); }
	  
	  
	  /*Validate the working of upload from gallery option with invalid QR code
	  image.*/
	  
	  @Test(priority = 17) public void
	  To_validate_the_working_of_upload_from_gallery_option_with_invalid_QR_code_image
	  () { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	  newchatpage.UploadInValidQRCode();
	  Assert.assertEquals(Toast(),"An error occurred.");
	  Assert.assertEquals(newchatpage.getScanQRScreenTitle(),"Scan QR");
	  newchatpage.ClickScanQRBackArrow(); }
	  
	  /*New screen latest design*/
	  
	 /* Validate the working of close icon in search text box in new screen*/
	  
	  @Test(priority = 18) public void
	  To_validate_the_working_of_close_icon_in_search_textbox_in_new_Screen() {
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchIcon();
	  Assert.assertEquals(newchatpage.getPlaceHolderOfSearchTextBox()
	  ,"Search people and groups"); newchatpage.EnterSearchValue("sat123");
	  newchatpage.ClickCloseIconInSearchTextBox(); }
	  
	 /* Validate whether the search option is able to open and close in new screen*/
	  
	  @Test(priority = 19) public void
	  To_validate_whether_the_search_option_is_able_to_open_and_close_in_new_screen
	  (){ newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.OpenAndCloseSearchOption();
	  
	  }
	  
	 /* Validate the presence of placeholder in search text box on the new screen*/
	  
	  @Test(priority = 20) public void
	  To_validate_the_presence_of_placeholder_in_search_textbox_on_the_new_screen()
	  { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchIcon();
	  Assert.assertEquals(newchatpage.getPlaceHolderOfSearchTextBox()
	  ,"Search people and groups"); }
	  
	 /* Validate the cursor blink in search text box on the new screen*/
	  
	  @Test(priority = 21) public void
	  To_validate_the_cursor_blink_in_search_textbox_on_the_new_screen() {
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchTextBox();
	  Assert.assertTrue(newchatpage.activeElement().isDisplayed()); }
	  
	  /*Validate the search text box in new screen by entering the valid value*/
	  
	  @Test(priority = 22) public void
	  To_validate_the_search_textbox_in_new_Screen_by_entering_the_valid_value()
	  throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.EnterSearchValue("Aravind"); driver.navigate().back();
	  Thread.sleep(3000); newchatpage.ClearSearchTextBox(); }
	  
	 /* Validate the search text box in new screen by entering the special character
	  Validate whether the value entered in the search text box of new screen is
	  editable and delete-able.*/
	  
	  
	  @Test(priority = 23) public void
	  To_validate_the_search_textbox_in_new_Screen_by_entering_the_special_character_And_To_validate_whether_the_value_entered_in_the_search_textbox_of_new_screen_is_editable_and_deleteable
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchTextBox(); newchatpage.EnterSearchValue("!@#$%^&*()");
	  driver.navigate().back(); Thread.sleep(3000);
	  newchatpage.ClearSearchTextBox(); } 
	  
	  /*Validate the search text box in new screen by entering the space value*/
	  
	  @Test(priority = 24) public void
	  To_validate_the_search_textbox_in_new_Screen_by_entering_the_space_value()
	  throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchTextBox(); newchatpage.EnterSearchValue("    ");
	  driver.navigate().back(); Thread.sleep(3000);
	  newchatpage.ClearSearchTextBox(); }
	  
	  /*Validate the search text box in new screen by entering the numerical value*/
	  
	  @Test(priority = 25) public void
	  To_validate_the_search_textbox_in_new_Screen_by_entering_the_numerical_value(
	  ) throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchIcon(); newchatpage.ClickSearchTextBox();
	  newchatpage.EnterSearchValue("1234567890"); driver.navigate().back();
	  Thread.sleep(3000); newchatpage.ClearSearchTextBox(); }
	  
	 /* Validate the search text box in new screen by entering the alphabets both in
	  upper case and lower case*/
	  
	  @Test(priority = 26) public void
	  To_validate_the_search_textbox_in_new_Screen_by_entering_the_alphabets_both_in_uppercase_and_lowercase
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchTextBox(); newchatpage.EnterSearchValue("ABCDEFGH");
	  driver.navigate().back(); Thread.sleep(3000);
	  newchatpage.ClearSearchTextBox(); newchatpage.ClickSearchTextBox();
	  newchatpage.EnterSearchValue("abcdefgh"); newchatpage.ClearSearchTextBox(); }
	  
	 /* Validate whether the paste option is working on the search text box in new
	  screen.*/
	  
	  @Test(priority = 27) public void
	  To_validate_whether_paste_option_is_working_on_the_search_textbox_in_new_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchTextBox();
	  newchatpage.PasteValuesInSearchTextbox("Hello"); driver.navigate().back();
	  Thread.sleep(3000); newchatpage.ClearSearchTextBox(); }
	  
	  /*Validate whether the user is able enter a lengthy value in the search text
	  box in new screen*/
	  
	  @Test(priority = 28) public void
	  To_Validate_whether_the_user_is_able_to_enter_a_lengthy_value_in_search_textbox_in_new_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSearchTextBox(); newchatpage.
	  EnterSearchValue("Hii hello are you there to here that in the message and ok then now its ok mm hmm ok "
	  ); driver.navigate().back(); Thread.sleep(3000);
	  newchatpage.ClearSearchTextBox(); }
	  
	  /*Validate whether the user is able to navigate back to the home screen from
	  invite friend screen.*/
	  
	  @Test(priority = 29) public void
	  To_validate_whether_the_user_is_able_to_navigate_back_to_the_home_screen_from_invite_friend_screen
	  () throws InterruptedException { newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickOptionInviteFriend();
	  Assert.assertTrue(newchatpage.getElementofInviteScreen().isDisplayed());
	  Thread.sleep(3000); driver.navigate().back(); }
	  
	 /* Validate the working of the Invite friend functionality in new screen.*/
	  
	  @Test(priority = 30) public void
	  To_validate_whether_the_working_of_the_invite_friend_functionality_in_new_screen
	  () { homepage = new HomeScreen(driver);
	  Assert.assertEquals(homepage.Pagetitle(), "Chats"); homepage.OpenNewScreen();
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickOptionInviteFriend();
	  Assert.assertTrue(newchatpage.getElementofInviteScreen().isDisplayed());
	  //newchatpage.swipeGesture(100, 100, 200, 200, "left");
	  newchatpage.InviteToBchat();
	  Assert.assertEquals(newchatpage.getForwardScreenTitle(),"Forward");
	  driver.navigate().back(); }
	  
	  /*Validate whether the user is able to navigate to secret group screen by
	  clicking the secret group option in new screen*/
	  
	  @Test(priority = 31) public void
	  To_validate_whether_the_user_is_able_to_navigate_to_secret_group_screen_by_clicking_the_secret_group_option_in_new_screen
	  () { homepage = new HomeScreen(driver);
	  Assert.assertEquals(homepage.Pagetitle(), "Chats"); homepage.OpenNewScreen();
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSecretGroupOption(); createsecretgrouppage = new
	  CreateSecretGroupScreen(driver);
	  Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	  createsecretgrouppage.ClickBackArrow(); }
	  
	  /*Validate whether the user is able to navigate to social group screen by
	  clicking the social group option in new screen*/
	  
	  @Test(priority = 32) public void
	  To_validate_whether_the_user_is_able_to_navigate_to_social_group_screen_by_clicking_the_social_group_option_in_new_screen
	  () { homepage = new HomeScreen(driver);
	  Assert.assertEquals(homepage.Pagetitle(), "Chats"); homepage.OpenNewScreen();
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickSocialGroupOption(); joinsocialgrouppage = new
	  JoinSocialGroupScreen(driver);
	  Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(),
	  "Social Group"); joinsocialgrouppage.ClickBackArrow(); }
	  
	  /*Validate whether the user is able to navigate to Note to self chat screen by
	  clicking the Note to Self option in new screen*/
	  
	  @Test(priority = 33) public void
	  To_validate_whether_the_user_is_able_to_navigate_to_Note_to_Self_chat_screen_by_clicking_the_Note_to_Self_option_in_new_screen
	  () { homepage = new HomeScreen(driver);
	  Assert.assertEquals(homepage.Pagetitle(), "Chats"); homepage.OpenNewScreen();
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickNoteToSelfOption(); chatpage = new ChatScreen(driver);
	  Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	  chatpage.click_Back_Arrow(); } 
	  
	  /*Validate whether the user is able to navigate
	  to one to one chat screen or secret group chat screen by clicking the contact
	  name or group name in new screen*/
	  
	  @Test(priority = 34) public void
	  To_validate_whether_the_user_is_able_to_navigate_to_one_to_one_chat_screen_or_secret_group_chat_screen_by_clicking_the_contact_name_or_group_name_in_new_screen
	  () { homepage = new HomeScreen(driver);
	  Assert.assertEquals(homepage.Pagetitle(), "Chats"); homepage.OpenNewScreen();
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickContactorGroup(); chatpage = new ChatScreen(driver);
	  Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	  driver.navigate().back(); 
	  }
	 
	
	/* Validate whether user is able to open scan QR screen and navigation back to new screen from scan QR screen */
	
	  @Test(priority = 35) 
	  public void To_validate_whether_the_user_is_able_to_open_Scan_QR_screen_and_navigation_back_to_new_screen_from_Scan_QR_screen () {
	  newchatpage = new NewChatScreen(driver);
	  Assert.assertEquals(newchatpage.Pagetitle(),"New");
	  newchatpage.ClickQRCodeIcon();
	  Assert.assertEquals(newchatpage.getScanQRScreenTitle(),"Scan QR");
	  driver.navigate().back();
	  }
}
