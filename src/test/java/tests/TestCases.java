package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.*;
import utils.AssertUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

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
        final String viennaCity = "Vienna";
        final String suratCity = "Surat";
        final String berlinCity = "Berlin";
        final String sanFranciscoCity = "San Francisco";
        final String torontoCity = "Toronto";
        final String beijingCity = "Beijing";
        final String capeTownCity = "Cape Town";
        final String melbourneCity = "Melbourne";
        final String istanbulCity = "Istanbul";
        final String perthCity = "Perth";

        Set<String> defaultCities = DefaultCities.getDefaultCities();
        Set<String> expectedAvailableCitiesOnDashboard = new HashSet<String>();
        expectedAvailableCitiesOnDashboard.addAll(defaultCities);
        expectedAvailableCitiesOnDashboard.add(viennaCity);
        expectedAvailableCitiesOnDashboard.add(suratCity);
        expectedAvailableCitiesOnDashboard.add(berlinCity);
        expectedAvailableCitiesOnDashboard.add(sanFranciscoCity);
        expectedAvailableCitiesOnDashboard.add(torontoCity);
        expectedAvailableCitiesOnDashboard.add(beijingCity);
        expectedAvailableCitiesOnDashboard.add(capeTownCity);
        expectedAvailableCitiesOnDashboard.add(melbourneCity);
        expectedAvailableCitiesOnDashboard.add(istanbulCity);
        expectedAvailableCitiesOnDashboard.add(perthCity);

        System.out.println(expectedAvailableCitiesOnDashboard);


        dashboardPO.waitTillDashboardPOAppeared();
        SearchPO searchPO = dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(viennaCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(suratCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(berlinCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(sanFranciscoCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(torontoCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(beijingCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(capeTownCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(melbourneCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(istanbulCity);
        dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(perthCity);

        //System.out.println(dashboardPO.getAllCities());

        dashboardPO.removeCity(DefaultCities.LONDON.getCityName());
        dashboardPO.removeCity(sanFranciscoCity);
        dashboardPO.removeCity(perthCity);

        expectedAvailableCitiesOnDashboard.remove(DefaultCities.LONDON.getCityName());
        expectedAvailableCitiesOnDashboard.remove(sanFranciscoCity);
        expectedAvailableCitiesOnDashboard.remove(perthCity);

        driver.closeApp();
        driver.runAppInBackground(Duration.ofSeconds(1));

        Set<String> actualAvailableAllCitiesOnDashboard = dashboardPO.getAllCities();
        AssertUtils.assertListEquals(new ArrayList<String>(actualAvailableAllCitiesOnDashboard), new ArrayList<String>(expectedAvailableCitiesOnDashboard), "Available Cities on Dashboard");


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

        public static Set<String> getDefaultCities() {
            Set<String> defaultCities = new HashSet<String>();
            defaultCities.add(DUBLIN.getCityName());
            defaultCities.add(LONDON.getCityName());
            defaultCities.add(NEW_YORK.getCityName());
            defaultCities.add(BARCELONA.getCityName());
            return defaultCities;
        }
    }

}
