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
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//menupage =new MenuScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		menupage.ClickAccountSettingsOption();
}
	/*
	 To Validate the working of the Show BChatId option.
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
		To validate the working of the Show BeldexAddress option.
		*/
		   /* @Test(priority = 2)
		    public void To_validate_the_working_of_the_Show_Beldex_Address_option () {
		
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.ClickBeldexAddressIcon();
			Assert.assertEquals(accountsettingspage.getPopupTitle("BeldexAddress"),"Beldex Address");
			driver.navigate().back();
		}
		/*
		To validate the working of the show QR code option. 
		*/
		  /*  @Test(priority = 3)
		    public void To_validate_the_working_of_the_Show_QrCode_option () {
		
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.ClickQRCode();
			Assert.assertEquals(accountsettingspage.getPopupTitle("QrCode"),"Scan QR code");
			driver.navigate().back();
		}
		/*
		To validate the working of the copy icon in the bchat id in both normal view and in the popup screen.
		*/
		   /* @Test(priority = 4)
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
		   /* @Test(priority = 5)
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
		   /* @Test(priority = 7)
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
		  /* @Test(priority = 8)
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
		   /* @Test(priority = 9)
		    public void To_validate_the_working_cancel_button_in_link_bns_popup_screen () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
			accountsettingspage.click_Cancel_Button_In_Popup_Screen();
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		}
		/*
		 validate whether verify button is enabled without the word .bdx in bns name
		*/
		   /* @Test(priority = 10)
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
		   /* @Test(priority = 11)
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
		  /*  @Test(priority = 12)
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
		   /* @Test(priority = 13)
		    public void To_Validate_Whether_the_screen_is_scrollable () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.scroll_the_page(100, 100, 500, "down");
			Assert.assertEquals(accountsettingspage.Content_changelog(), "Changelog");
		
		}
		/*
		   Validate the working of the FeedBack option
		*/
		   /* @Test(priority = 14)
		    public void To_Validate_the_working_of_the_FeedBack_option () {
			accountsettingspage =new AccountSettingsScreen(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Feedback_option();
			Assert.assertEquals(accountsettingspage.feedback_mail_Id(), "feedback@beldex.io");
			
		}
	/*
	   Validate whether able to navigate back to the my account screen from Gmail screen.
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
 	Validate the working of the FAQ option. 
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
	   /* @Test(priority = 17)
        public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_From_FAQ_Screen () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.FAQ_Page_Title(), "Frequently Asked Questions");
		driver.navigate().back();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	/*
	 Validate the working of the change log option.
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
	   Validate Whether change log screen is scrollable.
	*/
	    /*@Test(priority = 20)
	    public void To_Validate_Whether_changelog_screen_is_scrollable () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.scrollgesture_Using_text("2.6.0");
		Assert.assertTrue(accountsettingspage.lastLog().isDisplayed());
	}
	/*
	Validate whether able to navigate back to the my account screen from change log screen.
	*/
	    /*@Test(priority = 21)
	    public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_from_changeLog_screen () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.Click_back_arrow();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}*/
	    
/* Validate if it goes to the gallery after clicking the gallery option in the upload picture functionality */
	    
	   /* @Test(priority = 22)
	    public void To_Validate_if_it_goes_to_the_gallery_after_clicking_the_gallery_option_in_the_upload_picture_functionality () {
		accountsettingspage =new AccountSettingsScreen(driver);
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickUploadPictureButton();
		accountsettingspage.ClickGalleryOption();
		driver.navigate().back();
	    }*/
	    
 /* Validate if it goes to the Camera after clicking the Camera option in the upload picture functionality */
	    
	   /* @Test(priority = 23)
	    public void To_Validate_if_it_goes_to_the_Camera_after_clicking_the_Camera_option_in_the_upload_picture_functionality () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickUploadPictureButton();   
		accountsettingspage.ClickCameraOption();
		driver.navigate().back();
	    }

/* Validate the working of the remove picture function when profile picture is not uploaded */
	    
	    /*@Test(priority = 24)
	    public void To_Validate_the_working_of_the_remove_picture_functionality_when_profile_picture_is_not_uploaded () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickCameraIcon(); 	    
		accountsettingspage.ClickRemovePictureButton();   
	    }
	
/* Validate the working of the (x) cancel icon in the profile picture popup */

	   /* @Test(priority = 25)
	    public void To_Validate_the_working_of_the_Close_icon_in_the_profile_picture_popup () {
		accountsettingspage =new AccountSettingsScreen(driver);  
		accountsettingspage.ClickCloseIconInProfilePicturePopup();
	    }*/
	    
