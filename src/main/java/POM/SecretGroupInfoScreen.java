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
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='4 members']")
	private WebElement MemberList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3 members']")
	private WebElement MemberList2;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='1 members']")
	private WebElement MemberList3;
	
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
	
	//@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
	private WebElement AllMediaOption;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]")
	private WebElement DisappearingMessagesOption;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
	private WebElement EditGroupOption;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]")
	private WebElement NotifyForMentionOnlyOption;
	
	//@AndroidFindBy(xpath = "//android.view.View[@index=''4]")
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]")
	private WebElement LeaveGroupOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/cntGroupNameDisplay")
	public WebElement GroupNameEditOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/edtGroupName")
	public WebElement GroupNameEditTextBox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/btnSaveGroupNameEdit")
	public WebElement TickIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/applyChangesBtn")
	public WebElement ApplyChangesButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Group']")
	private WebElement EditGroupScreenTitle;
	
	@AndroidFindBy(accessibility="Apply")
	public WebElement ApplyOption;
	
	//@AndroidFindBy(id="io.beldex.bchat:id/contentView")
	@AndroidFindBy(id="io.beldex.bchat:id/actionIndicatorImageView")
	public WebElement ContactList;
	
	@AndroidFindBy(id="io.beldex.bchat:id/addButton")
	public WebElement AddButton;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']")
	//@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='io.beldex.bchat:id/actionIndicatorImageView']")
	//@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/nameTextView\" and @text=\"check\"]")
	public WebElement RemovableContact;
		
	@AndroidFindBy(id="io.beldex.bchat:id/removeFromGroup")
	public WebElement RemoveUserFromGroupOption;
	
	@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	private WebElement AllNotificationOption;
	
	@AndroidFindBy(xpath = "//android.view.View[@index='1']")
	private WebElement MentionNotificationOption;
	
	@AndroidFindBy(xpath = "//android.view.View[@index=''3]")
	private WebElement OkbuttonInDisappearingMessagesPoup;
	
	//@AndroidFindBy(xpath = "//android.view.View[@index=''3]")
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]")
	private WebElement LeaveButtonInLeaveGroupPoup;
	
	public void ClickLeaveGroupOption() {
		LeaveGroupOption.click();	
	}
	
	public void ClickLeaveButtonInLeaveGroupPoup() {
		LeaveButtonInLeaveGroupPoup.click();	
	}
	
	public void ClickOkbuttonInDisappearingMessagesPoup() {
		OkbuttonInDisappearingMessagesPoup.click();	
	}
	
	public void ClickMentionNotificationOption() {
		MentionNotificationOption.click();	
	}
	
	public void ClickAllNotificationOption() {
		AllNotificationOption.click();	
	}
	
	public void ClickDisappearingMessagesOption() {
		DisappearingMessagesOption.click();	
	}
	
	public String getEditGroupScreenTitle() {
		return EditGroupScreenTitle.getText();
	}
	
	public void ClickNotifyForMentionOnlyOption() {
		NotifyForMentionOnlyOption.click();	
	}
	
	public void ClickEditGroupOption() {
		EditGroupOption.click();	
	}
	
	public void ClickAllMediaOption() {
		AllMediaOption.click();	
	}
	
	public void EditGroup(String value) {
		GroupNameEditOption.click();
		GroupNameEditTextBox.sendKeys(value);
		TickIcon.click();
		ApplyChangesButton.click();
	}
	
	public void AddMemberToGroup() {
		ApplyOption.click();
		ContactList.click();
		AddButton.click();
		ApplyChangesButton.click();	
	}
	
	public void RemoveMemberFromGroup() {
		RemovableContact.click();
		RemoveUserFromGroupOption.click();
		ApplyChangesButton.click();	
	}
	
	public void ClickRemovableContact() {
		RemovableContact.click();	
	} 
	
	public void ClickRemoveUserFromGroupOption() {
		RemoveUserFromGroupOption.click();	
	} 
	public void ClickApplyOption() {
		ApplyOption.click();	
	} 
	
	public void ClickContactList() {
		ContactList.click();	
	} 
	
	public void ClickAddButton() {
		AddButton.click();	
	} 
	
	public void ClickApplyChangesButton() {
		ApplyChangesButton.click();	
	}
	
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
	 
	 public String getMemberList2() {
			return MemberList2.getText();
		}
	 public String getMemberList3() {
			return MemberList3.getText();
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
