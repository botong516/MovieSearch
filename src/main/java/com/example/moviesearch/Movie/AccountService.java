package com.example.moviesearch.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void addNewUser(Account account, String pw1, String pw2) {
        Optional<Account> accountOptional =
                accountRepository.findAccountByUsername(account.getUsername());
        if (accountOptional.isPresent()) {
            throw new IllegalStateException("username taken");
        } else if (!pw1.equals(pw2)) {
            throw new IllegalStateException("password inconsistent");
        }

        accountRepository.save(account);
    }

    public Account logIn(Account account, String pw) {
        Optional<Account> accountOptional =
                accountRepository.findAccountByUsername(account.getUsername());
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException("username not exist");
        }
        if (!account.getPassword().equals(pw)) {
            throw new IllegalStateException("wrong password");
        }

        return account;
    }
}
