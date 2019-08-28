package com.company.bankingservice.controller;

import com.company.bankingservice.model.Banking;
import com.company.bankingservice.repository.BankingRepo;
import com.company.bankingservice.service.BankingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BankingController.class)
public class BankingControllerTest {

    @MockBean
    BankingRepo repo;

    @MockBean
    BankingService service;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private String bankingCostJson;

//    private Banking banking;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void shouldGetBankingById100Banking() throws Exception {
        Banking banking = new Banking();
        banking.setCredit(BigDecimal.valueOf(50.00).setScale(2));
        banking.setId(100);

        bankingCostJson= mapper.writeValueAsString(banking);

        when(repo.findById(100)).thenReturn(java.util.Optional.of(banking));

        mockMvc.perform(MockMvcRequestBuilders.get("/account/100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(bankingCostJson));
    }

    @Test
    public void shouldCreateBanking() throws Exception {
        Banking banking = new Banking();
        banking.setCredit(BigDecimal.valueOf(50.00).setScale(2));
        banking.setId(100);

//        bankingCostJson = mapper.writeValueAsString(banking);
when(repo.save(banking)).thenReturn(banking);
//        Mockito.when(repo.getBankingByAccountNumber("100")).thenReturn(banking);

        Banking output= new Banking();
        output.setCredit(BigDecimal.valueOf(50.00).setScale(2));
        output.setId(100);

        String inputJson = mapper.writeValueAsString(banking);

        when(repo.save(banking)).thenReturn(output);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/addfunds")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(output)));


    }
}