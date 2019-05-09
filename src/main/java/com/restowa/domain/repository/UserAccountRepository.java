
package com.restowa.domain.repository;

import com.restowa.domain.model.UserAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    
    List<UserAccount> getUserAccountByEmail(String email);
    
}