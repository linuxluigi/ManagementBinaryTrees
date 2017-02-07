package com.linuxluigi.edu;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;
import com.linuxluigi.edu.list.OrderBy;
import com.linuxluigi.edu.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
            System.out.println("Loading++");
        }
    }

    class MenuSaveListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            System.out.println("Saving++");
        }
    }

    class MenuExitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            System.exit(0);
        }
    }

}
