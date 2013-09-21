import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Julia
 */
public class WebpageLogin implements Action {

    private String url;
    private String username;
    private String password;

    public WebpageLogin(String url, String user, String pass) {
        this.url = url;
        this.username = user;
        this.password = pass;
    }

    public void launch() {
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(username);

        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys(password);

        WebElement submit = driver.findElement(By.id("u_0_b"));
        submit.click();
    }
}
