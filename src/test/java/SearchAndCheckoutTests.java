import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchAndCheckoutTests {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com");
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void TC001_validSearchRed() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("Red");
        Thread.sleep(1000);
        searchBox.submit();

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(1000);

        WebElement resultsContainer = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));
        Assert.assertTrue(resultsContainer.isDisplayed(), "Search results should be displayed");
    }

    @Test(priority = 2)
    public void TC002_addToCart() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(1000);

        WebElement product = driver.findElement(By.cssSelector("li.product.item a.product-item-link"));
        product.click();

        Thread.sleep(2000);
        WebElement size = driver.findElement(By.cssSelector(".swatch-attribute.size .swatch-option"));
        size.click();

        WebElement color = driver.findElement(By.cssSelector("#option-label-color-93-item-58"));
        color.click();

        WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
        addToCart.click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a.action.showcart")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#minicart-content-wrapper > div.block-content > div:nth-child(7) > div > a > span")).click();

        Thread.sleep(2000);
        WebElement proceedToCheckout = driver.findElement(By.cssSelector(".checkout-methods-items button.checkout"));
        js.executeScript("arguments[0].scrollIntoView(true);", proceedToCheckout);
        Thread.sleep(1000);
        proceedToCheckout.click();

        // wait for checkout container to appear instead of fixed .checkout-title
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout")));

        WebElement checkoutContainer = driver.findElement(By.id("checkout"));
        Assert.assertTrue(checkoutContainer.isDisplayed(), "Checkout page should be shown");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void TC003_invalidSearch() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("123@");
        Thread.sleep(1000);
        searchBox.submit();

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(1000);

        WebElement message = driver.findElement(By.cssSelector("div.message.notice"));
        String expectedText = "Your search returned no results.";
        Assert.assertTrue(message.getText().contains(expectedText), "Expected 'no results' message");
    }

    @AfterClass
    public void teardown() {
        // Keep browser open for inspection after all tests
    }
}
