package greenKartpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class sorting {
	public static WebDriver driver;
	@BeforeSuite
	public void precondition() throws IOException, InterruptedException
	{    Properties prop=new Properties();
	
	     FileInputStream fis=new FileInputStream("C:\\Users\\pranj\\eclipse2\\greenKart\\src\\greenKartpack\\dataprovider.properties");
	     prop.load(fis);
	     
		driver = BrowserFactory.lauchbrowser("chrome");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[contains(@placeholder,'password')]")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		/*driver.findElement(By.xpath("//div[text()='My Naukri']")).click();
		Thread.sleep(8000);*/
		
		/*Actions action = new Actions(driver);*/
	/*	action.moveToElement(driver.findElement(By.xpath("//div[text()='My Naukri']"))).perform();
		driver.findElement(By.xpath("//a[text()='Edit Profile']")).click();*/
		driver.findElement(By.xpath("//div[@class='popout profile-section card']//img[@class='circle nk-userdp']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='edit icon'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']//button[text()='Save']")).click();
        System.out.println("Profile EDited");
        driver.quit();
		//	System.out.println(prop.getProperty("username"));
	}
	/*@AfterSuite
	public void postcondtion()
	{
		driver.close();
	}*/
@Test(priority=1, enabled=false)
public void sortData()
{
	driver.findElement(By.xpath("//table[@id='sortableTable']//b[text()='Veg/fruit name']")).click();
	//driver.findElement(By.xpath("//table[@id='sortableTable']//b[text()='Veg/fruit name']")).click();  //double click and test is in descending order
   List<WebElement> firstColList = driver.findElements(By.cssSelector("tbody>tr>td:nth-child(2)"));
   ArrayList<String> originalList = new ArrayList<String>();
   for(int i=0;i<firstColList.size();i++)
   {
	   originalList.add(firstColList.get(i).getText()  );
   }
   System.out.println(originalList);
   ArrayList<String> copiedlist = new ArrayList<String>();
   for(int i=0;i<firstColList.size();i++)
   {
	   copiedlist.add(firstColList.get(i).getText()  );
   }
   Collections.sort(copiedlist);
   
   Collections.reverse(copiedlist);
   System.out.println(copiedlist);
   Assert.assertTrue(originalList.equals(copiedlist));
   
   
}
/*@Test(dependsOnMethods= {"sortData"})
public void print()
{
	System.out.println("hey pranjal congrats");
}*/
}
