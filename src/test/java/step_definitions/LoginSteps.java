package step_definitions;

import Utilities.ReadConfigFiles;
import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.List;
import java.util.Map;


public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By Logout = By.id("logout");
    private static final By invalidPassword = By.xpath("//*[@id='pageLogin']/form//div[text()='Password is invalid']");

    private static final Logger LOGGER= LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;


    @Given("^a user is on the login page$")
    public void navigateToLoginPage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("TestAppUrl"));
        LOGGER.info("a user is on the login page");
    }

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
         ActOn.element(driver, FullName).setValue(username);
         ActOn.element(driver, Password).setValue(password);
        LOGGER.info("User has entered credentials");
    }

    @And("^click on login button$")
    public void clickOnLogin() {
      ActOn.element(driver,Login).click();
        LOGGER.info("User clicked on login button");
    }

    @When("^user click on login button upon entering credentials$")
    public void userClickOnLoginButtonUponEnteringCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String, String> cells:data) {
            ActOn.element(driver, FullName).setValue(cells.get("username"));
            ActOn.element(driver, Password).setValue(cells.get("password"));
            LOGGER.info("User has entered credentials");

            ActOn.element(driver,Login).click();
            LOGGER.info("User clicked on login button");
        }
    }

        @Then("^user is navigated to home page$")
    public void validateUserIsLoggedSuccessfully() {
        AssertThat.elementAssertions(driver,Logout).elementIsDisplayed();
        LOGGER.info("User is navigated to home page");
    }

    @Then("^user is failed to login$")
    public void validateUserIsFailedToLogin() {
        AssertThat.elementAssertions(driver,invalidPassword).elementIsDisplayed();
        LOGGER.info("logger is still ON THE login page");
    }

}