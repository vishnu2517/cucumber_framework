package ui_cum_utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;
import ui_cum_constants.Constants;


public class DriverManager {

	public static Logger log = LogManager.getLogger(DriverManager.class);
	private static WebDriver driver = null;

	public static void launchBrower() {
		try {
			switch (Constants.Browser) {
			case "chrome":
				log.info("Chrome Browser is started ");
			   // WebDriverManager.chromedriver().setup();
		    	 driver = new ChromeDriver();
		    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		         driver.manage().window().maximize();
		         driver.get(Constants.AppURL);
				break;
			case "edge":
				log.info("Edge Browser is started ");
				// WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			     driver.manage().window().maximize();
			     driver.get(Constants.AppURL);
				break;
			default:
				log.info("Chrome Browser is started ");
				//WebDriverManager.chromedriver().setup();
		    	 driver = new ChromeDriver();
		    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		         driver.manage().window().maximize();
		         driver.get(Constants.AppURL);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

}
	public static WebDriver getDriver() {
		return driver;
	}
}

