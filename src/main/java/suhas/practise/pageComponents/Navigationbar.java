package suhas.practise.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suhas.practise.AbstarctComponents.AbstarctComponent;

public class Navigationbar extends AbstarctComponent {

    public Navigationbar(WebDriver driver, By sectionElement_top) {
        super(driver, sectionElement_top);

    }

    By sectionElement = By.cssSelector("[title='Flights']");
    By linksCount = By.cssSelector("a");

    public void getFlights() {
        findElement_New(sectionElement).click();
    }

    public String getFlights_Attribute(String attributeName) {
        return findElement_New(sectionElement).getAttribute(attributeName);
    }

    public int getTotalLinks() {
        return findElements_New(linksCount).size();
    }


}
