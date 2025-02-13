package AutomationTesting.BchatApp;

import java.time.Duration;

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
import POM.HomeScreen;
import POM.HopsScreen;
import POM.MenuScreen;
import POM.NewChatScreen;
import POM.NoteToSelfChatScreen;
import POM.OneToOneChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Blocked_Contacts_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
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
	WebDriverWait wait;
	//Robot robot;

	@Test(priority = 0)
	public void PreSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
		displaynamepage =new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Sat");
		displaynamepage.clickContinue();
		registerpage= new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.TextPageTitle));
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		Thread.sleep(20000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		//createpasswordpage.clickOk();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		recoveryphrasepage =new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		Thread.sleep(5000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		newchatpage = new NewChatScreen(driver);
		   newchatpage.Check_with_ValidId_1();
		chatpage = new ChatScreen(driver);
		chatpage.Set_Values_In_Message_textbox("Hello");
		chatpage.click_Send_Button();
		chatpage.click_Back_Arrow();
		//menupage =new MenuScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		menupage.click_Account_Settings();
		accountsettingspage =new AccountSettingsScreen(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_Blocked_contact_Option();
	}
	/*
	Validate whether able to navigate back to the my account screen from blocked contacts screen.
	*/
	/*@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_from_blocked_contacts_screen () {
		 blockedcontactspage = new BlockedContactsScreen(driver);
		 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		 blockedcontactspage.click_Back_Arrow();
		  accountsettingspage = new AccountSettingsScreen(driver);
		  Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}
	/*
	Validate the Blocked Contacts screen when there is no blocked contact
	*/
	/*@Test (priority = 2)
	public void To_Validate_the_Blocked_Contacts_screen_when_there_is_no_blocked_contact () {
	
		accountsettingspage = new AccountSettingsScreen(driver);
		  accountsettingspage.click_Blocked_contact_Option();  
		  blockedcontactspage = new BlockedContactsScreen(driver);
		  Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		  Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
		 
	}
	/*
	Validate whether blocked contact is showing in blocked contacts screen.
	*/
	@Test (priority = 3)
	public void To_Validate_whether_blocked_contacts_is_showing_in_blocked_contacts_screen () {
		  blockedcontactspage = new BlockedContactsScreen(driver);
		  Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		  blockedcontactspage.click_Back_Arrow();
		    accountsettingspage = new AccountSettingsScreen(driver);
		    driver.navigate().back();
		    homepage = new HomeScreen(driver);
		  String blockedContact=  homepage.get_DisplayName_Or_Id_Of_ChatItem().toLowerCase();
		    homepage.Block_First_Contact();
		    homepage.clickMenuDrawer();
		    menupage = new MenuScreen(driver);
		    menupage.click_Account_Settings();
		    accountsettingspage.click_Blocked_contact_Option();
		    Assert.assertEquals(blockedContact,blockedcontactspage.get_Blocked_Contact_Id_Or_Name());	    
		
	}
	/*
 	Validate the working of the cancel button in the unblock users popup.
 */
@Test(priority = 4)
public void To_Validate_the_working_of_cancel_button_in_unblock_users_popup () {
	blockedcontactspage = new BlockedContactsScreen(driver);
	 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
	 blockedcontactspage.check_Cancel_button_In_unblockusers_Popup();
	 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
}
/*
Validate whether able to unblock the blocked contacts.
*/
@Test(priority = 5)
public void To_Validate_whether_able_to_unblock_the_blocked_contacts () {
	blockedcontactspage = new BlockedContactsScreen(driver);
	 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
	 blockedcontactspage.UnBlock_contact();
	  Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
	  
}
/*

Validate whether able to unblock by multiselect the contacts in the blocked contacts screen.
*/
@Test(priority = 6)
public void To_Validate_whether_able_to__Unblock_By_multiselect_the_contacts_in_blocked_contacts_screen() {
	blockedcontactspage = new BlockedContactsScreen(driver);
	 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
	 blockedcontactspage.click_Back_Arrow();
	 driver.navigate().back();
	 homepage = new HomeScreen(driver);
	 homepage.OpenNewChat();
	 newchatpage = new NewChatScreen(driver);
	 newchatpage.Check_with_ValidId_2();
	 onetoonechatpage = new OneToOneChatScreen(driver);
	 onetoonechatpage.Set_Values_In_Message_textbox("Hello");
	 onetoonechatpage.click_Send_Button();
	 onetoonechatpage.click_Back_Arrow(); 
	 homepage.Block_First_Contact();
	 homepage.Block_Second_Contact();
	 homepage.clickMenuDrawer();
	 menupage = new MenuScreen(driver);
	 menupage.click_Account_Settings();
	 accountsettingspage = new AccountSettingsScreen(driver);
	 accountsettingspage.click_Blocked_contact_Option();
	 blockedcontactspage.UnBlock_By_Using_MultiSelect_option();
	 Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
	 
}

}
