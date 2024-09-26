package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/main/java/Features",
        glue = {"stepDefinations"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

//	@CucumberOptions(features = "src/main/java/Features",   //features file location
//			glue = {"stepDefinations"},				//Step Definations package name
//			plugin = {"pretty" , "html:target/cucmber-reports" , "json:target/cucumber.json"},  //this is for reports
//			monochrome = true,   //align format for results in console
//			publish = true )     //publish the reports on the clouds