package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordScreen;
import POM.CreateSecretGroupScreen;
import POM.HomeScreen;
import POM.JoinSocialGroupScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SecretGroupChatScreen;
import POM.SeedScreen;
import POM.SocialGroupChatScreen;
import TestUtiles.baseclass;

public class Join_Social_Group_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	SeedScreen Seedpage;
	RestoreFromSeedScreen restorefromseedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	CreateSecretGroupScreen createsecretgrouppage;
	JoinSocialGroupScreen joinsocialgrouppage;
	SocialGroupChatScreen socialgroupchatpage;
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
			Thread.sleep(5000); 
			homepage.OpenJoinSocialGroup();	
	 }
	 /*
		Validate whether able to navigate back to the Home screen from join social group screen.
		*/
		/*@Test(priority = 1)
		public void To_Validate_whether_able_to_navigate_back_to_home_Screen_from_join_social_group_screen () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.ClickBackArrow();
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.OpenJoinSocialGroup();
		}
		/*
		Validate whether suggested social groups showing in join social group screen.
		*/
		/*@Test(priority = 2)
		public void To_Validate_whether_suggested_social_groups_showing_in_join_social_group_screen () throws InterruptedException {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			Thread.sleep(50000);
			//wait = new  WebDriverWait(driver, Duration.ofMinutes(2));
			//wait.until();
			for(int i =0; i<5 ; i++) {
			Assert.assertTrue(joinsocialgrouppage.get_Element_of_Groups().get(i).isDisplayed());
			}
			
			}
		/*
		Validate whether able to join the groups shown in suggestion in join social group screen.
		*/
		/*@Test(priority = 3)
		public void To_Validate_whether_able_to_join_the_groups_shown_in_suggestion_in_join_social_group_screen () throws InterruptedException {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.JoinBchatGroup();
			socialgroupchatpage = new SocialGroupChatScreen(driver);
			Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"Bchat");
			//Thread.sleep(3000); 
			//socialgroupchatpage.ClickBackArrow();
			driver.navigate().back();
			homepage = new HomeScreen(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.OpenJoinSocialGroup();
		}*/
	 /*
		Validate next option in the Join Social group screen by entering a Invalid URL.
		*/
		/*@Test(priority = 4)
		public void To_Validate_next_option_in_Join_Social_group_screen_by_entering_a_Invalid_URL () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("http://www.bchatgroup");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
			}
		/*
		Validate the next option without entering values in URL text box in join social group screen.
		*/
		/*@Test(priority = 5)
		public void To_Validate_the_next_option_without_entering_values_in_URL_textbox_in_join_social_group_screen () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
		}
		/*
		Validate the presence of placeholder inside the URL text box in join social group screen.
		*/
		/*@Test(priority = 6)
		public void To_Validate_the_presence_of_placeholder_inside_the_URL_textbox_in_join_social_group_screen () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			Assert.assertEquals(joinsocialgrouppage.getSocialGroupURLTextBoxPlaceHolder(), "Enter a social group URL");
		}
		/*
		Validate the next option in the join social group screen with empty space value.
		*/
		/*@Test(priority = 7)
		public void To_Validate_the_next_option_in_join_social_group_screen_with_empty_space_value () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("  ");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(Toast() ,"Invalid URL");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
		}
		/*
		Validate the URL text box of the join social Group using special Characters in join social group screen. 
		*/
		/*@Test(priority = 8)
		public void To_Validate_the_URL_textbox_of_join_socialGroup_using_special_Characters_in_join_social_group_screen () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("@#$%^&");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(Toast() ,"Invalid URL");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
		}
		/*
		 Validate Whether value entered inside URL text box is editable in join social group screen.
		 */
		/*@Test(priority = 9)
		public void To_Validate_Whether_value_entered_inside_URL_textbox_is_editable_in_join_social_group_screen () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("www.Bchat");
			Assert.assertEquals(joinsocialgrouppage.get_Values_From_URLTextBox(),"www.Bchat");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("www.beldex");
			Assert.assertEquals(joinsocialgrouppage.get_Values_From_URLTextBox(),"www.beldex");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
		}
		/*
		Validate the text box of the join social group using numerical values in join social group screen.
		*/
		/*@Test(priority = 10)
		public void To_Validate_the_textbox_of_join_social_group_using_numerical_values_in_join_social_group_screen () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("123456");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
		}
		/*
		Validate the text box of the join social group screen using alphabets both in upper case and lower case. 
		*/
		/*@Test(priority = 11)
		public void To_Validate_the_textbox_of_join_social_group_screen_using_alphabets_both_in_upper_case_and_lower_case () {
			joinsocialgrouppage = new JoinSocialGroupScreen(driver);
			Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("BCHAT");
			Assert.assertEquals(joinsocialgrouppage.get_Values_From_URLTextBox(),"BCHAT");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
			joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("bchat");
			Assert.assertEquals(joinsocialgrouppage.get_Values_From_URLTextBox(),"bchat");
			joinsocialgrouppage.ClickNextButton();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
			joinsocialgrouppage.ClearSocialGroupURLTextBox();
		}*/
	 /*
	 Validate Whether able to paste values in text box in join social group screen.
	 */
	@Test(priority = 12)
	public void To_Validate_Whether_able_to_paste_values_in_textbox_in_join_social_group_screen () {
		joinsocialgrouppage = new JoinSocialGroupScreen(driver);
		Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
		joinsocialgrouppage.Paste_Values_In_URL_TextBox("Paste values");
		Assert.assertEquals(joinsocialgrouppage.get_Values_From_URLTextBox(), "Paste values");
		joinsocialgrouppage.ClearSocialGroupURLTextBox();
	
	}
	/*
	Validate next option in the join social group screen by entering a valid URL. 
	*/
	@Test(priority = 13)
	public void To_Validate_next_option_in_Join_social_group_screen_by_entering_a_valid_URL () {
		joinsocialgrouppage = new JoinSocialGroupScreen(driver);
		Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
		joinsocialgrouppage.Set_Values_In_SocialGroupURL_Textbox("http://social.beldex.io/bchat?public_key=0cfdbcc8bba5989a6787019c6635c08415c103174609360f9c3e4e764ef48073");
		joinsocialgrouppage.ClickNextButton();
		socialgroupchatpage = new SocialGroupChatScreen(driver);
        Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"BChat");
        driver.navigate().back();
        homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenJoinSocialGroup();
	}
	/*
	Validate whether able to join social group without internet connection in the join social group screen.
	*/
	@Test(priority = 14)
	public void To_Validate_whether_able_to_join_social_group_without_internet_connection_in_Join_social_group_screen () throws InterruptedException {
		
		joinsocialgrouppage = new JoinSocialGroupScreen(driver);
		Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		joinsocialgrouppage.JoinMasternodeGroup();
		Assert.assertEquals(Toast(),"Couldn't join social group");
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
	}
	/*
	validate whether cursor blinks while clicking the text box in the join social group screen.
	*/
	@Test(priority = 15)
	public void To_validate_whether_cursor_blinks_while_clicking_the_textbox_in_Join_social_group_screen () {
		joinsocialgrouppage = new JoinSocialGroupScreen(driver);
		Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(), "Social Group");
		joinsocialgrouppage.ClickURLTextBox();
		Assert.assertTrue(joinsocialgrouppage.activeElement().isDisplayed());
	}	
		
}
