package ui_cum_utilities;
import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import ui_cum_constants.Constants;
import ui_cum_page_object.BrokenLink;
import ui_cum_page_object.LoginPage;
import ui_cum_step_definitions.CommonStep;



public class CommonUtils {
	
	private static CommonUtils commonutilsInstances = null;
	
	private CommonUtils() {
		
	}
	public static CommonUtils getInstances() {
		
		if(commonutilsInstances== null) {
			commonutilsInstances = new CommonUtils();
		}
		return commonutilsInstances ;
		
	}

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
	 
	 public void takeScreenshot() {
		 File screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		 
		 try {
			FileUtils.copyFile(screenshot, new File(CommonStep.getScenarioname()+".png"));
			System.out.println("Screenshot copied successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	 }

}

