package com.example.demo.Controller;

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

    @PostMapping("/login")
    public ResponseEntity login(String userId, String password){
        HttpStatus resultHttpStatus = accountService.login(userId, password);
        
        return ResponseEntity.status(resultHttpStatus)
                .build();
    }
}
