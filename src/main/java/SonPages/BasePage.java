package SonPages;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriverWait webDriverWait;
    public void type(By byLocator, String text){
        PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .sendKeys(text);
    }

    public void click(By byLocator){
        PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .click();
    }
    public String getText(By byLocator){
        return  PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .getText();
    }
    public void waitForElement(By byLocator,int timeout){
        webDriverWait=new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(timeout));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }


}
