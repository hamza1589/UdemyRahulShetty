package Topic1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenURL {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a=new SoftAssert();
        for(WebElement link :links){
            String url= link.getAttribute("href");
            HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resPCode=conn.getResponseCode();
            System.out.println(resPCode);
            a.assertTrue(resPCode<400, "The link with Text"+link.getText()+" is broken with code" +resPCode);
//            if(resPCode>400){
//                System.out.println("The link with the text"+link.getText()+" is broken"+resPCode);
//                 hard assertion
//                Assert.assertTrue(false);
//            }
        }
        a.assertAll();



    }
}
