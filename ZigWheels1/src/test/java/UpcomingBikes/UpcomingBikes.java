package UpcomingBikes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import driverSetup.DriverSetup;

//import Main.Main;

public class UpcomingBikes extends driverSetup.DriverSetup {
	public static Actions act;


	@Test (priority = 1)
	public void newBikes() {
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='New Bikes']"))).build().perform();
		
	}
	@Test (priority = 2)
	public void upcomingBikes() {
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Upcoming Bikes']"))).build().perform();
		driver.findElement(By.xpath("//span[text()='Upcoming Bikes']")).click();
	}
	@Test (priority = 3)
	public void bikeCompany() {
		Select select= new Select(driver.findElement(By.id("makeId")));
		select.selectByVisibleText("Honda");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			driver.findElement(By.xpath("//span[text()='View More Bikes ']")).click();
			Thread.sleep(1000);
			}
		
		catch(Exception e) {
			WebElement firstResult1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modelList']/li[18]/span")));
			driver.findElement(By.xpath("//*[@id='modelList']/li[18]/span")).click();
			
			//System.out.println("Not working");
			}
	}
	@Test (priority = 4)
	public void upcomingBikesData() {
		
		List<WebElement> upcomingBikes=driver.findElements(By.cssSelector("div.fnt-15"));
		List<WebElement> bikeNames=driver.findElements(By.cssSelector("strong.lnk-hvr"));
		List<WebElement> bikeLaunchDate=driver.findElements(By.xpath("//div[contains(text(),'Launch Date')]"));
		for(int i=0;i<upcomingBikes.size();i++) {
			WebElement e1=upcomingBikes.get(i);
			String[] price=e1.getText().split(" ");
			String p=price[1];
//			Double d= Double.parseDouble(p);
//			Double d1=4.00;
//			if(d<d1) {
//				WebElement e2=bikeNames.get(i);
//				WebElement e3=bikeLaunchDate.get(i);
//				System.out.println(e2.getText());
//				System.out.println(e1.getText());
//				System.out.println(e3.getText());
//			}
			
			if(price.length==2) {
				WebElement e2=bikeNames.get(i);
				WebElement e3=bikeLaunchDate.get(i);
				System.out.println(e2.getText());
				System.out.println(e1.getText());
				System.out.println(e3.getText());
				System.out.println("_______________________________________________________________________________________________________________________");
				
			}
				
			else if( price.length==3 ) {
				Double d= Double.parseDouble(p);
				//	System.out.println(d.getClass().getName());
				Double d1=4.00;
				if((d<d1)) {
				WebElement e2=bikeNames.get(i);
				WebElement e3=bikeLaunchDate.get(i);
				System.out.println(e2.getText());
				System.out.println(e1.getText());
				System.out.println(e3.getText());
				System.out.println("_______________________________________________________________________________________________________________________");
				
				}
			}
		}
	}
	
	@Test (priority = 5)
	public void navigateBack() {
		driver.navigate().back();
		driver.navigate().back();
	}

}
