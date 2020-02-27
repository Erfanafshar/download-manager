package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QueueGUI {

    // fields //

    private ArrayList<DownloadGUI> queue;

    private JPanel queuePanel;
    private JScrollPane scrollPane;

    // constructor //


    public QueueGUI() {

        queue = new ArrayList<>();
        queuePanel = new JPanel();
        queuePanel.setLayout(new GridLayout(10, 1));
        addDownloadsToPanel();
        queuePanel.setPreferredSize(new Dimension(300, 1000));
        scrollPane = new JScrollPane(queuePanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    }

    // method //

    public void addDownload(DownloadGUI downloadGUI) {
        queue.add(downloadGUI);
    }


    public ArrayList<DownloadGUI> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<DownloadGUI> queue) {
        this.queue = queue;
    }

    // add downloads to j panel
    public void addDownloadsToPanel() {
        for (int i = 0; i < queue.size(); i++) {
            queuePanel.add(queue.get(i).getDownloadPanel());
        }
    }

    public JPanel getQueuePanel() {
        return queuePanel;
    }

    public void setQueuePanel(JPanel queuePanel) {
        this.queuePanel = queuePanel;
    }
}
