package com.vim.rulesengine.loanapp;

import com.vim.rulesengine.AbstractRule;

public class ValidIncomeExpenseRatioRule extends AbstractRule {

    private double validRatio;

    protected boolean makeDecision(Object arg) throws Exception {
        LoanApp app = (LoanApp) arg;
        if(( app.getExpences() / app.getIncome() ) < validRatio)
            return true;

        app.setStatus(LoanState.INVALID_INCOME_EXPENSE_RATIO);
        return false;
    }

    public void setValidRatio(double validRatio) {
        this.validRatio = validRatio;
    }
}
