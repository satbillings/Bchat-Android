package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.CreatePINScreen;
import POM.CreatePINScreen2;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.MenuScreen;
import POM.MyWalletScreen;
import POM.EnableWalletScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import POM.WalletReceiveScreen;
import POM.WalletSendScreen;
import POM.WalletSettingsScreen;
import TestUtiles.baseclass;

public class My_Wallet_Screen_TestCases_In_Create_Account_Flow extends baseclass{
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
    RegisterScreen registerpage;
	MenuScreen menupage;
	EnableWalletScreen Enablewalletpage;
	CreatePINScreen createpinpage;
	CreatePINScreen2 createpinpage2;
	MyWalletScreen mywalletpage;
	WalletSendScreen sendpage;
	WalletSettingsScreen walletsettingspage;
	WalletReceiveScreen walletreceivepage;
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
		Thread.sleep(3000);
		menupage =new MenuScreen(driver);
		menupage.click_option_Wallet();
}
	/*
	 Validate whether able to navigate to home screen from wallet enable screen.
	*/
	/*@Test (priority = 1)
	public void To_Validate_whether_able_to_navigate_to_home_screen_from_wallet_enable_screen () {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickBackArrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
	
	}
	/*
    Validate the working of enable wallet button without clicking the check box.
	*/
	/*@Test(priority = 2)
	public void To_Validate_the_working_of_enable_wallet_button_without_clicking_the_check_box () {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletButton();
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
	}
	
	
	/*
    Validate the working of the yes, I understand check box.
	*/
	/*@Test(priority = 3)
	public void To_validate_the_Working_of_the_yes_I_understand_check_box () {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Assert.assertTrue(Enablewalletpage.ElementofEnableWalletButton().isEnabled());
		
	}
	/*
	Validate the working of the Enable wallet button.
	 */
	/*@Test(priority = 4)
	public void To_Validate_the_working_of_Enable_wallet_Button () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		//Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getCreatePinScreenTitle(),"Create PIN");
	}
	/*
	 Validate whether able to navigate to the re-enter pin field without entering a value in create pin field.
	*/
	/*@Test(priority = 5)
	public void To_Validate_whether_able_to_navigate_to_ReEnter_pin_field_without_entering_a_value_in_create_pin_field () {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getCreatePinScreenTitle(),"Create PIN");
		createpasswordpage = new CreatePasswordScreen(driver);
		createpasswordpage.clickNext();
		Assert.assertEquals(Enablewalletpage.getCreatePinScreenTitle(),"Create PIN");
	}
	/*
	 Validate the Wallet password functionality by entering a valid value in Create pin and invalid value in Re-Enter pin.
	 */
	/*@Test(priority = 6)
	public void To_Validate_Wallet_password_functionality_by_entering_valid_value_in_Create_pin_and_invalid_Value_in_ReEnter_pin () {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
	//	Assert.assertEquals(createpinpage.getCreatePinScreenTitle(),"Create PIN");
		//Enablewalletpage = new EnableWalletScreen(driver);
		//Assert.assertEquals(Enablewalletpage.getCreatePinScreenTitle(),"Create PIN");
		//createpinpage = new CreatePINScreen(driver);
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_1();
		createpinpage2.clickNext();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		createpinpage2.ClickBackArrow();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Assert.assertEquals(Toast(),"Both PINs should be same.");
		//WebElement toastmsg=driver.findElement(By.xpath("//android.widget.Toast"));
		//Assert.assertEquals(toastmsg,"Both PINs should be same.");
		//createpasswordpage.setPassword_1();
		//createpasswordpage.clickNext();
		//Assert.assertEquals(Toast(), "Both PINs should be same.");
		//Assert.assertEquals(mywalletpage.getCreatePinScreenTitle(),"Create PIN");
	}*/
	/*
    Validate whether able to navigate to the next screen without entering a value in Re-Enter pin field.
	 */
	/*@Test(priority = 7)
	public void To_Validate_whether_able_to_navigate_to_next_screen_without_entering_a_value_in_ReEnter_pin_field () {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.clickNext();	
	}*/
	/*
    Validate the Wallet password functionality by entering a valid Create pin and valid Re-Enter pin.
	*/
	/*@Test(priority = 8)
    public void To_Validate_the_Wallet_password_functionality_by_entering_a_valid_Create_pin_and_valid_ReEnter_pin () throws InterruptedException{
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(50000);
		//wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.getSynchronizedStatus()));	
		//Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(),"My Wallet");
	   // mywalletpage.ClickBackArrow();
	}
	/*
	Validate the Transaction history when empty
	*/
	/*@Test(priority = 9)
	public void To_Validate_the_Transaction_history_when_empty () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");	
		Assert.assertEquals(mywalletpage.getTransactionEmptyStatus(), "No Transactions yet!");
	}
	
	/*
	 Validate the working of the Transaction filter when transaction is empty
	 */
	/*@Test (priority = 10)
	public void To_Validate_the_working_of_Transaction_filter_when_transaction_is_empty () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickTransactionFilter();
		Assert.assertEquals(mywalletpage.getTransactionEmptyStatus(),"No Transactions yet!");
		//mywalletpage.ClickBackArrow();
	}
	/*
	Validate the working of the all possible navigation from the my wallet screen in both forward and backward direction.
	*/
	/*@Test(priority = 11)
	public void To_Validate_working_of_all_possible_navigation_from_my_wallet_screen_in_both_forward_and_backward_direction () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickScanOption();
		Assert.assertEquals(mywalletpage.Scan_Page_Title(), "Scan");
		mywalletpage.ClickBackArrow();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSendOption();
		Assert.assertEquals(mywalletpage.Send_Page_Title(), "Send");
		mywalletpage.ClickBackArrow();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickReceiveOption();
		Assert.assertEquals(mywalletpage.Receive_Page_Title(), "Receive");
		mywalletpage.ClickBackArrow();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSyncingOption();
		Assert.assertEquals(mywalletpage.SyncOption_Page_Title(),"Syncing Option");
		driver.navigate().back();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSettingsOption();
		Assert.assertEquals(mywalletpage.getWalletSettingsTitle(), "Wallet settings");
		//Assert.assertEquals(false, null);
		mywalletpage.ClickBackArrow();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");

	}
	
	/*
	Validate whether able to navigate out from verify pin screen.
	*/
	/*@Test(priority = 9)
	public void To_Validate_whether_able_to_navigate_out_from_Verify_Pin_screen () throws InterruptedException {
		
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage2 = new CreatePINScreen2(driver);
		Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");
		mywalletpage.ClickBackArrow();
	}*/
	/*
	Validate the Wallet password functionality by entering a Incorrect pin.
	*/
	/*@Test(priority = 10)
	public void To_Validate_the_Wallet_password_functionality_by_entering_a_Incorrect_pin () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage2 = new CreatePINScreen2(driver);
		Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");
		createpinpage2.setPassword_1();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Assert.assertEquals(Toast(),"Incorrect PIN.");	
	}*/
	/*
	Validate the Wallet password functionality by entering a valid pin.
	*/
	/*@Test(priority = 11)
	public void To_Validate_the_Wallet_pin_functionality_by_entering_a_valid_pin () {
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage2 = new CreatePINScreen2(driver);
		//Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");
		createpinpage2.setPassword_0();
		mywalletpage = new MyWalletScreen(driver);
		//Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
	}*/
	/*
	Validate the working of the MyWallet functionality without internet connection
	*/
	/*@Test(priority = 12)
	public void To_Validate_the_working_of_MyWallet_functionality_without_internet_connection () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(58000);
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		mywalletpage.ClickBackArrow();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		Thread.sleep(3000);
		menupage.click_option_Wallet();
        Thread.sleep(5000);
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			//Assert.assertEquals(Toast(),"Please check your internet connection");
		turnOn_Mobile_Wifi();
         Thread.sleep(5000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
			createpinpage2 = new CreatePINScreen2(driver);
			createpinpage2.setPassword_0();
			mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
        Thread.sleep(5000);

	}
	/*
	 Validate whether able to navigate out of the wallet Send screen.
	 */
	/*@Test(priority = 13)
	public void To_validate_whether_able_to_navigate_out_of_the_wallet_Send_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		Thread.sleep(58000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_BackArrow();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(),"My Wallet");	
	}
	/*
	 Validate the working of the scan option in my wallet screen.
	 */
	/*@Test(priority = 14)
	public void To_validate_the_working_of_the_scan_option_in_my_wallet_screen () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(),"My Wallet");
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_scanner();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.Scan_Page_Title(),"Scan");
		mywalletpage.ClickBackArrow();
		Assert.assertEquals(sendpage.pagetitle(), "Send");
	}
	/*
	 Validate the working of the address book option in wallet send screen.
	 */
	/*@Test(priority = 15)
	public void To_validate_the_working_of_AddressBook_option_in_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_AddressBook();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(),"Address Book");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(sendpage.pagetitle(), "Send");
	}
	/*
	 Validate the working of the send function without entering values in both address and amount in my wallet screen.
	 */
	/*@Test(priority = 16)
	public void To_validate_the_working_of_send_function_without_entering_values_in_both_address_and_amount_in_my_wallet_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_send();
		Assert.assertEquals(sendpage.pagetitle(), "Send");
	}
	/*
	 Validate the presence of amount and address text boxes placeholder's in wallet send screen.
	 */
	/*@Test(priority = 17)
	public void To_validate_the_presence_of_amount_and_address_textboxes_placeholders_in_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		Assert.assertEquals(sendpage.get_Amount_placeholder(),"0.0000");
		Assert.assertEquals(sendpage.get_Address_Placeholder(),"Enter Address");
		
	}
	
	
	/*
	 Validate the cursor blinks on clicking the amount and address text boxes of wallet send screen.
	 */
	/*@Test(priority = 18)
	public void  To_Validate_the_cursor_blinks_on_Clicking_the_amount_and_address_textboxes_of_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_Amount_textbox();
		Assert.assertTrue(sendpage.activeElement().isDisplayed());
		sendpage.click_Address_textbox();
		Assert.assertTrue(sendpage.activeElement().isDisplayed());
		driver.navigate().back();
	}
	/*
	 Validate the working of the transaction priority drop down in wallet send screen.
	 */
	/*@Test(priority = 19)
	public void To_validate_the_working_of_the_transaction_priority_drop_down_in_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Set_Slow_inPriority();
		Assert.assertEquals(sendpage.get_priority_value(), "Slow");
		sendpage.Set_Flash_InPriority();
		Assert.assertEquals(sendpage.get_priority_value(), "Flash");
	}
	/*
	 Validate the working of the send function with value in amount text box and without value in address text box in wallet send screen.
	 */
	/*@Test(priority = 20)
	public void To_validate_the_working_of_send_function_with_value_in_amount_textbox_and_without_value_in_address_textbox_in_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Amount("10");
		sendpage.click_send();
		Assert.assertEquals(sendpage.pagetitle(), "Send"); 	
	}
	
	/*
	 Validate the Estimated Fee In Slow and Flash in wallet send screen.
	 */
	/*@Test(priority = 21)
	public void To_Validate_the_estimated_fee_in_Slow_And_in_flash_in_wallet_send_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		Thread.sleep(58000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Set_Slow_inPriority();
		Assert.assertEquals(sendpage.getSlowEstimatedFee(), "0.013532 BDX");
		sendpage.Set_Flash_InPriority();
		Assert.assertEquals(sendpage.getFlashEstimatedFee(), "0.040596 BDX");
		sendpage.click_BackArrow();
	}
	/*
	Validate whether able to copy the wallet Address in wallet receive screen.
	*/
	/*@Test(priority = 22)
	public void To_Validate_whether_able_to_copy_the_wallet_Address_in_wallet_receive_screen () throws InterruptedException {
		
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickReceiveOption();
		walletreceivepage = new  WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.click_copyIcon_In_receiveScreen();
		Thread.sleep(8000);
		//Assert.assertEquals(Toast(),"Copied to clip board");
	}
	/*
	 Validate the working of the share button in wallet receive screen.
	 */
	/*@Test(priority = 23)
	public void To_Validate_the_working_of_share_button_in_wallet_receive_screen () {
		walletreceivepage = new  WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.click_share();
		Assert.assertEquals(walletreceivepage.Share_Screen_Title(), "1 image in total");
		walletreceivepage.click_Cancel();
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
	}
	/*
	Validate the amount text box with valid amount value in wallet receive screen.
	*/
	/*@Test(priority = 24)
	public void To_Validate_the_amount_textbox_with_valid_amount_value_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.Enter_Value_In_Amount_textBox("10");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"10");
		walletreceivepage.clear_TextBox();		
		Thread.sleep(5000);
		
	}
	/*
	Validate whether able to paste numerical value in the amount text box in wallet receive screen.
	*/
	/*@Test(priority = 25)
	public void To_validate_whether_able_to_paste_numerical_value_in_amount_textbox_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values("100");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"100" );
		walletreceivepage.clear_TextBox();
		Thread.sleep(5000);
	}
	/*
	Validate whether able to paste characters in the amount text box in wallet receive screen.
	*/
	/*@Test(priority = 26)
	public void To_validate_whether_able_to_paste_characters_in_amount_textbox_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values("abcde");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"" );
		walletreceivepage.clear_TextBox();
		Thread.sleep(5000);
	}
	/*
	Validate whether cursor blinks on clicking the amount text box in wallet receive screen.
	*/
	/*@Test(priority = 27)
	public void To_validate_whether_cursor_blinks_on_clicking_the_amount_textbox_in_wallet_receive_screen () {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.click_textbox();
		Assert.assertTrue(walletreceivepage.activeElement().isDisplayed());
	}
	/*
	Validate whether allowing to enter Special characters and multiple dots in amount text box in wallet receive screen.
	*/
	/*@Test(priority = 28)
	public void To_Validate_whether_allowing_to_enter_Special_characters_and_multiple_dots_in_amount_textbox_in_wallet_receive_screen () {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values(",-");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"" );	
		walletreceivepage.paste_values("0.10.");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"" );		
	}
	/*
	Validate the presence of amount text box placeholder in wallet receive screen.
	*/
	/*@Test(priority = 29)
	public void To_validate_the_presence_of_amount_textbox_placeholder_in_wallet_receive_screen () {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		Assert.assertEquals(walletreceivepage.get_Placholder(), "0.0000");
	}
	/*
	Validate whether able to enter values above boundary limit in amount text box in wallet receive screen.
	*/
	/*@Test(priority = 30)
	public void To_Validate_whether_able_to_enter_values_above_boundary_limit_in_amount_textbox_in_wallet_receive_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		Thread.sleep(58000);
		mywalletpage.ClickReceiveOption();
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		Thread.sleep(3000);
		walletreceivepage.Enter_Value_In_Amount_textBox("12345678901234567");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"" );	
		walletreceivepage.Enter_Value_In_Amount_textBox("1234567890123456");
		Assert.assertEquals(walletreceivepage.get_Values_From_Amount_textbox(),"1234567890123456" );	
		walletreceivepage.clear_TextBox();
		Thread.sleep(8000);
	}
	/*
	Validate the amount text box with invalid amount value in wallet receive screen.
	*/
	/*@Test(priority = 31)
	public void To_validate_the_amount_text_box_with_invalid_amount_value_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.Enter_Value_In_Amount_textBox("0.0000");
		Assert.assertEquals(walletreceivepage.get_ErrorMsg(), "Enter a valid amount");
		walletreceivepage.clear_TextBox();
		driver.navigate().back();
		Thread.sleep(5000);
	}
	/*
	 Validate the navigation into and out from node screen.
	 */
	/*@Test(priority =32)
	public void To_Validate_the_navigation_into_and_out_from_node_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		mywalletpage.ClickSettingsOption();;
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Back_Arrow();
		Thread.sleep(5000);
	}
	/*
	Validate whether able to switch to the available nodes in node screen.
	*/
	/*@Test(priority = 33)
	public void To_Validate_whether_able_to_switch_to_available_nodes_in_node_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		mywalletpage.ClickSettingsOption();;
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		String currentNode = walletsettingspage.get_Current_Node();
		
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	
		
		if (currentNode.equalsIgnoreCase("publicnode1.rpcnode.stream") ) {
			walletsettingspage.click_publicNode2();
			
		}
		else if (currentNode.equals("publicnode2.rpcnode.stream")) {
			walletsettingspage.click_publicNode3();
		}
		else if (currentNode.equals("publicnode3.rpcnode.stream")) {
			walletsettingspage.click_publicNode4();
		}
		else if (currentNode.equals("publicnode4.rpcnode.stream")) {
			walletsettingspage.click_publicNode5();
		}
		else if (currentNode.equals("publicnode5.rpcnode.stream")) {
			walletsettingspage.click_publicNode1();
		}
		walletsettingspage.click_Back_Arrow();
		try {
		Assert.assertNotEquals(walletsettingspage.get_Current_Node(), currentNode);
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		}
		Thread.sleep(5000);
	}
	/*
	Validate whether selected node is displayed as current Node in wallet settings screen.
	*/
	/*@Test(priority = 34)
	public void To_Validate_whether_selected_node_is_displayed_as_current_Node_in_wallet_settings_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_publicNode1();
		//walletsettingspage.click_Yes_InPopup();
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_Current_Node(), "publicnode1.rpcnode.stream");
		Thread.sleep(5000);
		
	}
	/*
	 Validate the working of refresh node option in node screen.
	 */
	/*@Test(priority = 35)
	public void To_Validate_the_working_of_Refresh_Node_option_in_node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		//String currentNode = walletsettingspage.get_Current_Node();
		walletsettingspage.click_Current_Node();
		walletsettingspage.click_Refresh_Node();
		Thread.sleep(3000);
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
	}
	/*
	 Validate the working of the cancel button in all popup's in node screen.
	 */
	/*@Test(priority = 36)
	public void To_Validate_the_working_of_the_cancel_button_in_all_popups_in_node_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		Thread.sleep(58000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.ClickCancelButtonInSwitchNodePopup();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		//Thread.sleep(2000);
		walletsettingspage.ClickCancelButtonInRefreshNodePopup();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		//Thread.sleep(2000);
		walletsettingspage.ClickCancelButtonInAddNodePopup();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	}
	/*
	Validate the working of the Test node without entering a value in both Node Address and Node port in add node popup.
	*/
	/*@Test(priority = 37)
	public void To_Validate_the_working_of_Test_node_without_entering_value_in_both_Node_Address_and_Node_port_in_add_node_popup () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"we need this");
		//Thread.sleep(4000);
	}
	/*
	Validate the working of the test node with Invalid Node Address and Invalid Node port in add node popup.
	*/
	/*@Test(priority = 38)
	public void To_Validate_the_working_of_Add_node_with_Invalid_Node_Address_and_Invalid_Node_port_in_add_node_popup () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("test");
		walletsettingspage.Enter_NodePort("1234");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();
		//Thread.sleep(4000);

	}
	/*
	Validate the working of the Test node with entering a valid value in Node Address and without value in Node port in add node popup.
	*/
	/*@Test(priority = 39)
	public void To_Validate_the_working_of_Test_node_with_entering_a_valid_value_in_Node_Address_and_without_value_in_Node_port_in_add_node_popup () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.clear_TextBoxes();
	}
	/*
	Validate the working of the Test node with Invalid Node Address and Valid Node port in add node popup.
	*/
	/*@Test(priority = 40)
	public void To_Validate_the_working_of_Test_node_with_Invalid_Node_Address_and_Valid_Node_port_in_add_node_popup () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("test.rpc.node1");
		walletsettingspage.Enter_NodePort("1234");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();
	}
	/*
	Validate the working of the Test node with valid Node Address and InValid Node port in add node popup.
	*/
	/*@Test(priority = 41)
	public void To_Validate_the_working_of_Test_node_with_valid_Node_Address_and_InValid_Node_port_in_add_node_popup () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("1234");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"CONNECTION ERROR");
		walletsettingspage.clear_TextBoxes();
	}
	/*
	Validate whether able to add Node without test in add node popup.
	*/
	/*@Test(priority = 42)
	public void To_Validate_whether_able_to_add_Node_without_test_in_add_node_popup () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.click_Add_InAddNode();
		Assert.assertNotEquals(walletsettingspage.Success_Msg(),"Success");
	  	walletsettingspage.clear_TextBoxes();
	}
	/*
	Validate whether able to Add node with entering a value in Node Name, user name and password fields in add node popup.
	*/
	/*@Test(priority = 43)
	public void To_Validate_whether_able_to_Add_Node_with_entering_value_in_NodeName_username_and_password_fields_in_add_node_popup () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.Enter_NodeName("publicNode1");
		walletsettingspage.Enter_Username("chris");
		walletsettingspage.Enter_Password("1111");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.click_Add_InAddNode();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	}
	/*
	Validate the working of the Test node with valid Node Address and Valid Node port in add node popup.
	*/
	/*@Test(priority = 44)
	public void To_Validate_the_working_of_Test_node_with_valid_NodeAddress_and_Valid_NodePort_in_add_node_popup () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.click_Add_InAddNode();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	}

	
	
	/*
	 Validate Whether able to paste Characters values in node port text box in add node popup.
	 */
	/*@Test(priority = 46)
	public void To_Validate_Whether_able_to_paste_Characters_values_in_node_port_text_box_in_add_node_popup () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		Thread.sleep(58000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.paste_Values_In_NodePort();
		Thread.sleep(4000);
		walletsettingspage.click_Test();
	//	Assert.assertEquals(walletsettingspage.Success_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();	
	}
	/*
	 Validate whether able to paste values in the all text box fields in add node popup.
	 */
	/*@Test(priority = 47)
	public void To_Validate_whether_able_to_paste_values_in_the_text_box_fields_in_add_node_popup () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.paste_values_In_All_TextBox_Fields();
		Thread.sleep(5000);
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.clear_TextBoxes();
		driver.navigate().back();
		walletsettingspage.click_Back_Arrow();
	}
	/*
	Validate the address book screen when empty.
	*/
	/*@Test(priority = 48)
	public void To_Validate_the_address_book_screen_when_empty () throws InterruptedException {
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Address Book");
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		Assert.assertEquals(walletsettingspage.emptyAddressBook_screen(), "No Addresses!");
		driver.navigate().back();
		//walletsettingspage.click_Back_Arrow();
		//Thread.sleep(2000);
		driver.navigate().back();
		//walletsettingspage.click_Back_Arrow();
	}
	/*
	Validate the working of the rescan option without entering any value in block height text box in rescan screen.
	*/
	/*@Test(priority = 49)
	public void To_Validate_the_working_of_the_rescan_option_Without_entering_any_Value_in_block_height_textbox_in_rescan_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSyncingOption();
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		Thread.sleep(5000);
		mywalletpage.ClickRescanButton();
		//Assert.assertEquals(Toast(), "Please enter a restore height or Select a restore date");
	}*/
	/*
	validate the working of rescan with more than current block height value.
	*/
	/*@Test(priority = 50)
	public void To_validate_the_working_of_rescan_with_more_than_current_blockheight_value () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		Thread.sleep(58000);
		mywalletpage.ClickSyncingOption();
		Thread.sleep(3000);
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		mywalletpage.Enter_BlockHeight("99999999");
		Thread.sleep(3000);
		mywalletpage.ClickRescanButton();
		//Assert.assertEquals(Toast(),"Enter a valid blockheight");
		mywalletpage.ClearBlockHeightTextBox();
		}
	/*
	Validate presence of placeholder in the block height text box in rescan screen.
	*/
	/*@Test(priority = 51)
	public void To_validate_presence_of_placeholder_in_blockheight_textbox_in_rescan_screen () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		Assert.assertEquals(mywalletpage.getBlockheightPlaceHolder(), "Restore from BlockHeight");
	}
	/*
	Validate whether able to paste numerical value in blockheight text box in rescan screen.
	*/
	/*@Test(priority = 52)
	public void To_Validate_whether_able_to_paste_numerical_value_in_blockheight_textbox_in_rescan_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		mywalletpage.paste_Value_In_BlockheightTextBox("12345");
		Assert.assertEquals(mywalletpage.getValuesFromBlockheightTextBox(), "12345");
		Thread.sleep(3000);
		mywalletpage.ClearBlockHeightTextBox();
	}
	/*
	Validate whether able to paste characters value in block height text box in rescan screen.
	Validate whether able to navigate out of rescan screen.
	*/
	/*@Test(priority = 53)
	public void To_validate_whether_able_to_paste_characters_value_in_blockheight_textbox_To_Validate_whether_able_to_navigate_out_of_rescan_screen () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		mywalletpage.paste_Value_In_BlockheightTextBox("abced");
		Assert.assertEquals(mywalletpage.getValuesFromBlockheightTextBox(), "");
		driver.navigate().back();	
	}
	/*
	Validate the working of the reconnect option in my wallet screen.
	*/
	/*@Test(priority = 54)
	public void To_Validate_the_working_of_reconnect_option_in_my_wallet_screen () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSyncingOption();
		mywalletpage.ClickReconnectOption();
		Assert.assertEquals(mywalletpage.getStatusReconnecting(), "Reconnecting...");
		 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
			wait.until(ExpectedConditions.visibilityOf( mywalletpage.ElementofStatusReconnecting()));
		  Assert.assertTrue(mywalletpage.ElementofStatusReconnecting().isDisplayed());
	}
	/*
	Validate the working of rescan with restore from date in rescan screen.
	*/
	/*@Test(priority = 55)
	public void To_validate_the_working_of_rescan_with_restore_from_date_in_rescan_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		//wait.until(ExpectedConditions.visibilityOf( mywalletpage.ElementofStatusSynchronized()));
		Thread.sleep(58000);
		mywalletpage.ClickSyncingOption();
		Thread.sleep(8000);
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		mywalletpage.click_To_Swicth_rescan_option();
		Thread.sleep(3000);
		mywalletpage.rescan_From_date();
		//Thread.sleep(58000);
		//Assert.assertEquals(mywalletpage.getSyncingStatus(),"Wallet Syncing..");
		wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		//wait.until(ExpectedConditions.visibilityOf( mywalletpage.ElementofStatusSynchronized()));
		//Assert.assertTrue(mywalletpage.ElementofStatusSynchronized().isDisplayed());
		 }
	/*
	Validate the working of rescan with valid block height.
	*/
	/*@Test(priority = 56)
	public void To_validate_the_working_of_rescan_with_valid_blockheight () throws InterruptedException {
		
		mywalletpage = new MyWalletScreen(driver);
		mywalletpage.ClickSyncingOption();
		Thread.sleep(4000);
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		mywalletpage.Enter_BlockHeight("3980000");
	   mywalletpage.ClickRescanButton();
	   //wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		//wait.until(ExpectedConditions.visibilityOf( mywalletpage.ElementofStatusSynchronized()));
	   Thread.sleep(58000);
	}
	/*
	Validate the working of rescan with restore from date in rescan screen.
	*/
	/*@Test(priority = 55)
	public void To_validate_the_working_of_rescan_with_restore_from_date_in_rescan_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		Thread.sleep(58000);
		//mywalletpage = new MyWalletScreen(driver);
		//Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		//wait.until(ExpectedConditions.visibilityOf( mywalletpage.ElementofStatusSynchronized()));
		mywalletpage.ClickSyncingOption();
		Thread.sleep(5000);
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(),"Rescan");
		mywalletpage.click_To_Swicth_rescan_option();
		Thread.sleep(3000);
		mywalletpage.rescan_From_date();
		Thread.sleep(58000);
	}
	/*
	Validate whether able to add node without Internet connection in add node popup.
	*/
	/*@Test(priority = 56)
	public void To_Validate_whether_able_to_Add_Node_without_Internet_connection_in_add_node_popup () throws InterruptedException {
		//mywalletpage = new MyWalletScreen(driver);
		//Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		turnOff_Mobile_Wifi();
		Thread.sleep(8000);
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		Thread.sleep(8000);
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"cannot resolve host");
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
		walletsettingspage.clear_TextBoxes();
		//driver.navigate().back();
		//driver.navigate().back();
		//driver.navigate().back();
	}*/
	
