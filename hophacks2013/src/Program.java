
import java.io.IOException;

/**
 *
 * @author burkaman
 */
public class Program implements Action {

    private String path;

    public Program(String path) {
        this.path = path;
    }
    
    public void launch() {
        Process process = null;
        Runtime runtime = null;

        try {
            runtime = Runtime.getRuntime();
            process = runtime.exec(path);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
