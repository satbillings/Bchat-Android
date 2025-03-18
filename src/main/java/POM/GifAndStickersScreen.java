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
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='STICKERS']")
	private WebElement StickersOption;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='STICKERS']")
	private WebElement StickersTitle;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Search']")
	private WebElement SearchPlaceHolder;
	
	@AndroidFindBy(accessibility ="Navigate up")
	private WebElement BackArrow;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/view_grid")
	private WebElement ViewOption;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/view_stream")
	private WebElement AnotherViewOption;
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@resource-id=\"io.beldex.bchat:id/thumbnail\"])[1]")
	private WebElement Gif;
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@resource-id=\"io.beldex.bchat:id/thumbnail\"])[1]")
	private WebElement Stickers;
	
	@AndroidFindBy(id ="//android.widget.EditText[@resource-id=\"io.beldex.bchat:id/search_view\"]")
	private WebElement SearchTextBox;
	
	public void ClickSearchTextBox () {
		SearchTextBox.click();	
	}
	
	
	public String getSearchPlaceHolder() {
		return SearchPlaceHolder.getText();
	}
	
	public void ClickGif () {
		Gif.click();	
	}
	
	public void ClickStickers () {
		Stickers.click();	
	}
	
	public void ClickStickersOption () {
		StickersOption.click();	
	}
	
	public void ClickViewOption () {
		ViewOption.click();	
	}
	
	public void ClickAnotherViewOption () {
		AnotherViewOption.click();	
	}
	
	public void ClickBackArrow () {
		BackArrow.click();	
	}
	
	
	public String getGifTitle() {
		return GifTitle.getText();
	}
	
	public String getStickersTitle() {
		return StickersTitle.getText();
	}

}
