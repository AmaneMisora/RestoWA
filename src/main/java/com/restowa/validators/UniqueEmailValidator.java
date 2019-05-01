/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.validators;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author yanis
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailConstraint, String> {
 
    @Resource
    UserAccountManager uamanager;
    
    @Override
    public void initialize(UniqueEmailConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {

        List<UserAccount> userAccounts = uamanager.getUserAccountByEmail(email);
        if(userAccounts.isEmpty())
            return true;
        else
            return false;
        }
 
}