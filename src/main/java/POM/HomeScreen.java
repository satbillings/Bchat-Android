package POM;

//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen extends ActionsClass {
	AndroidDriver driver;
	public HomeScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	//@AndroidFindBy(id="io.beldex.bchat:id/bchatHeaderImage")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BChat']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save your seed']")
	private WebElement PopupSaveSeed;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement buttonOk;
	
	@AndroidFindBy(id="io.beldex.bchat:id/profileButton")
	private WebElement btnMenuDrawer;
		
	@AndroidFindBy(xpath="android.widget.TextView[@text='Search']")
	//@AndroidFindBy(xpath="android.widget.TextView[@index='1']")
	private WebElement searchpagetitle;
	
	@AndroidFindBy(xpath="android.widget.TextView[@text='Search']")
	//@AndroidFindBy(xpath="android.widget.TextView[@index='1']")
	private WebElement titleSearch;
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchBarBackButton")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_close_icon")
	private WebElement btncancel;
	
	
	@AndroidFindBy(accessibility="clear")
	private WebElement btntextboxcancel;
	
	@AndroidFindBy(className="android.widget.Button")
	private WebElement groupsIcon;
	
	//@AndroidFindBy(id="io.beldex.bchat:id/gradientView")
	//private WebElement chathistory;
	 
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/emptyStateContainerText")
	public WebElement BlankChatScreen;
	
	//@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1632][1026,1800]']")
	@AndroidFindBy (xpath="//android.widget.TextView[@text='New Chat']")
	private WebElement btnNewChat;
	//android.view.View[1][480,1632][1026,1800]
	//[480,1632][1026,1800]
	//android.view.View
	
	//@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1800][1026,1968]']")
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Secret Group']")
	private WebElement btnSecretGroup;
	
	//@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1968][1026,2136]']")
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Social Group']")
	private WebElement btnSocialGroup;
	
	//@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[45,190][165,280]']")
	//private WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Note to Self']")
	private WebElement optionNoteToMyself;
	
	//@AndroidFindBy(xpath="//android.view.View[@index='1']")
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Search people and groups']")
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement textboxSearch;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]")
	//@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']")
	private WebElement FirstChatItem;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]")
	private WebElement SecondChatItem;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Block']")
	private WebElement optionBlock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Block Contact']")
	private WebElement BlockContactPopupTitle;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btnCancelInBlockContactPopup;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnYesInBlockContactPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationViewDisplayNameTextView")
	private WebElement DisplayNameOfChatItem;
	
	@AndroidFindBy(id="io.beldex.bchat:id/recyclerView")
	private WebElement oldMessages;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search people and groups']")
	//@AndroidFindBy(xpath="//androidx.compose.ui.platform.ComposeView[@resource-id='io.beldex.bchat:id/requests']")
	private WebElement textboxplacholder;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.ImageView[@index='3']")
	private WebElement messagerequestdropdown;
	
	@AndroidFindBy(xpath="(//android.view.View/android.view.View[2]/android.view.View[1])[1]")
	private WebElement firstRequest;
	
	@AndroidFindBy(id="io.beldex.bchat:id/content_view")
	private WebElement FirstContactorGroup;
	
	@AndroidFindBy(id="//android.widget.LinearLayout[@index='7']")
	private WebElement EighthContactorGroup;
	
	@AndroidFindBy(id="//android.widget.LinearLayout[@index='1']")
	private WebElement SecondContactorGroup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mute_icon")
	public WebElement MentionsMuteIcon;
	
	public void ClickEighthContactorGroup() {
		EighthContactorGroup.click();
	}
	
	public void ClickSecondContactorGroup() {
		SecondContactorGroup.click();
	}
	
	 public WebElement getMentionsMuteIcon() {
			return MentionsMuteIcon;
		}
	public void ClickFirstContactorGroup() {
		FirstContactorGroup.click();
	}
	
	public void ClickMessageRquestDropdown() {
		messagerequestdropdown.click();
	}
	
	public void ClickFirstMessageRquest() {
		firstRequest.click();
	}
	public  String popuptitle() {
		String popupTitle = PopupSaveSeed.getText();
		return popupTitle;
	}
	
	public void click_Option_Note_To_Myself () {
		optionNoteToMyself.click();
	}
	
	public void clickok() {
		buttonOk.click();
	}
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
	public String Search_PageTitle () {
		return searchpagetitle.getText();
	}
	public void clickMenuDrawer() {
		btnMenuDrawer.click();
	}
	
	public String searchTitle() {
		 String text= titleSearch.getText();
		 return text;
	}
	
	public void clickSearch() {
		textboxplacholder.click();
		
	}
	
	public void clickBackArrow() {
		btnBackArrow.click();
	}
	
	public void OpenNewChat(){
		groupsIcon.click();
		btnNewChat.click();
	}

public void OpenNewSecretGroup() {
	groupsIcon.click();
	btnSecretGroup.click();
	}

public void OpenJoinSocialGroup() {
	groupsIcon.click();
	btnSocialGroup.click();
}


public String SearchPlaceholder () {
	return textboxSearch.getText();
}

public void ClickCancel() {
	btncancel.click();
}

public void pastevalues(String text) {
	textboxplacholder.click();
	super.Copy_And_Paste_Values(text, textboxSearch);
}
//public void paste_values (String text) {
//	Copy_And_Paste_Values(text, textboxSearch);
//}

public void clearTextBox () {
	textboxSearch.clear();
}

public void enterValues (String text){
	textboxplacholder.click();
	textboxSearch.sendKeys(text);
}

public void click_cancel_icon_inside_textbox () {
	btntextboxcancel.click();
}

public boolean visiblity_of_placeholder () {
	boolean result =textboxSearch.isDisplayed();
	return result;
}
public boolean visblity_of_crusor() {
	boolean result =textboxSearch.equals(activeElement());
 return result;
}

public void Block_First_Contact () {
	longPress(DisplayNameOfChatItem);
	optionBlock.click();
	btnYesInBlockContactPopup.click();		
}

public void Block_Second_Contact () {
	longPress(SecondChatItem);
	optionBlock.click();
	btnYesInBlockContactPopup.click();		
}

public String get_DisplayName_Or_Id_Of_ChatItem() {
	 return DisplayNameOfChatItem.getText();	 
}

public void EnterTextInSearchBox () {
	textboxSearch.click();
	textboxSearch.sendKeys("grugrhgruhgrhguhgrgrhughughughguhuhuhhguguhtuhtu");
}
	

}
