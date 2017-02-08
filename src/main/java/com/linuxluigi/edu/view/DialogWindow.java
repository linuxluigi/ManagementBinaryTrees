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
