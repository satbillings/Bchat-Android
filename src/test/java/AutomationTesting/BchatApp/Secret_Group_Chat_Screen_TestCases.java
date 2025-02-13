package AutomationTesting.BchatApp;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatScreen;
import POM.CreatePasswordScreen;
import POM.HomeScreen;
import POM.JoinSocialGroupScreen;
import POM.OpeningPage;
import POM.RestoreFromSeedScreen;
import POM.SecretGroupChatScreen;
import POM.SeedScreen;
import POM.SocialGroupChatScreen;
import TestUtiles.baseclass;

public class Secret_Group_Chat_Screen_TestCases extends baseclass {
	OpeningPage Openingpage;
	SeedScreen Seedpage;
	RestoreFromSeedScreen restorefromseedpage;
	CreatePasswordScreen createpasswordpage;
	HomeScreen homepage;
	WebDriverWait wait;
    SecretGroupChatScreen groupchatpage;
    ChatScreen chatpage;
    SocialGroupChatScreen socialgroupchatpage;
    JoinSocialGroupScreen joinsocialgrouppage;
    
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
		Thread.sleep(40000); 
		//wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		//homepage.ClickFirstContactorGroup();
		//homepage.ClickSecondContactorGroup();
    }
    /*
	Validate working of remove member from group in secret group chat screen 
	*/
	/*@Test(priority = 1)
	public void To_validate_working_of_remove_member_from_group_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Groupchat");
		groupchatpage.RemoveMemberFromGroup();
		Assert.assertEquals(groupchatpage.getRemovedMemberContent(), "You removed Testapk from the group");
	} 
	/*
	Validate the whether able to add new member in secret group chat screen  
	*/
	/*@Test(priority = 2)
	public void To_Validate_the_whether_able_add_new_member_in_secret_group_chat_screen () throws InterruptedException {
			groupchatpage = new SecretGroupChatScreen(driver);
			Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Groupchat");
			groupchatpage.AddMemberToGroup();
			Assert.assertEquals(groupchatpage.getAddedMemberContent(), "You added Testapk to the group");
	}
	/*
	Validate whether able to change the group name in secret group chat screen
	*/
	/*@Test(priority = 3)
	public void To_validate_whether_able_to_change_the_group_name_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Groupchat");
		groupchatpage.ChangeGroupName("Test");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
	}
	/*
	Validate whether able to set group name without value in secret group chat screen
	*/
	/*@Test(priority = 4)
	public void To_validate_whether_able_to_set_group_name_without_value_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.ChangeGroupName("  ");
		Assert.assertEquals(Toast(), "Group name can't be empty");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
	}
	
	/*
	Validate whether able to set group with already existing name in secret group chat screen
	*/
	/*@Test(priority = 5)
	public void To_Validate_whether_able_to_set_group_with_already_existing_name_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.ChangeGroupName("Test");
		Assert.assertEquals(Toast(), "Please enter a different name");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");	
	}
	/*
	Validate the working of cancel option inside the all popups in secret group chat screen
	*/
	/*@Test(priority = 6)
	public void To_Validate_the_working_of_cancel_option_inside_all_popups_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.ClickCancelButtonInLeaveGroupPopup();
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.ClickCloseIconInNotificationSettingsPopup();
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.ClickCloseIconInEditGroupcreen();
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
	}*/
    /*
	Validate the working of the both option Notification settings of the menu bar in secret group chat screen.
	*/
	/*@Test(priority = 7)
	public void To_Validate_the_working_of_both_option_Notification_settings_of_menu_bar_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.SetMentionsOptionInNotificationSettingsPopup();
		groupchatpage.ClickBackArrow();
		homepage = new HomeScreen(driver);
		Assert.assertTrue(homepage.getMentionsMuteIcon().isDisplayed());
		homepage.ClickFirstContactorGroup();
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.SetAllOptionInNotificationSettingsPopup();
	}
	/*
	Validate whether able to send message in secret group chat screen.
	*/
	/*@Test(priority = 8)
	public void To_Validate_whether_able_to_send_message_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.Set_Values_In_Message_textbox("Hii");
		groupchatpage.ClickSendButton();
		Assert.assertTrue(groupchatpage.getMessageStatus().isDisplayed());
		//groupchatpage.delete_Send_Message();
	}
	/*
	validate whether able to send voice message in secret group chat screen.
	*/
	/*@Test(priority = 9)
	public void To_validate_whether_able_to_send_voice_message_in_secret_group_chat_screen () throws InterruptedException {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
	    groupchatpage.Record_Voice_Msg();
	    groupchatpage.ClickSendButton();
	    Assert.assertTrue(groupchatpage.getMessageStatus().isDisplayed());
	  // groupchatpage.delete_Send_Message();
	}
	/*
	validate whether able to send attachments in secret group chat screen.
	*/
	/*@Test(priority = 10)
	public void To_validate_whether_able_to_send_attachments_in_secret_group_chat_screen () throws InterruptedException {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
	    groupchatpage.SendImage();
		Assert.assertTrue(groupchatpage.getMessageStatus().isDisplayed());		
	}*/
    /*
    Validate whether able to set group name with space in between values in secret group chat screen.
    */
	/*@Test(priority = 11)
	public void To_validate_whether_able_to_set_group_name_with_space_in_between_values_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(),"Test");
		groupchatpage.ChangeGroupName("Group Name");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "Group Name");
	}
	/*
    Validate whether able to set group name with numerical values in secret group chat screen.
    */
	/*@Test(priority = 12)
    public void To_validate_whether_able_to_set_group_name_with_numerical_values_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "Group Name");
		groupchatpage.ChangeGroupName("12345");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "12345");
		
	}
	/*
    Validate whether able to set group name with special characters in secret group chat screen.
    */
	/*@Test(priority = 13)
	public void To_validate_whether_able_to_set_group_name_with_special_characters_in_secret_group_chat_screen () {
		groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "12345");
		groupchatpage.ChangeGroupName("!@#$%");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "!@#$%");
	}
	/*
    Validate whether able to set group name with mixed values in secret group chat screen.
    */
    /*@Test(priority = 14)
    public void To_Validate_whether_able_to_set_group_name_with_mixed_values_in_secret_group_chat_screen () {
    	groupchatpage = new SecretGroupChatScreen(driver);
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "!@#$%");
		groupchatpage.ChangeGroupName("Test@12345678");
		Assert.assertEquals(groupchatpage.getGroupChatTitle(), "Test@12345678");
    }
    /*
    Validate the presence of placeholder in group name text box in secret group chat screen.
    Validate whether cursor blinks while clicking the group name text box in secret group chat screen.
    */
   /* @Test(priority = 15)
    public void To_validate_the_presence_of_placeholder_in_group_name_textbox_To_validate_whether_cursor_blinks_while_clicking_the_group_name_textbox_in_secret_group_chat_screen(){
    	groupchatpage = new SecretGroupChatScreen(driver);
    	Assert.assertEquals(groupchatpage.getGroupChatTitle(), "Test@12345678");
    	groupchatpage.ClearGroupNameText();
    	Assert.assertEquals(groupchatpage.getGroupNamePlaceHolder(),"Enter a new group name");
    	Assert.assertTrue(groupchatpage.activeElement().isDisplayed());
        groupchatpage.ClickApplyChangesButton();
    }
    /*
    Validate the working of leave group in secret group chat screen.
   	*/
	/*@Test(priority = 16)
	public void To_validate_the_working_of_leave_group_in_secret_group_chat_screen () throws InterruptedException {
		groupchatpage = new SecretGroupChatScreen(driver);
    	Assert.assertEquals(groupchatpage.getGroupChatTitle(), "Test@12345678");
    	groupchatpage.LeaveGroup();
    	homepage = new HomeScreen(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat"); 
		homepage.ClickFirstContactorGroup();
		groupchatpage = new SecretGroupChatScreen(driver);
    	Assert.assertEquals(groupchatpage.getGroupChatTitle(), "Test@12345678");
    	Assert.assertTrue(groupchatpage.getLeaveGroupContent().isDisplayed());
    	groupchatpage.ClickBackArrow();
	}*/
	/*
    Validate the working of the community guidelines in social group chat screen
    */
    @Test(priority = 17)
    public void To_Validate_the_working_of_community_guidelines_in_social_group_chat_screen () {
    	homepage.OpenJoinSocialGroup();
    	joinsocialgrouppage = new JoinSocialGroupScreen(driver);
        Assert.assertEquals(joinsocialgrouppage.getJoinSocialGroupScreenTitle(),"Social Group");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	joinsocialgrouppage.JoinBchatGroup();
    	socialgroupchatpage = new SocialGroupChatScreen(driver);
        Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"Bchat");
    	socialgroupchatpage.Open_Community_Guidelines();
    	Assert.assertEquals(socialgroupchatpage.Community_Guidelines_Screen_Title(), "Community Guidelines");
    	socialgroupchatpage.ClickBackArrow();
    	//driver.navigate().back();
        Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"Bchat");
    }
    /*
    Validate the working of add member in social group chat screen
    */
	@Test(priority = 18)
	public void To_validate_the_working_of_add_member_in_social_group_chat_screen () {
		socialgroupchatpage = new SocialGroupChatScreen(driver);
        Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"Bchat");
        socialgroupchatpage.AddMembers();
        Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"Bchat");
	}
	/*
	 Validate whether member count showing in social group chat screen.
	 */
   @Test(priority = 19)
   public void To_Validate_whether_member_count_showing_in_social_group_chat_screen () {
	    socialgroupchatpage = new SocialGroupChatScreen(driver);
       	Assert.assertEquals(socialgroupchatpage.getSocialGroupChatTitle(),"Bchat");
		Assert.assertNotEquals(socialgroupchatpage.get_Member_Count(),0);
   }
}
