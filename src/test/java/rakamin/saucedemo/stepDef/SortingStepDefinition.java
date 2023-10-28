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

public class SortingStepDefinition {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("success login in https:\\/\\/www.saucedemo.com\\/")
    public void success_login_in_https_www_saucedemo_com() throws Exception{
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

    @When("user click Name  \\(A to Z) in top right of page")
    public void user_click_Name_A_to_Z_in_top_right_of_page() throws Exception{
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(500);
    }

    @And("user choose price \\(low to highr)")
    public void user_choose_price_low_to_highr() throws Exception {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
        Thread.sleep(500);
    }

    @Then("will display list product in home page will sorting based on price low to high")
    public void will_display_list_product_in_home_page_will_sorting_based_on_price_low_to_high() {
        Assert.assertEquals("$7.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        System.out.println("Scenario : choose price (low to high)");
        System.out.println("If Success Sorting Price Low to High, You Can See Firt Product Will See Price " + driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.quit();
    }
}