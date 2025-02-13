package AutomationTesting.BchatApp;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.BlockedContactsScreen;
import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.MenuScreen;
import POM.MessageRequestScreen;
import POM.NotificationsScreen;
import POM.OneToOneChatScreen;
import POM.OpeningPage;
import POM.RecoverySeedScreen;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Recovery_Seed_Screen_TestCases extends baseclass {
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
		menupage.click_option_Recovery_Seed();
	}
	/*
	Validate whether able to navigate back to the home screen from recovery seed screen
	*/
	/*@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_home_screen_from_recovery_seed_screen () {
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_BackArrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	/*
	Validate the working of the yes,I'm Safe option.
	*/
	/*@Test(priority = 2)
	public void To_Validate_the_working_of_yes_Im_Safe_button () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Recovery_Seed();
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_Yes_Iam_Safe();
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
	}
	/*
	validate Whether able to navigate back to the previous screen from pin screen
	*/
	/*@Test(priority = 3)
	public void To_validate_Whether_able_to_navigate_back_to_previous_screen_from_pin_screen () {
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		recoveryseedpage.click_BackArrow();
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		
	}
	/*
	Validate whether the value entered in the pin field is visible.
	*/
	/*@Test(priority = 4)
	public void To_Validate_whether_the_value_entered_in_pin_field_is_visible ()
	{
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_Yes_Iam_Safe();
   
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");	
		recoveryseedpage.Enter_Value_1();
		Assert.assertNotEquals(recoveryseedpage.text_Value_inPin_fields(), "[1, 1, 1]");
		recoveryseedpage.Delete_Values_In_password();
	}
	/*
	Validate whether value entered in the pin field is deletable.
	Validate whether value entered in the pin field is Editable.
	*/
	/*@Test(priority = 5)
	public void To_Validate_whether_value_entered_in_pin_field_is_deletable_and_Editable () {
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_Yes_Iam_Safe();
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		recoveryseedpage.Enter_Value_1();
		recoveryseedpage.Delete_Values_In_password();
		recoveryseedpage.Enter_Value_2();
		recoveryseedpage.Delete_Values_In_password();
		
	}
	/*
	Validate the password word functionality in the recover seed screen with Invalid pin.
	*/
	/*@Test(priority = 6)
	public void To_Validate_the_password_word_functionality_in_recover_seed_screen_with_Invalid_pin () {
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		try {
		recoveryseedpage.Enter_InValid_Pin();
		Assert.assertEquals(Toast(), "Invalid Password.");
		}
		catch (StaleElementReferenceException e) {
			recoveryseedpage.Enter_InValid_Pin();
			Assert.assertEquals(Toast(), "Invalid Password.");
		}
		catch (NoSuchElementException e) {
			recoveryseedpage.Enter_InValid_Pin();
			Assert.assertEquals(Toast(), "Invalid Password.");
		}
		
		}*/
	/*
	Validate the password word functionality in the recover seed screen with valid pin.
	*/
	@Test(priority = 7)
	public void To_Validate_the_password_word_functionality_in_recover_seed_screen_with_valid_pin () {
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_Yes_Iam_Safe();
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		recoveryseedpage.Enter_valid_Pin();
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
	}
	/*
	Validate whether able to copy the seed.
	*/
	@Test(priority = 8)
	public void To_Validate_whether_able_to_copy_the_seed (){
		recoveryseedpage = new RecoverySeedScreen(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_Copy();
		try {
			recoveryseedpage.click_Copy();
		Assert.assertEquals(Toast(), "Copied to clip board");
		recoveryseedpage.click_BackArrow();
		}
		catch (StaleElementReferenceException e) {
			recoveryseedpage.click_Copy();
			Assert.assertEquals(Toast(), "Copied to clip board");
			recoveryseedpage.click_BackArrow();
		}
		catch (NoSuchElementException e) {
			recoveryseedpage.click_Copy();
			Assert.assertEquals(Toast(), "Copied to clip board");
			recoveryseedpage.click_BackArrow();
		}
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		
	}
	
}
