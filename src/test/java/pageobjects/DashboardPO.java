package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;
import utils.AppiumUtils;

import java.util.List;

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

    public SearchPO tapOnAddLocationFloatingButton() {
        addLocationFloatingButton.click();
        return new SearchPO(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dublin']")
    AndroidElement dublinCityTextView;

    public TempretureDetailsPO tapOnDublinCityTextView() {
        dublinCityTextView.click();
        return new TempretureDetailsPO(driver);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_city_name")
    List<AndroidElement> cityNameTextView;

    public int getCityCardIndex(String cityName) {
        int index = 0;
        for (AndroidElement cityEl : cityNameTextView) {
            System.out.println(cityEl.getText());
            if (cityName.equals(cityEl.getText()))
                return index;
            index++;
        }
        return -1;
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/card_container")
    List<AndroidElement> cityNameCardContainer;

    public void removeCity(String cityName) {
        int index = getCityCardIndex(cityName);
        AndroidElement el = cityNameCardContainer.get(index);
        int leftX = el.getLocation().getX();
        int rightX = leftX + el.getSize().getWidth();
        int upperY = el.getLocation().getY();
        int lowerY = upperY + el.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;
        AppiumUtils.doSwipe(rightX, middleY, leftX, middleY, driver);
    }


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
