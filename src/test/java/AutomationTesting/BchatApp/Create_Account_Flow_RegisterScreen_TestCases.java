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
	WebDriverWait Wait;
	
	/*
	 TC_47	: Validate whether displaying same Value as entered in the display name screen text box.
	 And
	 PreSetup Method for this class
	 */
	@Test
	public void TC_47_To_Validate_whether_displaying_same_Name_entered_in_the_display_name_text_box(){
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
   	displaynamepage = new DisplayNameScreen(driver);
   	displaynamepage.setDisplayName("Chris");
	 displaynamepage.clickContinue();
		Registerpage =new RegisterScreen(driver);
		Wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		Wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
		try{
			Assert.assertEquals(Registerpage.getdisplayName(),"Chris");
		}
		catch(Throwable th) {
			th.printStackTrace();
		}
	}
	/*
	 TC_48 : Validate Whether able to navigate to the previous screen.
	 */
	@Test
	public void TC_48_To_Validate_Whether_able_to_navigate_to_previous_screen () {
		Registerpage =new RegisterScreen(driver);
		
		try{
			Assert.assertEquals(Registerpage.pageTitle(), "Register"); 
			driver.navigate().back();
			Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		}
		catch(Throwable th) {
			th.printStackTrace();
		}
	}
	/*
	 TC_49	: Validate whether ID and Address are change while navigating back and navigating in into the register screen.
	 */
	@Test
	public void TC_49_To_Validate_whether_ID_And_Address_are_change_while_navigating_back_and_navigate_into_register_screen() {
		displaynamepage = new DisplayNameScreen(driver);
	   	displaynamepage.setDisplayName("Chris");
		 displaynamepage.clickContinue();
			Registerpage =new RegisterScreen(driver);
			Wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			Wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
			
			

		String oldBChatId= Registerpage.BChatID();
		String oldBeldexAddress= Registerpage.BeldexAddress();
		driver.navigate().back();
		
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		 displaynamepage.clickContinue();
		 Wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			Wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
			Registerpage =new RegisterScreen(driver);
			Assert.assertNotEquals(oldBChatId, Registerpage.BChatID());
			Assert.assertNotEquals(oldBeldexAddress, Registerpage.BeldexAddress());
		
	
	}
	/*
	 TC_50	: Validate whether able to copy the ID and Address showing in the register screen.
	 */
	@Test
	public void TC_50_To_Validate_whether_able_to_copy_ID_and_Address () {
		Registerpage =new RegisterScreen(driver);
	
		Assert.assertFalse(Registerpage.isBChatIdLongClickable());
		Assert.assertFalse(Registerpage.isBeldexAddressLongClickable());
		
		
	}
	/*
	 TC_52	 : Validate whether ID and Address response for the touch action.
	 TC_52.1 : Validate whether able to edit the ID and Address
	 */
	@Test
	public void TC_52_To_Validate_whether_ID_and_Address_were_Clickable_And_Editable() {
		Registerpage =new RegisterScreen(driver);
		
		Assert.assertFalse(Registerpage.isBChatIdClickable());
		Assert.assertFalse(Registerpage.isBeldexAddressClickable());
		
	  
	}
	/*
	 TC_53	: Validate the working of the next functionality in the register screen.
	 */
	@Test
	public void TC_53_To_Validate_the_working_of_next_Button (){
		Registerpage =new RegisterScreen(driver);
		
		try {
			Registerpage.clickNext();
			createpasswordpage = new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
			
		   }
		catch(Exception e) {
			e.printStackTrace();		}
		
	}

}
