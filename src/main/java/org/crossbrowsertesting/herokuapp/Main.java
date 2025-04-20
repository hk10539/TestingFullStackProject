package org.crossbrowsertesting.herokuapp;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public class Main {
    String value = "";
    WebDriver driver;
    Properties props;
    HSSFRow headerRow;
    int rowCount = 1;

    @BeforeClass
    public void beforeClass() {
        try {
            value = BuildFrame.serverFrame();
            if (value == null) {
                throw new SkipException("No selection made.");
            }

            props = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/herokuapp.properties");
            props.load(input);

            ExcelSheetcreation.excelSheetCreation();
            headerRow = ExcelSheetcreation.sheet1.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("FIRST_NAME");
            headerRow.createCell(2).setCellValue("LAST_NAME");
            headerRow.createCell(3).setCellValue("EMAIL");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
    }

    @Test
    public void drag_and_drop() {
        if (!Objects.equals(value, "drag_and_drop")) {
            throw new SkipException("Skipping drag_and_drop test");
        }
        driver.get(props.getProperty("db.url") + value);
        writeExcel("1", "Shreya", "Singh", "shreya@example.com");
    }

    @Test
    public void dropdown() {
        if (!Objects.equals(value, "dropdown")) {
            throw new SkipException("Skipping dropdown test");
        }
        driver.get(props.getProperty("db.url") + value);
        writeExcel("2", "Amit", "Sharma", "amit@example.com");
    }

    @Test
    public void dynamic_controls() {
        if (!Objects.equals(value, "dynamic_controls")) {
            throw new SkipException("Skipping dynamic_controls test");
        }
        driver.get(props.getProperty("db.url") + value);
        writeExcel("3", "Neha", "Verma", "neha@example.com");
    }

    @Test
    public void dynamic_content() {
        if (!Objects.equals(value, "dynamic_content")) {
            throw new SkipException("Skipping dynamic_content test");
        }
        driver.get(props.getProperty("db.url") + value);
        writeExcel("4", "Ravi", "Patel", "ravi@example.com");
    }

    @Test
    public void dynamic_loading() {
        if (!Objects.equals(value, "dynamic_loading")) {
            throw new SkipException("Skipping dynamic_loading test");
        }
        driver.get(props.getProperty("db.url") + value);
        writeExcel("5", "Pooja", "Rani", "pooja@example.com");
    }

    public void writeExcel(String id, String first, String last, String email) {
        HSSFRow dataRow = ExcelSheetcreation.sheet1.createRow(rowCount++);
        dataRow.createCell(0).setCellValue(id);
        dataRow.createCell(1).setCellValue(first);
        dataRow.createCell(2).setCellValue(last);
        dataRow.createCell(3).setCellValue(email);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void saveExcelSheet() {
        ExcelSheetcreation.saveExcel("src/main/resources/test-output.xls");
    }
}
