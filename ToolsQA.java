package Cosmo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQA {

	public static void main(String[] args) throws InterruptedException {
//Autofill Textbox
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/skuma/eclipse-workspace/SimpleSelenium/src/test/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

		WebElement subject = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']"));

		subject.click();

		WebElement subjectinput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));

		subjectinput.sendKeys("a");

		Actions actions = new Actions(driver);
		actions.sendKeys(subjectinput, Keys.ARROW_DOWN).sendKeys(subjectinput, Keys.ARROW_DOWN).sendKeys(subjectinput, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		System.out.println("complete");

		driver.close();
		driver.quit();

	}
}