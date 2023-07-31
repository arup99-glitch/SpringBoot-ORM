package com.academy.hdemo.controller;

import com.academy.hdemo.dto.Account;
import com.academy.hdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/detail")
    public Account detail(@RequestParam long accountId) {

        return accountService.findById(accountId);
    }

    @GetMapping("/detail/{id}")
    public Account detail(@PathVariable int id) {
        return accountService.findById(id);
    }
    @GetMapping("/getAllAccount")
    public List<Account> getAllAccount(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/new")
    public void newAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

    @PutMapping
    void updateAccount(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@RequestBody Account account) {
        accountService.deleteAccount(account);
    }

    @GetMapping("/transaction")
    void transaction(@RequestBody Account account){

    }

    @GetMapping()
    public List allAccount() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/transfer")
        void transfer(@RequestBody Map<String, Long>details){
        accountService.transfer(details);

    }


}
