package com.vim.fundamentals.controller;

import com.vim.fundamentals.model.FunduUser;

public class GetAllUsersRepsonse {
    private Iterable<FunduUser> users;

    public Iterable<FunduUser> getUsers() {
        return users;
    }

    public void setUsers(Iterable<FunduUser> users) {
        this.users = users;
    }

    public GetAllUsersRepsonse(Iterable<FunduUser> users) {
        this.users = users;
    }
}
