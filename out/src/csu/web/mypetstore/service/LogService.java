package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Log;
import csu.web.mypetstore.persistance.LogDAO;
import csu.web.mypetstore.persistance.impl.LogDAOImpl;

public class LogService {
    Log log;
    private LogDAO logDAO;

    public LogService(){
        log = new Log();
        logDAO = (LogDAO) new LogDAOImpl();
    }

    public String logInfo(Object... s){
        return log.logInfomation(s);
    }

    public void insertLogInfo(String username, String time,String page,String ps){
        logDAO.insertLog(username, time,page,ps);
    }
}

