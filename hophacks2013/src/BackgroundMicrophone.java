
import com.musicg.wave.Wave;
import com.musicg.wave.WaveFileManager;
import com.musicg.wave.WaveHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * Reads data from the input channel and writes to the output stream Modified
 * from:
 * http://ganeshtiwaridotcomdotnp.blogspot.com/2011/12/java-sound-capture-from-microphone.html
 */
public class BackgroundMicrophone implements Runnable {
    // record microphone && generate stream/byte array  

    private AudioInputStream audioInputStream;
    private AudioFormat format;
    public TargetDataLine line;
    public Thread thread;
    private double duration;
    private static final int THRESHOLD = 10;

    public BackgroundMicrophone() {
    }

    public void start() {
        thread = new Thread(this);
        thread.setName("Capture");
        thread.start();
    }

    public void stop() {
        thread = null;
    }

    public void run() {
        format = new AudioFormat(44100.0f, 16, 2, true, false);

        duration = 0;
        line = getTargetDataLineForRecord();

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final int frameSizeInBytes = format.getFrameSize();
        final int bufferLengthInFrames = line.getBufferSize() / 8;
        final int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
        final byte[] data = new byte[bufferLengthInBytes];
        int numBytesRead;
        line.start();
        boolean quiet = true;
        while (quiet) {
            if ((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
                break;
            }
            for (byte b : data) {
                if (b > THRESHOLD) {
                    out.write(data, 0, numBytesRead);
                    quiet = false;
                    break;
                }
            }
        }
        int quietFrames = 0;
        while (quietFrames < 3) {
            if ((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
                break;
            }
            quietFrames++;
            for (byte b : data) {
                if (b > 3 * THRESHOLD) {
                    quietFrames--;
                    break;
                }
            }
            out.write(data, 0, numBytesRead);
        }
        // we reached the end of the stream. stop and close the line.  
        line.stop();
        line.close();
        line = null;
        // stop and close the output stream  
        try {
            out.flush();
            out.close();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        // load bytes into the audio input stream for playback  
        byte audioBytes[] = out.toByteArray();
        final ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
        audioInputStream = new AudioInputStream(bais, format,
                audioBytes.length / frameSizeInBytes);
        final long milliseconds = (long) ((audioInputStream.getFrameLength()
                * 1000) / format.getFrameRate());
        duration = milliseconds / 1000.0;
        WaveHeader header = new WaveHeader();
        header.setBitsPerSample(16);
        header.setChannels(2);
        header.setSampleRate(44100);
        header.setByteRate(176400);
        header.setBlockAlign(4);
        header.setChunkId("RIFF");
        header.setChunkSize(audioBytes.length);
        header.setFormat("WAVE");
        header.setSubChunk1Id("fmt");
        header.setSubChunk1Size(16);
        header.setAudioFormat(1);
        header.setSubChunk2Id("data");
        header.setSubChunk2Size(audioBytes.length);
        ArrayList<Byte> ab = new ArrayList<Byte>();
        for (byte b : audioBytes) {
            ab.add(b);
        }
        int i = 0;
        for (Byte b : ab) {
            if (Math.abs(b) > THRESHOLD) {
                break;
            }
            i++;
        }
        ab = new ArrayList<Byte>(ab.subList(i, ab.size() - 1));
        Byte[] temp = ab.toArray(new Byte[ab.size()]);
        byte[] trimmed = new byte[temp.length];
        i = 0;
        for (Byte b : temp) {
            trimmed[i++] = b;
        }
        Wave wave = new Wave(header, trimmed);
    }

    private TargetDataLine getTargetDataLineForRecord() {
        TargetDataLine line;
        final DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        if (!AudioSystem.isLineSupported(info)) {
            return null;
        }
        // get and open the target data line for capture.  
        try {
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format, line.getBufferSize());
        } catch (final Exception ex) {
            return null;
        }
        return line;
    }

    public AudioInputStream getAudioInputStream() {
        return audioInputStream;
    }

    public AudioFormat getFormat() {
        return format;
    }

    public void setFormat(AudioFormat format) {
        this.format = format;
    }

    public Thread getThread() {
        return thread;
    }

    public double getDuration() {
        return duration;
    }
}