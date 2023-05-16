package com.saucedemo.framework;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.saucedemo.pages.FormPage;
import com.saucedemo.pages.SubscriptionPage;


public class BaseClass {

	public static WebDriver driver;
	public FormPage form;
	public SubscriptionPage subscription;
	public WebDriverUtils WbUtil;
	public static Logger logger;
	public Properties prop;
	
	public void setup() throws IOException
	{
		
		//Logger
				logger=Logger.getLogger("Sauce Labs"); 
				PropertyConfigurator.configure("log4j.properties");
		
		//Reading properties
		prop=new Properties();
		FileInputStream fis=new FileInputStream("GlobalSettings.properties");
		prop.load(fis);
		
		String br=prop.getProperty("browser");
		
		if(br.contains("chrome"))
		{
			ChromeOptions options= new ChromeOptions();
			if(br.contains("headless"))
			{
				options.addArguments("headless");
			}
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
		driver=new ChromeDriver(options);
		}
		else if (br.contains("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",prop.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static String getScreenshot() {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/target/Screenshots/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(source,destination );
		} catch (IOException e) {
			System.out.println("Capture Failed" + e.getMessage());
		}
		return path;
	}
	
		public static byte[] getByteScreenshot() throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent= FileUtils.readFileToByteArray(src);
		return fileContent;
		
	}
		
		
}
