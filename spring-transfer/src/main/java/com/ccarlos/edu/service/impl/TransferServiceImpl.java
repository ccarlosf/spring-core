package com.ccarlos.edu.service.impl;

import com.ccarlos.edu.dao.AccountDao;
import com.ccarlos.edu.dao.impl.JdbcAccountDaoImpl;
import com.ccarlos.edu.pojo.Account;
import com.ccarlos.edu.service.TransferService;

public class TransferServiceImpl implements TransferService {
    //    private AccountDao accountDao = new JdbcAccountDaoImpl();

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money)
            throws Exception {
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);
        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);
        accountDao.updateAccountByCardNo(from);
        accountDao.updateAccountByCardNo(to);
    }
}
