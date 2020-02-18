package actions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.formObjects;

public class actionsForm {

	/**
	 * Method to validate the text 'Let's party rock.'
	 * @param driver
	 * @throws InterruptedException
	 */
	public void validateText(WebDriver driver) throws InterruptedException {

		formObjects objForm = new formObjects(driver);

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@class,'lfr-ddm-form-page-description')]")));

		assertTrue("test failed",
				objForm.lblDescriptionForm().getAttribute("innerHTML").toString().equalsIgnoreCase("Let's party rock."));

	}

	/**
	 * Method to Fill in LifeRay Forms
	 * @param driver
	 * @param name
	 * @param date
	 * @param message
	 * @throws InterruptedException
	 */
	public void fillInForm(WebDriver driver, String name, String date, String message) throws InterruptedException {

		formObjects objForm = new formObjects(driver);
		objForm.inputName().click();
		objForm.inputName().sendKeys(name);
		Thread.sleep(1000);
		objForm.inputDate().sendKeys(Keys.HOME);
		objForm.inputDate().sendKeys(date);
		Thread.sleep(1000);
		objForm.inputMessage().click();
		objForm.inputMessage().sendKeys(message);
		Thread.sleep(1000);
		objForm.butSubmit().click();

	}

	/**
	 * Method to validate if message of error appears.
	 * @param driver
	 * @throws InterruptedException
	 */
	public void validateFields(WebDriver driver) throws InterruptedException {

		List<WebElement> erros = driver.findElements(By.xpath("//*[contains(@class,'form-feedback-item help-block')]"));
		int totalError = erros.size();

		if (totalError > 0) {
			for (int i = 0; i < totalError; i++) {

				Assert.fail("Error - Field not Filled");

			}

		}

	}

	/**
	 * Method to confirm is the information was sent with success
	 * @param driver
	 * @param timeout
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validaEnvioForm(WebDriver driver, int timeout) throws InterruptedException {
		boolean sucess = false;
		formObjects objForm = new formObjects(driver);
		try {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(objForm.lblFormName()));

			if (objForm.lblFormName().isDisplayed() && objForm.lblMsgConfirmation().getAttribute("innerHTML").toString()
					.equalsIgnoreCase("Informações enviadas com sucesso!")) {
				sucess = true;

			} else {

				Assert.fail("Error sending the form.");

			}

		} catch (NoSuchElementException ex) {
			System.out.println("Form not sent!");

		} finally {
			driver.navigate().back();
		}
		return sucess;
	}
}