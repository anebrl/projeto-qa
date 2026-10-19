import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQAFormBoundaryTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testLimiteMaximoDeDezDigitosNoCelular() {
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement mobileInput = driver.findElement(By.id("userNumber"));
        String limiteValido = "1234567890";

        mobileInput.sendKeys(limiteValido);
        assertEquals(limiteValido, mobileInput.getAttribute("value"),
                "O campo deve aceitar exatamente 10 dígitos.");

        mobileInput.sendKeys("1");
        assertEquals(limiteValido, mobileInput.getAttribute("value"),
                "O campo não deve aceitar um 11º dígito.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
