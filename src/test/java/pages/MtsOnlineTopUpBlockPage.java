package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class MtsOnlineTopUpBlockPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MtsOnlineTopUpBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Проверка названия блока
    public void checkBlockTitle() {
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']")
        ));

        String actualText = header.getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
        String expectedText = "Онлайн пополнение без комиссии";
        assert actualText.equals(expectedText) : "Текст заголовка не совпадает";
    }

    // Проверка логотипов платёжных систем
    public void checkPaymentSystemLogosPresent() {
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']")
        ));
        WebElement block = header.findElement(By.xpath("./ancestor::section"));
        List<WebElement> logos = block.findElements(By.xpath(".//img | .//svg"));
        assert !logos.isEmpty() : "Логотипы платёжных систем не найдены";
    }

    // Проверка ссылки «Подробнее о сервисе»
    public void checkMoreAboutServiceLink() {
        acceptCookiesIfPresent();

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

    // Проверка кнопки «Продолжить» после заполнения полей
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

        // Проверка, что форма оплаты открылась
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));
        driver.switchTo().frame(iframe);
        WebElement paymentFormTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay-description__text']/span")));
        assert paymentFormTitle.isDisplayed() : "Форма оплаты не появилась";
        driver.switchTo().defaultContent();
    }

    public void checkServiceSelectionForEachPaymentType() {
        acceptCookiesIfPresent();

        String[] paymentTypes = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        String[][] expectedPlaceholders = {
                {"Номер телефона", "Сумма"},
                {"Номер абонента", "Сумма"},
                {"Номер счета на 44", "Сумма"},
                {"Номер счета на 2073", "Сумма"}
        };

        WebElement block = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']/ancestor::section")));

        for (int i = 0; i < paymentTypes.length; i++) {
            // Открываем выпадающий список
            WebElement dropdown = block.findElement(By.cssSelector(".select__header"));
            dropdown.click();

            // Ждём, пока список станет видимым
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".select__list[style*='opacity: 1']")));

            // Кликаем по нужному варианту
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//p[normalize-space(text())='" + paymentTypes[i] + "']")));
            option.click();

            // Находим все инпуты в блоке
            List<WebElement> inputs = block.findElements(By.cssSelector("input"));

            // Проверяем, что нужные плейсхолдеры присутствуют
            for (String expected : expectedPlaceholders[i]) {
                boolean found = inputs.stream().anyMatch(input ->
                        input.getAttribute("placeholder") != null &&
                                input.getAttribute("placeholder").contains(expected)
                );
                assert found : "Плейсхолдер '" + expected + "' не найден для типа оплаты: " + paymentTypes[i];
            }
        }
    }

    public void checkPaymentFormFieldsAndIcons() {
        acceptCookiesIfPresent();

        WebElement block = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']/ancestor::section")));

        // Выбор услуги "Услуги связи"
        WebElement dropdown = block.findElement(By.cssSelector(".select__header"));
        dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select__list[style*='opacity: 1']")));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[normalize-space(text())='Услуги связи']")));
        option.click();

        // Ввод номера телефона и суммы
        WebElement phoneInput = block.findElement(By.xpath(".//input[contains(@placeholder, 'Номер телефона')]"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = block.findElement(By.xpath(".//input[contains(@placeholder, 'Сумма')]"));
        amountInput.clear();
        amountInput.sendKeys("5");

        // Нажать кнопку "Продолжить"
        WebElement continueButton = block.findElement(By.xpath(".//button[contains(text(), 'Продолжить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        // Переключаемся в iframe с формой оплаты
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));
        driver.switchTo().frame(iframe);

        // Проверка отображаемой суммы
        WebElement amountInForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay-description__cost']/span")));
        assert amountInForm.getText().contains("5") : "Сумма в форме оплаты не соответствует";

        // Проверка номера телефона
        WebElement phoneInForm = driver.findElement(By.xpath("//div[@class='pay-description__text']/span"));
        assert phoneInForm.getText().contains("Номер:") : "Номер телефона не совпадает";

        // Проверка суммы на кнопке
        WebElement payButton = driver.findElement(By.xpath("//button[@class='colored disabled']"));
        assert payButton.getText().contains("5") : "Сумма на кнопке оплаты некорректна";

        // Проверка placeholder'ов полей карты
        assertFieldPlaceholder("//input[@id='cc-number']", "Номер карты");
        assertFieldPlaceholder("//input[@placeholder=\"MM / YY\"]", "Срок действия");
        assertFieldPlaceholder("//input[@name=\"verification_value\"]", "CVC");
        assertFieldPlaceholder("//input[@autocomplete=\"cc-name\"]", "Имя и фамилия на карте");

        // Проверка наличия иконок платёжных систем
        List<WebElement> logos = driver.findElements(By.xpath("//div[contains(@class, 'cards-brands')]/img"));
        assert !logos.isEmpty() : "Иконки платёжных систем не найдены";

        // Возврат в основной контекст
        driver.switchTo().defaultContent();
    }

    private void assertFieldPlaceholder(String inputXpath, String expectedLabel) {
        WebElement input = driver.findElement(By.xpath(inputXpath));
        WebElement label = input.findElement(By.xpath(
                "./preceding-sibling::label[1] | ./following-sibling::label[1]"
        ));
        String actualLabel = label.getText().trim();
        assert actualLabel.contains(expectedLabel) :
                "Ожидался плейсхолдер: '" + expectedLabel + "', но найдено: '" + actualLabel + "'";
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement cookieAcceptButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
            cookieAcceptButton.click();
        } catch (Exception e) {
            // Ничего не делаем, если баннер не появился
        }
    }
}
