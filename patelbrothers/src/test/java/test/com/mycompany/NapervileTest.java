/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.mycompany;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
public class NapervileTest {

    private WebDriver driver;

    public NapervileTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
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

    @Test(priority = 8)
    public void testOpenWebsite() throws Exception {
        driver.get("https://shop.patelbros.com/");
    }

    @Test(priority = 9)
    public void testM2() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("margaretaby2014@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("F16falcon@");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 10)
    public void testM3() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"location-list\"]/li[4]/h4/a")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 11)
    public void testM4() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[5]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[6]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[7]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[8]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[9]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 12)
    public void testM5() throws Exception {

        driver.findElement(By.xpath("//div[@id='navbar']/ul[2]/li[7]/a/span/i")).click();
        driver.findElement(By.linkText("Checkout")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 13)
    public void testChooseDeliveryMethod() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"fulfillment-step\"]/drawer/div[2]/div/ul/li[1]/h3")).click();
        driver.findElement(By.xpath("//*[@id=\"fulfillment-step\"]/drawer/div[2]/div/div/button")).click();
    }

    @Test(priority = 14)
    public void testPayment() throws Exception {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)", "");
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#payment-step > drawer > div.drawer-header.cursor-pointer > div.info > h4")));
        WebElement elem2 = driver.findElement(By.cssSelector("#payment-step > drawer > div.drawer-header.cursor-pointer > div.info > h4"));
        elem2.click();
        driver.findElement(By.xpath("//*[@id=\"payment-step\"]/drawer/div[2]/div/div/div/a")).click();

        WebElement iframe1 = driver.findElement(By.xpath("//*[@id=\"card-element\"]/div/iframe"));
        driver.switchTo().frame(iframe1);

        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input")).sendKeys("4204958518604439");
        Thread.sleep(3000);
        driver.findElement(By.name("exp-date")).click();
        driver.findElement(By.name("exp-date")).sendKeys("0723");

        driver.findElement(By.name("cvc")).click();
        driver.findElement(By.name("cvc")).sendKeys("181");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"street1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"street1\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"street1\"]")).sendKeys("852 Teasel lane, Aurora, IL, USA");

        String OptionToSelect = "852 Teasel lane,Aurora, IL, USA";
        int count = 0;
        List<WebElement> optionList = driver.findElements(By.xpath("//*[@id=\"street1\"]"));
        for (WebElement ele : optionList) {
            String currentOption = ele.getText();
            if (currentOption.contains(OptionToSelect)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(OptionToSelect + "has been selected in the DD");
        } else {
            System.out.println("option you want to select is not available in the DD");
        }
        Thread.sleep(3000);
        driver.findElement(By.id("street2")).click();
        driver.findElement(By.id("street2")).clear();
        driver.findElement(By.id("street2")).sendKeys("#A");

        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Aurora");

        //Create a Select class object for static drop down menu
        Select s = new Select(driver.findElement(By.id("state")));
        s.selectByValue("IL");

        driver.findElement(By.id("zip_code")).click();
        driver.findElement(By.id("zip_code")).clear();
        driver.findElement(By.id("zip_code")).sendKeys("60504");

        driver.findElement(By.xpath("//*[@id=\"payment-step\"]/drawer/div[2]/div/credit-card-form/div/div[3]/div/button")).click();
    }

    @Test(priority = 15)
    public void testContact() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"contact-step\"]/drawer/div[1]/div[2]/h4/span")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-step\"]/drawer/div[2]/div/div/ul/li/p[2]/a")).click();
    }

   
    @Test(priority = 16)
    public void testPickupTime() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"dateScrollBar\"]/div[3]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div/div[2]/div/div[3]/button")).click();
    }

    @Test(priority = 17)//Remove item
    public void testM7() throws Exception {


        driver.findElement(By.className("cart-container")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[3]/div[4]/ul/div[6]/div[2]/i/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[4]/div[4]/ul/div[6]/div[2]/i/span")).click();

         JavascriptExecutor js8 = (JavascriptExecutor) driver;
        js8.executeScript("window.scrollBy(0,750)", "");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[3]/div[4]/ul/div[6]/div[2]/i/span")).click();

    }

    
    @Test(priority = 18)
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
