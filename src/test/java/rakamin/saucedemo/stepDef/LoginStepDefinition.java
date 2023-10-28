package rakamin.saucedemo.stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user should be open https:\\/\\/www.saucedemo.com\\/ in web browser")
    public void user_should_be_open_https_www_saucedemo_com_in_web_browser() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input valid username and password")
    public void user_input_valid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
    }
    @And("user click button Login")
    public void user_click_button_login() throws Exception {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }
    @Then("home page should be displayed")
    public void home_page_should_be_displayed() {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login as valid username");
        System.out.println("If Success Login, You Can See Title Name " + driver.findElement(By.className("title")).getText());
        driver.quit();
    }
}