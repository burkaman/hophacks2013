import com.musicg.fingerprint.FingerprintSimilarityComputer;
import java.util.HashMap;

/**
 *
 * @author Julia
 */
public class MapManager {

    private HashMap<byte[],Action> database;
    private float THRESHOLD = 0.4f;

    public MapManager() {
        database = new HashMap<byte[],Action>();
    }

    public void add(byte[] fingerprint, Action action) {
        database.put(fingerprint, action);
    }

    public Action get(byte[] fingerprint) {
        FingerprintSimilarityComputer fsc;
        Action best = null;
        for (byte[] print : database.keySet()) {
            double ratio = ((double) fingerprint.length)/((double) print.length);
            if (ratio > 1.25 || ratio < 0.75) {
                System.out.println("Mismatched lengths");
                continue;
            }
            fsc = new FingerprintSimilarityComputer(fingerprint, print);
            float score = fsc.getFingerprintsSimilarity().getSimilarity();
            System.out.println("Score: " + score);
            if (score > THRESHOLD) best = database.get(print);
        }
        return best;
    }
}
