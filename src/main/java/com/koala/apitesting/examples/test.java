package com.koala.apitesting.examples;

import com.koala.apitesting.yaml.YamlRunner;
import org.testng.annotations.Test;

public class test {

    @Test
    public void singleYamlSuite () {
        String GlobalVarsFile = "execution/globalVars.json";
        String YAMLFiles = "execution/sample-1.yaml";

        YamlRunner yamlRunner = new YamlRunner();

        yamlRunner.executeYamlSuite(YAMLFiles, GlobalVarsFile);
    }

    @Test
    public void multipleYamlSuites () {
        String GlobalVarsFile = "execution/globalVars.bueno";
        String YAMLFiles = "execution/sample-1.yaml, execution/sample-2.yaml";

        YamlRunner yamlRunner = new YamlRunner();

        yamlRunner.executeYamlSuite(YAMLFiles, GlobalVarsFile);
    }


    @Test
    public void databaseTestSuite () {
        String GlobalVarsFile = "execution/globalVars.json";
        String YAMLFiles = "execution/sample-database.yaml";

        YamlRunner yamlRunner = new YamlRunner();

        yamlRunner.executeYamlSuite(YAMLFiles, GlobalVarsFile);
    }

}

