package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.*;

import java.io.IOException;
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
    public void verifyUserCanMakeTheOffer() throws InterruptedException, IOException {
        final List<String> citiesToBeAdded = Arrays.asList("Vienna", "Surat", "Berlin");
        final String password = "test";

        dashboardPO.waitTillDashboardPOAppeared();
        dashboardPO.removeCity(DefaultCities.LONDON.getCityName());
        dashboardPO.removeCity(DefaultCities.DUBLIN.getCityName());
        dashboardPO.removeCity(DefaultCities.BARCELONA.getCityName());




        //SearchPO searchPO = dashboardPO.tapOnAddLocationFloatingButton();
        //searchPO.addCity("Surat");
        waitUtils.staticWait(5000);


        //Assert.assertTrue(cityTempretureDetailsPO.getMakeOfferButton().isDisplayed(), "Make Offer button didn't display");
    }

    public enum DefaultCities {
        DUBLIN("Dublin"),
        LONDON("London"),
        NEW_YORK("New York"),
        BARCELONA("Barcelona");

        String cityName;

        DefaultCities(String cityName) {
            this.cityName = cityName;
        }

        public String getCityName() {
            return cityName;
        }
    }

}
