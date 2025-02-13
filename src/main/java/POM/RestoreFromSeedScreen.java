package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;

public class RestoreFromSeedScreen extends ActionsClass {
	AndroidDriver driver;
	public RestoreFromSeedScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	//@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='io.beldex.bchat:id/restoreSeedWalletName']")
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletName")
	private WebElement txtboxDisplayName;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='io.beldex.bchat:id/restoreSeedWalletRestoreHeight']")
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletRestoreHeight")
	private WebElement txtboxBlockheight;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletRestoreDate")
	private WebElement txtboxRestreFromDate;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedRestoreButton")
	private WebElement btnRestore;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreFromDateButton")
	private WebElement btnRestoreFromDate;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreFromHeightButton")
	private WebElement btnRestoreFromBlockheight;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletRestoreDate")
	private WebElement btnCalendar;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement btnOk;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button2']")
	private WebElement btnCancel;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement textPageTitle;
	
	@AndroidFindBy(xpath = "//android.view.View[@index='12']")
	private WebElement todayDate;
	
	

	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	public String NamePlaceholder() {
		
		return txtboxDisplayName.getText();
	}
	
    public String BlockheightPlaceholder() {
		
		return txtboxBlockheight.getText();
	}
	
   public String datePlaceholder() {
		
		return txtboxRestreFromDate.getText();
	}
 
	public WebElement BlockheightTextBox () {
        return txtboxBlockheight;
	}
	
	public void clickOk() {
		btnOk.click();
	}
	
    public void clickCancel() {
		btnCancel.click();
	}

	public void clicktextboxDisplayname() {
		txtboxDisplayName.click();
	}
	
	public void clicktextboxBLockheight() {
		txtboxBlockheight.click();
	}
	
	public void clicktextboxDate() {
	txtboxRestreFromDate.click();
	}
	
	public void clickBtnRestore () {
		btnRestore.click();
	}
	
	public void clickBtnDate () {
		btnRestoreFromDate.click();
	}
	
	public void clickBtnBlockheight () {
		btnRestoreFromBlockheight.click();
	}

    public void setDisplayName(String Name) {
    	txtboxDisplayName.click();
	txtboxDisplayName.sendKeys(Name);	
	}
    
    public void setBlockheight(String value) {
    	txtboxBlockheight.click();
    	txtboxBlockheight.sendKeys(value);	
    	}
    
    public void clearValues () {
    
    	txtboxDisplayName.clear();
    	txtboxBlockheight.clear();
    }
 
    public WebElement CheckFutureDate() {
    	
  	int date = Integer.parseInt(todayDate.getText());
  	int futuredate = date+1;
  	String nextdate =String.valueOf(futuredate);
  	WebElement futureDateWebelement = driver.findElement(By.xpath("//android.view.View[@text='"+nextdate+"']"));
	return futureDateWebelement;
   
    }
    
    public void selectTodayDate() {
    	btnRestoreFromDate.click();
    	txtboxRestreFromDate.click();
         //todayDate.click();
    	btnOk.click();
    }
    
    public void setRestoreDate(int date) {
    	txtboxRestreFromDate.click();
    	WebElement futureDateWebelement = driver.findElement(By.xpath("//android.view.View[@text='"+date+"']"));
    	futureDateWebelement.click();
    	
    }
    
    public void paste_Value_In_Blockheight(String value) {
    	txtboxBlockheight.click();
    	Copy_And_Paste_Values(value, txtboxBlockheight);
    }
    
    public void paste_Value_In_DisplayName(String value) {
    	txtboxDisplayName.click();
    	//txtboxDisplayName.click();
    	Copy_And_Paste_Values(value, txtboxDisplayName);
    }
}
