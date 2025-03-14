package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import TestUtiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GifAndStickersScreen extends ActionsClass {
	AndroidDriver driver;
	public GifAndStickersScreen(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='GIFS']")
	private WebElement GifTitle;
	
	@AndroidFindBy(accessibility ="Navigate up")
	private WebElement BackArrow;
	
	public void ClickBackArrow () {
		BackArrow.click();	
	}
	
	
	public String getGifTitle() {
		return GifTitle.getText();
	}

}
