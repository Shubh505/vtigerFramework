package objectRepository;

import GenericUtilities.WebdriverUtility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    WebdriverUtility wlib= new WebdriverUtility();

     public HomePage(WebDriver driver){
         this.driver= driver;
         PageFactory.initElements(driver, this);
     }

    @FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr[1]/td[2]/table/tbody/tr/td[6]")
    public WebElement orgButton;

     @FindBy(xpath= "//table[@class='hdrTabBg']/tbody/tr[1]/td[2]/table/tbody/tr/td[8]")
    public WebElement contactButton;

     @FindBy(xpath = "//img[@title='Create Contact...']")
     public WebElement contactlink;

     @FindBy(xpath = "//span[text()=' Administrator']/ancestor::tr[1]/descendant::td[2]/img")
    public WebElement signoutImage;

     @FindBy(xpath = "//a[text()='Sign Out']")
     public WebElement signoutbutton;

     public void signout() throws InterruptedException {

         Actions ac= new Actions(driver);
         wlib.waituntilelementtobevisible(driver,20,signoutImage);
         ac.moveToElement(signoutImage).perform();
         wlib.waituntilelementtobevisible(driver,20,signoutbutton);
         ac.moveToElement(signoutbutton).perform();
         ac.click(signoutbutton).perform();
     }



}
