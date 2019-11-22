import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constant;
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
        ExcelUtils excel = new ExcelUtils(excelPath, excelSheet);


        // getting row and columns count
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];


        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
//                System.out.println(cellData + "cellData: ");
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }


    @Test(dataProvider = "snakeData")
    public void testMethod(String gameData, String outcomeStatus, String outcomeCode) {

//        decisionMaking.whatTheStatusCode(gameData);
//        Assert.assertEquals(outcomeCode, decisionMaking.whatTheStatusCode(gameData));

        Assert.assertEquals(outcomeStatus, decisionMaking.whatTheStatus(gameData));


        System.out.println("Given data " + gameData +  "; Code: " + outcomeCode + "; Status: " + outcomeStatus);

    }
}
