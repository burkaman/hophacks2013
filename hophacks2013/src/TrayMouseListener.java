
import com.musicg.wave.Wave;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author burkaman
 */
public class TrayMouseListener implements MouseListener {

    private HophacksGUI frame;
    private Thread thread;
    private boolean forever;

    public TrayMouseListener(HophacksGUI frame) {
        this.frame = frame;
        forever = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (frame.isVisible()) {
            frame.setVisible(false);
            forever = true;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    MicrophoneRecorder mr = new MicrophoneRecorder();
                    while (forever) {
                        Wave wave = mr.record();
                        frame.playAction();
                    }
                }
            });
            thread.start();
        } else {
            forever = false;
            frame.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
}