/* Validate whether user is able to set profile picture using camera option */
	    
	    /*@Test(priority = 26)
	    public void To_Validate_whether_user_is_able_to_set_profile_picture_using_camera_option () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickUploadPictureButton();
		accountsettingspage.ClickCameraOption();
		accountsettingspage.ClickCaptureButton();
        Thread.sleep(2000);
        accountsettingspage.ClickCaptureDoneButton();
        accountsettingspage.ClickCropIcon();
        Thread.sleep(2000);
        accountsettingspage.ClickDoneButton();
	    }
	
/* Validate the working of the Remove picture functionality when profile picture is uploaded */	 
	    
	    /*@Test(priority = 27)
	    public void To_Validate_the_working_of_the_Remove_picture_functionality_when_profile_picture_is_uploaded () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickRemovePictureButton();   
		Thread.sleep(2000);
        accountsettingspage.ClickDoneButton();
	    }
	    
/* Validate whether user is able to change the profile picture multiple times */

	   /* @Test(priority = 28)
	    public void To_Validate_whether_user_is_able_to_change_the_profile_picture_multiple_times () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver); 
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ChangeProfilePictureMultipleTimes();
	    }
	    
/* Validate whether user is able to set profile picture using camera option without internet connection */	
	 
	   /* @Test(priority = 29)
	    public void To_Validate_whether_user_is_able_to_set_profile_picture_using_camera_option_without_internet_connection () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings"); 
		Thread.sleep(5000);	
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);	
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickUploadPictureButton();
        Thread.sleep(5000);	
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);	
		}*/	    
	    
/* Validate the cursor blink in Profile Name Edit text box on the Account Settings screen */
	    
	    /*@Test(priority = 30)
	    public void To_Validate_the_cursor_blink_in_Profile_Name_Edit_textbox_on_the_Account_settings_screen () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings"); 
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickProfileNameEditTextBox();
		Assert.assertTrue(accountsettingspage.activeElement().isDisplayed());
	    }
	    
/* Validate the Profile Name Edit text box in Account Settings screen by entering the empty space value */

	   /* @Test(priority = 31)
	    public void To_Validate_the_Profile_name_edit_text_box_in_Account_settings_screen_by_entering_the_empty_space_value () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("          ");
		accountsettingspage.ClearProfileNameEditTextBox();
	    }
	    
/* Validate the Profile Name Edit text box in Account Settings screen by entering the special characters 
 * Validate whether the value entered in the Profile Name Edit text box of Account Settings screen is editable and delete-able
 * */
	    
	   /* @Test(priority = 32)
	    public void To_Validate_the_Profile_name_edit_text_box_in_Account_settings_screen_by_entering_the_special_characters_To_validate_whether_the_value_entered_in_the_Profile_name_edit_text_box_of_Account_settings_screen_is_editable_and_deletable () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("!@#$%^&*()_");
		accountsettingspage.ClearProfileNameEditTextBox();
	    }    
	    
/* Validate whether user is able to remove profile picture without internet connection */	
		 
	   /* @Test(priority = 33)
	    public void To_Validate_whether_user_is_able_to_remove_profile_picture_without_internet_connection () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings"); 
		//turnOff_Mobile_Wifi();
		//Thread.sleep(5000);	
		//accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickUploadPictureButton();
		accountsettingspage.ClickCameraOption();
		accountsettingspage.ClickCaptureButton();
        Thread.sleep(2000);
        accountsettingspage.ClickCaptureDoneButton();
        accountsettingspage.ClickCropIcon();
        Thread.sleep(6000);
        //accountsettingspage.ClickDoneButton();
        turnOff_Mobile_Wifi();
      	Thread.sleep(5000);	
		accountsettingspage.ClickCameraIcon();
		accountsettingspage.ClickRemovePictureButton();	 
		Thread.sleep(6000);	
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
	    } */
	    
