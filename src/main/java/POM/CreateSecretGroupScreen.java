package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CreateSecretGroupScreen extends ActionsClass {
	AndroidDriver driver;
	public CreateSecretGroupScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Secret Group']")
	private WebElement PageTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='3']")
	private WebElement GroupNameTextBox;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='4']")
	private WebElement SearchTextBox;
	
	//@AndroidFindBy(xpath="//android.view.View[@index='0']")
	//@AndroidFindBy(xpath="//android.widget.CheckBox[@index='1']")
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='test'])[1]")
	private WebElement FirstContactList;
	
	//@AndroidFindBy(xpath="//android.widget.CheckBox[@index='1']")
	//@AndroidFindBy(xpath="//android.view.View[@index='1']")
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='test'])[2]")
	private WebElement SecondContactList;
	
	@AndroidFindBy(xpath="//android.view.View[@index='6']")
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Create']")
	private WebElement CreateButton;
	
	@AndroidFindBy(accessibility="Back")
	private WebElement BackArrow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter Group Name']")
	private WebElement GroupNameTextBoxPlaceHolder;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search Contact']")
	private WebElement SearchTextBoxPlaceHolder;
	
	public String get_Values_From_GroupNameTextBox () {
		 return GroupNameTextBox.getText();
	}
	
	public String get_Values_From_SearchTextBox () {
		 return SearchTextBox.getText();
	}
	
	public void PasteValues_In_GroupNameTextBox (String value) {
		Copy_And_Paste_Values(value, GroupNameTextBox);
	}
	
	public void PasteValues_In_SearchTextBox (String value) {
		Copy_And_Paste_Values(value, SearchTextBox);
	}
	
	public void ClickCreateButton() {
		CreateButton.click();
	}
	
	public void MultiSelectContact() {
		FirstContactList.click();
		SecondContactList.click();
	}
	
	public String getGroupNameTextBoxPlaceHolder() {
		return GroupNameTextBoxPlaceHolder.getText();
	}
	
	public String getSearchTextBoxPlaceHolder() {
		return SearchTextBoxPlaceHolder.getText();
	}
	
	
	public void Set_Values_In_GroupName_Textbox (String value) {
		GroupNameTextBox.sendKeys(value);
		}
	public void Set_Values_In_Search_Textbox (String value) {
		SearchTextBox.sendKeys(value);
		}
	
	public void ClearGroupNameTextBox() {
		GroupNameTextBox.clear();
	}
	
	public void ClickGroupNameTextBox() {
		GroupNameTextBox.click();
	}
	
	public void ClearSearchTextBox() {
		SearchTextBox.clear();
	}
	public void ClickSearchTextBox() {
		SearchTextBox.click();
	}
	
	@SuppressWarnings("deprecation")
	public String CheckContactSelectorNot() {
		return FirstContactList.getAttribute("checked");
	}
	
	public WebElement DisplaySelectedFirstContact() {
		return FirstContactList;
	}
	public WebElement DisplaySelectedSecondContact() {
		return SecondContactList;
	}
	
	public void ClickBackArrow() {
		BackArrow.click();
	}
	
	
	public void SelectContact() {
		FirstContactList.click();
	}
	
	
	public String getPageTitle() {
		String title = PageTitle.getText();
		return title;
	}
	
	
	
	

}
