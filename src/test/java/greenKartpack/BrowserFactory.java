package greenKartpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
public static WebDriver lauchbrowser(String BrowserName)
{
	WebDriver driver=null;
	if (BrowserName.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		driver=new ChromeDriver();
	}
	if (BrowserName.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		
		driver=new FirefoxDriver();
	}
	return driver;
}
}
