package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewDownloadFrame {

    // fields //

    // frame
    private JFrame newDownloadFrame;

    // frames image icon
    private ImageIcon newDownloadFrameIcon;

    // new download buttons
    private JButton ok;
    private JButton cancel;

    // text area
    private JTextArea downloadAddress = new JTextArea();

    // radio button
    private JRadioButton isInQueue;

    // a jlabel for address
    private JLabel address;

    // a listener
    private clickListener click;

    // Constructor //

    public NewDownloadFrame() {

        // create frame
        newDownloadFrame = new JFrame();

        // create frame image icons
        newDownloadFrameIcon = new ImageIcon("downloadIcon.png");

        // add images to frames icon
        newDownloadFrame.setIconImage(newDownloadFrameIcon.getImage());

        // create new download buttons
        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        // create radio button
        isInQueue = new JRadioButton("add to queue");

        // create frame
        createWindow(newDownloadFrame, "New Download ", 400, 200, 750, 400);
        newDownloadFrame.setResizable(false);
        newDownloadFrame.setLayout(null);
        newDownloadFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // create image
        ImageIcon addressIcon = new ImageIcon("addressIcon.png");
        address = new JLabel("Address");
        address.setIcon(addressIcon);
        address.setSize(100, 100);
        address.setLocation(20, 2);

        // set buttons and text field size and location
        downloadAddress.setSize(300, 20);
        downloadAddress.setLocation(100, 43);
        ok.setSize(100, 20);
        ok.setLocation(95, 120);
        cancel.setSize(100, 20);
        cancel.setLocation(205, 120);
        isInQueue.setSize(100, 20);
        isInQueue.setLocation(145, 80);

        // create and add buttons
        click = new clickListener();
        ok.addActionListener(click);
        cancel.addActionListener(click);

        // add buttons and textfield to frame
        newDownloadFrame.add(address);
        newDownloadFrame.add(downloadAddress);
        newDownloadFrame.add(isInQueue);
        newDownloadFrame.add(ok);
        newDownloadFrame.add(cancel);

    }

    // Methods //

    // this method load the hided frame
    public void loadNewDownloadWindow() {
        newDownloadFrame.setVisible(true);
    }

    protected class clickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // new download buttons
            if (e.getSource() == ok) {
                // will executed twice

                System.out.println("ok");
                downloadAddress.setText("");
                isInQueue.setSelected(false);
                newDownloadFrame.dispose();

            }
            if (e.getSource() == cancel) {
                System.out.println("cancel");
                downloadAddress.setText("");
                newDownloadFrame.dispose();
            }

        }
    }

    // create new download window
    public void createWindow(JFrame jFrame, String title, int width, int height, int x, int y) {
        jFrame.setTitle(title);
        jFrame.setSize(width, height);
        jFrame.setLocation(x, y);
        jFrame.setVisible(true);
    }

    public JButton getOk() {
        return ok;
    }


    public JTextArea getDownloadAddress() {
        return downloadAddress;
    }


    public JRadioButton getIsInQueue() {
        return isInQueue;
    }

    public void diposeFrame() {
        newDownloadFrame.dispose();
    }

}
