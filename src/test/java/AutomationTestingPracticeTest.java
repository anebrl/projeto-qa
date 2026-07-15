import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomationTestingPracticeTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configura o Chrome para rodar em modo "Headless" (sem interface gráfica - essencial para CI)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testFormularioSimples() {
        // Acessa o site de práticas
        driver.get("https://testautomationpractice.blogspot.com/");

        // Preenche o campo Nome
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("Automação Selenium");

        // Seleciona o gênero "Male"
        WebElement maleRadio = driver.findElement(By.id("male"));
        maleRadio.click();

        // Valida se o radio button foi de fato selecionado
        assertTrue(maleRadio.isSelected(), "O radio button de gênero deveria estar selecionado.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}