/* Validate whether it navigate to the gallery after clicking the upload from gallery function in send screen */
	
	/*@Test(priority = 57)
	public void To_Validate_whether_it_navigate_to_the_gallery_after_clicking_the_upload_from_gallery_functionality_in_Send_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(5000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		Thread.sleep(3000);
		sendpage.ClickScanOptionInSendScreen();
		sendpage.clickAs();
		sendpage.ClickGalleryOption();
	}    
	
/* 	Validate whether user is able to navigate back to send screen scanner without selecting QR code image from Gallery */
	
	/*@Test(priority = 58)
	public void To_Validate_whether_user_is_able_to_navigate_back_to_send_screen_scanner_without_selecting_QR_code_image_from_gallery () throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		//Assert.assertEquals(sendpage.pagetitle(),"Send");
		driver.navigate().back();
	}*/
	
/* 	Validate the working of scan from gallery function with valid Bchat QR code with bdx value image */
	
	/*@Test(priority = 59)
	public void To_Validate_the_working_of_scan_from_gallery_functionality_with_valid_bchat_QR_code_with_bdx_value_image () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(5000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		Thread.sleep(3000);
		sendpage.ClickScanOptionInSendScreen();
		sendpage.clickAs();
		sendpage.ClickGalleryOption();
		sendpage.ClickAlbumSection();
		Thread.sleep(2000);
		sendpage.ClickRecentPhotosSection();
		Thread.sleep(2000);
		sendpage.ClickValidQRcodeImage();
		Thread.sleep(2000);
		sendpage.ClickSelectIconInGallery();;
	}    
	
	/* 	Validate the working of scan from gallery function with invalid Bchat QR code */
	
	/*@Test(priority = 60)
	public void To_Validate_the_working_of_scan_from_gallery_functionality_with_invalid_bchat_QR_code () throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		Thread.sleep(3000);
		sendpage.ClickScanOptionInSendScreen();
		sendpage.clickAs();
		sendpage.ClickGalleryOption();
		sendpage.ClickAlbumSection();
		Thread.sleep(2000);
		sendpage.ClickRecentPhotosSection();
		Thread.sleep(2000);
		sendpage.ClickInValidQRcodeImage();
		Thread.sleep(2000);
		sendpage.ClickSelectIconInGallery();
		Thread.sleep(3000);
	}    
	
/* Validate the working of scan from gallery function by selecting the non QR code images from gallery */
	
	/*@Test(priority = 61)
	public void To_Validate_the_working_of_scan_from_gallery_functionality_by_selecting_the_non_QR_code_images_from_gallery() throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		Thread.sleep(3000);
		sendpage.clickAs();
		sendpage.ClickGalleryOption();
		sendpage.ClickAlbumSection();
		Thread.sleep(2000);
		sendpage.ClickRecentPhotosSection();
		Thread.sleep(2000);
		sendpage.ClickNonQRcodeImage();
		Thread.sleep(2000);
		sendpage.ClickSelectIconInGallery();
		Thread.sleep(3000);
	}  */
	
