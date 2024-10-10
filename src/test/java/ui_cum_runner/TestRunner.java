package ui_cum_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty","summary", "rerun:target/failed_scenario.txt",
		  "html:target/cucumber-report/report.html",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features ="src/test/resources/features",
glue= "ui_cum_step_definitions",
dryRun = false,
monochrome = true
)
public class TestRunner{

}


//plugin = {"pretty","summary", "rerun:target/failed_scenario.txt",
//		  "html:target/cucumber-report/report.html",
//		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},