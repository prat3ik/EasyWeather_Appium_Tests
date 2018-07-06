package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.*;

import java.util.Arrays;
import java.util.List;

public class TestCases extends BaseTest {

    DashboardPO dashboardPO;
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    @Override
    public void setUpPage() {
        dashboardPO = new DashboardPO(driver);
    }

    @Test
    public void verifyUserCanMakeTheOffer() throws InterruptedException {
        final List<String> citiesToBeAdded = Arrays.asList("Vienna", "Surat", "Berlin");
        final String password = "test";

        dashboardPO.waitTillDashboardPOAppeared();
        TempretureDetailsPO tempretureDetailsPO = dashboardPO.tapOnDublinCityTextView();
        tempretureDetailsPO.getTemp();
        //SearchPO searchPO = dashboardPO.tapOnAddLocationFloatingButton();
        //searchPO.addCity("Surat");
        waitUtils.staticWait(5000);


        //Assert.assertTrue(cityTempretureDetailsPO.getMakeOfferButton().isDisplayed(), "Make Offer button didn't display");
    }


}
