package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeature"},
        glue = {"StepDefinitions", "AppHooks"},
        plugin = {"pretty",
                "json:target/cucumber-json.json", "summary"

        }

)


public class MyTestRunner {
}
