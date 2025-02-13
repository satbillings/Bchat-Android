package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePINScreen;
import POM.CreatePasswordScreen;
import POM.CreateSecretGroupScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.JoinSocialGroupScreen;
import POM.MenuScreen;
import POM.NewChatScreen;
import POM.NoteToSelfChatScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import POM.SettingsScreen;
import TestUtiles.baseclass;
import io.appium.java_client.TouchAction;

public class Menu_Drawer_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	// RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
	RegisterScreen registerpage;
	MenuScreen menupage;
	SettingsScreen settingspage;
	CreatePINScreen createpinpage;
	NoteToSelfChatScreen notetomyselfpage;
	WebDriverWait wait;

	@Test(priority = 0)
	public void PreSetup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
		displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
		displaynamepage.setDisplayName("Sat");
		displaynamepage.clickContinue();
		registerpage = new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.TextPageTitle));
		Assert.assertEquals(registerpage.pageTitle(), "Register");
		Thread.sleep(10000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		createpasswordpage.setValidPassword();
		// createpasswordpage.clickOk();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		recoveryphrasepage = new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		Thread.sleep(5000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		// menupage =new MenuScreen(driver);
		// Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		// Assert.assertEquals(menupage.pagetitle(), "Menu");
	}

	/*
	 * Validate whether entered display name is showing in profile name.
	 */
	/*
	 * @Test (priority = 1) public void
	 * To_Validate_whether_entered_display_name_is_showing_in_profile_name () {
	 * 
	 * menupage =new MenuScreen(driver);
	 * Assert.assertEquals(menupage.pagetitle(),"Menu");
	 * Assert.assertEquals(menupage.getProfileName(), "Sat");
	 * 
	 * } /* TC_249 Validate whether the icons and functions present in the Settings
	 * screen response for the touch action.
	 */
	/*
	 * @Test (priority = 2) public void
	 * TC_249_To_Validate_Whether_icon_Response_For_touch_action (){ menupage =new
	 * MenuScreen(driver); Assert.assertEquals(menupage.pagetitle(),"Menu");
	 * menupage.click_My_Account_option(); driver.navigate().back();
	 * 
	 * } /* Validate the working of the scrolling action in both upward and downward
	 * direction.
	 */
	/*
	 * @Test (priority = 3) public void
	 * To_Validate_Whether_Screen_is_Scrollable_in_both_upward_and_downward_direction
	 * () throws InterruptedException { //homepage.clickMenuDrawer();
	 * //Assert.assertEquals(menupage.pagetitle(), "Menu"); menupage =new
	 * MenuScreen(driver); Assert.assertEquals(menupage.pagetitle(),"Menu");
	 * Thread.sleep(3000); menupage.swipeGesture(100, 100, 200, 200, "UP");
	 * //Thread.sleep(2000); //menupage.swipeGesture(100, 100, 200, 200, "down");
	 * //menupage.Scroll_the_Screen(optionAbout); //menupage.scroll_the_page(700,
	 * 750, 300, "down"); // menupage.Scroll_the_Screen(optionAbout);
	 * //menupage.scrollgesture_Using_text("About");
	 * //menupage.scrollgesture_Using_text("Account Settings");
	 * //Assert.assertEquals(menupage.contentAbout(), "About"); }
	 */
	/*
	 * Validate the working of the cancel icon in menu screen.
	 * 
	 */
	/*@Test(priority = 3)
	public void To_Validate_the_working_of_the_Cancel_Icon_in_Menu_Screen() throws InterruptedException {

		menupage = new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(), "Menu");
		menupage.ClickCloseIcon();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
	}

	/* Help Screen */
	/*
	 * Validate the working of help functionality in menu screen.
	 */
