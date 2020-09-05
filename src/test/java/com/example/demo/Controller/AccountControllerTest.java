package com.example.demo.Controller;

import com.example.demo.Domain.Account;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountControllerTest {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @Test
    void account() throws Exception {
        Account account = Account.builder()
                .userId("test1")
                .password("test1")
                .build();

        accountService.account(account);

        Account account1 = accountRepository.findByUserId(account.getUserId()).orElseThrow(Exception::new);

        System.out.println(account);
        System.out.println(account1);
        assertThat(account.getUserId()).isEqualTo(account1.getUserId());
    }
}