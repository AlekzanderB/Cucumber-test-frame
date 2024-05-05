package definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "progress", "html:target/cucumber-html-report" },
        features = "src/test/resources",
        tags = "@regression")

public class RunTestBDD extends AbstractTestNGCucumberTests{
}
