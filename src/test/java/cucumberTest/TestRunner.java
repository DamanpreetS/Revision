package cucumberTest;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/cucumberTest", glue="stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{
	private void syso() {
		// TODO Auto-generated method stub

	}

}
