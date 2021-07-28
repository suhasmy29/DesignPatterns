package suhas.practise.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suhas.practise.AbstarctComponents.AbstarctComponent;

import java.util.List;

public class FooterNavigation extends AbstarctComponent {


    By flights = By.cssSelector("a[title='Flights']");
    By totalLinks = By.cssSelector("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        //when we inherit any parent class we should call parent class constructor by using super keyword at first.
        super(driver,sectionElement);
    }

    public void Selectflights()
    {
        findElement_New(flights).click();
    }

    public int getTotalLinks()
    {
        return findElements_New(totalLinks).size();
    }
    public String Selectflights_getattribute(String attributeName)
    {
        return findElement_New(flights).getAttribute(attributeName);
    }


}
