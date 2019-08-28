package com.company.clientservice.util.feign;


import com.company.clientservice.model.Banking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("banking-service")
public interface BankingClient {

    @RequestMapping(value = "/account/addfunds",method = RequestMethod.POST)
    public Banking addBanking(@RequestBody Banking banking);


    @GetMapping("/account/{id}")
    public Optional<Banking> getBankingById(@PathVariable int id);

//    @RequestMapping(value = "/account/balance/{accountnumber}", method = RequestMethod.GET)
//    public List<Banking> getBankingByAccountNumber(@PathVariable("accountnumber") String accountNumber);
}
