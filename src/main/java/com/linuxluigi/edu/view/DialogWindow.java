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
 * Dialog Fenster welches erscheint nachdem ein Knoten gedrückt worden ist.
 * Welches folgenede Optionen liefert.
 * <ul>
 *     <li>Knoten hinzufügen</li>
 *     <li>Knoten ändern</li>
 *     <li>Knoten löschen</li>
 * </ul>
 */
public class DialogWindow extends JFrame {
    private int nodeId;

    private JTextPane jTextPane;
    private JButton renameButton = new JButton("RENAME");
    private JButton addButton = new JButton("ADD");
    private JButton removeButton = new JButton("REMOVE");

    public DialogWindow(int nodeId, String nodeContent) {
        this.nodeId = nodeId;

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

    /**
     * Button Knoten ändern
     * @param listenerForRenameButton   ActionListener
     */
    public void addRenameListener(ActionListener listenerForRenameButton) {
        this.renameButton.addActionListener(listenerForRenameButton);
    }

    /**
     * Button Knoten hinzufügen
     * @param listenerForAddButton   ActionListener
     */
    public void addAddListener(ActionListener listenerForAddButton) {
        this.addButton.addActionListener(listenerForAddButton);
    }

    /**
     * Button Knoten löschen
     * @param listenerForRemoveButton   ActionListener
     */
    public void addRemoveListener(ActionListener listenerForRemoveButton) {
        this.removeButton.addActionListener(listenerForRemoveButton);
    }

    /**
     * Gibt das Textfeld des DialogWindows zurück
     * @return  Textfeld des Dialogfenster als String
     */
    public String getText() {
        return this.jTextPane.getText();
    }

    /**
     * Gibt die Knoten ID des DialogWindow zurück
     * @return  Knoten ID
     */
    public int getNodeId() {
        return this.nodeId;
    }
}
