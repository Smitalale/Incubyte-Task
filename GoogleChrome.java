package LaunchBrowser;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleChrome {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver", "F:\\Selenium drivers//chromedriver.exe");
 
 ChromeOptions options = new ChromeOptions();
 
 options.addArguments("--disable-web-security");
 
 options.addArguments("--allow-running-insecure-content");
 
 DesiredCapabilities capabilities = new DesiredCapabilities();
 //To disable security features, we can use ChromeOptions and DesiredCapabilities in Selenium to configure the ChromeDriver instance.
 
 capabilities.setCapability(ChromeOptions.CAPABILITY, options);

 WebDriver driver = new ChromeDriver();

driver.get("https://www.google.com/");

driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a/span")).click();

driver.findElement(By.id("identifierId")).sendKeys("abc@gmail.com");
//We get the message in URL as : https://accounts.google.com/v3/signin/rejected?continue=https%3A%2F%2Fwww.google.com%2F&dsh=S923250917%3A1686379584497746&epd=ARH0xVOq2DlN-zyhzjBCY5egxoVqaR6ANTtY8zWk6S17JbzJmQo4t4ArJQ&flowEntry=ServiceLogin&flowName=GlifWebSignIn&hl=en&idnf=smitavlale%40gmail.com&ifkv=Af_xneE1QfRwNVYg8-hB8VaAZW3TNtqZCTeFuR3TDdnYfLSToTWXbVgexjqq0HxUjkE4xBw5l9gyBQ&rhlk=le&rrk=46

driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
//Trial for to view the password field by using wait WebDriverWait wait = new WebDriverWait(driver, 10);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd"))).sendKeys("xyz");

//Trial for to view the password field by using implicitly as mentioned below:
//wait WebDriver gmail;
//gmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//Trial for to view the password field by using Fluent wait as mentioned below: 
//FluentWait<WebDriver> wait1 = new FluentWait<>(driver);
//FluentWait<WebDriver> wait

//Trial for to view the password field by using Thread.sleep as mentioned below:
//Thread.sleep(3000);
//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

driver.findElement(By.xpath("//span[contains(text(),'Next')]")).sendKeys("xyz");

//OR Use wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
//driver.findElement(By.name("Passwd")).sendKeys("123456");
//driver.findElement(By.id("passwordNext")).click();

//wait1.until(ExpectedConditions.titleContains("Inbox"));

driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();

driver.findElement(By.id(":1ie")).sendKeys("recipient@example.com");

driver.findElement(By.name("subjectbox")).sendKeys("Incubyte Deliverables:1");

driver.switchTo().frame(driver.findElement(By.cssSelector("div[role='dialog'] iframe")));

driver.findElement(By.xpath("//div[@id=':1fq']")).sendKeys("Automation QA test for Incubyte");

driver.switchTo().defaultContent();

driver.findElement(By.xpath("//div[@id=':1e7']")).click();

FluentWait<WebDriver> wait1 = null;

wait1.until(ExpectedConditions.textToBe(By.cssSelector("span.bAq"), "Message sent."));

driver.close();

}
	
}

