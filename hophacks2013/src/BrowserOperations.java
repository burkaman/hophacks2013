/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julia
 */
import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOperations {
    
    public static void main(String[] args) throws Exception {
        
        Process process = null;
        Runtime runtime = null;
        
        try {
        runtime = Runtime.getRuntime();
        process = runtime.exec("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        } catch (IOException e) {
            System.err.println(e);
        }
        
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.facebook.com");
            
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("amonroe7@jhu.edu");
        
        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("hophacks");
        
        WebElement submit = driver.findElement(By.id("u_0_b"));
        submit.click();
        
    }   
    
}
