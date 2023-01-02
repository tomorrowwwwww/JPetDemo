package csu.web.mypetstore.persistance;

public interface LogDAO {
    void insertLog(String username,String time,String page,String ps);
}
