package GUI;

import javax.swing.*;
import java.awt.*;

public class AboutFrame {

    // fields //

    // frame
    private JFrame aboutFrame;

    // frames image icon
    private ImageIcon aboutFrameIcon;

    // text panes
    private JTextPane information;
    private JTextPane tips;

    // Constructor //


    public AboutFrame() {


        // create frame
        aboutFrame = new JFrame();

        // create frame image icons
        aboutFrameIcon = new ImageIcon("downloadIcon.png");

        // add images to frames icon
        aboutFrame.setIconImage(aboutFrameIcon.getImage());

        // create the frame
        createWindow(aboutFrame, "About", 500, 300, 750, 400);
        aboutFrame.setLayout(new GridLayout(2, 1));

        // create jtextpanes
        information = new JTextPane();
        tips = new JTextPane();

        // make texts uneditable
        information.setEditable(false);
        tips.setEditable(false);

        // set text to jtextpanes
        information.setText("Information : \n" +
                "programmer : Erfan Afshar \n" +
                "student ID : 9631007 \n" +
                "date of start : 5/12/2018 \n" +
                "date of end : 5/30/2018 \n");
        tips.setText("Tips : \n" +
                "This app can download files from everywhere for you. \n" +
                "You can use Shortcut in this app. \n" +
                "And can choose where your downloads will be stored. \n");

        // add jtextpanes to frame
        aboutFrame.add(information);
        aboutFrame.add(tips);

    }

    // Methods //

    // create new download window
    public void createWindow(JFrame jFrame, String title, int width, int height, int x, int y) {
        jFrame.setTitle(title);
        jFrame.setSize(width, height);
        jFrame.setLocation(x, y);
        jFrame.setVisible(true);
    }

}
