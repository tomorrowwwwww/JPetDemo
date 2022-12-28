package csu.web.mypetstore.persistance.impl;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.persistance.AccountDao;
import csu.web.mypetstore.persistance.impl.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements AccountDao{
    private static final String UPDATE_ACCOUNT_STRING = "UPDATE ACCOUNT SET" +
            "      EMAIL = ?," +
            "      FIRSTNAME = ?," +
            "      LASTNAME = ?," +
            "      STATUS = ?," +
            "      ADDR1 = ?," +
            "      ADDR2 = ?," +
            "      CITY = ?," +
            "      STATE = ?," +
            "      ZIP = ?," +
            "      COUNTRY = ?," +
            "      PHONE = ?" +
            "    WHERE USERID = ?";

    private static final String UPDATE_PROFILE_STRING = "UPDATE PROFILE SET LANGPREF = ?, FAVCATEGORY = ? WHERE USERID = ?";
    private static final String UPDATE_SIGINON_STRING = "UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";

    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD="SELECT "+
            "SIGNON.USERNAME,"+
            "ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,"+
            "ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,"+
            "ACCOUNT.CITY, ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,"+
            "PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,"+
            "PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,"+
            "BANNERDATA.BANNERNAME "+
            "FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA "+
            "WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD= ? " +
            "AND SIGNON.USERNAME = ACCOUNT.USERID "+
            "AND PROFILE.USERID = ACCOUNT.USERID "+
            "AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private static final String INSERT_USER="INSERT INTO ACCOUNT"+
            "(USERID,EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE) "+
            "VALUES "+
            "(?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String INSERT_USER1="INSERT INTO SIGNON"+
            "(USERNAME,PASSWORD) "+
            "VALUES "+
            "(?,?)";

    private static final String INSERT_USER2="INSERT INTO PROFILE"+
            "(USERID,LANGPREF,FAVCATEGORY,MYLISTOPT,BANNEROPT) "+
            "VALUES "+
            "(?,?,?,?,?)";

    private static final String FIND_USER_BY_NAME="SELECT *FROM SIGNON WHERE username=?";

    @Override
    public Account getAccountByUsername(String username) {
        return null;
    }

    @Override
    public boolean findAccountByAccountName(String username){
        boolean result=false;
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_USER_BY_NAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("这是resultset的内容"+username);

            if(resultSet.next()){
                result=true;
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account accountResult=null;
        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println(account.getUsername()+" "+resultSet+"bbbbbbbbbb");
            if(resultSet.next()){
                accountResult=this.resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return accountResult;
    }

    @Override
    public boolean insertAccount(Account account) {
        boolean result=false;
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3,account.getFirstName());
            preparedStatement.setString(4,account.getLastName());
            preparedStatement.setString(5, account.getStatus());
            preparedStatement.setString(6,account.getAddress1());
            preparedStatement.setString(7,account.getAddress2());
            preparedStatement.setString(8,account.getCity());
            preparedStatement.setString(9, account.getState());
            preparedStatement.setString(10,account.getZip());
            preparedStatement.setString(11,account.getCountry());
            preparedStatement.setString(12,account.getPhone());


            int rows=preparedStatement.executeUpdate();

            if(rows==1){
                result =true;
            }
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertProfile(Account account) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement1=connection.prepareStatement(INSERT_USER2);
            System.out.println(account.getUsername()+"accountdaoimpl");
            preparedStatement1.setString(1, account.getUsername());
            preparedStatement1.setString(2,account.getLanguagePreference());
            preparedStatement1.setString(3, account.getFavouriteCategoryId());
            preparedStatement1.setString(4,account.getListOption());
            preparedStatement1.setString(5, account.getBannerOption());

            preparedStatement1.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement1);
            DBUtil.closeConnection(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account account) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement1=connection.prepareStatement(INSERT_USER1);
            preparedStatement1.setString(1, account.getUsername());
            preparedStatement1.setString(2,account.getPassword());

            preparedStatement1.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement1);
            DBUtil.closeConnection(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_STRING);
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getFirstName());
            preparedStatement.setString(3, account.getLastName());
            preparedStatement.setString(4, account.getStatus());
            preparedStatement.setString(5, account.getAddress1());
            preparedStatement.setString(6, account.getAddress2());
            preparedStatement.setString(7, account.getCity());
            preparedStatement.setString(8, account.getState());
            preparedStatement.setString(9, account.getZip());
            preparedStatement.setString(10, account.getCountry());
            preparedStatement.setString(11, account.getPhone());
            preparedStatement.setString(12, account.getUsername());
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateProfile(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFILE_STRING);
            preparedStatement.setString(1, account.getLanguagePreference());
            preparedStatement.setString(2, account.getFavouriteCategoryId());
            preparedStatement.setString(3, account.getUsername());
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignon(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SIGINON_STRING);
            preparedStatement.setString(1,account.getPassword());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Account resultSetToAccount(ResultSet resultSet) throws Exception{
        Account account = new Account();
        account.setUsername(resultSet.getString("username"));
        account.setPassword("null");
        account.setEmail(resultSet.getString("email"));
        account.setFirstName(resultSet.getString("firstname"));
        account.setLastName(resultSet.getString("lastname"));
        account.setStatus(resultSet.getString("status"));
        account.setAddress1(resultSet.getString("address1"));
        account.setAddress2(resultSet.getString("address2"));
        account.setCity(resultSet.getString("city"));
        account.setState(resultSet.getString("state"));
        account.setZip(resultSet.getString("zip"));
        account.setCountry(resultSet.getString("country"));
        account.setPhone(resultSet.getString("phone"));
        account.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
        account.setLanguagePreference(resultSet.getString("languagePreference"));
        account.setListOption(resultSet.getString("listOption"));
        account.setBannerOption(resultSet.getString("bannerOption"));
        account.setBannerName(resultSet.getString("bannerName"));
        System.out.println("这是userdaoimpl里的112行"+resultSet.getString("username"));
        return account;
    }

    public static void main(String[] args) {
        AccountDao accountDao =new AccountDaoImpl();
        Account account= new Account();
        account.setUsername("222");
        account.setPassword("222");
        Account result=accountDao.getAccountByUsernameAndPassword(account);
        System.out.println("success");
    }
}
