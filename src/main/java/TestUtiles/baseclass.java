package TestUtiles;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import POM.OpeningPage;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class baseclass {
    public AndroidDriver driver;
	
	//public AppiumDriverLocalService service ;
	
	 public OpeningPage Openingpage;
	 
	
	
	
	
	@BeforeClass
	public void Configure() throws InterruptedException, IOException, URISyntaxException {
		
		
		/*
		 * service = new AppiumServiceBuilder().withAppiumJS(new File(
		 * "C://Users//satbi//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"
		 * )).withIPAddress("127.0.0.1").usingPort(4723) .build(); service.start();
		 */
		 
		    
		 //   String path = System.getProperty("user.dir")+"\\reports\\index.html";
		 
		 //cap.setBrowserName(System.getProperty("user.dir")+"//Resources//General-Store.apk");
		//try {
			UiAutomator2Options options = new UiAutomator2Options();
			
			options.setCapability("appium:automationName", "UiAutomator2");	
			 options.setCapability("appium:deviceName", "OnePlus Nord CE 3 Lite 5G");		 
			 options.setCapability("appium:platformName","Android");
			 options.setCapability("appium:platformVersion","14");
			 //options.setCapability("appium:newCommandTimeout","30000");

			options.setCapability("udid","ad5c6257");
			//options.setCapability("noReset", "true");

			 options.setCapability("appium:ignoreHiddenApiPolicyError", true);
			//options.setCapability("appium:fullReset",true);
			 options.setCapability("appium:autoGrantPermissions", true);
			// options.setCapability("enforceXPath1",true);
				options.setApp(System.getProperty("user.dir")+"\\Resources\\Bchat-2.6.4-arm64-v8a-feature-gif.apk");
			
		  	 options.setCapability("appium:appPackage", "io.beldex.bchat");	
		  	 options.setCapability("appium:appActivity", "io.beldex.bchat.RoutingActivity");	

			 //For To wait until the landing screen activity comes 
			 //options.setCapability("appium:appWaitActivity", "com.thoughtcrimes.securesms.onboarding.LandingActivity"); 
			 //options.setCapability("autoLaunch", true);
			 
				
			 
			 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
			 //private static AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				

				  
					Openingpage =new OpeningPage(driver);
		
	}
		/*
		 * catch(Exception E) { try { UiAutomator2Options options = new
		 * UiAutomator2Options();
		 * 
		 * options.setCapability("appium:automationName", "UiAutomator2");
		 * options.setCapability("appium:deviceName", "BUTOZHAUWKWWTGEM");
		 * options.setCapability("appium:platformName","Android");
		 * options.setCapability("appium:platformVersion","10");
		 * //options.setCapability("udid","BUTOZHAUWKWWTGEM");
		 * //options.setCapability("noReset", "true");
		 * 
		 * options.setCapability("appium:ignoreHiddenApiPolicyError", true);
		 * //options.setCapability("appium:fullReset",true);
		 * options.setCapability("appium:autoGrantPermissions", true);
		 * options.setApp(System.getProperty("user.dir")+
		 * "\\Resources\\General-Store.apk");
		 * 
		 * options.setCapability("appium:appPackage", "io.beldex.bchat"); //For To wait
		 * until the landing screen activity comes
		 * options.setCapability("appium:appWaitActivity",
		 * "com.thoughtcrimes.securesms.onboarding.LandingActivity");
		 * //options.setCapability("autoLaunch", true);
		 * 
		 * 
		 * 
		 * driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		 * //private static AppiumDriver driver = new AndroidDriver(new
		 * URL("http://127.0.0.1:4723"), options);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 * 
		 * Openingpage =new OpeningPage(driver);
		 * 
		 * }
		 */
		/*
		 * catch(Exception E1) { E1.printStackTrace(); }
		 */    
	
	public List<HashMap<String ,String>> getjsonFile(String filepath) throws IOException {
		//Json file to json string
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+filepath),StandardCharsets.UTF_8);
		
		//json string to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap<String,String>> data= mapper.readValue(jsoncontent, new TypeReference <List<HashMap<String,String>>> (){
			
		});
		
		return data;
		
	}

@SuppressWarnings("deprecation")
public String Toast() {
	
	String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	return toastmsg;
	
	
}
	  @AfterClass 
	  public void closeApp() {
		  
	         driver.quit();
	         //service.stop(); 
	 }
	  public void turnOff_Mobile_Wifi () {
			
			 driver.openNotifications();
			//driver.findElement(By.id("com.android.systemui:id/hl_tile_one_holder")).click();
			driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='android:id/icon'])[1]")).click();
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				    "left", 350, "top", 2345, "width", 100, "height", 1345,
				    "direction", "Up",
				    "percent", 0.75
				));
		}

		public void turnOn_Mobile_Wifi () {
			
			 driver.openNotifications();
			//driver.findElement(By.id("com.android.systemui:id/hl_tile_one_holder")).click();
			driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='android:id/icon'])[1]")).click();
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				    "left", 350, "top", 2345, "width", 100, "height", 1345,
				    "direction", "Up",
				    "percent", 0.75
				));
		}
		
		@SuppressWarnings("deprecation")
		public void restrictNotification () {
			// Navigate to Apps & notifications
            driver.findElement(By.xpath("//android.widget.TextView[@text='Apps & notifications']")).click();

            // Select the app you want to restrict notifications for
            driver.findElement(By.xpath("//android.widget.TextView[@text='BChat']")).click();

            // Navigate to Notifications
            driver.findElement(By.xpath("//android.widget.TextView[@text='Notifications']")).click();

            // Turn off notifications
            WebElement toggle = driver.findElement(By.id("android:id/switch_widget"));
            if (toggle.getAttribute("checked").equals("true")) {
                toggle.click();
            }
			
		}

	


}

