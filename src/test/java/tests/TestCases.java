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
        final List<String> citiesToBeAdded = Arrays.asList("Vienna", "Surat", "Berlin", "Tokyo","San Francisco","Torronto");
        final String password = "test";
        final String viennaCity = "Vienna";
        final String suratCity = "Surat";
        final String berlinCity = "Berlin";
        final String sanFranciscoCity = "San Francisco";
        final String torrontoCity = "Torronto";
        final String beijingCity = "Beijing";
        final String capeTownCity = "Cape town";
        final String perthCity = "Perth";

        dashboardPO.waitTillDashboardPOAppeared();
//        dashboardPO.removeCity(DefaultCities.LONDON.getCityName());
//        dashboardPO.removeCity(DefaultCities.DUBLIN.getCityName());
//        dashboardPO.removeCity(DefaultCities.BARCELONA.getCityName());


//        SearchPO searchPO = dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(viennaCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(suratCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(berlinCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(sanFranciscoCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(torrontoCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(beijingCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(capeTownCity);
//        dashboardPO.tapOnAddLocationFloatingButton();
//        searchPO.addCity(perthCity);

        dashboardPO.removeCity("Surat");
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
