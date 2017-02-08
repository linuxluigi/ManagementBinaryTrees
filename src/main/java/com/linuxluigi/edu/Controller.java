package com.linuxluigi.edu;

import com.linuxluigi.edu.data.Load;
import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;
import com.linuxluigi.edu.list.OrderBy;
import com.linuxluigi.edu.view.View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by fubu on 06.02.17.
 */
public class Controller {
    private Listlabel<NodeData> nodeList;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.nodeList = new BinaryLinkedList<NodeData>();

        initDefaultTree();
        view.setBinaryTree(nodeList);

        this.view.addNodeListener(new NodeListener());
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
        this.nodeList.add(new NodeData("I"));
        this.nodeList.add(new NodeData("J"));
        this.nodeList.add(new NodeData("K"));
        this.nodeList.add(new NodeData("L"));
        this.nodeList.add(new NodeData("AA"));
        this.nodeList.sort(OrderBy.DESC);
    }

    void loadBinaryTree(){
        System.out.println("loading");
    }

    void saveBinaryTree(){

    }

    void updateView(){
        int sizeWith = view.getSize().width;
        int sizeHeight = view.getSize().height;
        int locationX = view.getX();
        int locationY = view.getY();

        view.setVisible(false);

        view = new View(sizeWith, sizeHeight);
        view.setLocation(locationX, locationY);

        view.setBinaryTree(nodeList);

        view.addNodeListener(new NodeListener());
        view.addMenuLoadListener(new MenuLoadListener());
        view.addMenuSaveListener(new MenuSaveListener());
        this.view.addSortAcsListener(new MenuSortAcsListener());
        this.view.addSortDecsListener(new MenuSortDecsListener());
        view.addMenuExitListener(new MenuExitListener());
    }

    //INNER CLASS

    class NodeListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            JButton jButton = (JButton) arg0.getSource();
            System.out.println(jButton.getName());
            nodeList.add(new NodeData("L"));
            nodeList.add(new NodeData("L"));
            nodeList.add(new NodeData("L"));

            updateView();
        }
    }

    class MenuLoadListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
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
        public void actionPerformed(ActionEvent arg0){

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
        public void actionPerformed(ActionEvent arg0){
            nodeList.sort(OrderBy.ASC);
            updateView();
        }
    }

    class MenuSortDecsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            nodeList.sort(OrderBy.DESC);
            updateView();
        }
    }

    class MenuExitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            System.exit(0);
        }
    }

}
