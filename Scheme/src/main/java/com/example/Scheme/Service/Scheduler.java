package com.example.Scheme.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {


    @Autowired
    private AccountService service;

    public void run(){
        service.updateInterestForAllAccounts();
    }
}
