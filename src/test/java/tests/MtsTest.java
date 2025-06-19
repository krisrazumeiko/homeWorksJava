package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.pages.MtsOnlineTopUpBlockPage;

import java.time.Duration;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MtsOnlineTopUpBlockPage paymentPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mts.by");
        paymentPage = PageFactory.initElements(driver, MtsOnlineTopUpBlockPage.class);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void checkBlockTitle() {
        paymentPage.checkBlockTitle();
    }

    @Test
    public void checkPaymentSystemLogosPresent() {
        paymentPage.checkPaymentSystemLogosPresent();
    }

    @Test
    public void checkMoreAboutServiceLink() {
        paymentPage.checkMoreAboutServiceLink();
    }

    @Test
    public void checkServiceSelectionAndContinueButton() {
        paymentPage.checkServiceSelectionAndContinueButton();
    }

    @Test
    public void checkServiceSelectionForEachPaymentType() {
        paymentPage.checkServiceSelectionForEachPaymentType();
    }

    @Test
    public void checkPaymentFormFieldsAndIcons() {
        paymentPage.checkPaymentFormFieldsAndIcons();
    }
}