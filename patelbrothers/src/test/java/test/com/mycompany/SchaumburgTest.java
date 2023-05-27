/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com.mycompany;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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
public class SchaumburgTest {

    private WebDriver driver;

    public SchaumburgTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\Data\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver();
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

    @Test(priority = 30)
    public void testOpenWebsite() throws Exception {
        driver.get("https://shop.patelbros.com/");
    }

    @Test(priority = 31)
    public void executeLoginPageModule() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.loginToFlighApplication(FileUtil.readForm1().getUser(), FileUtil.readForm1().getPassword());
    }

    // @Test(priority = 2)
    public void testLogIn() throws Exception {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("swetumrug@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 32)
    public void testChooseLocation() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"location-list\"]/li[3]/h4/a")).click(); // replace by your location
    }

    @Test(priority = 33)
    public void testAddItems() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id=\"PatelsFreshKitchen\"]/div/ul/li[1]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[3]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a/i")).click();
        driver.findElement(By.xpath("//div[@id='PatelsFreshKitchen']/div/ul/li[4]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a/i")).click();
        driver.findElement(By.xpath("//*[@id=\"PatelsFreshKitchen\"]/div/ul/li[5]/hs-product-item/div/div/div/div[2]/div/div[2]/div/a")).click();
    }

    @Test(priority = 34)
    public void testCheckout() throws Exception {
        driver.findElement(By.linkText("Add")).click();
        driver.findElement(By.xpath("//div[@id='navbar']/ul[2]/li[7]/a/span/i")).click();
        driver.findElement(By.linkText("Checkout")).click();
    }

    @Test(priority = 35)
    public void testChooseDeliveryMethod() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"fulfillment-step\"]/drawer/div[2]/div/ul/li[1]/h3")).click();
        driver.findElement(By.xpath("//*[@id=\"fulfillment-step\"]/drawer/div[2]/div/div/button")).click();
    }

    @Test(priority = 36)
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
        driver.findElement(By.xpath("//*[@id=\"street1\"]")).sendKeys("951 N Plum Grove Rd, Schaumburg, IL, USA");

        String OptionToSelect = "951 N Plum Grove Rd, Schaumburg, IL, USA";
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
        driver.findElement(By.id("city")).sendKeys("Schaumburg");

        //Create a Select class object for static drop down menu
        Select s = new Select(driver.findElement(By.id("state")));
        s.selectByValue("IL");

        driver.findElement(By.id("zip_code")).click();
        driver.findElement(By.id("zip_code")).clear();
        driver.findElement(By.id("zip_code")).sendKeys("60193");
        File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("./image2.png"));
        driver.findElement(By.xpath("//*[@id=\"payment-step\"]/drawer/div[2]/div/credit-card-form/div/div[3]/div/button")).click();
    }

    @Test(priority = 37)
    public void testContact() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"contact-step\"]/drawer/div[1]/div[2]/h4/span")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-step\"]/drawer/div[2]/div/div/ul/li/p[2]/a")).click();
    }

    @Test(priority = 38)
    public void testPickupTime() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"dateScrollBar\"]/div[3]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div/div[2]/div/div[3]/button")).click();
    }

    @Test(priority = 39)
    public void testRemoveItems() throws Exception {
        driver.findElement(By.className("cart-container")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[2]/div[4]/ul/div[6]/div[2]/i/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[3]/div[4]/ul/div[6]/div[2]/i/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[2]/div/div[4]/div[4]/ul/div[6]/div[2]/i/span")).click();
        Thread.sleep(3000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,500)", "");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.main-view.ng-scope.main-view-margin-normal > section > div > div > div.col-md-9.col-sm-8.col-xs-12.pleftright0 > div.bg-white.box-shadow.ptop0.pbot15.position-relative.overflow-hidden.mbot15 > div > div:nth-child(2) > div.col-md-10.col-sm-10.col-xs-9.pleft0.pbot15 > ul > div.text-dark-gray.display-flex-space-between.mtop15.cart-instructions-width-80 > div:nth-child(2) > i > span")));
        WebElement elem3 = driver.findElement(By.cssSelector("body > div.main-view.ng-scope.main-view-margin-normal > section > div > div > div.col-md-9.col-sm-8.col-xs-12.pleftright0 > div.bg-white.box-shadow.ptop0.pbot15.position-relative.overflow-hidden.mbot15 > div > div:nth-child(2) > div.col-md-10.col-sm-10.col-xs-9.pleft0.pbot15 > ul > div.text-dark-gray.display-flex-space-between.mtop15.cart-instructions-width-80 > div:nth-child(2) > i > span"));
        elem3.click();
        // driver.findElement(By.cssSelector("body > div.main-view.ng-scope.main-view-margin-normal > section > div > div > div.col-md-9.col-sm-8.col-xs-12.pleftright0 > div.bg-white.box-shadow.ptop0.pbot15.position-relative.overflow-hidden.mbot15 > div > div:nth-child(2) > div.col-md-10.col-sm-10.col-xs-9.pleft0.pbot15 > ul > div.text-dark-gray.display-flex-space-between.mtop15.cart-instructions-width-80 > div:nth-child(2) > i > span")).click();
        driver.findElement(By.cssSelector("body > div.main-view.ng-scope.main-view-margin-normal > section > div > div > div.col-md-9.col-sm-8.col-xs-12.pleftright0 > div.bg-white.box-shadow.ptop0.pbot15.position-relative.overflow-hidden.mbot15 > div > div.row.mleftright0.position-relative.cart-item.ng-scope.even-cart > div.col-md-10.col-sm-10.col-xs-9.pleft0.pbot15 > ul > div.text-dark-gray.display-flex-space-between.mtop15.cart-instructions-width-80 > div:nth-child(2) > i > span")).click();

    }

    //@Test(priority = 11)
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

    @Test(priority = 40)
    public void executeLogoutPage() throws Exception {
        LogoutPage logout = PageFactory.initElements(driver, LogoutPage.class);
        logout.logoutPage();

    }
}
