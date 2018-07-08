/**
 * Year: 2018-2019
 * Pratik Patel(https://github.com/prat3ik)
 */
package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;
import utils.AppiumUtils;

import java.util.List;
/**
 * Page Objects for Search Screen
 * @author prat3ik
 */
public class SearchPO extends BasePO {

    protected SearchPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/edittext_toolbar_city_search")
    AndroidElement searchBox;

    /**
     * This will perform search operation
     * @param input
     */
    protected void doSearch(String input) {
        searchBox.clear();
        searchBox.sendKeys(input);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/content_layout_found_city")
    AndroidElement searchSuggestion;

    /**
     * It will select the first suggestion when user type city name in searchbox
     */
    protected void selectFirstSuggestion() {
        waitUtils.waitForElementToBeVisible(searchSuggestion, driver);
        searchSuggestion.click();
    }

    /**
     * This method should be use at Test Case in order to add the City to Dashboard
     * @param cityName
     */
    public void addCity(String cityName) {
        doSearch(cityName);
        if(!AppiumUtils.isElementDisplayed(searchSuggestion)){
            doSearch(cityName);
        }
        searchSuggestion.click();
    }

}
