package StepRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "J:\\eclipse_Jdrive\\TestBDD\\src\\test\\java\\Featurefile\\TestLogin.feature",
		glue = {"StepDefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@regression",
		plugin = {"pretty", "html:J:\\eclipse_Jdrive\\TestBDD\\target\\TestFolder\\Login_Successful.html",
				"json:J:\\eclipse_Jdrive\\TestBDD\\target\\TestFolder\\Login_Successful.json",
				"junit:J:\\eclipse_Jdrive\\TestBDD\\target\\TestFolder\\Login_Successful.xml"}
		
		)


public class TestRunner {

}
 