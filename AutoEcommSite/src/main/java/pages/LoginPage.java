package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	// We have to write page locators, action..etc in LoginPage.java

	private WebDriver driver;

	// By Locators
	private By emailInputLocators = By.name("email");
	private By passwordInputLocators = By.name("password");
	private By loginButtonLocators = By.xpath("//button[@type=\"submit\"][1]");
	private By forgottenPasswordLinkLocator = By.xpath("//button[@type=\\\"submit\\\"][1]\")");
	private By logoutLinkLocators = By
			.xpath("//div[@class = \"navbar-right hidden-xs\"]//a[contains(text(), \"Logout\")][1]");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// PageMethod/Actions
	public void enterEmail(String email) {
		WebElement emailInput = driver.findElement(emailInputLocators);
		emailInput.sendKeys("email");
	}

	public void enterPassword(String password) { // try to remove parameter than run n observe
		WebElement passwordInput = driver.findElement(passwordInputLocators);
		passwordInput.sendKeys("password");
	}

	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(loginButtonLocators);
		loginButton.click();
	}

	public void clickForgottenPasswordLink() {
		WebElement forgotYourPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
		forgotYourPasswordLink.click();
	}

	public boolean checkForgitPasswordLink() {
		return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
	}

	public boolean checkLogoutLink() {
		return driver.findElement(logoutLinkLocators).isDisplayed();
	}

	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();
	}

	public String getForgotPasswordPageUrl() {
		String forgotPwdPageUrl = driver.getCurrentUrl();
		return forgotPwdPageUrl;
	}
}
