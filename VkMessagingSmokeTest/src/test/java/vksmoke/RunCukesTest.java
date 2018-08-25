package vksmoke;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:target/cucumberHtmlReport"},
        features = "src/test/resources/vksmoke/",
        glue = {"vksmoke"}
)
public class RunCukesTest {
}