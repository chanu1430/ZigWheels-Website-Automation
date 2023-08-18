package Main;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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


public class Main {
	
	public static Actions act;
	public static Properties prop;
	public static WebDriver driver;
	public static String first;
	@BeforeSuite
	public void getConfigData() throws IOException {
		prop= new Properties();
		String file=System.getProperty("user.dir");
		InputStream f=new FileInputStream(file+"/src/test/resources/configuration/config.properties");
		prop.load(f);
	}
	@Test (priority = 1)
	public void driverSetup() {
		DriverSetup d= new DriverSetup();
		d.setDriver(prop.getProperty("browserName"));
		driver=d.getDriverSetup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test (priority = 2)
	public void websiteNavigation() {
		driver.get(prop.getProperty("websiteLink"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Navigated to thye website successfully");
	}
	
	
	
	
	


//

	
}


