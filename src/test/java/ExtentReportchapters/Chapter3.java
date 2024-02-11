package ExtentReportchapters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Chapter3 {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        extentReports
                .createTest("Test 1")
                .log(Status.INFO, "info1")
                .log(Status.INFO, "<b>info2</b>")//to get bold
                .log(Status.INFO, "<i>info3</i>"); // to get italic
        String xmlDate = "<menu id=\"file\" value=\"File\">\n" +
                "  <popup>\n" +
                "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                "  </popup>\n" +
                "</menu>\n";
        String jsonData = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +

                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";

        extentReports
                .createTest("XML based Test")
                    //    .log(Status.INFO, xmlDate); -----this will not show the code so we go for markup helper
                .info(MarkupHelper.createCodeBlock(xmlDate, CodeLanguage.XML));
        extentReports
                .createTest("Json Data")
//                        .log(Status.INFO, jsonData)
                .info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
        List<String> listData = new ArrayList<>();
        listData.add("achutha");
        listData.add("riaan");
        listData.add("rithan");

        Map<Integer, String> mapData = new HashMap<>();
        mapData.put(3, "fdfl");
        mapData.put(34,"dfmld");
        mapData.put(5, "fldf");


        Set<Integer> setData = mapData.keySet();
        extentReports
                .createTest("List based Text")
                .info(MarkupHelper.createOrderedList(listData))
                .info(MarkupHelper.createUnorderedList(listData));
        extentReports
                .createTest("Set based Text")
                .info(MarkupHelper.createOrderedList(mapData))
                .info(MarkupHelper.createUnorderedList(mapData));
        extentReports
                .createTest("Highlight log Text")
                .info("not a highlighed one")
                .info(MarkupHelper.createLabel("this is highlighted message", ExtentColor.RED));
        try { int a=5/0;
             }
        catch (Exception e)
        {extentReports
                .createTest("Exception test")
                .info(e);
        }
        Throwable t = new RuntimeException("This is a custom exception");
        extentReports
                .createTest("Exeption test2")
                .fail(t);
        extentReports
                .createTest("Exeption test3")
                .fail(t);



        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());

    }
}
