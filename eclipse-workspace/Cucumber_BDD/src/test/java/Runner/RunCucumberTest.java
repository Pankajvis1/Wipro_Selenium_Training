package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/PHPTravelsAutomation.feature",
    glue = {"StepDefinitions","Hooks"},
    plugin = {
        "pretty",
        "html:target/CucumberReport.html",
        "json:target/CucumberReport.json"
    }
)
public class RunCucumberTest {
}