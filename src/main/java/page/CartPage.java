package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {
	
	
	@FindBy (how= How.XPATH, using="//span[@class='title']")WebElement validateyourCartPageElement;
	@FindBy (how= How.XPATH, using="//button[@id='remove-sauce-labs-onesie']")WebElement removeItem1fromCartElement;
	@FindBy (how= How.XPATH, using="//button[@id='continue-shopping'] ")WebElement ContinueSoppingElement;
	@FindBy (how= How.XPATH, using="//button[@id='checkout']")WebElement CheckoutButtonElement;
	
	
	
	
	public String validatelandonCartPage(String expectedheaderText) {

		return validateyourCartPageElement.getText();

	}
	
	public void removeitemfromcart() {
		
		removeItem1fromCartElement.click();
	}
	
	public void pressContinueShoppingButton() {
		
		ContinueSoppingElement.click();
	}
	
	public void pressCheckoutButton() {
		
		CheckoutButtonElement.click();
	}

}
