package ui_cum_utilities;
import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
     
	 public void highlightElements(WebElement element) {
		 JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		 executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');",element);
	 }
	 
	 public void selectFromDropdown(WebElement dropDown, String howTo, String value) {
		 
		 Select select = new Select(dropDown);
		 switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
        case "value":
			select.selectByValue(value);
			break;
        case "text":
	        select.selectByVisibleText(value); 
	break;

		default:
			System.out.println("Such element not found");
			break;
		}
	 }
}

