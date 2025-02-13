package AutomationTesting.BchatApp;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.bidi.module.Input;
//import org.openqa.selenium.bidi.module.Input;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.internal.protocols.Input;

import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;
import TestUtiles.ActionsClass;


public class Home_Screen_TestCases_In_Restore_Account_Flow extends baseclass {
	OpeningPage Openingpage;		
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	WebDriverWait wait;
	
	/*
	 PreSetup Method for this class
	 */
	@Test(priority = 1)
	public void preSetup () throws InterruptedException {
		
		Openingpage = new OpeningPage(driver);	
		Openingpage.clickSignIn();
		seedpage = new SeedScreen(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.pasteSeedValue();
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedScreen(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.paste_Value_In_DisplayName("Sat");
	   	restorefromseedpage.paste_Value_In_Blockheight("3400000");
	   	restorefromseedpage.clickBtnRestore();
	   	createpasswordpage = new CreatePasswordScreen(driver);
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		//Thread.sleep(10000);
		//homepage = new HomeScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	//Validate the text box of the search functionality by entering values above boundary value.
	
	@Test(priority = 2)
	public void To_Validate_the_text_box_of_the_search_functionality_by_entering_values_above_boundary_value(){
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//homepage.clickSearch();
	    homepage.pastevalues("effknfknfkgfnkggkgmfkfkkjkjkhjhjkhhhhjhkjh");        		
	}
	
	
	
	

}
