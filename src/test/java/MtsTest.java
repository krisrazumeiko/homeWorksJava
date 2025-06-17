import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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

        List<String> allowedAltTexts = Arrays.asList("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        for (WebElement logo : logos) {
            String tagName = logo.getTagName();

            if ("img".equalsIgnoreCase(tagName)) {
                String src = logo.getAttribute("src");
                assertNotNull(src, "У <img> отсутствует атрибут src");
                assertFalse("У <img> src пустой", src.trim().isEmpty());

                String alt = logo.getAttribute("alt");
                assertNotNull(alt, "У <img> отсутствует атрибут alt");
                assertFalse("У <img> alt пустой", alt.trim().isEmpty());

                // Проверка соответствия alt списку допустимых значений
                assertTrue("Недопустимое значение alt: " + alt, allowedAltTexts.contains(alt.trim()));

            } else if ("svg".equalsIgnoreCase(tagName)) {
                String svgContent = logo.getAttribute("outerHTML");
                assertNotNull(svgContent, "SVG контент отсутствует");
                assertTrue("SVG не содержит <svg> разметку", svgContent.contains("<svg"));

            } else {
                fail("Неожиданный тег: " + tagName);
            }
        }
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

        //Провекра, что форма оплаты открылась
        // Переключиться в iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'widget_v2/index.html')]")));
        driver.switchTo().frame(iframe);
        // Проверка названия формы
        WebElement paymentFormTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), 'Оплата: Услуги связи')]")));
        assert paymentFormTitle.isDisplayed() : "Форма оплаты не появилась";
        // Вернуться назад в основной контекст
        driver.switchTo().defaultContent();
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