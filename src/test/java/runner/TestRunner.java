package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                glue = "org.veeva.stepdefination",
                plugin = {"pretty","html:target/cucumber-reports"},
                monochrome = true,
                publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
