
import java.io.IOException;

/**
 *
 * @author burkaman
 */
public class Program {
    
    public static void launchProgram(String program) {
        Process process = null;
        Runtime runtime = null;

        try {
            runtime = Runtime.getRuntime();
            process = runtime.exec(program);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
