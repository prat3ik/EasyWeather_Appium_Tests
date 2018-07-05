package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyUtils;
import utils.WaitUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePO {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    public static WaitUtils waitUtils;
    public static Calendar cal;
    /**
     * The driver
     */
    protected final AppiumDriver driver;

    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    protected BasePO(AppiumDriver driver){
        this.driver = driver;
        initElements();
        loadProperties();
        waitUtils = new WaitUtils();
    }


    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    private void loadProperties() {

    }

    /**
     * Tries three times to send text to element properly.
     * <p>
     * Note: This method was needed because Appium sometimes sends text to textboxes incorrectly.
     *
     * @param input         String to be sent
     * @param element       WebElement to receive text, cannot be a secure text field.
     * @return true if keys were successfully sent, otherwise false.
     */
//    protected boolean sendKeysToElement(String input, WebElement element) throws InterruptedException {
//        final int MAX_ATTEMPTS = 3;
//        int attempts = 0;
//
//        do {
//            element.clear();
//            Thread.sleep(KEYBOARD_ANIMATION_DELAY);
//            element.sendKeys(input);
//            Thread.sleep(XML_REFRESH_DELAY);
//        } while (!element.getText().contains(input) && ++attempts < MAX_ATTEMPTS);
//        return element.getText().contains(input);
//    }


    protected void setDeviceDateAndTime() throws ParseException {
        String deviceDateAndTime = driver.getDeviceTime();
        System.out.println("basepo::::"+deviceDateAndTime);
        cal = Calendar.getInstance();
        SimpleDateFormat formatter2 = new SimpleDateFormat("E MMM d hh:mm:ss z yyyy");
        Date date = formatter2.parse(deviceDateAndTime);
        cal.setTime(date);
        System.out.println("Device Time has set:" + cal);
    }

    protected Calendar getDeviceDateAndTime() throws Exception {
        if(cal!=null)
            return cal;
        else
            throw new Exception("Calendar(Date) has not set");
    }

}
