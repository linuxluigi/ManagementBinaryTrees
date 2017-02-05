package com.linuxluigi.edu.view;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by fubu on 03.02.17.
 */
public class View extends JFrame {

    // creating a panel
    JPanel jPanel = new JPanel();

    JButton button1;

    public View() {
        this.setTitle("Management Binary Trees");

        this.setSize(350, 250);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // creating a panel
        this.jPanel = new JPanel();

        // label
        JLabel label1 = new JLabel("Something intristing");
        this.jPanel.add(label1);

        // button
        this.button1 = new JButton("send");
        //button1.setBorderPainted(false);
        //button1.setContentAreaFilled(false);

        ListenForButton listenForButton = new ListenForButton();
        this.button1.addActionListener(listenForButton);

        this.jPanel.add(this.button1);

        createMenuBar();

        this.add(jPanel);
        this.setVisible(true);

    }

    private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();

        ImageIcon iconExit = new ImageIcon(this.getClass().getResource("/icomoon-free_2014-12-23_exit_16_0_000000_none.png"));
        ImageIcon iconSave = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_save_16_0_000000_none.png"));
        ImageIcon iconLoad = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_upload_16_0_000000_none.png"));
        ImageIcon iconFile = new ImageIcon(this.getClass().getResource("/icomoon-free_2014-12-23_menu_16_0_000000_none.png"));

        JMenu file = new JMenu("File");
        file.setIcon(iconFile);
        file.setMnemonic(KeyEvent.VK_F);

        // Loading Button
        JMenuItem eMenuItemLoad = new JMenuItem(new AbstractAction("Load File") {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Load File");
            }
        });
        eMenuItemLoad.setIcon(iconLoad);
        eMenuItemLoad.setMnemonic(KeyEvent.VK_E);
        eMenuItemLoad.setToolTipText("Load a Binary Tree from Disk");

        // Saving Button
        JMenuItem eMenuItemSave = new JMenuItem(new AbstractAction("Save File") {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save File");
            }
        });
        eMenuItemSave.setIcon(iconSave);
        eMenuItemSave.setMnemonic(KeyEvent.VK_E);
        eMenuItemSave.setToolTipText("Save a Binary Tree from Disk");

        // Exit Button
        JMenuItem eMenuItemExit = new JMenuItem(new AbstractAction("Exit") {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        eMenuItemExit.setIcon(iconExit);
        eMenuItemExit.setMnemonic(KeyEvent.VK_E);
        eMenuItemExit.setToolTipText("Exit application");

        file.add(eMenuItemLoad);
        file.add(eMenuItemSave);
        file.add(eMenuItemExit);

        menubar.add(file);

        setJMenuBar(menubar);
    }

    // Implement Listeners

    private class ListenForButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button1) {
                int x = (int) button1.getLocation().getX();
                x = x + 50;
                int y = (int) button1.getLocation().getY();
                y = y + 50;
                button1.setLocation(x, y);
            }

        }
    }
}
