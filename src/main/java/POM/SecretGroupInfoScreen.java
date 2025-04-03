package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SecretGroupInfoScreen extends ActionsClass {
	AndroidDriver driver;
	public SecretGroupInfoScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='2 members']")
	private WebElement MemberList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Group Info']")
	private WebElement GroupInfoScreenTitle;
	
	@AndroidFindBy(accessibility="search members")
	public WebElement SearchIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search Members']")
	private WebElement SearchMembersScreenTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter name']")
	private WebElement EnterNamePlaceholder;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='No records found!']")
	private WebElement NoRecordsFoundText;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement EnterNameTextBox;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='']")
	private WebElement EmptyValueInEnterNameTextBox;
	
	@AndroidFindBy(accessibility="Back")
	public WebElement BackArrowInSearchMembersScreen;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]")
	private WebElement Member1;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]")
	private WebElement Member2;
	
	@AndroidFindBy(accessibility="admin crown")
	public WebElement CrownSymbol;
	
	public String getEmptyValueInEnterNameTextBox() {
		return EmptyValueInEnterNameTextBox.getText();
	}
	
	public WebElement ShowMember1() {
		return Member1;
	}
	
	public WebElement ShowCrownSymbol() {
		return CrownSymbol;
	}
	
	public WebElement ShowNoRecordsFound() {
		return NoRecordsFoundText;
	}
	
	public WebElement ShowMember2() {
		return Member2;
	}
	
	public void ClickEnterNameTextBox () {
		EnterNameTextBox.click();	
	}
	
	public void ClickBackArrowInSearchMembersScreen () {
		BackArrowInSearchMembersScreen.click();	
	}
	
	public void ClickSearchIcon () {
		SearchIcon.click();	
	}
	
	 public String getEnterNamePlaceholder() {
			return EnterNamePlaceholder.getText();
		}
	 
	 
	 public String getNoRecordsFoundText() {
			return NoRecordsFoundText.getText();
		}
	 
	 public String getMemberList() {
			return MemberList.getText();
		}
	 
	 public String getSearchMembersScreenTitle() {
			return SearchMembersScreenTitle.getText();
		}
	 
	 
	 public String getGroupInfoScreenTitle() {
			return GroupInfoScreenTitle.getText();
		}
	 
	 public void Set_Values_In_EnterName_textbox (String value) {
		 EnterNameTextBox.sendKeys(value);
		}
	 
	 public void Paste_values_In_EnterName_TextBox (String value) {
			Copy_And_Paste_Values(value, EnterNameTextBox);
		}
	 
	 public void Clear_EnterName_textbox () {
		 EnterNameTextBox.clear();
		}

}
