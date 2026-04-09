package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath ="//input[@type='text']")
    WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='submitButton']")
    WebElement submit;


    public void Logintoapp(){

        username.sendKeys("admin");
        password.sendKeys("admin");
        submit.click();


    }


}
