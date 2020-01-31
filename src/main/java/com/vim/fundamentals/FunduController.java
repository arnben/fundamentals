package com.vim.fundamentals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunduController {

    @GetMapping (value = "/home")
    public FunduResponse getHome() {
        FunduResponse fundu = new FunduResponse();
        fundu.setMessage("Hello");
        return fundu;
    }
}
