package com.linuxluigi.edu;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;
import com.linuxluigi.edu.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fubu on 06.02.17.
 */
public class Controller {
    private Listlabel<NodeData> nodeList;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.nodeList = new BinaryLinkedList<NodeData>();

        this.view.addNodeListener(new NodeListener());

        initDefaultTree();
        view.setBinaryTree(nodeList);
    }

    private void initDefaultTree() {
        this.nodeList.add(new NodeData("A"));
        this.nodeList.add(new NodeData("B"));
        this.nodeList.add(new NodeData("C"));
        this.nodeList.add(new NodeData("D"));
        this.nodeList.add(new NodeData("E"));
        this.nodeList.add(new NodeData("F"));
        this.nodeList.add(new NodeData("G"));
        this.nodeList.add(new NodeData("H"));
        this.nodeList.add(new NodeData("I"));
        this.nodeList.add(new NodeData("J"));
        this.nodeList.add(new NodeData("K"));
        this.nodeList.add(new NodeData("L"));
    }

    void loadBinaryTree(){
        System.out.println("loading");
    }

    void saveBinaryTree(){

    }

    //INNER CLASS

    class NodeListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
            System.out.println("sdabbsjifbsdjf");
        }

    }

}
