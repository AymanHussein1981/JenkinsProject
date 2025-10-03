package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import page.CartPage;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductPage;
import util.BaseClass;

public class CheckoutTest {
	
	
	
	static WebDriver driver;
	LoginPage loginpage;
	ProductPage productpage;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	
	
	String UserName="standard_user";
	String Password="secret_sauce";
	String ProductPageHeader="Products";
	String CartPageHeader="Your Cart";
	String CheckoutPageHeader="Checkout: Your Information";
	String FilterDropDown="Price (low to high)";
	String postalCode="75";
	String firstname="Ayman";
	String lastname="Hussein";
	
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeRun() {
		driver=BaseClass.init();
		
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		productpage=PageFactory.initElements(driver, ProductPage.class);
		cartpage=PageFactory.initElements(driver, CartPage.class);
		checkoutpage=PageFactory.initElements(driver, CheckoutPage.class);
	}
	
	
	@Test
	public void CustomerShouldCheckout() throws InterruptedException {
		
		loginpage.insertUserName(UserName);
		loginpage.insertPassword(Password);
		loginpage.pressLoginBotton();
		Thread.sleep(3000);
		String actualheaderText =productpage.validatelandonProductPage(ProductPageHeader);
		Assert.assertEquals(actualheaderText, ProductPageHeader, "Page not Found");
		productpage.sortPriceDropDown(FilterDropDown);
		productpage.AddItem1toCart();
		productpage.AddItem2toCart();
		productpage.AddItem3toCart();
		productpage.PressCartButton();
		Thread.sleep(3000);
		String actualheaderText1 =cartpage.validatelandonCartPage(CartPageHeader);
		Assert.assertEquals(actualheaderText1, CartPageHeader, "Page not Found");
		cartpage.removeitemfromcart();
		cartpage.pressContinueShoppingButton();
		Thread.sleep(3000);
		productpage.AddItem4toCart();
		productpage.PressCartButton();
		Thread.sleep(3000);
		cartpage.pressCheckoutButton();
		String actualheaderText2 =checkoutpage.validateLandonCheckoutPage(CheckoutPageHeader);
		Assert.assertEquals(actualheaderText2, CheckoutPageHeader, "Page not Found");
		checkoutpage.insertFirstName(firstname);
		checkoutpage.insertLastName(lastname);
		checkoutpage.insertPostalCode(postalCode);
		checkoutpage.presscontinuebutton();
		checkoutpage.pressfinishbutton();
		Thread.sleep(3000);
		Thread.sleep(3000);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void AfterRun() {
		
		BaseClass.TearDown();
	}

}
