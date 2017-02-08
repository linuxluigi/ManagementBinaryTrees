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
 * Created by fubu on 07.02.17.
 */
public class Save {
    private File file;
    private Listlabel<NodeData> nodeList;

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
