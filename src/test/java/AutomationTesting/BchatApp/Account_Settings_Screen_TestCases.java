package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.MenuScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Account_Settings_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
    RegisterScreen registerpage;
	MenuScreen menupage;
	AccountSettingsScreen accountsettingspage; 
	WebDriverWait wait;
	
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
		Thread.sleep(15000);
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
		//menupage =new MenuScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		menupage.click_Account_Settings();
}
	/*
	 * To Validate the working of the Show BChatId option
*/
	/* @Test(priority = 1)
      public void To_validate_the_working_of_the_Show_BChatId_option () {
	
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickBchatIdIcon();
		Assert.assertEquals(accountsettingspage.getPopupTitle("BChatId"),"BChat ID");
		driver.navigate().back();
	}
	  /*
		To validate the working of the Show BeldexAddress option 
		*/
		/*@Test(priority = 2)
		public void To_validate_the_working_of_the_Show_Beldex_Address_option () {
		
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.ClickBeldexAddressIcon();
			Assert.assertEquals(accountsettingspage.getPopupTitle("BeldexAddress"),"Beldex Address");
			driver.navigate().back();
		}
		/*
		To validate the working of the show Qrcode option 
		*/
		/*@Test(priority = 3)
		public void To_validate_the_working_of_the_Show_QrCode_option () {
		
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.ClickQRCode();
			Assert.assertEquals(accountsettingspage.getPopupTitle("QrCode"),"Scan QR code");
			driver.navigate().back();
		}
		/*
		To validate the working of the copy icon in the bchat id in both normal view and in the popup screen
		*/
		/*@Test(priority = 4)
		public void To_validate_the_working_of_copy_icon_in_Bchat_Id () throws InterruptedException{
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.CopyBchatId();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//String toastmessage =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
			Assert.assertEquals(Toast(),"Copied to clip board");
			accountsettingspage.ClickBchatIdIcon();
			accountsettingspage.clickCopyIcon();
			//String toastmessage2 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
			Assert.assertEquals(Toast(),"Copied to clip board");
			
		}
		
		/*
		To validate the working of the copy icon in the beldex address in both normal view and in the popup screen
		*/
		/*@Test(priority = 5)
		public void To_validate_the_working_of_copy_icon_in_Beldex_Address () throws InterruptedException{
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.CopyBeldexAddress();
			//String toastmessage3 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
			Assert.assertEquals(Toast(),"Copied to clip board");
			accountsettingspage.ClickBeldexAddressIcon();
			accountsettingspage.clickCopyIcon();
			//String toastmessage4 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
			Assert.assertEquals(Toast(),"Copied to clip board");
		}
		/*
		 To Validate the Navigation to the About BNS screen
		 */
		/*@Test(priority =6)
		public void  To_Validate_the_Navigation_to_About_BNS_screen () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.ClickAboutBNS();
			Assert.assertEquals(accountsettingspage.get_About_BNS_Screen_title(),"About BNS");
		    driver.navigate().back();
		
		}
		/*
		To validate the working of the share QR code.
		*/
		/*@Test(priority = 7)
	    public void To_validate_the_working_of_the_share_qr_code () throws InterruptedException {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.ClickQRCode();
			Thread.sleep(3000);
			accountsettingspage.clickSharebtn();
			Assert.assertEquals(accountsettingspage.Share_Screen_Title(), "Share QR Code");
			accountsettingspage.click_Cancel_In_share_option();
		}
		/*
		 Validate whether verify and link buttons are enabled without entering any value in bns name
		 */
		/*@Test(priority = 8)
		public void To_Validate_verify_and_link_buttons_are_enabled_without_entering_any_value_in_bns_name () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Link_BNS_option();
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
			
				accountsettingspage.click_Verify_Button();
				Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
				accountsettingspage.click_Link_Button_In_Popup_Screen();;			
				Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
			
		}
		/*
		 validate the working cancel button in link bns popup screen
		 */
		/*@Test(priority = 9)
		public void To_validate_the_working_cancel_button_in_link_bns_popup_screen () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
			accountsettingspage.click_Cancel_Button_In_Popup_Screen();
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		}
		/*
		validate whether verify button is enabled without the word .bdx in bns name
		*/
		/*@Test(priority = 10)
		public void To_validate_Whether_verify_button_is_enabled_without_the_word_bdx_in_bns_name () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Link_BNS_option();
			accountsettingspage.Enter_Value_In_BNS_Name_field("Sat");		
		
			accountsettingspage.click_Verify_Button();
			Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
	      accountsettingspage.clear_text_box();
			
		}
		/*
		  Validate the verify function with invalid BNS name
		 */
		/*@Test(priority = 11)
		public void To_Validate_the_verify_function_with_invalid_bns_name () throws InterruptedException {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
			accountsettingspage.Enter_Value_In_BNS_Name_field("name.bdx");
			accountsettingspage.click_Verify_Button();
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOf(accountsettingspage.Element_of_Link_BNS_PopScreen_content()));	
			Assert.assertEquals(Toast(), "Invalid BNS");
			accountsettingspage.clear_text_box();
			//Thread.sleep(3000);
		}
		/*
		 Validate whether link button is enabled for invalid BNS name
		 */
		/*@Test(priority = 12)
		public void To_validate_whether_link_button_is_enabled_for_invalid_bns_name () throws InterruptedException {
		 
			accountsettingspage =new AccountSettingsScreen(driver);
			accountsettingspage.click_Link_BNS_option();
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");	
		accountsettingspage.Enter_Value_In_BNS_Name_field("name.bdx");
		accountsettingspage.click_Verify_Button();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(accountsettingspage.Element_of_Link_BNS_PopScreen_content()));
	
		 accountsettingspage.click_Link_Button_In_Popup_Screen();
		 Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
			//Thread.sleep(3000);
		accountsettingspage.click_Cancel_Button_In_Popup_Screen();
		
		}
		/*
		 Validate Whether the screen is scrollable.
		 */
		/*@Test(priority = 13)
		public void To_Validate_Whether_the_screen_is_scrollable () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.scroll_the_page(100, 100, 500, "down");
			Assert.assertEquals(accountsettingspage.Content_changelog(), "Changelog");
		
		}
		/*
		Validate the working of the FeedBack option
		*/
		/*@Test(priority = 14)
		public void To_Validate_the_working_of_the_FeedBack_option () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Feedback_option();
			Assert.assertEquals(accountsettingspage.feedback_mail_Id(), "feedback@beldex.io");
			
		}*/
	/*
	Validate whether able to navigate back to the my account screen from gmail screen
	*/
	/*@Test(priority = 15)
	public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_from_gmail_screen () {
		accountsettingspage =new AccountSettingsScreen(driver);
		accountsettingspage.scroll_the_page(100, 100, 500, "down");
		accountsettingspage.click_Feedback_option();
		Assert.assertEquals(accountsettingspage.feedback_mail_Id(), "feedback@beldex.io");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	/*
 	Validate the working of the FAQ option 
	 */
	/*@Test(priority = 16)
	public void To_Validate_the_working_of_the_FAQ_option () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_FAQ_option();
		Assert.assertEquals(accountsettingspage.FAQ_Page_Title(), "Frequently Asked Questions");
	}
	/*
	Validate whether able to navigate back to the my account screen From FAQ Screen.
	*/
	/*@Test(priority = 17)
     public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_From_FAQ_Screen () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.FAQ_Page_Title(), "Frequently Asked Questions");
		driver.navigate().back();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	/*
	 Validate the working of the change log option
	 */
	/*@Test (priority =18)
	public void To_Validate_the_working_of_change_log_option () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Changelog_option();
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		
	}
	/*
	Validate the working of the change log drop down.
	*/
	/*@Test(priority = 19)
	public void To_Validate_the_working_of_the_changelog_dropdown () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.click_First_Log();
		Assert.assertTrue(accountsettingspage.FirstLog_content().isDisplayed());
	}
	/*
	Validate Whether change log screen is scrollable
	*/
	/*@Test(priority = 20)
	public void To_Validate_Whether_changelog_screen_is_scrollable () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.scrollgesture_Using_text("2.6.0");
		Assert.assertTrue(accountsettingspage.lastLog().isDisplayed());
	}
	/*
	Validate whether able to navigate back to the my account screen from change log screen
	*/
	/*@Test(priority = 21)
	public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_from_changeLog_screen () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.Click_back_arrow();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}*/
	
	
}
