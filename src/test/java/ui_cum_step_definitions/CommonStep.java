package ui_cum_step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ui_cum_utilities.CommonUtils;
import ui_cum_utilities.DriverManager;



public class CommonStep {
	
	private static String scenarioname=null;

public static String getScenarioname() {
		return scenarioname;
	}

public static Logger log = LogManager.getLogger(CommonStep.class);

@Before
	public void beforeScenario(Scenario scenario) {
    	log.info("Starting the Executuion -------->");
		try {
			scenarioname =scenario.getName();
			log.info("Loading the Properties file");
			CommonUtils.getInstances().loadProperties();
			if(DriverManager.getDriver()==null) {
			log.info("Initiating the Browser");
			DriverManager.launchBrower();
			CommonUtils.getInstances().initWebElements();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void afterScenario() {
		log.info("Execution is stopped -------->");
		DriverManager.getDriver().quit();
	}




	}

