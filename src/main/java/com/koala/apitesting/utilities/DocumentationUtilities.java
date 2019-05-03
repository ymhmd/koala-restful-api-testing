package com.koala.apitesting.utilities;

public class DocumentationUtilities {

    public static String getTestDataWithValues(String url, String type, String[] headersKeys
            , String[] headersValues, String body, int statusCode
            , String[] JsonPaths, String[] JsonValues, String[] DataTypes) {

        String output = VariablesProvider.dashLine + "URL: \n <" + url + ">" + VariablesProvider.dashLine;
        output = output + "Request type: \n <" + type + ">" + VariablesProvider.dashLine;
        String headerOutput = "N/A";
        String pathOutput = "N/A";

        for (int i = 0; i < headersKeys.length; i++) {
            if (i == 0) {
                headerOutput = " <" + headersKeys[i] + "> : <" + headersValues[i] + ">";
            } else {
                headerOutput = headerOutput + "\n <" + headersKeys[i] + "> : <" + headersValues[i] + ">";
            }

        }
        for (int i = 0; i < JsonPaths.length; i++) {
            if (JsonPaths[i].equals("")) break;
            if (i == 0) {
                pathOutput = " <" + JsonPaths[i] + "> : <" + DataTypes[i] + "> : <" + JsonValues[i] + ">";
            } else {
                pathOutput = pathOutput + "\n <" + JsonPaths[i] + "> : <" + DataTypes[i] + "> : <" + JsonValues[i] + ">";
            }

        }
        output = output + "Headers: \n" + headerOutput + VariablesProvider.dashLine;
        output = output + "Request body: \n <" + body + ">" + VariablesProvider.dashLine;
        output = output + "Expected status code: \n" + (statusCode) + VariablesProvider.dashLine;
        output = output + "Json paths to check: \n" + pathOutput + VariablesProvider.dashLine;
        return output;

    }

}

