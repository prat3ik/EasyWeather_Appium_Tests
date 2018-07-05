package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.AppiumUtils;
import utils.PropertyUtils;

import java.text.ParseException;
import java.util.List;

public class CityTempretureDetailsPO extends BasePO {

    public final static String EXECUTION_TYPE = PropertyUtils.getProperty("execution.type", "local");

    protected CityTempretureDetailsPO(AppiumDriver driver) {
        super(driver);
    }

    public void waitTillPageIsLoaded() {
        waitUtils.waitForElementToBeVisible(askQuestionButton, driver);
    }

    @AndroidFindBy(id = "com.shpock.android:id/detail_item_button_question")
    AndroidElement askQuestionButton;

    public void tapOnAskQuestionButton() {
        askQuestionButton.click();
    }

    @AndroidFindBy(id = "com.shpock.android:id/detail_item_button_offer")
    AndroidElement privateOfferButton;

    public void tapOnPrivateOfferButton() {
        privateOfferButton.click();
    }

    @AndroidFindBy(id = "com.shpock.android:id/detail_item_dialog_offer_offer")
    AndroidElement offerTextField;

    @AndroidFindBy(id = "com.shpock.android:id/detail_item_dialog_offer_comment")
    AndroidElement messageTextField;

    public void makeAnOffer(String offerText, String messageText) {
        offerTextField.sendKeys(offerText);
        messageTextField.sendKeys(messageText);
    }

    @AndroidFindBy(id = "com.shpock.android:id/detail_item_button_activity_send")
    AndroidElement makeOfferButton;

    public AndroidElement getMakeOfferButton() {
        return makeOfferButton;
    }


    @AndroidFindBy(id = "com.shpock.android:id/gotit")
    AndroidElement hintGotItButton;

    public void tapOnHintGotItButton() {
        if (hintGotItButton.isDisplayed())
            hintGotItButton.click();
    }


}
