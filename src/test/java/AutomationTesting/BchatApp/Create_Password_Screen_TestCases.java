package AutomationTesting.BchatApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordScreen;
import POM.DisplayNameScreen;
import POM.OpeningPage;
import POM.RecoveryPhraseScreen;
import POM.RegisterScreen;
import TestUtiles.baseclass;

public class Create_Password_Screen_TestCases extends baseclass {
	CreatePasswordScreen createpasswordpage;
	OpeningPage Openingpage;
	DisplayNameScreen displaynamepage;
	RegisterScreen registerpage;
	RecoveryPhraseScreen RecoveryPhrasePage;
	WebDriverWait wait;

	@Test(priority = 1)
	public void preSetup() throws InterruptedException {
		Openingpage = new OpeningPage(driver);
		Openingpage.clickCreateAccount();
		displaynamepage = new DisplayNameScreen(driver);
		displaynamepage.setDisplayName("SatBill");
		displaynamepage.clickContinue();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		registerpage = new RegisterScreen(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.TextPageTitle));
		Assert.assertEquals(registerpage.pageTitle(), "Register");
		Thread.sleep(10000);
		registerpage.clickNext();
	}

	/*
	 * Validate the next function without entering a value in Enter password field
	 * in create password screen.
	 */
	@Test(priority = 2)
	public void To_Validate_the_next_function_without_entering_a_value_in_Enter_password_field_and_ReEnter_password_field_in_create_password_screen() {
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.textEnter(), "Enter your PIN");

		try {
			createpasswordpage.clickNext();
		} catch (ElementNotInteractableException e) {
			Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(), "Enter your PIN");

		}
	}

	/*
	 * Validate with Valid value in password field and Invalid value in Re-enter
	 * password field in create password screen.
	 */
	@Test(priority = 3)
	public void To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field_in_create_password_screen() throws InterruptedException {
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(), "Enter your PIN");
		Thread.sleep(3000);
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		//Assert.assertEquals(createpasswordpage.textErrorMsg(), "Password does not match.");
		Thread.sleep(3000);
		driver.navigate().back();
		registerpage = new RegisterScreen(driver);
		registerpage.clickNext();
		Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(), "Enter your PIN");
	}
	/*
	 * TC_62 : Validate the next function with a value in Enter password and without
	 * a value in Re-Enter password
	 */
	/*
	 * @Test(priority = 4) public void
	 * TC_62_To_Validate_the_next_function_with_value_only_In_Enter_password_Field
	 * () { createpasswordpage =new CreatePasswordScreen(driver);
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
	 * 
	 * createpasswordpage.setPassword_0(); try { createpasswordpage.clickNext();
	 * createpasswordpage.clickNext(); } catch(ElementNotInteractableException E){
	 * driver.navigate().back(); registerpage = new RegisterScreen(driver);
	 * registerpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN"); }
	 * 
	 * }
	 * 
	 * TC_66 : Validate the Pin number fields in the Create password screen by
	 * entering values below boundary value in any one field
	 * 
	 * @Test(priority =5) public void
	 * TC_66_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field
	 * (){
	 * 
	 * createpasswordpage =new CreatePasswordScreen(driver);
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * 
	 * 
	 * createpasswordpage.setPassword_with_below_boundary_value();
	 * createpasswordpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
	 * createpasswordpage.click1();
	 * 
	 * createpasswordpage.clickNext();
	 * createpasswordpage.setPassword_with_below_boundary_value();
	 * 
	 * createpasswordpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
	 * 
	 * //createpasswordpage.clickBackArrow(); driver.navigate().back(); registerpage
	 * = new RegisterScreen(driver); registerpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
	 * 
	 * 
	 * }
	 * 
	 * TC_76 Validate whether the value entered in the Pin number fields of the
	 * Create password is editable. TC_77 Validate whether the value entered in the
	 * Pin number fields of the Create password is deleteable.
	 * 
	 * @Test(priority=6) public void
	 * TC_76_And_77_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable
	 * () {
	 * 
	 * createpasswordpage =new CreatePasswordScreen(driver);
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
	 * 
	 * createpasswordpage.setPassword_0();
	 * 
	 * createpasswordpage.cancel_Values();
	 * 
	 * createpasswordpage.setPassword_1();
	 * 
	 * createpasswordpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
	 * createpasswordpage.setPassword_0();
	 * 
	 * createpasswordpage.cancel_Values();
	 * 
	 * createpasswordpage.setPassword_1();
	 * 
	 * driver.navigate().back(); registerpage = new RegisterScreen(driver);
	 * registerpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN"); }
	 * 
	 * TC_59 : Validate with Valid value in enter password field and Invalid value
	 * in Re-enter password field and repeat it for multiple times.
	 * 
	 * @Test(priority = 7) public void
	 * TC_59_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field_and_repeat_it_for_multiple_time
	 * (){
	 * 
	 * 
	 * 
	 * for(int i=0;i<3;i++) { createpasswordpage =new CreatePasswordScreen(driver);
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
	 * createpasswordpage.setInValidPassword();
	 * Assert.assertEquals(createpasswordpage.textErrorMsg()
	 * ,"Password does not match."); driver.navigate().back(); registerpage = new
	 * RegisterScreen(driver); registerpage.clickNext();
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN"); } }
	 * 
	 * TC_58 : Validate with Valid value in enter password field and Valid value in
	 * Re-enter password field.
	 * 
	 * @Test(priority = 8) public void
	 * TC_58_To_Validate_with_Valid_value_in_both_enter_password_field_and_in_ReEnter_password_field
	 * () {
	 * 
	 * createpasswordpage =new CreatePasswordScreen(driver);
	 * Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	 * Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
	 * createpasswordpage.setValidPassword(); //createpasswordpage.clickOk();
	 * createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
	 * RecoveryPhrasePage =new RecoveryPhraseScreen(driver);
	 * 
	 * wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOf(RecoveryPhrasePage.TextPageTitle))
	 * ; Assert.assertEquals(RecoveryPhrasePage.pageTitle(), "Recovery Seed");
	 * 
	 * }
	 */
}
