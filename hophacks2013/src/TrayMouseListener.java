
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author burkaman
 */
public class TrayMouseListener implements MouseListener {

    private JFrame frame;
    private BackgroundMicrophone mic;

    public TrayMouseListener(JFrame frame) {
        this.frame = frame;
        mic = new BackgroundMicrophone();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (frame.isVisible()) {
            frame.setVisible(false);
            mic.start();
        }
        frame.setVisible(!frame.isVisible());
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
