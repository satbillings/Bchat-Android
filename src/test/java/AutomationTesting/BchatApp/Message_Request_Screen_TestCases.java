package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.BlockedContactsScreen;
import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.MenuScreen;
import POM.MessageRequestScreen;
import POM.OneToOneChatScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Message_Request_Screen_TestCases extends baseclass {
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
	WebDriverWait wait;
	
	/*
	 PreSetup Method for this class
	 */
	@Test(priority = 0)
	public void preSetup () throws InterruptedException {
		
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
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		//Thread.sleep(10000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Message_requests();
	}
	/*
	 Validate whether able to navigate out of message request screen
	 */
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_out_of_message_request_screen () {
		messagerequestpage = new MessageRequestScreen(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		//messagerequestpage.click_Back_Arrow();
		driver.navigate().back();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	/*
	Validate whether Message requests received from others is showing on the message request screen.
	*/
	@Test(priority = 2)
	public void To_Validate_whether_Message_requests_recevied_from_others_is_showing_on_the_message_request_screen () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		menupage.click_option_Message_requests();
		messagerequestpage = new MessageRequestScreen(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(messagerequestpage.Empty_screen()));
						
		}
		catch(NoSuchElementException e){
			Assert.assertTrue(messagerequestpage.Element_Of_First_Received_Request().isDisplayed());
		}
		}
		/*
		Validate the working of the cancel button in all popup on the message request screen 
		*/
		@Test(priority = 3)
		public void To_Validate_the_working_of_cancel_button_in_all_popup_on_the_message_request_screen () {
			messagerequestpage = new MessageRequestScreen(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			messagerequestpage.Click_Block_option();
			Assert.assertEquals(messagerequestpage.PopupTilte(), "Message Request");
			messagerequestpage.click_cancel();
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			messagerequestpage.Click_Delete_option();
			Assert.assertEquals(messagerequestpage.PopupTilte(), "Message Request");
			messagerequestpage.click_cancel();
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");

	}
		/*
		Validate working of the Accept option in the Message Request screen
		*/
		@Test(priority = 4)
		public void To_Validate_working_of_Accept_option_in_Message_Request_screen () {
			messagerequestpage = new MessageRequestScreen(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			String IdorName =messagerequestpage.Element_Of_First_Received_Request().getText();
			messagerequestpage.Accept_First_Request_In_List();
			onetoonechatpage = new OneToOneChatScreen(driver);
			onetoonechatpage.click_Accept();
			driver.navigate().back();
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(),IdorName);
			
		}	
		/*
		Validate the working of the Block option in the Message request screen
		*/
		@Test(priority = 5)
		public void To_Validate_the_working_of_Block_option_in_Message_request_screen () {
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new  MenuScreen(driver);
			menupage.click_option_Message_requests();
			messagerequestpage = new  MessageRequestScreen(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			String IdorName =messagerequestpage.Element_Of_First_Received_Request().getText();
			messagerequestpage.Block_First_request_In_List();
			messagerequestpage.click_Back_Arrow();
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new  MenuScreen(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_Account_Settings();
			accountsettingspage = new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Blocked_contact_Option();
			blockedcontactspage = new BlockedContactsScreen(driver);
			Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			Assert.assertEquals(blockedcontactspage.get_Blocked_Contact_Id_Or_Name(),IdorName);
			blockedcontactspage.click_Back_Arrow();
			driver.navigate().back();
		}
		/*
		Validate working of the Delete option in the Message request screen.
		*/
		@Test(priority = 6)
		public void To_Validate_working_of_the_Delete_option_in_Message_request_screen () {
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new  MenuScreen(driver);
			menupage.click_option_Message_requests();
			messagerequestpage = new  MessageRequestScreen(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			messagerequestpage.Delete_First_Request_in_list();
			Assert.assertTrue(messagerequestpage.Empty_screen().isDisplayed());
			
		}
		
		
		/*
		 Validate Message Requests Screen without any message request.
		 */
		@Test(priority = 7)
		public void To_Validate_Message_Requests_Screen_without_any_message_request () {
			
			messagerequestpage = new MessageRequestScreen(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			Assert.assertTrue(messagerequestpage.Empty_screen().isDisplayed());
		}
}
