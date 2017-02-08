package com.linuxluigi.edu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by fubu on 08.02.17.
 */
public class DialogWindow extends JFrame {
    private int nodeId;
    private String nodeContent;

    private JTextPane jTextPane;
    private JButton renameButton = new JButton("RENAME");
    private JButton addButton = new JButton("ADD");
    private JButton removeButton = new JButton("REMOVE");

    public DialogWindow(int nodeId, String nodeContent) {
        this.nodeId = nodeId;
        this.nodeContent = nodeContent;

        this.setTitle(Integer.toString(nodeId) + ": " + nodeContent);

        this.setSize(400, 100);

        this.setLayout(new FlowLayout());

        this.jTextPane = new JTextPane();
        this.jTextPane.setText(nodeContent);
        add(this.jTextPane);

        add(this.renameButton);
        add(this.addButton);
        add(this.removeButton);

        this.setVisible(true);
    }

    public void addRenameListener(ActionListener listenerForRenameButton) {
        this.renameButton.addActionListener(listenerForRenameButton);
    }

    public void addAddListener(ActionListener listenerForAddButton) {
        this.addButton.addActionListener(listenerForAddButton);
    }

    public void addRemoveListener(ActionListener listenerForRemoveButton) {
        this.removeButton.addActionListener(listenerForRemoveButton);
    }

    public String getText() {
        return this.jTextPane.getText();
    }

    public int getNodeId() {
        return this.nodeId;
    }
}
