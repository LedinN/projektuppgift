package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.reky.hakan.repository.PlayerRepository;
import se.reky.hakan.service.PlayerService;

import java.time.Duration;
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
    @DisplayName("Ensure 3 players are in player-list")
    void should_DisplayThreePlayers_When_VisitingPlayersPage() {
        driver.get("http://localhost:8080/players");
        List<WebElement> players = driver.findElements(By.tagName("li"));

        assertEquals(3, players.size());
    }

    @Test
    @DisplayName("Ensure that player name is visible on the player-list")
    void should_DisplayPlayerName_When_VisitingPlayersPage() {
        driver.get("http://localhost:8080/players");
        WebElement playerName = driver.findElement(By.className("player-name"));
        assertTrue(playerName.isDisplayed());
    }

    @Test
    @DisplayName("Ensure the web page title is correct on player-list page")
    void should_DisplayCorrectTitle_When_VisitingPlayersPage() {
        driver.get("http://localhost:8080/players");
        assertEquals("Players List", driver.getTitle());
    }

    @Test
    @DisplayName("Ensure login button has correct text")
    void should_DisplayCorrectButtonText_When_VisitingPlayersPage() {
        driver.get("http://localhost:8080/players");
        WebElement button = driver.findElement(By.tagName("button"));
        assertEquals("Logga in", button.getText());
    }


    @Test
    @DisplayName("Ensure navigation to player details page shows player name and experience")
    void should_DisplayPlayerDetails_When_NavigatingToPlayerPage() {
        driver.get("http://localhost:8080/players");
        driver.findElement(By.className("player-name")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playerName = driver.findElement(By.className("player-name"));
        WebElement playerExp = driver.findElement(By.className("player-exp"));
        assertTrue(playerName.isDisplayed() && playerExp.isDisplayed());
    }
}