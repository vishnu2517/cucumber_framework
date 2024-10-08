package ui_cum_step_definitions;

import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui_cum_constants.Constants;
import ui_cum_page_object.BrokenLink;
import ui_cum_page_object.LoginPage;
import ui_cum_utilities.CommonUtils;
;

public class StepOne {
	public static Logger log = LogManager.getLogger(StepOne.class);


	@Given("I am entering the email id")
	public void I_am_entering_the_email_id() throws InterruptedException {
		LoginPage.getInstance().enterEmail(Constants.UserName);

	}

	@Then("I select the country {string} from the dropdown {string}")
	public void I_select_the_country_from_the_dropdown(String value, String howTo) throws InterruptedException {
		CommonUtils.getInstances().selectFromDropdown(LoginPage.getInstance().getCountry(), howTo, value);
		//Assert.fail();
	}

	@And("I enter the manatory field")
	public void I_enter_the_manatory_field() {
	}

	@And("I click on Refresh button")
	public void I_click_on_Refresh_button() {
	}
	
	@Then("Verify the valid links")
	public void Verify_the_valid_links() {		
		BrokenLink.gettInstances().broken();
	}
}
