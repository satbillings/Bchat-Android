package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.BlockedContactsScreen;
import POM.ChatScreen;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.MenuScreen;
import POM.MessageRequestScreen;
import POM.NotificationsScreen;
import POM.OneToOneChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RecoverySeedScreen;
import POM.RegisterScreen;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Report_Issue_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;		
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	MenuScreen menupage;
	MessageRequestScreen messagerequestpage;
	OneToOneChatScreen onetoonechatpage;
	AccountSettingsScreen accountsettingspage;
	BlockedContactsScreen blockedcontactspage;
	NotificationsScreen notificationspage;
	RecoverySeedScreen recoveryseedpage;
	ChatScreen chatpage;
	DisplayNameScreen displaynamepage;
	RegisterScreen registerpage;
	RecoveryPhraseScreen recoveryphrasepage;
	WebDriverWait wait;
	
	/*
	 PreSetup Method for this class
	 */
	@Test(priority = 0)
	public void preSetup () throws InterruptedException {
		
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
		Thread.sleep(10000);
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
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Report_Issue();
		
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
		 * Assert.assertEquals(homepage.Pagetitle(),"BChat");
		 * homepage.clickMenuDrawer(); menupage =new MenuScreen(driver);
		 * Assert.assertEquals(menupage.pagetitle(),"Menu");
		 * menupage.click_option_Report_Issue();
		 */
	}
	/*
	Validate whether able to navigate back to the home screen from report issue screen.
	*/
	/*@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_home_screen_from_report_issue_screen () {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		chatpage.click_Back_Arrow();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Report_Issue();
		
	}
	/*
	Validate the text box of the Report Issue functionality is allowing null value.
	*/
	/*@Test(priority = 2)
	public void To_Validate_the_textbox_of_Report_Issue_functionality_is_allowing_null_value () {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		chatpage.Set_Values_In_Message_textbox(" ");
		try{
			chatpage.click_Send_Button();
		}
		catch( NoSuchElementException e)
		{
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		}
	}
	/*
	 Validate whether able to delete the send report
	 */
	/*@Test(priority = 3)
	public void To_Validate_whether_able_to_delete_the_send_report ()  {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		chatpage.Set_Values_In_Message_textbox("hello");
		chatpage.click_Send_Button();
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(chatpage.SendMessageCard()));
    // try {
		chatpage.delete_Send_Message();
   	 //chatpage.click_DeleteForEveryone();
		chatpage.click_delete_In_Popup();


    // }
    // catch (NoSuchElementException e) {
 		//chatpage.delete_Send_Message();

    	 //chatpage.click_DeleteForEveryone();
		
		//chatpage.click_delete_In_Popup();

	//}
		/*try {
			Assert.assertFalse(chatpage.SendMessageCard().isDisplayed());
		}
		catch (NoSuchElementException e) {
			try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e2) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		}
		catch (StaleElementReferenceException e) {
			try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		}*/
	//}
	/*
	Validate the presence of placeholder in the text box of Report Issue functionality.
	*/
	/*@Test (priority = 4)
	public void To_Validate_the_presence_of_placeholder_in_textbox_of_Report_Issue_functionality () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Write a message....");		
		
	}
	
	
	/*
	Validate whether the value entered in the text box of Report Issue functionality is editable and deletable.	
	*/
	/*@Test(priority = 5)
	public void To_Validate_whether_value_entered_in_textbox_of_Report_Issue_functionality_is_editable_and_deletable () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("Hi");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hi");
		chatpage.clear_textBox();
		chatpage.Set_Values_In_Message_textbox("Hello");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
		chatpage.clear_textBox();
		
	}
	
	
	/*
	Validate whether crusher blink on clicking the text box of Report Issue functionality.
	*/
	/*@Test(priority = 6)
	public void To_Validate_whether_crusher_blink_on_clicking_textbox_of_Report_Issue_functionality () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.clickTextBox();
		Assert.assertTrue(chatpage.activeElement().isDisplayed());
	}
	/*
	Validate Whether able to send multiple reports.
	*/
	/*@Test(priority = 7)
	public void To_Validate_Whether_able_to_send_multiple_reports () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("hi");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "hi");
		chatpage.Set_Values_In_Message_textbox("hello");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(), "hello");
		
	}*/
	
	/*
	Validate the text box of the Report Issue Functionality using special Characters.
	*/
	/*@Test(priority = 8)
	public void To_Validate_the_textbox_of_Report_Issue_Functionality_using_special_Characters () throws InterruptedException  {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("@!#$%");
		chatpage.click_Send_Button();
		//Thread.sleep(15000);
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"@!#$%");
			try {
			chatpage.delete_Send_Message();
			  chatpage.click_DeleteForEveryone();
			}
	   catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
			}
		
	}
	
	/*
	validate whether paste option is working on the text box Report Issue functionality.
	*/
	/*@Test(priority = 9)
	public void To_validate_whether_paste_option_is_working_on_textbox_Report_Issue_functionality () {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.paste_values("Hello");
		chatpage.click_Send_Button();
		//Assert.assertEquals(chatpage.get_Send_Message_Value(), "Hello");
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
		}
			catch (NoSuchElementException e) {
				chatpage.click_delete_In_Popup();
			}
	}
	
	/*
	Validate the text box of the Report Issue Functionality is Allowing the Space in between the value.
	*/
	/*@Test(priority = 10)
	public void To_Validate_textbox_of_Report_Issue_Functionality_is_Allowing_Space_in_between_the_value (){
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("Hi Hello ok");
		
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "Hi Hello ok");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//Thread.sleep(10000);
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
		}
			catch (NoSuchElementException e) {
				chatpage.click_delete_In_Popup();
			}
		
	}
	/*
	
	/*
	Validate whether record option in the message functionality is enable.
	*/
	/*@Test(priority = 11)
	public void To_Validate_whether_record_option_in_message_functionality_is_enable (){
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Record_Voice_Msg();
		chatpage.click_Send_Button();
	//	try {
			//Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
		//}
		//catch (NoSuchElementException e) {
			try {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
				}
				catch (AssertionError e1) {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
				}
		//}
		
		}*/
	/*
	Validate the text box of the Report Issue Functionality using Alaphabats both in uppercase and lower case.
	*/
	@Test(priority = 12)
	public void To_Validate_textbox_of_Report_Issue_Functionality_using_Alaphabats_both_in_uppercase_and_lowercase () throws InterruptedException  {
		chatpage = new ChatScreen(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("ABCDEH");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value().trim(), "ABCDEH");
		chatpage.delete_Send_Message();
		//Thread.sleep(2000); 
		//chatpage.click_DeleteForEveryone();
		chatpage.click_delete_In_Popup();
				
		chatpage.Set_Values_In_Message_textbox("abcdef");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value().trim(), "abcdef");
	
		chatpage.delete_Send_Message();
		//chatpage.click_DeleteForEveryone();
		chatpage.click_delete_In_Popup();
				
		}
}
