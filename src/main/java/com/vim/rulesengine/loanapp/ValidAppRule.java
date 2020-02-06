package com.vim.rulesengine.loanapp;

import com.vim.rulesengine.AbstractRule;

public class ValidAppRule extends AbstractRule {
    protected boolean makeDecision(Object arg) throws Exception {
        LoanApp app = (LoanApp) arg;
        if(app.getExpences() == 0 ||
                app.getFirstName() == null ||
                app.getIncome() == 0 ||
                app.getLastName() == null ||
                app.getStateCode() == null) {
            app.setStatus(LoanState.INSUFFICIENT_DATA);
            return false;
        }
        return true;
    }
}
