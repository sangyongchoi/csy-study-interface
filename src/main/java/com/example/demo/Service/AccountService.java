package com.example.demo.Service;

import com.example.demo.Domain.Account;
import com.example.demo.Domain.UserLog;
import com.example.demo.Error.Code.ErrorCode;
import com.example.demo.Error.CoreExceptionONE;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.UserLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserLogRepository userLogRepository;

    public AccountService(AccountRepository accountRepository, UserLogRepository userLogRepository) {
        this.accountRepository = accountRepository;
        this.userLogRepository = userLogRepository;
    }

    public HttpStatus account(Account account){
        try {
            accountRepository.save(account);
            return HttpStatus.OK;
        }catch (Exception e){
            throw e;
        }
    }

    public HttpStatus login(String userId, String password, String type) {
        if("kakao".equals(type)){
            HttpStatus resultStatus = kakaoLogin(userId);
            return resultStatus;
        }else{
            HttpStatus resultStatus = defaultLogin(userId, password);
            return resultStatus;
        }
    }

    private HttpStatus kakaoLogin(String userId){
        Account user = accountRepository.findByUserId(userId).orElseThrow(() -> new CoreExceptionONE(ErrorCode.ERROR_ONE));
        insertSocialLoginLog(userId);

        return HttpStatus.OK;
    }

    private HttpStatus defaultLogin(String userId, String password){
        Account user = accountRepository.findByUserId(userId).orElseThrow(() -> new CoreExceptionONE(ErrorCode.ERROR_ONE));
        if (password.equals(user.getPassword())) {
            return HttpStatus.OK;
        } else {
            throw new CoreExceptionONE(ErrorCode.ERROR_ONE);
        }
    }

    private void insertSocialLoginLog(String userId){
        UserLog userLog = UserLog.builder()
                .userId(userId)
                .loginDate(LocalDateTime.now())
                .build();

        userLogRepository.save(userLog);
    }
}
