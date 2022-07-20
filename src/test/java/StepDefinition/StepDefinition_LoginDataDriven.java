/*package StepDefinition;

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
import java.util.concurrent.TimeUnit;


public class StepDefinition_LoginDataDriven {

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
        driver.close();
    }

    @Given("^I am on Home Page$")
    public void isUserOnHomePage(){
        Assert.assertTrue(driver.findElement(By.cssSelector("#home-page-tabs")).isDisplayed());
    }

    @When("^I click on SIGN IN link$")
    public void selectSignInLink(){
        WebElement signInLink = driver.findElement(By.cssSelector(".login"));
        signInLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^I should be on the authentication page$")
    public void isUserOnAuthenticationPage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.cssSelector("#create-account_form")).isDisplayed());
    }

    @When("^I enter the Email Address as (.*) Password as (.*)$")
    public void enterValidLoginCredentials(String email, String password){
        WebElement loginEmail = driver.findElement(By.cssSelector("#email"));
        loginEmail.sendKeys(email);
        WebElement loginPassword = driver.findElement(By.cssSelector("#passwd"));
        loginPassword.sendKeys(password);
    }

    @And("^I click on the SIGN IN button$")
    public void selectSignInButton(){
        WebElement signInBtn = driver.findElement(By.cssSelector("#SubmitLogin"));
        signInBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^I should be LOGGED IN successfully$")
    public void verifyLogin(){
        driver.getTitle().contains("My account");
    }

    @And("^I should be on MY ACCOUNT page$")
    public void verifyUserIsOnMyAccountPage(){
        Assert.assertTrue(driver.findElement(By.cssSelector(".myaccount-link-list")).isDisplayed());
    }

    @And("^I should see validation message (.*)$")
    public void verifyValidationMessage(String validation_message){
        String expected_validationMsg;
        expected_validationMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        Assert.assertEquals(expected_validationMsg,validation_message);

    }

}*/
