package tests.oishopping.tests;


import cucumber.api.CucumberOptions;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.*;
import tests.BaseTest;


@CucumberOptions(
        monochrome = true,
      
        features = "src/test/java/tests/oishopping/features/OIShopping.feature",
        glue = "tests.oishopping.steps",
        format=("pretty")
       
                )
public class RunnerOIShopping extends  BaseTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups="cucumber", description = "Runs OIShopping Feature")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("Cucumber Test Class Inside Test");
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

   
}
