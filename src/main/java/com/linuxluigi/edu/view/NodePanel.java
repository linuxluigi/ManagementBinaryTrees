package com.linuxluigi.edu.view;

import com.linuxluigi.edu.data.DrawnLines;
import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.data.ViewPosition;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

/**
 * Created by fubu on 05.02.17.
 */
public class NodePanel extends JPanel {

    //private JPanel jPanel;
    private Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();
    public JButton[] jButtons;
    public JLabel[] jLabels;
    private ImageIcon nodeIcon = new ImageIcon(this.getClass().getResource("/Node.png"));

    public NodePanel() {
        //this.jPanel = new JPanel();
        this.setLayout(null);
    }

    public JPanel getJPanel(Listlabel<NodeData> nodeList) {
        this.nodeList = nodeList;
        update();
        return this;
    }

    private void addButton(int id) {
        NodeData nodeData = nodeList.get(id);

        ViewPosition viewPosition = nodeList.getViewPosition(id);

        this.jButtons[id] = new JButton(nodeData.getContent());

        // icon
        this.jButtons[id].setIcon(nodeIcon);

        // boarder & background
        this.jButtons[id].setBorderPainted(false);
        this.jButtons[id].setContentAreaFilled(false);

        // set text font
        this.jButtons[id].setVerticalTextPosition(SwingConstants.CENTER);
        this.jButtons[id].setHorizontalTextPosition(SwingConstants.CENTER);
        this.jButtons[id].setFont(new Font("Arial", Font.BOLD, 20));
        this.jButtons[id].setForeground(Color.BLACK);

        // set location
        this.jButtons[id].setBounds(viewPosition.getX(), viewPosition.getY(), viewPosition.getIconSize(), viewPosition.getIconSize()); // ( x, y, with, high)

        // set id as button name
        this.jButtons[id].setName(Integer.toString(id));


        // add ID Label

        // set ID as Text
        this.jLabels[id] = new JLabel(Integer.toString(id));

        // set location
        int labelWith = viewPosition.getX() + 69;
        int labelHigh = viewPosition.getY() + 2;
        this.jLabels[id].setAlignmentX(Component.CENTER_ALIGNMENT);
        this.jLabels[id].setAlignmentY(Component.CENTER_ALIGNMENT);
        this.jLabels[id].setBounds(labelWith, labelHigh, 10, 10);

        // set text font
        this.jLabels[id].setFont(new Font("Arial", Font.PLAIN, 8));
        this.jLabels[id].setForeground(Color.BLACK);

        // add label && button to panel
        this.add(this.jLabels[id]);
        this.add(this.jButtons[id]);
    }

    private void update() {
        this.removeAll();
        this.jButtons = new JButton[nodeList.getSize()];

        this.jLabels = new JLabel[nodeList.getSize()];

        for (int i = 0; i < nodeList.getSize(); i++) {
            addButton(i);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));

        for (int i = 0; i < this.nodeList.getDrawnLines().getSize(); i++) {

            DrawnLines tempLine = this.nodeList.getDrawnLines().get(i);
            g2.draw(new Line2D.Float(tempLine.getX1(), tempLine.getY1(), tempLine.getX2(), tempLine.getY2()));

        }
    }

    ;

    public void addNodeListener(ActionListener listenerForNodeButton) {
        for (int i = 0; i < nodeList.getSize(); i++) {
            this.jButtons[i].addActionListener(listenerForNodeButton);
        }
    }
}
