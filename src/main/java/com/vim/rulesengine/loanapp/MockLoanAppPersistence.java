package com.vim.rulesengine.loanapp;

public class MockLoanAppPersistence implements LoanAppPersistenceInterface {

    private static String MSG_FORMAT = "%s for %s %s.\nLoan Status : %s";

    public void recordApproval(LoanApp app) throws Exception {
        System.out.println(constructMsg("Loan application is approval.", app));
    }

    public void recordRejection(LoanApp app) throws Exception {
        System.out.println(constructMsg("Loan application is rejected.", app));
    }

    public void recordIncomplete(LoanApp app) throws Exception {
        System.out.println(constructMsg("Loan application is incomplete.", app));
    }

    private String constructMsg(String msgText, LoanApp app) {
        return String.format(MSG_FORMAT, msgText, app.getFirstName(), app.getLastName(), app.getStatus());
    }
}
