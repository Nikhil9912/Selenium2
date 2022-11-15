package SelenAss2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Set;

public class Ques3 {
    public WebDriver driver;



        @BeforeClass
        public void browser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://amazon.in/");
        }



        @Test(priority = 1)
        public void homepage() {
            //Getting title of the homepage
            String s = driver.getTitle();
            String s1 = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
            System.out.println(s);
            Assert.assertEquals(s, s1);
        }

        @Test(priority = 2)
        public void homepage2() {
            String s = driver.getCurrentUrl();
            String s1 = "https://www.amazon.in/";
            Assert.assertEquals(s, s1);
        }




        @Test(priority = 3)
        public void search_page() {
            //validating search bar
            Boolean b = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
            System.out.println(b);
            Assert.assertTrue(b);
        }

        @Test(priority = 4)
        public void search_page2() {
            //validating that it is enabled or not for sending data into it
            Boolean b = driver.findElement(By.id("twotabsearchtextbox")).isEnabled();
            Assert.assertTrue(b);
        }

        @Test(priority = 5)
        public void search_page3() {
            //validating whether it is searching what is demanded or not
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
            driver.findElement(By.id("nav-search-submit-button")).click();
            String s = driver.findElement(By.xpath("//span[text()='\"iphone\"']")).getText();
            Assert.assertEquals(s, "\"iphone\"");
        }

        @Test(priority = 6)
        public void search_page4() {
            //Validating the contents of searched item.
            String s = driver.findElement(By.xpath("//span[text()=\"Apple iPhone 14 128GB Starlight\"]")).getText();
            Assert.assertTrue(s.contains("iPhone"));

        }





        @AfterClass
        public void close_browser() {
            driver.close();
        }

}