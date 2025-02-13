package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class JoinSocialGroupScreen extends ActionsClass{
	AndroidDriver driver;
	public JoinSocialGroupScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Social Group']")
	private WebElement JoinSocialGroupScreenTitle;
	
	//@AndroidFindBy(xpath="//android.view.View[@index='0']")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BChat']")
	private WebElement BchatGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beldex']")
	//@AndroidFindBy(xpath="//android.view.View[@index='1']")
	private WebElement BeldexGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Crypto News']")
	//@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement CryptoNewsGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Masternode']")
	//@AndroidFindBy(xpath="//android.view.View[@index='4']")
	private WebElement MasternodeGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BELNET']")
	//@AndroidFindBy(xpath="//android.view.View[@index='2']")
	private WebElement BelnetGroup;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
	private WebElement SocialGroupURLTextBox;
	
	@AndroidFindBy(xpath="//android.view.View[@index='1']")
	private WebElement NextButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='0']")
	private WebElement QRCodeOption;
	
	@AndroidFindBy(accessibility="Back")
	private WebElement BackArrow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter a social group URL']")
	private WebElement SocialGroupURLTextBoxPlaceHolder;
	
	
	
	public void Paste_Values_In_URL_TextBox (String value) {
		Copy_And_Paste_Values(value, SocialGroupURLTextBox);
	}
	
	public String getSocialGroupURLTextBoxPlaceHolder() {
		return SocialGroupURLTextBoxPlaceHolder.getText();
	}
	public void Set_Values_In_SocialGroupURL_Textbox (String value) {
		SocialGroupURLTextBox.sendKeys(value);
		}
	
	public void ClearSocialGroupURLTextBox() {
		SocialGroupURLTextBox.clear();
	}
	
	public void ClickNextButton() {
		NextButton.click();
	}
	public void ClickURLTextBox() {
		SocialGroupURLTextBox.click();
	}
	
	public void ClickBackArrow() {
		BackArrow.click();
	}
	
	public String get_Values_From_URLTextBox () {
		 return SocialGroupURLTextBox.getText();
	}
	
    public List<WebElement> get_Element_of_Groups (){
		
		List<WebElement> list = new ArrayList<WebElement>();
		list.add(BchatGroup);
		list.add(BeldexGroup);
		list.add(BelnetGroup);
		list.add(MasternodeGroup);
		list.add(CryptoNewsGroup);
		
		return list;	
	}
	
	public String getJoinSocialGroupScreenTitle() {
		String title = JoinSocialGroupScreenTitle.getText();
		return title;
	}
	public void JoinBchatGroup(){
		BchatGroup.click();
	}
	public void JoinMasternodeGroup(){
		MasternodeGroup.click();
	}

}
