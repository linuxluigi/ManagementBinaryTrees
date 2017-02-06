package com.linuxluigi.edu.view;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fubu on 05.02.17.
 */
public class NodePanel {

    private JPanel jPanel = new JPanel();
    private Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();
    private JButton[] jButtons;

    public JPanel getJPanel(Listlabel<NodeData> nodeList) {
        this.nodeList = nodeList;
        update();
        return jPanel;
    }

    private void update() {
        jPanel.removeAll();
        jButtons = new JButton[nodeList.size()];

        //ListenForButton listenForButton = new ListenForButton();

        for (int i = 0; i < nodeList.size(); i++) {
            NodeData nodeData = nodeList.get(i);
            this.jButtons[i] = new JButton(nodeData.getContent());
            this.jPanel.add(this.jButtons[i]);
            //this.jButtons[i].addActionListener(listenForButton);
        }
    }

    public void addNodeListener(ActionListener listenerForNodeButton){
        for (int i = 0; i < nodeList.size(); i++) {
            jButtons[i].addActionListener(listenerForNodeButton);
        }
    }

    private class ListenForButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < nodeList.size(); i++) {
                if (e.getSource() == jButtons[i]) {
                    System.out.println(i);
                }
            }
        }
    }
}
