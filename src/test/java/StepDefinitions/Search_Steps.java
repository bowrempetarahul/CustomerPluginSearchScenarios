package StepDefinitions;

import Pages.Search_Page;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Properties;

public class Search_Steps {


    private static String title;
   private Search_Page searchPage1 = new Search_Page(DriverFactory.getDriver());

    private ConfigReader configReader;

    private WebDriver driver = DriverFactory.getDriver();

    Properties prop;

    @Given("navigate to Search Page")
    public void navigate_to_search_page() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();

        DriverFactory.getDriver()
                .get(prop.getProperty("url"));


    }

    @When("identify Search Page title")
    public void identify_search_page_title() {

        Alert alt = driver.switchTo().alert();

        alt.sendKeys("Demo_NYP@2022");
        alt.accept();
        title = searchPage1.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }



    @When("Provide Search Input {string}")
    public void Provide_Search_Input(String Query) throws InterruptedException {

        Alert alt = driver.switchTo().alert();

        alt.sendKeys("Demo_NYP@2022");
        alt.accept();

        Thread.sleep(2000);
        WebElement searchinput = driver.findElement(By.xpath("//input[@id='search-input']"));
        searchinput.clear();
        searchinput.sendKeys(Query);
        searchinput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
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

}
