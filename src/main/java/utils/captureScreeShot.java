package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseClass.browserSelection;

public class captureScreeShot extends browserSelection{
	
	//CLASS TO TAKE SCREENSHOT
	static takeExcelData takeData = new takeExcelData();
  	public static String failedTCSS(String testMethodName) throws IOException {  
  		//System.out.println("SS block start");
  		Date currentdate = new Date();
  		String screenShotName = currentdate.toString().replace(" ", "-").replace(":", "-");	
  		File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  		File dest = new File(takeData.readExcelFile("testData", 4, 1)+testMethodName+"-"+screenShotName+"_FAILED.png");
  		FileUtils.copyFile(scrShot, dest);
  		return dest.getAbsolutePath();
  		//System.out.println("SS block end");
  	}

}
