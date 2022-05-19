package StepDefinitions;

import Pages.Search_Page;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Search_Steps {


    private static String title;
    private Search_Page searchPage1 = new Search_Page(DriverFactory.getDriver());

    private ConfigReader configReader;

    private WebDriver driver = DriverFactory.getDriver();

    Properties prop;


    @Then("Provide Authentication to the page")
    public void Provide_Authentication_to_the_page() throws InterruptedException {

        Alert alt = driver.switchTo().alert();

        alt.sendKeys(prop.getProperty("authpassword"));
        alt.accept();

        Thread.sleep(2000);


    }


    @Given("navigate to Search Page")
    public void navigate_to_search_page() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();

        DriverFactory.getDriver()
                .get(prop.getProperty("url"));


    }

    @When("identify Search Page title")
    public void identify_search_page_title() {
        title = searchPage1.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }


    @When("Provide Search Input {string}")
    public void Provide_Search_Input(String Query) throws InterruptedException {

        WebElement searchinput = driver.findElement(By.xpath("//input[@id='search-input']"));
        searchinput.clear();
        searchinput.sendKeys(Query);
        searchinput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


    @When("Check for the AutoSuggest")

    public void Check_for_the_AutoSuggest() throws InterruptedException {

        WebElement autosuggest = driver.findElement(By.id("search-input"));
        autosuggest.clear();
        autosuggest.click();
        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement Autosuggestcontainer = driver.findElement(By.xpath("//*[@id=\"autosuggest-container\"]/ul"));
        String autosuggestdata = Autosuggestcontainer.getText();
        System.out.println("Elememts under Autosuggestions are \n" + autosuggestdata);
        WebElement autosuggestelements = driver.findElement(By.xpath("//*[@id=\"autosuggest-container\"]/ul/li[1]"));
        autosuggestelements.click();
        Thread.sleep(3000);

    }

    @Then("Search Results Should Display {string}")
    public void Search_Results_Should_Display(String extectedresults) throws InterruptedException {

        WebElement results = driver.findElement(By.id("results-container"));
        System.out.println(results.getText());

        Assert.assertTrue(results.getText().contains(extectedresults));
    }


    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }


    @Then("Search Results for the invalid query Should Display {string}")

    public void Search_Results_for_the_invalid_query_Should_Display(String extectedresults) {

        WebElement results = driver.findElement(By.id("results-container-main"));
        System.out.println(results.getText());

        Assert.assertTrue(results.getText().contains(extectedresults));

    }


}
