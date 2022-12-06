package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Butun testeri calisitir
@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = "StepDefinitions"
)

public class _03_TestRunnerAll extends AbstractTestNGCucumberTests {
}
