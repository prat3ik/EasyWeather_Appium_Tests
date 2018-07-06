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
    AndroidElement tempretureForToday;

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_day_max_temp")
    List<AndroidElement> maxTempreture;

    @AndroidFindBy(id = "com.example.harry.myapplication:id/textview_day_min_temp")
    List<AndroidElement> minTempreture;

    public String getMaxTempretureForTwoDaysLater(){
        return  maxTempreture.get(0).getText();
    }

    public String getMaxTempretureForThreeDaysLater(){
        return  maxTempreture.get(1).getText();
    }

    public String getMaxTempretureForFourDaysLater(){
        return  maxTempreture.get(2).getText();
    }

    public String getMaxTempretureForFiveDaysLater(){
        return  maxTempreture.get(3).getText();
    }

    public String getMaxTempretureForSixDaysLater(){
        return  maxTempreture.get(4).getText();
    }

    public String getMinTempretureForTwoDaysLater(){
        return  minTempreture.get(0).getText();
    }

    public String getMinTempretureForThreeDaysLater(){
        return  minTempreture.get(1).getText();
    }

    public String getMinTempretureForFourDaysLater(){
        return  minTempreture.get(2).getText();
    }

    public String getMinTempretureForFiveDaysLater(){
        return  minTempreture.get(3).getText();
    }

    public String getMinTempretureForSixDaysLater(){
        return  minTempreture.get(4).getText();
    }

    public void getTemp(){
        System.out.println(tempretureForToday.getText());
        System.out.println("MAX:");
        System.out.println(getMaxTempretureForTwoDaysLater());
        System.out.println(getMaxTempretureForThreeDaysLater());
        System.out.println(getMaxTempretureForFourDaysLater());
        System.out.println(getMaxTempretureForFiveDaysLater());
        System.out.println(getMaxTempretureForSixDaysLater());

        System.out.println("MIN:");
        System.out.println(getMinTempretureForTwoDaysLater());
        System.out.println(getMinTempretureForThreeDaysLater());
        System.out.println(getMinTempretureForFourDaysLater());
        System.out.println(getMinTempretureForFiveDaysLater());
        System.out.println(getMinTempretureForSixDaysLater());

    }

}
