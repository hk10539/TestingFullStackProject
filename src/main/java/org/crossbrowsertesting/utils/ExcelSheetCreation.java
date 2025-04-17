package org.crossbrowsertesting.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Date;

public class ExcelSheetCreation {
    public static String filename = null;
    public static HSSFWorkbook workbook = new HSSFWorkbook();
    public static HSSFSheet sheet1 = workbook.createSheet("Data");
    public static void excelSheetCreation() {
        try {
            FolderCreate.folderCreate();
            Date currentDate = new Date();
            String excelSheetFileName = currentDate.toString().replace(":", ".");
            String userHome = System.getProperty("user.home");
            filename = userHome + "/Documents/Record "+FolderCreate.folderName + "/Record"+excelSheetFileName + ".xls";
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
