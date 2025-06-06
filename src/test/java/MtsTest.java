import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mts.by");
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    //Проверка названия блока
    @Test
    public void checkBlockTitle() {
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']")
        ));

        String actualText = header.getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
        String expectedText = "Онлайн пополнение без комиссии";
        assert actualText.equals(expectedText) : "Текст заголовка не совпадает";
    }

    //Проверка логотипов платёжных систем
    @Test
    public void checkPaymentSystemLogosPresent() {
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']")
        ));
        WebElement block = header.findElement(By.xpath("./ancestor::section"));
        List<WebElement> logos = block.findElements(By.xpath(".//img | .//svg"));
        assert !logos.isEmpty() : "Логотипы платёжных систем не найдены";
    }

    //Проверка ссылки «Подробнее о сервисе»
    @Test
    public void checkMoreAboutServiceLink() {
        acceptCookiesIfPresent(); //обязательно

        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']")
        ));
        WebElement block = header.findElement(By.xpath("./ancestor::section"));
        WebElement link = block.findElement(By.xpath(".//a[contains(text(), 'Подробнее о сервисе')]"));

        assert link.isDisplayed() && link.isEnabled() : "Ссылка неактивна";

        String initialUrl = driver.getCurrentUrl();
        link.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
    }

    //Проверка кнопки «Продолжить» после заполнения полей
    @Test
    public void checkServiceSelectionAndContinueButton() {
        acceptCookiesIfPresent();

        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']")
        ));
        WebElement block = header.findElement(By.xpath("./ancestor::section"));

        // Убедиться, что тип услуги "Услуги связи"
        WebElement serviceType = block.findElement(By.xpath(".//span[@class='select__now' and normalize-space()='Услуги связи']"));
        assert serviceType != null : "Тип услуги 'Услуги связи' не найден";

        // Ввод номера телефона
        WebElement phoneInput = block.findElement(By.xpath(".//input[contains(@placeholder, 'Номер телефона')]"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        // Ввод суммы
        WebElement amountInput = block.findElement(By.xpath(".//input[contains(@placeholder,'Сумма')]"));
        amountInput.clear();
        amountInput.sendKeys("5");

        // Кнопка «Продолжить»
        WebElement continueButton = block.findElement(By.xpath(".//button[contains(text(), 'Продолжить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    //метод нажимает кнопку согласия с cookies
    private void acceptCookiesIfPresent() {
        try {
            WebElement cookieAcceptButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
            cookieAcceptButton.click();
        } catch (Exception e) {
            // Ничего не делаем, если баннер не появился — продолжаем
        }
    }
}