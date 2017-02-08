package com.linuxluigi.edu.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;

/**
 * Created by fubu on 08.02.17.
 */
public class Load {
    private File file;
    private String[][] BinaryListArray;

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
