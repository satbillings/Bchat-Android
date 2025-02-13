package AutomationTesting.BchatApp;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Restore_Flow_RestoreFromSeedScreen_TestCases extends baseclass {
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
public void preSetup () {
	
	Openingpage = new OpeningPage(driver);	
	Openingpage.clickSignIn();
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.pasteSeedValue();
	seedpage.clickNext();
	restorefromseedpage = new RestoreFromSeedScreen(driver);
	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	}
/*
TC_114 : Validate whether crusher blink on clicking the text box of screen.
*/
/*@Test(priority = 2)
public void TC_114_To_Validate_whether_crusher_blink_on_clicking_the_text_box_of_screen () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	restorefromseedpage.clicktextboxDisplayname();
	restorefromseedpage.clicktextboxBLockheight();
}

/*
TC_115 : Validate the presence of placeholder in the text box of the screen.
*/
/*@Test(priority = 3)
public void TC_115_To_Validate_the_presence_of_placeholder_in_the_text_box_of_the_screen () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
    Assert.assertEquals(restorefromseedpage.NamePlaceholder(), "Enter name");
    Assert.assertEquals(restorefromseedpage.BlockheightPlaceholder(), "Enter Block height to Restore");
    restorefromseedpage.clickBtnDate();
    Assert.assertEquals(restorefromseedpage.datePlaceholder(), "Select Date");
    restorefromseedpage.clickBtnBlockheight();
}

/*
TC_108 : Validate the working of the restore option without Entering value in display name, restore from block height and restore from date.
*/
/*@Test(priority = 4)
public void TC_108_To_Validate_the_working_of_restore_without_Entering_value_in_display_name_restore_from_blockheight_and_restore_from_date () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
    restorefromseedpage.clickBtnRestore();
    restorefromseedpage.clickBtnDate();
    restorefromseedpage.clickBtnRestore();
    restorefromseedpage.clickBtnBlockheight();
}

/*
TC_109 : Validate the working of the restore option with valid display name and Without entering a value in both blockheight and restore from date.
*/
/*@Test(priority = 5)
public void TC_109_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Without_entering_both_blockheight_and_restore_from_date () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
  	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
   restorefromseedpage.clearValues();   	
  	restorefromseedpage.setDisplayName("Sat");
  	restorefromseedpage.clickBtnRestore();
    //String toastmessage =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
   //Assert.assertEquals(Toast(),"Please enter a restore height");
   restorefromseedpage.clickBtnDate();
   restorefromseedpage.clickBtnRestore();
  // String toastmessage2 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
  // Assert.assertEquals(Toast(),"Please pick a restore date");	
   restorefromseedpage.clickBtnBlockheight();
      	
}

/*
TC_112 : Validate the working of the restore option with valid display name and Invalid block height 
*/
/*@Test(priority = 6)
public void TC_112_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Invalid_blockheight () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
  	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
  	restorefromseedpage.clearValues();
  	restorefromseedpage.setDisplayName("SatBill");
  	restorefromseedpage.setBlockheight("888888888");
  	restorefromseedpage.clickBtnRestore();
   // String toastmessage =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
   Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
}

/*
TC_113 : Validate the working of the restore option with Invalid display name and Invalid blockheight
*/
/*@Test(priority = 7)
public void TC_113_To_Validate_working_of_restore_option_with_Invalid_display_name_and_Invalid_blockheight () throws InterruptedException {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
  	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
  	restorefromseedpage.clearValues();
  	restorefromseedpage.setDisplayName("@#$5&89");
  	restorefromseedpage.setBlockheight("888888888");
  	Thread.sleep(5000);
    //String toastmessage2 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
    //Assert.assertEquals(Toast(),"Enter a valid height");
  	restorefromseedpage.clickBtnRestore();
   // String toastmessage2 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
   Assert.assertEquals(Toast(),"Please enter a valid name");
}

/*
TC_111 : Validate the working of the restore option with Invalid display name and valid blockheight
Tc_116 : Validate the working of the restore option with Invalid display name and valid restore date.
*/
/*@Test(dataProvider ="setInvaliddata",priority = 8)
public void TC_111_And_116_To_Validate_the_working_of_the_restore_option_with_Invalid_display_names_and_valid_blockheight_and_Date(HashMap <String,String> Input) throws InterruptedException{
	restorefromseedpage = new RestoreFromSeedScreen(driver);
  	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
  	restorefromseedpage.clearValues();
  	restorefromseedpage.setDisplayName(Input.get("DisplayName"));
  	restorefromseedpage.setBlockheight("300000");
	//Thread.sleep(5000);
  	try {
	restorefromseedpage.clickBtnRestore();
    //String toastmessage3 = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	Assert.assertEquals(Toast(),"Please enter a valid name");
  	}
  	catch(StaleElementReferenceException E) {
		 restorefromseedpage.clickBtnRestore();	
		    //String toastmessage3 = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		 Assert.assertEquals(Toast(),"Please enter a valid name");
		 
	 }
	restorefromseedpage.selectTodayDate();
	//Thread.sleep(3000);
	try {
	restorefromseedpage.clickBtnRestore();
   // String toastmessage4 = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
    Assert.assertEquals(Toast(),"Please enter a valid name");
	}
	catch(StaleElementReferenceException E) {
		 restorefromseedpage.clickBtnRestore();	
		    //String toastmessage4 = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		 Assert.assertEquals(Toast(),"Please enter a valid name");
		 
	 }
	restorefromseedpage.clickBtnBlockheight();

}
@DataProvider
public Object[][] setInvaliddata() throws IOException {
	
	List <HashMap <String,String>>data=super.getjsonFile("//Data//InvalidDisplayNames.json");
	return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
	
}

/*
TC_110 : Validate the working of the restore option with valid display name and valid blockheight
*/
@Test(dataProvider = "setValiddata",priority = 9)
public void TC_110_To_Validate_the_working_of_the_restore_option_with_valid_datas_display_name_and_valid_blockheight (HashMap <String,String> input) {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
  	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
  	restorefromseedpage.clearValues();
	restorefromseedpage.setDisplayName(input.get("DisplayName"));
  	restorefromseedpage.setBlockheight("3000000");
  	restorefromseedpage.clickBtnRestore();
  	 createpasswordpage = new CreatePasswordScreen(driver);
  	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  	// wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
  	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
  	try {
  	driver.navigate().back();
  	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
  	}
  	catch( NoSuchElementException E) {
		if(Openingpage.WebElementAppList().isDisplayed()||Openingpage.WebElementAppList().isDisplayed()) {
			Openingpage.swipeGesture(100, 100, 200, 200, "UP");
			Openingpage.openApp();
			Openingpage.clickSignIn();
				seedpage = new SeedScreen(driver);
				Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
				seedpage.pasteSeedValue();
				seedpage.clickNext();
				restorefromseedpage = new RestoreFromSeedScreen(driver);
				Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	}
  	}
}

@DataProvider
public Object[][] setValiddata() throws IOException {
	
	List <HashMap <String,String>>data=super.getjsonFile("//Data//ValidDisplayNames.json");
	return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
	
}
/*
TC_117 : Validate whether able to select the future date in restore from date calendar
*/
@Test(priority = 10)
public void TC_117_To_Validate_whether_able_to_select_the_future_date_in_restore_from_date_calendar () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
   	//restorefromseedpage.clearValues();
   	restorefromseedpage.clickBtnDate();
   	restorefromseedpage.clicktextboxDate();
   Assert.assertFalse(restorefromseedpage.CheckFutureDate().isEnabled());
   restorefromseedpage.clickCancel();
   
}
/*
TC_122 : Validate the text box of the Display Name screen by entering values above boundary value.
*/
@Test(priority = 11)
public void TC_122_To_Validate_DisplayName_With_Above_Boundary_Value () throws InterruptedException {
	
	//restorefromseedpage = new RestoreFromSeedScreen(driver);
  	//Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   restorefromseedpage.clickBtnBlockheight();
   restorefromseedpage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
 	restorefromseedpage.setBlockheight("3000000");
   restorefromseedpage.clickBtnRestore();
	//wait =new WebDriverWait(driver,Duration.ofSeconds(30));
  // Thread.sleep(5000);
  // String toastmessage5 = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
   Assert.assertEquals(Toast(),"Please pick a shorter display name"); 	
   //restorefromseedpage.clearValues();
}
/*
TC_120 : Validate whether able to paste Alphabets blockheight textbox.
*/
@Test(priority = 12)
public void TC_120_To_Validate_whether_able_to_paste_Alphabets_Values_in_blockheight_textbox () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
   	restorefromseedpage.clearValues();
   	restorefromseedpage.paste_Value_In_Blockheight(("Abcde"));
   Assert.assertTrue(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
   
}
/*
TC_119 : validate the working of the restore option by paste values in textboxes.
*/
@Test(priority = 13)
public void TC_119_To_validate_the_working_of_the_restore_option_by_paste_values_in_textboxes () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
   	restorefromseedpage.clearValues();
   	restorefromseedpage.paste_Value_In_DisplayName("Sat");
   	restorefromseedpage.paste_Value_In_Blockheight("3000000");
   	try {
   		restorefromseedpage.clickBtnRestore();
   	 createpasswordpage = new CreatePasswordScreen(driver);
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   	 //wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
   		//driver.navigate().back();
   
   	}
   	catch( NoSuchElementException E) {
		if(Openingpage.WebElementAppList().isDisplayed()||Openingpage.WebElementAppList().isDisplayed()) {
			Openingpage.swipeGesture(100, 100, 200, 200, "UP");
			Openingpage.openApp();
			Openingpage.clickSignIn();
				seedpage = new SeedScreen(driver);
				Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
				seedpage.pasteSeedValue();
				seedpage.clickNext();
				restorefromseedpage = new RestoreFromSeedScreen(driver);
				Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	}

}	
}
/*TC_118 : Validate the working of the restore option with valid display name and valid restore date.
*/
/*@Test(priority = 14)
public void TC_118_To_Validate_the_working_of_the_restore_with_valid_display_name_and_valid_restore_date () {
	restorefromseedpage = new RestoreFromSeedScreen(driver);
   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
   	restorefromseedpage.clearValues();
   	restorefromseedpage.setDisplayName("Sat");
   	restorefromseedpage.selectTodayDate();
   	restorefromseedpage.clickBtnRestore();
   	 createpasswordpage = new CreatePasswordScreen(driver);
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   	// wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
   
}*/
/*
Setup to navigate to home screeen in signInFlow
No need of create Password screen validation, because create password screen scenarios tested in create account flow
*/
@Test(priority = 14)
public void TC_TO_validate_Navigation_To_home_with_Valid_Password() {
	createpasswordpage = new CreatePasswordScreen(driver);
	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	try {
	createpasswordpage.setValidPassword();
	createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
	homepage = new HomeScreen(driver);
	Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	catch(NoSuchElementException E) {
		
		homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
}
}