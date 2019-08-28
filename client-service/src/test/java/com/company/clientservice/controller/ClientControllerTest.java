package com.company.clientservice.controller;

import com.company.clientservice.model.Banking;
import com.company.clientservice.service.BankingService;
import com.company.clientservice.util.feign.BankingClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientControllerTest {

    @MockBean
    BankingService service;

    @Mock
    BankingClient client;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private String bankingCostJson;

    @Before
    public void setUp() {

        service = new BankingService(client);

    }


        @Test
    public void shouldAddFundsToAccount() {
        Banking banking = new Banking();
        banking.setId(100);
        banking.setCredit(BigDecimal.valueOf(50.00).setScale(2));

        Banking banking1 = new Banking();
        banking1.setId(100);
        banking1.setCredit(BigDecimal.valueOf(50.00).setScale(2));

        List<Banking> bankingList = new ArrayList<>();
        bankingList.add(banking);
        bankingList.add(banking1);
//
//        when(client.addBanking(banking)).thenReturn(banking);
//        banking = client.addBanking(banking);
//        verify(client,times(1)).addBanking(banking);
//
//        Banking clientAccount = client.addBanking(new Banking(100, BigDecimal.valueOf(50.00)));
    }

    @Test
    public void shouldGetAccountById(){
        Banking banking = new Banking();
        banking.setId(100);
        banking.setCredit(BigDecimal.valueOf(50.00).setScale(2));

//        verify(client,times(1)).getBankingById(100);



    }
}