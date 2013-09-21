
import com.musicg.math.rank.ArrayRankDouble;
import com.musicg.math.statistics.SpectralCentroid;
import com.musicg.math.statistics.StandardDeviation;
import com.musicg.pitch.PitchHandler;
import com.musicg.wave.Wave;
import com.musicg.wave.extension.Spectrogram;
import com.musicg.fingerprint.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.*;

public class SoundTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        AudioInputStream audioInputStream;
        AudioFormat format = new AudioFormat(48000.0f, 16, 2, true, true);
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
        while (true) {
            if ((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
                break;
            }
            int sum = 0;
            for (byte b : data) {
                sum += b;
            }
            System.out.println(sum);
            //out.write(data, 0, numBytesRead);
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
        final byte audioBytes[] = out.toByteArray();
        final ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
        audioInputStream = new AudioInputStream(bais, format,
                audioBytes.length / frameSizeInBytes);
        final long milliseconds = (long) ((audioInputStream.getFrameLength()
                * 1000) / format.getFrameRate());
        duration = milliseconds / 1000.0;
        System.out.println(duration);
        try {
            audioInputStream.reset();
            System.out.println("resetting...");
        } catch (final Exception ex) {
            ex.printStackTrace();
            return;
        }

        //MicrophoneRecorder mr = new MicrophoneRecorder(AudioFormatUtil.getDefaultFormat());  
        MicrophoneRecorder mr = new MicrophoneRecorder(format);
        mr.start();
        Thread.sleep(2000);
        mr.stop();
        Thread.sleep(1000);
        AudioInputStream stream = mr.getAudioInputStream();
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        for (byte b : bytes) {
            System.out.println(b);
        }
        //wd.saveToFile("~tmp", Type.WAVE, mr.getAudioInputStream()); 
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
//
//        int fps = spectrogram.getFramesPerSecond();
//        double unitFrequency = spectrogram.getUnitFrequency();
//
//        // set boundary
//        int highPass = 100;
//        int lowerBoundary = (int) (highPass / unitFrequency);
//        int lowPass = 4000;
//        int upperBoundary = (int) (lowPass / unitFrequency);
//        // end set boundary
//
//        double[][] spectrogramData = spectrogram.getNormalizedSpectrogramData();
//        double[][] absoluteSpectrogramData = spectrogram.getAbsoluteSpectrogramData();
//        double[][] boundedSpectrogramData = new double[spectrogramData.length][];
//
//        SpectralCentroid sc = new SpectralCentroid();
//        StandardDeviation sd = new StandardDeviation();
//        ArrayRankDouble arrayRankDouble = new ArrayRankDouble();
//
//        // zrc
//        short[] amps = wave.getSampleAmplitudes();
//        int numFrame = amps.length / 1024;
//        double[] zcrs = new double[numFrame];
//
//        for (int i = 0; i < numFrame; i++) {
//            short[] temp = new short[1024];
//            System.arraycopy(amps, i * 1024, temp, 0, temp.length);
//
//            int numZC = 0;
//            int size = temp.length;
//
//            for (int j = 0; j < size - 1; j++) {
//                if ((temp[j] >= 0 && temp[j + 1] < 0) || (temp[j] < 0 && temp[j + 1] >= 0)) {
//                    numZC++;
//                }
//            }
//
//            zcrs[i] = numZC;
//        }
//
//        // end zcr
//
//        for (int i = 0; i < spectrogramData.length; i++) {
//            double[] temp = new double[upperBoundary - lowerBoundary + 1];
//            System.arraycopy(spectrogramData[i], lowerBoundary, temp, 0, temp.length);
//
//            int maxIndex = arrayRankDouble.getMaxValueIndex(temp);
//            //sc.setValues(temp);
//            sd.setValues(temp);
//            double sdValue = sd.evaluate();
//
//            System.out.println(i + " " + (double) i / fps + "s\t" + maxIndex + "\t" + sdValue + "\t" + zcrs[i]);
//            boundedSpectrogramData[i] = temp;
//        }
//
//        PitchHandler ph = new PitchHandler();
//
//        for (int frame = 0; frame < absoluteSpectrogramData.length; frame++) {
//
//            System.out.print("frame " + frame + ": ");
//
//            double[] temp = new double[upperBoundary - lowerBoundary + 1];
//            sd.setValues(temp);
//            double sdValue = sd.evaluate();
//            double passSd = 0.1;
//
//            if (sdValue < passSd) {
//                System.arraycopy(spectrogramData[frame], lowerBoundary, temp, 0, temp.length);
//                double maxFrequency = arrayRankDouble.getMaxValueIndex(temp) * unitFrequency;
//
//                double passFrequency = 400;
//                int numRobust = 2;
//
//                double[] robustFrequencies = new double[numRobust];
//                double nthValue = arrayRankDouble.getNthOrderedValue(temp, numRobust, false);
//                int count = 0;
//                for (int b = lowerBoundary; b <= upperBoundary; b++) {
//                    if (spectrogramData[frame][b] >= nthValue) {
//                        robustFrequencies[count++] = b * unitFrequency;
//                        if (count >= numRobust) {
//                            break;
//                        }
//                    }
//                }
//
//                double passIntensity = 1000;
//                double intensity = 0;
//                for (int i = 0; i < absoluteSpectrogramData[frame].length; i++) {
//                    intensity += absoluteSpectrogramData[frame][i];
//                }
//                intensity /= absoluteSpectrogramData[frame].length;
//                System.out.print(" intensity: " + intensity + " pitch: " + maxFrequency);
//                if (intensity > passIntensity && maxFrequency > passFrequency) {
//                    double p = ph.getHarmonicProbability(robustFrequencies);
//                    System.out.print(" P: " + p);
//                }
//            }
//            System.out.print(" zcr:" + zcrs[frame]);
//            System.out.println();
//        }
//    }
}