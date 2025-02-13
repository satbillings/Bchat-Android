package TestUtiles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public abstract class ActionsClass {
public AndroidDriver driver;

public ActionsClass(AndroidDriver driver) {
		
		this.driver=driver;
		
	}

	
	
	public void scrollgesture_Using_text(String point) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+point+"\"));"));	
	}
 
	
	public void scrollgesture_Using_WebElement(WebElement Element) {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) Element).getId(),
						"direction", "down",
					    "percent", 1.0));
	}

	
	public void scroll_the_page (int left,int top, int height ,String direction) {
	
		boolean canScrollMore;
		do 
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	    "left", left, "top", top, "width", 200, "height", height,
	    "direction", direction,
	    "percent", 3.0	    
	));
		}while(canScrollMore); 
	}
	public void click(WebElement button) {
		button.click();
	}
	

	@SuppressWarnings("deprecation")
	public String Toast() {
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		return toastmsg;
		
		
	}
	public void longPress(WebElement Element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) Element).getId(),
				"duration",2000));
		}

	
public  static String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		
		File Source= driver.getScreenshotAs(OutputType.FILE);
		String Destination= System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(Source,new File(Destination));
		return Destination;
	}

public void doubleClick(WebElement Element) {
	((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", 
			ImmutableMap.of("elementId", ((RemoteWebElement) Element).getId(),
			"duration",10000));
	}

public void Copy_And_Paste_Values(String text,WebElement Element) {
	
	driver.setClipboardText(text);
 	 Element.sendKeys(driver.getClipboardText());
	
}


 public void swipeGesture(int left,int top, int width,int height,String direction){ 
	 // Java
	 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction",direction,
			    "percent", 1.0
			));
 }
 

	

public void Send_keys(WebElement element,String string) {
	Actions actions =new Actions(driver);
	actions.moveToElement(element).sendKeys(string).perform();
	driver.hideKeyboard();
}

public boolean isClickable(WebElement Element) {
    return Element.getAttribute("clickable").equals("true");
}

public boolean isLongClickable(WebElement Element) {
    return Element.getAttribute("long-clickable").equals("true");
}

public WebElement activeElement() {
	 WebElement result = driver.switchTo().activeElement();
	return result;
}

public void clearClipboard() {
driver.getClipboardText();

}

public void Android_Key_Enter () {
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
}

public void clickGesture (int x, int y) {
	// Java
	driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			"x", x, "y", y
	    
	));
}


/*
 * public void swipeGesture(WebElement Element, String direction) {
 * ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
 * ImmutableMap.of( "elementId", ((RemoteWebElement)Element).getId(),
 * "direction", direction,"percentage",0.75)); // TODO Auto-generated method
 * stub
 * 
 * }
 */
 

}
