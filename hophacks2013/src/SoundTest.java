
import com.musicg.wave.*;
import com.musicg.fingerprint.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.*;

public class SoundTest {

    private static final int THRESHOLD = 10;

    public static void main(String[] args) throws IOException, InterruptedException {
        AudioInputStream audioInputStream;
        AudioFormat format = new AudioFormat(44100.0f, 16, 2, true, false);
        TargetDataLine line;
        double duration;

        duration = 0;
        final DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        if (!AudioSystem.isLineSupported(info)) {
            line = null;
        }
        // get and open the target data line for capture.  
        try {
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format, line.getBufferSize());
        } catch (final Exception ex) {
            line = null;
        }
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
                if (b > 3*THRESHOLD) {
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
        System.out.println(duration);
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
        System.out.println(ab.size());
        int i = 0;
        for (Byte b : ab) {
            if (Math.abs(b) > 10) break;
            i++;
        }
        ab = new ArrayList<Byte>(ab.subList(i, ab.size() - 1));
        System.out.println(ab.size());
        Byte[] temp = ab.toArray(new Byte[ab.size()]);
        byte[] trimmed = new byte[temp.length];
        i = 0;
        for (Byte b : temp) {
            trimmed[i++] = b;
        }
        Wave wave = new Wave(header, trimmed);
        WaveFileManager fman = new WaveFileManager(wave);
        fman.saveWaveAsFile("test.wav");
        for (byte b : wave.getBytes()) {
            //System.out.println(b);
        }
        try {
            audioInputStream.reset();
            System.out.println("resetting...");
        } catch (final Exception ex) {
            ex.printStackTrace();
            return;
        }

    }
//        String filename = "sound/low E 1.wav";
//
//        // create a wave object
//        Wave wave = new Wave(filename);
//        System.out.println(wave.timestamp());
//        Wave wave2 = new Wave("sound/wawa2.wav");
//
//        // TimeDomainRepresentations
//        int fftSampleSize = 1024;
//        int overlapFactor = 1;
//        Spectrogram spectrogram = new Spectrogram(wave, fftSampleSize, overlapFactor);
//        FingerprintManager manager = new FingerprintManager();
//        byte[] print = manager.extractFingerprint(wave);
//        byte[] print2 = manager.extractFingerprint(wave2);
//        for (byte b : print) {
//            System.out.print(b + " ");
//        }
//        System.out.println("");
//        for (byte b : print2) {
//            System.out.print(b + " ");
//        }
//        System.out.println("");
//        FingerprintSimilarityComputer computer = new FingerprintSimilarityComputer(print, print2);
//        FingerprintSimilarity similarity = computer.getFingerprintsSimilarity();
//        System.out.println(similarity.getScore());
}