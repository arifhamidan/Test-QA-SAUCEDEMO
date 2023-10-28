package rakamin.saucedemo.stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartStepDefinition {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login in https:\\/\\/www.saucedemo.com\\/")
    public void user_login_in_https_www_saucedemo_com() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @When("user click button Add to Cart in first list product")
    public void user_click_button_add_to_cart_in_first_list_product() throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @And("user click icon cart")
    public void user_click_icon_cart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(500);
    }

    @Then("in cart page, will show product user which choose")
    public void in_cart_page_will_show_product_user_which_choose() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Adding product to cart");
        System.out.println("If Success Add Product to Cart " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + " , You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in Cart Page");
        driver.quit();
    }
}