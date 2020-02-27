package GUI;

import javax.swing.*;
import java.awt.*;

public class DownloadWindow {

    private JFrame downloadInformation;
    private DownloadGUI downloadGUI;
    private NewDownloadFrame newDownloadFrame;
    private SettingFrame settingFrame;

    private JLabel fileName;
    private JLabel fileSize;
    private JLabel downloadedValue;
    private JLabel downloadSpeed;
    private JLabel downloadedValuePercent;
    private JLabel downloadAddress;
    private JLabel downloadStored;

    public DownloadWindow() {
        fileName = new JLabel();
        fileSize = new JLabel();
        downloadedValue = new JLabel();
        downloadSpeed = new JLabel();
        downloadedValuePercent = new JLabel();
        downloadAddress = new JLabel();
        downloadStored = new JLabel();

        downloadInformation = new JFrame();
        newDownloadFrame = new NewDownloadFrame();
        newDownloadFrame.diposeFrame();
        downloadGUI = new DownloadGUI(newDownloadFrame.getDownloadAddress().getText());
        settingFrame = new SettingFrame();
        settingFrame.diposeFrame();

        fileName.setText("file name : " + downloadGUI.getFileName().getText());
        fileSize.setText("file size : " + downloadGUI.getFileSize2() + "MB");
        downloadedValue.setText("downloaded value : " + downloadGUI.getDownloadedValue2() + "MB");
        downloadSpeed.setText("downloadSpeed : " + downloadGUI.getDownloadSpeed2());
        downloadedValuePercent.setText("downloaded value percent : " + Integer.toString(downloadGUI.getDownloadedvaluePercent()) + "MB/S");
        downloadAddress.setText("download address : " /* + newDownloadFrame.getDownloadAddress().getText()*/);
        downloadStored.setText("download stored : "/*+ settingFrame.getFileChooser().getSelectedFile().getPath()*/);

        createWindow(downloadInformation, "downloadInformation", 600, 600, 600, 400);
        downloadInformation.setLayout(new GridLayout(10, 1));

        downloadInformation.add(fileName);
        downloadInformation.add(fileSize);
        downloadInformation.add(downloadedValue);
        downloadInformation.add(downloadSpeed);
        downloadInformation.add(downloadedValuePercent);
        downloadInformation.add(downloadAddress);
        downloadInformation.add(downloadStored);

    }


    public void createWindow(JFrame jFrame, String title, int width, int height, int x, int y) {
        jFrame.setTitle(title);
        jFrame.setSize(width, height);
        jFrame.setLocation(x, y);
        jFrame.setVisible(true);
    }
}
