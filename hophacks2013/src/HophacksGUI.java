
import com.musicg.fingerprint.FingerprintManager;
import com.musicg.wave.Wave;
import com.musicg.wave.WaveFileManager;
import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.util.Date;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;
//import com.sun.java.swing.plaf.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author burkaman
 */
public class HophacksGUI extends javax.swing.JFrame {

    private double x[];
    private double y[];

    private MapManager manager;
    private byte[] fingerprint;
    private Action action;
    /**
     * Creates new form HophacksGUI
     */
    public HophacksGUI() {
        x = new double[5];
        y = new double[5];
        manager = new MapManager();
        action = null;
        for (int i = 1; i <= 5; i++) {
            x[i - 1] = i;
            y[i - 1] = (int) (Math.random() * 5);
        }

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        mainPanel = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        mapSoundButton = new javax.swing.JButton();
        testMapButton = new javax.swing.JButton();
        shredButton = new javax.swing.JButton();
        recordPanel = new javax.swing.JPanel();
        recordButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        recordLabel = new java.awt.Label();
        backButton = new javax.swing.JButton();
        listenButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        pickActionLabel = new javax.swing.JLabel();
        testPanel = new javax.swing.JPanel();
        testLabel = new java.awt.Label();
        backButton2 = new javax.swing.JButton();
        recordButton2 = new javax.swing.JButton();
        testResult = new javax.swing.JLabel();
        actionPicker = new javax.swing.JPanel();
        actionLabel = new java.awt.Label();
        backButton3 = new javax.swing.JButton();
        actionOptions = new javax.swing.JTabbedPane();
        programTab = new javax.swing.JPanel();
        tab1Label1 = new javax.swing.JLabel();
        tab1Text1 = new javax.swing.JTextField();
        tab1Submit = new javax.swing.JButton();
        websiteTab = new javax.swing.JPanel();
        tab2Label1 = new javax.swing.JLabel();
        tab2Text1 = new javax.swing.JTextField();
        tab2Submit = new javax.swing.JButton();
        websiteLogon = new javax.swing.JPanel();
        tab3Label1 = new javax.swing.JLabel();
        tab3Text1 = new javax.swing.JTextField();
        tab3Label2 = new javax.swing.JLabel();
        tab3Label3 = new javax.swing.JLabel();
        tab3Text2 = new javax.swing.JTextField();
        tab3Text3 = new javax.swing.JPasswordField();
        tab3Submit = new javax.swing.JButton();

        jFrame1.getContentPane().setLayout(new java.awt.CardLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(102, 102, 255));
        label1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 36)); // NOI18N
        label1.setText("HopHacks 2013");

        mapSoundButton.setText("Map Sound");
        mapSoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapSoundButtonActionPerformed(evt);
            }
        });

        testMapButton.setText("Test Mapping");
        testMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testMapButtonActionPerformed(evt);
            }
        });

        shredButton.setText("Shred");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapSoundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(271, Short.MAX_VALUE)
                    .addComponent(testMapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(shredButton, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(mapSoundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(211, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(155, Short.MAX_VALUE)
                    .addComponent(testMapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(245, Short.MAX_VALUE)
                    .addComponent(shredButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        getContentPane().add(mainPanel, "main");

        recordButton.setText("Record");
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.setEnabled(false);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        recordLabel.setAlignment(java.awt.Label.CENTER);
        recordLabel.setBackground(new java.awt.Color(102, 102, 255));
        recordLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        recordLabel.setText("Record Your Sound");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        listenButton.setText("Listen");
        listenButton.setEnabled(false);
        listenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        pickActionLabel.setText("Pick an action");
        pickActionLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pickActionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pickActionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickActionLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout recordPanelLayout = new javax.swing.GroupLayout(recordPanel);
        recordPanel.setLayout(recordPanelLayout);
        recordPanelLayout.setHorizontalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addComponent(recordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createSequentialGroup()
                        .addComponent(recordButton, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createSequentialGroup()
                        .addComponent(pickActionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitButton)))
                .addContainerGap())
        );
        recordPanelLayout.setVerticalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(recordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickActionLabel))
                .addContainerGap())
        );

        getContentPane().add(recordPanel, "mapSound");

        testLabel.setAlignment(java.awt.Label.CENTER);
        testLabel.setBackground(new java.awt.Color(102, 102, 255));
        testLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        testLabel.setText("Test Your Sound");

        backButton2.setText("Back");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        recordButton2.setText("Record");
        recordButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButton2ActionPerformed(evt);
            }
        });

        testResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout testPanelLayout = new javax.swing.GroupLayout(testPanel);
        testPanel.setLayout(testPanelLayout);
        testPanelLayout.setHorizontalGroup(
            testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(recordButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(testPanelLayout.createSequentialGroup()
                        .addComponent(backButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(testResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        testPanelLayout.setVerticalGroup(
            testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(testResult, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(testPanel, "testSound");

        actionLabel.setAlignment(java.awt.Label.CENTER);
        actionLabel.setBackground(new java.awt.Color(102, 102, 255));
        actionLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        actionLabel.setText("Pick An Action");

        backButton3.setText("Back");
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });

        tab1Label1.setText("Path: ");

        tab1Submit.setText("Submit");
        tab1Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout programTabLayout = new javax.swing.GroupLayout(programTab);
        programTab.setLayout(programTabLayout);
        programTabLayout.setHorizontalGroup(
            programTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, programTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(programTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(programTabLayout.createSequentialGroup()
                        .addGap(0, 364, Short.MAX_VALUE)
                        .addComponent(tab1Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(programTabLayout.createSequentialGroup()
                        .addComponent(tab1Label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab1Text1)))
                .addContainerGap())
        );
        programTabLayout.setVerticalGroup(
            programTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(programTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab1Label1)
                    .addComponent(tab1Text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(tab1Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        actionOptions.addTab("Program", programTab);

        tab2Label1.setText("URL: ");

        tab2Submit.setText("Submit");
        tab2Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout websiteTabLayout = new javax.swing.GroupLayout(websiteTab);
        websiteTab.setLayout(websiteTabLayout);
        websiteTabLayout.setHorizontalGroup(
            websiteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(websiteTabLayout.createSequentialGroup()
                .addGroup(websiteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(websiteTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tab2Label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab2Text1))
                    .addGroup(websiteTabLayout.createSequentialGroup()
                        .addGap(143, 376, Short.MAX_VALUE)
                        .addComponent(tab2Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        websiteTabLayout.setVerticalGroup(
            websiteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(websiteTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(websiteTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab2Label1)
                    .addComponent(tab2Text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(tab2Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        actionOptions.addTab("Website", websiteTab);

        tab3Label1.setText("URL: ");

        tab3Label2.setText("Username: ");

        tab3Label3.setText("Password: ");

        tab3Submit.setText("Submit");
        tab3Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab3SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout websiteLogonLayout = new javax.swing.GroupLayout(websiteLogon);
        websiteLogon.setLayout(websiteLogonLayout);
        websiteLogonLayout.setHorizontalGroup(
            websiteLogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(websiteLogonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(websiteLogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(websiteLogonLayout.createSequentialGroup()
                        .addComponent(tab3Label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab3Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                    .addGroup(websiteLogonLayout.createSequentialGroup()
                        .addComponent(tab3Label3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab3Text3))
                    .addGroup(websiteLogonLayout.createSequentialGroup()
                        .addComponent(tab3Label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab3Text2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, websiteLogonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tab3Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        websiteLogonLayout.setVerticalGroup(
            websiteLogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(websiteLogonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(websiteLogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab3Label1)
                    .addComponent(tab3Text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(websiteLogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab3Label2)
                    .addComponent(tab3Text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(websiteLogonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab3Label3)
                    .addComponent(tab3Text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(tab3Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        actionOptions.addTab("Website With Logon", websiteLogon);

        javax.swing.GroupLayout actionPickerLayout = new javax.swing.GroupLayout(actionPicker);
        actionPicker.setLayout(actionPickerLayout);
        actionPickerLayout.setHorizontalGroup(
            actionPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPickerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actionPickerLayout.createSequentialGroup()
                        .addComponent(backButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actionPickerLayout.createSequentialGroup()
                        .addGroup(actionPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(actionOptions, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))))
        );
        actionPickerLayout.setVerticalGroup(
            actionPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPickerLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(backButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionOptions)
                .addContainerGap())
        );

        getContentPane().add(actionPicker, "action");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mapSoundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapSoundButtonActionPerformed
        CardLayout cl = (CardLayout) this.getContentPane().getLayout();
        cl.show(this.getContentPane(), "mapSound");
    }//GEN-LAST:event_mapSoundButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        resetButtonActionPerformed(evt);
        CardLayout cl = (CardLayout) this.getContentPane().getLayout();
        cl.show(this.getContentPane(), "main");
    }//GEN-LAST:event_backButtonActionPerformed

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        MicrophoneRecorder mr = new MicrophoneRecorder();
        Wave wave = mr.record();
        this.listenButton.setEnabled(true);
        this.resetButton.setEnabled(true);
        this.submitButton.setEnabled(true);
        this.recordButton.setEnabled(false);
        WaveFileManager fman = new WaveFileManager(wave);
        fman.saveWaveAsFile("temp.wav");
        FingerprintManager printMan = new FingerprintManager();
        fingerprint = printMan.extractFingerprint(wave);
    }//GEN-LAST:event_recordButtonActionPerformed

    private void listenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenButtonActionPerformed
        try {
            File file = new File("temp.wav");
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(file);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_listenButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        File file = new File("temp.wav");
        file.delete();
        fingerprint = null;
        this.listenButton.setEnabled(false);
        this.submitButton.setEnabled(false);
        this.resetButton.setEnabled(false);
        this.recordButton.setEnabled(true);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (action == null) {
            JOptionPane.showMessageDialog(this, "You must select an action");
            return;
        }
        String name = JOptionPane.showInputDialog(this, "What is the name of this sound?");
        Sound sound = new Sound(fingerprint, name, new Date());
        manager.add(sound, action);
        this.pickActionLabel.setText("Pick an action");
        action = null;
        backButtonActionPerformed(evt);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        this.testResult.setText("");
        CardLayout cl = (CardLayout) this.getContentPane().getLayout();
        cl.show(this.getContentPane(), "main");
    }//GEN-LAST:event_backButton2ActionPerformed

    private void recordButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButton2ActionPerformed
        MicrophoneRecorder mr = new MicrophoneRecorder();
        Wave wave = mr.record();
        FingerprintManager printMan = new FingerprintManager();
        fingerprint = printMan.extractFingerprint(wave);
        action = manager.get(fingerprint);
        if (action == null) {
            this.testResult.setText("No match found");
            return;
        }
        this.testResult.setText(("Success"));
        action.launch();
    }//GEN-LAST:event_recordButton2ActionPerformed

    private void testMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testMapButtonActionPerformed
        CardLayout cl = (CardLayout) this.getContentPane().getLayout();
        cl.show(this.getContentPane(), "testSound");
    }//GEN-LAST:event_testMapButtonActionPerformed

    private void backButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton3ActionPerformed
        CardLayout cl = (CardLayout) this.getContentPane().getLayout();
        cl.show(this.getContentPane(), "mapSound");
    }//GEN-LAST:event_backButton3ActionPerformed

    private void pickActionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickActionLabelMouseClicked
        CardLayout cl = (CardLayout) this.getContentPane().getLayout();
        cl.show(this.getContentPane(), "action");
    }//GEN-LAST:event_pickActionLabelMouseClicked

    private void tab1SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1SubmitActionPerformed
        String path = this.tab1Text1.getText();
        action = new Program(path);
        this.pickActionLabel.setText("Program: " + path);
        backButton3ActionPerformed(evt);
    }//GEN-LAST:event_tab1SubmitActionPerformed

    private void tab2SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab2SubmitActionPerformed
        String url = this.tab2Text1.getText();
        action = new Webpage(url);
        this.pickActionLabel.setText("Webpage: " + url);
        backButton3ActionPerformed(evt);
    }//GEN-LAST:event_tab2SubmitActionPerformed

    private void tab3SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab3SubmitActionPerformed
        String url = this.tab3Text1.getText();
        String user = this.tab3Text2.getText();
        String pass = new String(this.tab3Text3.getPassword());
        action = new WebpageLogin(url, user, pass);
        this.pickActionLabel.setText("Webpage login: " + url);
        backButton3ActionPerformed(evt);
    }//GEN-LAST:event_tab3SubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        double x[] = {1,2,3,4,5};
//        double y[] = {1,2,3,4,5};
//        
//        Plot2DPanel plot = new Plot2DPanel();
//        plot.addLinePlot("my plot",x,y);
//        jpanel1.getContentPane(plot);
//        JFrame frame = new JFrame ("a plot panel");
//        frame.setSize(new Dimension(500,500));
//        frame.setContentPane(plot);
//        frame.setVisible(true);
        TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("img/hacklogo.png").getScaledInstance(16, 16, 0));
        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HophacksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HophacksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HophacksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HophacksGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new HophacksGUI().setVisible(true);

            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label actionLabel;
    private javax.swing.JTabbedPane actionOptions;
    private javax.swing.JPanel actionPicker;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton backButton3;
    private javax.swing.JFrame jFrame1;
    private java.awt.Label label1;
    private javax.swing.JButton listenButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton mapSoundButton;
    private javax.swing.JLabel pickActionLabel;
    private javax.swing.JPanel programTab;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton recordButton2;
    private java.awt.Label recordLabel;
    private javax.swing.JPanel recordPanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton shredButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel tab1Label1;
    private javax.swing.JButton tab1Submit;
    private javax.swing.JTextField tab1Text1;
    private javax.swing.JLabel tab2Label1;
    private javax.swing.JButton tab2Submit;
    private javax.swing.JTextField tab2Text1;
    private javax.swing.JLabel tab3Label1;
    private javax.swing.JLabel tab3Label2;
    private javax.swing.JLabel tab3Label3;
    private javax.swing.JButton tab3Submit;
    private javax.swing.JTextField tab3Text1;
    private javax.swing.JTextField tab3Text2;
    private javax.swing.JPasswordField tab3Text3;
    private java.awt.Label testLabel;
    private javax.swing.JButton testMapButton;
    private javax.swing.JPanel testPanel;
    private javax.swing.JLabel testResult;
    private javax.swing.JPanel websiteLogon;
    private javax.swing.JPanel websiteTab;
    // End of variables declaration//GEN-END:variables
}
