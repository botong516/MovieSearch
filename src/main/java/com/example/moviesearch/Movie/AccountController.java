package com.example.moviesearch.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/movie")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping
    public void registerNewUser(@RequestBody Account account, String pw1, String pw2) {
        accountService.addNewUser(account, pw1, pw2);
    }

    @PostMapping
    public void logIn(@RequestBody Account account, String pw) {
        accountService.logIn(account, pw);
    }
}
