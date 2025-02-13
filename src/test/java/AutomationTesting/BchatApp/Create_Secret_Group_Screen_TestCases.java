package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatScreen;
import POM.CreatePasswordScreen;
import POM.CreateSecretGroupScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SecretGroupChatScreen;
import POM.SeedScreen;
import TestUtiles.baseclass;

public class Create_Secret_Group_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	SeedScreen Seedpage;
	RestoreFromSeedScreen restorefromseedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	CreateSecretGroupScreen createsecretgrouppage;
	SecretGroupChatScreen secretgroupchatpage;
	WebDriverWait wait;
	
	 @Test(priority = 0)
	   	public void PreSetup() throws InterruptedException {
	    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 Openingpage = new OpeningPage(driver); 
			 Openingpage.clickSignIn(); 
			 Seedpage = new SeedScreen(driver);
			Assert.assertTrue(Seedpage.SeedTextBox().isDisplayed());
			Seedpage.pasteSeedValue(); 
			Seedpage.clickNext(); 
			restorefromseedpage = new RestoreFromSeedScreen(driver);
			Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
			restorefromseedpage.paste_Value_In_DisplayName("Sathish");
			restorefromseedpage.paste_Value_In_Blockheight("3400000");
			restorefromseedpage.clickBtnRestore(); 
			createpasswordpage = new CreatePasswordScreen(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			createpasswordpage.setValidPassword();
			 createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
			//Thread.sleep(10000); 
			 homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat"); 
			Thread.sleep(50000); 
			homepage.OpenNewSecretGroup();	
	 }
	 /*
		Validate whether able to navigate back to the home screen from create secret group screen.
		*/
		/*@Test(priority = 1)
		public void To_Validate_whether_able_to_navigate_back_to_home_screen_from_create_secret_group_screen () {
			createsecretgrouppage = new CreateSecretGroupScreen(driver);
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.ClickBackArrow();
			homepage = new HomeScreen(driver);
			  Assert.assertEquals(homepage.Pagetitle(),"BChat");	
			  homepage.OpenNewSecretGroup();
		} 
		/*
		Validate Whether able to select the contacts showing in create secret group screen.
		*/
		/*@Test(priority = 2)
		public void To_Validate_Whether_able_to_select_the_contacts_showing_in_create_secret_group_screen () {
			createsecretgrouppage = new CreateSecretGroupScreen(driver);
			  Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			  Assert.assertEquals(createsecretgrouppage.CheckContactSelectorNot(),"false");
			  createsecretgrouppage.SelectContact();
			  Assert.assertTrue(createsecretgrouppage.DisplaySelectedFirstContact().isDisplayed());
		}
		/*
		 Validate Whether able to unselect the selected contact in create secret group screen.
		 */
		/*@Test(priority = 3)
		public void To_Validate_Whether_able_to_Unselect_the_contacts_showing_in_create_secret_group_screen () {
			createsecretgrouppage = new CreateSecretGroupScreen(driver);
			  Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			  createsecretgrouppage.SelectContact();
			  Assert.assertTrue(createsecretgrouppage.DisplaySelectedFirstContact().isDisplayed());
			  createsecretgrouppage.SelectContact();
			  Assert.assertEquals(createsecretgrouppage.CheckContactSelectorNot(),"false");
		}
		/*
		Validate Whether able to multi select the contacts showing in create secret group screen.
		*/
		/*@Test(priority = 4)
		public void To_Validate_Whether_able_to_multi_select_the_contacts_showing_in_create_secret_group_screen () {
			createsecretgrouppage = new CreateSecretGroupScreen(driver);
			  Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			  createsecretgrouppage.MultiSelectContact();
			  Assert.assertTrue(createsecretgrouppage.DisplaySelectedFirstContact().isDisplayed());
			  Assert.assertTrue(createsecretgrouppage.DisplaySelectedSecondContact().isDisplayed());
			  createsecretgrouppage.MultiSelectContact();
		}
		/*
		Validate the Create function without entering a group name and without selecting a member in create secret group screen.
		*/
		/*@Test(priority = 5)
		public void To_Validate_Create_function_without_entering_groupName_and_without_selecting_member_in_create_secret_group_screen () {
			createsecretgrouppage = new CreateSecretGroupScreen(driver);
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.ClickCreateButton();
			Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
		}
		/*
		Validate the Create function with entering a group name and without selecting a member in create secret group screen.
		*/
	  /* @Test(priority = 6)
	   public void To_Validate_Create_function_with_entering_groupName_and_without_selecting_member_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.Set_Values_In_GroupName_Textbox("Test");
			createsecretgrouppage.ClickCreateButton();
			 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.ClearGroupNameTextBox();
			 }*/
	 /*
	   Validate the Create function without entering a group name and with selecting a member in create secret group screen.
	   */
	   /*@Test(priority = 7)
	   public void To_Validate_the_Create_function_without_entering_groupName_and_with_selecting_member_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.SelectContact();
			 createsecretgrouppage.ClickCreateButton();
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.SelectContact();
	   }
	   /*
	    Validate the Create function with entering space value in group name and with selecting a member in create secret group screen.
	    */
	  /* @Test(priority = 8)
	   public void To_Validate_Create_function_with_entering_space_value_in_groupName_and_with_selecting_a_member_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
			 Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.Set_Values_In_GroupName_Textbox("     ");
			 createsecretgrouppage.SelectContact();
			 createsecretgrouppage.ClickCreateButton();
			Assert.assertEquals(Toast(),"Please enter a group name");
			Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
			 createsecretgrouppage.ClearGroupNameTextBox();
			 createsecretgrouppage.SelectContact();
	   }
	   /*
	   Validate the Create function with entering a group name and with selecting a member in create secret group screen.
	   */
	   /*@Test(priority = 9)
	   public void To_Validate_Create_function_with_entering_groupName_and_with_selecting_member_in_create_secret_group_screen () throws InterruptedException {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
		   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
		   createsecretgrouppage.Set_Values_In_GroupName_Textbox("Group");
		   createsecretgrouppage.SelectContact();
			Thread.sleep(4000); 
		   createsecretgrouppage.ClickCreateButton();	   
		   secretgroupchatpage = new SecretGroupChatScreen(driver);
		   Assert.assertEquals(secretgroupchatpage.getGroupChatTitle(),"Group");
		   secretgroupchatpage.ClickBackArrow();
	      homepage = new HomeScreen(driver);
		   	Assert.assertEquals(homepage.Pagetitle(),"BChat");	
		   	homepage.OpenNewSecretGroup();
			createsecretgrouppage.SelectContact();
	   }
	   /*
	   Validate whether crusher blink on clicking the text box of Secret Group in create secret group screen.
		*/
	  /* @Test(priority = 10)
	   public void To_Validate_whether_crusher_blink_on_clicking_textboxes_of_SecretGroup_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
		   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
		   createsecretgrouppage.ClickGroupNameTextBox();
		   Assert.assertTrue(createsecretgrouppage.activeElement().isDisplayed());
		   createsecretgrouppage.ClickSearchTextBox();
		   Assert.assertTrue(createsecretgrouppage.activeElement().isDisplayed());
	   }
	   
	  
	   /*
	   Validate the presence of placeholder in the text box of the Secret Group in create secret group screen. 
	   */
	 /* @Test(priority = 11)
	  public void To_Validate_presence_of_placeholder_in_the_textboxes_of_SecretGroup_in_create_secret_group_screen () {
		  createsecretgrouppage = new CreateSecretGroupScreen(driver);
		   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
		   Assert.assertEquals(createsecretgrouppage.getGroupNameTextBoxPlaceHolder(),"Enter Group Name");
		   Assert.assertEquals(createsecretgrouppage.getSearchTextBoxPlaceHolder(), "Search Contact");
	  }
	  /*
	   validate whether paste option is working on the text boxes of the Secret Group in create secret group screen.
		*/
	  /* @Test(priority = 12)
	   public void To_validate_whether_paste_option_is_working_on_textboxes_of_create_Secret_Group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
		   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
		   createsecretgrouppage.PasteValues_In_GroupNameTextBox("Test");
		   createsecretgrouppage.PasteValues_In_SearchTextBox("check");
		   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"Test");
		   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(), "check");
		   createsecretgrouppage.ClearGroupNameTextBox();
		   createsecretgrouppage.ClearSearchTextBox();  
	   }
	   /*
	   Validate whether able to create secret group without internet connection in create secret group screen.
	   */
	   @Test(priority = 13)
	   public void To_Validate_whether_able_to_create_secret_group_without_internet_connection_in_create_secret_group_screen () throws InterruptedException {
	 	  	
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	   turnOff_Mobile_Wifi();
	 	   Thread.sleep(5000);
	 	    createsecretgrouppage.Set_Values_In_GroupName_Textbox("Test");
	 	    createsecretgrouppage.SelectContact(); 
		 	Thread.sleep(4000);
	 		createsecretgrouppage.ClickCreateButton();
	 	   Assert.assertEquals(Toast(),"Please check your internet connection");
		   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
		   turnOn_Mobile_Wifi();
		   createsecretgrouppage.ClearGroupNameTextBox();
	 	   }
	   /*
	   Validate the text boxes of the Secret Group Functionality using special Characters in create secret group screen.
	   */
	   @Test(priority = 14)
	   public void To_Validate_the_textboxes_of_Secret_Group_using_special_Characters_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	  createsecretgrouppage.Set_Values_In_GroupName_Textbox("@#$%^");
	 	 createsecretgrouppage.Set_Values_In_Search_Textbox("@#$%^&");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"@#$%^");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(),"@#$%^&");
	 	  createsecretgrouppage.ClearGroupNameTextBox();
	 	  createsecretgrouppage.ClearSearchTextBox();
	   }
	   /*
	   Validate the text boxes of the Secret Group Functionality using alphabets both in upper case and lower case in create secret group screen.
	   */
	   @Test(priority = 15)
	   public void To_Validate_the_textboxes_of_Secret_Group_using_alphabets_both_in_uppercase_and_lowercase_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	   createsecretgrouppage.Set_Values_In_GroupName_Textbox("ABCDE");
	 	   createsecretgrouppage.Set_Values_In_Search_Textbox("ABCDE");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"ABCDE");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(),"ABCDE");
	 	   createsecretgrouppage.ClearGroupNameTextBox();
	 	   createsecretgrouppage.ClearSearchTextBox();
	 	   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	   createsecretgrouppage.Set_Values_In_GroupName_Textbox("abcde");
	 	   createsecretgrouppage.Set_Values_In_Search_Textbox("abcde");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"abcde");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(),"abcde");
	 	   createsecretgrouppage.ClearGroupNameTextBox();
	 	   createsecretgrouppage.ClearSearchTextBox();	   
	   }
	   /*
	   Validate the text boxes of the Secret Group Functionality by numerical value in create secret group screen.
	   */
	   @Test(priority = 16)
	   public void To_Validate_the_textboxes_of_Secret_Group_by_numerical_value_in_create_secret_group_screen () {
	 	
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	   createsecretgrouppage.Set_Values_In_GroupName_Textbox("12345");
	 	   createsecretgrouppage.Set_Values_In_Search_Textbox("12345");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"12345");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(),"12345");
	 	   createsecretgrouppage.ClearGroupNameTextBox();
	 	   createsecretgrouppage.ClearSearchTextBox();
	   }
	   /*
	   Validate whether the value entered in the text boxes of the Secret Group is editable and delete-able in create secret group screen.
	   */
	   @Test(priority = 17)
	   public void To_Validate_whether_the_value_entered_in_textboxes_of_SecretGroup_is_editable_and_deleteable_in_create_secret_group_screen () {
		   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	   createsecretgrouppage.Set_Values_In_GroupName_Textbox("Hello");
	 	   createsecretgrouppage.Set_Values_In_Search_Textbox("Hi");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"Hello");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(),"Hi");
	 	   createsecretgrouppage.ClearGroupNameTextBox();
	 	   createsecretgrouppage.ClearSearchTextBox();
	 	   createsecretgrouppage = new CreateSecretGroupScreen(driver);
	 	   Assert.assertEquals(createsecretgrouppage.getPageTitle(),"Secret Group");
	 	   createsecretgrouppage.Set_Values_In_GroupName_Textbox("Check");
	 	   createsecretgrouppage.Set_Values_In_Search_Textbox("Check");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_GroupNameTextBox(),"Check");
	 	   Assert.assertEquals(createsecretgrouppage.get_Values_From_SearchTextBox(),"Check");
	 	   createsecretgrouppage.ClearGroupNameTextBox();
	 	   createsecretgrouppage.ClearSearchTextBox(); 	   
	   }
	   
}
