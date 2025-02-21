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
		 * PreSetup method to this class
		 */
		@Test(priority = 0)
		public void PreSetup() throws InterruptedException {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Openingpage = new OpeningPage(driver);
			Openingpage.clickCreateAccount();
			Thread.sleep(3000);
			 displaynamepage = new DisplayNameScreen(driver);
		   	  displaynamepage.setDisplayName("Sat");
			  displaynamepage.clickContinue();
		}
	
	/*
	 Validate whether the displaying same value as entered in the display name screen text box.
	 And
	 PreSetup Method for this class
	 */
	 /* @Test(priority = 1)
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
	/*  @Test(priority = 2)
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
	/*  @Test(priority = 3)
	    public void To_Validate_whether_the_user_is_able_to_copy_the_ID_and_Address_showing_in_the_register_screen () {
		Registerpage =new RegisterScreen(driver);
		Assert.assertFalse(Registerpage.isBChatIdLongClickable());
		Assert.assertFalse(Registerpage.isBeldexAddressLongClickable());
	}*/
		 /*Validate whether ID and Address are change while navigating back and navigating in into the register screen.*/
		
	     @Test(priority = 4)
	     public void To_Validate_whether_the_ID_And_Address_are_change_while_navigating_back_and_navigate_into_register_screen() {
		 Registerpage =new RegisterScreen(driver);
		 wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
		 String oldBChatId= Registerpage.BChatID();
		 String oldBeldexAddress= Registerpage.BeldexAddress();
		 driver.navigate().back();
		 Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		 displaynamepage.clickContinue();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
		 Registerpage =new RegisterScreen(driver);
		 Assert.assertNotEquals(oldBChatId, Registerpage.BChatID());
		 Assert.assertNotEquals(oldBeldexAddress, Registerpage.BeldexAddress());
	}
	     /*
		 Validate whether the ID and Address response for the touch action in register screen.
		 Validate whether the user is able to edit the ID and Address in register screen. 
		 */
		 @Test(priority = 5)
		 public void To_Validate_whether_the_ID_and_Address_were_clickable_And_editable_in_register_screen() {
		 Registerpage =new RegisterScreen(driver);
		 Assert.assertFalse(Registerpage.isBChatIdClickable());
		 Assert.assertFalse(Registerpage.isBeldexAddressClickable());
			 
		}
		 /*
		 Validate the working of the next button functionality in the register screen.
		 */
		   @Test(priority = 6)
		   public void To_Validate_the_working_of_next_Button_functionality_in_register_screen (){
		   Registerpage =new RegisterScreen(driver);
		   Registerpage.clickNext();
		   createpasswordpage = new CreatePasswordScreen(driver);
		   Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
					
		}
}
