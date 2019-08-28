package com.company.bankingservice.controller;

import com.company.bankingservice.model.Banking;
import com.company.bankingservice.repository.BankingRepo;
import com.company.bankingservice.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class BankingController {
    @Autowired
    BankingRepo repo;
    @Autowired
    BankingService service;

    @PostMapping("/addfunds")
    public Banking createBanking(@RequestBody Banking banking) {
        return service.addFundsToAccount(banking);
    }

//    @GetMapping("/balance/{accountnumber}")
////    public List<Banking> getBankingByAccountNumber(@PathVariable("id") String accountNumber) {
////        return null;
////    }

    @GetMapping("/{id}")
    public Optional<Banking> getBankingById(@PathVariable int id){
        return repo.findById(id);
    }

}
