package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.AppLockScreen;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.HopsScreen;
import POM.MenuScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class App_Lock_Screen_TestCases extends baseclass {
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
	    accountsettingspage.click_App_Lock_Option();
	}
	/*
	Validate whether able to navigate back to the Account Screen from app lock screen.
	*/
	/*@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_the_Account_Screen_from_Applock_screen () {
		applockpage = new AppLockScreen(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_Back_Arrow();
		accountsettingspage =new AccountSettingsScreen(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	    accountsettingspage.click_App_Lock_Option();
	    Assert.assertEquals(applockpage.pageTitle(),"App Lock");	   
		
	}
	/*
	Validate whether the functions present in the App Lock screen response for the touch action.
	Validate navigation to the functions in the App Lock screen in both forward and backward direction.
	*/
	/*@Test(priority = 2)
	public void To_validate_functions_present_in_the_app_lock_screen_response_for_touch_action_To_Validate_functions_forward_and_backward_navigation_in_the_App_Lock_screen () {
		applockpage = new AppLockScreen(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		
		applockpage.click_ChangePassword_option();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		applockpage.click_Back_Arrow();
		applockpage.click_ScreenLockTimeOut_option();
		Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
		applockpage.Clicl_Cancel_Icon();
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");	
	}
	 /*
	Validate the Change password fields with Invalid Old password value
	*/
	/*@Test(priority = 3)
	public void To_Validate_the_Change_password_fields_with_Invalid_Old_password_value () {
		applockpage = new AppLockScreen(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ChangePassword_option();
		createpasswordpage =new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setPassword_0();
		try {
		createpasswordpage.clickNext();
		Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		catch (StaleElementReferenceException e) {
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		}
	/*
	Validate whether next button clickable without entering the values in all change password fields
	*/
	/*@Test(priority = 4)
	public void To_Validate_whether_next_button_clickable_without_entering_the_values_in_all_change_password_fields () {
		createpasswordpage =new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		createpasswordpage.clickNext();
		driver.navigate().back();
	}*/
	/*
	Validate the password fields with valid Old password and valid New Password and invalid Reenter password
	*/
	/* @Test(priority = 5)
	 public void To_Validate_password_fields_with_valid_Old_password_and_valid_New_Password_and_invalid_ReEnter_password () {
		 applockpage = new AppLockScreen(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			try {
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Password does not match.");
			}
			catch(StaleElementReferenceException e) {
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(), "Password does not match.");
			}
			driver.navigate().back();
	 }
	 /*
    Validate whether able to set the new password with old password value
     */
   /*@Test(priority = 6)
   public void To_Validate_whether_able_to_set_the_new_password_with_old_password_value () {
	applockpage = new AppLockScreen(driver);
	Assert.assertEquals(applockpage.pageTitle(),"App Lock");
	applockpage.click_ChangePassword_option();
	createpasswordpage =new CreatePasswordScreen(driver);
	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
	createpasswordpage.setPassword_1();
	createpasswordpage.clickNext();
	Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
	createpasswordpage.setPassword_1();
	try {
	createpasswordpage.clickNext();
	Assert.assertEquals(Toast(),"New password should not be same as old password.");
	}
	catch (StaleElementReferenceException e) {
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(Toast(),"New password should not be same as old password.");
	}
	driver.navigate().back();
 
 }
   /*
	Validate whether the value entered in all pin number fields is editable.
	Validate whether the value entered in all pin number fields is deleteable.
	*/
	/*@Test(priority=7)
	public void TC_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
		
		
		applockpage = new AppLockScreen(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ChangePassword_option();
		createpasswordpage =new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
		createpasswordpage.Delete_And_Edit_pin_field();	
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.cancel_Values();
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();  
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		createpasswordpage.Delete_And_Edit_pin_field();
		driver.navigate().back();
						
		}
	/*
	Validate both the Password fields by entering values Below boundary value.
	*/
		/*@Test(priority =8)
		public void TC_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
			
			applockpage = new AppLockScreen(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			
			createpasswordpage =new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click1();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");	
				createpasswordpage.click1();
				createpasswordpage.clickNext();
			
				Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click0();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");	
				createpasswordpage.click0();
				createpasswordpage.clickNext();	
				
				Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click0();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");	
			
			driver.navigate().back();
																         		         						
		}
		/* 
		Validate whether values entered in the pin number fields are visible
	*/
		/*@Test(priority = 9)
		public void To_Validate_whether_values_entered_in_the_pin_number_fields_are_visible () {
			applockpage = new AppLockScreen(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			
			createpasswordpage =new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_1();			
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[1, 1, 1, 1]");
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");	
			createpasswordpage.setPassword_0();
		
			
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[0, 0, 0, 0]");
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[1, 1, 1, 1]");
	
			driver.navigate().back();
						
		}
		/*
		Validate the password fields with valid Old password and Valid New Password.
		*/
		/*@Test(priority = 10)
		public void To_Validate_password_fields_with_valid_Old_password_and_Valid_New_Password () {
			applockpage = new AppLockScreen(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.change_password_with_Valid_value();
			Assert.assertEquals(createpasswordpage.text_PasswordSuccessful(), "Password changed successfully.");
			createpasswordpage.clickOk();
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		}*/
	
	
	/*
	 Validate the working of the Ok and Cancel option in the Screen lock inactivity timeout functionality
	 */
	/*@Test (priority = 12)
	public void To_Validate_working_of_Ok_and_Cancel_option_in_Screenlock_inactivity_timeout_functionality () throws InterruptedException {
	   // accountsettingspage.click_App_Lock_Option();
		applockpage = new AppLockScreen(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ScreenLockTimeOut_option();
		Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
		applockpage.click_cancel_Icon_In_screenlock();
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ScreenLockTimeOut_option();
		Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
		applockpage.click_Ok_In_Screenlock();	
	}
	
	/*
	 Validate the whether the user is able to select all timing options in Screen lock inactivity timeout functionality
	 Validate whether the selected option is displayed in the AppLock screen.
	 */
	@Test (priority = 13)
	public void To_Validate_whether_the_user_is_able_to_select_all_timing_options_in_Screenlock_inactivity_timeout_functionality_And_To_validate_whether_the_selected_option_is_displayed_in_AppLock_Screen () {
		applockpage = new AppLockScreen(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		
		Assert.assertEquals(applockpage.Showing_option_in_app_lock_screen(),"None");
		
	
		for(int i=0;i<6;i++) {
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
		applockpage.scroll_the_page(530, 1225, 100, "down");
		applockpage.click_Ok_In_Screenlock();
		}
		Assert.assertEquals(applockpage.Showing_option_in_app_lock_screen(),"30 Minutes");
		
	}
	
		
}
