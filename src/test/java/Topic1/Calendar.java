package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("travel_date")).click();
       while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("July")){
           driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
       }
       List <WebElement> dates=driver.findElements(By.className("day"));
       int count=driver.findElements(By.className("day")).size();
        for (int i=0;i<count;i++){
           String text= driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("7")){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }
}
