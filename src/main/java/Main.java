import org.crossbrowsertesting.utils.ExcelSheet;
import org.crossbrowsertesting.utils.FolderCreate;
import org.crossbrowsertesting.utils.GetScreenshot;
import org.crossbrowsertesting.web.URLVerification;
import org.openqa.selenium.WebDriver;

class Main{
    public static void main(String[] args){
        try{
            FolderCreate.folderCreate();
            ExcelSheet.excelSheetCreation();
            URLVerification u=new URLVerification();
            u.beforeMethod("chrome");
            u.URLverification();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}