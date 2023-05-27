/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.mycompany;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author swetu
 */
public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul[2]/li[6]/a")
    private WebElement Mahasweta;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul[2]/li[6]/ul/li[4]/a")
    private WebElement logoutPage;

    public void logoutPage() throws Exception {
        Actions act = new Actions(driver);
        org.openqa.selenium.interactions.Action a1 = act.moveToElement(Mahasweta).build();
        a1.perform();
        logoutPage.click();
// Logout logout = new Logout(driver);

    }
}
