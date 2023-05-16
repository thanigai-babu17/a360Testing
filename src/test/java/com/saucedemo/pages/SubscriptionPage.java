package com.saucedemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

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
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.log.SysoCounter;
import com.saucedemo.framework.WebDriverUtils;

import ch.qos.logback.core.util.Duration;

public class SubscriptionPage
{
	public WebDriver driver;
	
	

	
	
	//Here defining the locators
	public static final By searchBar =By.xpath("//div[@class='header__icon-list']//a[@href='/search']");
	public static final By productInSearchBar =By.xpath("//input[@class='predictive-search__input']");
	public static By productToSelect=null;
	public static By currencyToSelect=null;
	public static By product_NameBy=null;
	public static String product_Name1 = null;
	public static final By product_Name=By.xpath("//div[@class='product__info']//h1");
	//public static final By sub_RadioBtn=By.xpath("//input[@id='rc-radio1']");
	public static final By sub_RadioBtn=By.xpath("(// input[@type='radio' and @class='prive_input_radio'])[2]");
	public static final By product_MRP=By.xpath("//span[@id='prive_price_elem']//s");
	public static final By priceAfter_Discount=By.xpath("//span[@id='prive_price_elem']/following-sibling::span");
	public static final By actual_DiscPercent=By.xpath("//div[@class='product-meta__label-list prive-label-list label-list']//span[@class='label label--highlight']");
	public static final By product_title = By.xpath("//h1[contains(@class, 'product-meta__title')]");
//	public static final By OneTimePurchase_RadioBtn = By.xpath("//input[@id='rc-radio2']");
	public static final By OneTimePurchase_RadioBtn = By.xpath("(// input[@type='radio' and @class='prive_input_radio'])[1]");
	public static final By currency_DropdownBtn = By.xpath("//button[@aria-controls='footer-currency-selector']");
	public static final By currency_list = By.xpath("//button[@name='country_code']");
	public static final By frame_InHomePage = By.xpath("//iframe[@id='attentive_creative']");
	public static final By close_HomeFrame = By.xpath("//button[@id='closeIconContainer']");
	
	public SubscriptionPage(WebDriver driver2) 
	{
		this.driver=driver;
	} 
	
	public void clickOnSearch() throws Throwable 
	{		
		System.out.println(searchBar);
		WebDriverUtils.waitUntilElementEnabled(searchBar, 5);
		
		WebDriverUtils.Click(searchBar);
		}
	
	public void enteringValuesOnSearchBar(String productName) throws Throwable 
	{		
		WebDriverUtils.waitUntilElementEnabled(productInSearchBar, 10);
		WebDriverUtils.enterInTextBox(productInSearchBar, productName);
		}
	public void selectProduct(String productName) throws Throwable 
	{		
		productToSelect=WebDriverUtils.getByIdentifier("//span[normalize-space()='"+productName+"']", "xpath");
		WebDriverUtils.waitUntilElementVisble(productToSelect, 10);
		WebDriverUtils.Click(productToSelect);
		}
	
