package SelenAss2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ques4 {
    public WebDriver driver;
    @BeforeMethod
    public void browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
    }

    @Test
    public void drag_drop() {
        WebElement w = driver.findElement(By.id("draggable"));
        WebElement w1 = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(w, w1).perform();

        WebElement w2 = driver.findElement(By.xpath("//div[@id=\"droppable\"]//p[text()=\"Dropped!\"]"));
        String s = w2.getText();
        System.out.println(s);
        Assert.assertEquals(s,"Dropped!");
    }

    @AfterMethod
    public void close_browser()
    {
        driver.close();
    }
}
