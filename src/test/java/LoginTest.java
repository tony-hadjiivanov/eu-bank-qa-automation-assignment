import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

    @Test
    void testLoginWithCorrectDetails() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // Skip DDOS checks
        options.addArguments("--disable-blink-features=AutomationControlled");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://sumup.bg/");

        // Go to login page
        WebElement loginPageButton = driver.findElement(By.xpath("//*[@data-selector='login@action-area']"));
        loginPageButton.click();

        // Wait for login page to load
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("automation.test@example.com");
        passwordField.sendKeys("automation.test@example.com");
        // Wait for login button to become clickable
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for profile page to load
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        WebElement businessDetailsSection = driver.findElement(By.xpath("//*[@data-selector='ACCOUNT.BUSINESS_DETAILS']"));

        driver.close();
    }

    @Test
    void testLoginWithIncorrectDetails() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // Skip DDOS checks
        options.addArguments("--disable-blink-features=AutomationControlled");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://sumup.bg/");

        // Go to login page
        WebElement loginPageButton = driver.findElement(By.xpath("//*[@data-selector='login@action-area']"));
        loginPageButton.click();

        // Wait for login page to load
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("non.existent.email@example.com");
        passwordField.sendKeys("non.existent.email@example.com");
        // Wait for login button to become clickable
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for profile page to load
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        WebElement incorrectDetailsMessage = driver.findElement(By.xpath("//*[contains(text(), 'Грешен имейл адрес или парола')]"));

        driver.close();
    }
}