package com.vim.rulesengine.loanapp;

import com.vim.rulesengine.SpringRuleEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanProcessRuleEngineTest {

    @Test
    public void testSuccessfulFlow() throws Exception {
        SpringRuleEngine engine = LoanProcessRuleEngine.getEngine("SharkysExpressLoansApplicationProcessor");
        LoanApp app = new LoanApp();
        app.setFirstName("John");
        app.setLastName("Doe");
        app.setStateCode("TX");
        app.setExpences(4500);
        app.setIncome(7000);
        engine.processRequest(app);
        assertEquals(LoanState.APPROVED, app.getStatus());
    }

    @Test
    public void testInvalidState() throws Exception {
        SpringRuleEngine engine = LoanProcessRuleEngine.getEngine("SharkysExpressLoansApplicationProcessor");
        LoanApp app = new LoanApp();
        app.setFirstName("John");
        app.setLastName("Doe");
        app.setStateCode("OK");
        app.setExpences(4500);
        app.setIncome(7000);
        engine.processRequest(app);
        assertEquals(LoanState.INVALID_STATE, app.getStatus());
    }

    @Test
    public void testInvalidRatio() throws Exception {
        SpringRuleEngine engine = LoanProcessRuleEngine.getEngine("SharkysExpressLoansApplicationProcessor");
        LoanApp app = new LoanApp();
        app.setFirstName("John");
        app.setLastName("Doe");
        app.setStateCode("MI");
        app.setIncome(7000);
        app.setExpences(0.80 * 7000); //too high      
        engine.processRequest(app);
        assertEquals(LoanState.INVALID_INCOME_EXPENSE_RATIO, app.getStatus());
    }

    @Test
    public void testIncompleteApplication() throws Exception {
        SpringRuleEngine engine = LoanProcessRuleEngine.getEngine("SharkysExpressLoansApplicationProcessor");
        LoanApp app = new LoanApp();
        engine.processRequest(app);
        assertEquals(LoanState.INSUFFICIENT_DATA, app.getStatus());
    }
}
