package com.koala.apitesting.utilities;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class BuenoFileUtilities {

    public static Map<String, String> getBuenoFileContent (String fileName) {
        Map<String, String> data = new HashMap<String, String>();
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "r");
            String str;
            while ((str = file.readLine()) != null) {
                String [] lineContent = str.split("=");
                String key = lineContent[0].trim();
                String value = lineContent[1].trim();
                data.put(key, value);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}
