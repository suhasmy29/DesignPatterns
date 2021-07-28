package suhas.practise;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import suhas.practise.pageObjects.TravelHomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoTest extends BaseTest {

    WebDriver driver;
    TravelHomePage th;

    @BeforeTest
    public void setup() {
        driver = initialize();
        th = new TravelHomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> hMap) {

        th.goTo();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //th.getFooterNavigation().Selectflights();
        String attribute = th.getFooterNavigation().Selectflights_getattribute("class");
        System.out.println(attribute);

        String attribute_top = th.getNavigationBar().getFlights_Attribute("class");
        System.out.println(attribute_top);
        int totalLinks_Footer = th.getFooterNavigation().getTotalLinks();
        System.out.println("Total Links in footer: " + totalLinks_Footer);

        int totalLinks_header = th.getNavigationBar().getTotalLinks();
        System.out.println("Total Links in header: " + totalLinks_header);

        //checkAvailability mt = new MultiTrip();
        //th.checkBookingStrategy(new MultiTrip(driver,homeBanner));
        th.checkBookingStrategy("roundTrip");
        String title = th.getFooterNavigation().getTitleNew();
        Assert.assertTrue(title.contains("QAClickJet"));

        th.checkFlights(hMap);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir") + "/src/test/java/suhas/practise/DataLoads/testdata.json");
        return new Object[][]
                {
                        {l.get(0)}, {l.get(1)}
                };
    }
}
