package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(css = "body > table > tbody > tr > td > table > tbody > tr.heading3 > td")
	WebElement managerId;

	@FindBy(css = "body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee")
	WebElement welcomeMsg;

	@FindBy(css = "body > table > tbody > tr > td > center")
	WebElement imagesOnTop;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getManagerIdMsg() {
		return managerId.getText();
	}

}
