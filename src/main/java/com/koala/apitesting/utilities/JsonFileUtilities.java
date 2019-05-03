package com.koala.apitesting.utilities;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.util.Map;

public class JsonFileUtilities {

    public static Map<String, String> getJsonFileContent (String fileName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new File(fileName), new TypeReference<Map<String, Object>>() {});
    }

}
