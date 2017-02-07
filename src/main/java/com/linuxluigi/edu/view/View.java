package com.linuxluigi.edu.view;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by fubu on 03.02.17.
 */
public class View extends JFrame {
    private Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();
    private NodePanel nodePanel;

    JScrollPane jScrollPane;

    private JMenuBar menubar;

    // nodeData = (NodeData) nodeList.get(0);

    public View(int with, int height) {
        this.setTitle("Management Binary Trees");

        this.setSize(with, height);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();

        this.setVisible(true);
    }

    private void createMenuBar() {
        this.menubar = new JMenuBar();

        ImageIcon iconExit = new ImageIcon(this.getClass().getResource("/icomoon-free_2014-12-23_exit_16_0_000000_none.png"));
        ImageIcon iconSave = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_save_16_0_000000_none.png"));
        ImageIcon iconLoad = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_upload_16_0_000000_none.png"));
        ImageIcon iconFile = new ImageIcon(this.getClass().getResource("/icomoon-free_2014-12-23_menu_16_0_000000_none.png"));

        JMenu file = new JMenu("File");
        file.setIcon(iconFile);
        file.setMnemonic(KeyEvent.VK_F);

        // Loading Button
        JMenuItem eMenuItemLoad = new JMenuItem("Load File");
        eMenuItemLoad.setIcon(iconLoad);
        eMenuItemLoad.setMnemonic(KeyEvent.VK_E);
        eMenuItemLoad.setToolTipText("Load a Binary Tree from Disk");

        // Saving Button
        JMenuItem eMenuItemSave = new JMenuItem("Save File");
        eMenuItemSave.setIcon(iconSave);
        eMenuItemSave.setMnemonic(KeyEvent.VK_E);
        eMenuItemSave.setToolTipText("Save a Binary Tree from Disk");

        // Exit Button
        JMenuItem eMenuItemExit = new JMenuItem("Exit");
        eMenuItemExit.setIcon(iconExit);
        eMenuItemExit.setMnemonic(KeyEvent.VK_E);
        eMenuItemExit.setToolTipText("Exit application");

        file.add(eMenuItemLoad);
        file.add(eMenuItemSave);
        file.add(eMenuItemExit);

        this.menubar.add(file);

        setJMenuBar(this.menubar);
    }



    private void updateView() {
        getContentPane().removeAll();
        getContentPane().invalidate();

        this.nodePanel = new NodePanel();
        JPanel jPanel = this.nodePanel.getJPanel(nodeList);

        int x = nodeList.getWith();
        int y = nodeList.getHigh();

        jPanel.setPreferredSize(new Dimension( nodeList.getWith(),nodeList.getHigh()));
        jScrollPane = new JScrollPane(jPanel);
        jPanel.setAutoscrolls(true);
        add(jScrollPane);

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

    public void addMenuLoadListener(ActionListener listenerForMenuLoad){
        menubar.getMenu(0).getItem(0).addActionListener(listenerForMenuLoad);
    }

    public void addMenuSaveListener(ActionListener listenerForMenuSave){
        menubar.getMenu(0).getItem(1).addActionListener(listenerForMenuSave);
    }

    public void addMenuExitListener(ActionListener listenerForMenuExit){
        menubar.getMenu(0).getItem(2).addActionListener(listenerForMenuExit);
    }

}
