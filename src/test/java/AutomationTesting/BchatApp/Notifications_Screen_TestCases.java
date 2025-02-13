package AutomationTesting.BchatApp;

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
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Notifications_Screen_TestCases extends baseclass {
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
		menupage.click_Notification_option();
	}
	/*
	 Validate whether able to navigate back to the home screen from notifications screen
	 */
	@Test(priority = 1)
	public void To_validate_whether_able_to_navigate_back_to_The_home_Screen_from_notifications_screen () {
		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		notificationspage.click_Back_Arrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		
	}
	/*
	 Validate all options in the notifications screen is enable if all notifications in ON Condition.
	 */
	@Test(priority = 2)
	public void To_validate_all_options_in_notifications_screen_is_enable_if_all_notifications_in_ON_Condition () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		menupage.click_Notification_option();
		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		notificationspage.scrollgesture_Using_text("Show");
		Assert.assertTrue(notificationspage.get_All_options_Element().isEnabled());
	}
	/*
	 Validate all options in the notifications screen is enable if all notifications in OFF Condition.
	 */
	@Test(priority = 3)
	public void To_validate_all_options_in_notifications_screen_is_enable_if_all_notifications_in_OFF_Condition () {
		
		
		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		
		notificationspage.click_All_Notification_option();
		Assert.assertFalse(notificationspage.get_All_options_Element().isEnabled());
	}
	/*
	validate the navigation of the priority option from notifications screen
	*/
	@Test(priority = 4)
	public void To_validate_the_navigation_of_priority_option_from_notifications_screen () {

		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		notificationspage.click_All_Notification_option();
		notificationspage.click_option_Priority();
		Assert.assertEquals(notificationspage.priority_screen_title(),"Default");
		driver.navigate().back();
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
	}
	/*
	Validate the working of the all radio buttons in the notifications content.
	*/
	@Test(priority = 5)
	public void To_Validate_the_working_of_all_radio_buttons_in_notifications_content () {
		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		notificationspage.Select_options_in_Show();
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
	}
	/*
	Validate whether the selected radio button is highlighted in the show option of the notifications content.
	*/
	@Test(priority = 6)
	public void To_Validate_whether_the_selected_radio_button_is_highlighted_in_show_option_of_notifications_content () {
		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		notificationspage.click_option_Show();
		Assert.assertEquals(notificationspage.Show_Popup_Title(), "Show");
		notificationspage.select_option_Name_Only();
		Assert.assertEquals(notificationspage.get_Showing_option_In_Show_field(), "Name only");
	
		notificationspage.click_option_Show();
		Assert.assertEquals(notificationspage.Show_Popup_Title(), "Show");
		notificationspage.select_option_No_Name_Or_content();
		Assert.assertEquals(notificationspage.get_Showing_option_In_Show_field(), "No name or content");
		
		notificationspage.click_option_Show();
		Assert.assertEquals(notificationspage.Show_Popup_Title(), "Show");
		notificationspage.select_option_Name_and_content();;
		Assert.assertEquals(notificationspage.get_Showing_option_In_Show_field(), "Name and content");
	}
	/*
	Validate the working of the cancel button in notifications content Show popup screen
	*/
	@Test(priority = 7)
	public void To_Validate_the_working_of_cancel_button_in_notifications_content_Show_popup_screen () {
		notificationspage= new NotificationsScreen(driver);
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
		notificationspage.click_option_Show();
		Assert.assertEquals(notificationspage.Show_Popup_Title(), "Show");
		notificationspage.click_cancel_In_Show_Popup();
		Assert.assertEquals(notificationspage.pageTitle(),"Notifications");
	}
}
