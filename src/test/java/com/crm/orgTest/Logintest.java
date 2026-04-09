package com.crm.orgTest;

import GenericUtilities.FileUtility;
import objectRepository.OrganizationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import objectRepository.LoginPage;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class Logintest {


    WebDriver driver;
    OrganizationPage org= new OrganizationPage(driver);
    FileUtility flib= new FileUtility();


        @Test
        public void LoginTest() throws IOException {

        driver=new ChromeDriver();
        driver.get(flib.readDatafromPropertyfile("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        LoginPage lp= new LoginPage(driver);

        lp.Logintoapp();




    }















}





