package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.DocsAndSeriesPage;

public class TestNGTests {
	WebDriverWait wait;

	public WebDriver driver;
	public DocsAndSeriesPage dp;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.tvo.org/");
		driver.manage().window().maximize();
		dp = new DocsAndSeriesPage(driver);

	}

	@Test
	public void verifyAllFiterDisplayed() {
		dp.navigateToDocs();
		Assert.assertTrue(dp.allDisplayed());

	}

	@Test
	public void verifyPagination() {
		dp.clickNextArrow();
		Assert.assertTrue(dp.categorydisplayed());

	}

	@Test
	public void verifyVideoLinkClickble() {
		dp.clickedToOpenvideo();
		Assert.assertTrue(dp.watchNowDisplayed());

	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
