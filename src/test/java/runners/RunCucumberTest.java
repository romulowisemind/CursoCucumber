package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/aprender_cucumber.feature",
        glue = "steps",
        tags = "@Tipo1 or @Tipo2"
)
public class RunCucumberTest {
}
