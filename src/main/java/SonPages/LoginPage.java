package SonPages;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage(){
        driver= PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By textLogin=By.xpath("//div[@id='login-form-wrapper']//child::h1[contains(text(),'LOGIN TO YOUR ACCOUNT')]");
    By UsernameXpath=By.xpath("//input[@placeholder='Email']");
    By PasswordXpath=By.xpath("//input[@placeholder='Password']");
    By LoginButton=By.xpath("//span[normalize-space()='LOGIN']");
    By payment=By.xpath("//div[@class='advanced-pie chart']");


    By logout=By.xpath("//span[starts-with(@class,'username mr-')]//parent::div");
    By sign_out_text=By.xpath("//span[contains(text(),'Sign Out')]");
    public void Wait_For_Login_Text() throws InterruptedException {
        waitForElement(textLogin,10);
        Thread.sleep(3000);
    }
    public void Login_to_Application(String username,String password){
        type(UsernameXpath,username);
        type(PasswordXpath,password);
        click(LoginButton);
        waitForElement(payment,10);
    }
    public void Logout_from_Application(){
        waitForElement(logout,10);
        click(logout);
        waitForElement(sign_out_text,10);
        click(sign_out_text);
    }









}