/* Validate the working of scan from gallery function by selecting the non QR code images from gallery without internet connection */
	
	/*@Test(priority = 62)
	public void To_Validate_the_working_of_scan_from_gallery_functionality_by_selecting_the_non_QR_code_images_from_gallery_without_internet_connection() throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(5000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.ClickScanOptionInSendScreen();
		Thread.sleep(6000);
		turnOff_Mobile_Wifi();
      	Thread.sleep(6000);	
		sendpage.clickAs1();	
		Thread.sleep(2000);
		sendpage.ClickGalleryOption();
		sendpage.ClickAlbumSection();
		Thread.sleep(2000);
		sendpage.ClickRecentPhotosSection();
		Thread.sleep(4000);
		sendpage.ClickNonQRcodeImage();
		Thread.sleep(2000);
		sendpage.ClickSelectIconInGallery();
		Thread.sleep(6000);
	}
	
/* 	Validate the working of scan from gallery function with invalid Bchat QR code without internet connection */
	
	/*@Test(priority = 63)
	public void To_Validate_the_working_of_scan_from_gallery_functionality_with_invalid_bchat_QR_code_without_internet_connection () throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		//Assert.assertEquals(sendpage.pagetitle(),"Send");
		//Thread.sleep(3000);
		//sendpage.ClickScanOptionInSendScreen();
		sendpage.clickAs1();
		sendpage.ClickGalleryOption();
		sendpage.ClickAlbumSection();
		Thread.sleep(2000);
		sendpage.ClickRecentPhotosSection();
		Thread.sleep(4000);
		sendpage.ClickInValidQRcodeImage();
		Thread.sleep(2000);
		sendpage.ClickSelectIconInGallery();
		//Thread.sleep(3000);
	}    	
	
/* 	Validate the working of scan from gallery function with valid Bchat QR code with bdx value image without internet connection */
	
	/*@Test(priority = 64)
	public void To_Validate_the_working_of_scan_from_gallery_functionality_with_valid_bchat_QR_code_with_bdx_value_image_without_internet_connection () throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		//Assert.assertEquals(sendpage.pagetitle(),"Send");
		Thread.sleep(6000);
		//sendpage.ClickScanOptionInSendScreen();
		sendpage.clickAs1();
		sendpage.ClickGalleryOption();
		sendpage.ClickAlbumSection();
		Thread.sleep(2000);
		sendpage.ClickRecentPhotosSection();
		Thread.sleep(4000);
		sendpage.ClickValidQRcodeImage();
		Thread.sleep(2000);
		sendpage.ClickSelectIconInGallery();
		Thread.sleep(6000);
		turnOn_Mobile_Wifi();
      	Thread.sleep(6000);	
	} */
	
	/* Validate whether able to paste special characters in the amount text box in wallet receive screen */
	
	/*@Test(priority = 65)
	public void To_Validate_whether_user_is_able_to_paste_special_characters_in_the_amount_text_box_in_wallet_receive_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(5000);
		mywalletpage.ClickReceiveOption();
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.click_textbox();
		walletreceivepage.paste_values("!@#$%^&*()");
		Assert.assertNotEquals(walletreceivepage.get_Values_From_Amount_textbox(),"!@#$%^&*()" );
		//walletreceivepage.clear_TextBox();
		}
	
/* Validate whether able to paste upper case letter in the amount text box in wallet receive screen */
	
	/*@Test(priority = 66)
	public void To_Validate_whether_user_is_able_to_paste_upper_case_letter_in_the_amount_text_box_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values("ABCDEF");
		Assert.assertNotEquals(walletreceivepage.get_Values_From_Amount_textbox(),"ABCDEF" );
	}
	
/* Validate whether able to paste alphanumeric value in the amount text box in wallet receive screen */
	
	/*@Test(priority = 67)
	public void To_Validate_whether_user_is_able_to_paste_alphanumeric_value_in_the_amount_text_box_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values("abc123");
		Assert.assertNotEquals(walletreceivepage.get_Values_From_Amount_textbox(),"abc123" );
	}	
	
/* Validate whether able to paste HTML value in the amount text box in wallet receive screen */
	
	/*@Test(priority = 68)
	public void To_Validate_whether_user_is_able_to_paste_HTML_value_in_the_amount_text_box_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertNotEquals(walletreceivepage.get_Values_From_Amount_textbox(),"<a href=\\\"https://www.example.com\\\">Visit Example</a>" );
	}	
	
/* Validate whether able to paste long text in the amount text box in wallet receive screen */
	
	/*@Test(priority = 69)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_the_amount_text_box_in_wallet_receive_screen () throws InterruptedException {
		walletreceivepage = new WalletReceiveScreen(driver);
		Assert.assertEquals(walletreceivepage.Receive_Screen_title(),"Receive");
		walletreceivepage.paste_values("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertNotEquals(walletreceivepage.get_Values_From_Amount_textbox(),"civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen" );
	}	*/
		
