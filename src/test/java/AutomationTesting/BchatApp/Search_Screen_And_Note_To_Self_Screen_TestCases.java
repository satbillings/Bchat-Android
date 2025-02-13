package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.AppLockScreen;
import POM.BlockedContactsScreen;
import POM.ChatScreen;
import POM.ChatSettingsScreen;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.GlobalSearchScreen;
import POM.HomeScreen;
import POM.HopsScreen;
import POM.MenuScreen;
import POM.MessageRequestScreen;
import POM.NewChatScreen;
import POM.NoteToSelfChatScreen;
import POM.NotificationsScreen;
import POM.OneToOneChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RecoverySeedScreen;
import POM.RegisterScreen;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Search_Screen_And_Note_To_Self_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	// RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
	RegisterScreen registerpage;
	MenuScreen menupage;
	AccountSettingsScreen accountsettingspage;
	HopsScreen hopspage;
	AppLockScreen applockpage;
	ChatSettingsScreen chatsettingspage;
	BlockedContactsScreen blockedcontactspage;
	NewChatScreen newchatpage;
	ChatScreen chatpage;
	NoteToSelfChatScreen notetomyselfpage;
	OneToOneChatScreen onetoonechatpage;
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	// GlobalSearchScreen homepage;
	WebDriverWait wait;
	// Robot robot;

	@Test(priority = 0)
	public void PreSetup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
		displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
		displaynamepage.setDisplayName("Sat");
		displaynamepage.clickContinue();
		registerpage = new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.TextPageTitle));
		Assert.assertEquals(registerpage.pageTitle(), "Register");
		// wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(20000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		createpasswordpage.setValidPassword();
		// createpasswordpage.clickOk();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		recoveryphrasepage = new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		Thread.sleep(5000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
	}

	/*
	 * Openingpage = new OpeningPage(driver); Openingpage.clickSignIn(); seedpage =
	 * new SeedScreen(driver);
	 * Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
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
	 * Assert.assertEquals(homepage.Pagetitle(),"BChat"); }
	 */
	/*
	 * Validate the presence of placeholder in the search text box.
	 */
	/*
	 * @Test(priority = 1) public void
	 * To_Validate_the_presence_of_placeholder_in_the_search_text_box () { homepage
	 * = new HomeScreen(driver); Assert.assertEquals(homepage.Pagetitle(),"BChat");
	 * Assert.assertEquals(homepage.SearchPlaceholder(),
	 * "Search people and groups"); } /* Validate whether crusher blink on clicking
	 * the text box of search functionality.
	 */
	/*
	 * @Test(priority =2) public void
	 * To_Validate_Whether_crusor_Blinks_on_clicking_the_search_textbox () {
	 * homepage = new HomeScreen(driver); homepage.clickSearch();
	 * driver.navigate().back(); driver.navigate().back();
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	 * //Assert.assertTrue(homepage.visblity_of_crusor()); } /* Validate whether the
	 * value entered in the search text box is editable. Validate whether the value
	 * entered in the search text box is delete able.
	 */
	/*
	 * @Test(priority = 3) public void
	 * To_Validate_Values_enterd_in_search_textbox_is_editable_and_deleteable () {
	 * homepage = new HomeScreen(driver);
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	 * homepage.enterValues("text");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"text");
	 * homepage.click_cancel_icon_inside_textbox();
	 * //Assert.assertTrue(homepage.visiblity_of_placeholder());
	 * homepage.enterValues("Check");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"Check");
	 * homepage.clearTextBox();
	 * 
	 * } /* validate whether paste option is working on the search text box.
	 */
	/*
	 * @Test(priority=4) public void
	 * To_Validate_wether_paste_option_on_the_search_text_box () { homepage = new
	 * HomeScreen(driver); //Assert.assertEquals(homepage.Search_PageTitle(),
	 * "Search"); homepage.pastevalues("hello");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"hello");
	 * homepage.clearTextBox(); }
	 */
	/*
	 * validate the working of the cancel icon inside the search text box
	 */
	/*
	 * @Test(priority = 5) public void
	 * To_validate_working_of_cancel_icon_inside_the_search_textbox () { homepage =
	 * new HomeScreen(driver); //homepage.clickSearch();
	 * //Assert.assertEquals(homepage.searchTitle(), "Search");
	 * homepage.enterValues("text"); homepage.click_cancel_icon_inside_textbox();
	 * Assert.assertTrue(homepage.visiblity_of_placeholder()); } /* Validate the
	 * text box of the search Functionality using special Characters.
	 */
	/*
	 * @Test(priority = 6) public void
	 * To_Validate_the_textbox_of_the_search_Functionality_using_special_Characters
	 * () { homepage = new HomeScreen(driver);
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	 * homepage.enterValues("@#$%");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"@#$%");
	 * homepage.click_cancel_icon_inside_textbox();
	 * Assert.assertTrue(homepage.visiblity_of_placeholder()); } /* Validate the
	 * text box of the search Functionality using Alphabets both in uppercase and
	 * lower case.
	 */
	/*
	 * @Test(priority = 7) public void
	 * To_Validate_the_textbox_of_search_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase
	 * () { homepage = new HomeScreen(driver);
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	 * homepage.enterValues("ABCDE");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"ABCDE");
	 * homepage.click_cancel_icon_inside_textbox();
	 * Assert.assertTrue(homepage.visiblity_of_placeholder());
	 * homepage.enterValues("abcde");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"abcde");
	 * homepage.click_cancel_icon_inside_textbox();
	 * Assert.assertTrue(homepage.visiblity_of_placeholder()); } /* Validate the
	 * text box of the search Functionality is Allowing the Space.
	 */
	/*
	 * @Test(priority = 8) public void
	 * To_Validate_the_textbox_of_search_Functionality_is_Allowing_the_Space () {
	 * homepage = new HomeScreen(driver);
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	 * homepage.enterValues("Hi Hello ok");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"Hi Hello ok"
	 * ); homepage.click_cancel_icon_inside_textbox();
	 * Assert.assertTrue(homepage.visiblity_of_placeholder()); } /* Validate the
	 * text box of the search Functionality by numerical value.
	 */
	/*
	 * @Test(priority = 9) public void
	 * To_Validate_the_textbox_of_search_Functionality_by_Numerical_values () {
	 * homepage = new HomeScreen(driver);
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	 * homepage.enterValues("123456");
	 * //Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"123456");
	 * homepage.click_cancel_icon_inside_textbox();
	 * Assert.assertTrue(homepage.visiblity_of_placeholder()); }
	 */
	/*
	 * Validate whether searched messages are showing in the list in search screen
	 */
	/*
	 * @Test(priority = 10) public void
	 * To_Validate_whether_searched_messages_are_showing_in_the_list_in_search_screen
	 * () throws InterruptedException{ homepage = new HomeScreen(driver); //try {
	 * Thread.sleep(40000); //} //catch (NoSuchElementException e) {
	 * homepage.clickSearch(); //} try { homepage.enterValues("Hii");
	 * //Assert.assertTrue(homepage.Element_Messages().isDisplayed()); } catch
	 * (StaleElementReferenceException e) { homepage.enterValues("Hello");
	 * //Assert.assertTrue(homepage.Element_Messages().isDisplayed()); }
	 * homepage.clearTextBox(); } /* Validate the search functionality using Invalid
	 * value in search screen
	 */
	/*
	 * @Test(priority = 11) public void
	 * To_Validate_the_search_functionality_using_Invalid_value_in_search_screen ()
	 * { homepage = new HomeScreen(driver); homepage.clickSearch();
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search"); //try {
	 * homepage.enterValues("asdfghjkl");
	 * //Assert.assertTrue(homepage.Element_Messages().isDisplayed()); //} //catch
	 * (NoSuchElementException e) {
	 * //Assert.assertEquals(homepage.Search_PageTitle(), "Search"); //}
	 * homepage.clearTextBox(); }
	 * 
	 * /* Note to self chat screen
	 */
	/*
	 * Validate the text box of the Messaging Functionality using special Characters
	 * in note to self chat screen.
	 */
	/*
	 * @Test(priority = 12) public void
	 * To_Validate_the_textbox_of_the_Messaging_Functionality_using_special_Characters_in_note_to_self_chat_screen
	 * () { homepage = new HomeScreen(driver);
	 * homepage.click_Option_Note_To_Myself(); chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * chatpage.Set_Values_In_Message_textbox("Hii"); chatpage.click_Send_Button();
	 * chatpage.Set_Values_In_Message_textbox("!@#$$%&");
	 * chatpage.click_Send_Button();
	 * //Assert.assertEquals(chatpage.get_Second_Message_Value(),"!@#$$%&");
	 * 
	 * } /* Validate the working of cancel button in the delete message popup
	 */
	/*
	 * @Test(priority = 13) public void
	 * To_Validate_the_working_of_cancel_button_in_delete_message_popup () {
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * chatpage.delete_Send_Message();
	 * 
	 * try{ chatpage.cancelbuttonclick(); } catch (NoSuchElementException e) { // }
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self"); } /*
	 * Validate whether the value entered in the text box of Message functionality
	 * is editable and deleteable.
	 */
	/*
	 * @Test(priority = 14) public void
	 * To_Validate_whether_the_value_entered_in_textbox_of_Message_functionality_is_editable_and_deleteable
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * chatpage.Set_Values_In_Message_textbox("Hii");
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hii");
	 * chatpage.clear_textBox(); chatpage.Set_Values_In_Message_textbox("Hello");
	 * //Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
	 * chatpage.clear_textBox(); }
	 */
	/*
	 * Validate the presence of placeholder in the text box of Message functionality
	 * in note to self chat screen.
	 */
	/*
	 * @Test(priority = 15) public void
	 * To_Validate_the_presence_of_placeholder_in_textbox_of_Message_functionality_in_note_to_self_chat_screen
	 * () { homepage = new HomeScreen(driver); homepage.clickSearch();
	 * homepage.click_Option_Note_To_Myself(); chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message...."
	 * );
	 * 
	 * } /* Validate the text box of the Messaging Functionality using Alphabets
	 * both in uppercase and lower case. Validate Whether able to delete the send
	 * message in note to self chat screen
	 */
	/*
	 * @Test(priority = 16) public void
	 * To_Validate_the_textbox_of_Messaging_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase_and_validate_the_whether_able_to_delete_send_message_in_note_to_self_chat_screen
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * chatpage.Set_Values_In_Message_textbox("ABCDEFGH");
	 * chatpage.click_Send_Button();
	 * Assert.assertEquals(chatpage.get_Send_Message_Value(),"ABCDEFGH");
	 * chatpage.delete_Send_Message(); chatpage.click_delete_In_Popup();
	 * chatpage.Set_Values_In_Message_textbox("abcdefg");
	 * chatpage.click_Send_Button();
	 * Assert.assertEquals(chatpage.get_Send_Message_Value(),"abcdefg");
	 * chatpage.delete_Send_Message(); chatpage.click_delete_In_Popup(); } /*
	 * Validate the text box of the Messaging Functionality is Allowing the Space in
	 * between the value.
	 */
	/*
	 * @Test(priority = 17) public void
	 * To_Validate_the_textbox_of_Messaging_Functionality_is_Allowing_the_Space_in_between_the_value
	 * () { chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * chatpage.Set_Values_In_Message_textbox("hi hello how are you");
	 * chatpage.click_Send_Button();
	 * Assert.assertEquals(chatpage.get_Send_Message_Value(),"hi hello how are you"
	 * ); chatpage.delete_Send_Message(); chatpage.click_delete_In_Popup(); } /*
	 * Validate the text box of the Messaging Functionality by numerical value.
	 */
	/*
	 * @Test(priority = 18) public void
	 * To_Validate_the_textbox_of_Messaging_Functionality_by_numerical_value () {
	 * chatpage = new ChatScreen(driver);
	 * Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	 * chatpage.Set_Values_In_Message_textbox("12346789");
	 * chatpage.click_Send_Button();
	 * Assert.assertEquals(chatpage.get_Send_Message_Value(),"12346789");
	 * chatpage.delete_Send_Message(); chatpage.click_delete_In_Popup(); }
	 */
	/*
	 * Validate whether crusher blink on clicking the text box of Message functionality in note to self chat screen.
	 */
	/*@Test(priority = 19)
	public void To_Validate_whether_crusher_blink_on_clicking_the_textbox_of_Message_functionality_in_Note_to_self_chat_screen() {
		homepage = new HomeScreen(driver);
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Note to Self");
		chatpage.click_Textbox();
		Assert.assertTrue(chatpage.activeElement().isDisplayed());
	}

	/*
	 * Validate whether able enter a lengthy value in the text box Message functionality in note to self chat screen.
	 */
	/*@Test(priority = 20)
	public void To_Validate_whether_able_enter_a_lengthy_value_in_textbox_Message_functionality_in_Note_to_self_chat_screen() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Note to Self");
		chatpage.Set_Values_In_Message_textbox(
				"Hii hello are you there to here that in the message and ok then now its ok mm hmm ok ");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.SendMessageCard().isDisplayed());
		chatpage.delete_Send_Message();
		chatpage.click_delete_In_Popup();
	}

	/*
	 * validate whether paste option is working on the text box Note to myself functionality.
	 */
	/*@Test(priority = 21)
	public void To_validate_whether_paste_option_is_working_on_the_textbox_Note_to_myself_functionality() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Note to Self");
		chatpage.paste_values("Hello");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.SendMessageCard().isDisplayed());
		chatpage.delete_Send_Message();
		chatpage.click_delete_In_Popup();
	}

	/*
	 * Validate All media screen when empty in note to self chat screen
	 */
	/*@Test(priority = 22)
	public void To_Validate_All_media_screen_when_empty_in_Note_to_self_chat_screen() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Note to Self");
		chatpage.OpenAllMedia();
		// Assert.assertEquals(chatpage.get_AllMedia_Title_Text(), "All Media");
		Assert.assertTrue(chatpage.get_Element_of_Empty_media_Screen().isDisplayed());
		driver.navigate().back();
	}

	/*
	 * Validate the search option with valid value in note to self chat screen
	 */
	/*@Test(priority = 23)
	public void To_Validate_the_search_option_with_valid_value_in_Note_to_self_chat_screen() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Note to Self");
		chatpage.paste_values("Hii");
		chatpage.click_Send_Button();
		chatpage.Set_Values_In_Search_textbox("Hii");
		Assert.assertTrue(chatpage.Element_Down_arrow().isDisplayed());
		chatpage.ClickSearchCloseIcon();
	}

	/*
	 * Validate the search option with invalid value in note to self chat screen
	 */
	/*@Test(priority = 24)
	public void To_Validate_the_search_option_with_invalid_value_in_Note_to_self_chat_screen() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(), "Note to Self");
		chatpage.Set_Values_In_Search_textbox("test");
		Assert.assertEquals(chatpage.getNoMatchesFoundText(), "No Matches found!");
		chatpage.ClickSearchCloseIcon();
	}
	/*
	Validate the working of copy text option in note to self chat screen
	*/
	/*@Test(priority = 25)
	public void To_Validate_the_working_of_copy_text_option_in_note_to_self_chat_screen () {
		homepage = new HomeScreen(driver);
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("TestNew");
		chatpage.click_Send_Button();
		chatpage.ClickCopyTextOption();
		Assert.assertEquals(Toast(), "Copied to clipboard");
		}
	/*
	Validate the navigation to the message details screen in note to self chat screen
	*/
	/*@Test(priority = 26)
	public void To_Validate_the_navigation_to_message_details_screen_in_note_to_self_chat_screen () {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.ClickMessageDetailsOption();
		Assert.assertEquals(chatpage.getMessageDetailsScreenTitleText(),"Message details");
		driver.navigate().back();
	}
	/*
	Validate whether able to unselect the selected message in note to self chat screen
	*/
	/*@Test(priority = 27)
	public void To_Validate_whether_able_to_unselect_the_selected_message_in_note_to_self_chat_screen () {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.UnselectMessage();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	/*
	Validate the working of the record option in note to self chat screen
	*/
	/*@Test(priority = 28)
	public void To_Validate_the_working_of_record_option_in_note_to_self_chat_screen (){
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Record_Voice_Msg();
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.getMessageStatus().isDisplayed());	
	}
	/*
	Validate the working of Add to home screen shortcut in note to self chat screen
	*/
	/*@Test(priority = 29)
	public void To_Validate_the_working_of_Add_To_home_screen_in_note_to_self_chat_screen () {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.ClickAddtoHomeScreen();
		chatpage.click_Back_Arrow();
		driver.navigate().back();
		driver.navigate().back();
		chatpage.swipeGesture(100, 100, 200, 200, "left");
		chatpage.Clickshorcutnotetoselfhomescreen();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}*/
	/*
	validate the working of reply option in the Note to Self chat screen
	*/
	@Test(priority = 30)
	public void To_validate_the_working_of_reply_option_in_note_to_self_chat_screen () throws InterruptedException {
		homepage = new HomeScreen(driver);
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("test");
		chatpage.click_Send_Button();
		Thread.sleep(40000);
		chatpage.ReplyMessage("Hii");
		Assert.assertTrue(chatpage.ReplyCardView().isDisplayed());
	}
	/*
	Validate whether able to share the files,photos in the Note to Self chat screen
	*/
	@Test(priority = 31)
	public void To_Validate_whether_able_to_share_the_files_photos_in_note_to_self_chat_screen () throws InterruptedException {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		Thread.sleep(5000);
		chatpage.SendImage();
		Assert.assertTrue(chatpage.getMessageStatus().isDisplayed());	
	}
	/*
	validate the all media with image in the Note to Self chat screen
	*/
	@Test(priority = 32)
	public void To_validate_the_all_media_with_image_in_note_to_self_chat_screen () throws InterruptedException {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		Thread.sleep(5000);
		chatpage.OpenAllMedia();
		Assert.assertEquals(chatpage.get_AllMedia_Title_Text(), "All Media");
		//Assert.assertFalse(chatpage.get_Element_of_Empty_media_Screen().isDisplayed());
		driver.navigate().back();
	}
	/*
	Validate the Message screen response without internet in the note to self chat screen.
	*/
	@Test(priority = 33)
	public void To_Validate_the_Message_screen_and_response_without_internet_in_note_to_self_chat_screen () throws InterruptedException
	{
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		Assert.assertEquals(chatpage.getNetworkStatus(),"No connection");
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		//Assertion need to done after get different id for delivery status
		turnOn_Mobile_Wifi();
		//wait.until(ExpectedConditions.invisibilityOf(chatpage.get_internet_status()));
	}
}
