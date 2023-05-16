package com.saucedemo.stepdefinitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.Scenario;







import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.framework.BaseClass;
import com.saucedemo.framework.WebDriverUtils;
import com.saucedemo.pages.FormPage;
import com.saucedemo.pages.GraphQLApiTest;
import com.saucedemo.pages.SubscriptionPage;

//import cucumber.api.java.en.*;

import io.cucumber.java.en.*;
import testRunner.RunTest;


public class FormStepDefination extends BaseClass
{
	public static final By product_MRP=By.xpath("//span[@id='prive_price_elem']//s");
	public static final By priceAfter_Discount=By.xpath("//span[@id='prive_price_elem']/following-sibling::span");
	public static final By product_title = By.xpath("//h1[contains(@class, 'product-meta__title')]");

public static By productToSelect=null;
	
	
	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws Throwable {
		
		setup();
		logger.info("******** Launching browser*********");
		form=new FormPage(driver);  
		subscription=new SubscriptionPage(driver); 
		WbUtil= new WebDriverUtils(driver);
	}
	
	@When("I am in the Contact page of the application")
	 public void i_am_in_the_contact_page_of_the_application() throws Throwable {
		 logger.info("******** Opening URL*********");
		 driver.get(prop.getProperty("Url1"));
		 System.out.println(prop.getProperty("Url1"));
		 driver.manage().window().maximize();
	    }
	
	@Then("Verify that user is succesfully logged in {string}")
	public void verify_that_user_is_succesfully_logged_in(String title) throws Throwable {
		logger.info("********Verify whether user logged in or not *********");
    	String ActualTitle=driver.getTitle();
    	System.out.println("Actual Title is:-"+ActualTitle);
    	if(ActualTitle.equalsIgnoreCase(title)|| ActualTitle.contains(title))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
    	logger.info("********User logged in *********");
	}
	

    @And("Scroll down and validate Form is present")
    public void scroll_down_and_validate_form_is_present() throws Throwable 
    {
 //    WebElement ContactForm=driver.findElement(By.id("form"));
 //    WebElement ContactForm=driver.findElement(By.id("selectbox"));
    	WebDriverUtils.pageDown();
   
  // Scrolling down the page till the element is found		
 //    WebDriverUtils.scrollDown(ContactForm);
    }
    
    @Then("Select Interested in scenting {string} from dropdown")
    public void select_interested_in_scenting_from_dropdown(String scent) throws Throwable 
    {
    	logger.info("********Select the Interested in Scenting from Drop Down *********");
    	form.selectScentFromDD(scent); 
    }
    
    @And("Enter First Name {string}")
    public void enter_first_name(String firstname) throws Throwable 
    {
    	logger.info("********Enter First Name********");
    	form.enterFirstName(firstname);
    }
    
    @And("Enter Last Name {string}")
    public void enter_last_name(String lastname) throws Throwable 
    {
    	logger.info("********Enter Last Name********");
    	form.enterLastName(lastname);
    }
    
    @And("Enter Mail Id {string}")
    public void enter_mail_id(String mailid) throws Throwable 
    {
    	logger.info("********Enter Mail id********");
    	form.enterMailId(mailid);
    }
    
    @And("Enter Phone number {string}")
    public void enter_phone_number(String phoneNum) throws Throwable 
    {
    	logger.info("********Enter Phone number********");
    	form.enterphoneNum(phoneNum);
    }
    

    @And("Enter City {string} and State {string} and Zip code {string}")
    public void enter_city_and_state_and_zip_code(String city, String state, String zip) throws Throwable 
    {
    	logger.info("********Enter City, State and Zip code ********");
    	form.enterDetails(city,state,zip);
    }
    
    @And("Enter the comments {string}")
    public void enter_the_comments(String comment) throws Throwable 
    {
    	logger.info("********Enter Comments ********");
    	form.enterComments(comment);
    }
    
