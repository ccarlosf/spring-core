package com.ccarlos.edu.dao;


import com.ccarlos.edu.pojo.Account;

public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}
