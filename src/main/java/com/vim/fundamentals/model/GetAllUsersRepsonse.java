package com.vim.fundamentals.model;

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