    @Then("check the captcha button")
    public void check_the_captcha_button() throws Throwable 
    {
    	logger.info("********Checking Captcha ********");
    	form.clickOnCaptcha();
    	
    }
    

    @When("click on Submit button")
    public void click_on_submit_button() throws Throwable 
    {
    	logger.info("********Submiting the form ********");
    	form.clickOnSubmit();
    }

    @Then("Verify successfully landed on Thank you page")
    public void verify_successfully_landed_on_thank_you_page() throws Throwable 
 {
	 logger.info("********Verify whether is in Thank you page or not *********");
    	String ActualTitle=driver.getTitle();
    	if(ActualTitle.equalsIgnoreCase("Thank you for your interest in Aroma360."))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
    	logger.info("********User is in Thank you Page *********");
    }

    
    //Subscription Steps

	@When("I am in the Home page of the application")
	 public void i_am_in_the_home_page_of_the_application() throws Throwable 
	{
		 logger.info("******** Opening URL*********");
		 driver.get(prop.getProperty("Url2"));
		 System.out.println(prop.getProperty("Url2"));
		 driver.manage().window().maximize();
	    }
	


    @And("Click on search bar and search with product {string}")
    public void click_on_search_bar_and_search_with_product(String productname) throws Throwable
    {
    	logger.info("******** Clicking on Search Bar*********");
    	subscription.clickOnSearch();
    	logger.info("******** Entering Values in Search Bar*********");
    	subscription.enteringValuesOnSearchBar(productname); 
    }
    
    @And("select the product {string}")
    public void select_the_product(String productname) throws Throwable 
    {
    //	logger.info("******** Selecting Product from Search Result*********");
    	subscription.selectProduct(productname);
    }
    @And("Change the currency to {string}")
    public void change_the_currency_to(String currency) throws Throwable 
    {
    	logger.info("******** Change the currency*********");
    	subscription.selectCurrency(currency);
    }
    
    @And("Click on One time Purchase radio button")
    public void click_on_one_time_purchase_radio_button() throws Throwable 
    {
    	logger.info("******** Click on One time Purchase radio button*********");
    	subscription.selectOneTimePurchase_RadioBtn();
    	                    
    }
    

    @And("validate Product name {string} and Subscription and Price")
    public void validate_product_name_and_subscription_and_price(String productname) throws Throwable 
    {
    	logger.info("********Validating Product name*********");
    	subscription.validateProductName(productname);
    	logger.info("********Validating Subscription Radio button is checked by default*********");
    	subscription.SubscriptionIsChecked();
    	logger.info("********Validating The Price*********");
    	subscription.validatePrice();
    }
    @And("validate Product name {string} for variant {string} has same price as in Script")
    public void validate_product_name_for_variant_has_same_price_as_in_scipt(String productname, String variant) throws Throwable 
    {
    	logger.info("********Validating Product name and Price for variant from Script*********");
    	subscription.validateJSON(productname,variant);
    }
    
    @Then("validate Product name {string} for all variant with Subscription has same price as in Script")
    public void validate_product_name_for_all_variant_with_subscription_has_same_price_as_in_scipt(String productname) throws Throwable 
    {
    	logger.info("********Validating Product name and Price for all variant with Subscription has same price as in Script*********");
    	subscription.validate_MultipleJSON(productname);
    }
    
