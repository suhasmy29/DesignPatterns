package suhas.practise.AbstarctComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suhas.practise.pageComponents.MultiTrip;
import suhas.practise.pageComponents.RoundTrip;
import java.util.concurrent.TimeUnit;

public class StrategyFactory {

    WebDriver driver;
    By sectionElement = By.cssSelector("div#home_banner");

    public StrategyFactory(WebDriver driver) {
        this.driver=driver;
    }

    public checkAvailability createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("multiTrip")) {
            return new MultiTrip(driver, sectionElement);
        } else if (strategyType.equalsIgnoreCase("roundTrip")) {
            return new RoundTrip(driver, sectionElement);
        } else {
            return null;
        }
    }

}
