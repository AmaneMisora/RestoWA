package com.restowa.bl.concrete;

import com.restowa.domain.model.UserAccount;
import com.restowa.domain.repository.UserAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountManager {
    
    private UserAccountRepository repo;
    
    @Autowired
    public UserAccountManager(UserAccountRepository uarepo) {
        this.repo = uarepo;
    }
    
    public UserAccount getUserAccountById(int id) {
        return this.repo.findById(id).get();
    }
    
    public UserAccount saveUserAccount(UserAccount ua) {
        return this.repo.save(ua);
    }
    
    public List<UserAccount> getUserAccountByEmail(String email) {
        return this.repo.getUserAccountByEmail(email);
    }
    
    public boolean checkLogin(String email, String password) {
        return this.repo.checkLogin(email, password);
    }
}