/* Validate the Node address text box in the wallet node screen by entering the empty space */
	
	/*@Test(priority = 70)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_empty_space () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("     ");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "     ");
		walletsettingspage.ClearNodeAddressTextBox();
	}
	
/* Validate the Node address text box in the wallet node screen by entering the special characters */
	
	/*@Test(priority = 71)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_special_characters () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("!@#$%^&*()");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "!@#$%^&*()");
		walletsettingspage.ClearNodeAddressTextBox();
	}
	
/* Validate the Node address text box in the wallet node screen by entering the numerical values */
	
	/*@Test(priority = 72)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_numerical_values () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("1234567890");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "1234567890");
		walletsettingspage.ClearNodeAddressTextBox();
	}	
	
/* Validate the Node address text box in the wallet node screen by entering the decimal values */
	
	/*@Test(priority = 73)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_decimal_values () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("0.00001");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "0.00001");
		walletsettingspage.ClearNodeAddressTextBox();
	}	*/
	
/* Validate the Node address text box in the wallet node screen by entering the alphabets both in upper case and lower case letter */
	
	/*@Test(priority = 74)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_alphabets_both_in_uppercase_lowercase_letter () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("ABCDEF");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "ABCDEF");
		walletsettingspage.ClearNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("abcdef");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "abcdef");
		walletsettingspage.ClearNodeAddressTextBox();
	}	
	
/* Validate the Node address text box in the wallet node screen by entering the alphanumeric value */
/* 	Validate whether the value entered in the Node address text box of My wallet node screen is editable and delete-able */
	
	
	/*@Test(priority = 75)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_alphanumeric_value_To_validate_whether_the_value_entered_in_the_Node_address_text_box_of_My_wallet_node_screen_is_editable_and_deleteable () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("abc123");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "abc123");
		walletsettingspage.ClearNodeAddressTextBox();
	}
	
/* Validate the Node address text box in the wallet node screen by entering the HTML value */
	
	/*@Test(priority = 76)
	public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_HTML_value () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.Enter_NodeAddress("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		walletsettingspage.ClearNodeAddressTextBox();
	}	
	
/* Validate whether user is able to paste long text in Node address text box in the My wallet node screen*/
	
	/*@Test(priority = 77)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_Node_address_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.PasteValuesInNodeAddressTextBox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		walletsettingspage.ClearNodeAddressTextBox();
	}	
	
/* Validate whether user is able to paste special characters in Node port text box in the My wallet node screen*/
	
	/*@Test(priority = 78)
	public void To_Validate_whether_user_is_able_to_paste_special_characters_in_Node_port_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodePortTextBox();
		walletsettingspage.PasteValuesInNodePortTextBox("!@#$%^&*()");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodePortTextBox(), "!@#$%^&*()");
	}*/
	
