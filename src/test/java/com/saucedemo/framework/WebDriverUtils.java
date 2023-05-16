package com.saucedemo.framework;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtils{

	private static WebDriver driver;
	
	public WebDriverUtils(WebDriver driver){
		this.driver = driver;
	}
	
//	Explicit wait
	public static void waitUntilElementVisble(By by, long timeOutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

//	Explicit wait
	public static void waitUntilElementEnabled(By by, long timeOutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	//Refresh
	public static void refreshPage() {
	    driver.navigate().refresh();
	}
	//Execute java sript code
	public static Object executeScript(String script) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    return js.executeScript(script);
	}
	
//	entering text 
	public static void enterInTextBox(By elementAddress, String text) throws Exception {
		    waitUntilElementVisble(elementAddress, 20);
			driver.findElement(elementAddress).clear();
			Thread.sleep(2000);
			driver.findElement(elementAddress).sendKeys(text);
	}
	
	//integer text
	public static void enterInTextBoxWithNo(By elementAddress, CharSequence[] text) throws Exception {
		    waitUntilElementVisble(elementAddress, 20);
			driver.findElement(elementAddress).clear();
			Thread.sleep(100);
			driver.findElement(elementAddress).sendKeys(text);
	}
	
	//tab

	public static void tabKey() throws Exception
	{
	
	Robot robot = new Robot();
	// Simulate key Events
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	//Enter
	public static void enterKey() throws Exception
	{
	
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(200);
	}

//for clicking button
		public static void ClickButton(By elementAddress) 
		{ 
			waitUntilElementEnabled(elementAddress, 20);
			driver.findElement(elementAddress).click();
		}
		
		public static By getByIdentifier(String xpathText, String identifyBy) {
			By identifier;
			if (identifyBy.equalsIgnoreCase("id")) {
				identifier = By.id(xpathText);
			} else {
				identifier = By.xpath(xpathText);
			}
			return identifier;

		}
		
		public static WebElement findElement( By locator) {
		    return driver.findElement(locator);
		}
		public static List<WebElement> findElements( By locator) {
		    return  driver.findElements(locator);
		}
		//Switch to iframe
		public static void switchToIframe( String iframeId) {
		    try {
		        driver.switchTo().frame(iframeId);
		        System.out.println("Switched to iframe with id: " + iframeId);
		    } catch (NoSuchFrameException e) {
		        System.out.println("Iframe with id " + iframeId + " not found.");
		    }
		}
		// Switch back to default frame
		public static void switchtoDefaultFrame()
		{
			driver.switchTo().defaultContent();
		}
		
//		to verify element present
		public static boolean verifyElementPresent(By elementAddress, String elementName) throws Throwable {
			WebElement e = null;
			boolean found = false;
			try {
				waitUntilElementVisble(elementAddress, 10);
				e = driver.findElement(elementAddress);
			    found = e.isDisplayed();
				System.out.println(elementName + " is displayed");
			} catch (Exception exc) {
				System.out.println(elementName + " is NOT displayed");
				throw new Exception();
			}

			return found;
		}

//		to focus on element
		public static void setFocusOnElement(By identifier, String elementName) {
			WebElement element = null;
			try {
				element = driver.findElement(identifier);
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
			} catch (Exception e) {
				System.out.println("Unable to focus on element " + elementName);
			}
		}
		
		public static void click(By identifier) {
			
//			WebElement element = driver.findElement(By.xpath("//*[@id='selectbox']/option[2]"));
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", element);
			
			
			WebElement al = driver.findElement(By.xpath("//*[@id='selectbox']/option[2]"));
//			Actions builder = new Actions(driver);
//            builder.moveToElement(al).click().build().perform();
            
			
	//	System.out.println(al.getText());	
			
            al.click();
			
		}
		public static void Click(By identifier)
		{
			WebElement element = driver.findElement(identifier);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}
		
		
		public static String GetText(By identifier)
		{
			WebElement element = driver.findElement(identifier);
		  String   text= element.getText();
		    System.out.println("Text is:-"+text);
		    return text;
		}
		
		//Hover over Mouse
		public static void hoverOveronElement(By identifier, String elementName) {
			WebElement element = null;
			try {
				element = driver.findElement(identifier);
				Actions builder = new Actions(driver);
                Action mouseOverHome = builder.moveToElement(element).build();
			} catch (Exception e) {
				System.out.println("Unable to focus on element " + elementName);
			}
		}
		
		// Mouse click
				public static void mouseClick(By identifier, String elementName) {
					WebElement element = null;
					try {
						element = driver.findElement(identifier);
						Actions builder = new Actions(driver);
						builder.moveToElement(element).click();
					} catch (Exception e) {
						System.out.println("Unable to click on element " + elementName); 
					}
				}
		
		//Page down
		public static void pageDown() 
		{
			 Actions at = new Actions(driver);
		      at.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
		//Page Up
				public static void pageUp() 
				{
					 Actions at = new Actions(driver);
				      at.sendKeys(Keys.PAGE_UP).build().perform();
				}
				
				//Scroll bottom of page
				public static void ScrollBottomPage() 
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				}
				
				//Escape
				public static void escape() 
				{
					Actions action = new Actions(driver); 
					action. sendKeys(Keys. ESCAPE).build().perform();
				}
		//Scroll down to element
				public static void scrollDown(WebElement contactForm) 
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
				     js.executeScript("arguments[0].scrollIntoView();", contactForm);
				}
		
		public static boolean checkElementPresentWithString(String elementAddress, String elementName) throws Throwable {
			WebElement e = null;
			boolean found = false;
			try {
				e = driver.findElement(By.xpath(elementAddress));
			    found = e.isDisplayed();
				System.out.println(elementName + "element is displayed");
			} catch (Exception exc) {
				System.out.println(elementName + "element is NOT displayed");
			}

			return found;
		}
		
		/*	public static Boolean verifyPageTitle(String expectedTitle) throws Exception {
		String actualTitle = driver.getTitle();
		if (!actualTitle.contentEquals(expectedTitle)) {
			System.out.println("User is not logged into page title "+actualTitle);
			throw new Exception();
		}else{
			System.out.println("User successfully logged into page title "+actualTitle);
		}
		return true;
	}*/

		
		//Selecting Dropdowns with loops
		public static void selectOptionFromDropdown(WebElement ele, String value)
		{
			Select drp=new Select(ele);
			List<WebElement>alloptions=drp.getOptions();
			for(WebElement option:alloptions)
			{
				if(option.getText().equals(value))
				{
					option.click();
					break;
				}
			}
		}
		
		public static void selectByValue(By by, String value) {

            WebElement ele = driver.findElement(by);

            boolean flag = false;

            int time = 1;

            do {

                  try {

                        Select select = new Select(ele);

                        select.selectByValue(value);

                        if (!(flag = select.getOptions()

                              .get(Integer.valueOf(driver.findElement(by).getAttribute("selectedIndex"))).getAttribute("value")

                                    .equals(value))) {

                              try {

                                    Thread.sleep(1000);

                              } catch (InterruptedException e) {

                              }

                              flag = select.getOptions().get(Integer.valueOf(driver.findElement(by).getAttribute("selectedIndex")))

                                          .getAttribute("value").equals(value);

                        }

                  } catch (ElementNotVisibleException e) {

                        try {

                              Thread.sleep(1000);

                        } catch (InterruptedException e1) {

                        }

                  }

            } while (!flag && ++time < 5);

      }

	


}
