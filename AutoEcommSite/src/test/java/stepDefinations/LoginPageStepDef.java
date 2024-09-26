package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepDef {

	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setup() {
		driver = new ChromeDriver();
	}

	@Given("I am on OpenCart Login page")
	public void i_am_on_open_cart_login_page() {
		driver.get("https://www.opencart.com/?route=account/login");
		loginPage = new LoginPage(driver); // remove driver parameter and then try to run the code
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("yvwkagynfzrjwrswnn@hthlm.com\r\n" + "");
		loginPage.enterPassword("Babaji@123#");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
			loginPage.clickLoginButton();
	}

	@Then("User should be successfully logged in.")
	public void user_should_be_successfully_logged_in() {
			Assert.assertEquals(loginPage.checkLogoutLink(), true);
	}

	@Given("I have entered a invalid {string} and {string}")
	public void i_have_entered_a_invalid_and(String username, String password) {
			loginPage.enterEmail(username);
			loginPage.enterPassword(password);
	}

	@Then("User should not be successfully logged in and user should see error message {string}")
	public void user_should_not_be_successfully_logged_in_and_user_should_see_error_message(String string) {
			Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
			
	}

	@When("I click on the \"Forgot Password\" link.")
	public void i_click_on_the_link(String string) {
			loginPage.checkForgitPasswordLink();
		
	}

	@Then("I should be redirected to the password reset page.")
	public void i_should_be_redirected_to_the_password_reset_page() {
			Assert.assertTrue(loginPage.getForgotPasswordPageUrl().contains("account/forgotten"));
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
