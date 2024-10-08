package ui_cum_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty","summary"}, 
features ="@target/failed_scenario.txt",
glue= "ui_cum_step_definitions",
dryRun = false,
monochrome = true
)

public class ReRunner {

}
