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

import com.linuxluigi.edu.data.Load;
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
 * Created by fubu on 06.02.17.
 */
public class Controller {
    private Listlabel<NodeData> nodeList;
    private View view;

    private DialogWindow dialogWindow;

    public Controller(View view) {
        this.view = view;
        this.nodeList = new BinaryLinkedList<NodeData>();

        initDefaultTree();
        view.setBinaryTree(nodeList);

        this.view.addNodeListener(new NodeListener());
        this.view.addMenuNewListener(new MenuNewListener());
        this.view.addMenuLoadListener(new MenuLoadListener());
        this.view.addMenuSaveListener(new MenuSaveListener());
        this.view.addSortAcsListener(new MenuSortAcsListener());
        this.view.addSortDecsListener(new MenuSortDecsListener());
        this.view.addMenuExitListener(new MenuExitListener());
    }

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

    void updateView() {
        int sizeWith = view.getSize().width;
        int sizeHeight = view.getSize().height;
        int locationX = view.getX();
        int locationY = view.getY();

        this.view.setVisible(false);

        this.view = new View(sizeWith, sizeHeight);
        this.view.setLocation(locationX, locationY);

        this.view.setBinaryTree(nodeList);

        this.view.addNodeListener(new NodeListener());
        this.view.addMenuNewListener(new MenuNewListener());
        this.view.addMenuLoadListener(new MenuLoadListener());
        this.view.addMenuSaveListener(new MenuSaveListener());
        this.view.addSortAcsListener(new MenuSortAcsListener());
        this.view.addSortDecsListener(new MenuSortDecsListener());
        this.view.addMenuExitListener(new MenuExitListener());
    }

    //INNER CLASS

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

    class MenuNewListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.clearAll();
            nodeList.add(new NodeData("WWW"));

            updateView();
        }
    }

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

            updateView();
        }
    }

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

        }
    }

    class MenuSortAcsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.sort(OrderBy.ASC);
            updateView();
        }
    }

    class MenuSortDecsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.sort(OrderBy.DESC);
            updateView();
        }
    }

    class MenuExitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
        }
    }

    // Dialog Window
    class DialogRenameListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            NodeData nodeData = new NodeData(dialogWindow.getText());

            nodeList.set(dialogWindow.getNodeId(), nodeData);

            dialogWindow.setVisible(false);
            updateView();
        }
    }

    class DialogAddListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.add(dialogWindow.getNodeId(), new NodeData(dialogWindow.getText()));

            dialogWindow.setVisible(false);

            updateView();
        }
    }

    // Dialog Window
    class DialogRemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            nodeList.remove(dialogWindow.getNodeId());

            dialogWindow.setVisible(false);

            updateView();
        }
    }

}
