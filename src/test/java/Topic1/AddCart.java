package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddCart {
    public static void main(String[] args) {
        //70 , 71
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Beans", "Brinjal"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        int j = 0;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        //convert array to arrayList
        List itemNeededList = Arrays.asList(itemsNeeded);
        for (int i = 0; i < products.size(); i++) {
            // Brocolli - 1 Kg
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            if (itemNeededList.contains(formattedName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if (j == itemsNeeded.length)
                    break;


            }
        }

    }
}
