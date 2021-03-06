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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Lädt eine Json Datei und wandelt den Inhalt in ein Binärbaum um
 */
public class Load {
    private File file;
    private String[][] BinaryListArray;

    /**
     * Lädt eine Json Datei und wandelt den Inhalt in ein Binärbaum um
     * @param file Datei die geladen werden soll
     */
    public Load(File file) {
        this.file = file;

        try {
            if (!this.file.exists()) {
                this.file.createNewFile();
            }

            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);

            String row;
            String content = "";

            while ((row = br.readLine()) != null) {
                content = content + row;
            }
            br.close();

            Gson gson = new GsonBuilder().create();
            BinaryListArray = gson.fromJson(content, String[][].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] getBinaryListArray() {
        return BinaryListArray;
    }
}
