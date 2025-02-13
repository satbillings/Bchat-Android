package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.ChatScreen;
import POM.ClearDataPopup;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.EnableWalletScreen;
import POM.HomeScreen;
import POM.MenuScreen;
import POM.NewChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import POM.SettingsScreen;
import TestUtiles.baseclass;

public class One_To_One_Chat_Screen_TestCases extends baseclass {
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	DisplayNameScreen displaynamepage;
	RegisterScreen registerpage;
	MenuScreen menupage;
	// SocialGroupPage socialgrouppage;
	NewChatScreen newchatpage;
	// SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	ChatScreen chatpage;
	String bchatId;
	AccountSettingsScreen accountSettingsPage;
	ClearDataPopup cleardatapopup;
	SeedScreen seedpage;
	RestoreFromSeedScreen restorefromseedpage;
	SettingsScreen settingspage;
	EnableWalletScreen Enablewalletpage;
	// MyWalletPage mywalletpage;

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
		 * Assert.assertEquals(homepage.Pagetitle(), "BChat"); homepage.OpenNewChat();
		 * newchatpage = new NewChatScreen(driver); newchatpage.Check_with_ValidId_2();
		 * chatpage = new ChatScreen(driver); //
		 * chatpage.Set_Values_In_Message_textbox("Hii");
		 */
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Openingpage = new OpeningPage(driver);
		Openingpage.clickSignIn();
		seedpage = new SeedScreen(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.pasteSeedValue();
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedScreen(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.paste_Value_In_DisplayName("Sathish");
		restorefromseedpage.paste_Value_In_Blockheight("3400000");
		restorefromseedpage.clickBtnRestore();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		createpasswordpage.setValidPassword();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		// Thread.sleep(10000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		Thread.sleep(59000);
		//wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		homepage.ClickFirstContactorGroup();
		// homepage.ClickMessageRquestDropdown();
		// homepage.ClickFirstMessageRquest();
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Testdesktop");
	}
	/*
	 * Validate whether record option in the message functionality is enabled before
	 * message request got accepted
	 */
	/*
	 * @Test(priority = 1) public void
	 * To_Validate_whether_record_option_in_message_functionality_is_enabled_before_message_request_got_accepted_in_one_to_one_chat_screen
	 * () throws InterruptedException {
	 * 
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),
	 * "Bdd01e84c363afbe4d1bb88e6b2028316d9acd422b6ae3f08c520f2642272d8014");
	 * chatpage.Record_Voice_Msg(); chatpage.click_Send_Button();
	 * //Assert.assertFalse(chatpage.getMessageCardView().isDisplayed()); } /*
	 * Validate whether attachment option in the message functionality is enabled
	 * before message request got accepted
	 */
	/*
	 * @Test(priority = 2) public void
	 * To_Validate_whether_attachment_option_in_message_functionality_is_enabled_before_message_request_got_accepted_in_one_to_one_chat_screen
	 * () throws InterruptedException {
	 * 
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),
	 * "Bdd01e84c363afbe4d1bb88e6b2028316d9acd422b6ae3f08c520f2642272d8014");
	 * chatpage.click_Attachments(); } /* Setup for clear data
	 */
	/*
	 * @Test(priority = 3) public void setup_for_clear_data () throws
	 * InterruptedException {
	 * 
	 * driver.navigate().back(); homepage = new HomeScreen(driver);
	 * homepage.clickMenuDrawer(); menupage = new MenuScreen(driver);
	 * menupage.click_Account_Settings(); accountSettingsPage = new
	 * AccountSettingsScreen(driver); accountSettingsPage.click_Clear_Data_option();
	 * cleardatapopup = new ClearDataPopup(driver); cleardatapopup.click_ok();
	 * Assert.assertEquals(cleardatapopup.cleardata_popup_screen_title(),
	 * "Clear All Data"); cleardatapopup.click_Clear_Or_delete_option(); wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(30)); Openingpage = new
	 * OpeningPage(driver); Openingpage.clickSignIn(); seedpage = new
	 * SeedScreen(driver); Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	 * seedpage.pasteSeedValue(); seedpage.clickNext(); restorefromseedpage = new
	 * RestoreFromSeedScreen(driver);
	 * Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	 * restorefromseedpage.paste_Value_In_DisplayName("Sathish");
	 * restorefromseedpage.paste_Value_In_Blockheight("3400000");
	 * restorefromseedpage.clickBtnRestore(); createpasswordpage = new
	 * CreatePasswordScreen(driver);
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * createpasswordpage.setValidPassword();
	 * createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
	 * //Thread.sleep(10000); homepage = new HomeScreen(driver);
	 * Assert.assertEquals(homepage.Pagetitle(),"BChat"); } /* Validate the working
	 * of message request drop down
	 */
	/*
	 * @Test(priority = 4,dependsOnMethods = "setup_for_clear_data") public void
	 * To_validate_the_working_of_message_request_drop_down () throws
	 * InterruptedException { homepage = new HomeScreen(driver);
	 * Assert.assertEquals(homepage.Pagetitle(),"BChat"); wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * homepage.ClickMessageRquestDropdown(); homepage.ClickFirstMessageRquest();
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Automationtest"); }
	 */
	/*
	 * validate the working of cancel button in all popup in one to one chat screen
	 */
	/*
	 * @Test(priority = 5) public void
	 * To_validate_the_working_of_cancel_button_in_all_popup_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickCancelInAcceptPopup();;
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickCancelInDeclinePopup();;
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk"); } /*
	 * Validate whether text box is enable before accept the request in one to one
	 * chat screen
	 */
	/*
	 * @Test(priority =6) public void
	 * To_Validate_whether_textbox_is_enable_before_accept_the_request_in_one_to_one_chat_screen
	 * () {
	 * 
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("Hii");
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Hii");
	 * chatpage.clear_textBox(); } /* Validate whether attachments is enable before
	 * accept the request in one to one chat screen
	 */
	/*
	 * @Test(priority = 7) public void
	 * To_Validate_whether_attachments_is_enable_before_accept_the_request_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.click_Attachments();
	 * Assert.assertTrue(chatpage.getElementOfAttachment().isDisplayed());
	 * chatpage.click_Attachments(); } /* validate the working of accept option in
	 * one to one chat screen
	 */
	/*
	 * @Test(priority = 8) public void
	 * To_validate_the_working_of_accept_option_in_one_to_one_chat_screen () {
	 * 
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.click_Accept(); }
	 */
	/*
	 * Validate whether call icon showing After accept the request in one to one
	 * chat screen
	 */
	/*
	 * @Test(priority = 9) public void
	 * To_Validate_whether_call_icon_showing_After_accept_the_request_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.click_Accept();
	 * Assert.assertTrue(chatpage.getElementOfCallIcon().isDisplayed()); } /*
	 * Validate whether able to enable voice call using shortcut in one to one chat
	 * screen
	 */
	/*
	 * @Test(priority = 10) public void
	 * To_Validate_whether_able_to_enable_voice_call_using_shortcut_in_one_to_one_chat_screen
	 * () throws InterruptedException {
	 * 
	 * 
	 * //sAssert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickCallIcon(); chatpage.ClickSettingsButton(); settingspage = new
	 * SettingsScreen(driver);
	 * settingspage.scrollgesture_Using_text("Voice and video calls");
	 * settingspage.click_Voice_Call(); settingspage.click_Enable();
	 * settingspage.click_Back_Arrow(); } /* Validate working of the Mute option in
	 * the menu bar in one to one chat screen
	 */
	/*
	 * @Test(priority = 11) public void
	 * To_Validate_working_of_Mute_option_in_the_menu_bar_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * //Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Tsestapk");
	 * chatpage.ClickMuteNotificationOption();
	 * //Assert.assertTrue(chatpage.getElementOfMuteNotification().isDisplayed()); }
	 * /* Validate working of the Unmute option in the menu bar in one to one chat
	 * screen
	 */
	/*
	 * @Test(priority = 12) public void
	 * To_Validate_working_of_Unmute_option_in_the_menu_bar_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * //Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickUnMuteNotificationOption();
	 * //Assert.assertTrue(chatpage.getElementOfMuteNotification().isDisplayed()); }
	 * /* Validate the working of Block option in the menu bar in one to one chat
	 * screen
	 */
	/*
	 * @Test(priority = 13) public void
	 * To_Validate_the_working_of_Block_option_in_the_menu_bar_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickBlockOption();
	 * Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
	 * 
	 * } /* Validate whether call functionalities are enabled during contact is
	 * blocked in one to one chat screen
	 */
	/*
	 * @Test(priority = 14) public void
	 * To_Validate_whether_call_functionalities_are_enabled_during_contact_is_blocked_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickCallIcon(); chatpage.ClickCancelButtonInUnblockPopup();
	 * Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
	 * 
	 * } /* Validate the working of unblock option in menu bar in one to one chat
	 * screen
	 */
	/*
	 * @Test(priority = 15) public void
	 * To_Validate_the_working_of_unblock_option_in_menu_bar_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickUnBlockOption(); chatpage.Set_Values_In_Message_textbox("Hii");
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Hii");
	 * chatpage.click_Send_Button(); //chatpage.clear_textBox(); } /* Validate
	 * search option in the menu bar with valid value in one to one chat screen
	 */
	/*
	 * @Test(priority = 16) public void
	 * To_Validate_Search_option_in_the_menu_bar_with_valid_value_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Search_textbox("Hii");
	 * Assert.assertTrue(chatpage.Element_Down_arrow().isDisplayed());
	 * chatpage.ClickSearchCloseIcon(); }
	 */
	/*
	 * Validate Whether able to send alphabets both in uppercase and lower case in
	 * one to one chat screen.
	 */
	/*
	 * @Test(priority = 17) public void
	 * To_Validate_Whether_able_to_send_Alphabets_both_in_uppercase_and_lower_case_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.click_Accept(); chatpage.Set_Values_In_Message_textbox("ABCDEFGH");
	 * chatpage.click_Send_Button(); //
	 * Assert.assertEquals(chatpage.get_Send_Message_Value(),"ABCDEFGH");
	 * chatpage.Set_Values_In_Message_textbox("abcdefg");
	 * chatpage.click_Send_Button(); //
	 * Assert.assertEquals(chatpage.get_Send_Message_Value(),"abcdefg");
	 * 
	 * } /* Validate search option in the menu bar with invalid value in one to one
	 * chat screen
	 */
	/*
	 * @Test(priority = 18) public void
	 * To_Validate_Search_option_in_the_menu_bar_with_invalid_value_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * //chatpage.click_Accept(); chatpage.Set_Values_In_Search_textbox("test");
	 * Assert.assertEquals(chatpage.getNoMatchesFoundText(), "No Matches found!");
	 * chatpage.ClickSearchCloseIcon(); } /* Validate the working of the Add to home
	 * screen option in the menu bar in one to one chat screen.
	 */
	/*
	 * @Test(priority = 19) public void
	 * To_Validate_the_working_of_the_Add_To_home_screen_option_in_menu_bar_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickAddtoHomeScreen(); chatpage.click_Back_Arrow();
	 * driver.navigate().back(); driver.navigate().back();
	 * chatpage.swipeGesture(100, 100, 200, 200, "left");
	 * chatpage.ClickHomeScreenShortcut();
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk"); } /*
	 * Validate All media screen when empty in one to one chat screen
	 */
	/*
	 * @Test(priority = 20) public void
	 * To_Validate_All_media_screen_when_empty_in_one_to_one_chat_screen() {
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Testapk");
	 * chatpage.OpenAllMedia(); //
	 * Assert.assertEquals(chatpage.get_AllMedia_Title_Text(), "All Media");
	 * Assert.assertTrue(chatpage.get_Element_of_Empty_media_Screen().isDisplayed())
	 * ; driver.navigate().back(); } /* Validate the navigation to the message
	 * details screen in one to one chat screen
	 */
	/*
	 * @Test(priority = 21) public void
	 * To_Validate_the_navigation_to_message_details_screen_in_one_to_one_chat_screen
	 * () throws InterruptedException { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("Hello");
	 * chatpage.click_Send_Button(); //Thread.sleep(20000); wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * chatpage.ClickMessageDetailsOption();
	 * Assert.assertEquals(chatpage.getMessageDetailsScreenTitleText()
	 * ,"Message details"); driver.navigate().back(); } /* Validate Whether able to
	 * send special Characters in one to one chat screen.
	 */
	/*
	 * @Test(priority = 22) public void
	 * To_Validate_Whether_able_to_send_special_Characters_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("!@#$$%&");
	 * chatpage.click_Send_Button(); } /* Validate the text box of the Messaging
	 * Functionality is Allowing the Space in between the value in one to one chat
	 * screen.
	 */
	/*
	 * @Test(priority = 23) public void
	 * To_Validate_the_textbox_of_Messaging_Functionality_is_Allowing_the_Space_in_between_the_value_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("HI hello how are you 1234 @#$$");
	 * chatpage.click_Send_Button(); } /* Validate Whether able to send numerical
	 * value in one to one chat screen.
	 */
	/*
	 * @Test(priority = 24) public void
	 * To_Validate_Whether_able_to_send_numerical_value_in_one_to_one_chat_screen ()
	 * { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("123456");
	 * chatpage.click_Send_Button(); }
	 */
	/*
	 * Validate the presence of placeholder in the text box of Message functionality
	 * in one to one chat screen.
	 */
	/*
	 * @Test(priority = 25) public void
	 * To_Validate_the_presence_of_placeholder_in_the_textbox_of_Message_functionality_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.click_Accept();
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message...."
	 * ); } /* Validate whether crusher blink on clicking the text box of Message
	 * functionality in one to one chat screen.
	 */
	/*
	 * @Test(priority = 26) public void
	 * To_Validate_whether_crusher_blink_on_clicking_the_textbox_of_Message_functionality_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.click_Textbox();
	 * Assert.assertTrue(chatpage.activeElement().isDisplayed()); } /* Validate
	 * whether paste option is working on the text box Message functionality in one
	 * to one chat screen.
	 */
	/*
	 * @Test(priority = 27) public void
	 * To_validate_whether_paste_option_is_working_on_the_textbox_Message_functionality_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.paste_values("Hello"); chatpage.click_Send_Button(); } /* Validate
	 * whether the value entered in the text box of Message functionality is
	 * editable and deleteable in one to one chat screen.
	 */
	/*
	 * @Test(priority = 28) public void
	 * To_Validate_whether_the_value_entered_in_textbox_of_Message_functionality_is_editable_and_deleteable_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("Hii");
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hii");
	 * chatpage.clear_textBox(); chatpage.Set_Values_In_Message_textbox("Hello");
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
	 * chatpage.clear_textBox(); } /* Validate whether able enter a lengthy value in
	 * the text box Message functionality in one to one chat screen.
	 */
	/*
	 * @Test(priority = 29) public void
	 * To_Validate_whether_able_enter_a_lengthy_value_in_textbox_Message_functionality_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk"); chatpage.
	 * Set_Values_In_Message_textbox("Hii hello are you there to here that in the message and ok then now its ok mm hmm ok "
	 * ); chatpage.click_Send_Button(); } /* Validate the text box of the Messaging
	 * functionality is allowing null value in one to one chat screen.
	 */
	/*
	 * @Test(priority = 30) public void
	 * To_Validate_Whether_able_to_send_null_value_in_one_to_one_chat_screen (){
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Set_Values_In_Message_textbox("  "); chatpage.click_Send_Button();
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.clear_textBox(); } /* Validate the Message Functionality response
	 * without internet in one to one chat screen.
	 */
	/*
	 * @Test(priority = 31) public void
	 * To_Validate_the_Message_Functionality_response_without_internet_in_one_to_one_chat_screen
	 * () throws InterruptedException { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * turnOff_Mobile_Wifi(); Thread.sleep(5000);
	 * Assert.assertEquals(chatpage.getNetworkStatus(),"No connection");
	 * chatpage.Set_Values_In_Message_textbox("Hii"); chatpage.click_Send_Button();
	 * //Assertion need to done after get different id for delivery status
	 * turnOn_Mobile_Wifi(); } /* Validate whether able to reply received message in
	 * one to one chat screen.
	 */
	/*
	 * @Test(priority = 32) public void
	 * To_Validate_whether_able_to_reply_received_message_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * //chatpage.click_Accept(); chatpage.ReplyMessage("test");
	 * //Assert.assertTrue(chatpage.ReplyCardView().isDisplayed()); } /* Validate
	 * whether the chat history present above message text box is delete-able in one
	 * to one chat screen.
	 */
	/*
	 * @Test(priority = 33) public void
	 * To_Validate_whether_the_chat_history_present_above_message_textbox_is_deletable_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.delete_Send_And_Received_Message(); } /* Validate whether able to
	 * share the files,photos in in one to one chat screen
	 */
	/*
	 * @Test(priority = 34) public void
	 * To_Validate_whether_able_to_share_the_files_photos_in_one_to_one_chat_screen
	 * () throws InterruptedException { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * Thread.sleep(5000); chatpage.SendImage();
	 * Assert.assertTrue(chatpage.getMessageStatus().isDisplayed()); } /* Validate
	 * the working of the record option in one to one chat screen
	 */
	/*
	 * @Test(priority = 35) public void
	 * To_Validate_the_working_of_record_option_in_one_to_one_chat_screen (){
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.Record_Voice_Msg(); chatpage.click_Send_Button();
	 * Assert.assertTrue(chatpage.getMessageStatus().isDisplayed()); }
	 */
	/*
	 * Validate the all media with image in one to one chat screen
	 */
	/*
	 * @Test(priority = 36) public void
	 * To_validate_the_all_media_with_image_in_one_to_one_chat_screen () throws
	 * InterruptedException { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * //chatpage.click_Accept(); //chatpage.SendImage(); Thread.sleep(5000);
	 * chatpage.OpenAllMedia();
	 * //Assert.assertEquals(chatpage.get_AllMedia_Title_Text(), "All Media");
	 * //Assert.assertFalse(chatpage.get_Element_of_Empty_media_Screen().isDisplayed
	 * ()); driver.navigate().back(); }
	 * 
	 * Validate whether able to download media in one to one chat screen
	 * 
	 * @Test(priority = 37) public void
	 * To_Validate_whether_able_to_download_media_in_one_to_one_chat_screen ()
	 * throws InterruptedException { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.DownloadMedia(); }
	 * 
	 * Validate Whether able to delete voice message and image in one to one chat
	 * screen
	 * 
	 * @Test(priority = 38) public void
	 * To_Validate_Whether_able_to_delete_voice_message_and_image_in_one_to_one_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickDeleteAudioMessage(); chatpage.ClickDeleteImage(); }
	 * 
	 * Validate the working of the call icon in one to one chat screen
	 * 
	 * @Test(priority = 39) public void
	 * To_validate_the_working_of_the_call_icon_in_one_to_one_chat_screen () {
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickCallIcon(); chatpage.ClickSettingsButton(); settingspage = new
	 * SettingsScreen(driver);
	 * settingspage.scrollgesture_Using_text("Voice and video calls");
	 * settingspage.click_Voice_Call(); settingspage.click_Enable();
	 * settingspage.click_Back_Arrow(); chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testapk");
	 * chatpage.ClickCallIcon(); Assert.assertEquals(chatpage.getCallScreenTitle(),
	 * "Voice Call"); chatpage.ClickCallEndButton(); chatpage.click_Back_Arrow();
	 * homepage = new HomeScreen(driver); Assert.assertEquals(homepage.Pagetitle(),
	 * "BChat"); }
	 * 
	 * Validate the working of the decline option in the one to one chat screen
	 * 
	 * @Test(priority = 40) public void
	 * To_validate_the_working_of_the_decline_option_in_one_to_one_chat_screen () {
	 * homepage = new HomeScreen(driver); homepage.ClickMessageRquestDropdown();
	 * homepage.ClickFirstMessageRquest(); chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Checkapk");
	 * chatpage.ClickDecline(); homepage = new HomeScreen(driver);
	 * Assert.assertEquals(homepage.Pagetitle(), "BChat"); }
	 */
	/*
	Validate whether the user is able to enable "Pay as you chat" option using shortcut in one to one chat screen.
	*/
	@Test(priority = 41)
	public void To_validate_whether_the_user_is_able_to_enable_pay_as_you_chat_option_using_shortcut_in_one_to_one_chat_screen () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testdesktop");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testdesktop");
			}
		chatpage.click_Back_Arrow();
		homepage = new HomeScreen(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		menupage.click_option_Wallet();
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
        homepage.ClickFirstContactorGroup();
        chatpage.enable_Pay_as_youChat();
        settingspage = new SettingsScreen(driver);
        settingspage.click_PayAsYouChat();
        settingspage.Click_SetupPin();
        createpasswordpage = new CreatePasswordScreen(driver);
        createpasswordpage.setValidPassword();
        createpasswordpage.clickOk();
        settingspage.click_PayAsYouChat();
        settingspage.click_Back_Arrow();
       chatpage.Set_Values_In_Message_textbox("1");
       Assert.assertTrue(chatpage.Btn_Slide_to_pay().isDisplayed());
	}
	/*
	validate whether the user is able to disable "Pay as you chat" option using shortcut in one to one chat screen.
	*/
	@Test(priority = 42)
	public void To_validate_whether_the_user_is_able_to_disable_pay_as_you_chat_option_using_shortcut_in_one_to_one_chat_screen () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testdesktop");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Testdesktop");
			}
		chatpage.enable_Pay_as_youChat();
        settingspage = new SettingsScreen(driver);
        settingspage.click_PayAsYouChat();
        settingspage.click_Back_Arrow();
		chatpage.clear_textBox();
	}
}
