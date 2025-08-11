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
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='GIFS']")
	private WebElement GifsOption;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='STICKERS']")
	private WebElement StickersOption;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='STICKERS']")
	private WebElement StickersTitle;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Search']")
	private WebElement SearchPlaceHolder;
	
	@AndroidFindBy(accessibility ="Navigate up")
	private WebElement BackArrow;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/view_grid")
	private WebElement ViewOption;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/view_stream")
	private WebElement AnotherViewOption;
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@resource-id=\"io.beldex.bchat:id/thumbnail\"])[1]")
	private WebElement Gif;
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@resource-id=\"io.beldex.bchat:id/thumbnail\"])[2]")
	private WebElement Gif2;
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@resource-id=\"io.beldex.bchat:id/thumbnail\"])[1]")
	private WebElement Stickers;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@resource-id=\"io.beldex.bchat:id/search_view\"]")
	private WebElement SearchTextBox;
	
	@AndroidFindBy(xpath ="(//android.widget.ImageView[@content-desc='Media message'])[3]")
	private WebElement GifMediaMessage;
	
	@AndroidFindBy(accessibility ="Forward")
	private WebElement ForwardOption;
	
	@AndroidFindBy(xpath ="(//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/nameTextView\" and @text=\"grppp\"]")
	private WebElement ContactorGroupInForwardScreen;
	
	public void ClickSearchTextBox () {
		SearchTextBox.click();	
	}
	
	public void Set_Values_In_Search_textbox (String value) {
		SearchTextBox.sendKeys(value);
		}
	
	public void ClearSearchTextBox () {
		SearchTextBox.clear();	
	}
	
	public void Paste_Values_In_Search_TextBox (String value) {
		Copy_And_Paste_Values(value, SearchTextBox);
	}
	
	public String getSearchPlaceHolder() {
		return SearchPlaceHolder.getText();
	}
	
	public String getValuesFromSearchTextBox() {
		return SearchTextBox.getText();
	}
	
	public void ClickGif () {
		Gif.click();	
	}
	public void ClickGif2 () {
		Gif2.click();	
	}
	
	
	public void ClickStickers () {
		Stickers.click();	
	}
	
	public void ClickStickersOption () {
		StickersOption.click();	
	}
	
	public void ClickGifsOption () {
		GifsOption.click();	
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
