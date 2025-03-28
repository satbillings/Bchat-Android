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
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement EnterNameTextBox;
	
	@AndroidFindBy(accessibility="Back")
	public WebElement BackArrowInSearchMembersScreen;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]")
	private WebElement Member1;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]")
	private WebElement Member2;
	
	public WebElement ShowMember1() {
		return Member1;
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
	 
	 
	 public String getMemberList() {
			return MemberList.getText();
		}
	 
	 public String getSearchMembersScreenTitle() {
			return SearchMembersScreenTitle.getText();
		}
	 
	 
	 public String getGroupInfoScreenTitle() {
			return GroupInfoScreenTitle.getText();
		}
	

}
