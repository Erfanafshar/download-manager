package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DownloadTable {

    // fields //

    private ArrayList<DownloadGUI> downloads;
    private JScrollPane scrollPane;

    private JPanel jPanel;

    // constructor //

    public DownloadTable() {

        jPanel = new JPanel();
        downloads = new ArrayList<>();
        jPanel.setLayout(new GridLayout(10, 1));
        addDownloadsToPanel();
        jPanel.setPreferredSize(new Dimension(300, 1000));
        scrollPane = new JScrollPane(jPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    }

    // method //

    public void addDownload(DownloadGUI downloadGUI) {
        downloads.add(downloadGUI);
    }

    public void addQueue(QueueGUI queue) {
        for (int i = 0; i < queue.getQueue().size(); i++) {
            downloads.add(queue.getQueue().get(i));
        }
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }


    // add downloads to j panel
    public void addDownloadsToPanel() {
        for (int i = 0; i < downloads.size(); i++) {
            jPanel.add(downloads.get(i).getDownloadPanel());
        }
    }

}
