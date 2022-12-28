package csu.web.mypetstore.persistance.impl;

import csu.web.mypetstore.persistance.LogDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogDAOImpl implements LogDAO {
    private static final String insertLog ="insert into log(logUserId,logInfo) values(?,?)";
    private static final String searchUsername ="select logUserId from log where logUserId=? ";

    @Override
    public void insertLog(String username, String logInfo) {

        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement(searchUsername);
//            preparedStatement.setString(1, username);
//            boolean isExist = preparedStatement.execute();
//            if (isExist) {
            preparedStatement=connection.prepareStatement(insertLog);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, logInfo);
            int result = preparedStatement.executeUpdate();

            if (result == 1) {
                System.out.println("插入成功!");
            } else {
                System.out.println("插入失败!");
            }

//            } else {
//                preparedStatement = connection.prepareStatement(insertLog);
//                preparedStatement.setString(1, username);
//                preparedStatement.setString(2, logInfo);
//                int result = preparedStatement.executeUpdate();
//
//                if (result == 1) {
//                    System.out.println("插入成功!");
//                } else {
//                    System.out.println("插入失败!");
//                }
//            }

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch(Exception e){
            e.printStackTrace();
        }


    }
}
