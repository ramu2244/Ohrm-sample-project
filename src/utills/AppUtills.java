package utills;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class AppUtills {

	public static WebDriver driver;  
//@SuppressWarnings("deprecation")
@Parameters({"url"})
@BeforeTest
	public static void launchApp(String url){
 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
 driver = new ChromeDriver();
 driver.manage().deleteAllCookies();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 driver.get(url);
 }
//@AfterSuite
public static void closeApp(){
	
	driver.close();
	

	 
 }
 }

