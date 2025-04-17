package org.crossbrowsertesting.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.crossbrowsertesting.utils.ExcelSheetCreation;
import org.testng.annotations.Test;

import java.io.FileOutputStream;

import static io.restassured.RestAssured.given;

public class APITesting {
    @Test
    public void getMethod() {
        try {
            // Step 1: Create Excel File
            ExcelSheetCreation.excelSheetCreation();

            // Step 2: Add Header Row
            HSSFRow headerRow = ExcelSheetCreation.sheet1.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("FIRST_NAME");
            headerRow.createCell(2).setCellValue("LAST_NAME");
            headerRow.createCell(3).setCellValue("EMAIL");

            // Step 3: Start Fetching Users
            int userId = 1;
            int excelRowIndex = 1;

            while (true) {
                Response r = given()
                        .baseUri("https://reqres.in")
                        .when()
                        .get("/api/users/" + userId)
                        .then()
                        .extract()
                        .response();

                Integer id = r.path("data.id");
                if (id == null) {
                    System.out.println("No more users found. Ending loop.");
                    break;
                }

                // Step 4: Set data to object
                EncapsulationData obj = new EncapsulationData();
                obj.setId(id);
                obj.setEmail(r.path("data.email"));
                obj.setFirst_name(r.path("data.first_name"));
                obj.setLast_name(r.path("data.last_name"));

                // Step 5: Write to Excel
                HSSFRow dataRow = ExcelSheetCreation.sheet1.createRow(excelRowIndex++);
                dataRow.createCell(0).setCellValue(obj.getId());
                dataRow.createCell(1).setCellValue(obj.getFirst_name());
                dataRow.createCell(2).setCellValue(obj.getLast_name());
                dataRow.createCell(3).setCellValue(obj.getEmail());

                System.out.println("User ID " + userId + " written to Excel.");
                userId++;
            }

            // Step 6: Save Excel File
            FileOutputStream out = new FileOutputStream(ExcelSheetCreation.filename);
            ExcelSheetCreation.workbook.write(out);
            out.close();

            System.out.println("✅ All data written successfully to Excel.");

        } catch (Exception e) {
            throw new RuntimeException("Error occurred during GET method execution", e);
        }
    }

//    @Test
//    public void postMethod(){
//
//    }
//    @Test
//    public void putMethod(){
//
//    }
//    @Test
//    public void patchMethod(){
//
//    }
//    @Test
//    public void delete(){
//
//    }
}
