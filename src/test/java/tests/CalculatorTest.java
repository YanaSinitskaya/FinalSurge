package tests;

import org.testng.annotations.Test;

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

}
