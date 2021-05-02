package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Action {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
        //MouseHover + click on searchButton + use mouse to Select the field + write by keyboard and double click and right click
        act.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("iphone").doubleClick().build().perform();

    }
}
