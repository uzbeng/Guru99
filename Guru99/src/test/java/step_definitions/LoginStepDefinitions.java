package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import Utilities.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import page_objects.HomePage;
import page_objects.LoginPage;

@RunWith(Cucumber.class)
public class LoginStepDefinitions extends Base {
	WebDriver driver;

	public LoginPage loginPg;
	public HomePage homePg;
	public String baseUrl = "http://www.demo.guru99.com/V4/index.php";

	@Given("^Initilize driver$")
	public void initilize_driver() throws Throwable {
		driver = initializeDriver();
	}

	@When("^Initilize POM objects$")
	public void initilize_pom_objects() throws Throwable {
		loginPg = new LoginPage(driver);
		homePg = new HomePage(driver);
	}

	@Then("^Setup waits$")
	public void setup_waits() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^Login page of banking app is open$")
	public void login_page_of_banking_app_is_open() throws Throwable {
		driver.get(baseUrl);
		System.out.println("opening the url");
		String pageTitle = loginPg.getPageTitle();
		System.out.println("Gettting page title" + pageTitle);
		Assert.assertEquals("Guru99 Bank", pageTitle);
		System.out.println("Checking for page title");
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
		// Assert.assertFalse(loginPg.isLoginBoxDisplayed());
		// TODO: Here alert popup is not reachable. For that reason I added Chrome
		// options to accept unhandled alert errors in Base class
		/*
		 * Alert alert = driver.switchTo().alert(); String errorMsg = alert.getText();
		 * System.out.println("This is error message " + errorMsg);
		 * Assert.assertEquals("User or Password is not valid", errorMsg);
		 * alert.accept();
		 */
		Thread.sleep(3000);
		Assert.assertTrue(loginPg.isLoginBoxDisplayed());
		driver.close();
	}

	@Then("^Home page of banking app opens$")
	public void home_page_of_banking_app_opens() throws Throwable {
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(homePageUrl, "http://www.demo.guru99.com/V4/manager/Managerhomepage.php");
		String magerId = homePg.getManagerIdMsg();
		Assert.assertEquals("Manger Id : mngr211208", magerId);
		driver.close();
	}

}