/* Validate whether user is able to paste empty space in Node port text box in the My wallet node screen*/
	
	/*@Test(priority = 79)
	public void To_Validate_whether_user_is_able_to_paste_empty_space_in_Node_port_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodePortTextBox();
		walletsettingspage.PasteValuesInNodePortTextBox("     ");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodePortTextBox(), "     ");
	}
	
/* Validate whether user is able to paste upper case letter in Node port text box in the My wallet node screen*/
	
	/*@Test(priority = 80)
	public void To_Validate_whether_user_is_able_to_paste_upper_case_letter_in_Node_port_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodePortTextBox();
		walletsettingspage.PasteValuesInNodePortTextBox("ABCDEF");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodePortTextBox(), "ABCDEF");
	}
	
/* Validate whether user is able to paste alphanumeric value in Node port text box in the My wallet node screen*/
	
	/*@Test(priority = 81)
	public void To_Validate_whether_user_is_able_to_paste_alphanumeric_value_in_Node_port_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodePortTextBox();
		walletsettingspage.PasteValuesInNodePortTextBox("abc123");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodePortTextBox(), "abc123");
	}	
	
/* Validate whether user is able to paste long text in Node port text box in the My wallet node screen*/
	
	/*@Test(priority = 82)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_Node_port_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodePortTextBox();
		walletsettingspage.PasteValuesInNodePortTextBox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodePortTextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
	}	
	
/* Validate the cursor blinks in Node port text box on the My wallet node screen */
	/* Validate the presence of placeholder in Node port text box on the My wallet node screen */
	
	/*@Test(priority = 83)
	public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_in_Node_port_text_box_on_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodePortTextBox();	
		Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
		Assert.assertEquals(walletsettingspage.getNodePortTextBoxPlaceholder(), "Node port");
	}*/
	
	/* Validate the cursor blinks in Node address text box on the My wallet node screen */
	/* Validate the presence of placeholder in Node address text box on the My wallet node screen */
	
	/*@Test(priority = 84)
	public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_in_Node_address_text_box_on_the_wallet_Node_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeAddressTextBox();	
		Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
		Assert.assertEquals(walletsettingspage.getNodeAddressTextBoxPlaceholder(), "Node address");
	}
	
	/* Validate the cursor blinks in Node Name text box on the My wallet node screen */
	/* Validate the presence of placeholder in Node Name text box on the My wallet node screen */	
	
	/*@Test(priority = 85)
	public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_in_Node_Name_text_box_on_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeNameTextBox();	
		Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
		Assert.assertEquals(walletsettingspage.getNodeNameTextBoxPlaceholder(), "Node name (Optional)");
	}
	
/* Validate the Node Name text box in the wallet node screen by entering the empty space value */
	
	/*@Test(priority = 86)
	public void To_Validate_the_Node_Name_text_box_in_the_wallet_Node_screen_by_entering_the_empty_space_value () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.SetValuesInNodeNameTextBox("     ");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "     ");
		walletsettingspage.ClearNodeNameTextBox();
	}*/
	
/* Validate the Node Name text box in the wallet node screen by entering the special characters */
	
	/*@Test(priority = 87)
	public void To_Validate_the_Node_Name_text_box_in_the_wallet_Node_screen_by_entering_the_special_characters () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeNameTextBox();	
		walletsettingspage.SetValuesInNodeNameTextBox("!@#$%^&*()");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "!@#$%^&*()");
		walletsettingspage.ClearNodeNameTextBox();
	}
	
	/* Validate the Node Name text box in the wallet node screen by entering the numerical value */
	/* 	Validate whether the value entered in the Node Name text box of My wallet node screen is editable and delete-able */
		
		/*@Test(priority = 88)
		public void To_Validate_the_Node_address_text_box_in_the_wallet_Node_screen_by_entering_the_numerical_value_To_validate_whether_the_value_entered_in_the_Node_address_text_box_of_My_wallet_node_screen_is_editable_and_deleteable () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);	
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickNodeNameTextBox();	
			walletsettingspage.SetValuesInNodeNameTextBox("1234567890");
			Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "1234567890");
			walletsettingspage.ClearNodeNameTextBox();
		}
		
/* Validate the Node Name text box in the wallet node screen by entering the alphabets both in upper case and lower case letter */
		
		/*@Test(priority = 89)
		public void To_Validate_the_Node_Name_text_box_in_the_wallet_Node_screen_by_entering_the_alphabets_both_in_uppercase_lowercase_letter () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);	
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickNodeNameTextBox();	
			walletsettingspage.SetValuesInNodeNameTextBox("ABCDEF");
			Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "ABCDEF");
			walletsettingspage.ClearNodeNameTextBox();
			walletsettingspage = new WalletSettingsScreen(driver);	
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickNodeNameTextBox();	
			walletsettingspage.SetValuesInNodeNameTextBox("abcdef");
			Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "abcdef");
			walletsettingspage.ClearNodeNameTextBox();
		}
		
/* Validate the Node Name text box in the wallet node screen by entering the alphanumeric value */
		
		/*@Test(priority = 90)
		public void To_Validate_the_Node_Name_text_box_in_the_wallet_Node_screen_by_entering_the_alphanumeric_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);	
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickNodeNameTextBox();	
			walletsettingspage.SetValuesInNodeNameTextBox("abc123");
			Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "abc123");
			walletsettingspage.ClearNodeNameTextBox();		
		}
	
/* Validate the Node Name text box in the wallet node screen by entering the decimal value */
		
		/*@Test(priority = 91)
		public void To_Validate_the_Node_Name_text_box_in_the_wallet_Node_screen_by_entering_the_decimal_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);	
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickNodeNameTextBox();	
			walletsettingspage.SetValuesInNodeNameTextBox("0.00001");
			Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "0.00001");
			walletsettingspage.ClearNodeNameTextBox();		
		}	*/
	
