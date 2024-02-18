package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalculatorTest extends BaseTest {

    @Test(description = "Valid inputs on Pace Calculator", retryAnalyzer = Retry.class)
    public void paceCalcPositiveTest() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.paceCalc();
        calculatorPage.distance("5000");
        calculatorPage.time("4", "7", "28");
        calculatorPage.saveButton();
        assertTrue(calculatorPage.getPace(), "Pace is calculated");
    }

    @Test(description = "Valid inputs on Caloric Needs Calculator", retryAnalyzer = Retry.class)
    public void caloricNeedsPositiveTest() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.weight("58");
        calculatorPage.height("170");
        calculatorPage.age("18");
        calculatorPage.femaleGender();
        calculatorPage.runDistance("10");
        calculatorPage.saveButton();
        assertTrue(calculatorPage.getCaloricNeeds(), "Caloric Need is calculated");
    }

    @DataProvider(name = "Input data for negative tests for pace calculator")
    public Object[][] paceValues() {
        return new Object[][]{
                {"", "", "", "", "×\nPlease fix the following errors:\n" +
                        "*Please enter an Integer value for Minutes.\n"},
                {"0", "0", "0", "0", "×\nPlease fix the following errors:\n" +
                        "*Please enter a distance greater than 0.\n" +
                        "*Please enter a time greater than 0 seconds.\n"},
                {"qw", "qw", "qw", "qw", "×\nPlease fix the following errors:\n" +
                        "*Please enter a valid Integer for Hours (no decimals).\n" +
                        "*Please enter a valid Integer for Minutes (no decimals).\n" +
                        "*Please enter a valid Integer for Seconds (no decimals).\n"},
        };
    }

    @Test(dataProvider = "Input data for negative tests for pace calculator", retryAnalyzer = Retry.class)
    public void valuesForPaceCalcShouldBeRequired(String distance, String hours, String minutes, String seconds, String error) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.paceCalc();
        calculatorPage.distance(distance);
        calculatorPage.time(hours, minutes, seconds);
        calculatorPage.saveButton();
        assertEquals(calculatorPage.getError(), error, "Wrong error message");
    }
}