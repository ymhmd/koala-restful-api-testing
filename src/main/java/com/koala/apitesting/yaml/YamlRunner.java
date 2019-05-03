package com.koala.apitesting.yaml;

import com.koala.apitesting.utilities.BuenoFileUtilities;
import com.koala.apitesting.utilities.VariablesProvider;
import org.testng.TestNG;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YamlRunner {

    public static void main(String[] args) {
        String buenoFile;
        try {
            buenoFile = args[0];
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Please Enter Valid Bueno File Directory!!");
            return;
        }
        executeYamlSuite(buenoFile);
    }

    private static void executeYamlSuite(String buenoFile) {
        System.out.println("Bueno Runner file: " + buenoFile);
        System.out.println("======================================");
        Map<String, String> buenoRunnerData = BuenoFileUtilities.getBuenoFileContent(buenoFile);

        String yamlFiles = buenoRunnerData.get("YAMLFiles");
        String globalVarsFile = buenoRunnerData.get("GlobalVarsFile");
        String scriptFormat = buenoRunnerData.get("FileFormat");

        String testngRunner = createXmlRunner(yamlFiles, globalVarsFile, scriptFormat);

        TestNG runner = new TestNG();
        List<String> suiteFiles = new ArrayList<String>();
        suiteFiles.add(testngRunner);
        runner.setTestSuites(suiteFiles);
        runner.run();

        File file = new File(testngRunner);
        if (file.delete()) {
            System.out.println("All unnecessary files are deleted.");
        } else {
            System.out.println("Cannot delete unnecessary files.");
        }

        System.exit(0);

    }

    public void executeYamlSuite (String yamlFilesStr, String globalVars) {
        String testngRunner = createXmlRunner(yamlFilesStr, globalVars, "YAML");
        TestNG runner = new TestNG();
        List<String> suiteFiles = new ArrayList<String>();
        suiteFiles.add(testngRunner);
        runner.setTestSuites(suiteFiles);
        runner.run();

        File file = new File(testngRunner);
        if (file.delete()) {
            System.out.println("All unnecessary files are deleted.");
        } else {
            System.out.println("Cannot delete unnecessary files.");
        }

        System.exit(0);
    }

    private static String createXmlRunner(String yamlFilesStr, String globalVars, String scriptFormat) {
        String[] yamlFiles = yamlFilesStr.split(",");
        String xmlFilePath = "testsuite.xml";
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("suite");
            root.setAttribute("annotations", "JDK");
            root.setAttribute("name", yamlFilesStr.replaceAll("/", "-"));
            root.setAttribute("parallel", "tests");
            root.setAttribute("thread-count", "1");
            root.setAttribute("verbose", "3");
            document.appendChild(root);

            //Parameter elements
            Element parameter1 = document.createElement("parameter");
            parameter1.setAttribute("name", "FileFormat");
            parameter1.setAttribute("value", scriptFormat);
            root.appendChild(parameter1);

            Element parameter2 = document.createElement("parameter");
            parameter2.setAttribute("name", "GlobalVars");
            parameter2.setAttribute("value", globalVars.trim());
            root.appendChild(parameter2);

            //Test parameters
            for (String yamlFile : yamlFiles) {
                Element test = document.createElement("test");
                test.setAttribute("name", yamlFile.trim());

                Element parameter3 = document.createElement("parameter");
                parameter3.setAttribute("name", "YAMLFile");
                parameter3.setAttribute("value", yamlFile.trim());
                test.appendChild(parameter3);

                Element classes = document.createElement("classes");
                Element c = document.createElement("class");
                c.setAttribute("name", VariablesProvider.testClassPath.trim());
                classes.appendChild(c);
                test.appendChild(classes);
                root.appendChild(test);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

        return xmlFilePath;
    }

}