/*	@Test(priority = 4)
	public void To_Validate_the_working_of_help_functionality_in_menu_Screen() {
		homepage = new HomeScreen(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(), "Menu");
		menupage.ClickOptionHelp();
		Assert.assertTrue(menupage.getElementofGmailScreen().isDisplayed());
		// driver.navigate().back();
		// driver.navigate().back();
	}

	/*
	 * Validate the Gmail id in the Gmail screen by clicking the help option in menu
	 * screen.
	 */
	/*@Test(priority = 5)
	public void To_Validate_the_Gmail_id_in_Gmail_screen_by_clicking_the_help_option_in_menu_screen() {
		menupage = new MenuScreen(driver);
		Assert.assertTrue(menupage.getElementofGmailScreen().isDisplayed());
		Assert.assertEquals(menupage.getSupportMailId(), "support beldex");
	}

	/*
	 * Validate whether the user is able to navigate back to the home screen from
	 * Gmail screen.
	 */
	/*@Test(priority = 6)
	public void To_Validate_whether_the_user_is_able_to_navigate_back_to_home_screen_from_Gmail_screen() {
		menupage = new MenuScreen(driver);
		Assert.assertTrue(menupage.getElementofGmailScreen().isDisplayed());
		driver.navigate().back();
		driver.navigate().back();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
	}

	/* Theme Change Functionality */
	/*
	 * Validate the working of theme change button in menu screen.
	 */
	/*@Test(priority = 7)
	public void To_validate_the_working_of_theme_Change_button_in_menu_screen() {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(), "Menu");
		menupage.ClickThemeChangeButton();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
	}

	/*
	 * Validate whether the user is able to click the theme change button multiple
	 * times in menu screen.
	 */
	/*@Test(priority = 8)
	public void To_validate_whether_the_user_is_able_to_click_theme_change_button_multiple_times_in_menu_screen() {
		for (int i = 0; i <= 5; i++) {
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(), "BChat");
			homepage.clickMenuDrawer();
			menupage = new MenuScreen(driver);
			menupage.ClickThemeChangeButton();
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(), "BChat");
		}
	}*/
	
	/* Settings Screen */

	/*
	 Validate whether the user is able to navigate back to the menu screen from settings screen.
	 */
	/*@Test(priority = 9)
	public void To_Validate_whether_the_user_is_able_to_navigate_back_to_the_menu_screen_from_settings_screen () {
		menupage = new MenuScreen(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsScreen(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Back_Arrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");		
	}
	

	/*
	Validate the working of the pay as you without enabling the wallet in settings screen.
	*/
	/*@Test(priority = 10)
	public void To_Validate_the_working_of_pay_as_you_without_enabling_the_wallet_in_settings_screen () throws InterruptedException {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuScreen(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsScreen(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		Thread.sleep(2000);
		settingspage.click_PayAsYouChat();
		Assert.assertFalse(settingspage.Check_payAsYouChat_option().isEnabled());
	}
	/*
	 Validate the working of the Start wallet option in settings screen.
	*/
	/*@Test(priority = 11)
	public void To_Validate_the_working_of_Start_wallet_option_in_settings_screen () throws InterruptedException {
		settingspage = new SettingsScreen(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_start_wallet();
		Thread.sleep(4000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		Assert.assertEquals(createpinpage.getWalletPinTitle(),"Create PIN");
		createpinpage.ClickBackArrow();	
	}
	/*
	Validate the working of the pay as you chat in settings screen while enabling first time before entering into wallet
	 */
	/*@Test(priority = 12)
	public void To_validate_the_working_of_pay_as_you_chat_in_settings_screen_while_enabling_first_time_before_entering_into_wallet () throws InterruptedException {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuScreen(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsScreen(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		Thread.sleep(3000);
		settingspage.click_PayAsYouChat();
		Assert.assertEquals(settingspage.popupSetupPin(), "Setup Pin");
		Thread.sleep(2000);
		settingspage.click_Cancel();
	}
	/*
	 Validate the working of the Send Link Previews option in both On and Off condition in settings screen.
	*/
	@Test(priority = 13)
	public void To_Validate_the_working_of_Send_Link_Previews_option_in_both_On_and_Off_condition_in_settings_screen () throws InterruptedException {
		// to check in on condition
		menupage = new MenuScreen(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsScreen(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Back_Arrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		notetomyselfpage = new NoteToSelfChatScreen(driver);
		notetomyselfpage.Set_Values_In_Message_textbox("https://youtube.com/shorts/QE8EBWPLOUs?si=j5YE10X8O0_MHeWJ");
		Thread.sleep(4000);
		notetomyselfpage.click_send_Button();
		Assert.assertTrue(notetomyselfpage.Link_Preview().isDisplayed());
		//Thread.sleep(3000);
		notetomyselfpage.Delete_Link();
		//Thread.sleep(3000);
		driver.navigate().back();
		
		//To check in off condition
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuScreen(driver);
		Thread.sleep(3000);
		menupage.click_option_Settings();
		settingspage = new SettingsScreen(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.scrollgesture_Using_text("Voice and video calls");
		settingspage.click_Send_LinkPreview();
		settingspage.click_Back_Arrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		notetomyselfpage = new NoteToSelfChatScreen(driver);
		notetomyselfpage.Set_Values_In_Message_textbox("https://youtube.com/shorts/QE8EBWPLOUs?si=j5YE10X8O0_MHeWJ");
		Thread.sleep(4000);
		notetomyselfpage.click_send_Button();
		//Assert.assertFalse(notetomyselfpage.Link_Preview().isDisplayed());
		Thread.sleep(2000);
		driver.navigate().back();
	}
	
}
