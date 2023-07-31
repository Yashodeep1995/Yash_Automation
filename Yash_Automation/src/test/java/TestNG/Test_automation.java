package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_automation {

	public static WebDriver driver;
	
	@BeforeTest
	public void start() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mycarhelpline.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
	}
	@Test(priority=1,enabled=true)
	public void LandingPage() {
		System.out.println(driver.getCurrentUrl());
		String CurentURL="https://www.mycarhelpline.com/";
		
		if(CurentURL.equals("https://www.mycarhelpline.com/")) {
		System.out.println("Test Case LandingPage is PASS");
		
	}else {
			
		System.out.println("TestCase LandingPage is FAIL");
		}
	//ssert.fail("Deliberataly Failing");
	}
	 @Test(priority=2,enabled=true,dependsOnMethods="LandingPage")
	 public void Calculater() throws InterruptedException {
		 driver.findElement(By.linkText("Calculator")).click();
		 Thread.sleep(3000);
	 }
	 
	 @Test(priority=3,enabled=true,dependsOnMethods={"LandingPage","Calculater"})
	 public void ReturntoHomePage() throws InterruptedException {
		 driver.findElement(By.linkText("Home")).click();
		 Thread.sleep(3000);
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 driver.quit();
	 }
	
}
