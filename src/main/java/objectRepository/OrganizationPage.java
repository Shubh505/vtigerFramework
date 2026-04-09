package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
    WebDriver driver;

    public OrganizationPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//img[@title='Create Organization...']")
    public WebElement orgLink;

    @FindBy(xpath = "//input[@name='accountname']")
    public WebElement orgName;

    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='dvHeaderText']")
    WebElement headerText;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phonefield;

    @FindBy(xpath = "//select[@name='industry']")
    public WebElement industry;

    @FindBy(xpath  ="//select[@name='accounttype']")
    public  WebElement type;

    @FindBy(id="Accounts_editView_fieldName_accountname")
    WebElement ele5;

    @FindBy(xpath= "//button[text()='Save']")
    WebElement ele6;

    @FindBy(xpath = "(//span[@class='value textOverflowEllipsis'])[1]")
    WebElement ele7;











}
