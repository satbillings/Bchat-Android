package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WalletSettingsScreen extends ActionsClass {
	AndroidDriver driver;
	public WalletSettingsScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wallet settings']")
	private WebElement WalletSettingsScreenTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nodes']")
	private WebElement NodesScreentitle;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Node']")
	private WebElement AddNodeScreentitle;
		
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]")
	private WebElement optionCurrentNode;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='publicnode1.rpcnode.stream']")
	private WebElement publicNode1;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='publicnode2.rpcnode.stream']")
	private WebElement publicNode2;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='publicnode3.rpcnode.stream']")
	private WebElement publicNode3;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='publicnode4.rpcnode.stream']")
	private WebElement publicNode4;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='publicnode5.rpcnode.stream']")
	private WebElement publicNode5;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btnCancelInPopup;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnYesInPopup;
	
	@AndroidFindBy(accessibility = "Refresh")
	private WebElement btnRefresh;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button")
	private WebElement btnAddNode;

	@AndroidFindBy(xpath="//android.view.View/android.widget.EditText[1]")
	private WebElement textBoxNodeAddress;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.EditText[2]")
	private WebElement textBoxNodePort;

	@AndroidFindBy(xpath="//android.view.View/android.widget.EditText[3]")
	private WebElement textBoxNodeName;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.EditText[4]")
	private WebElement textBoxUsername;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.EditText[5]")
	private WebElement textBoxPassword;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Test']")
	private WebElement btnTest;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnCancelInAddNode;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button")
	private WebElement btnAddInAddNode;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[2]")
	private WebElement errorMsg;
    
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[2]")
	private WebElement SuccessMsg;
	
	//@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[2]")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Display Balance As']")
	private WebElement optionDisplayBalanceAs;
	
	//@AndroidFindBy(xpath = "//android.view.View[2]/android.widget.TextView[2]")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Decimals']")
	private WebElement optionDecimals;
	
	//@AndroidFindBy(xpath = "//android.view.View[3]/android.widget.TextView[2]")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Currency']")
	private WebElement optionCurrency;
	
	//@AndroidFindBy(xpath = "//android.view.View[4]/android.widget.TextView[2]")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Fee Priority']")
	private WebElement optionFeePriority;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Address Book']")
	private WebElement optionAddressBook;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change Pin']")
	private WebElement optionChangePin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='No Addresses!']")
	private WebElement emptyAddressBook;
	
	@AndroidFindBy(className = "android.widget.ImageView")
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	private WebElement cancelIconInPopup;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement SearchTextBox;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement ElementInCurrencypopup;
	
	//android.view.View[1]/android.widget.TextView
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.ImageView[1]")
	private WebElement CopyOrSendIconofFirstAddress;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='No Contacts']")
	private WebElement ContentNoContacts;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beldex Available Balance']")
	private WebElement BeldexAvailableBalance;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beldex Hidden']")
	private WebElement BeldexHidden;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='0 - Zero (0)']")
	private WebElement ZeroDigitDecimal;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement closeIcon;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[@index='0']")
	private WebElement firstContactNameInAddressBook;
	
	//@AndroidFindBy(uiAutomator = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	@AndroidFindBy(xpath="//android.view.View[@index='0']")
	private WebElement SearchedCurrency;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BRL']")
	private WebElement BRLCurrency;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='INR']")
	private WebElement INRCurrency;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Flash']")
	private WebElement FlashPriority;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Slow']")
	private WebElement SlowPriority;
	
	 public void ClickBRLCurrency () {
		 optionCurrency.click();
		 BRLCurrency.click();
	 }
	 public void ClickSlowPriority () {
		 optionFeePriority.click();
		 SlowPriority.click();
	 }
	  
	 public String getBRLCurrency () {
	    	return BRLCurrency.getText();
	    }
	 
	 public String getFlashPriority() {
	    	return FlashPriority.getText();
	    }
	 public String getSlowPriority() {
	    	return SlowPriority.getText();
	    }
	
	 public String getINRCurrency () {
	    	return INRCurrency.getText();
	    }
	 public void ClickZeroDigitDecimal () {
		    optionDecimals.click();
		    ZeroDigitDecimal.click();
	    }
	 
	 public String get_DecimalAs_Zero () {
	    	return ZeroDigitDecimal.getText();
	    }
	 public String get_DisplayBalanceAs_Beldex_Available_Balance () {
	    	return BeldexAvailableBalance.getText();
	    }
	 
	 public String get_DisplayBalanceAs_Beldex_Hidden () {
	    	return BeldexHidden.getText();
	    }
	
	 public void ClickBeldexAvailableBalance () {
		    optionDisplayBalanceAs.click();
	    	BeldexAvailableBalance.click();
	    }
	 
	 public void ClickBeldexHidden () {
		    optionDisplayBalanceAs.click();
		    BeldexHidden.click();
	    }
	 public void ClickCancelButtonInRefreshNodePopup () {
	    	btnRefresh.click();
	    	cancelIconInPopup.click();
	    }
	 public void ClickCancelButtonInSwitchNodePopup () {
		    publicNode2.click();
	    	cancelIconInPopup.click();
	    }
	 public void ClickCancelButtonInAddNodePopup () {
	    	btnAddNode.click();
	    	cancelIconInPopup.click();
	    }
	
	public String walletSettings_screen_Title () {
    	return WalletSettingsScreenTitle.getText();
    }
   
    public void click_Current_Node () {
    	optionCurrentNode.click();
    }
    
    public String get_Current_Node () {
    	return optionCurrentNode.getText();
    }
    
    public String Nodes_Screen_title () {
    	return NodesScreentitle.getText();
    }
    
    public void click_Public_Node (int nodevalue) {
    	if(nodevalue == 1) {
    		publicNode1.click();
    	}
    	if(nodevalue == 2) {
    		publicNode2.click();
    	}
    	if(nodevalue == 3) {
    		publicNode3.click();
    	}
    	if(nodevalue == 4) {
    		publicNode4.click();
    	}
    	if(nodevalue == 5) {
    		publicNode5.click();
    	}  	
    }

    public String AddNode_Screen_Title () {
    	return AddNodeScreentitle.getText();
    }

    public void click_Cancel_InPopup () {
    	btnCancelInPopup.click();
    }

    public void click_Yes_InPopup () {
    	btnYesInPopup.click();
    }
    
    public void click_Cancel_InAddNode () {
		btnCancelInAddNode.click();
	}
    
    public void click_Add_InAddNode () {
    	btnAddInAddNode.click();
    }
    
    public void click_publicNode1 ()  {
    	publicNode1.click();
    	btnYesInPopup.click();
    }

    public void click_publicNode2 ()  {
    	publicNode2.click();
    	btnYesInPopup.click();
    }
    
    public void click_publicNode3 ()  {
    	publicNode3.click();
    	btnYesInPopup.click();
    }
    
    public void click_publicNode4 ()  {
    	publicNode4.click();
    	btnYesInPopup.click();
    }
    
    public void click_publicNode5 ()  {
    	publicNode5.click();
    	btnYesInPopup.click();
    }
    
    public void click_Back_Arrow () {
    	btnBackArrow.click();
    }
    
    public void click_Refresh_Node () {
    	btnRefresh.click();
    	btnYesInPopup.click();
    }
    
    public void click_AddNode () {
    	btnAddNode.click();
    }
    
    public void click_Test () {
    	btnTest.click();
    }
    
    public String error_Msg () {
    	return errorMsg.getText();
    }
    
    public String Success_Msg () {
    	return SuccessMsg.getText();
    }
    
    public void Enter_NodeAddress (String value){
      textBoxNodeAddress.sendKeys(value);	
    }
    
    public void Enter_NodePort (String value) {
		textBoxNodePort.sendKeys(value);
	}
    
    public void Enter_NodeName (String value){
        textBoxNodeName.sendKeys(value);	
      }
    
    public void Enter_Username (String value) {
    	textBoxUsername.sendKeys(value);
    }
    
    public void Enter_Password (String value) {
    	textBoxPassword.sendKeys(value);
    }
    
    public void clear_TextBoxes () {
    	textBoxNodeAddress.clear();
    	textBoxNodeName.clear();
    	textBoxNodePort.clear();
    	textBoxPassword.clear();
    	textBoxUsername.clear();
    }
    
    public void paste_values_In_All_TextBox_Fields () {
    	Copy_And_Paste_Values("publicnode1.rpcnode.stream", textBoxNodeAddress);
    	Copy_And_Paste_Values("29095", textBoxNodePort);
    	Copy_And_Paste_Values("publicnode1", textBoxNodeName);
    	Copy_And_Paste_Values("chris", textBoxUsername);
    	Copy_And_Paste_Values("1111", textBoxPassword);
    }
    
    public List<String> allTextBoxes () {
		
    	List<String> list = new ArrayList<String>();
    	list.add(textBoxNodeAddress.getText());
    	list.add(textBoxNodePort.getText());
    	list.add(textBoxNodeName.getText());
    	list.add(textBoxUsername.getText());
    	list.add(textBoxPassword.getText());
    	return  list;
    	
    }
    
    public void paste_Values_In_NodePort () {
    	Copy_And_Paste_Values("Abcde", textBoxNodePort);
    }
    
    public void click_DisplayBalanceAs () {
    	optionDisplayBalanceAs.click();
    }
    
    public void click_Decimals () {
    	optionDecimals.click();
    }
    
    public void click_Currency () {
    	optionCurrency.click();
    }

    public void click_Fee_priority () {
    	optionFeePriority.click();
    }
    
    
    public void click_AddressBook () {
    	optionAddressBook.click();
    }
    
    public String get_Decimals_Value () {
    	return optionDecimals.getText();
    }
    
    public String get_currency_Value () {
    	return optionCurrency.getText();
    }
    
    public String get_FeePriority_value () {
    	return optionFeePriority.getText();
    }
    
    
    public void Select_All_Options_In_DisplayBalanceAs () {
    	for (int i=1;i<=3;i++) {
    		optionDisplayBalanceAs.click();
    		driver.findElement(By.xpath("//android.view.View/android.view.View["+i+"]")).click();		
    	}
    }
    
    public void Select_All_options_InDecimals () {
    	for(int i=1;i<=4;i++) {
    		optionDecimals.click();
    		try{
    			driver.findElement(By.xpath("//android.view.View/android.view.View["+i+"]")).click();	
    		}
    		catch (StaleElementReferenceException e) {
    			driver.findElement(By.xpath("//android.view.View/android.view.View["+i+"]")).click();
			}
    	}
    }
    
    public void Select_All_options_Currency () {
    	for(int i=1;i<=5;i++) {
    		optionCurrency.click();
    		driver.findElement(By.xpath("//android.view.View/android.view.View["+i+"]")).click();	
    	}
    }

    public void Select_All_options_FeePriority () {
    	for(int i=1;i<=2;i++) {
    		optionFeePriority.click();
    		driver.findElement(By.xpath("//android.view.View/android.view.View["+i+"]")).click();	
    	}
    }
    
    public void click_CancelIcon_In_Popup () {
    	cancelIconInPopup.click();
    }

    public void Enter_values_In_Search_TextBox (String value) {
    	SearchTextBox.sendKeys(value);
    }

    public String Value_In_CurrencyPopup () {
    	return ElementInCurrencypopup.getText();
    }

    public String emptyAddressBook_screen () {
    	return emptyAddressBook.getText();
    }
    
    public String AddressBook_screen_title () {
    	return optionAddressBook.getText();
    }
    
    public void click_change_Pin () {
    	optionChangePin.click();
    }
    
    public void click_CopyOrSend_Of_FirstAddress () {
    	CopyOrSendIconofFirstAddress.click();
    }
    
    public String Element_No_Contacts () {
    	return ContentNoContacts.getText();
    }
    
    public void clear_search_textbox () {
    	SearchTextBox.clear();
    }
    
    public String get_values_In_searchTextBox () {
    	return SearchTextBox.getText();
    }
    
    public void paste_Values_In_Searchtextbox (String value) {
    	Copy_And_Paste_Values(value, SearchTextBox);
    }
    
    public void click_closeIcon_In_searchtextbox () {
    	closeIcon.click();
    }
    
    public String get_Name_Of_FirstContact_In_AddressBook () {
    	return firstContactNameInAddressBook.getText();
    }
    
    public WebElement Element_of_Copy_Icon () {
    	return CopyOrSendIconofFirstAddress;
    }
    
    public void click_Searched_Currency () {
    	SearchedCurrency.click();
    }

}
