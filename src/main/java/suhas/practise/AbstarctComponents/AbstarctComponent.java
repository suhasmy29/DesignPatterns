package suhas.practise.AbstarctComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstarctComponent {
    WebElement sectionElement;
    WebDriver driver;

    public AbstarctComponent(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement= driver.findElement(sectionElement);
    }


    public WebElement findElement_New(By findElm)
    {
        return sectionElement.findElement(findElm);
    }

    public List<WebElement> findElements_New(By findElm)
    {
        return sectionElement.findElements(findElm);
    }

    public void checkVisiblityOfElement(By Elm)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elm));
    }

    public void alertAccept()
    {
      driver.switchTo().alert().accept();
    }

    public String getTitleNew()
    {
        return driver.getTitle();
    }


}
