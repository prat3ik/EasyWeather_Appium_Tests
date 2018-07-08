package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.List;

public class WeatherDetailsPO extends BasePO {

    protected WeatherDetailsPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_temperature")
    AndroidElement tempretureForTodayTextView;


    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_city_name")
    AndroidElement cityNameTextView;


    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_current_city_weather")
    AndroidElement weatherConditionTextView;


    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_day_max_temp")
    List<AndroidElement> maxTempretureTextView;

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_day_min_temp")
    List<AndroidElement> minTempretureTextView;

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_day_of_the_week")
    List<AndroidElement> dayNameTextView;


    public String getFirstDayName() {
        return dayNameTextView.get(0).getText();
    }

    public String getSencondDayName() {
        return dayNameTextView.get(1).getText();
    }

    public String getThirdDayName() {
        return dayNameTextView.get(2).getText();
    }

    public String getFourthDayName() {
        return dayNameTextView.get(3).getText();
    }

    public String getFifthDayName() {
        return dayNameTextView.get(4).getText();
    }

    public AndroidElement getMaxTempretureForTwoDaysLater() {
        return maxTempretureTextView.get(0);
    }

    public AndroidElement getMaxTempretureForThreeDaysLater() {
        return maxTempretureTextView.get(1);
    }

    public AndroidElement getMaxTempretureForFourDaysLater() {
        return maxTempretureTextView.get(2);
    }

    public AndroidElement getMaxTempretureForFiveDaysLater() {
        return maxTempretureTextView.get(3);
    }

    public AndroidElement getMaxTempretureForSixDaysLater() {
        return maxTempretureTextView.get(4);
    }

    public AndroidElement getMinTempretureForTwoDaysLater() {
        return minTempretureTextView.get(0);
    }

    public AndroidElement getMinTempretureForThreeDaysLater() {
        return minTempretureTextView.get(1);
    }

    public AndroidElement getMinTempretureForFourDaysLater() {
        return minTempretureTextView.get(2);
    }

    public AndroidElement getMinTempretureForFiveDaysLater() {
        return minTempretureTextView.get(3);
    }

    public AndroidElement getMinTempretureForSixDaysLater() {
        return minTempretureTextView.get(4);
    }

    public void getTemp() {
        System.out.println(tempretureForTodayTextView.getText());
        System.out.println("MAX:");
        System.out.print(getFirstDayName());
        System.out.println(getMaxTempretureForTwoDaysLater());
        System.out.print(getSencondDayName());
        System.out.println(getMaxTempretureForThreeDaysLater());
        System.out.print(getThirdDayName());
        System.out.println(getMaxTempretureForFourDaysLater());
        System.out.print(getFourthDayName());
        System.out.println(getMaxTempretureForFiveDaysLater());
        System.out.print(getFifthDayName());
        System.out.println(getMaxTempretureForSixDaysLater());

        System.out.println("MIN:");
        System.out.print(getFirstDayName());
        System.out.println(getMinTempretureForTwoDaysLater());
        System.out.print(getSencondDayName());
        System.out.println(getMinTempretureForThreeDaysLater());
        System.out.print(getThirdDayName());
        System.out.println(getMinTempretureForFourDaysLater());
        System.out.print(getFourthDayName());
        System.out.println(getMinTempretureForFiveDaysLater());
        System.out.print(getFifthDayName());
        System.out.println(getMinTempretureForSixDaysLater());

    }

    @AndroidFindBy(accessibility = "Navigate up")
    AndroidElement backArrow;

    public DashboardPO backToDashboard() {
        backArrow.click();
        return new DashboardPO(driver);
    }

    public void assertWeather() {
        Assert.assertTrue(tempretureForTodayTextView.isDisplayed());
        Assert.assertTrue(cityNameTextView.isDisplayed());
        Assert.assertTrue(weatherConditionTextView.isDisplayed());
        Assert.assertTrue(dayNameTextView.size()==5, "Days were not displayed properly");
        Assert.assertTrue(maxTempretureTextView.size()==5,"Maximum tempreture may not displayed");
        Assert.assertTrue(minTempretureTextView.size()==5,"Minimum tempreture may not displayed");
        Assert.assertTrue(getMaxTempretureForTwoDaysLater().isDisplayed());
        Assert.assertTrue(getMinTempretureForFiveDaysLater().isDisplayed());
    }

    public void waitTillPageIsLoaded() {
        waitUtils.waitForElementToBeVisible(cityNameTextView, driver);
    }
}
