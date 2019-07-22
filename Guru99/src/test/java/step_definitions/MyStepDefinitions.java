package step_definitions;

import org.junit.Assert;
import org.junit.runner.RunWith;

import Utilities.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import page_objects.HomePage;
import page_objects.LoginPage;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends Base {

	public static LoginPage loginPg = new LoginPage(driver);
	public static HomePage homePg = new HomePage(driver);
	public String baseUrl = properties.getProperty("baseUrl");

	@Given("^Login page of banking app is open$")
	public void login_page_of_banking_app_is_open() throws Throwable {
		driver.get(baseUrl);
		String pageTitle = loginPg.getPageTitle();
		Assert.assertEquals("Guru99 Bank", pageTitle);
	}

	@When("^User enters invalid (.+) and (.+)$")
	public void user_enters_invalid_and(String username, String password) throws Throwable {
		loginPg.loginToBankApp(username, password);
	}

	@When("^User enters valid username: \"([^\"]*)\" and password: \"([^\"]*)\"$")
	public void user_enters_valid_username_something_and_password_something(String username, String password) {
		loginPg.loginToBankApp(username, password);
	}

	@Then("^User cannot login and error message is displayed$")
	public void user_cannot_login_and_error_message_is_displayed() throws Throwable {
		Assert.assertFalse(loginPg.isLoginBoxDisplayed());
		String errorMsg = driver.switchTo().alert().getText();
		Assert.assertEquals("User or Password is not valid", errorMsg);
		driver.switchTo().alert().accept();
		Assert.assertTrue(loginPg.isLoginBoxDisplayed());
	}

	@Then("^Home page of banking app opens$")
	public void home_page_of_banking_app_opens() throws Throwable {
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(homePageUrl, "http://www.demo.guru99.com/V4/manager/Managerhomepage.php");
		String magerId = homePg.getManagerIdMsg();
		Assert.assertEquals("Manger Id : mngr211208", magerId);
	}

}
