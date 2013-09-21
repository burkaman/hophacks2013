
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Julia
 */
public class Webpage implements Action {

    private String url;

    public Webpage(String url) {
        this.url = url;
    }

    public void launch() {
        Program program = new Program("C:/Program Files (x86)/Mozilla Firefox/firefox.exe " + url);
        program.launch();
    }
}
