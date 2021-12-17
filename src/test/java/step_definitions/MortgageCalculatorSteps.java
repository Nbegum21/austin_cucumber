package step_definitions;

import Utilities.ReadConfigFiles;
import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    private static final Logger LOGGER= LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is in mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageUrl"));
        LOGGER.info("Landed on the mortgage calculator home page");

    }

    @And("^user navigate to Real Apr page$")
    public void navigatedToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
        LOGGER.info("navigated to Real Apr Page");
    }


    @When("^user click on login button upon entering the date$")
    public void clickOnLoginButtonUponEnteringTheDate(DataTable table) {
        List<Map<String,String>> data = table.asMaps(String.class,String.class);
        for (Map<String,String> cells:data) {
            new RealApr(driver)
                    .TypeHomePrice(cells.get("HomePrice"))
                    .ClickDownPaymentInDollar()
                    .TypeDownPayment(cells.get("DownPayment"))
                    .TypeInterestRate(cells.get("Interest Rate"))
                    .ClickCalculateButton();
        }
        LOGGER.info("Real Apr Rate is calculated upon entering the dare");

    }

    @Then("^the real apr rate is \"(.+?)\"$")
    public void validateRealAprRate(String realApr) {
        new RealApr(driver)
                .ValidatingRealAprRate(realApr);
        LOGGER.info("Real Apr Rate is validated");

    }
}
