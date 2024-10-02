package ui_cum_utilities;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import ui_cum_constants.Constants;
import ui_cum_page_object.BrokenLink;
import ui_cum_page_object.LoginPage;



public class CommonUtils {

	public void loadProperties() {


		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Constants.AppURL=properties.getProperty("APP_Url");
		Constants.Browser=properties.getProperty("BROWSER");
		Constants.UserName=properties.getProperty("UserName");
		Constants.Password=properties.getProperty("Password");

	}

	 public void initWebElements() {
    	 PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
    	 PageFactory.initElements(DriverManager.getDriver(), BrokenLink.gettInstances());
     }

}

