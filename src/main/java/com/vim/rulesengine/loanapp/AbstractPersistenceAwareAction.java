package com.vim.rulesengine.loanapp;

import com.vim.rulesengine.AbstractAction;

public abstract class AbstractPersistenceAwareAction extends AbstractAction {

    private LoanAppPersistenceInterface persistenceService;

    public void setPersistenceService(LoanAppPersistenceInterface persistenceService) {
        this.persistenceService = persistenceService;
    }

    public LoanAppPersistenceInterface getPersistenceService() {
        return persistenceService;
    }
}
