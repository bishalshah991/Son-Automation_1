package testCase;

import BaseClass.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class End_to_End {
    WebDriverWait wait;

    @Test
    public void LoginToApplicationTest(){
        WebDriver driver= PageDriver.getCurrentDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://snuat.benekiva.io/login");
    }
}
