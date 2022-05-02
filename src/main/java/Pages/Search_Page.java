package Pages;

import org.openqa.selenium.WebDriver;

public class Search_Page {

    private WebDriver driver;

    // 1. By Locators: OR

    // 2. Constructor of the page class:
    public Search_Page(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }




}
