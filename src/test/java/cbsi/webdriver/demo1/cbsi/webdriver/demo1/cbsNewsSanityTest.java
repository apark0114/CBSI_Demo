package cbsi.webdriver.demo1.cbsi.webdriver.demo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cbsNewsSanityTest {
	public WebDriver driver;
	private String homeUrl = "http://www.cbsnews.com/"; 
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get(homeUrl);
	}

	@After
	public void cleanUp(){
		driver.quit();
	}
	
	@Test
	public void mainTitleIsDisplayed(){
		WebElement mainTitle = driver.findElement(By.cssSelector("div.col-8.hero h1")); // this css path looks for <div class="col-8" "hero"> <h1> tag.
		assertTrue(mainTitle.isDisplayed()); //isDisplayed() is a method that returns true/false if the element is displayed.
	}
	
	
	@Test
	public void mainImageIsDisplayed(){
		WebElement mainImage = driver.findElement(By.cssSelector("div.col-8.hero figure a span img")); // this css path looks for <div class="col-8" "hero"> <figure> <a> <span> <img> tag.
		assertTrue(mainImage.isDisplayed());
	}
	
	@Test
	public void mainTitleLinkWorks(){
//		WebElement mainTitle = driver.findElement(By.cssSelector("div.col-8.hero h1 a"));
		WebElement mainTitle = driver.findElement(By.xpath("//div[@class='col-8 hero']/h1/a")); //findElement using XPath.
		mainTitle.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //implicitWait will wait UPTO 20 seconds until the following element is available. 
		WebElement mediaObject = driver.findElement(By.cssSelector("div[class='article-image'] figure span.img"));
		
		assertTrue(mediaObject.isDisplayed());
		
	}
	
	@Test
	public void validateTitleText(){
		WebElement mainTitle = driver.findElement(By.cssSelector("div.col-8.hero h1 a"));
		String actualTitle = mainTitle.getText(); // getText() returns a text inside the element.
		assertEquals("California's Central Valley is sinking -- here's why", actualTitle);
	}
	
	@Test
	public void searchText(){
		WebElement searchInput = driver.findElement(By.cssSelector("div.search-wrapper input.query"));
		WebElement searchButton = driver.findElement(By.cssSelector("form.site-search button[type='submit']"));
		
		searchInput.sendKeys("California");
		searchButton.click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement resultTitle = driver.findElement(By.cssSelector("div h1.result-title"));
		assertEquals("Results for \"California\"",resultTitle.getText());	
	}

}
