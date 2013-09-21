import com.musicg.fingerprint.FingerprintSimilarityComputer;
import java.util.HashMap;

/**
 *
 * @author Julia
 */
public class MapManager {

    private HashMap<byte[],String> database;
    private float THRESHOLD = 0.5f;

    public MapManager() {
        database = new HashMap<byte[],String>();
    }

    public void add(byte[] fingerprint, String action) {
        database.put(fingerprint, action);
    }

    public String get(byte[] fingerprint) {
        FingerprintSimilarityComputer fsc;
        String best = "No match found";
        for (byte[] print : database.keySet()) {
            fsc = new FingerprintSimilarityComputer(fingerprint, print);
            float score = fsc.getFingerprintsSimilarity().getSimilarity();
            if (score > THRESHOLD) best = database.get(print);
        }
        return best;
    }
}
