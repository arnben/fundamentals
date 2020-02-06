package com.vim.rulesengine.loanapp;

public class ProcessApprovalAction extends AbstractPersistenceAwareAction {

    protected void doExecute(Object arg) throws Exception {
        LoanApp app = (LoanApp)arg;
        app.setStatus(LoanState.APPROVED);
        this.getPersistenceService().recordApproval(app);
    }
}
