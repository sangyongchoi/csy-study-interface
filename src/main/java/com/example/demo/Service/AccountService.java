package com.example.demo.Service;

import com.example.demo.Domain.Account;
import com.example.demo.Error.Code.ErrorCode;
import com.example.demo.Error.CoreExceptionONE;
import com.example.demo.Repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public HttpStatus account(Account account){
        try {
            accountRepository.save(account);
            return HttpStatus.OK;
        }catch (Exception e){
            throw e;
        }
    }

    public HttpStatus login(String userId, String password) {
        Account user = accountRepository.findByUserId(userId).orElseThrow(() -> new CoreExceptionONE(ErrorCode.ERROR_ONE));
        if (password.equals(user.getPassword())) {
            return HttpStatus.OK;
        } else {
            throw new CoreExceptionONE(ErrorCode.ERROR_ONE);
        }
    }
}
