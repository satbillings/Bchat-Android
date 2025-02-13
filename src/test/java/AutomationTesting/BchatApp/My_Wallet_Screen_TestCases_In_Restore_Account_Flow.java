package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatScreen;
import POM.CreatePINScreen;
import POM.CreatePINScreen2;
import POM.CreatePasswordScreen;
import POM.EnableWalletScreen;
import POM.HomeScreen;
import POM.JoinSocialGroupScreen;
import POM.MenuScreen;
import POM.MyWalletScreen;
import POM.NotificationsScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SecretGroupChatScreen;
import POM.SeedScreen;
import POM.SocialGroupChatScreen;
import POM.WalletReceiveScreen;
import POM.WalletSendScreen;
import POM.WalletSettingsScreen;
import TestUtiles.baseclass;

public class My_Wallet_Screen_TestCases_In_Restore_Account_Flow extends baseclass{
	OpeningPage Openingpage;
	SeedScreen Seedpage;
	RestoreFromSeedScreen restorefromseedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
    SecretGroupChatScreen groupchatpage;
    ChatScreen chatpage;
    SocialGroupChatScreen socialgroupchatpage;
    JoinSocialGroupScreen joinsocialgrouppage;
    MenuScreen menupage;
	EnableWalletScreen Enablewalletpage;
	CreatePINScreen createpinpage;
	CreatePINScreen2 createpinpage2;
	MyWalletScreen mywalletpage;
	WalletSendScreen sendpage;
	WalletSettingsScreen walletsettingspage;
	WalletReceiveScreen walletreceivepage;
	NotificationsScreen notificationspage;
	WebDriverWait wait;
    
