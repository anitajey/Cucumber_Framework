package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefinition_UserRegistration {

    String baseUrl = "http://automationpractice.com/index.php";
    public WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @After
    public void TearDown(){
        //driver.quit();
        // driver.close();
    }

    @Given("^I am on Home Page$")
    public void isUserOnHomePage() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#home-page-tabs")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^I click on SIGN IN link$")
    public void selectSignInLink() throws InterruptedException {
        Thread.sleep(10000);
        WebElement signInLink = driver.findElement(By.cssSelector(".login"));
        signInLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^I should be on the authentication page$")
    public void isUserOnAuthenticationPage()throws InterruptedException {
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.cssSelector("#create-account_form")).isDisplayed());
    }

    @When("User enters email as {string}")
    public void verifyUserEntersEmailAddress(String createEmail) throws InterruptedException {
        WebElement createEmailVar = driver.findElement(By.cssSelector("#email_create"));
        createEmailVar.sendKeys(createEmail);
    }

    @And("^User clicks on Create An Account button$")
    public void verifyUserClicksOnCreateAccountButton() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^User should be on Create An Account page$")
    public void verifyUserIsOnCreateAccountPage() throws InterruptedException {
        Thread.sleep(10000);
        WebElement createAccountPage = driver.findElement(By.cssSelector("#account-creation_form"));
        Assert.assertTrue(createAccountPage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("User provide title {string}, first name {string}, last name {string}, password {string}")
    public void enterPersonalDetails(String titleVal, String firstnameVal, String lastnameVal, String passwordVal) throws InterruptedException {
        Thread.sleep(10000);
        if (titleVal.equalsIgnoreCase("Mr")) {
            WebElement title1 = driver.findElement(By.cssSelector("#id_gender1"));
            title1.click();
        } else if (titleVal.equalsIgnoreCase("Mrs")) {
            WebElement title2 = driver.findElement(By.cssSelector("#id_gender2"));
            title2.click();
        }
        WebElement firstName = driver.findElement(By.cssSelector("#customer_firstname"));
        firstName.sendKeys(firstnameVal);
        WebElement lastName = driver.findElement(By.cssSelector("#customer_lastname"));
        lastName.sendKeys(lastnameVal);
        WebElement password = driver.findElement(By.cssSelector("#passwd"));
        password.sendKeys(passwordVal);

    }

    @And ("User selects DOB {string}, month {string} and year {string}")
    public void enterDOB(String dateVal, String monthVal, String yearVal) throws InterruptedException {
        Thread.sleep(10000);
        WebElement dateOfBirth = driver.findElement(By.cssSelector("#days"));
        Select select1 = new Select(dateOfBirth);
        select1.selectByValue(dateVal);

        WebElement monthOfBirth = driver.findElement(By.cssSelector("#months"));
        Select select2 = new Select(monthOfBirth);
        select2.selectByValue(monthVal);

        WebElement yearOfBirth = driver.findElement(By.cssSelector("#years"));
        Select select3 = new Select((yearOfBirth));
        select3.selectByValue(yearVal);

    }

    @And ("^User provides address as below:$")
    public void enterAddress(DataTable table) throws InterruptedException {
        Thread.sleep(10000);
        List<String> data = table.asList();
        String address = (data.get(0));
        driver.findElement(By.cssSelector("#address1")).sendKeys(address);
        driver.findElement(By.cssSelector("#city")).sendKeys(data.get(1));
        driver.findElement(By.cssSelector("#postcode")).sendKeys(data.get(2));

    }

    @And ("User selects the state {string} and country {string}")
    public void enterStateandCountry(String stateVal, String countryVal) throws InterruptedException {
        Thread.sleep(10000);
        WebElement state = driver.findElement(By.cssSelector("#id_state"));
        Select select1 = new Select(state);
        select1.selectByVisibleText(stateVal);
        WebElement country = driver.findElement(By.cssSelector("#id_country"));
        Select select2 = new Select(country);
        select2.selectByVisibleText(countryVal);
    }

    @And ("User enter the mobile number {string}")
    public void enterMobileNumber(String mobileNum){
        WebElement mobile = driver.findElement(By.cssSelector("#phone_mobile"));
        mobile.sendKeys(mobileNum);
    }

    @And ("User clicks on register button")
    public void clickRegisterButton() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#submitAccount")).click();
    }

    @Then ("User should see error message as {string}")
    public void verifyErrorMessage(String actualError){
        String expectedError = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        Assert.assertTrue(actualError.contains(expectedError));
        Assert.assertEquals(expectedError,actualError);
    }
}
