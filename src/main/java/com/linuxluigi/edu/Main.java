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
        View view = new View(660, 550);
        view.setLocationRelativeTo(null);
        Controller controller = new Controller(view);
    }
}
