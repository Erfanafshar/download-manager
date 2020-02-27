package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SettingFrame {

    // fields //

    // frame
    private JFrame settingFrame;

    // frames image icon
    private ImageIcon settingFrameIcon;

    // container for setting card layout
    private Container settingContainer;

    // card layout
    private CardLayout settingCardLayout;

    // setting button
    private JButton next;
    private JButton save;

    // a jlabel
    private JLabel question1;

    // two panel
    private JPanel buttonPanel;
    private JPanel savePanel;

    // three important panel
    private JPanel simultaneousDownloadNumber;
    private JPanel chooseDownloadStorage;
    private JPanel chooseLookAndFeel;

    // a click listener
    private clickListener clickListener;

    // a combo box
    private JComboBox numbersOfSimultaneousDownload;

    // for file choosing
    private JFileChooser fileChooser;
    private File file;

    // two  jlabel
    private JLabel text1;
    private JLabel text2;

    // a combo box
    private JComboBox lookAndFeel;

    // array list for combo boxes
    private String[] lookAndFeels = {"Default", "Nimbus", "Windows"};
    private String[] numbers = {"unlimit", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    // Constructor //


    public SettingFrame() {


        // create frame
        settingFrame = new JFrame();

        // create frame image icons
        settingFrameIcon = new ImageIcon("downloadIcon.png");

        // add images to frames icon
        settingFrame.setIconImage(settingFrameIcon.getImage());

        // container
        settingContainer = new Container();

        // card layout
        settingCardLayout = new CardLayout();

        // create setting buttons
        next = new JButton("next");
        save = new JButton("save");


        // download number //

        // create a Jlabel
        question1 = new JLabel();

        // set the text to label
        question1.setText("choose the simultaneous download number ");

        // two panel to use card layout
        buttonPanel = new JPanel();
        savePanel = new JPanel();

        // set frame layout
        settingFrame.setLayout(new BorderLayout());

        // set panels layout
        buttonPanel.setLayout(new BorderLayout());
        savePanel.setLayout(new BorderLayout());

        // create setting frame
        createWindow(settingFrame, "Setting", 500, 450, 750, 400);
        settingFrame.setResizable(false);
        settingFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // create three panel for three setting frame parts
        simultaneousDownloadNumber = new JPanel();
        chooseDownloadStorage = new JPanel();
        chooseLookAndFeel = new JPanel();

        // set simultaneousDownloadNumber layout
        simultaneousDownloadNumber.setLayout(new GridLayout(8, 1));

        // set the container layout
        settingContainer.setLayout(settingCardLayout);

        // create listener
        clickListener = new clickListener();

        // set the button text and add action listener to that
        next.addActionListener(clickListener);
        save.addActionListener(clickListener);

        // crate combo box and array
        numbersOfSimultaneousDownload = new JComboBox(numbers);

        // add two object to panel
        simultaneousDownloadNumber.add(question1);
        simultaneousDownloadNumber.add(numbersOfSimultaneousDownload);

        // add button to panel
        buttonPanel.add(next);
        savePanel.add(save);

        // file chooser //

        // create file chooser and set the Current Directory
        chooseDownloadStorage.setLayout(new BorderLayout());
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file = new File("C:\\Users\\Erfan\\Desktop");
        fileChooser.setCurrentDirectory(file);


        // jlabel
        text1 = new JLabel();
        text1.setText("choose where downloads store ");

        chooseDownloadStorage.add(text1, BorderLayout.NORTH);
        chooseDownloadStorage.add(fileChooser, BorderLayout.SOUTH);

        // L & F //

        chooseLookAndFeel.setLayout(new GridLayout(7, 1));
        text2 = new JLabel();
        text2.setText("choose the look end feel ");
        chooseLookAndFeel.add(text2);

        // crate combo box and array
        lookAndFeel = new JComboBox(lookAndFeels);

        chooseLookAndFeel.add(lookAndFeel);

        // add panels to container
        settingContainer.add(simultaneousDownloadNumber);
        settingContainer.add(chooseDownloadStorage);
        settingContainer.add(chooseLookAndFeel);

        // add buttonPanel and settingContainer to settingFrame
        settingFrame.add(buttonPanel, BorderLayout.NORTH);
        settingFrame.add(settingContainer, BorderLayout.CENTER);
        settingFrame.add(savePanel, BorderLayout.SOUTH);

    }

    // Methods //

    // this method load the hided frame
    public void loadSettingWindow() {
        settingFrame.setVisible(true);
    }

    protected class clickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // setting frame
            if (e.getSource() == next) {
                settingCardLayout.next(settingContainer);
                System.out.println("next ");
            }
            if (e.getSource() == save) {
                setLookAndFeel(lookAndFeels[lookAndFeel.getSelectedIndex()]);
                System.out.println("save");
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

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    // set look and fill with given string
    public void setLookAndFeel(String name) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (name.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
    }

    public void diposeFrame() {
        settingFrame.dispose();
    }
}

