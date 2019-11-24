import org.apache.poi.ss.usermodel.CellType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constant;
import utils.ExcelDataProvider;
import utils.ExcelUtils;

import java.io.IOException;

public class UnitTests {
    DecisionMaking decisionMaking = new DecisionMaking();


    // returning the data object
    @DataProvider(name = "snakeData")
    public Object[][] getData() throws IOException {
        Object data[][] = testData(Constant.SHEET_PATH, Constant.SHEET);
        return data;
    }

    // running a loop to get all data in a Object Array
    public Object[][] testData(String excelPath, String excelSheet) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils(excelPath, excelSheet);


        // getting row and columns count
        int rowCount = excelUtils.getRowCount();
        int colCount = excelUtils.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];


        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {

//                String cellData = excelUtils.getCellDataString(i, j);
//                data[i - 1][j] = cellData;


                switch(excelUtils.cellType(i, j)) {
                    case STRING:
                        String cellData = excelUtils.getCellDataString(i, j);
                        data[i - 1][j] = cellData;
                        break;
                    case NUMERIC:
                        int cellDataNumber = (int)excelUtils.getCellDataNumber(i, j);
                        data[i - 1][j] = cellDataNumber;
                        break;
                }
            }
        }
        return data;
    }


    @Test(dataProvider = "snakeData")
    public void testMethod(String gameData, String outcomeStatus, int outcomeCode) {
        int code = decisionMaking.whatTheStatusCode(gameData);
        String status = decisionMaking.whatTheStatus(gameData);

        Assert.assertEquals(outcomeCode, code);
        Assert.assertEquals(outcomeStatus, status);

        System.out.println("Given data: " + gameData +  ";  Code: " + outcomeCode + ";  Status: " + outcomeStatus);

    }
}
