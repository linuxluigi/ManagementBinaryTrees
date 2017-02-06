package com.linuxluigi.edu.view;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by fubu on 03.02.17.
 */
public class View extends JFrame {
    Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();
    NodePanel nodePanel = new NodePanel();
    // nodeData = (NodeData) nodeList.get(0);

    public View() {
        this.setTitle("Management Binary Trees");

        this.setSize(350, 250);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();

        this.add(nodePanel.getJPanel(nodeList));
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



    private void updateView() {
        getContentPane().removeAll();
        getContentPane().invalidate();
        getContentPane().add(nodePanel.getJPanel(nodeList));
        validate();
        repaint();
    }

    public void setBinaryTree(Listlabel<NodeData> nodeList) {
        this.nodeList = nodeList;
        updateView();
    }

    public void addNodeListener(ActionListener listenerForNodeButton){
        nodePanel.addNodeListener(listenerForNodeButton);
    }

}
