
import com.musicg.fingerprint.FingerprintSimilarityComputer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Julia
 */
public class MapManager implements Serializable {

    private HashMap<byte[], Action> database;
    private static final float THRESHOLD = 0.7f;

    public MapManager() {
        database = new HashMap<byte[], Action>();
        try {
            FileInputStream fileIn = new FileInputStream("data");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            database = (HashMap<byte[], Action>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
    }

    public void add(byte[] fingerprint, Action action) {
        database.put(fingerprint, action);
        try {
            FileOutputStream fileOut = new FileOutputStream("data");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(database);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Action get(byte[] fingerprint) {
        FingerprintSimilarityComputer fsc;
        Action best = null;
        for (byte[] print : database.keySet()) {
            double ratio = ((double) fingerprint.length) / ((double) print.length);
            if (ratio > 1.25 || ratio < 0.75) {
                System.out.println("Mismatched lengths");
                continue;
            }
            fsc = new FingerprintSimilarityComputer(fingerprint, print);
            float score = fsc.getFingerprintsSimilarity().getSimilarity();
            System.out.println("Score: " + score);
            if (score > THRESHOLD) {
                best = database.get(print);
            }
        }
        return best;
    }
}
