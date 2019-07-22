package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "step_definitions", plugin = { "pretty",
		"html:target/cucumber" }, monochrome = true)

public class TestRunner {

}
