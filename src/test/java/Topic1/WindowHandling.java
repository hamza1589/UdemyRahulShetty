package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set <String> windows=driver.getWindowHandles();
        Iterator <String> it= windows.iterator();
        String parentWindow=it.next();
        String childWindow=it.next();
        driver.switchTo().window(childWindow);
       String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
       driver.switchTo().window(parentWindow);
       driver.findElement(By.cssSelector("#username")).sendKeys(emailId);

    }
}
