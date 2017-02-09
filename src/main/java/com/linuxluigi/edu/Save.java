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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.list.Listlabel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Speichert den Binärbaum in eine Json Datei
 */
public class Save {
    private File file;
    private Listlabel<NodeData> nodeList;

    /**
     * Speichert den Binärbaum in eine Json Datei
     * Dabei wird der Binärbaum in 2 Dimensionalen String Array konvertiert,
     * um speicherplatz effektiv zu sichern.
     *
     * @param file     zu speichernde Json Datei
     * @param nodeList den zu Speicherenden Binärbaum
     */
    public Save(File file, Listlabel<NodeData> nodeList) {
        this.file = file;

        Gson gson = new GsonBuilder().create();

        String content = gson.toJson(nodeList.getBinaryList());

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
