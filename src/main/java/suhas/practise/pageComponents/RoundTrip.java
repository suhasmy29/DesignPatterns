package suhas.practise.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suhas.practise.AbstarctComponents.AbstarctComponent;
import suhas.practise.AbstarctComponents.checkAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstarctComponent implements checkAvailability {

    private By tripType = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By originStation = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By destinationStation = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By todayDate = By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']");
    private By checkBox = By.id("ctl00_mainContent_chk_IndArm");
    private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkFlights(HashMap<String, String> reservationDetails) {

        System.out.println("I am inside round trip");
        makeStateReady(s->selectCityOrigin(reservationDetails.get("origin")));
        checkVisiblityOfElement(destinationStation);
        selectCityDestination(reservationDetails.get("destination"));
        findElement_New(todayDate).click();
        findElement_New(checkBox).click();
        findElement_New(searchBtn).click();
    }

    public void selectCityOrigin(String origin)
    {
        findElement_New(originStation).click();
        findElement_New(By.cssSelector("li a[value='"+origin+"']")).click();
    }

    public void selectCityDestination(String destination)
    {
        findElement_New(By.xpath("(//a[@value=\""+destination+"\"])[2]")).click();
    }

    public void makeStateReady(Consumer<RoundTrip> consumer)
    {
        findElement_New(tripType).click();
        consumer.accept(this);
        System.out.println("Am done");
    }
}
