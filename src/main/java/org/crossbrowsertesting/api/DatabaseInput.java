package org.crossbrowsertesting.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.Connection;

import static io.restassured.RestAssured.given;
public class DatabaseInput {
    @Test
    public void getMethod() {
        try {
            String db=ServerFrame.serverFrame();
            System.out.println(db);
            Connection con=DatabaseConnection.databaseConnection(db);
            con.setAutoCommit(true);
            System.out.println(con.toString());
            int userId = 1;
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
                obj.setEmail(r.path("data.email"));
                obj.setFirst_name(r.path("data.first_name"));
                obj.setLast_name(r.path("data.last_name"));
                DatabaseInsert.insertUser(con,obj.getFirst_name(),obj.getLast_name(), obj.getEmail());
                userId++;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during GET method execution", e);
        }
    }
}
