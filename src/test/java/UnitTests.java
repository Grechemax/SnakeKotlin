import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.IDataProviderMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class UnitTests {
    DecisionMaking decisionMaking = new DecisionMaking();


    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {"xxxooo---", "Status is incorrect", 404},
                {"oomoxxxxo", "Input is incorrect", 500},
                {"x--------", "Game continues", 100},
                {"xxxoo----", "x won", 301},
                {"xxoxx-ooo", "o won", 302}};
    }


    @Test(dataProvider = "getData")

    public void testMethod(String gameData, String outcomeStatus, int outcomeCode) {

        decisionMaking.whatTheStatusCode(gameData);

        Assert.assertEquals(outcomeStatus, decisionMaking.whatTheStatus(gameData));
        Assert.assertEquals(outcomeCode, decisionMaking.whatTheStatusCode(gameData));


//        System.out.println("given data " + code + " = " + outcomeCode + " " + gameData);

    }


}
