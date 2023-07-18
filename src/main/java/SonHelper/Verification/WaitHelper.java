package SonHelper.Verification;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper extends TestBase {

    WebDriverWait webDriverWait;
    public WaitHelper(WebDriver driver, int timeout) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void WaitForTheElement(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        boolean status=element.isDisplayed();
        if (status){
            System.out.println("Element is Displayed:-"+element.getText());
        }
        else {
            System.out.println("Element is not displayed: "+element.getText());
        }

    }

    public static ExpectedCondition<Boolean> waitForAnElement(WebElement el){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                boolean flag=false;
                try {
                    if (el.isDisplayed()){
                        flag=true;
                    }
                }
                catch (Exception e){
                    System.out.println("Inside catch block " + e.getMessage());
                }
                return flag;
            }
        };
    }

}
