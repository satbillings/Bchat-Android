package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SocialGroupChatScreen extends ActionsClass {
	AndroidDriver driver;
	public SocialGroupChatScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(accessibility="More options")
	public WebElement MoreOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/readButton")
	public WebElement CommunityGuidelinesReadButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Community Guidelines']")
	public WebElement CommunityGuidelinesTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back")
	public WebElement BackArrow;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='3']")
	public WebElement AddMembersOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/contentView")
	public WebElement ContactList;
	
	@AndroidFindBy(id="io.beldex.bchat:id/addButton")
	public WebElement AddButton;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	public WebElement SocialGroupChatTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationSubtitleView")
	private WebElement MemberCount;
	
	public void ClickBackArrow () {
		BackArrow.click();
	}
	
	public String getSocialGroupChatTitle () {
		return SocialGroupChatTitle.getText();
	}
	
	public void Open_Community_Guidelines () {
		CommunityGuidelinesReadButton.click();
	}
	
	public String Community_Guidelines_Screen_Title () {
		return CommunityGuidelinesTitle.getText();
	}
	
	public void AddMembers () {
		MoreOption.click();
		AddMembersOption.click();
		ContactList.click();
		AddButton.click();	
	}
	public int get_Member_Count () {
		String Count = MemberCount.getText();
		int count = Integer.parseInt(Count.substring(0,2));
		return count;
		}
	

}
