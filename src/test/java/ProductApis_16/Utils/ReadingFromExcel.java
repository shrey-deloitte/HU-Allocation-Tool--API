package ProductApis_16.Utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFromExcel{

    AdminClass adminClass= null;


    public static AdminClass loginAdmin() throws IOException{
        AdminClass adminClass =null;
        String excelFilePath ="C:\\Users\\shubhamkumar32\\IdeaProjects\\ApiAutomation\\src\\test\\java\\AdminLoginDetails.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(0);
        XSSFRow row= sheet.getRow(1);
        adminClass = new AdminClass(row.getCell(0).toString(),row.getCell(1).toString());
        return adminClass;
    }


}
