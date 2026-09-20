package Day_12;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {
    public static String getData(int row,int cell) throws IOException {
        FileInputStream fis=new FileInputStream("./src/test/resources/new/Day12.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        DataFormatter df=new DataFormatter();
        String data=df.formatCellValue(wb.getSheet("Sheet1").getRow(row).getCell(cell));
        wb.close();
        fis.close();
        return data;
    }
    public static String getMyInfoData(int row,int cell) throws IOException {
        FileInputStream fis=new FileInputStream("./src/test/resources/new/Day12.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        DataFormatter df=new DataFormatter();
        String data=df.formatCellValue(wb.getSheet("Sheet2").getRow(row).getCell(cell));
        wb.close();
        fis.close();
        return data;
    }

}
