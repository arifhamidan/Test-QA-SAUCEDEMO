package saucedemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo")
    public void halamanLoginSaucedemo() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("Input username")
    public void inputUsername() {
        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("user in on dashboard page")
    public void userInOnDashboardPage() {
    }

    @And("Input Invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("test123");

    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String errorLogin  = driver.findElement(By.xpath("//div[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");

    }
}
