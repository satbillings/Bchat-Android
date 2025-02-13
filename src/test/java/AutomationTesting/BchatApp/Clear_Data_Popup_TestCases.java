package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.AppLockScreen;
import POM.ClearDataPopup;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.HopsScreen;
import POM.MenuScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Clear_Data_Popup_TestCases extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
    RegisterScreen registerpage;
	MenuScreen menupage;
	AccountSettingsScreen accountsettingspage; 
	ClearDataPopup cleardatapopup;
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
		accountsettingspage =new AccountSettingsScreen(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	    accountsettingspage.click_Clear_Data_option();
	}
	/*
    Validate whether able to navigate back to the Account Settings screen from clear data popup
	*/
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_Account_Settings_Screen () {
		cleardatapopup = new ClearDataPopup(driver);
		Assert.assertEquals(cleardatapopup.pageTitle(),"Clear All Data");
		driver.navigate().back();
		accountsettingspage= new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}
	/*
    Validate the working of the cancel button in all popup 
	*/
	@Test(priority = 2)
	public void To_Validate_the_working_of_cancel_button_in_all_popup () {
		accountsettingspage= new AccountSettingsScreen(driver);
		accountsettingspage.click_Clear_Data_option();
		cleardatapopup = new ClearDataPopup(driver);
		Assert.assertEquals(cleardatapopup.pageTitle(),"Clear All Data");
		cleardatapopup.click_Cancel_Option_popup();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Clear_Data_option();
		cleardatapopup.click_ok();
		Assert.assertEquals(cleardatapopup.cleardata_popup_screen_title(), "Clear All Data");
		cleardatapopup.click_cancel_In_clear_Or_Delete_popup();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Clear_Data_option();
		cleardatapopup.click_option_deleteAccount();
		cleardatapopup.click_ok();
		Assert.assertEquals(cleardatapopup.DeleteAccount_popup_screen_title(), "Delete Entire Account");
		cleardatapopup.click_cancel_In_clear_Or_Delete_popup();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}
	/*
    Validate the working of the clear data from device option 
     */
	@Test(priority = 3)
	public void To_Validate_the_working_of_clear_data_from_device_option () {
		accountsettingspage= new AccountSettingsScreen(driver);
		accountsettingspage.click_Clear_Data_option();
		cleardatapopup = new ClearDataPopup(driver);
		Assert.assertEquals(cleardatapopup.pageTitle(),"Clear All Data");
		cleardatapopup.click_ok();
		Assert.assertEquals(cleardatapopup.cleardata_popup_screen_title(), "Clear All Data");
		cleardatapopup.click_Clear_Or_delete_option();
		Openingpage = new OpeningPage(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(Openingpage.Openingpage_Element()));
		Assert.assertEquals(Openingpage.Pagetitle(), "Welcome to");
		
	}
	
	 /*
    Validate the working of the delete entire account option.
   */
	@Test(priority = 4)
	public void To_Validate_the_working_of_delete_entire_account_option () throws InterruptedException {
	        PreSetup();
	    	cleardatapopup = new ClearDataPopup(driver);
			Assert.assertEquals(cleardatapopup.pageTitle(),"Clear All Data");
			cleardatapopup.click_option_deleteAccount();
			cleardatapopup.click_ok();
			Assert.assertEquals(cleardatapopup.DeleteAccount_popup_screen_title(), "Delete Entire Account");
			
			
			try {
				cleardatapopup.click_Clear_Or_delete_option();
			wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			Openingpage = new OpeningPage(driver);
			//wait.until(ExpectedConditions.visibilityOf(cleardatapopup.landingpage_Element()));
			Assert.assertEquals(Openingpage.Pagetitle(), "Welcome to");
			}
			catch (AssertionError e) {
				cleardatapopup.click_Clear_Or_delete_option();
				wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				Openingpage = new OpeningPage(driver);
				//wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
				Assert.assertEquals(Openingpage.Pagetitle(), "Welcome to");
			}
		
	}

}
