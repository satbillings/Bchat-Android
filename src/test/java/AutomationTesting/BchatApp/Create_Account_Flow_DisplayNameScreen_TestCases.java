package AutomationTesting.BchatApp;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import org.testng.asserts.Assertion;


import POM.DisplayNameScreen;
import POM.OpeningPage;
import POM.RegisterScreen;
import TestUtiles.baseclass;
//import TestUtiles.ActionsClass;

public class Create_Account_Flow_DisplayNameScreen_TestCases extends baseclass{
	DisplayNameScreen displaynamepage;
	OpeningPage Openingpage;
	RegisterScreen Registerpage;
	WebDriverWait Wait;
	//String ErrorMessage;
	/*
	 PreSetup method to this class
	 */
	@Test
	public void PreSetup () {
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
   	displaynamepage = new DisplayNameScreen(driver);
    	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
	}
	 /*
    TC_37 :Validate the presence of placeholder in the text box of the Display Name screen.
    */    
      @Test
		public void TC_37_To_Validate_presence_of_placeholder_in_Display_Name_Textbox() {
	
       	displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.NameTextBoxPlachoder(),"Enter a display name");
		   
       }
       /*
       TC_36 : Validate whether crusher blink on clicking the text box of Display Name screen.
       */
      @Test
		public void TC_36_To_Validate_whether_crusher_blink_on_clicking_textbox_of_Display_Name() {
		   
      	displaynamepage = new DisplayNameScreen(driver);
      	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
			try {
				displaynamepage.clickTextBox();
				WebElement active=driver.switchTo().activeElement();
				Assert.assertTrue(displaynamepage.TxtBoxDisplayName.equals(active));
				//Assert.assertTrue(displaynamepage.txtboxDisplayName.equals(driver.switchTo().activeElement()));
				
			}
			catch(Throwable th) {
				th.printStackTrace();
			}
						     
		}
      //Validate display name with empty value
      @Test
  	public void TC_34_To_Validate_DisplayName_With_Empty_Value () {
  		
  		displaynamepage = new DisplayNameScreen(driver);
  		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
  		
  		Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      Wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
      displaynamepage.setDisplayName("   ");
      displaynamepage.clickContinue();
      //String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
      Assert.assertEquals(Toast(),"Please pick a display name");
      displaynamepage.cleardisplayname();
      }
	 /*
    TC_30 : Validate the continue functionality without enter any value in the text box.
    */
	@Test
	public void TC_30_To_Validate_DisplayName_WithoutAny_Value () {
		
		displaynamepage = new DisplayNameScreen(driver);
		String Title=displaynamepage.pageTitle();
		Assert.assertEquals(Title, "Display Name");
		System.out.println(Title); 
		Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
   try {
   displaynamepage.clickContinue();
  // String toastmsg1 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
   Assert.assertEquals(Toast(),"Please pick a display name");
	//System.out.println(toastmsg1); 
   
   }
   catch(Throwable e) {
   	e.printStackTrace();
   }
   }
	 //TC_31 : Validate the text box of the Display Name screen by entering values above boundary value.
	@Test
	public void TC_31_To_Validate_DisplayName_With_Above_Boundary_Value () throws InterruptedException {
		
		displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");	
		Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
    displaynamepage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
    displaynamepage.clickContinue();
       //String toastmsg2 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
    Assert.assertEquals(Toast(),"Please pick a shorter display name");
    displaynamepage.cleardisplayname();
    }
	/*
    TC_34	Validate the text box of the Display Name screen with empty Space.
    TC_32	: Validate the text box of the Display Name screen by using special Characters.	
 TC_41	: Validate whether the value entered in the text box of display Name screen is editable.	
 TC_42	: Validate whether the value entered in the text box of display Name screen is deleteable.
 */

@Test(dataProvider="setInvaliddata")
public void TC_To_Validate_DisplayName_With_Invalid_Datas (HashMap<String,String> input) throws IOException {
	
	//openingpage.clickCreateAccount();
	displaynamepage = new DisplayNameScreen(driver);
	
	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
	//displaynamepage.cleardisplayname();
	displaynamepage.setDisplayName(input.get("DisplayName"));
    displaynamepage.clickContinue();
	 //String toastmsg3 =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
    Assert.assertEquals(Toast(),"Please enter a valid name"); 
	
}


@DataProvider
public Object[][] setInvaliddata() throws IOException {
	
	List <HashMap <String,String>>data=super.getjsonFile("//Data//InvalidDisplayNames.json");
	return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
	
}
/*
TC_33	: Validate the text box of the Display Name screen using Alaphabats both in uppercase and lower case.
TC_35	: Validate the text box of the Display Name screen by numerical value.
*/
@Test(dataProvider="setValiddata")
public void TC_To_Validate_DisplayName_With_valid_Datas (HashMap<String,String> input) throws IOException {

//openingpage.clickCreateAccount();
displaynamepage = new DisplayNameScreen(driver);

Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
displaynamepage.cleardisplayname();
displaynamepage.setDisplayName(input.get("DisplayName"));
	displaynamepage.clickContinue();
	Registerpage =	new RegisterScreen(driver);		 
	Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));		    
	Assert.assertEquals(Registerpage.pageTitle(), "Register"); 		
  driver.navigate().back();	
  Wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
  Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
}


@DataProvider
public Object[][] setValiddata() throws IOException {

List <HashMap <String,String>>data=super.getjsonFile("//Data//ValidDisplayNames.json");
return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};

}
/*
TC_39	: validate whether paste option is working on the text box display Name screen.
*/
@Test
public void TC_39_To_Validate_Whether_Able_To_Paste_Values_In_TextBox () throws InterruptedException {
	displaynamepage = new DisplayNameScreen(driver);
	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
	
	
	try {
		displaynamepage.pasteDisplayName("ChrisLang");
	displaynamepage.clickContinue();
	Registerpage =	new RegisterScreen(driver);
    Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Wait.until(ExpectedConditions.visibilityOf(Registerpage.TextPageTitle));
	Assert.assertEquals(Registerpage.pageTitle(), "Register"); 
	driver.navigate().back();
	displaynamepage.cleardisplayname();
	}
	catch(Throwable th) {
		th.printStackTrace();
	}
 
}
}
