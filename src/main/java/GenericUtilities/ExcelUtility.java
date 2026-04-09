package GenericUtilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    public String readDatatFromExcel(String sheetname, int  rownum, int cellnum) throws IOException {

        FileInputStream fis= new FileInputStream("src/test/resources/testdata/Vtiger.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet(sheetname);
        Row row= sh.getRow(rownum);
        Cell cel= row.getCell(cellnum);
        String value= cel.getStringCellValue();
        wb.close();
        return value;

    }

    public int getrowcount(String sheetname) throws IOException {
        FileInputStream fis= new FileInputStream("src/test/resources/testdata/Vtiger.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet(sheetname);
        int rowcount=sh.getLastRowNum();
        return  rowcount;

    }
}
