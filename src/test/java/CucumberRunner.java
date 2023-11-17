import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty", "json:target/cucumber.json"},
        stepNotifications = true,
        tags = "@LoginTestCase-03"
)

public class CucumberRunner {

}