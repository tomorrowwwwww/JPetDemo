//package csu.web.mypetstore.persistance;
//
//public class AccountDao {
//}
package csu.web.mypetstore.persistance;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import csu.web.mypetstore.domain.Account;

public interface AccountDao {
    Account getAccountByUsername(String username);


    Account getAccountByUsernameAndPassword(Account account);


    public boolean insertAccount(Account account);

    public boolean findAccountByAccountName(String username);

    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);
}

