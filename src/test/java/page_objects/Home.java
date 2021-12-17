package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home extends NavigatorBar{

    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By SelectDownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HoiInputField = By.id("hoi");
    private final By HoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By RefiOrBuyDropDown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver) {
       super(driver);
    }

    public Home TypeHomePrice(String value) {
        LOGGER.debug("Typing the Home price" + value);
        ActOn.element(driver, HomeValueInputField).setValue(value);
        return this;
    }

    public Home TypeDownPayment(String value) {
        LOGGER.debug("Typing the Down Payment" + value);
        ActOn.element(driver,DownPaymentInputField).setValue(value);
        return this;
    }

    public Home CClickDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ radio Button" );
        ActOn.element(driver,SelectDownPaymentInDollar).click();
        return this;
    }

    public Home TypeLoanAmount (String value) {
        LOGGER.debug("Typing the Loan Amount" + value);
        ActOn.element(driver,LoanAmountInputField).setValue(value);
        return this;
    }

    public Home TypeInterestRate (String value) {
        LOGGER.debug("Typing the Interest Rate" + value);
        ActOn.element(driver,InterestRateInputField).setValue(value);
        return this;
    }

    public Home TypeLoanTermYears (String value) {
        LOGGER.debug("Typing the Loan Term" + value);
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }

    public Home SelectMonth(String month) {
        LOGGER.debug("Selecting the Start Month" + month);
        ActOn.element(driver,StartMonthDropDown).selectValue(month);
        return this;
    }

    public Home TypeYear(String year) {
        LOGGER.debug("Selecting the start year" + year);
        ActOn.element(driver,StartYearInputField).setValue(year);
        return this;
    }

    public Home TypePropertyTax (String value) {
        LOGGER.debug("Typing the property tax" +value);
        ActOn.element(driver,PropertyTaxInputField ).setValue(value);
        return this;
    }

    public Home TpePmi(String value) {
        LOGGER.debug("Typing the Pmi" +value);
        ActOn.element(driver,PmiInputField ).setValue(value);
        return this;
    }
    public Home TpeHoi(String value) {
        LOGGER.debug("Typing the Hoi" +value);
        ActOn.element(driver,HoiInputField ).setValue(value);
        return this;
    }

    public Home TypeHoa(String value) {
        LOGGER.debug("Typing the HOA" +value);
        ActOn.element(driver,HoaInputField ).setValue(value);
        return this;

    }

    public Home SelectLoanType(String value) {
        LOGGER.debug("Selecting the Loan Type" +value);
        ActOn.element(driver,LoanTypeDropDown).selectValue(value);
        return this;
    }

    public Home SelectBuyOrRefiOption(String value) {
        LOGGER.debug("Selecting the BuyOrRefi option" +value);
        ActOn.element(driver,RefiOrBuyDropDown).selectValue(value);
        return this;
    }

    public Home ClickCalculateButton() {
        LOGGER.debug("Selecting on Calculate Button" );
        ActOn.element(driver,CalculateButton).click();
        return this;
    }

    public Home ValidateTotalMonthlyPayment(String expectedTotalMonthlyPayment) {
        String formattedXpath = String.format("//h3[text()= '%s']",expectedTotalMonthlyPayment);
        By monthlyPayment = By.xpath(formattedXpath);

        LOGGER.debug("Validated that the total monthly payment is" + expectedTotalMonthlyPayment);
        AssertThat.elementAssertions(driver,monthlyPayment).elementIsDisplayed();
        return this;
    }

}
