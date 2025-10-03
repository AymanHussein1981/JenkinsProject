package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	WebElement validateCheckoutPageElement;
	@FindBy(how = How.XPATH, using = "//input[@id='first-name']")
	WebElement FirstNameFeildElement;
	@FindBy(how = How.XPATH, using = "//input[@id='last-name']")
	WebElement LastNameFeildElement;
	@FindBy(how = How.XPATH, using = "//input[@id='postal-code']")
	WebElement PostalCodeFeildElement;
	@FindBy(how = How.XPATH, using = "//input[@id='continue']")
	WebElement ContinueButtonElement;
	@FindBy(how = How.XPATH, using = "//button[@id='finish']")
	WebElement FinishButtonElement;

	public String validateLandonCheckoutPage(String expectedheaderText) {

		return validateCheckoutPageElement.getText();
	}

	public void insertFirstName(String firstname) {

		FirstNameFeildElement.sendKeys(firstname);
	}

	public void insertLastName(String lastname) {

		LastNameFeildElement.sendKeys(lastname);
	}

	public void insertPostalCode(String postalCode) {

		PostalCodeFeildElement.sendKeys(postalCode + generateRandomNum(999));
	}

	public void pressfinishbutton() {

		FinishButtonElement.click();
	}

	public void presscontinuebutton() {

		ContinueButtonElement.click();
	}
}
