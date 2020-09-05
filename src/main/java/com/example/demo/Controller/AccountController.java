package com.example.demo.Controller;

import com.example.demo.Domain.Account;
import com.example.demo.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity account(Account account){
        HttpStatus resultHttpStatus = accountService.account(account);
        return ResponseEntity.status(resultHttpStatus)
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity login(String userId, String password, String type){
        HttpStatus resultHttpStatus = accountService.login(userId, password, type);

        return ResponseEntity.status(resultHttpStatus)
                .build();
    }
}