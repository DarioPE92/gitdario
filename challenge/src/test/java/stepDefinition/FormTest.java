package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import actions.actionsForm;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.constants;
import utils.seleniumUtils;

public class FormTest {

	public WebDriver driver;
	seleniumUtils utilSelenium = new seleniumUtils();
	constants varConstants = new constants();
	actionsForm formActions = new actionsForm();

//Scenario Validate Rock Text

	@Given("I Open chrome and start application")
	public void open_chrome_and_start_application() {

		driver = seleniumUtils.startBrowser(driver, "chrome",
				"https://forms.liferay.com/web/forms/shared/-/form/122548");
	}

	@When("I Validate if rock text is diplayed")
	public void i_Validate_if_rock_text_is_diplayed() throws Throwable {
		formActions.validateText(driver);
	}

	@When("I fill in the required fields {string} {string} {string} and click in submit")
	public void i_fill_in_the_required_fields_and_click_in_submit(String name, String date, String message) throws Throwable {
		
		formActions.fillInForm(driver, name, date, message);
	}

	@Then("I Validate if the message of success is showup")
	public void i_Validate_if_the_message_of_success_is_showup() throws Throwable {
		
		formActions.validateFields(driver);
		formActions.validaEnvioForm(driver, 10);
		driver.quit();
	}
}