/* Validate the Profile Name Edit text box in Account Settings screen by entering the numerical value */
	    
	   /* @Test(priority = 34)
	    public void To_Validate_the_Profile_name_edit_text_box_in_Account_settings_screen_by_entering_the_numerical_value () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickProfileNameEditTextBox();
		accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("1234567890");
		accountsettingspage.ClearProfileNameEditTextBox();
	    }  
	    
/* Validate the Profile Name Edit text box in Account Settings screen by entering the alphabets both in uppercase and lowercase letter */
	    
	   /* @Test(priority = 35)
	    public void To_Validate_the_Profile_name_edit_text_box_in_Account_settings_screen_by_entering_the_alphabets_both_in_uppercase_and_lowercase_letter () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("ABCDEF");
		accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("abcdef");
		accountsettingspage.ClearProfileNameEditTextBox();
	    }  
	    
/* Validate whether the user is able enter a lengthy value in the Profile Name Edit text box in Account Settings screen */
	    
	    /*@Test(priority = 36)
		public void To_validate_whether_the_user_is_able_to_enter_lengthy_value_in_Profile_Name_Edit_text_box_in_Account_settings_screen() throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("Hii hello are you there to here that in the message and ok then now its ok mm hmm ok");
		accountsettingspage.ClearProfileNameEditTextBox(); 
	    }
	    
/* Validate the Profile Name Edit text box in Account Settings screen by entering the empty profile name */
	    
	    /*@Test(priority = 37)
	    public void To_Validate_the_Profile_name_edit_text_box_in_Account_settings_screen_by_entering_the_empty_profile_name () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings"); 
		accountsettingspage.ClickDoneButton();
		
	    }
	    
/* Validate the Profile Name Edit text box in Account Settings screen by entering the valid name */
	    
	    /*@Test(priority = 38)
	    public void To_Validate_the_Profile_name_edit_text_box_in_Account_settings_screen_by_entering_the_valid_name () throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		//Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		Thread.sleep(4000);
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickProfileNameEditTextBox();
		//accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("Billings");
		accountsettingspage.ClickDoneButton();
	    } */
	    
/* Validate whether user is able to set same profile name again in Profile Name Edit text box in Account Settings screen */
	    
	    @Test(priority = 39)
	    public void To_Validate_whether_user_is_able_to_set_same_profile_name_again_in_profile_name_edit_text_box_in_Account_settings_screen() throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickProfileNameEditTextBox();
		accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("Sat");
		accountsettingspage.ClickDoneButton();
	    }
	    
/*  Validate whether user is able to set profile name as empty space in Profile Name Edit text box in Account Settings screen */
	    
	    @Test(priority = 40)
	    public void To_Validate_whether_user_is_able_to_set_profile_name_as_empty_space_in_profile_name_edit_text_box_in_Account_settings_screen() throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings"); 
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickProfileNameEditTextBox();
		accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Set_Values_In_ProfileName_EditTextBox("      ");
		accountsettingspage.ClickDoneButton();
	    }
	    
/* Validate whether the paste option is working on the Profile Name Edit text box in Account Settings screen */
	    
	    @Test(priority = 41)
	    public void To_Validate_whether_the_paste_option_is_working_on_the_profile_name_edit_text_box_in_Account_settings_screen() throws InterruptedException {
		accountsettingspage =new AccountSettingsScreen(driver);
		//Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");  
		Thread.sleep(4000);
		accountsettingspage.ClickPictureEditOption();
		accountsettingspage.ClickProfileNameEditTextBox();
		accountsettingspage.ClearProfileNameEditTextBox();
		accountsettingspage.Paste_values_In_ProfileName_EditTextBox("Hales");
		accountsettingspage.ClearProfileNameEditTextBox();
	    }
	              
}
