package com.vim.rulesengine.loanapp;

public enum LoanState {
    INVALID_STATE("Sorry we are not doing business in your state"),
    INVALID_INCOME_EXPENSE_RATIO("Sorry we cannot provide the loan given this expense/income ratio"),
    APPROVED("Your application has been approved"),
    INSUFFICIENT_DATA("You did not provide enough information on your application"),
    INPROGRESS("in progress");

    private String status;

    private LoanState(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
