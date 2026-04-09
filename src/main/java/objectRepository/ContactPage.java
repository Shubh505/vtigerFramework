package objectRepository;

import GenericUtilities.ExcelUtility;
import GenericUtilities.JavaUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.XMLFormatter;

public class ContactPage {

    WebDriver driver;
    ExcelUtility elib= new ExcelUtility();
    JavaUtility jlib= new JavaUtility();

    public ContactPage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastname;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    public WebElement savebutton;

    public  void  createContact() throws IOException {

        HomePage hp= new HomePage(driver);
        hp.contactButton.click();
        hp.contactlink.click();
        String lname=elib.readDatatFromExcel("Org",1,0)+jlib.randint() ;
        String phonenum= elib.readDatatFromExcel("Org",1,1)+jlib.randint();
        lastname.sendKeys(lname);
        phone.sendKeys(phonenum);
        savebutton.click();

    }


}
