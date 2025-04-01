package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatScreen;
import POM.CreatePasswordScreen;
import POM.GifAndStickersScreen;
import POM.HomeScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SecretGroupChatScreen;
import POM.SecretGroupInfoScreen;
import POM.SeedScreen;
import POM.SocialGroupChatScreen;
import TestUtiles.baseclass;

public class Secret_Group_Info_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;		
	RestoreFromSeedScreen restorefromseedpage;
	SeedScreen seedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	ChatScreen chatpage;
	SecretGroupInfoScreen secretgroupinfopage;
    SecretGroupChatScreen groupchatpage;
	WebDriverWait wait;
	
	@Test(priority = 0)
   	public void PreSetup() throws InterruptedException {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Openingpage = new OpeningPage(driver); 
		 Openingpage.clickSignIn(); 
		 seedpage = new SeedScreen(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.pasteSeedValue(); 
		seedpage.clickNext(); 
		restorefromseedpage = new RestoreFromSeedScreen(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.paste_Value_In_DisplayName("Sathish");
		restorefromseedpage.paste_Value_In_Blockheight("4000000");
		restorefromseedpage.clickBtnRestore(); 
		createpasswordpage = new CreatePasswordScreen(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		 createpasswordpage.PasswordSuccessfullPopupOkButtonClick();
		 homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		Thread.sleep(59000);
		homepage.ClickFirstContactorGroup();
	}
	
	/* Validate whether member count of the group is showing correctly in Secret group info screen */
	
	/*@Test(priority = 1)
	public void To_validate_whether_members_count_of_the_group_is_showing_correctlyin_secret_group_info_screen () throws InterruptedException {
		groupchatpage = new SecretGroupChatScreen(driver);
		//Assert.assertEquals(groupchatpage.getGroupChatTitle(),"AndroidtoAndroidGroup");
	    Thread.sleep(5000);
		groupchatpage.ClickGroupTopBar();
		secretgroupinfopage = new SecretGroupInfoScreen(driver);
        Assert.assertEquals(secretgroupinfopage.getGroupInfoScreenTitle(),"Group Info");
        Assert.assertEquals(secretgroupinfopage.getMemberList(),"2 members");
	}
	
/* Validate whether members of the group are showing in Secret group info screen 
 * Validate whether group admin name is showing in the top of the member list in Secret group info screen
 * */
	
	/*@Test(priority = 2)
	public void To_validate_whether_members_of_the_group_are_showing_in_secret_group_info_screen_To_validate_whether_group_admin_name_is_showing_in_the_top_of_the_member_list_in_Secret_group_info_screen () throws InterruptedException {
		secretgroupinfopage = new SecretGroupInfoScreen(driver);
        Assert.assertEquals(secretgroupinfopage.getGroupInfoScreenTitle(),"Group Info");
        secretgroupinfopage.scrollgesture_Using_text("Android");
        Assert.assertTrue(secretgroupinfopage.ShowMember1().isDisplayed());
        Assert.assertTrue(secretgroupinfopage.ShowMember2().isDisplayed());
	}
	
	/* Validate whether the Search Members screen is showing by clicking the search icon in Secret group info screen */
	/*@Test(priority = 3)
	public void To_validate_whether_the_Search_Members_screen_is_showing_by_clicking_the_search_icon_in_secret_group_info_screen () throws InterruptedException {
		secretgroupinfopage = new SecretGroupInfoScreen(driver);
        Assert.assertEquals(secretgroupinfopage.getGroupInfoScreenTitle(),"Group Info");
        secretgroupinfopage.ClickSearchIcon();
        Assert.assertEquals(secretgroupinfopage.getSearchMembersScreenTitle(),"Search Members");
	}

	/* Validate the working of Back arrow in Search Members screen */
	/*@Test(priority = 4)
	public void To_validate_the_working_of_Back_arrow_in_Search_Members_screen () throws InterruptedException {
		secretgroupinfopage = new SecretGroupInfoScreen(driver);
        Assert.assertEquals(secretgroupinfopage.getSearchMembersScreenTitle(),"Search Members");
        secretgroupinfopage.ClickBackArrowInSearchMembersScreen();
        Assert.assertEquals(secretgroupinfopage.getGroupInfoScreenTitle(),"Group Info");
	}*/
	
	/* Validate whether cursor blinks inside the search text box in secret group info screen */
	 @Test(priority = 5)
	public void To_validate_whether_cursor_blinks_inside_the_search_textbox_in_secret_group_info_screen () throws InterruptedException {
		groupchatpage = new SecretGroupChatScreen(driver);
		//Assert.assertEquals(groupchatpage.getGroupChatTitle(),"AndroidtoAndroidGroup");
	    Thread.sleep(5000);
		groupchatpage.ClickGroupTopBar();
		secretgroupinfopage = new SecretGroupInfoScreen(driver);
        Assert.assertEquals(secretgroupinfopage.getGroupInfoScreenTitle(),"Group Info");
        secretgroupinfopage.ClickSearchIcon();
        Assert.assertEquals(secretgroupinfopage.getSearchMembersScreenTitle(),"Search Members");
        secretgroupinfopage.ClickEnterNameTextBox();
		Assert.assertTrue(secretgroupinfopage.activeElement().isDisplayed());
        
	}
	
  /* Validate the presence of placeholder inside the search text box in secret group info screen */
	 @Test(priority = 6)
	public void To_validate_presence_of_placeholder_inside_the_search_textbox_in_secret_group_info_screen () throws InterruptedException {
	   secretgroupinfopage = new SecretGroupInfoScreen(driver);
       Assert.assertEquals(secretgroupinfopage.getSearchMembersScreenTitle(),"Search Members");
	   Assert.assertEquals(secretgroupinfopage.getEnterNamePlaceholder(),"Enter name");
	     
	 }
	 
	 /* Validate the search text box in Secret group info screen by entering the empty space value */
	 
	    @Test(priority = 7)
		public void To_validate_the_search_textbox_in_secret_group_info_screen_by_entering_the_empty_space_value () throws InterruptedException {
		secretgroupinfopage = new SecretGroupInfoScreen(driver);
        Assert.assertEquals(secretgroupinfopage.getSearchMembersScreenTitle(),"Search Members");
		secretgroupinfopage.Set_Values_In_EnterName_textbox("        ");
		secretgroupinfopage.Clear_EnterName_textbox();
	 }
	    
	 /* Validate the search text box in Secret group info screen by entering the special character 
	  * Validate whether the value entered in the search text box of Secret group info screen is editable and delete-able. 
	  * */
	    
	      @Test(priority = 8)
	  	  public void To_validate_the_search_textbox_in_secret_group_info_screen_by_entering_the_special_characters_To_validate_whether_the_value_entered_in_search_text_box_of_Secret_group_info_screen_is_editable_deletable () throws InterruptedException {
	  	  secretgroupinfopage = new SecretGroupInfoScreen(driver);
	      Assert.assertEquals(secretgroupinfopage.getSearchMembersScreenTitle(),"Search Members");
	  	  secretgroupinfopage.Set_Values_In_EnterName_textbox("!@#$%^&*()_+=");
	  	  secretgroupinfopage.Clear_EnterName_textbox();
	  	 }   
}
