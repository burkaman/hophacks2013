import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author burkaman
 */
public class Program implements Action, Serializable {

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
