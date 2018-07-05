package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class DashboardPO extends BasePO {

    public DashboardPO(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.example.harry.myapplication:id/fab")
    AndroidElement addLocationFloatingButton;

    public void tapOnHintGotItButton() {
        if (addLocationFloatingButton.isDisplayed())
            addLocationFloatingButton.click();
    }

    public void waitTillDashboardPOAppeared() throws InterruptedException {
        Thread.sleep(500);
        waitUtils.waitForElementToBeVisible(addLocationFloatingButton, driver);
    }

    public void tapOnAddLocationFloatingButton(){
        addLocationFloatingButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dublin']")
    AndroidElement dublinCityTextView;

    public void tapOnDublinCityTextView(){
        dublinCityTextView.click();
    }
//
//    @AndroidFindBy(id = "com.shpock.android:id/search_src_text")
//    AndroidElement searchTextField;
//
//    public void searchItem(String productText) {
//        searchButton.click();
//        searchTextField.sendKeys(productText);
//        waitUtils.staticWait(1500);
//        driver.findElement(By.id("com.shpock.android:id/search_item_title")).click();
//        tapOnHintGotItButton();
//    }
//
//    @AndroidFindBy(id = "com.shpock.android:id/itemContainer")
//    AndroidElement firstProductCard;
//
//    public CityTempretureDetailsPO tapOnFirstProduct(){
//        firstProductCard.click();
//        CityTempretureDetailsPO cityTempretureDetailsPO = new CityTempretureDetailsPO(driver);
//        cityTempretureDetailsPO.tapOnHintGotItButton();
//        cityTempretureDetailsPO.tapOnHintGotItButton();
//        return cityTempretureDetailsPO;
//    }

}
