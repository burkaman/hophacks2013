
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Julia
 */
public class Webpage {

    public static void visitPage(String url) {
        Process process = null;
        Runtime runtime = null;

        try {
            runtime = Runtime.getRuntime();
            process = runtime.exec("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        } catch (IOException e) {
            System.err.println(e);
        }

        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("amonroe7@jhu.edu");

        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("hophacks");

        WebElement submit = driver.findElement(By.id("u_0_b"));
        submit.click();
    }
}
