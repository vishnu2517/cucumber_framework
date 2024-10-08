package ui_cum_page_object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui_cum_step_definitions.CommonStep;
import ui_cum_utilities.CommonUtils;

public class LoginPage {
// Locator
	@FindBy(id="email")
	private WebElement Email;

	@FindBy(id="enterimg")
	private WebElement OkButton;

	@FindBy(xpath="//input[@ng-model=\"FirstName\"]")
	private WebElement firstName;

	@FindBy(xpath="//input[@placeholder=\"Last Name\"]")
	private WebElement lastName;

	@FindBy(xpath="//input[@type=\"email\"]")
	private WebElement emailReg;

	@FindBy(id="country")
	private WebElement country;


	private static LoginPage loginInstance;

	private LoginPage() {
	}

//Instance creations
	public static LoginPage getInstance(){
		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
	}

//Actions

	public static Logger log = LogManager.getLogger(CommonStep.class);


    public void enterEmail(String username) throws InterruptedException {
    	Email.sendKeys(username);
    	log.info("User name entered");
    	OkButton.click();
    	log.info("Clicked the ok button");
    	Thread.sleep(2000);
    	firstName.sendKeys("Vishnu");
    	log.info("First Name entered");
    	lastName.sendKeys("prashant");
    	log.info("Last Name entered");
    	emailReg.sendKeys("vishnuprashant.sv@gmail.com");
    	log.info("Email entered successfuly");
    	 Thread.sleep(2000);
    	 CommonUtils.getInstances().takeScreenshot();
    	
    }
    public void selectCounty() throws InterruptedException {
    	Select select = new Select(country);
    	select.selectByVisibleText("Hong Kong");
    	Thread.sleep(2000);
    	CommonUtils.getInstances().takeScreenshot();
    }

}