/* Validate the Node Name text box in the wallet node screen by entering the HTML value */
	
	/*@Test(priority = 92)
	public void To_Validate_the_Node_Name_text_box_in_the_wallet_Node_screen_by_entering_the_HTML_value () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeNameTextBox();	
		walletsettingspage.SetValuesInNodeNameTextBox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		walletsettingspage.ClearNodeNameTextBox();
	}	
	
	
/* Validate whether user is able to paste long text in Node Name text box in the My wallet node screen*/
	
	/*@Test(priority = 93)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_Node_Name_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.PasteValuesInNodeNameTextBox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		walletsettingspage.ClearNodeNameTextBox();
	}
	
/* Validate the cursor blinks in User name text box on the My wallet node screen */
/* Validate the presence of placeholder in User name text box on the My wallet node screen */	
	
	/*@Test(priority = 94)
	public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_in_User_name_text_box_on_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickUserNameTextBox();	
		Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
		Assert.assertEquals(walletsettingspage.getUserNameTextBoxPlaceholder(), "Username (Optional)");
	}
	
/* Validate the User name text box in the wallet node screen by entering the empty space value */
	
	/*@Test(priority = 95)
	public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_empty_space_value () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.SetValuesInUserNameTextBox("     ");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "     ");
		walletsettingspage.ClearUserNameTextBox();
	}
	
	/* Validate the User name text box in the wallet node screen by entering the numerical value */
	/* 	Validate whether the value entered in the User name text box of My wallet node screen is editable and delete-able */
		
		/*@Test(priority = 96)
		public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_numerical_value_To_validate_whether_the_value_entered_in_the_User_name_text_box_of_My_wallet_node_screen_is_editable_and_deleteable () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);	
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			//walletsettingspage.ClickUserNameTextBox();	
			walletsettingspage.SetValuesInUserNameTextBox("1234567890");
			Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "1234567890");
			walletsettingspage.ClearUserNameTextBox();
		}*/

/* Validate the User name text box in the wallet node screen by entering the special characters */
	
	/*@Test(priority = 97)
	public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_special_characters () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickUserNameTextBox();	
		walletsettingspage.SetValuesInUserNameTextBox("!@#$%^&*()");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "!@#$%^&*()");
		walletsettingspage.ClearUserNameTextBox();
	}	
	
/* Validate the User name text box in the wallet node screen by entering the alphabets both in upper case and lower case letter */
	
	/*@Test(priority = 98)
	public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_alphabets_both_in_upper_case_and_lower_case_letter () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.SetValuesInUserNameTextBox("ABCDEF");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "ABCDEF");
		walletsettingspage.ClearUserNameTextBox();
		walletsettingspage.SetValuesInUserNameTextBox("abcdef");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "abcdef");
		walletsettingspage.ClearUserNameTextBox();	
	}
	
	
/* Validate the User name text box in the wallet node screen by entering the alphanumeric value */
	
	/*@Test(priority = 99)
	public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_alphanumeric_value () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.SetValuesInUserNameTextBox("abc123");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "abc123");
		walletsettingspage.ClearUserNameTextBox();	
	}
	
/* Validate the User name text box in the wallet node screen by entering the decimal value */
	
	/*@Test(priority = 100)
	public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_decimal_value () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.SetValuesInUserNameTextBox("0.00001");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "0.00001");
		walletsettingspage.ClearUserNameTextBox();	
	}	*/
	
/* Validate the User name text box in the wallet node screen by entering the HTML value */
	
	/*@Test(priority = 101)
	public void To_Validate_the_User_name_text_box_in_the_wallet_Node_screen_by_entering_the_HTML_value () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickUserNameTextBox();	
		walletsettingspage.SetValuesInUserNameTextBox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		walletsettingspage.ClearUserNameTextBox();
	}		
	
/* Validate whether user is able to paste long text in User name text box in the My wallet node screen*/
	
	/*@Test(priority = 102)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_User_name_text_box_in_the_wallet_Node_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		//walletsettingspage.ClickNodeAddressTextBox();
		walletsettingspage.PasteValuesInUserNameTextBox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		walletsettingspage.ClearUserNameTextBox();
	}	
	
/* Validate the cursor blinks in Password text box on the My wallet node screen */
/* Validate the presence of placeholder in Password text box on the My wallet node screen */	
		
		/*@Test(priority = 103)
		public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_in_Password_text_box_on_the_wallet_Node_screen () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickPasswordTextBox();	
			Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
			Assert.assertEquals(walletsettingspage.getPasswordTextBoxPlaceholder(), "Password (Optional)");
		}	
		
/* Validate the Password text box in the wallet node screen by entering the empty space value */
		
		/*@Test(priority = 104)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_empty_space_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			//walletsettingspage.ClickNodeAddressTextBox();
			walletsettingspage.SetValuesInPasswordTextBox("     ");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "     ");
			walletsettingspage.ClearPasswordTextBox();	
		}	
		
/* Validate the Password text box in the wallet node screen by entering the special characters */
/* Validate whether the value entered in the Password text box of My wallet node screen is editable and delete-able */		
		
		/*@Test(priority = 105)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_special_characters_To_validate_whether_the_value_entered_in_the_Password_text_box_of_My_wallet_node_screen_is_editable_and_deleteable () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			//walletsettingspage.ClickNodeAddressTextBox();
			walletsettingspage.SetValuesInPasswordTextBox("!@#$%^&*()");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "!@#$%^&*()");
			walletsettingspage.ClearPasswordTextBox();	
		}*/		
		
/* Validate the Password text box in the wallet node screen by entering the HTML value */
		
		/*@Test(priority = 106)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_HTML_value () throws InterruptedException {
			Enablewalletpage = new EnableWalletScreen(driver);
			Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
			Enablewalletpage.ClickEnableWalletCheckBox();
			Enablewalletpage.ClickEnableWalletButton();
			//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//Thread.sleep(59000);
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"Chats");
			//Thread.sleep(10000);
			homepage.clickMenuDrawer();
		    menupage =new MenuScreen(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_option_Wallet();
			createpinpage = new CreatePINScreen(driver);
			//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
			createpinpage.setPassword_0();
			createpinpage.clickNext();
			createpinpage2 = new CreatePINScreen2(driver);
			createpinpage2.setPassword_0();
			createpinpage2.clickNext();	
			createpinpage2.clickOk();
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
			//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
			//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
			//Thread.sleep(59000);
			Thread.sleep(3000);
			mywalletpage.ClickSettingsOption();
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
			walletsettingspage.click_Current_Node();
			Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
			walletsettingspage.click_AddNode();
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.ClickPasswordTextBox();	
			walletsettingspage.SetValuesInPasswordTextBox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
			walletsettingspage.ClearPasswordTextBox();
		}	
		
/* Validate the Password text box in the wallet node screen by entering the numerical value */
		
		/*@Test(priority = 107)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_numerical_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			//walletsettingspage.ClickNodeAddressTextBox();
			walletsettingspage.SetValuesInPasswordTextBox("1234567890");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "1234567890");
			walletsettingspage.ClearPasswordTextBox();	
		}
		
/* Validate the Password text box in the wallet node screen by entering the both in upper case and lower case letter */
		
		/*@Test(priority = 108)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_both_in_upper_case_and_lower_case_letter () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.SetValuesInPasswordTextBox("ABCDEF");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "ABCDEF");
			walletsettingspage.ClearPasswordTextBox();
			walletsettingspage.SetValuesInPasswordTextBox("abcdef");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "abcdef");
			walletsettingspage.ClearPasswordTextBox();
		}	
		
/* Validate the Password text box in the wallet node screen by entering the alphanumeric value */
		
		/*@Test(priority = 109)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_alphanumeric_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.SetValuesInPasswordTextBox("abc123");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "abc123");
			walletsettingspage.ClearPasswordTextBox();	
		}	
		
/* Validate the Password text box in the wallet node screen by entering the decimal value */
		
		/*@Test(priority = 110)
		public void To_Validate_the_Password_text_box_in_the_wallet_Node_screen_by_entering_the_decimal_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.SetValuesInPasswordTextBox("0.00001");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "0.00001");
			walletsettingspage.ClearPasswordTextBox();
		}
		
/* Validate whether user is able to paste long text in Password text box in the My wallet node screen */
		
		/*@Test(priority = 111)
		public void To_Validate_whether_user_is_able_to_paste_long_text_in_Password_text_box_in_the_wallet_Node_screen () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
			walletsettingspage.PasteValuesInPasswordTextBox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
			Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
			walletsettingspage.ClearPasswordTextBox();
		}*/
	
