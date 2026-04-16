package com.crm.orgTest;

import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import com.crm.basetest.BaseClass;
import objectRepository.ContactPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class createContactTest extends BaseClass {

    @Test
    public void createContactBynameAndPhone() throws IOException, InterruptedException {

        ContactPage cp= new ContactPage(driver);
        cp.createContact();
        ExcelUtility elib= new ExcelUtility();
        JavaUtility jlib= new JavaUtility();
        String lname=elib.readDatatFromExcel("Org",1,0) ;

        //Verify...
        WebElement headertext= driver.findElement(By.xpath("//span[contains(text(),' Contact Information')]"));
        String text= headertext.getText();
        if(text.contains(lname)){
            System.out.println("Contact created..");
        }
        else{
            System.out.println("contact not created");
        }

        Thread.sleep(5000);
    }


}
