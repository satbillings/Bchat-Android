package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatScreen;
import POM.CreatePasswordScreen;
import POM.GifAndStickersScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Gif_And_Stickers_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;		
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	ChatScreen chatpage;
	GifAndStickersScreen gifandstickerspage;
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
		homepage.ClickFirstContactorGroup();
	}
	
	/* Validate the working of the gif icon in the attachments
	 * Validate the working of the ok button in search gif popup
	 * Validate the working of the back arrow in the gif and sticker screen */
	 /* @Test (priority = 1)
	   public void To_Validate_working_of_Gif_icon_in_attachments_To_validate_working_of_the_Ok_button_in_search_Gif_popup_To_validate_working_of_back_arrow_in_Gif_and_Stickers_screen() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
		chatpage.ClickAttachmentsIcon();
		chatpage.ClickGifOption();
		chatpage.ClickOkButtonInSearchGifPopup();
		gifandstickerspage = new GifAndStickersScreen(driver);
		Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
		gifandstickerspage.ClickBackArrow();
	 }*/
	
	/* Validate the working of the Cancel button in search Gif popup */
	  /* @Test (priority = 2)
	   public void To_validate_working_of_the_Cancel_button_in_search_Gif_popup() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
		chatpage.ClickAttachmentsIcon();
		chatpage.ClickGifOption();
		chatpage.ClickCancelButtonInSearchGifPopup();
	   }
	   
	/* Validate the working of the different view option in Gif and Stickers screen */
	 /*  @Test (priority = 3)
	   public void To_validate_the_working_of_the_different_view_option_in_Gif_and_Stickers_screen() throws InterruptedException {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
		chatpage.ClickAttachmentsIcon();
		chatpage.ClickGifOption();
		chatpage.ClickOkButtonInSearchGifPopup(); 
		gifandstickerspage = new GifAndStickersScreen(driver);
		Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
		gifandstickerspage.ClickViewOption();
		Thread.sleep(2000);
		gifandstickerspage.ClickAnotherViewOption();
		gifandstickerspage.ClickBackArrow();
		
	   }
	   
	   /* Validate whether the user is able to open the gif and sticker screen without internet connection */
		/*  @Test (priority = 4)
		   public void To_validate_whether_the_user_is_able_to_open_the_gif_and_stickers_screen_without_internet_connection() throws InterruptedException {
			chatpage = new ChatScreen(driver);
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
			turnOff_Mobile_Wifi();
			Thread.sleep(4000);
			chatpage.ClickAttachmentsIcon();
			chatpage.ClickGifOption();
			Thread.sleep(4000);
			turnOn_Mobile_Wifi();	
			Thread.sleep(5000);
		   }  
		  
      /* Validate whether the user is able to send Gif and Stickers */
		  /*@Test (priority = 5)
		   public void To_validate_whether_the_user_is_able_to_send_gif_and_stickers() throws InterruptedException {
			chatpage = new ChatScreen(driver);
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
			//chatpage.ClickAttachmentsIcon();
			chatpage.ClickGifOption();
			gifandstickerspage = new GifAndStickersScreen(driver);
			Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
			gifandstickerspage.ClickGif();
			Thread.sleep(8000);
			chatpage = new ChatScreen(driver);
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
			chatpage.ClickAttachmentsIcon();
			chatpage.ClickGifOption();
			gifandstickerspage = new GifAndStickersScreen(driver);
			Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
			gifandstickerspage.ClickStickersOption();
			gifandstickerspage.ClickStickers();
			Thread.sleep(8000);
		  }  */
	
	/* Validate whether send or received gifs or stickers showing in all media */
	    /*@Test (priority = 6)
	    public void To_validate_whether_send_or_received_gif_and_stickers_is_showing_all_media_section() throws InterruptedException {
		chatpage = new ChatScreen(driver);
		//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bd68a48ca4fb888...");
		Thread.sleep(5000);
		chatpage.OpenAllMedia();
		driver.navigate().back();
	    }
	
	  /* Validate the cursor blinks inside the search text box while clicking at the search text box in Gif and Stickers screen */
	   /* @Test (priority = 7)
	   public void To_validate_the_cursor_blinks_inside_the_search_text_box_while_clicking_at_the_search_text_box_in_Gif_and_stickers_screen() throws InterruptedException {
	    chatpage = new ChatScreen(driver);
		//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bd68a48ca4fb888...");  
		chatpage.ClickAttachmentsIcon();
		chatpage.ClickGifOption();
		chatpage.ClickOkButtonInSearchGifPopup(); 
		gifandstickerspage = new GifAndStickersScreen(driver);
		Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
		gifandstickerspage.ClickSearchTextBox();
		Assert.assertTrue(gifandstickerspage.activeElement().isDisplayed());
	    }
	    
	    /* Validate the presence of placeholder inside the search text box in Gif and Stickers screen */
	   /* @Test (priority = 8)
	   public void To_validate_the_presence_of_placeholder_of_search_text_box_in_Gif_and_stickers_screen() throws InterruptedException {
		gifandstickerspage = new GifAndStickersScreen(driver);
		Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
		//gifandstickerspage.ClickSearchTextBox();
		Assert.assertEquals(gifandstickerspage.getSearchPlaceHolder(),"Search");
	    }*/
	
	/* Validate whether the user is able to forward Gif in chat screen */
   /* @Test (priority = 9)
    public void To_validate_whether_the_user_is_able_to_forward_Gif_in_chat_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	Thread.sleep(7000);
	chatpage.ClickGifMediaMessage();
	chatpage.ClickForwardOption();
	Assert.assertEquals(chatpage.getForwardScreenTitle(),"Forward");
	driver.navigate().back();
	chatpage.ClickMediaPreview();
	chatpage.ClickForwardScreenBackArrow();
	//driver.navigate().back();
    }
    
    /* Validate whether the user is able to reply to gif in chat screen */
   /* @Test (priority = 10)
    public void To_validate_whether_the_user_is_able_to_reply_to_Gif_in_chat_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	chatpage.ReplyGifMediaMessage("hii");
	Thread.sleep(3000);
    }
    
   /* Validate whether the user is able to delete gif in chat screen */
   /* @Test (priority = 11)
    public void To_validate_whether_the_user_is_able_to_delete_Gif_in_chat_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	chatpage.DeleteGifMediaMessage();
	Thread.sleep(3000);
    }*/ 
	
	/* Validate whether the user is able to save Gif in chat screen */
	@Test (priority = 12)
    public void To_validate_whether_the_user_is_able_to_save_Gif_in_chat_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	Thread.sleep(10000);
	chatpage.ClickGifMediaMessage();
	Thread.sleep(2000);
	chatpage.ClickSaveOption();
	Thread.sleep(2000);
	chatpage.ClickSaveToStoragePopupYesButton();
	chatpage.ClickMediaPreview();
	chatpage.ClickForwardScreenBackArrow();
	}
	
	/*Validate whether the user is able to multi select Gif in Gif and Stickers screen */
    @Test (priority = 13)
    public void To_validate_whether_the_user_is_able_to_multiselect_Gif_in_Gif_and_Stickers_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	chatpage.ClickAttachmentsIcon();
	chatpage.ClickGifOption();
	chatpage.ClickOkButtonInSearchGifPopup(); 
	gifandstickerspage = new GifAndStickersScreen(driver);
	Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
	Thread.sleep(5000);
	gifandstickerspage.ClickGif();
	//Assert.assertNotEquals(gifandstickerspage.getGifTitle(),"GIFS");

    }
    
  /* Validate whether user is able to navigate between Gif and Stickers option in Gif and Stickers Screen */
    @Test (priority = 14)
    public void To_validate_whether_the_user_is_able_to_navigate_between_Gif_and_Stickers_option_in_Gif_and_Stickers_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
	chatpage.ClickAttachmentsIcon();
	chatpage.ClickGifOption();
	//chatpage.ClickOkButtonInSearchGifPopup(); 
	gifandstickerspage = new GifAndStickersScreen(driver);
	Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS"); 
	gifandstickerspage.ClickStickersOption();
	gifandstickerspage.ClickGifsOption();
	gifandstickerspage.ClickStickersOption();
	gifandstickerspage.ClickGifsOption();
	gifandstickerspage.ClickBackArrow();
    }
    
   /* Validate whether the user is able to delete the gifs and stickers by multiselecting in all media screen */
    
    @Test (priority = 15)
    public void To_validate_whether_the_user_is_able_to_delete_Gif_and_Stickers_by_multiselecting_in_all_media_screen () throws InterruptedException {
	chatpage = new ChatScreen(driver);
	//Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind"); 
	chatpage.OpenAllMedia();
	chatpage.MultiSelectMedia();
	chatpage.ClickDeleteOptionInAllMedia();
	chatpage.ClickDeleteButtonInAllMedia();
    }



}
