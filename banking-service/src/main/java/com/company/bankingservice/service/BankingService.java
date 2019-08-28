package com.company.bankingservice.service;

import com.company.bankingservice.model.Banking;
import com.company.bankingservice.repository.BankingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankingService {
    @Autowired
    BankingRepo repo;

    public BankingService(BankingRepo repo) {
        this.repo = repo;
    }

    public Banking addFundsToAccount(Banking banking){
        Banking tempBank = repo.findById(100).get();
        tempBank.setCredit(tempBank.getCredit().add(banking.getCredit()));
        return banking;
    }
}
