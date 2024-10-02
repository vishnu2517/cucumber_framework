package ui_cum_step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui_cum_utilities.CommonUtils;
import ui_cum_utilities.DriverManager;



public class CommonStep {

public static Logger log = LogManager.getLogger(CommonStep.class);

@Before
	public void beforeScenario() {
    	log.info("Starting the Executuion -------->");
		try {
			CommonUtils commonUtils = new CommonUtils();
			log.info("Loading the Properties file");
			commonUtils.loadProperties();
			if(DriverManager.getDriver()==null) {
			log.info("Initiating the Browser");
			DriverManager.launchBrower();
			commonUtils.initWebElements();
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

