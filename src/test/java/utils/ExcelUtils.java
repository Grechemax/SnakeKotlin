package utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;


public class ExcelUtils {
    static final String SHEET_PATH = "/Users/max/IdeaProjects/SnakeKotlin/excel/Book2.xlsx";
    static XSSFSheet sheet;
    static XSSFWorkbook workbook;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) throws IOException {
        getCellDataString(1, 0);
    }

    public static int getRowCount() throws IOException {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("Number of rows " + rowCount);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount() throws IOException {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Number of cols " + colCount);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;
    }


    // retrieving data from a particular String cell
    public static String getCellDataString(int rows, int columns) throws IOException {
        String cellData = null;
        try {
            cellData = sheet.getRow(rows).getCell(columns).getStringCellValue();
//            System.out.println(cellData);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }

    // retrieving data from a particular Number cell
    public static void getCellDataNumber(int rows, int columns) throws IOException {
        try {
            double cellData = sheet.getRow(rows).getCell(columns).getNumericCellValue();
//            System.out.println(cellData);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
