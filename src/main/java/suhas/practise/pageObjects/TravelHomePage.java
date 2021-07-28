package suhas.practise.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suhas.practise.AbstarctComponents.StrategyFactory;
import suhas.practise.AbstarctComponents.checkAvailability;
import suhas.practise.pageComponents.FooterNavigation;
import suhas.practise.pageComponents.Navigationbar;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TravelHomePage {

    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By sectionElement_top =  By.cssSelector("div.search-buttons-heading");
    checkAvailability check;
    public TravelHomePage(WebDriver driver) {
        this.driver= driver;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public Navigationbar getNavigationBar()
    {
        return new Navigationbar(driver, sectionElement_top);
    }

    public FooterNavigation getFooterNavigation()
    {
        return new FooterNavigation(driver, sectionElement);
    }

    public void checkBookingStrategy(String startegyTpe)
    {
        StrategyFactory s = new StrategyFactory(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        checkAvailability tripType = s.createStrategy(startegyTpe);
        this.check=tripType;
    }

    public void checkFlights(HashMap<String, String> hMap)
    {
        check.checkFlights(hMap);
    }





}
