package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

public class TestBase {
    public static WebDriver driver;

    @BeforeClass
    public void SetUp() throws IOException, ParseException {
        String environment=System.getProperty("os.name");
        System.out.println("Automation Script run on ......"+environment);
        String  browser=System.getProperty("browser","chrome");

        switch (browser.toLowerCase(Locale.ROOT))
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;

            default:
                driver=null;
                break;
        }
        PageDriver.getInstance().setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://snuat.benekiva.io/login");
    }

    @AfterClass
    public void TearDown(){
        //PageDriver.getCurrentDriver().quit();
    }

}
