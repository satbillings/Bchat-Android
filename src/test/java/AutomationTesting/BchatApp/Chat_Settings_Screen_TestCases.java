package AutomationTesting.BchatApp;

//import java.awt.Robot;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.AppLockScreen;
import POM.ChatSettingsScreen;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.HopsScreen;
import POM.MenuScreen;
import POM.NoteToSelfChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Chat_Settings_Screen_TestCases extends baseclass {
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
	NoteToSelfChatScreen notetomyselfpage;
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
		//menupage =new MenuScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		menupage.click_Account_Settings();
		accountsettingspage =new AccountSettingsScreen(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_option_Chat_settings();
	}
	/*
	Validate whether able to navigate back to the my account screen from chat settings screen
	*/
	/*@Test(priority = 1)
	public void To_Validate_whether_Able_to_navigate_back_to_my_account_screen_from_chat_settings_screen () {
		
		chatsettingspage=new ChatSettingsScreen(driver);
		Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		chatsettingspage.click_Back_Arrow();
		accountsettingspage =new AccountSettingsScreen(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}
	/*
	Validate the working of the enter key send option in the messaging screen in ON condition.
    */
   /*@Test(priority = 2)
	public void To_Validate_working_of_enter_key_send_option_in_messaging_screen_in_ON_condition () {
	  
		
		// accountsettingspage =new AccountSettingsScreen(driver);
		// Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		 //accountsettingspage.click_option_Chat_settings();
       chatsettingspage = new ChatSettingsScreen(driver);
   	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
   	   chatsettingspage.click_Swipe_button_In_Enter_key();
   	   chatsettingspage.click_Back_Arrow();
   	   driver.navigate().back();
     	homepage = new HomeScreen(driver);
	homepage.clickSearch();
	homepage.click_Option_Note_To_Myself();
	notetomyselfpage = new NoteToSelfChatScreen(driver); 
	notetomyselfpage.clickTextBox();
	notetomyselfpage.Set_Values_In_Message_textbox("Hello");
   //	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
   	Assert.assertTrue(notetomyselfpage.SendMessageCard().isDisplayed());   
   	notetomyselfpage.click_Back_Arrow(); 
	   	   
   }
   /*
	Validate the working of the enter key send option in the messaging screen in OFF condition.
	*/
  /*@Test(priority =3)
  public void To_Validate_working_of_enter_key_send_option_in_messaging_screen_in_OFF_condition () {
	   	homepage = new HomeScreen(driver);
	   	homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		menupage.click_Account_Settings();
       accountsettingspage =new AccountSettingsScreen(driver);
       Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
       accountsettingspage.click_option_Chat_settings();
       chatsettingspage = new ChatSettingsScreen(driver);
       Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
       chatsettingspage.click_Swipe_button_In_Enter_key();
   	  
   	   chatsettingspage.click_Back_Arrow();
   	   driver.navigate().back();
   	
	homepage.clickSearch();
	homepage.click_Option_Note_To_Myself();
	notetomyselfpage = new NoteToSelfChatScreen(driver); 
   	notetomyselfpage.clickTextBox();
   	notetomyselfpage.Set_Values_In_Message_textbox("Hii");
    //((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
   	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
	Assert.assertNotEquals(notetomyselfpage.get_Send_Message_Value(), "Hii");
	notetomyselfpage.click_Back_Arrow();  
	
  }
  /*
  Validate Whether option in message trimming are clickable without enabled delete old messages
	*/
 /*@Test(priority = 4)
 public void To_Validate_Whether_option_in_message_trimming_are_clickabble_without_enabled_delete_old_messages () {
	   homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		menupage.click_Account_Settings();
     accountsettingspage =new AccountSettingsScreen(driver);
     Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
     accountsettingspage.click_option_Chat_settings();
     chatsettingspage = new ChatSettingsScreen(driver);
 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	   chatsettingspage.click_Option_Conversation_Length();
 	   Assert.assertEquals(chatsettingspage.pageTitle(), "Chat Settings");
 	chatsettingspage.click_option_Trim_conversation();
	   Assert.assertEquals(chatsettingspage.pageTitle(), "Chat Settings");
 }
 /*
 Validate the Whether able to change the value in the conversation length limit
  */
/* @Test(priority = 5)
  public void To_Validate_the_Whether_able_to_change_the_value_in_the_conversation_length_limit () {
	  
	  chatsettingspage = new ChatSettingsScreen(driver);
 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	   chatsettingspage.click_Swipe_button_In_delete();
 	   chatsettingspage.click_Option_Conversation_Length();
 	   Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
 	   chatsettingspage.change_Value_In_Conversation_Length("100");
 	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),100);
 	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  
 }
 /*
 Validate whether entered value in conversation length limit field is displayed chat Setting Screen.
  Validate whether the value entered in Conversation length limit field is editable and deleteable.
 */
/*@Test(priority =6)
public void To_Validate_whether_entered_value_in_conversation_length_limit_field_is_displayed_In_Chat_Settings_screen_To_validate_whether_the_value_entered_in_conversation_length_limit_field_is_editable_and_deleteable () {
	  chatsettingspage = new ChatSettingsScreen(driver);
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   chatsettingspage.click_Option_Conversation_Length();
	  Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	   chatsettingspage.change_Value_In_Conversation_Length("200");
	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),200);
	  chatsettingspage.click_Option_Conversation_Length();
	  Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	   chatsettingspage.change_Value_In_Conversation_Length("300");
	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),300);
	   
	
}*/
	 /*
	  Validate the working of the Ok and cancel buttons in conversation length
		*/
	  @Test(priority = 7)
	  public void To_Validate_the_working_of_Ok_and_cancel_buttons_in_conversation_length () {
		  chatsettingspage = new ChatSettingsScreen(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   chatsettingspage.click_Swipe_button_In_delete();
	 	  chatsettingspage.click_Option_Conversation_Length();
	 	   Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	 	   chatsettingspage.click_Cancel_In_conversation_Length_Popup();
	 	  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	  chatsettingspage.click_Option_Conversation_Length();
	 	 Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
		   chatsettingspage.click_Ok_In_Conversation_Popup();
		  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  }
	  /*
	  Validate the working of the delete button in the Delete all old messages now
	 	*/
	   @Test(priority = 8) 
	   public void To_Validate_the_working_of_delete_button_in_Delete_all_old_messages_now () {
	 	  chatsettingspage = new ChatSettingsScreen(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   chatsettingspage.click_option_Trim_conversation();
	 	   Assert.assertEquals(chatsettingspage.Delete_Old_Messages_Popup_Title(),"Delete All Old Messages Now?");
	 	  //chatsettingspage.click_delete_In_Delete_Messages_Popup();
	 	try {
	 		 chatsettingspage.click_delete_In_Delete_Messages_Popup();
	 	   Assert.assertEquals(Toast(),"Old messages successfully deleted");
	 	 }
	 	 catch (StaleElementReferenceException e) {
	 		 chatsettingspage.click_option_Trim_conversation();
	 		 chatsettingspage.click_delete_In_Delete_Messages_Popup();
	 		 Assert.assertEquals(Toast(),"Old messages successfully deleted");
	 	}
	 	 catch (NoSuchElementException e) {
	 		 chatsettingspage.click_option_Trim_conversation();
	 		 chatsettingspage.click_delete_In_Delete_Messages_Popup();
	 		 Assert.assertEquals(Toast(),"Old messages successfully deleted");
	 	}
	 	 
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	  
	 	   
	   }
	   /*
	   Validate the working of the cancel button in the Delete all old messages now
	     */
	    @Test(priority =9 )
	    public void To_Validate_working_of_cancel_button_in_Delete_all_old_messages_now () {
	 	   chatsettingspage = new ChatSettingsScreen(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   chatsettingspage.click_option_Trim_conversation();
	 	   Assert.assertEquals(chatsettingspage.Delete_Old_Messages_Popup_Title(),"Delete All Old Messages Now?");
	 	   chatsettingspage.click_Cancel_In_Delete_Messages_Popup();
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	    }
	    /*
	    Validate Conversation length limit field Whether allowing space.
	    */
	    @Test(priority = 10)
	    public void To_Validate_Conversation_length_limit_field_Whether_allowing_space () {
	 	   chatsettingspage = new ChatSettingsScreen(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   chatsettingspage.click_Option_Conversation_Length();
	 	   chatsettingspage.set_Space_Inbetween_Values();
	 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),200);
	 	   
	    }
	    /*
	    validate whether paste option is working on Conversation length limit field.
	    */
	    @Test(priority = 11)
	    public void To_Validate_whether_paste_option_is_working_on_Conversation_length_limit_field () {
	 	   chatsettingspage = new ChatSettingsScreen(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   chatsettingspage.click_Option_Conversation_Length();
	 	   chatsettingspage.Copy_And_Paste_Values();
	 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),500);
	    }
	    /*	    Validate whether crusher blink in Conversation length limit field while clicking.
	    */
	   @Test(priority = 12)
	   public void To_Validate_whether_crusher_blink_in_Conversation_length_limit_field_while_clicking () {
		   chatsettingspage = new ChatSettingsScreen(driver);
		   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		   chatsettingspage.click_Option_Conversation_Length();
		   chatsettingspage.click_conversation_Length_text_box();
		   WebElement active=driver.switchTo().activeElement();
			Assert.assertTrue(chatsettingspage.activeElement().equals(active));
	   }
}
