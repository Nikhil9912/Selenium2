package SelenAss2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ques2 {
    public WebDriver driver;

    @BeforeMethod
    public void browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    @Test(priority = 1)
    public void fetch_alert_popup_text() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_0\"]")).click();
    System.out.println("Radio button is selected:" + driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_0\"]")).isSelected());
    Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void dynamic_element_handling() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
    driver.findElement(By.xpath("//a[@value=\"AMD\"]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]")).click();
    driver.findElement(By.xpath("//a[@value=\"AIP\"]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//a[text()=\"11\"])[1]")).click();

    driver.findElement(By.id("divpaxinfo")).click();
    driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
    driver.findElement(By.id("btnclosepaxoption")).click();
    Thread.sleep(2000);
    //
    driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();

    Thread.sleep(5000);
    }

    @AfterMethod
    public void close_browser()
    {
        driver.close();
    }
}
