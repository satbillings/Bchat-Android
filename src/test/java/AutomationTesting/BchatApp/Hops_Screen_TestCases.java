package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsScreen;
import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.HomeScreen;
import POM.HopsScreen;
import POM.MenuScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Hops_Screen_TestCases extends baseclass{
	OpeningPage Openingpage;
	CreatePasswordScreen createpasswordpage;
	RecoveryPhraseScreen recoveryphrasepage;
	HomeScreen homepage;
	//RecoverySeed_Page recoveryseedpage ;
	DisplayNameScreen displaynamepage;
    RegisterScreen registerpage;
	MenuScreen menupage;
	AccountSettingsScreen accountsettingspage; 
	HopsScreen hopspage;
	WebDriverWait wait;
	
	@Test(priority = 0)
	public void PreSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
		displaynamepage =new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Sat");
		displaynamepage.clickContinue();
		registerpage= new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.TextPageTitle));
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		Thread.sleep(15000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		//createpasswordpage.clickOk();
		createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		recoveryphrasepage =new RecoveryPhraseScreen(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		turnOff_Mobile_Wifi();
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		Thread.sleep(5000);
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		//menupage =new MenuScreen(driver);
		//Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuScreen(driver);
		menupage.click_Account_Settings();
		accountsettingspage =new AccountSettingsScreen(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	    accountsettingspage.click_Hops_Option();
}
	/*
	Validate the working of the Hops Screen without Internet Connection.
	*/
	@Test(priority = 1)
	public void To_Validate_the_working_of_the_Hops_Screen_without_Internet_Connection (){
		hopspage =new HopsScreen(driver);
		Assert.assertEquals(hopspage.pageTitle(), "Hops");				
		}			
		
	/*
	Validate whether able to navigate back to the My Account Screen from hops screen.
	*/
	@Test(priority = 2)
	public void To_Validate_whether_able_to_navigate_back_to_the_My_Account_Screen_from_hops_screen () {
		
		hopspage =new HopsScreen(driver);
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		hopspage.click_Back_Arrow();
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	/*
	Validate the working of the Hops Screen with Internet Connection.
	*/
	@Test(priority = 3)
	public void To_Validate_the_working_of_the_Hops_Screen_with_Internet_Connection () {
		accountsettingspage =new AccountSettingsScreen(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		driver.navigate().back();
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");	
		turnOn_Mobile_Wifi();
		homepage.clickMenuDrawer();
		menupage = new MenuScreen(driver);
		menupage.click_Account_Settings();
        accountsettingspage =new AccountSettingsScreen(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_Hops_Option();
		hopspage =new HopsScreen(driver);
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		Assert.assertTrue(hopspage.Element_Entry_Node().isDisplayed());
		Assert.assertTrue(hopspage.Element_Master_Node().isDisplayed());
	}
}
