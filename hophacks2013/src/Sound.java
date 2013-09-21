
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author burkaman
 */
public class Sound implements Serializable { 

    private byte[] fingerprint;
    private String name;
    private Date created;

    public Sound(byte[] fingerprint, String name, Date created) {
        this.fingerprint = fingerprint;
        this.name = name;
        this.created = created;
    }

    public byte[] getFingerprint() {
        return fingerprint;
    }

    public String getName() {
        return name;
    }

    public Date getCreated() {
        return created;
    }
}
