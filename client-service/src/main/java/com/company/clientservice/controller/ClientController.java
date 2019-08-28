package com.company.clientservice.controller;

import com.company.clientservice.model.Banking;
import com.company.clientservice.util.feign.BankingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class ClientController {

    @Autowired
    BankingClient client;

    @PostMapping("/addfunds")
    public Banking createBanking(@RequestBody Banking banking) {
        return client.addBanking(banking);
    }

    @GetMapping("/{accountnumber}")
    public Optional<Banking> getBanking(@PathVariable("accountnumber") int accountNumber) {
        return client.getBankingById(accountNumber);
    }
}
