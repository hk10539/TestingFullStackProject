package org.crossbrowsertesting.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Date;

public class ExcelSheet {
    public static String filename=null;
    public static HSSFWorkbook workbook = new HSSFWorkbook();
    public static HSSFSheet sheet1 = workbook.createSheet("WEB");
    public static HSSFRow rowhead = sheet1.createRow((short)0);
    public static void excelSheetCreation(){
        try
        {
            FolderCreate.folderCreate();
            Date currentDate = new Date();
            String excelSheetFileName = currentDate.toString().replace(":", ".");
            String userHome = System.getProperty("user.home");
            filename = userHome+"/Documents/Record "+FolderCreate.folderName+"/Record " +excelSheetFileName+ ".xls";
            rowhead.createCell(0).setCellValue("TS_ID");
            rowhead.createCell(1).setCellValue("Test Scenario");
            rowhead.createCell(2).setCellValue("TC_ID");
            rowhead.createCell(3).setCellValue("Test Case Description");
            rowhead.createCell(4).setCellValue("Test Data");
            rowhead.createCell(5).setCellValue("Test Step");
            rowhead.createCell(6).setCellValue("Expected Result");
            rowhead.createCell(7).setCellValue("Actual Result");
            rowhead.createCell(8).setCellValue("STATUS");
            rowhead.createCell(9).setCellValue("SCREENSHOT NAME");
            rowhead.createCell(10).setCellValue("TEST CASE RUN TIME");
            rowhead.createCell(11).setCellValue("REMARK");
            rowhead.createCell(12).setCellValue("");
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}