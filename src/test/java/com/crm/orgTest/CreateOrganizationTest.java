package com.crm.orgTest;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebdriverUtility;
import com.crm.basetest.BaseClass;
import objectRepository.HomePage;
import objectRepository.OrganizationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.io.IOException;


@Listeners(com.crm.Listener.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

    FileUtility flib = new FileUtility();
    ExcelUtility elib = new ExcelUtility();
    JavaUtility jlib = new JavaUtility();
    WebdriverUtility wlib = new WebdriverUtility();


    @Test
    public void CreateOrganizationTest() throws IOException, InterruptedException {
        String orgName = elib.readDatatFromExcel("Org", 1, 0) + jlib.randint();
//        1.Click on organization button on homepage......
        HomePage hp = new HomePage(driver);
        hp.orgButton.click();
//        2.Click on organization link...
        OrganizationPage op = new OrganizationPage(driver);
        op.orgLink.click();
//        3.Enter organization details ...
        op.orgName.sendKeys(orgName);
//        4.Click on save button..
        op.saveButton.click();
        //5. Verify organization....
        Thread.sleep(2000);
        WebElement headertext = driver.findElement(By.xpath("//span[contains(text(), 'Organization Information')]"));
        wlib.waituntilelementtobevisible(driver, 20, headertext);
        String text = headertext.getText();
        if (text.contains(orgName)) {
            System.out.println("test case- passed");
        } else {
            System.out.println("test -case failed");
        }
    }

    @Test
    public void createOrgTestwithPhone() throws IOException, InterruptedException {
        String orgName = elib.readDatatFromExcel("Org", 1, 0) + jlib.randint();
        String phonenumber = elib.readDatatFromExcel("Org", 1, 1).toString()+jlib.randint();
        // 1.Click on organization button on homepage..
        HomePage hp = new HomePage(driver);
        hp.orgButton.click();
//       2.Click on organization link...
        OrganizationPage op = new OrganizationPage(driver);
        op.orgLink.click();
//        3.Enter organization details ...
        op.orgName.sendKeys(orgName);
        op.phonefield.sendKeys(phonenumber);
//        4.Click on save button..
        op.saveButton.click();
//        5.//Verify the phone number...
        Thread.sleep(2000);
        WebElement phone = driver.findElement(By.xpath("//span[@id='dtlview_Phone']"));
        wlib.waituntilelementtobevisible(driver, 20, phone);
        String text = phone.getText();
        if (text.contains(phonenumber)) {
            System.out.println("phone number verify test case- passed");
        }
        else {
            System.out.println("phone number verify test case- failed");
        }

    }

    @Test
    public void createOrgwithIndustrytype() throws IOException {
        String orgName=elib.readDatatFromExcel("Org",1,0)+jlib.randint();
        HomePage hp= new HomePage(driver);
        hp.orgButton.click();

        OrganizationPage op= new OrganizationPage(driver);
        op.orgLink.click();

        op.orgName.sendKeys(orgName);
        wlib.handledropdown("Engineering",op.industry);
        wlib.handledropdown("Customer",op.type);

        op.saveButton.click();




    }
}
//    @DataProvider(name="Org data")
//    public Object[][] getData() throws IOException {
//        Object[][] data=new Object[elib.getrowcount("Org")][1];
//        for(int i=0; i< elib.getrowcount("Org"); i++){
//
//            data[i][0]=elib.readDatatFromExcel("Org",i+1,0)+jlib.randint();
//        }
//
//        return data;
//
//    }





