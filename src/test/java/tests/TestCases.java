/**
 * Year: 2018-2019
 * Pratik Patel(https://github.com/prat3ik)
 */
package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.DashboardPO;
import pageobjects.SearchPO;
import pageobjects.WeatherDetailsPO;
import utils.AssertUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class contains Test Cases for Easy Weather app(https://github.com/danprado/easyweather)
 *
 * @author prat3ik
 */
public class TestCases extends BaseTest {

    @BeforeTest
    @Override
    public void setUpPage() {
    }


    /**
     * In this test User Can check the weather details for existing as well as newly added cities, Even if app restarts city list does not change and user can check weather details again
     * <p>
     * Assertions:
     * 1) Default cities must be present when app is installed and opened first time.
     * 2) User can verify weather details for existing/newly added cities.
     * 3) After App restart the behaviour remains same and User can again check the weather details for existing cities.
     *
     * @throws InterruptedException
     */
    @Test
    public void verifyUserCanSeeTheWeatherOfCities() throws InterruptedException {
        final String londonCity = "London";
        final String suratCity = "Surat";
        final String sanFranciscoCity = "San Francisco";

        DashboardPO dashboardPO = new DashboardPO(driver);

        List<String> defaultCities = DefaultCities.getDefaultCities();
        Set<String> expectedAvailableCitiesOnDashboard = new HashSet<String>();
        expectedAvailableCitiesOnDashboard.addAll(defaultCities);
        expectedAvailableCitiesOnDashboard.add(suratCity);
        expectedAvailableCitiesOnDashboard.add(sanFranciscoCity);

        dashboardPO.waitTillDashboardPOAppeared();
        ArrayList<String> allAvailableCities = new ArrayList<String>(dashboardPO.getAllCities());
        System.out.println("First::" + allAvailableCities);
        AssertUtils.assertListEquals(allAvailableCities, DefaultCities.getDefaultCities(), "Default Cities");

        WeatherDetailsPO weatherDetailsPO = dashboardPO.tapOnCity(londonCity);
        weatherDetailsPO.assertWeather();
        dashboardPO = weatherDetailsPO.backToDashboard();

        SearchPO searchPO = dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(suratCity);
        searchPO = dashboardPO.tapOnAddLocationFloatingButton();
        searchPO.addCity(sanFranciscoCity);

        weatherDetailsPO = dashboardPO.tapOnCity(suratCity);
        weatherDetailsPO.assertWeather();
        dashboardPO = weatherDetailsPO.backToDashboard();
        weatherDetailsPO = dashboardPO.tapOnCity(sanFranciscoCity);
        weatherDetailsPO.assertWeather();
        dashboardPO = weatherDetailsPO.backToDashboard();

        this.restartApp();

        Set<String> actualAvailableAllCitiesOnDashboard = dashboardPO.getAllCities();
        AssertUtils.assertListEquals(new ArrayList<String>(actualAvailableAllCitiesOnDashboard), new ArrayList<String>(expectedAvailableCitiesOnDashboard), "Available Cities on Dashboard");

        weatherDetailsPO = dashboardPO.tapOnCity(londonCity);
        weatherDetailsPO.assertWeather();
        weatherDetailsPO.backToDashboard();
        weatherDetailsPO = dashboardPO.tapOnCity(suratCity);
        weatherDetailsPO.assertWeather();
        weatherDetailsPO.backToDashboard();
        weatherDetailsPO = dashboardPO.tapOnCity(sanFranciscoCity);
        weatherDetailsPO.assertWeather();
    }

    /**
     * This test verify that User can add and remove the cities, and cities list does not change when app restarts.
     * <p>
     * Assertions:
     * 1) Added cities must be present and Removed cities must not be present on Dashboard.
     * 2) After restarting of the app valid cities must be visible and also verify the weather data again.
     *
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void verifyUserCanAddAndRemoveTheCities() throws InterruptedException, IOException {
        final String firstCity = DefaultCities.DUBLIN.getCityName();
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

        List<String> defaultCities = DefaultCities.getDefaultCities();
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

        DashboardPO dashboardPO = new DashboardPO(driver);
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

        dashboardPO.removeCity(DefaultCities.LONDON.getCityName());
        dashboardPO.removeCity(sanFranciscoCity);
        dashboardPO.removeCity(perthCity);

        expectedAvailableCitiesOnDashboard.remove(DefaultCities.LONDON.getCityName());
        expectedAvailableCitiesOnDashboard.remove(sanFranciscoCity);
        expectedAvailableCitiesOnDashboard.remove(perthCity);

        dashboardPO.moveToFirstCity();
        Set<String> actualAvailableAllCitiesOnDashboard = dashboardPO.getAllCities();
        AssertUtils.assertListEquals(new ArrayList<String>(actualAvailableAllCitiesOnDashboard), new ArrayList<String>(expectedAvailableCitiesOnDashboard), "Available Cities on Dashboard");

        this.restartApp();

        actualAvailableAllCitiesOnDashboard = dashboardPO.getAllCities();
        System.out.println("Last::" + actualAvailableAllCitiesOnDashboard);
        AssertUtils.assertListEquals(new ArrayList<String>(actualAvailableAllCitiesOnDashboard), new ArrayList<String>(expectedAvailableCitiesOnDashboard), "Available Cities on Dashboard");
    }

    /**
     * Enum for Default Cities available at Dashboard
     */
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

        public static List<String> getDefaultCities() {
            List<String> defaultCities = new ArrayList<String>();
            defaultCities.add(DUBLIN.getCityName());
            defaultCities.add(LONDON.getCityName());
            defaultCities.add(NEW_YORK.getCityName());
            defaultCities.add(BARCELONA.getCityName());
            return defaultCities;
        }

    }
}