/* Validate the working of cancel button in add node popup on the My wallet node screen */
	
	/*@Test(priority = 112)
	public void To_Validate_the_working_of_cancel_button_in_add_node_popup_on_the_my_wallet_node_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Click_Cancel_Button_In_Add_Node_Popup();
	}
	
/* Validate if entered texts are displayed in all text boxes in add node popup after user navigates to node screen and again come back to add node popup */
	
	/*@Test(priority = 113)
	public void To_Validate_if_entered_texts_are_displayed_in_all_textboxes_in_add_node_popup_after_user_navigates_to_node_screen_again_come_back_to_add_node_popup () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.ClickNodeAddressTextBox();	
		walletsettingspage.PasteValuesInNodeAddressTextBox("abcdef");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "abcdef");
		walletsettingspage.PasteValuesInNodePortTextBox("1234");
		Assert.assertEquals(walletsettingspage.getValuesFromNodePortTextBox(), "1234");
		walletsettingspage.PasteValuesInNodeNameTextBox("sat");
		Assert.assertEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "sat");
		walletsettingspage.PasteValuesInUserNameTextBox("satbill");
		Assert.assertEquals(walletsettingspage.getValuesFromUserNameTextBox(), "satbill");
		walletsettingspage.PasteValuesInPasswordTextBox("satbill@123");
		Assert.assertEquals(walletsettingspage.getValuesFromPasswordTextBox(), "satbill@123");
		driver.navigate().back();
		walletsettingspage.click_AddNode();
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodeAddressTextBox(), "abcdef");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodePortTextBox(), "1234");
		Assert.assertNotEquals(walletsettingspage.getValuesFromNodeNameTextBox(), "sat");
		Assert.assertNotEquals(walletsettingspage.getValuesFromUserNameTextBox(), "satbill");
		Assert.assertNotEquals(walletsettingspage.getValuesFromPasswordTextBox(), "satbill@123");
	}
	
	
	/* Validate the cursor blinks in Search Currency text box on the My wallet settings screen */
	/* Validate the presence of placeholder in Search Currency text box on the My wallet settings screen */	
	/* Validate whether the Search icon is displayed in Search Currency text box on the My wallet settings screen */
			
		/*@Test(priority = 114)
		public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_and_Search_icon_in_Search_currency_text_box_on_the_Wallet_settings_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);	
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		driver.navigate().back();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		driver.navigate().back();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.ClickSearchCurrencyTextBox();	
		Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
		Assert.assertEquals(walletsettingspage.getSearchCurrencyTextBoxPlaceholder(), "Search Currency");
		Assert.assertTrue(walletsettingspage.getSearchIconInSearchCurrencyPopup().isDisplayed());
		}*/
	
/* Validate the Search currency text box in the wallet settings screen by entering the empty space value */
	
	/*@Test(priority = 115)
	public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_empty_space_value () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.ClickSearchCurrencyTextBox();
		walletsettingspage.SetValuesInSearchCurrencyTextBox("     ");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "     ");
		walletsettingspage.ClearSearchCurrencyTextBox();
	}
	
	/* Validate the Search currency text box in the wallet settings screen by entering the special characters */
	/* Validate whether the value entered in the Search currency text box of My wallet settings screen is editable and delete-able */		
			
			/*@Test(priority = 116)
			public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_special_characters_To_validate_whether_the_value_entered_in_the_Search_currency_text_box_of_My_wallet_settings_screen_is_editable_and_deleteable () throws InterruptedException {
				walletsettingspage = new WalletSettingsScreen(driver);
				Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
				walletsettingspage.SetValuesInSearchCurrencyTextBox("!@#$%^&*()");
				Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "!@#$%^&*()");
				walletsettingspage.ClearSearchCurrencyTextBox();
			}
			
/* Validate the Search currency text box in the wallet settings screen by entering the numerical value */
			
			/*@Test(priority = 117)
			public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_numerical_value () throws InterruptedException {
				walletsettingspage = new WalletSettingsScreen(driver);			
				Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
				walletsettingspage.SetValuesInSearchCurrencyTextBox("1234567890");
				Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "1234567890");
				walletsettingspage.ClearSearchCurrencyTextBox();
			}
			
/* Validate the Search currency text box in the wallet settings screen by entering the decimal value */
			
			/*@Test(priority = 118)
			public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_decimal_value () throws InterruptedException {
				walletsettingspage = new WalletSettingsScreen(driver);			
				Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
				walletsettingspage.SetValuesInSearchCurrencyTextBox("0.00001");
				Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "0.00001");
				walletsettingspage.ClearSearchCurrencyTextBox();
			}*/
	
/* Validate the Search currency text box in the wallet settings screen by entering the HTML value */
	
	/*@Test(priority = 119)
	public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_HTML_value () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.ClickSearchCurrencyTextBox();
		walletsettingspage.SetValuesInSearchCurrencyTextBox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		walletsettingspage.ClearSearchCurrencyTextBox();
	}	

/*Validate the Search currency text box in the wallet settings screen by entering the alphanumeric value */
	
	/*@Test(priority = 120)
	public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_alphanumeric_value () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);			
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.SetValuesInSearchCurrencyTextBox("abc123");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "abc123");
		walletsettingspage.ClearSearchCurrencyTextBox();
	}
	
	
/* Validate the Search currency text box in the wallet settings screen by entering the alphabets both in upper case and lower case letter */
	
	/*@Test(priority = 121)
	public void To_Validate_the_Search_currency_text_box_in_the_wallet_settings_screen_by_entering_the_alphabets_both_in_uppercase_lowercase_letter () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);			
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.SetValuesInSearchCurrencyTextBox("abcdef");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "abcdef");
		walletsettingspage.ClearSearchCurrencyTextBox();
		walletsettingspage.SetValuesInSearchCurrencyTextBox("ABCDEF");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "ABCDEF");
		walletsettingspage.ClearSearchCurrencyTextBox();
	}
	
/* Validate whether user is able to paste long text in Search currency text box in the My wallet settings screen */
	
	/*@Test(priority = 122)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_Search_currency_text_box_in_the_wallet_settings_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.pasteValuesInSearchCurrencytextbox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		walletsettingspage.ClearSearchCurrencyTextBox();
	}	
	
/* Validate if entered texts are displayed in Search currency text box in Currency popup after user navigates to settings screen and again come back to currency popup */
	
	/*@Test(priority = 123)
	public void To_Validate_if_entered_texts_are_displayed_in_Search_currency_textbox_in_Currency_popup_after_user_navigates_to_settings_screen_again_come_back_to_currency_popup () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);	
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		walletsettingspage.SetValuesInSearchCurrencyTextBox("usd");
		Assert.assertEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "usd");
		//driver.navigate().back();
		walletsettingspage.ClickCloseIconInCurrencyPopup();
		walletsettingspage.click_Currency();
		Assert.assertEquals(walletsettingspage.getCurrencyPopupTitle(), "Currency");
		Assert.assertNotEquals(walletsettingspage.getValuesFromSearchCurrencyTextBox(), "usd");
	}*/
	
	/* Validate the cursor blinks in Search Contact text box on the My wallet Address book screen */
	/* Validate the presence of placeholder in Search Contact text box on the My wallet Address book screen */
	/* Validate whether the Search icon is displayed in Search Contact text box on the My wallet Address book screen */

			
		/*@Test(priority = 124)
		public void To_Validate_the_cursor_blinks_and_presence_of_placeholder_and_Search_icon_in_Search_Contact_text_box_on_the_Wallet_Address_book_screen () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.ClickSearchTextBoxInAddressBook();
		Assert.assertTrue(walletsettingspage.activeElement().isDisplayed());
		Assert.assertEquals(walletsettingspage.getSearchContactTextBoxPlaceholder(), "Search Contact");
		Assert.assertTrue(walletsettingspage.getSearchIconInSearchContactTextBox().isDisplayed());
		}	
		
/*Validate the Search Contact text box in the Wallet Address book screen by entering the empty space value */
		
		/*@Test(priority = 125)
		public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_book_screen_by_entering_the_alphanumeric_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);		
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
			walletsettingspage.Enter_values_In_Search_TextBox("     ");
			Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"     ");
			walletsettingspage.clear_search_textbox();
		}
		
/*Validate the Search Contact text box in the Wallet Address book screen by entering the numerical value */
		
		/*@Test(priority = 126)
		public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_book_screen_by_entering_the_numerical_value () throws InterruptedException {
			walletsettingspage = new WalletSettingsScreen(driver);		
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
			walletsettingspage.Enter_values_In_Search_TextBox("1234567890");
			Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"1234567890");
			walletsettingspage.clear_search_textbox();
		}	*/
	
