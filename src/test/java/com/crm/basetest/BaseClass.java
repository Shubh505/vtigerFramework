package com.crm.basetest;

import GenericUtilities.FileUtility;
import GenericUtilities.WebdriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public FileUtility flib= new FileUtility();
    public WebDriver driver=null;
    WebdriverUtility wlib= new WebdriverUtility();
    public  static WebDriver sdriver=null;


    @BeforeSuite
    public void ConnecttoDb(){

        System.out.println("Connect to Db");
    }

    @BeforeClass
    public void LaunchBrowser() throws IOException {

        String Browser= flib.readDatafromPropertyfile("browser");
        if(Browser.equals("chrome")){
            driver= new ChromeDriver();
            wlib.maximizewindow(driver);

        }
        else if(Browser.equals("firefox")){
            driver= new FirefoxDriver();

        }
        else if(Browser.equals("edge")){
            driver= new EdgeDriver();
        }
        else{
            driver= new ChromeDriver();
        }
        sdriver=driver;

    }

    @BeforeMethod
    public void login() throws IOException {
        String url= flib.readDatafromPropertyfile("url");
        driver.manage().window().maximize();
        driver.get(url);
        LoginPage lp = new LoginPage(driver);
        lp.Logintoapp();
    }

    @AfterMethod
    public void logout() throws InterruptedException {
        HomePage hp= new HomePage(driver);
        driver.manage().window().maximize();
        hp.signout();
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();

    }
    @AfterSuite
    public void Disconnectdb(){
        System.out.println("disconnectfromDb");
    }


}
