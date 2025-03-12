package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AppLockScreen;
import POM.ArchivedChatsScreen;
import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Archived_Chats_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;		
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	ArchivedChatsScreen archivedchatspage;
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
	@Test (priority = 1)
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
	@Test (priority = 2)
	public void To_Validate_whether_the_user_is_able_to_archive_all_chats() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.ClickArchiveChatsOptionForFirstContactorGroup();
		//homepage.ClickArchiveChatsOptionForSecondContactorGroup();
		homepage.ClickArchivedChatCard();
		archivedchatspage = new ArchivedChatsScreen(driver);
		Assert.assertEquals(archivedchatspage.getArchivedChatsScreenTitle(),"Archived Chats");
		
	}
		
}
