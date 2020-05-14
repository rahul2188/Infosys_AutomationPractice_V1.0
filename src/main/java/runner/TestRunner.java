package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/features/PlacingEnd2EndOrder.feature",// replace with src/main/java/features/PlacingEnd2EndOrder.feature for running other feature file
		glue= "stepDefinition",						//path where step definition file is paced, usually the package name
		dryRun=false,			// to see if all steps of feature file are mapped with step definition file. Value = true will check the mapping in dry run without execution.
		monochrome=false,		//monochrome =true gives pretty output on console, generate readable format.
		strict=true) 		//strictly check the mapping between feature file and step definition file. It will execute the code and fail it if any mapping is missing.
public class TestRunner {

}


// 2 separate feature files
//src/main/java/features/AccountCreation.feature"
//src/main/java/features/PlacingEnd2EndOrder.feature