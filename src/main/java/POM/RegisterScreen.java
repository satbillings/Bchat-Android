package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;

public class RegisterScreen extends ActionsClass {
	AndroidDriver driver;
	public RegisterScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	//@AndroidFindBy(xpath="//android.widget.Button[@index='6']")
	private WebElement NextButton;

	//io.beldex.bchat:id/titleContentTextView
	
	@AndroidFindBy(id="io.beldex.bchat:id/titleContentTextView")
	private WebElement TextWithDisplayName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement TextPageTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/publicKeyTextView")
	private WebElement TextBChatID;
		
	@AndroidFindBy(id="io.beldex.bchat:id/beldexAddressTextView")
	private WebElement TextBeldexAddress;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_button")
	private WebElement BackButton;
	
	public void BackButtonClick() {
		BackButton.click();
	}
	
	public void clickNext() {
		super.click(NextButton);
	}
	//Hey hi, welcome to BChat!
	public String getdisplayName() {
	String displayName =TextWithDisplayName.getText().substring(4, 7);
	String name=displayName;
	return name;
	}
	
	public String pageTitle() {
		String PageTitle = TextPageTitle.getText();
		return PageTitle;
	}
	
	public String BChatID() {
	 String BChatId =TextBChatID.getText();
	 return BChatId;
	}

	public String BeldexAddress() {
		 String BeldexAddress =TextBeldexAddress.getText();
		 return BeldexAddress;
		}
	
	public void clickBChatId() {
		TextBChatID.click();
	}
	
	public void clickBeldexAddress() {
		TextBeldexAddress.click();
	}
	
	public boolean isBChatIdClickable() {
        return super.isClickable(TextBChatID);
    }
	public boolean isBeldexAddressClickable() {
        return isClickable(TextBeldexAddress);
    }
	
	public boolean isBChatIdLongClickable() {
        return super.isLongClickable(TextBChatID);
    }
	public boolean isBeldexAddressLongClickable() {
        return isLongClickable(TextBeldexAddress);
    }

}
