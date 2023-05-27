/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.mycompany;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author swetu
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul[2]/li[1]/a")
    private WebElement login;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"location-list\"]/li[3]/h4/a")
    private WebElement location;

    public void loginToFlighApplication(String eMail, String pWord)
            throws Exception {
        try {
            //driver.get("https://shop.patelbros.com/");
            login.click();
            email.click();
            email.clear();
            email.sendKeys(eMail);
            password.click();
            password.clear();
            password.sendKeys(pWord);
             File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./image.png"));
            loginBtn.click();
            location.click();
            //   LoginPage login = new LoginPage(driver);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
