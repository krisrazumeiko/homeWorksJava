package tests;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MtsOnlineTopUpBlockPage;

import java.time.Duration;

@Epic("MTS Payment Tests")       // Общая категория тестов
@Feature("Проверка страницы оплаты")  // Функциональный модуль
public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MtsOnlineTopUpBlockPage paymentPage;

    @Before
    @Step("Настройка браузера и открытие страницы")
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mts.by");
        paymentPage = PageFactory.initElements(driver, MtsOnlineTopUpBlockPage.class);
    }

    @After
    @Step("Закрытие браузера")
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("Проверка заголовка блока 'Онлайн пополнение без комиссии'")
    @Description("Тест проверяет, что заголовок блока оплаты отображается корректно")
    @Story("UI-тесты страницы оплаты")
    public void checkBlockTitle() {
        paymentPage.checkBlockTitle();
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем в блоке 'Онлайн пополнение без комиссии'")
    @Description("Тест проверяет наличие логотипов Visa, Mastercard и др.")
    @Story("UI-тесты страницы оплаты")
    public void checkPaymentSystemLogosPresent() {
        paymentPage.checkPaymentSystemLogosPresent();
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    @Description("Тест проверяет правильный переход после клика по ссылке")
    @Story("UI-тесты страницы оплаты")
    public void checkMoreAboutServiceLink() {
        paymentPage.checkMoreAboutServiceLink();
    }

    @Test
    @DisplayName("Проверка кнопки 'Продолжить' после заполнения полей в блоке 'Онлайн пополнение без комиссии'")
    @Description("Тест проверяет кликабельность кнопки после заполнения полей")
    @Story("UI-тесты страницы оплаты")
    public void checkServiceSelectionAndContinueButton() {
        paymentPage.checkServiceSelectionAndContinueButton();
    }

    @Test
    @DisplayName("Проверка надписей в незаполненных полях каждого варианта оплаты услуг в блоке 'Онлайн пополнение без комиссии'")
    @Description("Тест проверяет, что надписи в незаполненных полях отображаются корректно")
    @Story("UI-тесты страницы оплаты")
    public void checkServiceSelectionForEachPaymentType() {
        paymentPage.checkServiceSelectionForEachPaymentType();
    }

    @Test
    @DisplayName("Проверка отображения суммы, номера телефона, надписей в незаполненных полях для ввода реквизитов карты и наличия иконок платёжных систем в окне для оплаты")
    @Description("Тест проверяет, что сумма, номер телефона, надписи в незаполненных полях и иконки платёжных систем отображаются корректно")
    @Story("UI-тесты страницы оплаты")
    public void checkPaymentFormFieldsAndIcons() {
        paymentPage.checkPaymentFormFieldsAndIcons();
    }
}