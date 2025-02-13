package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Create_Account_Flow_RecoveryPhraseScreen_TestCases extends baseclass {
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
    RegisterScreen Registerpage;
	WebDriverWait wait;
	
    @Test(priority = 1)
	public void presetup() throws InterruptedException {
    	//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
		displaynamepage =new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Sat");
		displaynamepage.clickContinue();
		wait =new WebDriverWait(driver,Duration.ofSeconds(40));
		Registerpage =new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
		Thread.sleep(10000);
		Registerpage.clickNext();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();	
		Thread.sleep(5000);
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		Thread.sleep(5000);

	}
    /*
	 TC_82	Validate whether able to navigate to the next screen without copying the recovery seed.	
	 TC_83	Validate whether continue function is enable without copying the recovery seed.	
	 */
	@Test(priority = 2)
	 public void TC_82_To_Validate_whether_able_to_navigate_to_the_next_screen_without_copying_the_recovery_seed_TC_83_To_Validate_whether_continue_function_is_enable_without_copying_the_recovery_seed () throws InterruptedException {
		recoveryphrasepage =new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		try {
		recoveryphrasepage.ClickContinue();
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		}
		catch(ElementClickInterceptedException e) {
			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		}
	}
	/*
	 TC_81	Validate the working of the copy option in the recovery phase screen.
	 */
	@Test(priority = 3)
	public void TC_81_To_Validate_the_working_of_the_copy_option_in_the_recovery_phase_screen () {
		recoveryphrasepage =new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
	      //String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(Toast(),"Copied to clipboard");
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
	}
	/*
	TC_94 : To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority = 4)
	public void TC_85_To_Validate_Whether_Able_to_Navigate_Previous_screen () throws InterruptedException {
		recoveryphrasepage =new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		driver.navigate().back();
		//recoveryphrasepage.BackButtonClick();
		//createpasswordpage = new CreatePasswordScreen(driver);
       //Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		//driver.navigate().back();
       //createpasswordpage.clickBackArrow();
       displaynamepage =new DisplayNameScreen(driver);
       displaynamepage.clickContinue();
       wait =new WebDriverWait(driver,Duration.ofSeconds(40));
		Registerpage =new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
		Thread.sleep(10000);
		Registerpage.clickNext();
       createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(5000);
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		Thread.sleep(5000);
	}
	/*
	 * TC_84	Validate whether continue function is enable after copying the recovery seed.
	 TC_85	Validate the working of the  continue button after copying the recovery seed.
	 */
	@Test(priority = 5)
	public void TC_84_And_85_To_Validate_the_working_of_the_continue_button_after_copying_the_recovery_seed_TC_85_To_Validate_the_working_of_the_continue_button_after_copying_the_recovery_seed () {
		
		recoveryphrasepage =new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		try {
		recoveryphrasepage.ClickContinue();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		catch(NoSuchElementException E) {
			
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		}

}