		/*
		 * public void selectCurrency(String currency) throws Throwable { //WebElement
		 * IFrame = WebDriverUtils.findElement(frame_InHomePage);
		 * //System.out.println(IFrame); WebElement element =
		 * WebDriverUtils.findElement(By.id("attentive_creative"));
		 * if(element.isDisplayed()) { //driver.switchTo().frame(IFrame);
		 * WebDriverUtils.switchToIframe("attentive_creative");
		 * WebDriverUtils.Click(close_HomeFrame);
		 * System.out.println("Inside the Frame");
		 * WebDriverUtils.switchtoDefaultFrame();
		 * System.out.println("Default Framework");
		 * //driver.switchTo().defaultContent(); Thread.sleep(1000);
		 * WebDriverUtils.ScrollBottomPage();
		 * WebDriverUtils.Click(currency_DropdownBtn); // // List<WebElement>
		 * currencyList= WebDriverUtils.findElements(currency_list); // for(WebElement
		 * currency1:currencyList ){ // if(currency1.getText().trim().equals(currency))
		 * //currency1.click(); Thread.sleep(1000);
		 * WebDriverUtils.findElement(By.xpath("//button[@value='"+currency+"']")).click
		 * (); Thread.sleep(500); } else { Thread.sleep(1000);
		 * WebDriverUtils.ScrollBottomPage();
		 * WebDriverUtils.Click(currency_DropdownBtn); Thread.sleep(1000);
		 * WebDriverUtils.findElement(By.xpath("//button[@value='"+currency+"']")).click
		 * (); Thread.sleep(500); } }
		 * 
		 * 
		 */	
		/*
		 * public void selectOneTimePurchase_RadioBtn() throws Throwable { try {
		 * WebElement
		 * oneTimePurchaseBtn=WebDriverUtils.findElement(OneTimePurchase_RadioBtn);
		 * if(oneTimePurchaseBtn.isDisplayed()) {
		 * //WebDriverUtils.verifyElementPresent(OneTimePurchase_RadioBtn,
		 * "OneTimePurchase_RadioBtn"); WebDriverUtils.Click(OneTimePurchase_RadioBtn);
		 * } else { System.out.println("One Time Radio button is Not Present"); } }
		 * catch (NoSuchElementException e) {
		 * System.out.println("One Time Radio button is Not Present"); } }
		 */
	
	public void selectCurrency(String currency) throws Throwable 
	{
	    List<WebElement> frames = WebDriverUtils.findElements(By.id("attentive_creative"));
	    if(!frames.isEmpty())
	    {
	        WebDriverUtils.switchToIframe("attentive_creative");
	        WebDriverUtils.Click(close_HomeFrame);
	        System.out.println("Inside the Frame");
	        WebDriverUtils.switchtoDefaultFrame();
	        System.out.println("Default Framework");
	        Thread.sleep(1000);
	        WebDriverUtils.ScrollBottomPage();
	        WebDriverUtils.Click(currency_DropdownBtn);
	        Thread.sleep(1000);
	        WebDriverUtils.findElement(By.xpath("//button[@value='"+currency+"']")).click();
	        Thread.sleep(500);
	    }
	    else
	    {
	        Thread.sleep(1000);
	        WebDriverUtils.ScrollBottomPage();
	        WebDriverUtils.Click(currency_DropdownBtn);
	        Thread.sleep(1000);
	        WebDriverUtils.findElement(By.xpath("//button[@value='"+currency+"']")).click();
	        Thread.sleep(1000);
	    }
	} 

	
	
