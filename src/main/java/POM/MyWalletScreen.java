package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyWalletScreen extends ActionsClass {
	AndroidDriver driver;
	public MyWalletScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='My Wallet']")
	private WebElement MyWalletScreenTitle;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement BackArrow;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Wallet Syncing..']")
	private WebElement SyncingStatus;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Synchronized']")
	private WebElement SynchronizedStatus;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='No Transactions yet!']")
	private WebElement TransactionEmptyStatus;
	
	@AndroidFindBy(xpath="//android.view.View[@index='10']")
	private WebElement TransactionFilter;
	
	@AndroidFindBy(xpath="//android.view.View[@index='5']")
	private WebElement ScanOption;
	
	@AndroidFindBy(xpath="//android.view.View[@index='6']")
	//@AndroidFindBy(accessibility  = "Send")
	private WebElement SendOption;
	
	@AndroidFindBy(xpath="//android.view.View[@index='7']")
	private WebElement ReceiveOption;
	
	@AndroidFindBy(xpath="//android.view.View[@index='8']")
	private WebElement SyncingOption;
	
	@AndroidFindBy(xpath="//android.view.View[@index='2']")
	private WebElement SettingsOption;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/reConnectButton_Alert")
	private WebElement reconnectOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/rescanButton_Alert")
	private WebElement rescanOption;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[1][@text='Reconnecting...']")
	private WebElement StatusReconnecting;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan']")
	private WebElement ScanpageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Send']")
	private WebElement SendpageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Receive']")
	private WebElement ReceivepageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Rescan']")
	private WebElement ReScanpageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Syncing Option']")
	private WebElement SyncingOptionTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wallet settings']")
	private WebElement WalletSettingsTitle;
	
	@AndroidFindBy(xpath="//android.view.View[@index='4']")
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Rescan'][2]")
	private WebElement RescanButton;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
	@AndroidFindBy(xpath="//android.widget.EditText")
	//@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement BlockheightTextBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Restore from BlockHeight']")
	private WebElement BlockheightPlaceHolder;
	
	@AndroidFindBy(accessibility  = "Calendar")
	private WebElement btnCalendar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='OK']")
	private WebElement btnOkInCalendar;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button")
	private WebElement BtnSwitchBlockheightToDate;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[2][@index='5']")
	private WebElement firstTransactionInHistory;
	
	@AndroidFindBy(xpath="//android.widget.TextView[2][@index='2']")
	private WebElement firsttransactionamount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Details']")
	private WebElement DetailsScreentitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[5][@index='5']")
	private WebElement transactionID;
	
	@AndroidFindBy(xpath ="com.android.chrome:id/url_bar")
	private WebElement explorerUrl;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.TextView[11]")
	private WebElement amountInDetailsScreen;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement copyIconInDetails;
	
	@AndroidFindBy(accessibility = "back arrow")
	private WebElement backarrowInDetails;
	
	@AndroidFindBy(accessibility ="Transaction Filter")
	private WebElement btnTransactionFilter;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[1]")
	private WebElement IncomingCheckBox;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[2]")
	private WebElement OutgoingCheckBox;
	
	@AndroidFindBy(accessibility = "Filter By Date")
	private WebElement btnFilterDate;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"From Date\"])[1]")
	private WebElement btnFromDate;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"To Date\"])[1]")
	private WebElement btnToDate;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Select Date Range']")
	private WebElement FilterByDatePopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	private WebElement btnCancelInFilter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Ok']")
	private WebElement btnOkInFilterCalendar;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='---'])[2]")
	private WebElement BeldexHiddenAmount;
	
	@AndroidFindBy(accessibility = "Change to previous month")
	private WebElement ChangeToPreviousMonth;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1']")
	private WebElement AvailableBalance;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='0.23 BRL']")
	private WebElement BalanceCurrencyConversion;
	
	public String get_Available_Balance () {
    	return AvailableBalance.getText();
    }
	
	public String get_Balance_Currency_Conversion () {
    	return BalanceCurrencyConversion.getText();
    }
	
	
	
	public String get_Bdx_value () {
    	return BeldexHiddenAmount.getText();
    }
	
	 public void click_First_Transaction () {
	    	firstTransactionInHistory.click();
	    }
	    
	    public String get_first_Transaction_amount () {
	    	return firsttransactionamount.getText();
	    }
	    
	    public String Details_screen_title () {
	    	return DetailsScreentitle.getText();
	    }
	    
	    public String get_Amount_In_details () {
	    	return amountInDetailsScreen.getText();
	    }
	    
	    public void click_CopyIcon_In_details () {
	    	copyIconInDetails.click();
	    }
	    
	    public void click_transactionID () {
	    	transactionID.click();
	    }
	    
	    public String get_Explorer_Url () {
	    	return explorerUrl.getText();
	    }
	    
	    public void click_BackArrow_In_details () {
	    	backarrowInDetails.click();
	    }
	
    public void Select_FromDate_previousMonth (int date) {
    	
    	btnFromDate.click();
    	ChangeToPreviousMonth.click();
    	driver.findElement(By.xpath("//android.widget.TextView["+date+"]/android.widget.Button[@index='1']")).click();
    	btnOkInFilterCalendar.click();
    }
	
	public void Select_ToDate_As_TodayDate () {
    	btnToDate.click();
    	btnOkInFilterCalendar.click();
    }
	
	public void click_Filter_By_date () {
    	btnFilterDate.click();
    }
	
	public String Filter_By_Date_Popup_Title() {
		return FilterByDatePopup.getText();
	}
	
	public void click_ok_In_FilterDate () {
    	btnOkInFilterCalendar.click();
    }
    
	 public void click_Cancel_In_FilterDate () {
	    	btnCancelInFilter.click();
	    }
	
	 public void click_Transaction_Filter () {
	    	btnTransactionFilter.click();
	    }
	 public void click_Incoming_CheckBox () {
	    	IncomingCheckBox.click();
	    }
	    
	    public void click_Outgoing_CheckBox () {
	    	OutgoingCheckBox.click();
	    }
	    
	
	 public WebElement Element_of_First_Transaction () {
	    	return firstTransactionInHistory;
	    }
	 
	public WebElement ElementofStatusSyncing () {
    	return SyncingStatus;
    }
	
	public WebElement ElementofStatusSynchronized () {
    	return SynchronizedStatus;
    }
	
	public String getSyncingStatus () {
    	return SyncingStatus.getText();
    }
	
	
	public String getBlockheightPlaceHolder () {
    	return BlockheightPlaceHolder.getText();
    }
	
	public String getValuesFromBlockheightTextBox () {
    	return BlockheightTextBox.getText();
    }
	
	public void Enter_BlockHeight (String value) {
		BlockheightTextBox.sendKeys(value);
	}
	
	public void ClearBlockHeightTextBox() {
		BlockheightTextBox.clear();	
	}
	
	public void paste_Value_In_BlockheightTextBox (String value) {
		Copy_And_Paste_Values(value, BlockheightTextBox);
	}
	
	public void ClickRescanButton() {
		RescanButton.click();	
	}
	
	public void ClickRescanOption() {
		rescanOption.click();	
	}
	
	public void ClickReconnectOption() {
		reconnectOption.click();	
	}
	public String getRescanTitle () {
    	return ReScanpageTitle.getText();
    }
	public String getWalletSettingsTitle () {
    	return WalletSettingsTitle.getText();
    }
	
	 public String Send_Page_Title () {
	    	return SendpageTitle.getText();
	    }
	 
	 public String getStatusReconnecting () {
	    	return StatusReconnecting.getText();
	    }
	 
	 public WebElement ElementofStatusReconnecting () {
	    	return StatusReconnecting;
	    }
	    
	    public String Receive_Page_Title () {
	    	return ReceivepageTitle.getText();
	    }
	    
	    public String SyncOption_Page_Title () {
	    	return SyncingOptionTitle.getText();
	    }
	    
	    public String Scan_Page_Title () {
	    	return ScanpageTitle.getText();
	    }
	
	public void ClickSettingsOption () {
		SettingsOption.click();	
	}
	
	public void ClickScanOption () {
		ScanOption.click();	
	}
	
	public void ClickSendOption () {
		SendOption.click();	
	}
	public void ClickReceiveOption () {
		ReceiveOption.click();	
	}
	
	public void ClickSyncingOption () {
		SyncingOption.click();	
	}
	
	public void ClickTransactionFilter () {
		TransactionFilter.click();	
	}
	
	
	public String getTransactionEmptyStatus() {
		return TransactionEmptyStatus.getText();
	}
	
	public WebElement getSynchronizedStatus() {
		return SynchronizedStatus;
	}
	
	
	public void ClickBackArrow () {
		BackArrow.click();	
	}
	
	public String getMyWalletScreenTitle() {
		return MyWalletScreenTitle.getText();
	}
	 public void rescan_From_date () {
	    	btnCalendar.click();
	    	btnOkInCalendar.click();
	    	ClickRescanButton();
	    }
	 public void click_To_Swicth_rescan_option () {
		 BtnSwitchBlockheightToDate.click();
	    }
}
