package se.reky.hakan.model;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TEST {

    WebDriver driver;

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testWebsiteTitle() {
        // Navigera in till den URL du vill testa för respektive driver
        driver.get("https://svtplay.se");
        assertEquals("SVT Play", driver.getTitle(), "Titeln stämmer med förväntat");
    }

    @Test
    public void testProductNameIsPresent() {
        driver.get("http://someapi.com/products");
        // Find all list items in the products list (given that they are displayed with div elements and that those div elements are the only divs on the page)
        List<WebElement> products = driver.findElements(By.tagName("div"));
        //get first item with get(0)
        WebElement firstProduct = products.get(0);
        //getText() returns the text in the HTML-element
        //use getText().equals for exact match
        assertTrue(firstProduct.getText().contains("Macbook Air"), "Product name should be present");
    }

    @Test
    public void testFirstProductIsDisplayed() {
        driver.get("http://someapi.com/products/1");
        // Find the element contating the product by css-classname
    WebElement product = driver.findElement(By.className("product-class"));
        //isDisplayed() returns true or false
        boolean firstProductIsDisplayed = product.isDisplayed();
        assertTrue(firstProductIsDisplayed);
    }

    @Test
    public void testLogoIsPresentAtGoogle() {
        driver.get("https://www.google.se");
        WebElement logo = driver.findElement(By.cssSelector("img.lnXdpd"));
        boolean logoIsDisplayed = logo.isDisplayed();
        assertTrue(logoIsDisplayed);
    }

/*
//Vänta max 10 sekunder
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// Click the first link in the list
WebElement firstLinkInList = driver.findElement(By.cssSelector("ul li a"));
firstLinkInList.click();
// Use WebDriverWait to wait for element with id="some-id" to be visible on the new page
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("some-id")));
//Continue test and try to locate WebElement with "some-id"
 */

}
