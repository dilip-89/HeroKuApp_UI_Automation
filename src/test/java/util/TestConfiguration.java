package util;

public class TestConfiguration {

    public static final String OUTPUT_FOLDER = "./test-output/reports/";
    public static final String FILE_NAME = "HeroKuApp Regression Report.html";
    public static final String SPECIAL_CAPTURE_FOLDER = "/SPECIAL_CAPTURE_/";

    public static String prepareApplicationPropertyPrefix(String product) {
        return "application." + product.toLowerCase() + "." + "url";
    }
}
