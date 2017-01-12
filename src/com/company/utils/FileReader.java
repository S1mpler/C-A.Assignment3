package com.company.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by S1mpler on 1/6/2017.
 */
public class FileReader {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private String fileName;
    private List<String> lines;

    /**
     * Constructor
     * @param fileName Name of the file
     */
    public FileReader(String fileName) {
        this.fileName = fileName;
        this.lines = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public List<String> getLines() {
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String line = "";

        do {
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lines.add(line);
        } while (line != null);

        //Close the input stream
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.lines;
    }
}
