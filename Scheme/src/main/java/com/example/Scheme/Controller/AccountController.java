package com.example.Scheme.Controller;


import com.example.Scheme.Entity.Accountdetails;
import com.example.Scheme.Repository.AccountRepo;
import com.example.Scheme.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepo repo;

    @PostMapping("/register")
    public ResponseEntity<?>createaccount(@RequestBody Accountdetails account){

        String accountno=account.getAccountno();
        if(repo.findByAccountno(accountno).isPresent()){
            return new ResponseEntity<>("Account already exsists",HttpStatus.CONFLICT);
        }


        return new ResponseEntity<>(service.createaccount(account), HttpStatus.CREATED);
    }



 }
