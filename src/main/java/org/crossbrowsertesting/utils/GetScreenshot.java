package org.crossbrowsertesting.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.util.Date;
public class GetScreenshot{
    public static String screenshotFileName=null;
    public static void screenshot(WebDriver driver) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            Date currentDate = new Date();
            screenshotFileName = currentDate.toString().replace(":", ".");
            String userHome = System.getProperty("user.home");
            File DestFile = new File(userHome+"/Documents/Record "+FolderCreate.folderName+"\\Record " + screenshotFileName + ".png");
            FileHandler.copy(SrcFile, DestFile);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}