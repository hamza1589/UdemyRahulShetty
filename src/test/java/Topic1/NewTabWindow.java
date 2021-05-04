package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NewTabWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/#/index");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]/li[4]/a[1]")).click();
       // driver.get("https://www.rahulshettyacademy.com/#/practice-project");
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys("Hamza Cherfaoui");
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("Hamzacherfaoui32@gmail.com");
        driver.findElement(By.id("form-submit")).click();
        driver.findElement(By.cssSelector("a[href*='https://rahulshettyacademy.com/angularpractice/']")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        Set <String>windows=driver.getWindowHandles();
        Iterator<String>it=windows.iterator();
        String parentWindow=it.next();
        String childWindow=it.next();
        String course=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(course);


    }
}
