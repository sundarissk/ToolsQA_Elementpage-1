package com.ToolsQa.Qa.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ToolsQa.Qa.Base.DriverManager;

public class ScreenShotUtil extends DriverManager {

	public static void takesshot(String filename) throws IOException {

		// 1.take screenshot and store it as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 2. Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		String despath = System.getProperty("user.dir") + "\\reports\\" + filename + ".png";
		// 3. Location to save screenshot
		File tar = new File(despath + " " + timestamp + ".jpeg");
		// 4. now copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(src, tar);

	}

	public static String getScreenshot(String filename) throws IOException {

		// 1.take screenshot and store it as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 2. Open the current date and time
		// String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new
		// Date());

		// 2. Store path in varibale to use it in report
		String despath = System.getProperty("user.dir") + "\\reports\\" + filename + ".png";
		// 3. Location to save screenshot
		File tar = new File(despath);
		// 4. now copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(src, tar);
		return despath;

	}

}
