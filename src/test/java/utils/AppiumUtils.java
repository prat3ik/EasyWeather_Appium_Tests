package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;

/**
 * This class contains custom appium/selenium methods for Webelement
 */
public class AppiumUtils {
    public static WaitUtils waitUtils = new WaitUtils();

    /**
     * This will check whether element is displayed on UI or not
     *
     * @param element
     * @return
     */
    public static boolean isElementDisplayed(AndroidElement element) {
        waitUtils.staticWait(2000);
        boolean isPresent = false;
        try {
            element.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        }
        return isPresent && element.isDisplayed();
    }

    public static void scrollToElement(MobileElement element, AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int start_Y = (int) (size.getHeight() * 0.80);
        int end_Y = (int) (size.getHeight() * 0.20);
        int start_end_X = (int) (size.getWidth() * 0.50);
        while (!isElementDisplayed((AndroidElement) element)) {
           // driver.swipe(start_end_X, start_Y, start_end_X, end_Y, 2000);
        }
    }

    /**
     * This method is used to generate 4 digit randomNumber
     *
     * @return
     */
    public static String getRandomNumber() {
        return String.valueOf(System.currentTimeMillis() % 100000);
    }

    /**
     * Return whether Alert is displayed or not
     */
    public static boolean isAlertPresent(AppiumDriver driver) {
        boolean alertIsPresent = false;
        try {
            driver.switchTo().alert();
            alertIsPresent = true;
        } catch (Exception ex) {
            alertIsPresent = false;
        }
        return alertIsPresent;
    }

}
