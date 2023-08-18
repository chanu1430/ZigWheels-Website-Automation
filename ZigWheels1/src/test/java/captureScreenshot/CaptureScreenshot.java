package captureScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CaptureScreenshot extends driverSetup.DriverSetup{

		// TODO Auto-generated method stub
		
		@Test
		public void getScreenshot() throws IOException {
			SimpleDateFormat formatter=new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss");
			Date d=new Date();
			String name=formatter.format(d);
			TakesScreenshot screen=(TakesScreenshot)driver;
			File source=screen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshot/"+name+"_screenshot.png"));
			System.out.println("ScreenshotCaptured is captured. It's location path is: "+source);
			
	}
		
		
	@Test (priority = 2)
	public void exit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
		
		
	
}
