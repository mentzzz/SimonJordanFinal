package com.company.bankingservice.service;

import com.company.bankingservice.model.Banking;
import com.company.bankingservice.repository.BankingRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BankingServiceTest {

    @Mock
    BankingRepo repo;

    @InjectMocks
    BankingService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addFundsToAccount() {
        Banking banking = new Banking();
        banking.setId(100);
        banking.setCredit(BigDecimal.valueOf(500.00).setScale(2));

        when(repo.findById(100)).thenReturn(java.util.Optional.of(banking));

        Banking newTransaction = new Banking(100, BigDecimal.valueOf(50.00));

        Banking banking1 = service.addFundsToAccount(newTransaction);

        assertEquals(banking.getCredit(),BigDecimal.valueOf(550).setScale(2));
    }
}