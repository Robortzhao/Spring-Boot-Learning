package com.springbootlearning.beatsql.controller;

import com.springbootlearning.beatsql.dao.AccountDao;
import com.springbootlearning.beatsql.entity.Account;
import org.beetl.sql.core.db.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "/selectAccountList",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountDao.all();
    }

    @RequestMapping(value = "/selectAccountById",method = RequestMethod.GET)
    public  Account getAccountById(@RequestParam(value="id") int id){
        return accountDao.unique(id);
    }

    @RequestMapping(value = "selectAccountByName",method = RequestMethod.GET)
    public  Account getAccountById(@RequestParam("name") String name){
        return accountDao.selectAccountByName(name);
    }

    @RequestMapping(value = "/updateAccount",method = RequestMethod.PUT)
    public  String updateAccount(@RequestParam(value="id") int id, @RequestParam(value = "name")String name,
                                 @RequestParam(value = "money")double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountDao.updateById(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/addAccount",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        KeyHolder t = accountDao.insertReturnKey(account);
        if (t.getInt() > 0) {
            return account.toString();
        } else {
            return "fail";
        }
    }


}
