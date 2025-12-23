package com.example.Scheme.Service;

import com.example.Scheme.Entity.Accountdetails;
import com.example.Scheme.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Accountdetails createaccount(Accountdetails accounts){

       if(accounts.getAmount()<50000){
           throw new IllegalArgumentException("Amount should be above Fifty Thousand");
       }
        return accountRepo.save(accounts);
    }

     @Transactional
    public void updateInterestForAllAccounts() {

        List<Accountdetails> accounts =
                accountRepo.findAllByOrderByCreatedAtAsc();

        LocalDate today = LocalDate.now();

        for (Accountdetails acc : accounts) {

            LocalDate createdDate = acc.getCreatedAt().toLocalDate();

            if (today.getDayOfMonth() != createdDate.getDayOfMonth()) {
                continue;
            }
            if (acc.getLastInterestAppliedDate() != null &&
                    acc.getLastInterestAppliedDate().getMonth() == today.getMonth() &&
                    acc.getLastInterestAppliedDate().getYear() == today.getYear()) {
                continue;
            }

            double amount = acc.getAmount();
            double interest = amount * 5 / 100;
            acc.setAmount(amount + interest);
            acc.setLastInterestAppliedDate(today);
        }

        accountRepo.saveAll(accounts);
    }
}
