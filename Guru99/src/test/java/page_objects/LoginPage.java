package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	String name = "Name example";

	@FindBy(css = "h2[class='barone']")
	WebElement usrNameBoxTitle;

	@FindBy(css = "table input[name='uid']")
	WebElement usernameBox;

	@FindBy(id = "message23")
	WebElement usrNameErrMsg;

	@FindBy(css = "body > form > table > tbody > tr:nth-child(2) > td:nth-child(1)")
	WebElement pswdBoxTitle;

	@FindBy(name = "password")
	WebElement passwordBox;

	@FindBy(id = "message18")
	WebElement pswdErrMsg;

	@FindBy(name = "btnLogin")
	WebElement loginButton;

	@FindBy(name = "btnReset")
	WebElement resetButton;

	@FindBy(css = "h2.barone")
	WebElement loginPageTitle;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// set user name in textbox
	public void setUserName(String username) {
		usernameBox.sendKeys(username);
	}

	// set password in password textbox
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}

	// click on login button
	public void clickLogin() {
		loginButton.click();
	}

	// click on reset button
	public void clickReset() {
		resetButton.click();
	}

	// get login page title
	public String getPageTitle() {
		return loginPageTitle.getText();
	}

	// get username field error message
	public String getUsrNameErrMsg() {
		return usrNameErrMsg.getText();
	}

	// login to the banking application
	public void loginToBankApp(String username, String password) {
		setUserName(username);
		setPassword(password);
		clickLogin();
	}

	// insert empty credentials
	public void insertEmptyCredentials() {
		usernameBox.click();
		passwordBox.click();
	}

	// check if login box is displayed
	public boolean isLoginBoxDisplayed() {
		return usernameBox.isDisplayed();
	}

}
