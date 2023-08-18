package LoginSetup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import UsedCars.UsedCars;

public class LoginSetup extends driverSetup.DriverSetup{
	public String first;
	@Test (priority = 1)
	public void signup() {
		driver.findElement(By.id("des_lIcon")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test (priority = 2)
	public void signUpUsingGoogle() {
		WebElement firstResult1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Google']")));
		driver.findElement(By.xpath("//span[text()='Google']")).click();
	}
	@Test (priority = 3)
	public void switchingWindow() {
		first=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		while(itr.hasNext()) {
			
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle()+"..............");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Test (priority = 4)
	public void emailLogin() {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vsahsvhdsb@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	@Test (priority = 5)
	public void errorCapture() {
		driver.manage().window().maximize();
		String errorMsg=driver.findElement(By.xpath("//div[@class='o6cuMc Jj6Lae']")).getText();
		System.out.println(errorMsg);
	}
	
	
	
}
