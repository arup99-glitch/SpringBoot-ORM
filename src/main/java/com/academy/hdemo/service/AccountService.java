package com.academy.hdemo.service;


import com.academy.hdemo.dao.AccountDAO;
import com.academy.hdemo.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    @Qualifier("AccountDAOImp2")
    AccountDAO accountDAO;

    public Account findById(long id) {
        return accountDAO.findByAccountId(id);
    }

    public void saveAccount(Account account) {
        accountDAO.save(account);
    }

    public void update(Account account) {
        accountDAO.update(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.delete(account);

    }

    public List getAllAccounts() {
        return accountDAO.accountList();
    }

    public void transfer(Map<String, Long> details) {
        Long sender = details.get("fromAmount");
        Long receiver = details.get("toAmount");
        Long amount = details.get("transfer");



            if (sender != null ) {
                long currentSenderAmount = accountDAO.findByAccountId(sender).getBalance();
                long newSenderAmount = currentSenderAmount - amount;
                accountDAO.findByAccountId(sender).setBalance(newSenderAmount);
                accountDAO.update(accountDAO.findByAccountId(sender));

                long currentReceiverAmount = accountDAO.findByAccountId(receiver).getBalance();
                long newReceiverAmount = currentReceiverAmount + amount;
                accountDAO.findByAccountId(receiver).setBalance(newReceiverAmount);
                accountDAO.update(accountDAO.findByAccountId(receiver));

            } else {
                System.out.println("Sorry ");
            }
        }

    }
}
