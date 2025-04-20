package org.crossbrowsertesting.herokuapp;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelSheetcreation {
    public static HSSFWorkbook workbook;
    public static HSSFSheet sheet1;

    public static void excelSheetCreation() {
        workbook = new HSSFWorkbook();
        sheet1 = workbook.createSheet("Test Data");
    }

    public static void saveExcel(String path) {
        try (FileOutputStream out = new FileOutputStream(path)) {
            workbook.write(out);
            workbook.close();
            System.out.println("✅ Excel written successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
