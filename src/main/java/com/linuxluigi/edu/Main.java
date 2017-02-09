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

import com.linuxluigi.edu.view.View;


/**
 * Main Klasse zum starten des Programmes.
 * Es wird eine erste View angelegt und dem Controller übergeben.
 * Die View wird mit eine passende Größe für den ersten automatisch generierten Binär Baum erstellt.
 */
public class Main {

    /**
     * Main Methode
     * @param args
     */
    public static void main(String[] args) {
        // default with & height for the first view
        final int defaultWith = 660;
        final int defaultHeight = 550;

        // create a view and the controller
        View view = new View(defaultWith, defaultHeight);
        view.setLocationRelativeTo(null);
        Controller controller = new Controller(view);
    }
}
