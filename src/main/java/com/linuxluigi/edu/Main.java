package com.linuxluigi.edu;

import com.linuxluigi.edu.view.View;


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
