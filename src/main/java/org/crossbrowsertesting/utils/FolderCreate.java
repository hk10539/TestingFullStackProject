package org.crossbrowsertesting.utils;
import java.io.File;
import java.util.Date;
public class FolderCreate {
    public static String folderName;
    public static void folderCreate() {
        try{
            Date currentDate = new Date();
            folderName = currentDate.toString().replace(":", "");
            folderName=folderName.replaceAll("[^a-zA-Z0-9]", "");
            String userHome = System.getProperty("user.home");
            String folderPath = userHome+"/Documents/Record "+folderName;
            File folder = new File(folderPath);
            boolean folderCreated = folder.mkdir();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
