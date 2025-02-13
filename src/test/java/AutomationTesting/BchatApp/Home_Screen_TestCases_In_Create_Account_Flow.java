package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordScreen;
import POM.CreateSecretGroupScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.JoinSocialGroupScreen;
import POM.MenuScreen;
import POM.NewChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Home_Screen_TestCases_In_Create_Account_Flow extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
    RegisterScreen registerpage;
	MenuScreen menupage;
	JoinSocialGroupScreen joinsocialgrouppage;
	NewChatScreen newchatpage;
	CreateSecretGroupScreen createsecretgrouppage;
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
		Thread.sleep(10000);
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
		
	}
	
	/*
	Validate the all possible navigation from the home screen in both forward and backward direction
	Validate whether able to navigate to the device home page directly.
	*/
	/*@Test(priority = 1)
	public void To_Validate_navigation_from_the_home_screen_in_both_forward_and_backward_direction_To_validate_whether_able_to_navigate_to_the_device_home_page_directly () throws InterruptedException {
		//homepage = new HomeScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
		driver.navigate().back();
		 driver.navigate().back();
		// if(Openingpage.WebElementAppList().isDisplayed()||Openingpage.WebElementAppList().isDisplayed()) {
				Openingpage.swipeGesture(100, 100, 200, 200, "UP");
			 Openingpage.openApp();
	//}
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	/*
	 Validate the blank screen While creating new Account
	 */
	/*@Test(priority = 2)
	public void To_Validate_the_blank_screen_While_creating_new_Account () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertTrue(homepage.BlankChatScreen.isDisplayed());
	}
	/*
	Validate the navigation to the settings screen in both forward and backward direction.
	*/
	@Test(priority = 3)
	public void To_Validate_the_Navigation_to_the_Menu_screen_in_both_forward_and_backward_direction() {
		//homepage = new HomeScreen(driver);
		menupage =new MenuScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		Assert.assertEquals(menupage.pagetitle(), "Menu");
		homepage.ClickCancel();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	/*
	Validate the navigation to the Search screen in both forward and backward direction.
	*/
	@Test(priority = 4)
	public void To_Validate_the_Navigation_to_the_search_screen_in_both_forward_and_backward_direction() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickSearch();
		//Assert.assertEquals(homepage.searchTitle(), "Search");
	  // homepage.clickBackArrow();
	     driver.navigate().back();
	     driver.navigate().back();
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
	   
	}
	/*
	 Validate the navigation to the new chat screen
	 */
	
	@Test(priority=5)
	public void To_validate_the_navigation_to_newChat_screen (){
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		newchatpage = new NewChatScreen(driver);
		Assert.assertEquals(newchatpage.Pagetitle(), "New Chat");
		//homepage.clickBackArrow();
		driver.navigate().back();
	}
	/*
	 validate the navigation to the create secret group screen	
   */
	@Test(priority=6)
	public void To_validate_the_navigation_to_Create_SecretGroup_screen () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openNewSecretGroup();
		createsecretgrouppage =new CreateSecretGroupScreen(driver);
		Assert.assertEquals(createsecretgrouppage.Pagetitle(), "Secret Group");
		//homepage.clickBackArrow();
		driver.navigate().back();
	}
	/*
	  Validate the navigation to the join social group screen
	 */
	@Test(priority=7)
	public void To_validate_the_navigation_to_Join_Social_screen () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenJoinSocialGroup();
		joinsocialgrouppage = new JoinSocialGroupScreen(driver);
		Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
		//homepage.clickBackArrow();
		driver.navigate().back();
	}


	
}
