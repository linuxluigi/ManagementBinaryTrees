/*
 * Copyright 2017 Stefen Exler
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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

    public View(int with, int height) {
        this.setTitle("Management Binary Trees");

        this.setSize(with, height);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();

        this.setVisible(true);
    }

    private void createMenuBar() {
        this.menubar = new JMenuBar();

        ImageIcon iconFile = new ImageIcon(this.getClass().getResource("/icomoon-free_2014-12-23_menu_16_0_000000_none.png"));
        ImageIcon iconNew = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_file-o_16_0_000000_none.png"));
        ImageIcon iconSave = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_save_16_0_000000_none.png"));
        ImageIcon iconLoad = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_upload_16_0_000000_none.png"));
        ImageIcon iconSortAcs = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_sort-amount-asc_16_0_000000_none.png"));
        ImageIcon iconSortDesc = new ImageIcon(this.getClass().getResource("/font-awesome_4-7-0_sort-amount-desc_16_0_000000_none.png"));
        ImageIcon iconExit = new ImageIcon(this.getClass().getResource("/icomoon-free_2014-12-23_exit_16_0_000000_none.png"));

        JMenu file = new JMenu("File");
        file.setIcon(iconFile);
        file.setMnemonic(KeyEvent.VK_F);

        // New Tree Button
        JMenuItem eMenuItemNew = new JMenuItem("New Tree");
        eMenuItemNew.setIcon(iconNew);
        eMenuItemNew.setMnemonic(KeyEvent.VK_E);
        eMenuItemNew.setToolTipText("Create a new Binary Tree");

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

        // Sort Acs Button
        JMenuItem eMenuSortAcs = new JMenuItem("Sort ACS");
        eMenuSortAcs.setIcon(iconSortAcs);
        eMenuSortAcs.setMnemonic(KeyEvent.VK_E);
        eMenuSortAcs.setToolTipText("Sort Binary Tree ACS");

        // Sort Desc Button
        JMenuItem eMenuSortDesc = new JMenuItem("Sort DECS");
        eMenuSortDesc.setIcon(iconSortDesc);
        eMenuSortDesc.setMnemonic(KeyEvent.VK_E);
        eMenuSortDesc.setToolTipText("Sort Binary Tree DECS");

        // Exit Button
        JMenuItem eMenuItemExit = new JMenuItem("Exit");
        eMenuItemExit.setIcon(iconExit);
        eMenuItemExit.setMnemonic(KeyEvent.VK_E);
        eMenuItemExit.setToolTipText("Exit application");

        // add buttons
        file.add(eMenuItemNew);
        file.add(eMenuItemLoad);
        file.add(eMenuItemSave);
        file.add(eMenuSortAcs);
        file.add(eMenuSortDesc);
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

        jPanel.setPreferredSize(new Dimension(nodeList.getWith(), nodeList.getHigh()));
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

    public void addNodeListener(ActionListener listenerForNodeButton) {
        nodePanel.addNodeListener(listenerForNodeButton);
    }

    public void addMenuNewListener(ActionListener listenerForMenuNew) {
        menubar.getMenu(0).getItem(0).addActionListener(listenerForMenuNew);
    }

    public void addMenuLoadListener(ActionListener listenerForMenuLoad) {
        menubar.getMenu(0).getItem(1).addActionListener(listenerForMenuLoad);
    }

    public void addMenuSaveListener(ActionListener listenerForMenuSave) {
        menubar.getMenu(0).getItem(2).addActionListener(listenerForMenuSave);
    }

    public void addSortAcsListener(ActionListener listenerForMenuSave) {
        menubar.getMenu(0).getItem(3).addActionListener(listenerForMenuSave);
    }

    public void addSortDecsListener(ActionListener listenerForMenuSave) {
        menubar.getMenu(0).getItem(4).addActionListener(listenerForMenuSave);
    }

    public void addMenuExitListener(ActionListener listenerForMenuExit) {
        menubar.getMenu(0).getItem(5).addActionListener(listenerForMenuExit);
    }

}
