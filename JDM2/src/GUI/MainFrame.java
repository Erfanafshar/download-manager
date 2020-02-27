package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame {

    // fields //

    private JScrollPane queueScrollPane;
    private JScrollPane scrollPane;

    // frame
    private JFrame mainFrame;

    // other frames
    private NewDownloadFrame newDownloadFrame;
    private AboutFrame aboutFrame;
    private SettingFrame settingFrame;

    // frames image icon
    private ImageIcon mainFrameImageIcon;

    // panels
    private JPanel toolBar;
    private JPanel leftMenu;
    private JPanel downloads;
    private JPanel queuePanel;

    // other panels
    //DownloadGUI down ;

    // Download table
    DownloadTable downloadTable;
    QueueGUI queue;

    // listener
    private clickListener listener;

    // toolBar buttons
    private JButton addButton;
    private JButton resumeButton;
    private JButton pauseButton;
    private JButton cancelButton;
    private JButton removeButton;
    private JButton replaceButton;
    private JButton settingButton;

    // left menu buttons
    private JButton processingButton;
    private JButton completedButton;
    private JButton queuesButton;

    // toolBar images
    private ImageIcon addImage;
    private ImageIcon startImage;
    private ImageIcon pauseImage;
    private ImageIcon deleteImage;
    private ImageIcon trashImage;
    private ImageIcon repalceImage;
    private ImageIcon settingImage;

    // menuBar images
    private ImageIcon processingImage;
    private ImageIcon completedImage;
    private ImageIcon queuesImage;

    //  menu fields
    private JMenuBar menus;
    private JMenu download, help;
    private JMenuItem newDownloadItem, pauseItem, resumeItem, cancelItem, removeItem, replaceItem, settingItem, exitItem, aboutItem;

    // for preventing errors
    private int settingClicks = 0;
    private int newWindowClicks = 0;


    // tray
    private TrayIcon trayIcon = null;

    MenuItem menuItem;


    // Constructor //

    public MainFrame() {

        // create listener
        clickListener listener = new clickListener();

        // create frame
        mainFrame = new JFrame();

        /*
        // create other frames
        newDownloadFrame = new NewDownloadFrame();
        aboutFrame = new AboutFrame();
        settingFrame = new SettingFrame();
        */

        // create panel


        // create download table
        downloadTable = new DownloadTable();
        queue = new QueueGUI();


        // set main frame default close
        mainFrame.setDefaultCloseOperation(defualtClose());
        mainFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);


        // create frame image icons
        mainFrameImageIcon = new ImageIcon("downloadIcon.png");

        // add images to frames icon
        mainFrame.setIconImage(mainFrameImageIcon.getImage());

        // Menu //

        // create jmenubar
        menus = new JMenuBar();

        // create jmenu
        download = new JMenu("Download");
        help = new JMenu("Help");


        // create jmenuiteme
        newDownloadItem = new JMenuItem("New Download");
        pauseItem = new JMenuItem("Pause");
        resumeItem = new JMenuItem("Resume");
        cancelItem = new JMenuItem("Cancel");
        removeItem = new JMenuItem("Remove");
        replaceItem = new JMenuItem("Replace");
        settingItem = new JMenuItem("Setting");
        exitItem = new JMenuItem("Exit");

        aboutItem = new JMenuItem("About");

        // add menu items to download menu
        download.add(newDownloadItem);
        download.add(pauseItem);
        download.add(resumeItem);
        download.add(cancelItem);
        download.add(removeItem);
        download.add(replaceItem);
        download.add(settingItem);
        download.add(exitItem);

        // add menu items to help menu
        help.add(aboutItem);

        // add menu to menu bar
        menus.add(download);
        menus.add(help);

        // add menus jmenubar to frame
        mainFrame.setJMenuBar(menus);

        // set Mnemonic
        newDownloadItem.setMnemonic('N');
        pauseItem.setMnemonic('P');
        resumeItem.setMnemonic('R');
        cancelItem.setMnemonic('C');
        removeItem.setMnemonic('D');// delete
        replaceItem.setMnemonic('L');
        settingItem.setMnemonic('S');
        exitItem.setMnemonic('E');
        aboutItem.setMnemonic('A');

        // set Accelerator
        newDownloadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        pauseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
        resumeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
        cancelItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        removeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
        replaceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
        settingItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));

        // create panels
        toolBar = new JPanel();
        leftMenu = new JPanel();
        downloads = new JPanel();
        queuePanel = new JPanel();

        // set downloads layout
        downloads.setLayout(new BorderLayout());
        queuePanel.setLayout(new BorderLayout());

        // create tool bar images
        addImage = new ImageIcon("plusIcon.png");
        startImage = new ImageIcon("startIcon.png");
        pauseImage = new ImageIcon("pauseIcon.png");
        deleteImage = new ImageIcon("deleteIcon.png");
        trashImage = new ImageIcon("trashIcon.png");
        repalceImage = new ImageIcon("replaceIcon.png");
        settingImage = new ImageIcon("settingIcon.png");

        // create left menu images
        processingImage = new ImageIcon("processingItem.png");
        completedImage = new ImageIcon("completedIcon.png");
        queuesImage = new ImageIcon("queuesItem.png");

        // create tool bar buttons and add images to them
        addButton = new JButton(addImage);
        resumeButton = new JButton(startImage);
        pauseButton = new JButton(pauseImage);
        cancelButton = new JButton(deleteImage);
        removeButton = new JButton(trashImage);
        replaceButton = new JButton(repalceImage);
        settingButton = new JButton(settingImage);

        // create left menu buttons and add images to them
        processingButton = new JButton("processing", processingImage);
        completedButton = new JButton("completed", completedImage);
        queuesButton = new JButton("queues", queuesImage);

        // set panels color
        toolBar.setBackground(Color.lightGray);
        leftMenu.setBackground(Color.black);
        downloads.setBackground(Color.red);
        queuePanel.setBackground(Color.yellow);

        // add color to tool bar buttons
        addButton.setBackground(Color.gray);
        resumeButton.setBackground(Color.white);
        pauseButton.setBackground(Color.gray);
        cancelButton.setBackground(Color.white);
        removeButton.setBackground(Color.gray);
        replaceButton.setBackground(Color.white);
        settingButton.setBackground(Color.gray);

        // add color to menu bar buttons
        processingButton.setBackground(Color.darkGray);
        completedButton.setBackground(Color.darkGray);
        queuesButton.setBackground(Color.darkGray);

        // set foreground color for left menu buttons
        processingButton.setForeground(Color.white);
        completedButton.setForeground(Color.white);
        queuesButton.setForeground(Color.white);

        // add toolTip to buttons
        addButton.setToolTipText("New Download");
        resumeButton.setToolTipText("Resume");
        pauseButton.setToolTipText("Pause");
        cancelButton.setToolTipText("Cancel");
        removeButton.setToolTipText("Remove");
        replaceButton.setToolTipText("Replace");
        settingButton.setToolTipText("Setting");

        // create main frame
        createWindow(mainFrame, "JDM ( Java Download Manager )", 1000, 600, 500, 200);
        mainFrame.setLayout(new BorderLayout());

        // set tool bar and menu bar layout
        toolBar.setLayout(new FlowLayout());
        leftMenu.setLayout(new GridLayout(8, 1));

        // add buttons to tool bar
        toolBar.add(addButton);
        toolBar.add(resumeButton);
        toolBar.add(pauseButton);
        toolBar.add(cancelButton);
        toolBar.add(removeButton);
        toolBar.add(replaceButton);
        toolBar.add(settingButton);

        // add buttons to left menu
        leftMenu.add(processingButton);
        leftMenu.add(completedButton);
        leftMenu.add(queuesButton);

        // add panels to frame
        mainFrame.add(toolBar, BorderLayout.NORTH);
        mainFrame.add(leftMenu, BorderLayout.WEST);
        mainFrame.add(downloads, BorderLayout.CENTER);


        // add listener to tool bar buttons
        addButton.addActionListener(listener);
        resumeButton.addActionListener(listener);
        pauseButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        removeButton.addActionListener(listener);
        replaceButton.addActionListener(listener);
        settingButton.addActionListener(listener);

        // add listener to left menu  buttons
        processingButton.addActionListener(listener);
        completedButton.addActionListener(listener);
        queuesButton.addActionListener(listener);

        // add listener to menu bar buttons
        newDownloadItem.addActionListener(listener);
        pauseItem.addActionListener(listener);
        resumeItem.addActionListener(listener);
        cancelItem.addActionListener(listener);
        removeItem.addActionListener(listener);
        replaceItem.addActionListener(listener);
        settingItem.addActionListener(listener);
        exitItem.addActionListener(listener);
        aboutItem.addActionListener(listener);


        scrollPane = new JScrollPane(downloadTable.getjPanel());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        queueScrollPane = new JScrollPane(queue.getQueuePanel());
        queueScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    }

    // private class //

    protected class clickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // tool bar and some of menu bar
            if (e.getSource() == addButton || e.getSource() == newDownloadItem) {
                if (newWindowClicks == 0) {
                    newDownloadFrame = new NewDownloadFrame();

                    clickListener clickListener = new clickListener();
                    newDownloadFrame.getOk().addActionListener(clickListener);

                    newWindowClicks++;
                } else {
                    newDownloadFrame.loadNewDownloadWindow();
                }
            }
            if (e.getSource() == resumeButton || e.getSource() == resumeItem) {
                System.out.println("resumeButton");
            }
            if (e.getSource() == pauseButton || e.getSource() == pauseItem) {
                System.out.println("pauseButton");
            }
            if (e.getSource() == cancelButton || e.getSource() == cancelItem) {
                System.out.println("cancelButton");
            }
            if (e.getSource() == removeButton || e.getSource() == removeItem) {
                System.out.println("removeButton");
            }
            if (e.getSource() == replaceButton || e.getSource() == replaceItem) {
                System.out.println("replaceButton");
            }
            if (e.getSource() == settingButton || e.getSource() == settingItem) {
                System.out.println("settingButton");
                if (settingClicks == 0) {
                    settingFrame = new SettingFrame();
                    settingClicks++;
                } else {
                    settingFrame.loadSettingWindow();
                }
            }

            // left menu

            if (e.getSource() == processingButton) {
                System.out.println("processingButton");
            }
            if (e.getSource() == completedButton) {
                System.out.println("completedButton");
            }
            if (e.getSource() == queuesButton) {
                mainFrame.remove(downloads);
                mainFrame.add(queuePanel);
                System.out.println("queuesButton");
            } else {
                mainFrame.remove(queuePanel);
                mainFrame.add(downloads);
            }

            // menu bar

            if (e.getSource() == exitItem) {
                System.out.println("exitItem");
                System.exit(0);
            }
            if (e.getSource() == aboutItem) {
                System.out.println("aboutItem");
                aboutFrame = new AboutFrame();
            }


            if (!(newDownloadFrame == null)) {
                if (e.getSource() == newDownloadFrame.getOk()) {
                    if (!newDownloadFrame.getIsInQueue().isSelected()) {
                        // will executed first
                        System.out.println("aa");
                        scrollPane.remove(downloadTable.getjPanel());
                        downloadTable.addDownload(new DownloadGUI(newDownloadFrame.getDownloadAddress().getText()));
                        downloadTable.addDownloadsToPanel();
                        scrollPane.revalidate();
                        downloads.add(scrollPane);
                    } else {
                        System.out.println("ooo saf");
                        queueScrollPane.remove(queue.getQueuePanel());
                        queue.addDownload(new DownloadGUI(newDownloadFrame.getDownloadAddress().getText()));
                        queue.addDownloadsToPanel();
                        queueScrollPane.revalidate();
                        queuePanel.add(queueScrollPane);
                    }

                }
            }
            if (e.getSource() == menuItem) {
                System.out.println("menuItem");
            }
            if (e.getSource() == trayIcon) {
                mainFrame.setVisible(true);
                System.out.println("trayIcon");
            }

        }
    }


    // Methods //

    // create new download window
    public void createWindow(JFrame jFrame, String title, int width, int height, int x, int y) {
        jFrame.setTitle(title);
        jFrame.setSize(width, height);
        jFrame.setLocation(x, y);
        jFrame.setVisible(true);
    }

    // make the default close on system tray
    public int defualtClose() {
        if (SystemTray.isSupported()) {
            SystemTray systemTray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("trayIcon.png");

            clickListener clickListener = new clickListener();

            PopupMenu popupMenu = new PopupMenu();
            menuItem = new MenuItem("boz");
            menuItem.addActionListener(clickListener);
            popupMenu.add(menuItem);
            trayIcon = new TrayIcon(image, "me", popupMenu);
            trayIcon.addActionListener(clickListener);
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }

        }
        System.out.println("hi");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return 0;
    }


}
