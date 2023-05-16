package testRunner;


import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/Features/Aroma360/Subscription.feature"},
		glue="com.saucedemo.stepdefinitions",
		dryRun=false,
		monochrome=true,//removes unwanted symbols from condole window//	
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//		tags= ("@AllScenarios")
		tags= ("@scenario7")
		)

public class RunTest extends AbstractTestNGCucumberTests{

	

}
