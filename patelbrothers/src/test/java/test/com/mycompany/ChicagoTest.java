/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.mycompany;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author swetu
 */
public class ChicagoTest {

    private WebDriver driver;

    public ChicagoTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

    }

    @AfterClass
    public void tearDownClass() throws Exception {
        driver.quit();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(priority = 1)
    public void testChicago() throws Exception {
        driver.get("https://shop.patelbros.com/");
    }

    @Test(priority = 2)
    public void testLogin() throws Exception {

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("email")).sendKeys("sukhadiakavita@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();

        driver.findElement(By.name("password")).sendKeys("Sweety555");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Test(priority = 3)
    public void test3() throws Exception {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"location-list\"]/li[1]/h4/a")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void testItems() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//img[@alt=\"Patel's Fresh Kitchen Pav Bread (12 Pieces) 16 oz\"]")).click();
        driver.findElement(By.id("update-btn")).click();
        js.executeScript("window.scrollBy(0,500)", "");
        driver.findElement(By.xpath("//div[@id='Produce']/div/ul/li[8]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,300)", "");
        driver.findElement(By.xpath("//div[@id='DairyEggs']/div/ul/li[8]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='Beverages']/div/ul/li[3]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//div[@id='OilsGhee']/div/ul/li[9]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//div[@id='Pantry']/div/ul/li[3]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        js.executeScript("window.scrollBy(0,345)", "");
  
       // Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='HouseholdReligious']/div/ul/li[7]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        js.executeScript("window.scrollBy(0,345)", "");

        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void testCheckout() throws Exception {
//        
        driver.findElement(By.xpath("//div[@id='navbar']/ul[2]/li[7]/a/span/i")).click();
        driver.findElement(By.linkText("Checkout")).click();
    }

    @Test(priority = 6)
    public void testRemoveitems() throws Exception {
        driver.findElement(By.className("cart-container")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/ul/div[6]/div[2]/i/span ")).click();

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div[2]/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div[3]/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div[4]/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();
        JavascriptExecutor js8 = (JavascriptExecutor) driver;
        js8.executeScript("window.scrollBy(0,750)", "");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div[2]/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();

    }

//    @Test(priority = 7)
//    public void testLogout() throws Exception {
//        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
//        driver.findElement(By.linkText("Kavita")).click();
//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//        driver.findElement(By.cssSelector("#navbar > ul.nav.navbar-nav.navbar-right.mright0 > li.dropdown.hidden-xs.hidden-sm.ng-scope.open > ul > li:nth-child(4) > a")).click();
//    }
     @Test(priority = 7)
public void testLogOut() throws Exception {
        WebElement elem1 = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[6]/a"));
        Actions act = new Actions(driver);
        org.openqa.selenium.interactions.Action a1 = act.moveToElement(elem1).build();
        a1.perform();
        //To wait for element visible
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[6]/ul/li[4]/a")));
        WebElement elem2 = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[6]/ul/li[4]/a"));
        elem2.click();

    }
}
