package SelenAss2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ques1 {
    public WebDriver driver;

    @BeforeMethod
    public void browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @Test (priority = 1)
    public void fetch_alert_popup_text() throws InterruptedException {
        driver.findElement(By.id("alertbtn")).click();
        Alert a = driver.switchTo().alert();
        //fetching alert text
        System.out.println(a.getText());
        Thread.sleep(2000);
        //dismissing alert box
        a.dismiss();

    }

    @Test (priority = 2)
    public void enter_data_in_alert() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Nikhil");
        driver.findElement(By.id("confirmbtn")).click();
        Alert a = driver.switchTo().alert();

        
     //Second Method
        Assert.assertEquals(true,a.getText().contains("Nikhil"));
     
        a.accept();

    }

    @AfterMethod
    public void close_browser() {
        driver.close();
    }
}
