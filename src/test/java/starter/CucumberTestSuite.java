package starter;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Tugas",
        plugin = {"pretty"},
        features = "classpath:features/Reqres"
)
public class CucumberTestSuite {}
