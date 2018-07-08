/**
 * Year: 2018-2019
 * Pratik Patel(https://github.com/prat3ik)
 */
package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import utils.AppiumUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Page Objects for Dashboard(App Launching) Screen
 *
 * @author prat3ik
 */
public class DashboardPO extends BasePO {

    public DashboardPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dublin']")
    AndroidElement firstCityName;

    public void tapOnFirstCity() {
        firstCityName.click();
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/fab")
    AndroidElement addLocationFloatingButton;

    public void tapOnHintGotItButton() {
        if (addLocationFloatingButton.isDisplayed())
            addLocationFloatingButton.click();
    }

    /**
     * This method will wait until Dashboard(Launching Screen) is present.
     * Ideally this should be called at very first step of every test case.
     *
     * @throws InterruptedException
     */
    public void waitTillDashboardPOAppeared() throws InterruptedException {
        Thread.sleep(500);
        waitUtils.waitForElementToBeVisible(addLocationFloatingButton, driver);
    }

    /**
     * It will Tap(Click) on Add City(Floating) button.
     *
     * @return
     */
    public SearchPO tapOnAddLocationFloatingButton() {
        addLocationFloatingButton.click();
        return new SearchPO(driver);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_city_name")
    List<AndroidElement> cityNameTextView;

    /**
     * This method will give CardLayout index for given City Name.
     *
     * @param cityName
     * @return
     */
    public AndroidElement getCityCardIndex(String cityName) {
        String lastCityInLoop = "";
        String lastCity1 = "";
        boolean isCityFound = false;
        List<AndroidElement> cityNameTextView = driver.findElements(By.id("com.example.harry.myapplication:id/textview_city_name"));

        while (!isCityFound) {
            lastCity1 = cityNameTextView.get(cityNameTextView.size() - 1).getText();
            for (AndroidElement cityEl : cityNameTextView) {
                if (cityName.equals(cityEl.getText())) {
                    return cityEl;// index;
                }
            }
            AppiumUtils.verticalScroll(driver);
            cityNameTextView = driver.findElements(By.id("com.example.harry.myapplication:id/textview_city_name"));
            String lastCity2 = cityNameTextView.get(cityNameTextView.size() - 1).getText();
            if (lastCity1.equals(lastCity2)) {
                System.out.println("Breaking the loop");
                break;
            }
        }
        return null;
    }

    /**
     * This method will tap on particular city
     */
    public WeatherDetailsPO tapOnCity(String cityName) {
        AndroidElement el = getCityCardIndex(cityName);
        el.click();
        WeatherDetailsPO po = new WeatherDetailsPO(driver);
        po.waitTillPageIsLoaded();
        return po;
    }

    /**
     * It will remove given city from Dashboard
     *
     * @param cityName
     */
    public void removeCity(String cityName) {
        AndroidElement el = getCityCardIndex(cityName);
        Dimension size = driver.manage().window().getSize();
        int screenWidth = size.getWidth();
        int screenHeight = size.getHeight();
        int leftX = el.getLocation().getX();
        int rightX = leftX + el.getSize().getWidth();
        int upperY = el.getLocation().getY();
        int lowerY = upperY + el.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;
        AppiumUtils.doSwipe((int) (rightX + (screenWidth * 0.3)), middleY, leftX, middleY, driver);
    }

    /**
     * This method is used to get All City Names.
     *
     * @return
     */
    public Set<String> getAllCities() {
        boolean isLastCityPresent = false;
        Set<String> cityNames = new HashSet<String>();
        List<AndroidElement> cityNameTextView = driver.findElements(By.id("com.example.harry.myapplication:id/textview_city_name"));
        String lastCityName = "";
        while (!isLastCityPresent) {
            lastCityName = cityNameTextView.get(cityNameTextView.size() - 1).getText();
            for (AndroidElement city : cityNameTextView) {
                cityNames.add(city.getText());
            }
            AppiumUtils.verticalScroll(driver);
            cityNameTextView = driver.findElements(By.id("com.example.harry.myapplication:id/textview_city_name"));
            String lastCityNameAfterScroll = cityNameTextView.get(cityNameTextView.size() - 1).getText();
            if (lastCityName.equals(lastCityNameAfterScroll)) {
                break;
            }
        }
        return cityNames;
    }

    /**
     * This method will scroll until The First city on Dashboard is reached.
     */
    public void moveToFirstCity() {
        AppiumUtils.scrollUpToElement(firstCityName, driver);
    }

}
