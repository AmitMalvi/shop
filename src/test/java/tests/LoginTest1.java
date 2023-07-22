package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest1 extends BaseClass {	
	
	@Test
	void loginTest() throws InterruptedException {
		System.out.println("Login Test Started Executing...");		
		driver.findElement(By.linkText("LOG IN")).click();
		WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver -> driver.findElement(By.xpath("//*[@id='login-form']/div/div/div[1]/h2")));
		String strActual = ele.getText();
		//System.out.println("print text : "+strActual);
		String strExpected = "LOGIN";
		assertEquals(strActual,strExpected);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("62868326");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@id='send2']/span/span")).click();
		String strActualAfterlogin =driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[1]/div[1]/div[1]/p")).getText();		
		String strExpectedAfterlogin ="WELCOME, TEST1 DISTRIBUTOR ID (62868326)";
		assertEquals(strActualAfterlogin, strExpectedAfterlogin);
		System.out.println("Login Success");
		System.out.println("Login Test Ended...");
	}
	
	@Test
	void logoutTest() {
		System.out.println("Logout Test Started Executing...");
		WebElement logoutelement = driver.findElement(By.xpath("//*[@id='alogout']"));
		assertEquals(logoutelement.getText(), "LOG OUT");
		logoutelement.click();
		System.out.println("Logout successful");
		System.out.println("Logout Test Ended...");
	}
	
}
