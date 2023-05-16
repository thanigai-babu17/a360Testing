package com.saucedemo.stepdefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.saucedemo.framework.BaseClass;

import freemarker.template.Configuration;
import io.cucumber.java.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;



public class Hooks extends BaseClass
{

    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    @Before
    public void before(Scenario scenario) {
        Hooks.scenario.set(scenario);
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    @AfterStep
    public void takeScreenshot() throws IOException, InterruptedException {
        Scenario scenario = Hooks.scenario.get();
        if (scenario.isFailed()) {
        	
            scenario.attach(BaseClass.getByteScreenshot(), "image/png", "Failed Scenario Screenshot");
            
          
            
            
            BaseClass.getScreenshot();
        } else {
            scenario.attach(BaseClass.getByteScreenshot(), "image/png", "Screenshot");
        }
    }

}
