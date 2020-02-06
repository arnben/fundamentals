package com.vim.rulesengine.loanapp;

import com.vim.rulesengine.AbstractRule;

import java.util.List;

public class ValidStateRule extends AbstractRule {

    private List validStates;

    protected boolean makeDecision(Object arg) throws Exception {
        LoanApp app = (LoanApp) arg;
        if(validStates.contains(app.getStateCode())) {
            return true;
        }
        app.setStatus(LoanState.INVALID_STATE);
        return false;
    }

    public void setValidStates(List validStates) {
        this.validStates = validStates;
    }
}