	public void selectOneTimePurchase_RadioBtn() throws Throwable {
	    try {
	        boolean found = false;
	        WebElement element = WebDriverUtils.findElement(By.xpath("//div[@id='rc-how-it-works']"));
	        if (element.isDisplayed() && (element.getCssValue("display").equals("block") || element.getCssValue("display").equals("none"))) {
	            if (element.getCssValue("display").equals("block")) {
	                found = true;
	                WebDriverUtils.Click(OneTimePurchase_RadioBtn);
	            }
	        }
	        if (!found) {
	            System.out.println("One Time Radio button is Not Present");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("One Time Radio button is Not Present");
	    }
	}

	public void SubscriptionIsChecked() throws Throwable 
	{		
		try {
	        boolean found = false;
	        WebElement element = WebDriverUtils.findElement(By.xpath("//div[@id='rc-how-it-works']"));
	        if (element.isDisplayed() && (element.getCssValue("display").equals("block") || element.getCssValue("display").equals("none"))) {
	            if (element.getCssValue("display").equals("block")) {
	                found = true;
	                WebElement radioBtn=WebDriverUtils.findElement(sub_RadioBtn);
	                if (radioBtn.isSelected())
	                	 System.out.println("The Subscription radio button is selected");
	            }
	        }
	        if (!found) {
	            System.out.println("Subscription button is Not Present");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Subscription button is Not Present");
	    }
	}
	
	/*
	 * public void SubscriptionIsChecked() throws Throwable {
	 * WebDriverUtils.waitUntilElementEnabled(sub_RadioBtn, 10); WebElement
	 * radioBtn=WebDriverUtils.findElement(sub_RadioBtn); // Check if the radio
	 * button is selected or not if (radioBtn.isSelected()) {
	 * System.out.println("The Subscription radio button is selected"); } else {
	 * System.out.println("The One Time Purchase radio button is  selected"); } }
	 */
	
	
	/*
	 * public void validateJSON(String Product_Name1, String variant) throws
	 * Throwable {
	 * 
	 * String
	 * Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).
	 * getText()).trim());
	 * Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[$,R,]", "");
	 * System.out.println("Price of Product after discount is:-"
	 * +Product_DiscountedPrice);
	 * System.out.println("Nmae of Product is:-"+Product_Name1); // Locate the
	 * element that contains the JSON-LD data // WebElement script =
	 * WebDriverUtils.findElement(By.xpath(
	 * "(//script[@type='application/ld+json'])[1]"));
	 * 
	 * String script =
	 * "return document.querySelector(\"script[type='application/ld+json']\").textContent;"
	 * ; String jsonString = (String) WebDriverUtils.executeScript(script);
	 * System.out.println(jsonString); JSONObject json = new JSONObject(jsonString);
	 * JSONArray offersArray = json.getJSONArray("offers"); // JSONObject firstOffer
	 * = offersArray.getJSONObject(0); // String price =
	 * firstOffer.getString("price"); // // System.out.println(price); for (int i =
	 * 0; i < offersArray.length(); i++) { JSONObject offer =
	 * offersArray.getJSONObject(i);
	 * 
	 * //Get the name and price of the black variant if
	 * (offer.getString("name").equalsIgnoreCase(variant)) { String productName =
	 * json.getString("name"); String price = offer.getString("price");
	 * 
	 * //Print the product name and price
	 * System.out.println("Product Name in the Script is : " + productName);
	 * System.out.println("Price in the Script is : " + price);
	 * 
	 * Assert.assertEquals(Product_Name1,productName,
	 * " Name of the in the front end is:- "
	 * +Product_Name1+" Name of the Product in the Script is :- "+productName);
	 * Assert.assertEquals(Product_DiscountedPrice,price,
	 * " Price of the in the front end is:- "
	 * +Product_DiscountedPrice+" Price of the Product in the Script is :- "+price);
	 * 
	 * break; }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
	public void validateJSON(String Product_Name1,String variant1) throws Throwable 
	{
	    

	    String script = "return document.querySelector(\"script[type='application/ld+json']\").textContent;";
	    String jsonString = (String) WebDriverUtils.executeScript(script);
	    System.out.println(jsonString);

	    JSONObject json = new JSONObject(jsonString);
	    JSONArray offersArray = json.getJSONArray("offers");

	    List<WebElement> variantList = WebDriverUtils.findElements(By.xpath("//label[@class='block-swatch__item']"));
	    int size = variantList.size();
	    for (int j=1;j<=size;j++) 
	    {
	    	
		    
	    	 String variantName=WebDriverUtils.findElement(By.xpath("(//label[@class='block-swatch__item'])["+j+"]")).getText();
	    	 System.out.println("Variant selected now is:- "+variantName);
	    	//WebElement element= WebDriverUtils.findElement(By.xpath("(//label[@class='block-swatch__item'])['"+j+"']"));
	    	WebDriverUtils.Click(By.xpath("(//label[@class='block-swatch__item'])["+j+"]"));
	    	Thread.sleep(1000);
	    	String Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
		    Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[$,R,]", "");
		    System.out.println("Price of Product after discount is:-"+Product_DiscountedPrice);
		    System.out.println("Name of Product is:-"+Product_Name1);
           
	        for (int i = 0; i < offersArray.length(); i++) 
	        {
	            JSONObject offer = offersArray.getJSONObject(i);

	            if (offer.getString("name").equalsIgnoreCase(variantName)) 
	            {
	                String productName = json.getString("name");
	                String price = offer.getString("price");

	                System.out.println("Product Name in the Script is : " + productName);
	                System.out.println("Price in the Script is : " + price);

	                Assert.assertEquals(Product_Name1, productName,  " Name of the in the front end is:- "+Product_Name1+" Name of the Product in the Script is :- "+productName);
	                Assert.assertEquals(Product_DiscountedPrice, price,  " Price of the in the front end is:- "+Product_DiscountedPrice+" Price of the Product in the Script is :- "+price);

	                break;
	            }
	        }
	    }
	}

	public void validate_MultipleJSON(String Product_Name1) throws Throwable 
	{
		 // Extract data from the first script
	    WebElement script1 = WebDriverUtils.findElement(By.xpath("//script[@type='application/ld+json']"));
	    JSONObject jsonObject = new JSONObject(script1.getAttribute("innerHTML"));
	    String productName = jsonObject.getString("name");
	    System.out.println("productName  "+productName);
	    // Extract data from the second script for specific products
	    JSONArray offers = jsonObject.getJSONArray("offers");
	    WebElement script2 = WebDriverUtils.findElement(By.tagName("script"));
	    String scriptText = script2.getAttribute("innerHTML");
	    
	    
	    
	    List<WebElement> variantList = WebDriverUtils.findElements(By.xpath("//label[@class='block-swatch__item']"));
	    int size = variantList.size();
	    for (int j=1;j<=size;j++) 
	    {
	    	
		    
	    	 String variantName=WebDriverUtils.findElement(By.xpath("(//label[@class='block-swatch__item'])["+j+"]")).getText();
	    	 System.out.println("Variant selected now for Subscribed Product is :- "+variantName);
	    	//WebElement element= WebDriverUtils.findElement(By.xpath("(//label[@class='block-swatch__item'])['"+j+"']"));
	    	WebDriverUtils.Click(By.xpath("(//label[@class='block-swatch__item'])["+j+"]"));
	    	Thread.sleep(500);
	    	String Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
		    Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[$,R,]", "");
		    System.out.println("Price of Product after discount is:-"+Product_DiscountedPrice);
		    System.out.println("Name of Product is:-"+Product_Name1);
	    
	    

	    for (int i = 0; i < offers.length(); i++) 
	    {
	    	String productVariant = offers.getJSONObject(i).getString("name");
	        String productUrl = offers.getJSONObject(i).getString("url");
	        if (productVariant.equals(variantName))
	        {
	        String[] urlParts = productUrl.split("=");
	        String productId = urlParts[urlParts.length - 1];
	        if (productVariant.equals(variantName))
	        System.out.println("productId:- "+productId);
	        

	       	    }
	    }
	    }
}
    
	
	
	public void validateProductName(String productName ) throws Throwable 
	{		
		Thread.sleep(200);
		
		// WebDriverUtils.waitUntilElementVisble(product_NameBy, 0);
		//product_NameBy=WebDriverUtils.getByIdentifier("//h1[contains(@class, 'product-meta__title')]", "xpath");
		// WebElement product_title = driver.findElement(By.xpath("//h1[contains(@class, 'product-meta__title')]"));
		String ActualProduct_Name=WebDriverUtils.findElement(product_title).getText();
		//WebDriverUtils.waitUntilElementVisble(product_Name, 10);
		//WebDriverUtils.GetText(product_title);
		//String ActualProduct_Name=driver.findElement(product_Name).getText();
		System.out.println("Actual name of the product is:-"+ActualProduct_Name);
		Assert.assertEquals(ActualProduct_Name, productName,"Actual Product name in Product page is :-"+ActualProduct_Name+" and Expected name of the product is :-"+productName);
		
		}
	
		/*
		 * public void SubscriptionIsChecked() throws Throwable {
		 * WebDriverUtils.waitUntilElementEnabled(sub_RadioBtn, 10); // WebElement
		 * radioBtn = driver.findElement(By.xpath("//input[@id='rc-radio1']"));
		 * WebElement radioBtn=WebDriverUtils.findElement(sub_RadioBtn); //to calculate
		 * the actual discount breakup String
		 * ActualProduct_Price=((WebDriverUtils.findElement(product_MRP).getText()).trim
		 * ()); ActualProduct_Price=ActualProduct_Price.replaceAll("[$,R,]", "");
		 * System.out.println("Actual Price of Product is:-"+ActualProduct_Price);
		 * String
		 * Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).
		 * getText()).trim());
		 * Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[$,R,]", "");
		 * System.out.println("Price of Product after discount is:-"
		 * +Product_DiscountedPrice); double n1=Double.parseDouble(ActualProduct_Price);
		 * double n2=Double.parseDouble(Product_DiscountedPrice); // Check if the radio
		 * button is selected or not if (radioBtn.isSelected()) {
		 * System.out.println("The Subscription radio button is selected"); float
		 * Subscription_discountPercent=0.3f;// Subscription discount is of 30% int
		 * Subscription_discount=(int)(n1*(1-Subscription_discountPercent));
		 * System.out.println("Price after Subscription discount is:- "
		 * +Subscription_discount); float Sitewide_DiscountPercent=0.3f;// Sitewide
		 * discount is of 30% int
		 * Sitewide_Discount=(int)(Subscription_discount*(1-Sitewide_DiscountPercent));
		 * String Site_wide_Discount = String.format("%d",Sitewide_Discount);
		 * System.out.println("Price after Site wide discount is:- "+Site_wide_Discount)
		 * ; Assert.assertEquals(Product_DiscountedPrice,Site_wide_Discount,
		 * "Price after Discount displayed is:-"+n2+
		 * "and discount expected is:-"+Sitewide_Discount); } else {
		 * System.out.println("The Subscription radio button is not selected"); //In one
		 * time Purchase there will be only sitewide discount float
		 * Sitewide_DiscountPercent=0.3f;// Sitewide discount is of 30% double
		 * Sitewide_Discount=(double)(n1*(1-Sitewide_DiscountPercent)); String
		 * round_Sitewide_Discount1=String.format("%.3f", Sitewide_Discount); double
		 * n3=Double.parseDouble(round_Sitewide_Discount1); String
		 * round_Sitewide_Discount=String.format("%.2f", n3); // String
		 * Site_wide_Discount = String.format("%d",Sitewide_Discount);
		 * System.out.println("Price after Site wide discount is:- "
		 * +round_Sitewide_Discount);
		 * Assert.assertEquals(Product_DiscountedPrice,round_Sitewide_Discount,
		 * "Price after Discount displayed is:-"+n2+
		 * "and discount expected is:-"+Sitewide_Discount); } }
		 */
	
	
	public void validatePrice() throws Throwable 
	{
		Thread.sleep(500);
		//String ActualProduct_Price=driver.findElement(product_MRP).getText();//replaceAll("$,R,", ""));
		String ActualProduct_Price=((WebDriverUtils.findElement(product_MRP).getText()).trim());
		ActualProduct_Price=ActualProduct_Price.replaceAll("[^\\d]", "");
		System.out.println("Actual Price of Product is:-"+ActualProduct_Price);
		//String Product_DiscountedPrice=driver.findElement(priceAfter_Discount).getText();
		String Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
		Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[^\\d]", "");
		System.out.println("Price of Product after discount is:-"+Product_DiscountedPrice);
	//	 int intVal1 = Integer.parseInt(ActualProduct_Price.trim());
		int n1=Integer.parseInt(ActualProduct_Price);
		int n2=Integer.parseInt(Product_DiscountedPrice);
		int sub=n1-n2;
		double per=((double)sub/n1);
		double expected=per*100;
		int expected_price;
		 if (expected % 5 >= 2.5) {
		        expected_price = ((int) Math.ceil(expected / 5.0)) * 5;
		    } else {
		        expected_price = ((int) Math.floor(expected / 5.0)) * 5;
		    }
		//int expected_price = Math.round((float)expected/ 5.0f) * 5;
		//int expected_price = ((int)(expected/5.0)) * 5;
		//int expected_price=(int)expected;//"%.0f",
		String expected_PricePercent = String.format("%d",expected_price);
		//System.out.println("expected_Price"+expected_Price);
		//String expected_PricePercent=String.valueOf(expected_Price);
		System.out.println("Expected discount percentage is:-"+expected_PricePercent);
		String ActualProduct_DiscountPercent=WebDriverUtils.findElement(actual_DiscPercent).getText();
		System.out.println("Actual Discount for the Product is:-"+ActualProduct_DiscountPercent);
		Assert.assertEquals(ActualProduct_DiscountPercent, "SAVE "+expected_PricePercent+"%", "Discount displayed is:-"+ActualProduct_DiscountPercent+ "and discount expected is:-"+expected_PricePercent);
		
		
	}
	
	public void productApi() throws Throwable 
	{
		 ObjectMapper mapper = new ObjectMapper();
	        JsonNode rootNode = mapper.readTree(new File("ProductApi.json"));

	        // Traverse through the JSON tree to get the title of each product
	        JsonNode productsNode = rootNode.get("products");
	        JsonNode edgesNode = productsNode.get("edges");
	        for (JsonNode edgeNode : edgesNode) {
	            JsonNode node = edgeNode.get("node");
	            String title = node.get("title").asText();
	            System.out.println(title);
	            
	}
	}
	public void validateMerchantAPIData(String MRP, String SP) throws Throwable 
	{
		String ActualProduct_Price=((WebDriverUtils.findElement(product_MRP).getText()).trim());
		ActualProduct_Price=ActualProduct_Price.replaceAll("[$,R,]", "");
		System.out.println("Actual Price of Product is:-"+ActualProduct_Price);
	String Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
    Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[$,R,]", "");
    System.out.println("Price of Product after discount is:-"+Product_DiscountedPrice);
    Assert.assertEquals(ActualProduct_Price, MRP,  " Price of the in the front end is:- "+ActualProduct_Price+" Price of the Product in the Micro Data Script is :- "+MRP);
    Assert.assertEquals(Product_DiscountedPrice, SP,  " Price of the in the front end is:- "+Product_DiscountedPrice+" Price of the Product in the Micro Data Script is :- "+SP);
	}
	public String getPrice() throws Throwable {
	    String ActualProduct_Name = WebDriverUtils.findElement(product_title).getText();

	    System.out.println("Actual name of the product is:-" + ActualProduct_Name);
	    String ActualProduct_Price = ((WebDriverUtils.findElement(product_MRP).getText()).trim());
	    ActualProduct_Price = ActualProduct_Price.replaceAll("[$,R,]", "");
	    System.out.println("Actual Price of Product is:-" + ActualProduct_Price);
	    String Product_DiscountedPrice = ((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
	    Product_DiscountedPrice = Product_DiscountedPrice.replaceAll("[$,R,]", "");
	    System.out.println("Price of Product after discount is:-" + Product_DiscountedPrice);
	    
	    // Return a string that contains the actual product name, price, and discounted price
	    return ActualProduct_Name + "," + ActualProduct_Price + "," + Product_DiscountedPrice;
	}

	
	
	public void validateJSONAndMerchantAPIData(String variant1) throws Throwable 
	{
	    

	    String script = "return document.querySelector(\"script[type='application/ld+json']\").textContent;";
	    String jsonString = (String) WebDriverUtils.executeScript(script);
	    System.out.println(jsonString);

	    JSONObject json = new JSONObject(jsonString);
	    JSONArray offersArray = json.getJSONArray("offers");

	    
	    	
		    
	    	 String variantName=WebDriverUtils.findElement(By.xpath("(//label[contains(text(),'"+variant1+"')])")).getText();
	    	 System.out.println("Variant selected now is:- "+variantName);
	    	String Product_DiscountedPrice=((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
		    Product_DiscountedPrice=Product_DiscountedPrice.replaceAll("[$,R,]", "");
		    System.out.println("Price of Product after discount is:-"+Product_DiscountedPrice);
           
	        for (int i = 0; i < offersArray.length(); i++) 
	        {
	            JSONObject offer = offersArray.getJSONObject(i);

	            if (offer.getString("name").equalsIgnoreCase(variantName)) 
	            {
	                String productName = json.getString("name");
	                String price = offer.getString("price");

	                System.out.println("Product Name in the Script is : " + productName);
	                System.out.println("Price in the Script is : " + price);

	                Assert.assertEquals(Product_DiscountedPrice, price,  " Price of the in the front end is:- "+Product_DiscountedPrice+" Price of the Product in the Micro Data Script is :- "+price);

	                break;
	            }
	        
	    }
	}
}