package com.saucedemo.pages;

import org.openqa.selenium.Keys;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.saucedemo.framework.WebDriverUtils;

import ch.qos.logback.core.util.Duration;

public class FormPage
{
	public WebDriver driver;
	public FormPage(WebDriver driver2) 
	{
		this.driver=driver;
	}
	
	

	
	
	//Here defining the locators
	public static final By SelectScentPath1 = By.xpath("//select[@id='selectbox']");
	public static final By firstNameTextBox = By.xpath("//input[@id='First Name']");
	public static final By lastNameTextBox = By.xpath("//input[@id='Last Name']");
	public static final By mailIdTextBox = By.xpath("//input[@id='email']");
	public static final By phoneNumTextBox = By.xpath("//input[@id='phone']");
	public static final By cityTextBox = By.xpath("//input[@id='city' and @name='city']");
	public static final By stateTextBox = By.xpath("//input[@id='state']");
	public static final By zipTextBox = By.xpath("//input[@id='zip code']");
	public static final By commentTextBox = By.xpath("//textarea[@id='LEADCF40']");
	public static final By checkCaptcha = By.xpath("//span[@id='recaptcha-anchor']");
	public static final By SubmitButton = By.xpath("//input[@id='formsubmit']");
	public static final By iframe_by_title =By.xpath("//iframe[@title='reCAPTCHA']");
	
	public void selectScentFromDD(String SelectScent) throws Throwable
	{
		WebDriverUtils.ClickButton(SelectScentPath1);
		Thread.sleep(10000);
		WebDriverUtils.escape();
		
		
		WebDriverUtils.click(By.xpath("//select[@id='selectbox']/option"));
//		List<WebElement> SelectScentPaths=driver.findElements(By.xpath("//*[@id='selectbox']/option"));
//		for (WebElement option : SelectScentPaths) {
//			System.out.println(option.getText());
//		}
//		SelectScentPaths.get(2).click();
//		WebDriverUtils.selectOptionFromDropdown(SelectScentPaths, SelectScent);
//		Thread.sleep(5000);
//		WebDriverUtils.setFocusOnElement(SelectScentPath, SelectScent);
//		Thread.sleep(5000);
//		WebDriverUtils.ClickButton(SelectScentPath);
//		Thread.sleep(5000);
//		driver.findElement(SelectScentPath).sendKeys(SelectScent);
//		WebDriverUtils.selectByValue(SelectScentPath, SelectScent);
//		WebElement textbox = driver.findElement(By.xpath("//option[@value='-None-']"));
//		textbox.sendKeys(Keys.ARROW_DOWN);
//		WebDriverUtils.enterKey();
//		Select se = new Select(driver.findElement(By.xpath("//div[@class='contact-form__block contact-form__block--']//select")));
//		se.selectByVisibleText(SelectScent);
	}
	
	public void enterFirstName(String fName) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(firstNameTextBox, 10);
		WebDriverUtils.enterInTextBox(firstNameTextBox,fName);
		}
	public void enterLastName(String lName) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(lastNameTextBox, 10);
		WebDriverUtils.enterInTextBox(lastNameTextBox,lName);
		}
	
	public void enterMailId(String mail) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(mailIdTextBox, 10);
		WebDriverUtils.enterInTextBox(mailIdTextBox,mail);
		}
	
	public void enterphoneNum(String phoneNum) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(phoneNumTextBox, 10);
		WebDriverUtils.enterInTextBox(phoneNumTextBox,phoneNum);
		}
	
	public void enterDetails(String city, String state, String zip) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(cityTextBox, 10);
		WebDriverUtils.enterInTextBox(cityTextBox,city);
		WebDriverUtils.waitUntilElementEnabled(stateTextBox, 10);
		WebDriverUtils.enterInTextBox(stateTextBox,state);
		WebDriverUtils.waitUntilElementEnabled(zipTextBox, 10);
		WebDriverUtils.enterInTextBox(zipTextBox,zip);
		}
	public void enterComments(String comment) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(commentTextBox, 10);
		WebDriverUtils.enterInTextBox(commentTextBox,comment);
		Thread.sleep(5000);
		WebDriverUtils.tabKey();
		Thread.sleep(5000);
		WebDriverUtils.enterKey();
		}
	
	public void clickOnCaptcha() throws Throwable 
	{		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,3);
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
		 * "//iframe[@title='reCAPTCHA']")));
		 * (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//span[@id='recaptcha-anchor']")))).click();
		 */
//		System.out.println("inside method");
//		Thread.sleep(5000);
//		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
		
		System.out.println("Outside Frame");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Size of iframe is:-"+size);
		
//		WebDriverUtils.hoverOveronElement(checkCaptcha, "checkCaptcha");
//		System.out.println("mouse hover done");
		
//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
		
//		  WebElement iframe_by_title=driver.findElement(By.xpath("(//div[@id='recaptcha']//iframe)[1]"));
//		  driver.switchTo().frame(7);
//		  System.out.println("inside Frame");
//		  Thread.sleep(5000);
////		  System.out.println(driver.getTitle()); 
//		  WebDriverUtils.ClickButton(checkCaptcha);
		 
		Thread.sleep(1000);
		}
	
	public void clickOnSubmit() throws Throwable 
	{		
		
		WebDriverUtils.ClickButton(SubmitButton);
		}
	
}