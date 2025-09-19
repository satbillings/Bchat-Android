package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AppLockScreen;
import POM.ArchivedChatsScreen;
import POM.ChatScreen;
import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.NewChatScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import POM.SettingsScreen;
import TestUtiles.baseclass;

public class Archived_Chats_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;		
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	ArchivedChatsScreen archivedchatspage;
	NewChatScreen newchatpage;
	ChatScreen chatpage;
	SettingsScreen settingspage;
	WebDriverWait wait;

	@Test(priority = 0)
   	public void PreSetup() throws InterruptedException {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Openingpage = new OpeningPage(driver); 
		 Openingpage.clickSignIn(); 
		 seedpage = new SeedScreen(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.pasteSeedValue(); 
		seedpage.clickNext(); 
		restorefromseedpage = new RestoreFromSeedScreen(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.paste_Value_In_DisplayName("Sathish");
		restorefromseedpage.paste_Value_In_Blockheight("4000000");
		restorefromseedpage.clickBtnRestore(); 
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		 createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		 homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		Thread.sleep(59000);
		
	}
	
	/* Validate whether the user is able to navigate to home screen from archived chats screen */
	/*@Test (priority = 1)
	public void To_Validate_whether_the_user_is_able_to_navigate_to_home_screen_from_archived_chats_screen() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.ClickArchiveChatsOptionForFirstContactorGroup();
		homepage.ClickArchivedChatCard();
		archivedchatspage = new ArchivedChatsScreen(driver);
		Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");
		driver.navigate().back();
		
	}
	
	/* Validate whether the user is able to archive all chats (one to one, secret group and social group) */
	/*@Test (priority = 2)
	public void To_Validate_whether_the_user_is_able_to_archive_all_chats() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.ClickArchiveChatsOptionForFirstContactorGroup();
		//homepage.ClickArchiveChatsOptionForSecondContactorGroup();
		homepage.ClickArchivedChatCard();
		archivedchatspage = new ArchivedChatsScreen(driver);
		Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");
	}*/
	
	/* Validate whether archived chats counts are showing correctly */
	  /* @Test (priority = 3)
	   public void To_Validate_whether_archived_chats_counts_are_showing_correctly() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.ClickArchiveChatsOptionForFirstContactorGroup();
		Assert.assertEquals(homepage.getArchivedChatsCount(),"1");
	   }
	   
	/* Validate whether chats are not getting unarchived while sending messages  */
	  /* @Test (priority = 4)
	   public void To_Validate_whether_chats_are_not_getting_unarchived_while_sending_messages() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");  
		homepage.ClickArchivedChatCard();
		archivedchatspage = new ArchivedChatsScreen(driver);
		Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");
		archivedchatspage.ClickArchivedChatsScreenContactorGroup();
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
		chatpage.Set_Values_In_Message_textbox("hii");
		chatpage.click_Send_Button();
		chatpage.click_Back_Arrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");  
	   }
	   
	   /* Validate whether the user is able to search the archived chats */
	   /*@Test (priority = 5)
	   public void To_Validate_whether_the_user_is_able_to_search_archived_chats() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");  
		homepage.clickSearch();
		homepage.enterValues("aravind");
		Assert.assertEquals(homepage.getSearchedContact(),"aravind");  
		driver.navigate().back();
		driver.navigate().back();
	   }*/
	
	/* Validate whether cursor blinks in message text box on the Archived chat screen */
	/* Validate the presence of placeholder in message text box on the Archived chat screen */
		
		  /*@Test (priority = 6)
		   public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_in_the_message_text_box_on_the_Archieved_chat_screen(){
			  homepage = new HomeScreen(driver);
				Assert.assertEquals(homepage.Pagetitle(),"Chats");
				homepage.ClickArchiveChatsOptionForFirstContactorGroup();
				homepage.ClickArchivedChatCard();
				archivedchatspage = new ArchivedChatsScreen(driver);
				Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");	   
				archivedchatspage.ClickArchivedChatsScreenContactorGroup();
				chatpage = new ChatScreen(driver);
				chatpage.click_Textbox();
				Assert.assertTrue(chatpage.activeElement().isDisplayed());
				Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message....");	 
		  }   
		  
/* Validate the message text box in the Archive chat screen by entering the empty space */
		  
		  /*@Test (priority = 7)
		   public void To_Validate_the_message_text_box_on_the_Archieved_chat_screen_by_entering_the_empty_space(){
			    chatpage = new ChatScreen(driver);
				chatpage.Set_Values_In_Message_textbox("     ");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "     ");
				chatpage.clear_textBox();
		  }
		  
/* Validate the message text box in Archive chat screen by entering the special character 
   Validate whether the value entered in the message text box of Archive chat screen is editable and delete-able. 
*/	    
		   /* @Test(priority = 8)
			public void To_validate_the_message_textbox_in_Archive_chat_screen_by_entering_the_special_characters_To_validate_whether_the_value_entered_in_message_text_box_of_Archive_chat_screen_is_editable_deletable () throws InterruptedException {
		    	chatpage = new ChatScreen(driver);
				chatpage.Set_Values_In_Message_textbox("!@#$%^&*()");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "!@#$%^&*()");
				chatpage.clear_textBox();
		  }	
		    
/* Validate the message text box in the Archive chat screen by entering the numerical value */
			  
			  /*@Test (priority = 9)
			   public void To_Validate_the_message_text_box_on_the_Archieved_chat_screen_by_entering_the_numerical_value()throws InterruptedException{
				    chatpage = new ChatScreen(driver);
					chatpage.Set_Values_In_Message_textbox("1234567890");
					Assert.assertEquals(chatpage.get_Values_from_TextBox(), "1234567890");
					chatpage.clear_textBox();
			  }*/
	
/* Validate the message text box in the Archive chat screen by entering the alphabets both upper case and lower case letter */
	
	   @Test (priority = 10)
	   public void To_Validate_the_message_text_box_on_the_Archieved_chat_screen_by_entering_the_alphabets_both_uppercase_and_lowercase_letter()throws InterruptedException{
		    homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"Chats");
			homepage.ClickArchiveChatsOptionForFirstContactorGroup();
			homepage.ClickArchivedChatCard();
			archivedchatspage = new ArchivedChatsScreen(driver);
			Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");	   
			archivedchatspage.ClickArchivedChatsScreenContactorGroup();
			chatpage = new ChatScreen(driver);
			chatpage.click_Textbox();
			chatpage.Set_Values_In_Message_textbox("ABCDEF");
			Assert.assertEquals(chatpage.get_Values_from_TextBox(), "ABCDEF");
			chatpage.clear_textBox();
			chatpage.Set_Values_In_Message_textbox("abcdef");
			Assert.assertEquals(chatpage.get_Values_from_TextBox(), "abcdef");
			chatpage.clear_textBox();
	   }
	   
/* Validate the message text box in the Archive chat screen by entering the alphanumeric value */
		  
		  @Test (priority = 11)
		   public void To_Validate_the_message_text_box_on_the_Archieved_chat_screen_by_entering_the_alphanumeric_value()throws InterruptedException{
			    chatpage = new ChatScreen(driver);
				chatpage.Set_Values_In_Message_textbox("abc123");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "abc123");
				chatpage.clear_textBox();
		  }
		  
