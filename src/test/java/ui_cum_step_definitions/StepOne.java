package ui_cum_step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui_cum_constants.Constants;
import ui_cum_page_object.BrokenLink;
import ui_cum_page_object.LoginPage;
;

public class StepOne {
	public static Logger log = LogManager.getLogger(StepOne.class);


	@Given("I am entering the email id")
	public void I_am_entering_the_email_id() throws InterruptedException {
		LoginPage.getInstance().enterEmail(Constants.UserName);

	}

	@Then("Verify the Register page")
	public void Verify_the_Register_page() throws InterruptedException {
		LoginPage.getInstance().selectCounty();
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
