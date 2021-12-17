package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorBar {
    public WebDriver driver;

    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");

    private static final Logger LOGGER = LogManager.getLogger(NavigatorBar.class);

    public NavigatorBar(WebDriver driver){
        this.driver = driver;
    }
    public NavigatorBar mouseHoverToRates(){
        LOGGER.debug("Mouse Hover to Rates Link");
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }
    public RealApr navigateToRealApr() {
        LOGGER.debug("Navigating to Real apr link");
        ActOn.element(driver,RealAprLink).click();
        return new RealApr(driver);
    }
    public Home navigateToHome() {
        LOGGER.debug("Navigating to Mortgage Calculator Logo");
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }


    }

