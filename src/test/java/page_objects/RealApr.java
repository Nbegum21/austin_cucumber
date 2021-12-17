package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigatorBar{

    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HoneVPriceInputField = By.name("HomeValue");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By DownPaymentInDollarRadioButton = By.name("DownPaymentSel");
    private final By InterestRateInputField = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualApr = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER= LogManager.getLogger(RealApr.class);

    public RealApr (WebDriver driver) {
        super(driver);
    }

    public RealApr WaitForPgeToLoad() {
        LOGGER.debug("waiting for the real page to load");
        ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
        return this;
    }

    public RealApr TypeHomePrice(String value) {
        LOGGER.debug("Tyoing the Home Price" + value);
        ActOn.element(driver, HoneVPriceInputField).setValue(value);
        return this;
    }

    public RealApr TypeDownPayment(String value) {
        LOGGER.debug("Typing the down Payment" + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public RealApr ClickDownPaymentInDollar() {
        LOGGER.debug("Clicking on the radio Button of down payment in dollar");
        ActOn.element(driver, DownPaymentInDollarRadioButton).click();
        return this;
    }

    public RealApr TypeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate" + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public RealApr ClickCalculateButton() {
        LOGGER.debug("Clicking the calculate Button");
        ActOn.element(driver,CalculateButton).click();
        return this;
    }

    public RealApr ValidatingRealAprRate(String expectedAprRate) {
        LOGGER.debug("Validating to the real apr rate is" +expectedAprRate);
        String actualRealAprRate =  ActOn.element(driver,ActualApr).getTextValue();
        Assert.assertEquals(expectedAprRate,actualRealAprRate);
        return this;
    }
}



