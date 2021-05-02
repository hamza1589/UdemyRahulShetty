package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CountLinks {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.findElements(By.tagName("a")).size());
        // get count of links of footer section
       WebElement footer= driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());
        // count links on footer for just one column <Discount Coupons>
        WebElement footer1=driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
        System.out.println(footer1.findElements(By.tagName("a")).size());

        //click on each link and make sure each page is open
        for(int i=1;i<footer1.findElements(By.tagName("a")).size();i++){
            String clickOnTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
           footer1.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
        }

        Set<String> abc=driver.getWindowHandles();
       Iterator <String> it=abc.iterator();
       while (it.hasNext()){
           driver.switchTo().window(it.next());
           System.out.println(driver.getTitle());
       }
    }
}
