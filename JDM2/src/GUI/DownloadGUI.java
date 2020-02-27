package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DownloadGUI {

    // fields //

    private JPanel downloadPanel;
    private JProgressBar progressBar;
    private JLabel fileName;
    private JLabel fileSize;
    private JLabel downloadedValue;
    private int fileSize2;
    private int downloadedValue2;
    private int downloadedvaluePercent;
    private JLabel downloadSpeed;
    private int downloadSpeed2;

    private JButton startButton;
    private JButton stopButton;
    private JButton cancelButton;

    // constructor //

    public DownloadGUI(String nameFile) {

        // create jpanel and jprogressbar
        downloadPanel = new JPanel();
        progressBar = new JProgressBar(0, 100);
        fileName = new JLabel();
        fileSize = new JLabel();
        downloadedValue = new JLabel();
        downloadSpeed = new JLabel();

        startButton = new JButton();
        stopButton = new JButton();
        cancelButton = new JButton();


        // set panel layout
        downloadPanel.setLayout(null);

        // set panel color and size and location
        downloadPanel.setBackground(Color.cyan);
        downloadPanel.setLocation(100, 100);
        downloadPanel.setSize(100, 600);

        // progress bar changes and set location
        progressBar.setSize(430, 20);
        progressBar.setLocation(20, 30);
        progressBar.setValue(40);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.white);
        progressBar.setForeground(Color.black);

        downloadPanel.add(progressBar);

        // file name
        fileName.setText(nameFile);
        fileName.setSize(400, 15);
        fileName.setLocation(20, 10);

        downloadPanel.add(fileName);

        // file size
        fileSize2 = 100;
        fileSize.setText("/" + fileSize2 + "MB");
        fileSize.setSize(60, 80);
        fileSize.setLocation(405, 30);

        downloadPanel.add(fileSize);

        // downloadedvalue
        downloadedValue2 = 40;
        downloadedValue.setText(downloadedValue2 + "MB");
        downloadedValue.setSize(60, 80);
        downloadedValue.setLocation(370, 30);

        downloadPanel.add(downloadedValue);


        // download speed
        downloadSpeed2 = 2;
        downloadSpeed.setText(downloadSpeed2 + "MB/S");
        downloadSpeed.setSize(60, 80);
        downloadSpeed.setLocation(290, 30);

        downloadPanel.add(downloadSpeed);

        // add image to three buttons
        ImageIcon startImage = new ImageIcon("startIcon.png");
        startButton.setIcon(startImage);

        ImageIcon stopImage = new ImageIcon("pauseIcon.png");
        stopButton.setIcon(stopImage);

        ImageIcon cancelImage = new ImageIcon("deleteIcon.png");
        cancelButton.setIcon(cancelImage);

        // set buttons size and location
        startButton.setSize(20, 20);
        startButton.setLocation(20, 60);

        stopButton.setSize(20, 20);
        stopButton.setLocation(50, 60);

        cancelButton.setSize(20, 20);
        cancelButton.setLocation(80, 60);

        // add buttons to panel
        downloadPanel.add(startButton);
        downloadPanel.add(stopButton);
        downloadPanel.add(cancelButton);

        downloadPanel.setBorder(new LineBorder(Color.black, 3));

        MouseClickHandler click = new MouseClickHandler();
        downloadPanel.addMouseListener(click);

        //downloadedvaluePercent =  Integer.parseInt(downloadedvalue.getText()) / Integer.parseInt(fileSize.getText());
    }

    // methods //


    public JPanel getDownloadPanel() {
        return downloadPanel;
    }

    public JLabel getFileName() {
        return fileName;
    }

    public int getDownloadedvaluePercent() {
        return downloadedvaluePercent;
    }

    public int getFileSize2() {
        return fileSize2;
    }

    public int getDownloadedValue2() {
        return downloadedValue2;
    }

    public int getDownloadSpeed2() {
        return downloadSpeed2;
    }

    private class MouseClickHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            //super.mouseClicked(e);
            if (e.isMetaDown()) {
                System.out.println("why right");
                DownloadWindow downloadWindow = new DownloadWindow();
            }
        }
    }
}
