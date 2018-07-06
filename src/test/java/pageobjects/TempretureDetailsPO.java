package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class TempretureDetailsPO extends BasePO {

    protected TempretureDetailsPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_temperature")
    AndroidElement tempretureForTodayTextView;

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

    public String getMaxTempretureForTwoDaysLater() {
        return maxTempretureTextView.get(0).getText();
    }

    public String getMaxTempretureForThreeDaysLater() {
        return maxTempretureTextView.get(1).getText();
    }

    public String getMaxTempretureForFourDaysLater() {
        return maxTempretureTextView.get(2).getText();
    }

    public String getMaxTempretureForFiveDaysLater() {
        return maxTempretureTextView.get(3).getText();
    }

    public String getMaxTempretureForSixDaysLater() {
        return maxTempretureTextView.get(4).getText();
    }

    public String getMinTempretureForTwoDaysLater() {
        return minTempretureTextView.get(0).getText();
    }

    public String getMinTempretureForThreeDaysLater() {
        return minTempretureTextView.get(1).getText();
    }

    public String getMinTempretureForFourDaysLater() {
        return minTempretureTextView.get(2).getText();
    }

    public String getMinTempretureForFiveDaysLater() {
        return minTempretureTextView.get(3).getText();
    }

    public String getMinTempretureForSixDaysLater() {
        return minTempretureTextView.get(4).getText();
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

}
