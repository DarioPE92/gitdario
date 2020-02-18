package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class formObjects {

	public WebDriver driver;

	@FindBy(xpath = "//*[@class='lfr-ddm-form-page-description']")
	WebElement lblDescriptionForm;

	@FindBy(xpath = "//*[contains(@class,'ddm-field-text form-control') and contains(@name,'Qual…OSeuNome')]")
	WebElement inputName;

	@FindBy(xpath = "//*[contains(@class,'ddm-field-text form-control') and contains(@name,'PorqueVocÍIngressouNa¡reaDeTestes')]")
	WebElement inputMenssage;

	@FindBy(xpath = "//div[@class='input-group-item']//*[contains(@class,'form-control') and contains(@type,'text')]")
	WebElement inputDate;

	@FindBy(xpath = "//*[contains(@class,'btn btn-primary lfr-ddm-form-submit pull-right') and contains(@type,'submit')]")
	WebElement butSubmit;

	@FindBy(xpath = "//*[contains(@class,'form-feedback-item help-block')]")
	WebElement lblError;
	
	@FindBy(xpath = "//*[contains(@class,'ddm-form-description')]")
	WebElement lblMsgConfirmation;

	@FindBy(xpath = "//*[contains(@class,'ddm-form-name')]")
	WebElement lblFormName;

	public formObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebElement lblDescriptionForm() {
		return (lblDescriptionForm);
	}

	public WebElement inputName() {
		return (inputName);
	}

	public WebElement inputMessage() {
		return (inputMenssage);
	}

	public WebElement inputDate() {
		return (inputDate);
	}

	public WebElement butSubmit() {
		return (butSubmit);
	}

	public WebElement lblError() {
		return (lblError);
	}
	
	public WebElement lblMsgConfirmation() {
		return (lblMsgConfirmation);
	}

	public WebElement lblFormName() {
		return (lblFormName);
	}
}
