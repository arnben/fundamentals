package com.vim.rulesengine.loanapp;

public class ProcessRejectionAction extends AbstractPersistenceAwareAction {
    protected void doExecute(Object arg) throws Exception {
        LoanApp app = (LoanApp) arg;
        if(LoanState.INSUFFICIENT_DATA.getStatus().equals(app.getStatus()))
            this.getPersistenceService().recordIncomplete(app);
        else
            this.getPersistenceService().recordRejection(app);
    }
}