    @Test(priority = 0)
   	public void PreSetup() throws InterruptedException {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Openingpage = new OpeningPage(driver); 
		 Openingpage.clickSignIn(); 
		 Seedpage = new SeedScreen(driver);
		Assert.assertTrue(Seedpage.SeedTextBox().isDisplayed());
		Seedpage.pasteSeedValue(); 
		Seedpage.clickNext(); 
		restorefromseedpage = new RestoreFromSeedScreen(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.paste_Value_In_DisplayName("Sathish");
		restorefromseedpage.paste_Value_In_Blockheight("4000000");
		restorefromseedpage.clickBtnRestore(); 
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		 createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		//Thread.sleep(10000); 
		 homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		//restrictNotification();
		Thread.sleep(59000);
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		Thread.sleep(2000);
		menupage.click_option_Wallet();
		Enablewalletpage = new EnableWalletScreen(driver);
		Assert.assertEquals(Enablewalletpage.getEnableWalletScreenTitle(),"Wallet");
		Enablewalletpage.ClickEnableWalletCheckBox();
		Enablewalletpage.ClickEnableWalletButton();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
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
    }
    /*
	Validate whether blocks sync happens well when we disconnect internet and connect internet while blocks syncing.
	*/
	/*@Test(priority = 1)
	public void To_Validate_whether_blocks_sync_happens_well_when_we_disconnect_internet_and_connect_internet_while_blocks_syncing  () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		turnOff_Mobile_Wifi();
		Thread.sleep(8000);
		turnOn_Mobile_Wifi();
		Thread.sleep(8000);
	}
	/*
	  Validate Working Of blocks syncing while navigate to home screen and back to My Wallet screen.
	*/
	/*@Test(priority = 2)
	public void To_validate_Working_Of_blocks_syncing_while_navigate_to_home_screen_and_back_to_My_Wallet_screen () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickBackArrow();
		homepage = new HomeScreen(driver);
	    Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpinpage2 = new CreatePINScreen2(driver);
		createpinpage2.setPassword_0();
		mywalletpage = new MyWalletScreen(driver);
	    Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
	}
	/*
	Validate whether able to do transactions before synchronized of the blocks.
	*/
	/*@Test(priority = 3)
	public void To_Validate_Whether_able_to_do_transactions_before_Blocks_synchronized () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSendOption();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.getSyncingStatus(), "Wallet Syncing..");
		mywalletpage.ClickScanOption();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.getSyncingStatus(), "Wallet Syncing..");
	}
	/*
	Validate the screen navigation occurs well inside wallet while blocks syncing.
	*/
	/*@Test(priority = 4)
	public void To_Validate_screen_navigation_occurs_well_inside_wallet_while_blocks_syncing () {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickReceiveOption();
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		mywalletpage.ClickBackArrow();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.getSyncingStatus(), "Wallet Syncing..");
	}
	/*
	Validate node changes well while blocks sync is in progress in my wallet screen.
	*/
	/*@Test(priority = 5)
	public void To_Validate_node_changes_well_while_blocks_syncing_in_my_wallet_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(4000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
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
	    walletsettingspage.click_Back_Arrow();
	    Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.getSyncingStatus(), "Wallet Syncing..");
	   
	}
	/*
	Validate the working of reconnect and rescan option while blocks syncing in my wallet screen.
	*/
	/*@Test(priority = 6)
	public void To_Validate_the_working_of_reconnect_and_rescan_option_while_blocks_syncing_in_my_wallet_screen ()
	{
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		mywalletpage.ClickSyncingOption();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.getSyncingStatus(), "Wallet Syncing..");
	}
	/*
	Validate whether transaction histories are visible in my wallet screen.
	*/
	/*@Test(priority = 7)
	public void To_Validate_whether_transaction_histories_are_visible_in_my_wallet_screen () throws InterruptedException{
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(58000);
		Assert.assertTrue(mywalletpage.Element_of_First_Transaction().isDisplayed());		
	}
	/*
	Validate the working of the transactions filter by incoming in my wallet screen.
	*/
	/*@Test(priority = 8)
	public void To_Validate_the_working_of_transactions_filter_by_incoming_in_my_wallet_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(58000);
		mywalletpage.click_Transaction_Filter();
	    Thread.sleep(5000);
		mywalletpage.click_Outgoing_CheckBox();
		//Assert.assertEquals(Toast(), "Filter applied");
		Thread.sleep(5000);
	}
	/*
	Validate the working of the transactions filter by outgoing in my wallet screen.
	*/
	/*@Test(priority = 9 )
	public void To_Validate_the_working_of_transactions_filter_by_outgoing_in_my_wallet_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//Thread.sleep(3000);
		mywalletpage.click_Outgoing_CheckBox();
		Thread.sleep(5000);
		mywalletpage.click_Incoming_CheckBox();
		//Assert.assertEquals(Toast(), "Filter applied");
		Thread.sleep(5000);
		}
	/*
	 Validate the working of cancel button in the filter by date in my wallet screen.
	 */
	/*@Test(priority = 10)
	public void To_Validate_the_working_of_cancel_button_in_filter_by_date_in_my_wallet_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//mywalletpage.click_Transaction_Filter();
		mywalletpage.click_Filter_By_date();
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		Thread.sleep(3000);
		mywalletpage.click_Cancel_In_FilterDate();
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
	}
	/*
	 Validate the working of Transaction filter by date without selecting both date in my wallet screen.
	 */
	/*@Test(priority = 11)
	public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_both_date_in_my_wallet_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(3000);
		mywalletpage.click_Filter_By_date();
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		Thread.sleep(3000);
		mywalletpage.click_ok_In_FilterDate();
		//Assert.assertEquals(Toast(), "Please enter from date");
		Thread.sleep(4000);
		
	}
	  /*
		Validate the working of Transaction filter by date without selecting from date in my wallet screen.
		*/
		/*@Test(priority = 12)
		public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_from_date_in_my_wallet_screen () throws InterruptedException {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			mywalletpage.Select_ToDate_As_TodayDate();
			Thread.sleep(3000);
			mywalletpage.click_ok_In_FilterDate();
			
		}
		/*
		 Validate the working of Transaction filter by date without selecting To date in my wallet screen.
		 */
		/*@Test(priority = 13)
		public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_To_date_in_my_wallet_screen () throws InterruptedException {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
			Thread.sleep(58000);
			mywalletpage.click_Transaction_Filter();
			Thread.sleep(3000);
			mywalletpage.click_Filter_By_date();
			Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			Thread.sleep(3000);
			mywalletpage.Select_FromDate_previousMonth(1);
			Thread.sleep(5000);
			mywalletpage.click_ok_In_FilterDate();
			Thread.sleep(3000);
			mywalletpage.click_Cancel_In_FilterDate();
			Thread.sleep(4000);
		}
		/*
		Validate the working of the transactions filter by date in my wallet screen.
		*/
		/*@Test(priority = 14)
		public void To_Validate_the_working_of_transactions_filter_by_date_in_my_wallet_screen () throws InterruptedException {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
			mywalletpage.click_Filter_By_date();
			Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			Thread.sleep(3000);
			mywalletpage.Select_FromDate_previousMonth(1);
			Thread.sleep(3000);
			mywalletpage.Select_ToDate_As_TodayDate();
			Thread.sleep(3000);
			mywalletpage.click_ok_In_FilterDate();
			Thread.sleep(4000);
			//Assert.assertEquals(Toast(),"Filter applied");
		}
		/*
		Validate the working of transaction details drop down in my wallet screen.
		*/
		/*@Test(priority = 15)
		public void To_Validate_the_working_of_transaction_details_dropdown_in_my_wallet_screen () throws InterruptedException {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
			mywalletpage.click_Transaction_Filter();
			mywalletpage.click_First_Transaction();
			Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			mywalletpage.click_BackArrow_In_details();
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		}
		/*
		Validate whether same amount showing in the transaction history and in details section.
		*/
		/*@Test(priority = 16)
		public void To_validate_whether_same_amount_showing_in_transaction_history_and_details_section () {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
			String FirstAmount = mywalletpage.get_first_Transaction_amount();
			mywalletpage.click_First_Transaction();
			Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			Assert.assertEquals(FirstAmount, mywalletpage.get_Amount_In_details());
		
		}
		/*
		Validate the navigation to explorer page on clicking transaction Id in my wallet screen.
		*/
	/*	@Test(priority = 17)
		public void To_validate_the_navigation_to_explorer_page_on_clicking_transaction_Id_in_my_wallet_screen () {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			mywalletpage.click_transactionID();
			//Assert.assertTrue(mywalletpage.get_Explorer_Url().contains("explorer.beldex.io"));
			driver.navigate().back();
		}
		/*
		Validate the working of the copy icons in the transaction details section.
		*/
		/*@Test(priority = 18)
		public void To_validate_the_working_of_copy_icon_in_transaction_details_section () throws InterruptedException {
			mywalletpage = new MyWalletScreen(driver);
			Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
			Thread.sleep(58000);			
			mywalletpage.click_First_Transaction();
			Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			Thread.sleep(8000);
			mywalletpage.click_CopyIcon_In_details();
			//Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			Thread.sleep(8000);
			mywalletpage.click_BackArrow_In_details();
			Thread.sleep(8000);
			//Assert.assertEquals(Toast(), "Copied to clip board");
			//Thread.sleep(4000);		
			}
		/*
		Validate the working of the send amount functionality with amount greater than balance in wallet send screen.
		*/
		/*@Test(priority = 19)
		public void To_validate_the_working_of_send_amount_functionality_with_amount_greater_than_balance_in_wallet_send_screen () throws InterruptedException {
			mywalletpage = new MyWalletScreen(driver);
			mywalletpage.ClickSendOption();
			sendpage = new WalletSendScreen(driver);
			Assert.assertEquals(sendpage.pagetitle(),"Send");
			//Thread.sleep(5000);
			sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		//	Thread.sleep(3000);
			sendpage.Enter_Values_In_Amount("10");
			//Thread.sleep(3000);
			sendpage.swipeGesture(100, 100, 200, 200, "UP");
			Thread.sleep(3000);
			sendpage.click_send();
		//	Thread.sleep(3000);
			createpasswordpage = new CreatePasswordScreen(driver);
			createpasswordpage.setPassword_0();
			Assert.assertEquals(sendpage.transactionError_popup_Title(),"Create Transaction Error");
			//Thread.sleep(4000);
			sendpage.click_ok();
			Thread.sleep(3000);
			
		}
		/*
		Validate amount entered in BDX conversion to the selected currency in wallet send screen.
		*/
		/*@Test(priority = 20)
		public void To_Validate_amount_entered_in_BDX_conversion_to_selected_currency_in_wallet_send_screen () throws InterruptedException {
			sendpage = new WalletSendScreen(driver);
			Assert.assertEquals(sendpage.pagetitle(),"Send");
			sendpage.Enter_Values_In_Amount("10");
			Assert.assertNotEquals(sendpage.get_fiatCurrency_Value(),"0.0000 USD");
			Thread.sleep(2000);
			sendpage.clear_TextBoxes();
		}
		/*
		Validate the working of the send functionality with a valid Address and invalid amount in wallet send screen.
		*/
		/*@Test(priority = 21)
		public void To_Validate_the_working_of_send_functionality_with_valid_Address_and_Invalid_Amount_in_wallet_send_screen () {
			
			sendpage = new WalletSendScreen(driver);
			Assert.assertEquals(sendpage.pagetitle(),"Send");
			sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
			sendpage.Enter_Values_In_Amount("0.0000");
			sendpage.click_send();
			Assert.assertEquals(sendpage.get_Error_Msg_In_Amount(),"Enter a valid amount");
			Assert.assertEquals(sendpage.pagetitle(),"Send");
			sendpage.clear_TextBoxes();
			
		}
		/*
		Validate whether the values in the amount and address text boxes got cleared in wallet send screen after navigate to pin screen
		*/
		/*@Test(priority = 22)
		public void To_Validate_whether_the_values_in_amount_and_address_text_boxes_got_cleared_in_wallet_send_screen_after_navigate_to_pin_screen () throws InterruptedException {
			
			sendpage = new WalletSendScreen(driver);
			Assert.assertEquals(sendpage.pagetitle(),"Send");
			sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
			sendpage.Enter_Values_In_Amount("0.00001");
			sendpage.click_send();
			Thread.sleep(3000);
			sendpage.click_BackArrow();
			Thread.sleep(3000);
			Assert.assertEquals(sendpage.get_Values_In_AmountField(),"");
		}*/
    
    
	
	
	/*
	 Validate whether able to enter multiple dots and commas in amount field in wallet send screen.
	 */
	/*@Test(priority = 23)
	public void To_validate_whether_able_to_enter_multiple_dots_and_commas_in_amount_field_in_wallet_send_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver,Duration.ofMinutes(5));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.ElementofStatusSynchronized()));
		Thread.sleep(59000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.paste_Value_In_Amount("0.01.");
		Assert.assertTrue(sendpage.get_Values_In_AmountField().isEmpty());
	    sendpage.paste_Value_In_Amount("0,01");
	    Assert.assertTrue(sendpage.get_Values_In_AmountField().isEmpty());
	}
	/*
	 Validate the amount text box by entering lengthy amount value in wallet send screen.
	 */
	/*@Test(priority = 24)
	public void To_validate_the_amount_text_box_by_entering_lengthy_amount_value_in_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Amount("123456789012345");
		Assert.assertEquals(sendpage.get_Error_Msg_In_Amount(),"Enter a valid amount");
		sendpage.clear_TextBoxes();
		
	}
	/*
	 Validate whether able to paste values in the address and amount text boxes in wallet send screen.
	 */
	/*@Test(priority = 25)
	public void To_Validate_Whether_Able_To_Paste_Values_in_address_amount_text_Boxes_in_wallet_send_screen () {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.paste_Value_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.paste_Value_In_Amount("0.00001");
		Assert.assertFalse(sendpage.get_Values_In_AmountField().isEmpty());
		Assert.assertFalse(sendpage.get_Values_In_AddressField().isEmpty());
		sendpage.clear_TextBoxes();
	}
	/*
	 Validate the working of the send functionality with a invalid address and valid amount in wallet send screen.
	 */
	/*@Test(priority = 26)
	public void To_Validate_the_working_of_send_functionality_with_invalid_address_and_valid_amount_in_wallet_send_screen () throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		//Thread.sleep(5000);
		sendpage.Enter_Values_In_Address("bxc3P1trLBnjiLEgu3SjwqqnWuTv3446ejLgMV4gi5s1fMJnar3A");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.swipeGesture(100, 100, 200, 200, "UP");
		Thread.sleep(2000);
		sendpage.click_send();
		createpasswordpage = new CreatePasswordScreen(driver);
	    createpasswordpage.setPassword_0();
	    Assert.assertEquals(sendpage.transactionError_popup_Title(),"Create Transaction Error");
		sendpage.click_ok();
		Assert.assertEquals(sendpage.pagetitle(),"Send");		
	}
	/*
	Validate the working of the send amount functionality without internet connection in wallet send screen.
	*/
	/*@Test(priority = 27)
	public void To_Validate_the_working_of_send_amount_functionality_without_internet_connection_in_wallet_send_screen () throws InterruptedException {
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		turnOff_Mobile_Wifi();
		Thread.sleep(8000);
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.00001");
		sendpage.swipeGesture(100, 100, 200, 200, "UP");
		Thread.sleep(8000);
		sendpage.click_send();
		//Assert.assertEquals(Toast(), "Please check your internet connection");
		Thread.sleep(8000);
		turnOn_Mobile_Wifi();
		Thread.sleep(8000);
		sendpage.clear_TextBoxes();
		Assert.assertEquals(sendpage.pagetitle(),"Send");	
	}*/
    
    /*
	 Validate the working of cancel button in confirm sending popup in wallet send screen.
	 */
	/*@Test(priority = 28)
	public void To_Validate_the_working_of_cancel_button_in_confirm_sending_popup_in_wallet_send_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		//wait = new WebDriverWait(driver,Duration.ofMinutes(5));
		//wait.until(ExpectedConditions.visibilityOf(mywalletpage.ElementofStatusSynchronized()));
		Thread.sleep(59000);
		mywalletpage.ClickSendOption();
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		//Thread.sleep(3000);
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.swipeGesture(100, 100, 200, 200, "UP");
		Thread.sleep(2000);
		sendpage.click_send();
		createpasswordpage = new CreatePasswordScreen(driver);
		createpasswordpage.setPassword_0();
		//Thread.sleep(4000);		
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		sendpage.click_Cancel_In_confirm_sending_popup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
	}
	/*
	 Validate the working of the send functionality by using contacts book in wallet send screen.
	 */
	/*@Test(priority = 29)
	public void To_Validate_the_working_of_send_functionality_by_using_contacts_book_in_wallet_send_screen () throws InterruptedException {
	    sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
        sendpage.Enter_Values_In_Amount("0.0001");
        sendpage.click_AddressBook();
        walletsettingspage = new WalletSettingsScreen(driver);
        walletsettingspage.click_CopyOrSend_Of_FirstAddress();
		sendpage.swipeGesture(100, 100, 200, 200, "UP");
		Thread.sleep(2000);
        sendpage.click_send();
        createpasswordpage = new CreatePasswordScreen(driver);
        createpasswordpage.setPassword_0();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		Assert.assertEquals(sendpage.Element_Confirm_Popup().getText(), "Confirm Sending");
		sendpage.click_Cancel_In_confirm_sending_popup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
	}
	/*
	Validate the working of the send functionality with a valid address and valid amount in wallet send screen.
	*/
	/*@Test(priority = 30)
	public void To_Validate_the_working_of_send_functionality_with_valid_Address_and_valid_amount_in_wallet_send_screen () throws InterruptedException {
				
		sendpage = new WalletSendScreen(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.swipeGesture(100, 100, 200, 200, "UP");
		Thread.sleep(2000);
		sendpage.click_send();
		createpasswordpage = new CreatePasswordScreen(driver);
		createpasswordpage.setPassword_0();
		wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		Assert.assertEquals(sendpage.Element_Confirm_Popup().getText(), "Confirm Sending");
		sendpage.click_Cancel_In_confirm_sending_popup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_BackArrow();	
	}
	/*
	Validate the node screen without Internet connection
	*/
	/*@Test(priority = 31)
	public void To_Validate_the_node_screen_without_internet_connection () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		turnOff_Mobile_Wifi();
		Thread.sleep(8000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
	    Assert.assertEquals(walletsettingspage.get_Current_Node(),"Waiting for network..");
	    walletsettingspage.click_Current_Node();
	    walletsettingspage.click_Back_Arrow();
		turnOn_Mobile_Wifi();
		Thread.sleep(8000);
        }
	/*
	 Validate the working of cancel icons in all popups in wallet settings screen.
	 */
	/*@Test(priority = 32)
	public void To_Validate_the_working_of_cancel_icons_in_all_popups_in_wallet_settings_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_DisplayBalanceAs();
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Decimals();
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Fee_priority();
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	/*
	Validate whether the user is able to select all options in Display Balance As option in wallet settings screen.
	*/
	/*@Test(priority = 33)
	public void To_Validate_whether_user_is_able_to_select_all_options_in_DisplayBalanceAs_option_in_wallet_settings_screen () {
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		//walletsettingspage.scrollgesture_Using_text("Change Pin");
		//Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Full Balance");
		walletsettingspage.ClickBeldexAvailableBalance();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Beldex_Available_Balance(), "Beldex Available Balance");
	}
	/*
	 Validate the working of the beldex hidden option in Display Balance As option in wallet settings screen.
	 */
	/*@Test(priority = 34)
	public void To_Validate_the_working_of_beldex_hidden_option_in_DisplayBalanceAs_option_in_wallet_settings_screen () {
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.ClickBeldexHidden();
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Beldex_Hidden(), "Beldex Hidden");
		walletsettingspage.click_Back_Arrow();
		mywalletpage = new MyWalletScreen(driver);
		Assert.assertEquals(mywalletpage.get_Bdx_value(),"---");
		mywalletpage.ClickSettingsOption();
	}
	/*
	Validate whether the user is able to select all options in Decimals option in wallet settings screen.
	*/
	/*@Test(priority = 35)
	public void To_Validate_whether_the_user_is_able_to_select_all_options_in_Decimals_option_in_wallet_settings_screen () {
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.ClickZeroDigitDecimal();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_DecimalAs_Zero(), "0 - Zero (0)");
	}*/
    /*
	Validate whether the user is able to select options in the currency option in wallet settings screen.
   	*/
	/*@Test(priority = 36)
	public void To_Validate_whether_the_user_is_able_to_select_options_in_currency_option_in_wallet_settings_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.ClickBRLCurrency();
		Assert.assertEquals( walletsettingspage.getBRLCurrency(), "BRL");
		}
	/*
	 Validate whether the currency list is Scrollable in wallet settings screen.
	 */
	/*@Test(priority = 37)
	public void To_Validate_whether_currency_list_is_Scrollable_in_wallet_settings_screen (){
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		walletsettingspage.scrollgesture_Using_text("ZAR");
		}
	/*
    Validate the working of the search currency text box with valid value in currency popup in wallet settings screen.
   */
	/*@Test (priority = 38)
	public void To_validate_the_working_of_search_currency_text_box_with_valid_value_in_currency_popup_in_wallet_settings_screen (){
		walletsettingspage = new  WalletSettingsScreen(driver);
		walletsettingspage.Enter_values_In_Search_TextBox("INR");
		walletsettingspage.click_Searched_Currency();
		Assert.assertEquals(walletsettingspage.getINRCurrency(), "INR");
		walletsettingspage.click_CancelIcon_In_Popup();
	}
	/*
	Validate the working of all options in Fee Priority popup in wallet settings screen.
	*/
	/*@Test(priority = 39)
	public void To_Validate_working_of_all_options_in_Fee_Priority_popup_in_wallet_settings_screen () {
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.getFlashPriority(),"Flash");
		walletsettingspage.ClickSlowPriority();
		Assert.assertEquals(walletsettingspage.getSlowPriority(),"Slow");
	}*/
	/*
	 Validate whether the selected option is option is displayed in wallet Settings and My Wallet screen. 
	 */
	/*@Test(priority = 40)
	public void To_Validate_whether_the_selected_option_is_displayed_in_wallet_Settings_and_My_Wallet_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Thread.sleep(3000);
		walletsettingspage.ClickBeldexAvailableBalance();
		walletsettingspage.ClickZeroDigitDecimal();
		walletsettingspage.ClickBRLCurrency();
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Beldex_Available_Balance(), "Beldex Available Balance");
		Assert.assertEquals(walletsettingspage.get_DecimalAs_Zero(), "0 - Zero (0)");
		Assert.assertEquals( walletsettingspage.getBRLCurrency(), "BRL");
		walletsettingspage.click_Back_Arrow();
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.get_Available_Balance(),"1");
     	Assert.assertEquals(mywalletpage.get_Balance_Currency_Conversion(),"0.24 BRL");
		Thread.sleep(8000);
		mywalletpage.ClickSettingsOption();
	}
	/*
	Validate the navigation to the address book screen from wallet settings screen.
	*/
	/*@Test(priority = 41)
	public void To_Validate_the_navigate_to_Address_book_screen_from_wallet_settings_screen () throws InterruptedException {
		walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	/*
	 Validate the Address book screen while having a contacts.
	 */
	/*@Test(priority = 42)
	public void To_Validate_the_Address_book_screen_while_having_a_contacts () throws InterruptedException {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertTrue(walletsettingspage.Element_of_Copy_Icon().isDisplayed());
	}
	/*
	Validate the working of the search Text box with invalid contact name in address book screen
	*/
	/*@Test(priority = 43)
	public void To_validate_the_working_of_search_text_box_with_invalid_contact_name_in_address_book_screen () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.Enter_values_In_Search_TextBox("*1234@#45");
		Assert.assertEquals(walletsettingspage.Element_No_Contacts(),"No Contacts");
		walletsettingspage.clear_search_textbox();
	}
	/*
	Validate whether the user is able to paste the contact name in search text box in address book screen.
	*/
	/*@Test(priority = 44)
	public void To_validate_whether_the_user_is_able_to_paste_contact_name_in_search_textbox_in_address_book_screen () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.paste_Values_In_Searchtextbox("Test");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"Test");
		walletsettingspage.clear_search_textbox();
	}*/
    /*
	Validate the working of the cancel icon inside the search text box in address book screen.
	*/
	/*@Test(priority = 45)
	public void To_validate_the_working_of_cancel_icon_inside_the_search_textbox_in_address_book_screen () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.paste_Values_In_Searchtextbox("check");
		walletsettingspage.click_closeIcon_In_searchtextbox();
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"");
	}	
	/*
	Validate the working of copy icon in address book screen.
	*/
	/*@Test(priority = 46)
	public void To_validate_the_working_of_copy_icon_in_address_book_screen () {
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.click_CopyOrSend_Of_FirstAddress();
		//Assert.assertEquals(Toast(),"Copied to clipboard");
	    driver.navigate().back();
	}
	/*
	Validate the Change pin functionality by entering a valid old pin.
	*/
	 /*@Test(priority = 47)
	public void To_Validate_the_Change_pin_functionality_by_entering_a_valid_old_pin () {
		 walletsettingspage = new  WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_change_Pin();	
		createpinpage2 = new CreatePINScreen2(driver);
		Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		walletsettingspage.click_Back_Arrow();
	 }
	 /*
		Validate the Change pin functionality by entering a invalid old pin.
		*/
		/* @Test(priority = 48)
		public void To_Validate_the_Change_pin_functionality_by_entering_a_invalid_old_pin () throws InterruptedException {
			 walletsettingspage = new  WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
			walletsettingspage.click_change_Pin();	
			createpinpage2 = new CreatePINScreen2(driver);
			Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");
			createpasswordpage = new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			//Assert.assertEquals(Toast(),"Incorrect PIN.");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			Thread.sleep(4000);
			walletsettingspage.click_Back_Arrow();
		 }*/
    /*
	Validate the Whether the user is able to navigate to the next screen without entering a value enter pin fields.
	*/
	@Test(priority = 49 )
	public void To_Validatethe_Whether_the_user_is_able_to_navigate_to_next_screen_without_entering_a_values_in_pin_fields () throws InterruptedException {
		mywalletpage = new MyWalletScreen(driver);	
		Assert.assertEquals(mywalletpage.getMyWalletScreenTitle(), "My Wallet");
		Thread.sleep(59000);
		mywalletpage.ClickSettingsOption();
		walletsettingspage = new WalletSettingsScreen(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(10000);
		walletsettingspage.click_change_Pin();
		createpinpage2 = new CreatePINScreen2(driver);
		Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");		
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
		walletsettingspage.click_Back_Arrow();
	}
	/*
	 Validate whether able to set new pin with old pin value.
	 */
	@Test(priority = 50)
	public void To_Validate_whether_able_to_set_new_pin_with_old_pin_value () throws InterruptedException {
		    walletsettingspage = new  WalletSettingsScreen(driver);
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
			walletsettingspage.click_change_Pin();	
			createpinpage2 = new CreatePINScreen2(driver);
			Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");		
			createpasswordpage = new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			//Assert.assertEquals(Toast(), "New PIN should not be same as old PIN.");
			walletsettingspage.click_Back_Arrow();
			Thread.sleep(4000);

	}
	/*
	Validate the Change Pin functionality by entering a valid value in New pin and invalid value in Re-Enter pin.
	*/
	@Test(priority = 51 )
	public void To_Validate_the_Change_Pin_functionality_by_entering_a_valid_value_in_New_pin_and_invalid_value_in_ReEnter_pin () throws InterruptedException {
		   walletsettingspage = new  WalletSettingsScreen(driver);
		   Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		   walletsettingspage.click_change_Pin();
		   createpinpage2 = new CreatePINScreen2(driver);
		   Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");		
		    createpasswordpage = new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Thread.sleep(4000);
			//Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			//Assert.assertEquals(Toast(),"Both PINs should be same.");
			walletsettingspage.click_Back_Arrow();
	}
	/*
	Validate the Change Pin functionality by entering a valid Create pin and valid Re-Enter pin.
	*/
	@Test(priority = 52)
	public void To_Validate_the_Change_Pin_functionality_by_entering_a_valid_Create_pin_and_valid_ReEnter_pin () throws InterruptedException {
		   walletsettingspage = new  WalletSettingsScreen(driver);
		   Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		   walletsettingspage.click_change_Pin();
		   createpinpage2 = new CreatePINScreen2(driver);
		   Assert.assertEquals(createpinpage2.getVerifyPINScreenTitle(),"Verify PIN");		
		   createpasswordpage = new CreatePasswordScreen(driver);
		   Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		   createpasswordpage.change_password_with_Valid_value();
		   Thread.sleep(1000);
		   createpasswordpage.clickOk();
		   Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}

}
