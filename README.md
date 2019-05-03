# Koala

* Now you can write your API tests in yaml format with very solid assertions generating powerful report in xml and html. For example:

```
description: "First test suite ever"
steps:
  - description: Get token and validate it exists
    url: '{@global_vars:api_url}'
    type: GET
    headers:
    body:
    statusCode: 200
    validations: Token, null, string
    wait: 0

  - description: Get token and validate response
    url: '{@global_vars:api_url}'
    type: GET
    headers:
    body:
    statusCode: 200
    validations: 'Value_float, 123.123, float; Value_boolean, true, boolean'
    wait: 0
```

### How import Koala in your gradle project

* Gradle Example

```$xslt
allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
   }
   dependencies {
        implementation 'com.github.ymhmd:koala:master'
   }
```

* Now Koala is imported to gradle project.


* Create `KoalaExample` class to trigger tests execution

```$xslt
import com.koala.apitesting.yaml.YamlRunner;

public class KoalaExample {

    private static String YAMLFiles = "execution/sample-1.yaml, execution/sample-2.yaml";
    private static String GlobalVarsFile = "execution/globalVars.bueno";

    public static void main(String[] args) {

        YamlRunner yamlRunner = new YamlRunner();

        yamlRunner.executeYamlSuite(YAMLFiles, GlobalVarsFile);

    }

}

```