package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.OpeningPage;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Create_Account_Flow_RegisterScreen_TestCases extends baseclass {
	  DisplayNameScreen displaynamepage;
	  OpeningPage Openingpage;
	  RegisterScreen Registerpage;
	  CreatePasswordScreen createpasswordpage;
	  WebDriverWait wait;
	
	/*
	 Validate whether the displaying same value as entered in the display name screen text box.
	 And
	 PreSetup Method for this class
	 */
	  @Test(priority = 1)
	  public void To_Validate_whether_the_displaying_same_Name_entered_in_the_display_name_text_box() throws InterruptedException{
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Openingpage = new OpeningPage(driver);
	  Openingpage.clickCreateAccount();
	  Thread.sleep(3000);
   	  displaynamepage = new DisplayNameScreen(driver);
   	  displaynamepage.setDisplayName("Sat");
	  displaynamepage.clickContinue();
	  Registerpage =new RegisterScreen(driver);
	  //wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
	  Assert.assertEquals(Registerpage.getdisplayName(),"Sat");
	  Thread.sleep(10000); 
	  }
	/*
	 Validate Whether the user is able to navigate to the previous screen from register screen.
	 */
	@Test(priority = 2)
	public void To_Validate_Whether_the_user_is_able_to_navigate_to_previous_screen_from_register_screen () throws InterruptedException {
		Registerpage =new RegisterScreen(driver);
	    Assert.assertEquals(Registerpage.pageTitle(), "Register"); 
		driver.navigate().back();
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		displaynamepage.clickContinue();
	}
	/*
	 Validate whether the user is able to copy the ID and Address showing in the register screen.
	 */
	@Test(priority = 3)
	public void To_Validate_whether_the_user_is_able_to_copy_the_ID_and_Address_showing_in_the_register_screen () {
		Registerpage =new RegisterScreen(driver);
		Assert.assertFalse(Registerpage.isBChatIdLongClickable());
		Assert.assertFalse(Registerpage.isBeldexAddressLongClickable());
	}

	

}
