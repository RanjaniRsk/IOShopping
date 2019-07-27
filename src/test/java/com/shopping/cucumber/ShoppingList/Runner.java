package com.shopping.cucumber.ShoppingList;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;


@CucumberOptions(features ="src/test/java/shopping/cucumber/features/Shopping.feature" , glue= {"com.shopping.cucumber.ShoppingList"}, tags= {"@ShoppingListValidation"} ,
plugin = {"pretty", "html:target/site/cucumber-pretty" , "json:target/cucumber.json"}, monochrome=true)

public class Runner {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass (alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	
	 @Test(dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        System.out.println("Cucumber Test Class Inside Test");
	        System.out.println(cucumberFeature.getCucumberFeature());
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }

	 @DataProvider
	    public Object[][] features() {
	        System.out.println("Data Provider test Class");
	        return testNGCucumberRunner.provideFeatures();
	    }
	 
	 @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }
	 
}