/* Validate the message text box in the Archive chat screen by entering the HTML value */
		  
		  @Test (priority = 12)
		   public void To_Validate_the_message_text_box_on_the_Archieved_chat_screen_by_entering_the_HTML_value()throws InterruptedException{
			    chatpage = new ChatScreen(driver);
				chatpage.Set_Values_In_Message_textbox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
				chatpage.clear_textBox();
		  }	
		  
/* Validate the message text box in the Archive chat screen by entering the decimal value */
		  
		  @Test (priority = 13)
		   public void To_Validate_the_message_text_box_on_the_Archieved_chat_screen_by_entering_the_decimal_value()throws InterruptedException{
			    chatpage = new ChatScreen(driver);
				chatpage.Set_Values_In_Message_textbox("0.00001");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "0.00001");
				chatpage.clear_textBox();
		  }	
		  
/* Validate whether user is able to paste long text in message text box on the Archive chat screen */
		  
		  @Test (priority = 14)
		   public void To_Validate_whether_user_is_able_to_paste_long_text_in_message_text_box_on_the_Archieved_chat_screen()throws InterruptedException{
			    chatpage = new ChatScreen(driver);
			    chatpage.paste_values("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
				chatpage.clear_textBox();
		  }
		  
/* Validate if already entered text is displayed in message text box after navigating to home screen and come back to Archive chat screen */		  
			
		  @Test (priority = 15)
			public void To_Validate_if_already_entered_text_is_displayed_in_the_message_textbox_after_navigating_to_home_screen_and_back_to_Archive_chat_screen () throws InterruptedException  {
			    chatpage = new ChatScreen(driver);
			    chatpage.Set_Values_In_Message_textbox("Test");
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Test");
			    chatpage.click_Back_Arrow();
			    homepage = new HomeScreen(driver);
				Assert.assertEquals(homepage.Pagetitle(),"Chats");
				//homepage.ClickArchiveChatsOptionForFirstContactorGroup();
				homepage.ClickArchivedChatCard();
				archivedchatspage = new ArchivedChatsScreen(driver);
				Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");	   
				archivedchatspage.ClickArchivedChatsScreenContactorGroup();
				chatpage = new ChatScreen(driver);
				Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Test");
		  }
		  
}
