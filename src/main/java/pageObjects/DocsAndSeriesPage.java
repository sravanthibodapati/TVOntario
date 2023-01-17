package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocsAndSeriesPage {

	private WebDriver driver;

	public DocsAndSeriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='/series-docs']")
	private WebElement lnk_docsSeries;
	@FindBy(xpath = "//span[text()='All']")
	private WebElement lnk_all;
	@FindBy(xpath = "//div[@class='series-docs-nav__nav-button series-docs-nav__next-button']")
	private WebElement btn_next;
	@FindBy(xpath = "//span[text()='History']")
	private WebElement lnk_category;
	@FindBy(xpath = "//p[text()='Impossible Engineering']")
	private WebElement lnk_video;
	@FindBy(xpath = "//a[@aria-label='Watch Impossible Engineering']")
	WebElement btn_watchnow;

	public void navigateToDocs() {

		lnk_docsSeries.click();
		lnk_all.click();

	}

	public boolean allDisplayed() {
		boolean status = lnk_all.isDisplayed();
		return status;
	}

	public void clickNextArrow() {
		btn_next.click();

	}

	public boolean categorydisplayed() {
		boolean category = lnk_category.isDisplayed();
		return category;
	}

	public void clickedToOpenvideo() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		lnk_video.click();

	}

	public boolean watchNowDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(btn_watchnow));
		boolean status = btn_watchnow.isDisplayed();
		return status;
	}

}
