/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.mycompany;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class SigninTest {

    private WebDriver driver;

    public SigninTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver();
        driver.get("https://shop.patelbros.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }

    @Test(priority = 41)
    public void testIncorrectUsernameCorrectPassword() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(FileUtil.readForm3().getUser());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(FileUtil.readForm3().getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
              driver.toString().contentEquals("Incorrect username and/or password. Please try again.");
    }

    @Test(priority = 42)
    public void testCorrectUsernameIncorrectPassword() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(FileUtil.readForm2().getUser());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(FileUtil.readForm2().getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.toString().contentEquals("Incorrect username and/or password. Please try again.");
    }

    @Test(priority = 43)
    public void testCorrectUsernameCorrectPasswordLogOut() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(FileUtil.readForm1().getUser());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(FileUtil.readForm1().getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
         driver.findElement(By.xpath("//*[@id=\"location-list\"]/li[3]/h4/a")).click(); // replace by your location
        
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

   

    @Test(priority = 44)
    public void testIncorrectUsernameIncorrectPassword() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(FileUtil.readForm4().getUser());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(FileUtil.readForm4().getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.toString().contentEquals("Incorrect username and/or password. Please try again.");
    }

    @Test(priority = 45)
    public void testEmptyUsernameEmptytPassword() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.toString().contentEquals("Incorrect username and/or password. Please try again.");
    }
}
