import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.IDataProviderMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class UnitTests {
    DecisionMaking decisionMaking = new DecisionMaking();


    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{404, "xxxooo---"}, {500, "ooooxxxxo"}};
    }


    @Test(dataProvider = "getData")

    public void testMethod(Integer code, String status) {

        int outcomeCode = decisionMaking.whatTheStatusCode(status);
        Assert.assertEquals(code, outcomeCode);
        System.out.println("given data " + status);

    }



}


//  status  public String whatTheStatus(String input) {
//        switch (whatTheStatusCode(input)) {
//            case 301:
//                return DecisionMaking.Code.X_WON.value;
//            case 302:
//                return DecisionMaking.Code.O_WON.value;
//            case 100:
//                return DecisionMaking.Code.GAME_CONTINUES.value;
//            case 404:
//                return DecisionMaking.Code.STATUS_INCORRECT.value;
//            case 500:
//                return DecisionMaking.Code.INPUT_INCORRECT.value;
//            default:
//                return DecisionMaking.Code.STATUS_CORRECT.value;
//        }
//    }