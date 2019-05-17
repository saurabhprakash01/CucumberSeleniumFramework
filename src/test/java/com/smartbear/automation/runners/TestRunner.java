package com.smartbear.automation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFile", 
				glue = { "com.smartbear" },
				plugin= {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"})


public class TestRunner {

}