	@Then("from API Product list check subscription and onetimepurchase")
	public void from_api_product_list_check_subscription_and_onetimepurchase() throws Throwable {
		GraphQLApiTest.runTest();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(new File("ProductApi.json"));

		// Traverse through the JSON tree to get the title of each product
		JsonNode productsNode = rootNode.get("products");
		JsonNode edgesNode = productsNode.get("edges");
		for (JsonNode edgeNode : edgesNode) {
			JsonNode node = edgeNode.get("node");
			String product_Name = node.get("title").asText();
			System.out.println(product_Name);
			String product_Url = node.get("onlineStoreUrl").asText();
			System.out.println(product_Url);
			// subscription.productApi();

			// accessing the url
			if (product_Url.equals("null")) {
				System.out.println("This Product -" + product_Name + " is not active");
				continue;
			}

			try {

				logger.info("******** Opening URL*********");
				driver.get(product_Url);

				driver.manage().window().maximize();

				// selecting currency as US
				logger.info("******** Change the currency*********");
				subscription.selectCurrency("US");

				// Searching Functionality
				/*
				 * logger.info("******** Clicking on Search Bar*********");
				 * subscription.clickOnSearch();
				 * logger.info("******** Entering Values in Search Bar*********");
				 * subscription.enteringValuesOnSearchBar(product_Name); //selecting the product
				 * if its displayed
				 * 
				 * 
				 * 
				 * 
				 * logger.info("******** Selecting Product from Search Result*********");
				 * subscription.selectProduct(product_Name);
				 */
				// Validation of Product Page
				logger.info("********Verify whether user logged in or not *********");
				String ActualTitle = driver.getTitle();
				System.out.println("Actual Title is:-" + ActualTitle);
				if (ActualTitle.equalsIgnoreCase(product_Name) || ActualTitle.contains(product_Name))
					System.out.println("Title Matched");
				else
					System.out.println("Title didn't match");
				logger.info("********User logged in *********");
				// validate product name and subscription price
				logger.info("********Validating Product name*********");
				subscription.validateProductName(product_Name);
				logger.info("********Validating Subscription Radio button is checked by default*********");
				subscription.SubscriptionIsChecked();
				logger.info("********Validating The Price*********");
				subscription.validatePrice();
				// validate Product name for all variant with Subscription has same price as in
				// Script
				logger.info(
						"********Validating Product name and Price for all variant with Subscription has same price as in Script*********");
				subscription.validate_MultipleJSON(product_Name);
				// Click on one time purchase
				logger.info("******** Click on One time Purchase radio button*********");
				/*
				 * WebDriverUtils.refreshPage(); Thread.sleep(200);
				 */
				subscription.selectOneTimePurchase_RadioBtn();
				// validate Product name and Subscription and Price
				logger.info("********Validating Product name*********");
				subscription.validateProductName(product_Name);
				logger.info("********Validating Subscription Radio button is checked by default*********");
				subscription.SubscriptionIsChecked();
				logger.info("********Validating The Price*********");
				subscription.validatePrice();
				// Validate name and price from script
				logger.info("********Validating Product name and Price for variant from Script*********");
				subscription.validateJSON(product_Name, "50");
			}

			catch (Exception | AssertionError e) {
				 logger.info("Error while running script for product " + product_Name, e);
				    Scenario scenario = Hooks.scenario.get();
				    if (scenario != null) {
				        scenario.log("<b>Failed for Product:</b> " + product_Name);
				     //   scenario.log("Error message: " + e.getMessage());
				    	 scenario.log("<span style=\"color:red\">Error message: " + e.getMessage() + "</span>");
				      //  scenario.log("Error stacktrace: " + Arrays.toString(e.getStackTrace()));
				     //   scenario.attach(BaseClass.getByteScreenshot(), "image/png", "Failed Scenario Screenshot");
				        logger.error("Scenario failed: " + scenario.getName(), e);
				 
			} 

		}

	}
}
	@Then("from Merchant API Product list check subscription and onetimepurchase")
	public void from_merchant_api_product_list_check_subscription_and_onetimepurchase() throws Throwable 
	{
		// create an object mapper instance
		ObjectMapper mapper = new ObjectMapper();

		// read the JSON file and parse it into a JsonNode object
		JsonNode rootNode = mapper.readTree(new File("GoogleMerchantAPI.json"));

		// get the array of resources
		JsonNode resourcesNode = rootNode.get("resources");
		
		// create a file to store the results for failure
	    //File file = new File("failure_results.txt");
	   // FileWriter fw = new FileWriter(file);
	    BufferedWriter bw = new BufferedWriter(new FileWriter("failure_results.txt"));

		// iterate over the resources and retrieve the link and sale price
		for (JsonNode resourceNode : resourcesNode) {
		    String link = resourceNode.get("link").asText();
		    String MarkedPrice = resourceNode.get("price").get("value").asText();
		  //  String salePrice = resourceNode.get("salePrice").get("value").asText();
		    String salePrice = resourceNode.get("salePrice") != null ? resourceNode.get("salePrice").get("value").asText() : "";
		 //   String size = resourceNode.get("sizes").get(0).asText();
		    String size = resourceNode.get("sizes") != null ? resourceNode.get("sizes").get(0).asText() : "";
		    // do something with the link and sale price values
		    System.out.println("Link: " + link);
		    System.out.println("Variant:- "+size);
		    System.out.println("Marked Price is:- "+MarkedPrice);
		    System.out.println("Sale Price is:- "+salePrice);
			
			
			  try {
			  
			  logger.info("******** Opening URL*********"); driver.get(link);
			  
			  driver.manage().window().maximize(); // selecting currency as US
			  logger.info("******** Change the currency*********");
			  subscription.selectCurrency("US"); 
			  
		
			  
			  
			  
			  logger.info("********Validating Subscription Radio button is checked by default*********" );
			  subscription.SubscriptionIsChecked();
			  logger.info("********Validating The Price*********");
			  subscription.validatePrice();
			  logger.info("******** Click on One time Purchase radio button*********");
			  subscription.selectOneTimePurchase_RadioBtn(); logger.
			  info("********Validating Subscription Radio button is checked by default*********");
			  subscription.SubscriptionIsChecked();
			  
			
			  
			  logger.info("********Validating The Price*********");
			  subscription.validatePrice(); 
			  
			  logger.info("********Validating Product name and Price for variant from Script*********");
			  subscription.validateJSONAndMerchantAPIData(size); 
			  logger.info("********Validating Price for variant from Merchant Data*********");
			  subscription.validateMerchantAPIData(MarkedPrice,salePrice);
			  
			  } 
			  catch (Exception | AssertionError e) 
			  {
				  
				// log the failure information to the file
				  String ActualProduct_Name = WebDriverUtils.findElement(product_title).getText();
				    String ActualProduct_Price = ((WebDriverUtils.findElement(product_MRP).getText()).trim());
				    ActualProduct_Price = ActualProduct_Price.replaceAll("[$,R,]", "");
				    String Product_DiscountedPrice = ((WebDriverUtils.findElement(priceAfter_Discount).getText()).trim());
				    Product_DiscountedPrice = Product_DiscountedPrice.replaceAll("[$,R,]", "");
				    bw.write("Product Name : " + ActualProduct_Name + "<br>" +
				            "Product's Actual price in front End : " + ActualProduct_Price +
				            "Product's Discounted price in front End : " + Product_DiscountedPrice + 
				            "Link of the Product : " + link + 
				            "Variant in Merchant Data : " + size  +
				            "Actual Price in Merchant Data : " + MarkedPrice  +
				            "Sales Price in Merchant Data : " + salePrice );
				    bw.write("\n");
				  

				        bw.flush(); // Flush the buffer to write the data to the file immediately

			  logger.info("Error while running script for product " + link, e);
			  Scenario scenario = Hooks.scenario.get(); 
			  if (scenario != null) {
			  scenario.log("<b>Failed for Product:</b> " + link); 
			  //scenario.log("Error message: " + e.getMessage());
			  scenario.log("<span style=\"color:red\">Error message: " + e.getMessage() + "</span>"); 
			  // scenario.log("Error stacktrace: "+Arrays.toString(e.getStackTrace()));
			  scenario.attach(BaseClass.getByteScreenshot(), "image/png","Failed Scenario Screenshot"); 
			  logger.error("Scenario failed: " +scenario.getName(), e);
			  
			  } }
			 
			 
		}
	}
}  

	