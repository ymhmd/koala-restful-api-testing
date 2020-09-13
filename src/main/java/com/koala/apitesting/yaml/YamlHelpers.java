package com.koala.apitesting.yaml;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.InputStream;

public class YamlHelpers {

    private Suite yamlSuite;

    private Object getDescription(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getDescription();
    }

    private Object getUrl(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getUrl();
    }

    private Object getType(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getType();
    }

    private Object getMultipleValues(String[] values, int position) {
        String totalValue = null;
        if (values.length == 1) return values[0].split(",")[position].trim();
        for (int i = 0; i < values.length; i++) {
            String value = values[i].split(",")[position].trim();
            if (i == 0) totalValue = value + "\n";
            else if (i == values.length - 1) totalValue += value;
            else totalValue = totalValue + value + "\n";
        }
        return totalValue;
    }

    private Object getHeaderKeys(int stepNumber) {
        if (yamlSuite.getSteps().get(stepNumber).getHeaders() != null) {
            String[] headers = yamlSuite.getSteps().get(stepNumber).getHeaders().toString().split(";");
            return getMultipleValues(headers, 0);
        } else {
            return "";
        }
    }

    private Object getHeaderValues(int stepNumber) {
        if (yamlSuite.getSteps().get(stepNumber).getHeaders() != null) {
            String[] headers = yamlSuite.getSteps().get(stepNumber).getHeaders().toString().split(";");
            return getMultipleValues(headers, 1);
        } else {
            return "";
        }
    }

    private Object getBody(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getBody();
    }

    private Object getStatusCode(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getStatusCode();
    }

    private Object getValidationKeys(int stepNumber) {
        if (yamlSuite.getSteps().get(stepNumber).getValidations() != null) {
            String[] headers = yamlSuite.getSteps().get(stepNumber).getValidations().toString().split(";");
            return getMultipleValues(headers, 0);
        } else {
            return "";
        }
    }

    private Object getValidationValues(int stepNumber) {
        if (yamlSuite.getSteps().get(stepNumber).getValidations() != null) {
            String[] headers = yamlSuite.getSteps().get(stepNumber).getValidations().toString().split(";");
            return getMultipleValues(headers, 1);
        } else {
            return "";
        }
    }

    private Object getValidationDataTypes(int stepNumber) {
        if (yamlSuite.getSteps().get(stepNumber).getValidations() != null) {
            String[] headers = yamlSuite.getSteps().get(stepNumber).getValidations().toString().split(";");
            return getMultipleValues(headers, 2);
        } else {
            return "";
        }
    }

    private Object getWait(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getWait();
    }

    public Object[][] getTestData(String yamlName, int cols) throws Exception {

        Yaml yaml = new Yaml(new Constructor(Suite.class));
        InputStream inputStream = new FileInputStream(yamlName);
        yamlSuite = yaml.load(inputStream);

        int stepsLength = yamlSuite.getStepsLength();
        Object[][] values = new Object[stepsLength][cols];
        for (int i = 0; i < stepsLength; i++) {
            values[i][0] = getDescription(i);

            if (yamlSuite.getSteps().get(i).getUrl() == null) {
                values[i][1] = "";
            } else {
                values[i][1] = getUrl(i);
            }

            if (yamlSuite.getSteps().get(i).getType() == null) {
                values[i][2] = "";
            } else {
                values[i][2] = getType(i);
            }

            if (yamlSuite.getSteps().get(i).getHeaders() == null) {
                values[i][3] = "";
                values[i][4] = "";
            } else {
                values[i][3] = getHeaderKeys(i);
                values[i][4] = getHeaderValues(i);
            }

            if (yamlSuite.getSteps().get(i).getBody() == null) {
                values[i][5] = "";
            } else {
                values[i][5] = getBody(i);
            }

            if (yamlSuite.getSteps().get(i).getStatusCode() == null) {
                values[i][6] = "";
            } else {
                values[i][6] = getStatusCode(i).toString();
            }

            if (yamlSuite.getSteps().get(i).getValidations() == null) {
                values[i][7] = "";
                values[i][8] = "";
                values[i][9] = "";
            } else {
                values[i][7] = getValidationKeys(i);
                values[i][8] = getValidationValues(i);
                values[i][9] = getValidationDataTypes(i);
            }

            if (yamlSuite.getSteps().get(i).getWait() == null) {
                values[i][10] = "";
            } else {
                values[i][10] = getWait(i).toString();
            }

            if (yamlSuite.getSteps().get(i).getDbUrl() == null) {
                values[i][11] = "";
            } else {
                values[i][11] = getDbUrl(i);
            }

            if (yamlSuite.getSteps().get(i).getDbUsername() == null) {
                values[i][12] = "";
            } else {
                values[i][12] = getDbUsername(i);
            }

            if (yamlSuite.getSteps().get(i).getDbPassword() == null) {
                values[i][13] = "";
            } else {
                values[i][13] = getDbPassword(i);
            }

            if (yamlSuite.getSteps().get(i).getDbQuery() == null) {
                values[i][14] = "";
            } else {
                values[i][14] = getDbQuery(i);
            }

        }
        return values;
    }

    private Object getDbUrl(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getDbUrl();
    }

    private Object getDbUsername(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getDbUsername();
    }

    private Object getDbPassword(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getDbPassword();
    }

    private Object getDbQuery(int stepNumber) {
        return yamlSuite.getSteps().get(stepNumber).getDbQuery();
    }

}
