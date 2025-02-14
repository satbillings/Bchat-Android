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

public class Create_Account_Flow_DisplayNameScreen_TestCases extends baseclass {
	DisplayNameScreen displaynamepage;
	OpeningPage Openingpage;
	RegisterScreen Registerpage;
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
	}

	/*
	  Validate the presence of placeholder in the text box of the Display Name screen.
	 */
	@Test(priority = 1)
	public void To_Validate_presence_of_placeholder_in_Display_Name_Textbox_in_display_name_screen() throws InterruptedException {

		displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");	
		Thread.sleep(3000);
		Assert.assertEquals(displaynamepage.NameTextBoxPlachoder(), "Enter a display name");
		//Thread.sleep(3000);

	}

	/*
	 * Validate whether the cursor blink on clicking the text box of Display Name.
	 * screen.
	 */
	@Test(priority = 2)
	public void To_Validate_whether_the_crusher_blink_on_clicking_textbox_of_Display_Name_screen() {

		displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
		try {
			displaynamepage.clickTextBox();
			WebElement active = driver.switchTo().activeElement();
			Assert.assertTrue(displaynamepage.TxtBoxDisplayName.equals(active));
			// Assert.assertTrue(displaynamepage.txtboxDisplayName.equals(driver.switchTo().activeElement()));

		} catch (Throwable th) {
			th.printStackTrace();
		}

	}

	// Validate display name text box with empty value in display name screen.
	
	@Test(priority = 3)
	public void To_Validate_Display_Name_text_box_With_Empty_Value_in_display_name_screen() {

		displaynamepage = new DisplayNameScreen(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
		displaynamepage.setDisplayName("   ");
		displaynamepage.clickContinue();
		//Assert.assertEquals(Toast(), "Please pick a display name");
		displaynamepage.cleardisplayname();
	}

	/*
	  Validate the clicking continue button without enter any value in display name text box in display name screen.
	 */
	@Test(priority = 4)
	public void To_validate_the_clicking_continue_button_without_enter_any_value_in_display_name_text_box_in_display_name_screen() throws InterruptedException {

		displaynamepage = new DisplayNameScreen(driver);
		String Title = displaynamepage.pageTitle();
		Assert.assertEquals(Title, "Display Name");
		System.out.println(Title);
		Thread.sleep(3000);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
		displaynamepage.clickContinue();
		//Assert.assertEquals(Toast(), "Please pick a display name");
	}
	// Validate the text box of the Display Name screen by entering values above boundary value.
	
	  @Test(priority = 5)
	  public void To_validate_the_text_box_of_the_Display_Name_screen_by_entering_values_above_boundary_value () throws InterruptedException {
	  
	  displaynamepage = new DisplayNameScreen(driver);
	  Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
	  Thread.sleep(3000);
	  //wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  //wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
	  displaynamepage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
	  displaynamepage.clickContinue();
	  //Assert.assertEquals(Toast(),"Please pick a shorter display name");
	  displaynamepage.cleardisplayname();
	  }
	 
}
