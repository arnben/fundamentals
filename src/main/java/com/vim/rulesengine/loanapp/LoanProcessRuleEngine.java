package com.vim.rulesengine.loanapp;

import com.vim.rulesengine.SpringRuleEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoanProcessRuleEngine extends SpringRuleEngine {
    public static final SpringRuleEngine getEngine(String name) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("rulesengine/SpringRuleEngineContext.xml");
        return (SpringRuleEngine) context.getBean(name);
    }
}
