package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
	public static WebDriver driver;
	public Properties properties;

	public WebDriver initializeDriver() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\java\\Utilities\\login.properties");
		properties.load(fis);

		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\MyProgrammingTools\\ChromeWebDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\MyProgrammingTools\\MozillaWebDriver\\geckodriver.exe");
			DesiredCapabilities firefox = DesiredCapabilities.firefox();
			firefox.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\MyProgrammingTools\\EdgeWebDriver\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

	}

}
