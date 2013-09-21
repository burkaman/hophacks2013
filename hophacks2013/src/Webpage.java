import java.io.Serializable;

/**
 *
 * @author Julia
 */
public class Webpage implements Action, Serializable {

    private String url;

    public Webpage(String url) {
        this.url = url;
    }

    public void launch() {
        Program program = new Program("C:/Program Files (x86)/Mozilla Firefox/firefox.exe " + url);
        program.launch();
    }
}
