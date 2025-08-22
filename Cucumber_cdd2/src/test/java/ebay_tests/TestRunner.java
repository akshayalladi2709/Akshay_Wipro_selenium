package ebay_tests;

import org.junit. runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions (
features = "src/test/resources/features",
glue = "ebay_tests",

plugin = {"pretty", "html: target/HTML/htmlreport.html",
                    "json:target/JSON/jsonreport",
                    "junit:target/JUNIT/junitreport"})
public class TestRunner {
	
}