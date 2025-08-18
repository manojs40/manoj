package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/CucumberReports"},
    monochrome = true
)

public class TestRunner {
}
