import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "Acceptance",
        plugin = { "pretty", "html:target/cucumber" },
        junit = "--step-notifications"
)

public class RunCucumberTest {
}
