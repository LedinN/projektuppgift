package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import se.reky.hakan.repository.PlayerRepository;
import se.reky.hakan.service.PlayerService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class PlayerControllerTest {

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
    void testAmountOfPlayers() {
        driver.get("http://localhost:8080/players");
        List<WebElement> players = driver.findElements(By.tagName("li"));

        assertEquals(3, players.size());
    }

    @Test
    void testPlayerNameIsDisplayed() {
        driver.get("http://localhost:8080/players");
        WebElement playerName = driver.findElement(By.className("player-name"));
        assertTrue(playerName.isDisplayed());
    }

    @Test
    void testWebsiteTitle() {
        driver.get("http://localhost:8080/players");
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    void testButtonHasText() {
        driver.get("http://localhost:8080/players");
        WebElement button = driver.findElement(By.tagName("button"));
        assertEquals("Logga in", button.getText());
    }


}