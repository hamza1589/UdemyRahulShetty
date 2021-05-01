package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoSuggestive {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("divpaxinfo")).click();

//       while(i<5){
//           driver.findElement(By.id("hrefIncAdt")).click();
//           i++;
//       }
        for (int i = 1; i < 7; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        //54, 55 udemy
        //Click on desired Country first
        driver.findElement(By.id("autosuggest")).sendKeys("INDIA");
        //and lacate the parent and the option
        List <WebElement> options= driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for(WebElement option:options){
            if(option.getText().equalsIgnoreCase("INDIA")){
                option.click();
                break;
            }
        }
//        driver.findElement(By.id("autosuggest")).sendKeys("AL");
//        List <WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
//        for (WebElement option:options){
//            if(option.getText().equalsIgnoreCase("ALGERIA")){
//                option.click();
//                break;
//            }
//        }

    }
}
