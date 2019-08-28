package com.company.clientservice.service;

import com.company.clientservice.model.Banking;
import com.company.clientservice.util.feign.BankingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankingService {
    @Autowired
    BankingClient client;

    public BankingService(BankingClient client) {
        this.client = client;
    }

    public Banking addFundsToAccount(Banking banking){
//        Banking tempBank = client.(100).get();
//      return tempBank.setCredit(tempBank.getCredit().add(banking.getCredit()));
       return client.addBanking(banking);
    }

    public Optional<Banking> getBankingById(int id) {
        return client.getBankingById(id);
    }
}
