package com.vim.fundamentals.repository;

import com.vim.fundamentals.model.FunduUser;
import org.springframework.data.repository.CrudRepository;

public interface FunduRepository extends CrudRepository<FunduUser, Long> {

}
