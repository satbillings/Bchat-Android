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
	  @Test (priority = 1)
	   public void To_Validate_working_of_Gif_icon_in_attachments_To_validate_working_of_the_Ok_button_in_search_Gif_popup_To_validate_working_of_back_arrow_in_Gif_and_Stickers_screen() {
		chatpage = new ChatScreen(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Aravind");
		chatpage.ClickAttachmentsIcon();
		chatpage.ClickGifOption();
		chatpage.ClickOkButtonInSearchGifPopup();
		gifandstickerspage = new GifAndStickersScreen(driver);
		Assert.assertEquals(gifandstickerspage.getGifTitle(),"GIFS");
		gifandstickerspage.ClickBackArrow();
	 }
}
