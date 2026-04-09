package GenericUtilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

public class WebdriverUtility {


    public void maximizewindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    public void waitForpageload(WebDriver driver, int sec){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

    }

    public void waituntilelementtobevisible(WebDriver driver, int sec, WebElement element ){

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public  void waitUntilelementtobeclickable(WebDriver driver, int sec, WebElement element ){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(element));


    }

    public  void waitUntiltogettitle(WebDriver driver, int sec, String title ){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.titleContains(title));


    }

    public  void waitUntilAlerttobepresent(WebDriver driver, int sec){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.alertIsPresent());


    }

    public void handledropdown(WebElement element, String text){

        Select sc= new Select(element);
        sc.selectByVisibleText(text);

    }

    public  void handledropdown(String value ,WebElement element){

        Select sc= new Select((element));
        sc.selectByValue(value);


    }

    public  void handledropdown(WebElement element, int index){
        Select sc= new Select((element));
        sc.selectByIndex(index);


    }

    public  void mouseover(WebDriver driver, WebElement element){

        Actions ac= new Actions(driver);
        ac.moveToElement(element).perform();


    }

    public  void enterkeypress(WebDriver driver){

        Actions ac= new Actions(driver);
        ac.sendKeys(Keys.ENTER).perform();
    }

    public  void switchtoWindows(WebDriver driver, String window){

        Set<String> windows= driver.getWindowHandles();
        for(String child: windows){
            driver.switchTo().window(child);
        }
    }









}
