package AutomationTesting.BchatApp;





import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import org.testng.annotations.Test;


import POM.DisplayNameScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.TermsAndConditionsScreen;
import TestUtiles.baseclass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class OpeningPageTestcases extends baseclass{
	OpeningPage Openingpage;
	DisplayNameScreen displaynamepage;
	RestoreFromSeedScreen Restorefromseedpage;
	TermsAndConditionsScreen TermsAndConditionsPage;
	Boolean click;
	Boolean click2;
	Boolean click3;
	Boolean display;
	Boolean display2;
	WebDriverWait Wait;


	
// TC_3 : Validate whether functions and buttons in the openings screen response for the touch action. 
	
	@Test 
	 public void TC_3_Validate_whether_functions_and_buttons_is_Clickable()throws InterruptedException{
	 
	  Openingpage =new OpeningPage(driver); 
	  click=Openingpage.isCreateAccountClickable(); 
	  Assert.assertTrue(click);
	  System.out.println(click); 
	  click2=Openingpage.isSignInClickable();
	  Assert.assertTrue(click2); 
	  System.out.println(click2);
	  click3=Openingpage.isTermsAndConditionsClickable();
	  Assert.assertTrue(click3);
	  System.out.println(click3); 
	  }
	 
    
    //TC_8 :	Validate whether able to navigate out of the App.
    
	@Test
	public void TC_8_To_Validate_whether_able_to_navigate_out_And_Open_the_App_Again() throws InterruptedException{		
		Openingpage =new OpeningPage(driver);
		display = Openingpage.WebElementCreateAccount().isDisplayed();
		 Assert.assertTrue(display);
		 System.out.println(display);
		 driver.navigate().back();
		Openingpage.swipeGesture(100, 100, 200, 200, "UP");
		Openingpage.openApp();
		Thread.sleep(10000);
		Assert.assertTrue(display);
		System.out.println(display);
			  
			}
	
	/*
	TC_4 : Validate the working of navigation to Create Account screen in both forward and backward direction
	 */
	@Test
	public void TC_4_To_Validate_the_navigation_to_Create_Account_screen_both_forward_and_backward_direction() {
		Openingpage =new OpeningPage(driver);
		display=Openingpage.WebElementCreateAccount().isDisplayed();
	 Assert.assertTrue(display);
	 System.out.println(display);
	 Openingpage.clickCreateAccount();
	 displaynamepage = new DisplayNameScreen(driver);
	  Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
	 
	 Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
	 //try {
		 driver.navigate().back();
		// if(Openingpage.WebElementAppList().isDisplayed()||Openingpage.WebElementAppList().isDisplayed()) {
			 Openingpage.swipeGesture(100, 100, 200, 200, "UP");
				Openingpage.openApp();
					// }
		// }
	// catch(Throwable e) {
		 //e.printStackTrace();
		 
	 //}
	 Assert.assertTrue(display);

	 System.out.println(display);

	 
	}
	/*
	TC_5 : Validate the working of navigation to Sign In screen in both forward and backward direction.
	 */
	@Test
	public void TC_5_To_Validate_the_navigation_to_SignIn_screen_both_forward_and_backward_direction() {
		Openingpage =new OpeningPage(driver);
		display=Openingpage.WebElementCreateAccount().isDisplayed();
	 Assert.assertTrue(display);
	 System.out.println(display);
	 Openingpage.clickSignIn();
	 Restorefromseedpage =new RestoreFromSeedScreen(driver);
	 Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Wait.until(ExpectedConditions.visibilityOf(Restorefromseedpage.textPageTitle));
	 Assert.assertEquals(Restorefromseedpage.pageTitle(),"Restore Seed");

	 //try {
		 driver.navigate().back();
		// if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
		 //Openingpage.swipeGesture(100, 100, 200, 200, "UP");
		 Openingpage.openApp();
		// }
		// }
	 //catch(Throwable e) {
		 //e.printStackTrace();
		 
	 //}
	 Assert.assertTrue(display);
	 System.out.println(display);

	 
	}
	/*
	TC_6 : Validate the working of navigation to terms & conditions page in both forward and backward direction.
	 */
	@Test
	public void TC_6_To_Validate_the_navigation_to_Terms_And_Conditions_screen_both_forward_and_backward_direction() throws InterruptedException {
		Openingpage =new OpeningPage(driver);
		display=Openingpage.WebElementCreateAccount().isDisplayed();
	 Assert.assertTrue(display);
	 System.out.println(display);
	 Openingpage.clickTermsAndConditions();
	 TermsAndConditionsPage =new TermsAndConditionsScreen(driver);
		 /*Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  Wait.until(ExpectedConditions.visibilityOf(TermsAndConditionsPage.textPageTitle));*/
		  //Assert.assertEquals(TermsAndConditionsPage.pageTitle(),"BChat Terms of Service");
	 driver.navigate().back();
	 Assert.assertTrue(display);
	 System.out.println(display);

	}
	

	

}

