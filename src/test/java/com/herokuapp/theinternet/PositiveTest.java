package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {
	@Test
	public void loginTest() {
		// create a driver
		//System.setProperty("webdriverл.chrome.driver", "src/main/resources/chromedriver");

		WebDriver driver = new ChromeDriver();
		// sleep for 3 sec
		sleep(3000);
		// maximize browser window
		driver.manage().window().maximize();
		// open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(3000);

		System.out.print("Page is opened");
		
		// enter username
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		sleep(1000);

		// enter password
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(2000);

		// click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		sleep(1000);

		// verification:
		
		// new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected!");

		
	
		// logout button is visible

		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Log out button is not visible!");
		sleep(3000);

		// successful login message
			WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
			String expectedMessage ="You logged into a secure area!";
			String actualMessage = successMessage.getText();
			//Assert.assertEquals(actualMessage, expectedMessage,"Actual message is the same as expected ");
			Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected.\nActual Message:" + actualMessage + "\nExpectedMessage:" + expectedMessage);
						sleep(3000);
		// close browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
