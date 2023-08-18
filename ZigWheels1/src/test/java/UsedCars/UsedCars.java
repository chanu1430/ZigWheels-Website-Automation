package UsedCars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import UpcomingBikes.UpcomingBikes;
import driverSetup.DriverSetup;

public class UsedCars extends driverSetup.DriverSetup{
	public static Actions act;
	
	@Test (priority = 1)
	public void usedCars() {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Used Cars']"))).build().perform();
		
	}
	@Test (priority = 2)
	public void usedCarsLocation() {
		driver.findElement(By.xpath("//span[@city='Chennai']")).click();
	}
	@Test (priority = 3)
	public void usedCarsData() {
		List<WebElement>usedCarsName=driver.findElements(By.xpath("//a[@data-track-label='Car-name']"));
		List<WebElement>usedCarsPrice=driver.findElements(By.cssSelector("span.zw-cmn-price"));
		
		System.out.println(usedCarsName.size());
		for(int i=0;i<usedCarsName.size();i++) {
			WebElement c1=usedCarsName.get(i);
			WebElement c2=usedCarsPrice.get(i);
			System.out.println(c1.getText());
			System.out.println(c2.getText());
			System.out.println("_______________________________________________________________________________________________________________________");
			
		}
	}
	
	
	@Test (priority = 4)
	public void back() {
		driver.navigate().back();
	}


}


//<class name="captureScreenshot.CaptureScreenshot"/>
