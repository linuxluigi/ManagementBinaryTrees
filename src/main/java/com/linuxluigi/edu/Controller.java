/*
 * Copyright 2017 Stefen Exler
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.linuxluigi.edu;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;
import com.linuxluigi.edu.list.OrderBy;
import com.linuxluigi.edu.view.DialogWindow;
import com.linuxluigi.edu.view.View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Der Controller der für die Steuerung der Software verantworlicch ist
 * Enthalten sind:
 * <ul>
 * <li>Verwaltung der View</li>
 * <li>Verwaltung des Dialog Fenster zum ändern, hinzufügen und löschen eines Knoten</li>
 * <li>Verwalten des Binärbaumes</li>
 * <li>Action Listener</li>
 * </ul>
 */
public class Controller {
    private Listlabel<NodeData> nodeList;
    private View view;

    private DialogWindow dialogWindow;

    /**
     * Konstruktor des Controllers
     * <ul>
     * <li>1. Erstellt ein Demo Binärbaum</li>
     * <li>2. Übergibt die Binärbaum informationen der View</li>
     * <li>3. Fügt die Actionen Listener für jeden Button hinzu</li>
     * </ul>
     *
     * @param view Die View für das haupt Fenster
     */
    public Controller(View view) {
        this.view = view;
        this.nodeList = new BinaryLinkedList<NodeData>();

        initDefaultTree();
        view.setBinaryTree(nodeList);

        addActionListener();
    }

    /**
     * Fügt der view alle Button Actionlistener hinzu
     */
    private void addActionListener() {
        this.view.addNodeListener(new NodeListener());
        this.view.addMenuNewListener(new MenuNewListener());
        this.view.addMenuLoadListener(new MenuLoadListener());
        this.view.addMenuSaveListener(new MenuSaveListener());
        this.view.addSortAcsListener(new MenuSortAcsListener());
        this.view.addSortDecsListener(new MenuSortDecsListener());
        this.view.addMenuExitListener(new MenuExitListener());
    }

    /**
     * Erstellt ein Demo Binärbaum, der anschließend nach DESC sortiert wird
     */
    private void initDefaultTree() {
        this.nodeList.add(new NodeData("A"));
        this.nodeList.add(new NodeData("K"));
        this.nodeList.add(new NodeData("G22"));
        this.nodeList.add(new NodeData("C"));
        this.nodeList.add(new NodeData("D"));
        this.nodeList.add(new NodeData("G"));
        this.nodeList.add(new NodeData("F"));
        this.nodeList.add(new NodeData("G"));
        this.nodeList.add(new NodeData("K"));
        this.nodeList.add(new NodeData("I33"));
        this.nodeList.add(new NodeData("J"));
        this.nodeList.add(new NodeData("K"));
        this.nodeList.add(new NodeData("L"));
        this.nodeList.add(new NodeData("AA"));
        this.nodeList.sort(OrderBy.DESC);
    }

    /**
     * Führt ein update der View aus
     * <ul>
     * <li>1. Binärbaum der View übergeben</li>
     * <li>2. Actionlistener einfügen</li>
     * </ul>
     */
    void updateView() {
        this.view.setBinaryTree(nodeList);

        addActionListener();
    }

    /**
     * Führt ein update der View in ein neues Fenster aus und schließt das vorherige
     * <ul>
     *     <li>1. Position der alten View sichern</li>
     *     <li>2. Alte View unsichbar schalten</li>
     *     <li>3. Neue View an gleicher Stelle und gleicher Dimension der alten View erstellen</li>
     *     <li>4. Binärbaum der View übergeben</li>
     *     <li>5. Actionlistener einfügen</li>
     * </ul>
     */
    void updateViewInNewWindow() {
        int sizeWith = view.getSize().width;
        int sizeHeight = view.getSize().height;
        int locationX = view.getX();
        int locationY = view.getY();

        this.view.setVisible(false);

        this.view = new View(sizeWith, sizeHeight);
        this.view.setLocation(locationX, locationY);

        updateView();
    }


    //INNER CLASS - Action Listener

    /**
     * Actionelistener für alle Binärbaum Knoten
     */
    class NodeListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            JButton jButton = (JButton) arg0.getSource();

            int nodeId = Integer.parseInt(jButton.getName());

            NodeData nodeData = nodeList.get(nodeId);

            dialogWindow = new DialogWindow(nodeId, nodeData.getContent());

            // add action listener for dialog
            dialogWindow.addRenameListener(new DialogRenameListener());
            dialogWindow.addAddListener(new DialogAddListener());
            dialogWindow.addRemoveListener(new DialogRemoveListener());
        }
    }

    /**
     * Actionelistener für Menü Button: neuen Baum anlegen
     */
    class MenuNewListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.clearAll();
            nodeList.add(new NodeData("AAA"));

            updateView();
        }
    }

    /**
     * Actionelistener für Menü Button: Binärbaum aus Json Datei laden
     */
    class MenuLoadListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            JFileChooser chooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Json", "json", "JSON");
            chooser.setFileFilter(filter);

            chooser.setSelectedFile(new File("~/BinaryTree.json"));

            int chooseFile = chooser.showOpenDialog(null);

            if (chooseFile == JFileChooser.APPROVE_OPTION) {
                Load load = new Load(chooser.getSelectedFile());
                nodeList.setBinaryTreeFromList(load.getBinaryListArray());
            }

            updateViewInNewWindow();
        }
    }

    /**
     * Actionelistener für Menü Button: Binärbaum in Json Datei speicher
     */
    class MenuSaveListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            JFileChooser chooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Json", "json", "JSON");
            chooser.setFileFilter(filter);

            chooser.setSelectedFile(new File("~/BinaryTree.json"));

            int chooseFile = chooser.showSaveDialog(null);

            if (chooseFile == JFileChooser.APPROVE_OPTION) {
                Save save = new Save(chooser.getSelectedFile(), nodeList);
            }

            updateView();

        }
    }

    /**
     * Actionelistener für Menü Button: Binärbaum nach ACS sortieren
     */
    class MenuSortAcsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.sort(OrderBy.ASC);
            updateView();
        }
    }

    /**
     * Actionelistener für Menü Button: Binärbaum nach DECS sortieren
     */
    class MenuSortDecsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.sort(OrderBy.DESC);
            updateView();
        }
    }

    /**
     * Actionelistener für Menü Button: Exit
     */
    class MenuExitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
        }
    }

    /**
     * Actionelistener für Dialog Window:
     * <ul>
     * <li>ändern eines vorhandenen Knoten</li>
     * </ul>
     */
    class DialogRenameListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            NodeData nodeData = new NodeData(dialogWindow.getText());

            nodeList.set(dialogWindow.getNodeId(), nodeData);

            dialogWindow.setVisible(false);
            updateView();
        }
    }

    /**
     * Actionelistener für Dialog Window:
     * <ul>
     * <li>Hinzufügen von neuen Knoten</li>
     * </ul>
     */
    class DialogAddListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.add(dialogWindow.getNodeId(), new NodeData(dialogWindow.getText()));

            dialogWindow.setVisible(false);

            updateView();
        }
    }

    /**
     * Actionelistener für Dialog Window:
     * <ul>
     * <li>löschen eines Knotens</li>
     * </ul>
     */
    class DialogRemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.remove(dialogWindow.getNodeId());

            dialogWindow.setVisible(false);

            updateView();
        }
    }

}
