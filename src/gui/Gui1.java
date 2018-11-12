package gui;

import data.PlaylistCopyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui1 extends AbstractGui {

    public Gui1() {
        JPanel all = new JPanel(new GridLayout(0, 1));
        all.setPreferredSize(new Dimension(650, 300));

        infoLabel = new JLabel();
        infoLabel.setText("Welcome to the Playlist-Copy Program.");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        // Add Playlist File Opener Elements
        JPanel playlistOpenerPanel = new JPanel();
        playlistOpenerButton = new JButton("Select Playlist File");
        playlistOpenerText = new JTextArea("No File Selected");
        playlistOpenerButton.addActionListener(this);
        playlistOpenerPanel.setLayout(new GridLayout(1, 0));
        playlistOpenerPanel.add(playlistOpenerButton);
        playlistOpenerPanel.add(playlistOpenerText);

        // Add Copy Dir Chooser Elements
        JPanel dirChooserPanel = new JPanel();
        dirChooserButton = new JButton("Choose Copy Directory");
        dirChooserText = new JTextArea("No Directory Selected!");
        dirChooserButton.addActionListener(this);
        dirChooserPanel.setLayout(new GridLayout(1, 0));
        dirChooserPanel.add(dirChooserButton);
        dirChooserPanel.add(dirChooserText);

        // Add Copy Button
        JPanel copyButtonPanel = new JPanel();
        copyButtonPanel.setLayout(new GridLayout(1, 0));
        copyButton = new JButton("Start Copy!");
        copyText = new JTextArea("");
        copyButton.addActionListener(this);
        copyButtonPanel.add(copyButton);
        copyButtonPanel.add(copyText);

        // Add all components
        all.add(new JLabel("1. Select Playlist file"));
        all.add(playlistOpenerPanel);
        all.add(new JLabel("2. Select destination directory"));
        all.add(dirChooserPanel);
        all.add(new JLabel("3. Press Copy"));
        all.add(copyButtonPanel);
        all.add(infoLabel);

        this.getContentPane().add(all);
        this.pack();

        this.setTitle("PlaylistCopy");

        this.setVisible(true);

        // init other components
        controller = PlaylistCopyController.getInstance(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == copyButton) {
            controller.startCopying();
        }
        else if (e.getSource() == dirChooserButton) {
            controller.chooseTargetDir();
        }
        else if (e.getSource() == playlistOpenerButton) {
            controller.choosePlaylistFile();
        }
    }

}
