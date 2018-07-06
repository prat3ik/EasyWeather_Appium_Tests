package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;

public class SearchPO extends BasePO {

    protected SearchPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/edittext_toolbar_city_search")
    AndroidElement searchBox;

    protected void doSearch(String input){
        searchBox.sendKeys(input);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/content_layout_found_city")
    AndroidElement searchSuggestion;

    protected void selectFirstSuggestion(){
        waitUtils.waitForElementToBeVisible(searchSuggestion,driver);
        searchSuggestion.click();
    }

    public void addCity(String cityName){
        doSearch(cityName);
        selectFirstSuggestion();
    }

}
