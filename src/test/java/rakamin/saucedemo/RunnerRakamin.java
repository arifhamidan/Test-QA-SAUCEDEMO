package rakamin.saucedemo;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = {"rakamin.saucedemo.stepDef"},
        plugin = {"html:target/HTML_report.html"}
)

public class RunnerRakamin {

}