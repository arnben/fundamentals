package com.vim.rulesengine.loanapp;

public interface LoanAppPersistenceInterface {
    public void recordApproval(LoanApp app) throws Exception;
    public void recordRejection(LoanApp app) throws Exception;
    public void recordIncomplete(LoanApp app) throws Exception;
}
