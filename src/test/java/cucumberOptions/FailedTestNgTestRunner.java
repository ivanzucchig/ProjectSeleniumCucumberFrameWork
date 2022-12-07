package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenario.txt",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/cucumber.html", "json:target/cucumber.json"
        }
)
public class FailedTestNgTestRunner extends AbstractTestNGCucumberTests {
    /*@Override
    @DataProvider (parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    tags = "@PlaceOrder1 or PlaceOrder2",
    plugin = {"html:target/cucumber.html", "json:target/cucumber.json"}*/

}