/* Validate the Search Contact text box in the Wallet Address book screen by entering the special characters */
	
	/*@Test(priority = 127)
	public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_book_screen_by_entering_the_special_characters () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.ClickSearchTextBoxInAddressBook();
		walletsettingspage.Enter_values_In_Search_TextBox("!@#$%^&*()");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"!@#$%^&*()");
		walletsettingspage.clear_search_textbox();
	}
	
	/* Validate the Search Contact text box in the wallet Address book screen by entering the alphanumeric characters */
	/* Validate whether the value entered in the Search Contact text box of My wallet Address Book screen is editable and delete-able */		
			
			/*@Test(priority = 128)
			public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_Book_screen_by_entering_the_alphanumeric_value_To_validate_whether_the_value_entered_in_the_Search_Contact_text_box_of_My_wallet_Address_Book_screen_is_editable_and_deleteable () throws InterruptedException {
				walletsettingspage = new WalletSettingsScreen(driver);	
				Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
				walletsettingspage.Enter_values_In_Search_TextBox("abc123");
				Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"abc123");
				walletsettingspage.clear_search_textbox();
			}
			
/* Validate the Search Contact text box in the Wallet Address book screen by entering the alphabets both in upper case and lower case letter */
			
			/*@Test(priority = 129)
			public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_book_screen_by_entering_the_alphabets_both_in_upper_case_and_lower_case_letter () throws InterruptedException {
				walletsettingspage = new WalletSettingsScreen(driver);		
				Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
				walletsettingspage.Enter_values_In_Search_TextBox("abcdef");
				Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"abcdef");
				walletsettingspage.clear_search_textbox();
				walletsettingspage.Enter_values_In_Search_TextBox("ABCDEF");
				Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"ABCDEF");
				walletsettingspage.clear_search_textbox();	
			}
			
/* Validate the Search Contact text box in the Wallet Address book screen by entering the decimal value */
			
			/*@Test(priority = 130)
			public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_book_screen_by_entering_the_decimal_value () throws InterruptedException {
				walletsettingspage = new WalletSettingsScreen(driver);		
				Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
				walletsettingspage.Enter_values_In_Search_TextBox("0.00001");
				Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"0.00001");
				walletsettingspage.clear_search_textbox();			
			}*/
	
/* Validate the Search Contact text box in the Wallet Address book screen by entering the HTML value */
	
	/*@Test(priority = 131)
	public void To_Validate_the_Search_Contact_text_box_in_the_Wallet_Address_book_screen_by_entering_the_HTML_value () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		//Thread.sleep(59000);
		Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.ClickSearchTextBoxInAddressBook();
		walletsettingspage.Enter_values_In_Search_TextBox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		walletsettingspage.clear_search_textbox();
	}
	
/* Validate whether user is able to paste long text in Search Contact text box in the My wallet address book screen */
	
	/*@Test(priority = 132)
	public void To_Validate_whether_user_is_able_to_paste_long_text_in_Search_Contact_text_box_in_the_wallet_address_book_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);	
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.paste_Values_In_Searchtextbox("civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"civilian ticket oxidant sixteen luxury costume coal loudly poaching suffice cigar wife aplomb gnome bevel theatrics goat novelty adhesive sawmill beyond dwelt below code sixteen");
		walletsettingspage.clear_search_textbox();			
	}
	
/* Validate if entered texts are displayed in Search Contact text box in wallet address book screen after user navigates to settings screen and again come back to address book screen */
	
	/*@Test(priority = 133)
	public void To_Validate_if_entered_texts_are_displayed_in_Search_Contact_textbox_in_wallet_address_book_screen_after_user_navigates_to_settings_screen_again_come_back_to_address_book_screen () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);	
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.Enter_values_In_Search_TextBox("Test");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"Test");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		Assert.assertNotEquals(walletsettingspage.get_values_In_searchTextBox(),"Test");
	}*/
	
/* Validate whether No Contacts text is displayed in wallet address book screen when the user enters the invalid contact name */ 	
	
	/*@Test(priority = 134)
	public void To_Validate_whether_No_Contacts_text_is_displayed_in_wallet_address_book_screen_when_the_user_enters_the_invalid_contact_name () throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(10000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.SendOpt));
		Thread.sleep(59000);
		//Thread.sleep(3000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.ClickSearchTextBoxInAddressBook();
		walletsettingspage.Enter_values_In_Search_TextBox("testing");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"testing");
		Assert.assertEquals(walletsettingspage.Element_No_Contacts(),"No Contacts");
		walletsettingspage.clear_search_textbox();
	}
	
/* Validate whether No Addresses! text is displayed in wallet address book screen while having empty contacts */ 	
	
	/*@Test(priority = 135)
	public void To_Validate_whether_No_Addresses_text_is_displayed_in_wallet_address_book_screen_while_having_empty_contacts () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);	
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		Thread.sleep(59000);
        driver.navigate().back();
		Assert.assertEquals(walletsettingspage.emptyAddressBook_screen(),"No Addresses!");
		Thread.sleep(59000);
		driver.navigate().back();
		Thread.sleep(59000);
		driver.navigate().back();
	}			
	
/* Validate the cursor blinks in the block height text box in rescan screen */
	
	/*@Test(priority = 136)
	public void To_validate_the_cursor_blinks_in_blockheight_textbox_in_rescan_screen ()throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		mywalletpage.ClickSyncingOption();
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(), "Rescan");
		mywalletpage.ClickBlockHeightTextBox();
		Assert.assertTrue(mywalletpage.activeElement().isDisplayed());
	}
	
	
/* Validate whether user is able to paste empty space in block height text box in the My wallet Rescan screen*/
	
	/*@Test(priority = 137)
	public void To_validate_whether_user_is_able_to_paste_empty_space_in_blockheight_textbox_in_My_wallet_Rescan_screen ()throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(), "Rescan");
		mywalletpage.paste_Value_In_BlockheightTextBox("     ");
		Assert.assertNotEquals(mywalletpage.getValuesFromBlockheightTextBox(), "     ");
	}
	
/* Validate whether user is able to paste special characters in block height text box in the My wallet Rescan screen*/
	
	/*@Test(priority = 138)
	public void To_validate_whether_user_is_able_to_paste_special_characters_in_blockheight_textbox_in_My_wallet_Rescan_screen ()throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(), "Rescan");
		mywalletpage.paste_Value_In_BlockheightTextBox("!@#$%^&*()");
		Assert.assertNotEquals(mywalletpage.getValuesFromBlockheightTextBox(), "!@#$%^&*()");
	}*/
	
/* Validate whether user is able to paste alphanumeric value in block height text box in the My wallet Rescan screen*/
	
	@Test(priority = 139)
	public void To_validate_whether_user_is_able_to_paste_alphanumeric_value_in_blockheight_textbox_in_My_wallet_Rescan_screen ()throws InterruptedException {
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Thread.sleep(59000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		//Thread.sleep(59000);
		homepage.clickMenuDrawer();
	    menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage = new CreatePINScreen(driver);
		//Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpinpage.setPassword_0();
		createpinpage.clickNext();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		createpinpage2.clickNext();	
		createpinpage2.clickOk();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(mywalletpage.ElementofStatusSynchronized()));
		//Thread.sleep(59000);
		mywalletpage.ClickSyncingOption();
		mywalletpage.ClickRescanOption();
		Assert.assertEquals(mywalletpage.getRescanTitle(), "Rescan");
		mywalletpage.ClickBlockHeightTextBox();
		mywalletpage.paste_Value_In_BlockheightTextBox("abc123");
		Assert.assertNotEquals(mywalletpage.getValuesFromBlockheightTextBox(), "abc123");
		 }
		 
/* Validate whether user is able to paste decimal value in block height text box in the My wallet Rescan screen*/
	
	@Test(priority = 140)
	public void To_validate_whether_user_is_able_to_paste_decimal_value_in_blockheight_textbox_in_My_wallet_Rescan_screen ()throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(), "Rescan");
		mywalletpage.paste_Value_In_BlockheightTextBox("0.00001");
		Assert.assertNotEquals(mywalletpage.getValuesFromBlockheightTextBox(), "0.00001");
	}
	
/* Validate whether user is able to paste HTML value in block height text box in the My wallet Rescan screen*/
	
	@Test(priority = 141)
	public void To_validate_whether_user_is_able_to_paste_HTML_value_in_blockheight_textbox_in_My_wallet_Rescan_screen ()throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getRescanTitle(), "Rescan");
		mywalletpage.paste_Value_In_BlockheightTextBox("<a href=\\\"https://www.example.com\\\">Visit Example</a>");
		Assert.assertNotEquals(mywalletpage.getValuesFromBlockheightTextBox(), "<a href=\\\"https://www.example.com\\\">Visit Example</a>");
	}
	
	}
