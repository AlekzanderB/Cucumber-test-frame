package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyStepdefs {
    String buffer;
    WebDriver driver;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    @Given("the admin is on Login Page")
    public void theAdminIsOnLoginPage() {
        driver.get("https://shop.pragmatic.bg/admin");
    }

    @When("he enters {string} as username")
    public void heEntersAsUsername(String userName) {
        driver.findElement(By.id("input-username")).sendKeys(userName);
    }

    @And("he enters {string} as password")
    public void heEntersAsPassword(String pass) {
        driver.findElement(By.id("input-password")).sendKeys(pass);
    }

    @And("he clicks over login button")
    public void heClicksOverLoginButton() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("he has the Dashboard page open")
    public void heHasTheDashboardPageOpen() {
        final String text = driver.findElement(By.xpath("//*[@id='content']/div[1]/div/h1")).getText();
        Assert.assertEquals(text, "Dashboard");
    }

    @And("he selects sales drop down menu")
    public void heSelectsSalesDropDownMenu() {
    driver.findElement(By.cssSelector("#menu-sale > a")).click();
    }

    @And("he selects orders option")
    public void heSelectsOrdersOption() {
    driver.findElement(By.xpath("//*[@id='collapse4']/li[1]/a")).click();
    }

    @And("he enters {string} as customer name")
    public void heEntersAsCustomerName(String custName) {
    driver.findElement(By.cssSelector("#input-customer")).sendKeys(custName);
    }

    @And("he uses filter button")
    public void heUsesFilterButton() {
        driver.findElement(By.xpath("//*[@id='button-filter']")).click();
    }

    @Then("he has the orders list from {string}")
    public void heHasTheOrdersListFrom(String userName) {
        final String text = driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr[1]/td[3]")).getText();
       Assert.assertEquals(text,userName);
    }

    @And("he enters {string} as customer order ID")
    public void heEntersAsCustomerOrderID(String orderNumber) {
    driver.findElement(By.xpath("//*[@id='collapse4']/li[1]/a")).sendKeys(orderNumber);
    }


    @Then("he uses the view button")
    public void heUsesTheViewButton() {
        final String dateCreated = driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr/td[6]")).getText();
        driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr/td[8]/div/div/a")).click();
        final String expDateCreated = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div[1]/div/table/tbody/tr[2]/td[2]")).getText();

        Assert.assertEquals(dateCreated,expDateCreated);
    }

    @And("he enters {string} at order status drop down menu")
    public void heEntersAtOrderStatusDropDownMenu(String arg0) {
        final WebElement dropDown = driver.findElement(By.id("input-order-status"));
        Select orderStatus = new Select(dropDown);
        orderStatus.selectByVisibleText("Pending");
    }

    @Then("he sees only pending orders selected")
    public void heSeesOnlyPendingOrdersSelected() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[2]/div/div[1]/ul/li[11]/a")).click();
        final String actualText = driver.findElement(By.cssSelector("#form-order > div > table > tbody > tr:nth-child(12) > td:nth-child(4)")).getText();
        Assert.assertEquals(actualText,"Pending");
    }


}
