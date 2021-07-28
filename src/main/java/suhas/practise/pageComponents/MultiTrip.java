package suhas.practise.pageComponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suhas.practise.AbstarctComponents.AbstarctComponent;
import suhas.practise.AbstarctComponents.checkAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstarctComponent implements checkAvailability {
    private By tripType = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By alertPopup = By.id("MultiCityModelAlert");
    private By originStation = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By originStation2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By destinationStation = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    /*@Override
    public void checkFlights(String origin, String destination) {

        System.out.println("I am inside multitrip");
        makeStateReady(s->selectCityOrigin(origin));
        selectCityDestination(destination);
        selectCityOrigin2("AMD");
        findElement_New(searchBtn).click();
    }*/

    public void selectCityOrigin(String origin)
    {
        findElement_New(originStation).click();
        findElement_New(By.cssSelector("li a[value='"+origin+"']")).click();
    }

    public void selectCityDestination(String destination)
    {
        findElement_New(By.xpath("(//a[@value=\""+destination+"\"])[2]")).click();
    }

    public void selectCityOrigin2(String origin2)
    {
        findElement_New(originStation2).click();
        findElement_New(By.xpath("(//a[@value=\""+origin2+"\"])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        findElement_New(tripType).click();
        findElement_New(alertPopup).click();
        consumer.accept(this);
        System.out.println("Am done");

    }

    @Override
    public void checkFlights(HashMap<String, String> reservationDetails) {
        System.out.println("I am inside multitrip");
        makeStateReady(s->selectCityOrigin(reservationDetails.get("origin")));
        checkVisiblityOfElement(destinationStation);
        selectCityDestination(reservationDetails.get("destination"));
        selectCityOrigin2(reservationDetails.get("destination2"));
        findElement_New(searchBtn).click();
    }
}
