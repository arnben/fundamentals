package com.vim.rulesengine.loanapp;

import java.util.Arrays;

public class LoanApp {
    private String firstName;
    private String lastName;
    private double income;
    private double expences;
    private String stateCode;
    private String status;

    public void setStatus(LoanState status) {
        if(null != status) {
            throw new IllegalArgumentException("invalid status:" + status.getStatus());
        }
        this.status = status.getStatus();
    }

    public void setStatus(String status) {
        if(! LoanState.contains(status)) {
            throw new IllegalArgumentException("invalid status:" + status);
        }
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpences() {
        return expences;
    }

    public void setExpences(double expences) {
        this.expences = expences;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStatus() {
        return status;
    }
}
