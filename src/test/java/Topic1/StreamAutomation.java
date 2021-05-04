package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StreamAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementLists = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elementLists.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> newList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(newList));
        List <String> price;
        do{
            List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));
            price= row.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).sorted().collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if(price.size()<1){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while (price.size()<1);

    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return priceValue;
    }
}
