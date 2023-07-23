package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	String url = "https://shop.myvestige.com/";
	
	@BeforeTest
	void setup(){
		WebDriverManager.chromedriver().setup();
		//ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setBinary("/usr/bin/google-chrome");
        options.addArguments("--headless");		
		
		driver = new ChromeDriver(options);
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
