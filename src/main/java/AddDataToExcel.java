import org.apache.poi.hssf.usermodel.HSSFRow;

import java.io.FileOutputStream;

public class AddDataToExcel {
    public static void main(String[] args) {
        try {
            // Pehle sheet create kar lo
            Main.excelSheetCreation();

            // Sheet access karo
            HSSFRow row = Main.sheet1.createRow(1);  // Row 1
            row.createCell(0).setCellValue(102);
            row.createCell(1).setCellValue("Rahul Verma");
            row.createCell(2).setCellValue("rahul@example.com");

            // File mein changes save karo
            FileOutputStream out = new FileOutputStream(Main.filename);
            Main.workbook.write(out);
            out.close();

            System.out.println("Data added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
