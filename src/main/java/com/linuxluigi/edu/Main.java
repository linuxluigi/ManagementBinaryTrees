package com.linuxluigi.edu;

import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.BinaryLinkedList;
import com.linuxluigi.edu.list.Listlabel;
import com.linuxluigi.edu.view.View;

import java.io.IOException;


/**
 * Created by fubu on 01.02.17.
 */
public class Main {

    public static void main(String[] args) {
        Listlabel<NodeData> list = new BinaryLinkedList<NodeData>();

        System.out.println("Is Empty: " + list.isEmpty());

        list.add(new NodeData("0"));
        list.add(new NodeData("1"));
        list.add(new NodeData("2"));
        list.add(new NodeData("3"));
        list.add(new NodeData("4"));
        list.add(new NodeData("5"));
        list.add(new NodeData("6"));
        list.add(new NodeData("7"));
        list.add(new NodeData("8"));
        list.add(new NodeData("9"));
        list.add(new NodeData("10"));
        list.add(new NodeData("11"));

        System.out.println("Is Empty: " + list.isEmpty());

        NodeData ID4 = list.get(4);

        list.set(4, new NodeData("888"));

        list.add(4, new NodeData("lef"));
        list.add(4, new NodeData("rig"));

        NodeData newID4 = list.get(4);

        //list.remove(4);

        System.out.println("asdasd");




        View view = new View();

    }
}
