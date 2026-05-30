package Testing_practice;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Write_Excel {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {
                { "admin", "admin" },
                { "invalid", "password" },
                { "username", "wrongpass" },
                { "testuser", "test123" }
        };
    }

    @Test
    public void createExcel() throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("LoginData");

        sheet.createRow(0).createCell(0).setCellValue("Username");
        sheet.getRow(0).createCell(1).setCellValue("Password");

        Object[][] data = loginData();

        for (int i = 0; i < data.length; i++) {

            sheet.createRow(i + 1).createCell(0)
                    .setCellValue(data[i][0].toString());

            sheet.getRow(i + 1).createCell(1)
                    .setCellValue(data[i][1].toString());
        }

        FileOutputStream file = new FileOutputStream(
                "/Users/pankajvishwakarma/eclipse-workspace/TestNG_Selenium/TestData/Write_Data.xlsx");

        workbook.write(file);

        file.close();
        workbook.close();

        System.out.println("Excel File Created Successfully");
    }
}