package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CountLink2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(By.id("gf-BIG")).size();
        WebElement footer4 = driver.findElement(By.xpath("//tbody/tr/td[4]/ul[1]"));
        footer4.findElements(By.tagName("a")).size();
        for (int i = 1; i < footer4.findElements(By.tagName("a")).size(); i++) {
            String clickOnTab1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
         footer4.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab1);
        }
        Set<String> ab = driver.getWindowHandles();
        Iterator<String> it = ab.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


    }
}
