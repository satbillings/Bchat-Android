package POM;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

//import com.google.common.collect.ImmutableMap;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OpeningPage extends ActionsClass {
	AndroidDriver driver;
	//String UP;
	public OpeningPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
		
		@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
		private WebElement CreateAccountButton;
		
		@AndroidFindBy(id="io.beldex.bchat:id/restoreButton")
		private WebElement RestoreAccountButton;
		
		@AndroidFindBy(id="io.beldex.bchat:id/TermsandCondtionsTxt")
		private WebElement TermsandConditionsLink;
		
		@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
		private WebElement AllowButton;

		@AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"BChat Messenger\"]")
		private WebElement AppIcon;
		
		@AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
		private WebElement ButtonDeny;
		
		@AndroidFindBy(id="com.android.launcher:id/all_apps_content")
		private WebElement DeviceHome;
		//com.android.launcher:id/all_apps_content"
		
		@AndroidFindBy(id="com.android.launcher:id/recent_container")
		private WebElement AppList;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Welcome to']")
		private WebElement PageTitle;
		
		public String Pagetitle() {
			String title = PageTitle.getText();
			return title;
		}
		
		
		/*
		 * @AndroidFindBy(xpath=
		 * "//android.widget.ImageView[@content-desc=\"Messaging\"]") private WebElement
		 * point;
		 */
		
		/*
		 * @AndroidFindBy(id="com.miui.home:id/drop_target_bar") private WebElement
		 * point;
		 */
		/*
		 * public void swipeup(int left,int top, int width,int height,String direction)
		 * { swipeup(left, top, width, height, direction); }
		 */
		

		public void clickCreateAccount() {
			super.click(CreateAccountButton);
		}

		public void clickSignIn() {
			super.click(RestoreAccountButton);
		}
		
		public void clickTermsAndConditions() {
			super.click(TermsandConditionsLink);
		}
		
		public void clickAllow() {
			super.click(AllowButton);
		}
		
		public void clickDeny() {
			super.click(ButtonDeny);
		}
		
		public WebElement WebElementCreateAccount() {
			
			WebElement element = CreateAccountButton;
			return element;
		}

		public WebElement WebElementDeviceHome() {
			
			WebElement element = DeviceHome;
			return element;
		
		}
		public WebElement WebElementAppList() {
			
			WebElement element = AppList;
			return element;
		
		}

	public void openApp() {
			AppIcon.click();
		}
	
	public boolean isCreateAccountClickable() {
		return isClickable(CreateAccountButton);
		
	}

	public boolean isSignInClickable() {
		return isClickable(RestoreAccountButton);
		
	}

	public boolean isTermsAndConditionsClickable() {
		return isClickable(TermsandConditionsLink);
		
	}
	public void homekey() {
		super.Android_Key_Enter();
	}
}
