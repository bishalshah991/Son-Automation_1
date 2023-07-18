package testCase;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import SonHelper.Read_Json.ReadJsonData;
import SonPages.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


public class AccountLoginTest extends TestBase {

    @Test
    public void LoginToApplicationTest() throws IOException, ParseException, InterruptedException {
        PageDriver.getCurrentDriver();
        LoginPage loginPage=new LoginPage();
        ReadJsonData readJsonData=new ReadJsonData();
        String u_name=readJsonData.ReadJSONData("Username");
        String p_password=readJsonData.ReadJSONData("Password");


        loginPage.Wait_For_Login_Text();
        loginPage.Login_to_Application(u_name,p_password);
        loginPage.Logout_from_Application();

    }
}
