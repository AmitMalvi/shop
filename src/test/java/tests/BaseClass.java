package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	String url = "https://shop.myvestige.com/";
	
	@BeforeTest
	void setup(){
		WebDriverManager.chromedriver().setup();
		ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
		driver = new ChromeDriver(service);
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println(url+" link opened.");
	}	

	@AfterTest
	void teardown() {	
		driver.quit();
		System.out.println("Driver Quit");
	}
	
}
