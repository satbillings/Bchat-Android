package AutomationTesting.BchatApp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Restore_Flow_SeedScreen_TestCases extends baseclass {
	OpeningPage Openingpage;
	SeedScreen seedpage;
	RestoreFromSeedScreen Restorefromseedpage;
	
	
	/*
	 presetup method for this class
	 */
	@Test(priority = 1)
	public void PreSetup () {
		Openingpage = new OpeningPage(driver);
		Openingpage.clickSignIn();
		//seedpage = new SeedScreen(driver);
		
	}
	/*
	 TC_94	To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority =2)
	public void TC_94_To_Validate_Whether_Able_to_Navigate_Previous_screen () {
		
		seedpage = new SeedScreen(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		//try {
			 driver.navigate().back();
				Openingpage.swipeGesture(100, 100, 200, 200, "UP");

			 //if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
			 Openingpage.openApp();
			// }
			// }
		 //catch(Throwable e) {
			// e.printStackTrace();
			 
		// }
		Assert.assertTrue(Openingpage.WebElementCreateAccount().isDisplayed());
	}
	
/*
TC_96 :Validate the presence of placeholder in the text box of the Restore seed screen.
*/
@Test(priority =3)
public void TC_96_To_Validate_the_presence_of_placeholder_in_the_Restore_From_seed_text_box () {
	
	Openingpage.clickSignIn();
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	Assert.assertEquals(seedpage.Placeholder(),"Enter your Seed");
}
/*
TC_ 95 : Validate whether crusher blink on clicking the text box of Restore from screen.
*/
@Test(priority =4)
public void	TC_95_To_Validate_whether_crusher_blink_on_clicking_the_Restore_From_Seed_text_Box () {

	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clickTextBox();
	try {
	WebElement active=driver.switchTo().activeElement();
	Assert.assertTrue(seedpage.SeedTextBox.equals(active));
	}
	catch(Exception E) {
		E.printStackTrace();
	}
	}
/*
TC_102 :	Validate the working of the next option without entering seed.
*/
@Test(priority =5)
public void TC_102_To_Validate_the_working_of_the_next_option_without_entering_seed () {
	
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clickNext();
    //String toastmessage =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	//Assert.assertEquals(Toast(), "Please enter valid seed");
	
}
/*
TC_92 : Validate whether able to paste the copied seed.	
*/
@Test(priority =6)
public void TC_92_To_Validate_whether_able_to_paste_the_copied_seed () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	seedpage.pasteSeedValue();
   Assert.assertEquals(seedpage.SeedValueCount(),"25/25");
}
/*
TC_93 :  Validate whether able to clear the entered seed
*/
@Test(priority =7)
public void TC_93_To_Validate_whether_able_to_clear_the_entered_seed () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	Assert.assertEquals(seedpage.SeedValueCount(),"25/25");
	seedpage.clickClear();
	Assert.assertEquals(seedpage.SeedValueCount(),"0/25");
}
/*
TC_98 : Validate the text box of the restore from screen by entering values below boundary value.
*/
@Test(priority = 8)
public void TC_98_To_Validate_the_text_box_of_the_restore_from_screen_by_entering_values_below_boundary_value () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.set_Below_Boundary_SeedValue();
try {
	seedpage.clickNext();
   // String toastmessage =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	Assert.assertEquals(Toast(),"Please enter valid seed");
}
catch(StaleElementReferenceException E) {
	seedpage.clickNext();
   // String toastmessage2 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	Assert.assertEquals(Toast(),"Please enter valid seed");
}
}
/*
TC_97 : Validate the text box of the restore from screen by entering values above boundary value.
*/
@Test(priority = 9)
public void TC_97_To_Validate_the_text_box_of_the_restore_from_seed_by_entering_values_above_boundary_value () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	seedpage.set_above_Boundary_SeedValue();
	Assert.assertEquals(seedpage.SeedValueCount(), "25/25");
}
/*
TC_99 : Validate whether able to type a seed.
*/
@Test(priority = 10)
public void TC_99_To_Validate_whether_able_to_type_a_seed () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	seedpage.EnterSeedValue();
	Assert.assertEquals(seedpage.SeedValueCount(), "25/25");	
}
/*
TC_105 :	Validate Whether entered seed is editable
*/
@Test(priority = 11)
public void TC_105_To_Validate_Whether_Entered_seed_is_editable () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	seedpage.setSeedValue("Football");
	String value1 = seedpage.SeedtextboxValues();
	seedpage.clearSeedValues();
	seedpage.setSeedValue("isolated");
	String value2 = seedpage.SeedtextboxValues();
	Assert.assertNotEquals( value1, value2);
	
}	
/*
TC_103 :	Validate the working of the next option by entering Invalid seed.
*/
@Test(dataProvider = "setdata",priority = 12)
public void TC_103_To_Validate_the_working_of_the_next_option_by_entering_Invalid_seed ( HashMap <String,String> input) {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	seedpage.setSeedValue(input.get("Seed"));
	try {
	seedpage.clickNext();
   // String toastmessage3 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");

	Assert.assertEquals(Toast(),"There appears to be an invalid word in your mnemonic. Please check what you entered and try again.");
	}
	catch (Exception e) {
		seedpage.clickNext();
	    //String toastmessage4 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");

		Assert.assertEquals(Toast(),"There appears to be an invalid word in your mnemonic. Please check what you entered and try again.");
	}
	catch (AssertionError e) {
		seedpage.clickNext();
	   // String toastmessage5 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");

		Assert.assertEquals(Toast(),"Your mnemonic couldn't be verified. Please check what you entered and try again.");
	}
	}

@DataProvider
public Object[][] setdata() throws IOException {
	List <HashMap <String,String>>data=super.getjsonFile("//Data//InvalidSeedValues.json");
	return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
}
/*
TC_100 : Validate the working of next option by pasting 25 blank space value
*/
@Test(priority = 13)
public void TC_100_To_Validate_the_working_of_next_option_by_pasting_25_blank_space_value (){
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	
	seedpage.setSeedValue("                         ");
	seedpage.clickNext();
    //String toastmessage6 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");

	Assert.assertEquals(Toast(), "Please enter valid seed");
}
/*
TC_104 :	Validate the working of the next option by entering Valid seed.
*/
@Test(priority = 14)
public void TC_104_To_Validate_the_working_of_the_next_option_by_entering_Valid_seed () {
	seedpage = new SeedScreen(driver);
	Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	seedpage.clearSeedValues();
	seedpage.EnterSeedValue();
	seedpage.clickNext();
	Restorefromseedpage = new RestoreFromSeedScreen(driver);
	Assert.assertTrue(Restorefromseedpage.BlockheightTextBox().isDisplayed());	
}
}
