package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.persistance.AccountDao;
import csu.web.mypetstore.persistance.impl.AccountDaoImpl;

public class AccountService {

    private AccountDao accountDao;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    private String Msg;

    public AccountService() {
        this.accountDao = (AccountDao) new AccountDaoImpl();
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDao.getAccountByUsernameAndPassword(account);
    }

    public boolean addAccount(Account registerUser) {
        String username = registerUser.getUsername();
        if (accountDao.findAccountByAccountName(username)) {
            this.setMsg("用户名已存在");
            return false;
        }
        accountDao.insertSignon(registerUser);
        accountDao.insertProfile(registerUser);
        return accountDao.insertAccount(registerUser);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
        accountDao.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountDao.updateSignon(account);
        }
    }
}

