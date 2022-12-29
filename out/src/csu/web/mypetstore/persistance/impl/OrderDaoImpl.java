package csu.web.mypetstore.persistance.impl;

import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.persistance.OrderDao;
import csu.web.mypetstore.persistance.impl.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao
{
    private static final String getOrdersByUsernameString =
            "SELECT * FROM ORDERS WHERE ORDERS.USERID = ? ";

    private static final String getOrderString =
            "select * FROM ORDERS WHERE ORDERS.ORDERID = ?  ";

    private static final String insertOrderString =
            "INSERT INTO ORDERS ( USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE,\n" +
                    "      SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY,\n" +
                    "      COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME,\n" +
                    "      CREDITCARD, EXPRDATE, CARDTYPE, LOCALE)\n" +
                    "    VALUES( ?,?, ?, ?, ?,\n" +
                    "      ?, ?, ?, ?, ?, ?,\n" +
                    "      ?, ?, ?, ?, ?, ?, ?,\n" +
                    "     ?, ?, ?, ?, ?, ?)";

//    private static final String insertOrderStatusString =
//            " INSERT INTO ORDERSTATUS (ORDERID, LINENUM, TIMESTAMP, STATUS)\n" +
//                    "    VALUES (?, ?, ?, ?)";

    @Override
    public List<Order> getOrdersByUsername(String username) {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getOrdersByUsernameString);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setUsername(resultSet.getString(2));
                order.setOrderDate(resultSet.getDate(3));
                order.setShipAddress1(resultSet.getString(4));
                order.setShipAddress2(resultSet.getString(5));
                order.setShipCity(resultSet.getString(6));
                order.setShipState(resultSet.getString(7));
                order.setShipZip(resultSet.getString(8));
                order.setShipCountry(resultSet.getString(9));
                order.setBillAddress1(resultSet.getString(10));
                order.setBillAddress2(resultSet.getString(11));
                order.setBillCity(resultSet.getString(12));
                order.setBillState(resultSet.getString(13));
                order.setBillZip(resultSet.getString(14));
                order.setBillCountry(resultSet.getString(15));
                order.setCourier(resultSet.getString(16));
                order.setTotalPrice(resultSet.getBigDecimal(17));
                order.setBillToFirstName(resultSet.getString(18));
                order.setBillToLastName(resultSet.getString(19));
                order.setShipToFirstName(resultSet.getString(20));
                order.setShipToLastName(resultSet.getString(21));
                order.setCreditCard(resultSet.getString(22));
                order.setExpiryDate(resultSet.getString(23));
                order.setCardType(resultSet.getString(24));
                order.setLocale(resultSet.getString(25));
                orderList.add(order);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order getOrder(int orderId) {
        Order order  = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getOrderString);
            preparedStatement.setInt(1,orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                order = new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setUsername(resultSet.getString(2));
                order.setOrderDate(resultSet.getDate(3));
                order.setShipAddress1(resultSet.getString(4));
                order.setShipAddress2(resultSet.getString(5));
                order.setShipCity(resultSet.getString(6));
                order.setShipState(resultSet.getString(7));
                order.setShipZip(resultSet.getString(8));
                order.setShipCountry(resultSet.getString(9));
                order.setBillAddress1(resultSet.getString(10));
                order.setBillAddress2(resultSet.getString(11));
                order.setBillCity(resultSet.getString(12));
                order.setBillState(resultSet.getString(13));
                order.setBillZip(resultSet.getString(14));
                order.setBillCountry(resultSet.getString(15));
                order.setCourier(resultSet.getString(16));
                order.setTotalPrice(resultSet.getBigDecimal(17));
                order.setBillToFirstName(resultSet.getString(18));
                order.setBillToLastName(resultSet.getString(19));
                order.setShipToFirstName(resultSet.getString(20));
                order.setShipToLastName(resultSet.getString(21));
                order.setCreditCard(resultSet.getString(22));
                order.setExpiryDate(resultSet.getString(23));
                order.setCardType(resultSet.getString(24));
                order.setLocale(resultSet.getString(25));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void insertOrder(Order order) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertOrderString,Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,order.getUsername());
            preparedStatement.setTimestamp(2, new Timestamp(order.getOrderDate().getTime()));
            preparedStatement.setString(3,order.getShipAddress1());
            preparedStatement.setString(4,order.getShipAddress2());
            preparedStatement.setString(5,order.getShipCity());
            preparedStatement.setString(6,order.getShipState());
            preparedStatement.setString(7,order.getShipZip());
            preparedStatement.setString(8,order.getShipCountry());
            preparedStatement.setString(9,order.getBillAddress1());
            preparedStatement.setString(10,order.getBillAddress2());
            preparedStatement.setString(11,order.getBillCity());
            preparedStatement.setString(12,order.getBillState());
            preparedStatement.setString(13,order.getBillZip());
            preparedStatement.setString(14,order.getBillCountry());
            preparedStatement.setString(15,order.getCourier());
            preparedStatement.setBigDecimal(16,order.getTotalPrice());
            preparedStatement.setString(17,order.getBillToFirstName());
            preparedStatement.setString(18,order.getBillToLastName());
            preparedStatement.setString(19,order.getShipToFirstName());
            preparedStatement.setString(20,order.getShipToLastName());
            preparedStatement.setString(21,order.getCreditCard());
            preparedStatement.setString(22,order.getExpiryDate());
            preparedStatement.setString(23,order.getCardType());
            preparedStatement.setString(24,order.getLocale());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                order.setOrderId(resultSet.getInt(1));
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);


        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    private static final String getOrdersByUsernameString =
//            "SELECT * FROM ORDERS WHERE ORDERS.USERID = ? ";
//
//    private static final String getOrderString =
//            "select * FROM ORDERS WHERE ORDERS.ORDERID = ?  ";
//
//    private static final String insertOrderString =
//            "INSERT INTO ORDERS ( USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE,\n" +
//                    "      SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY,\n" +
//                    "      COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME,\n" +
//                    "      CREDITCARD, EXPRDATE, CARDTYPE, LOCALE)\n" +
//                    "    VALUES( ?,?, ?, ?, ?,\n" +
//                    "      ?, ?, ?, ?, ?, ?,\n" +
//                    "      ?, ?, ?, ?, ?, ?, ?,\n" +
//                    "     ?, ?, ?, ?, ?, ?)";
//
////    private static final String insertOrderStatusString =
////            " INSERT INTO ORDERSTATUS (ORDERID, LINENUM, TIMESTAMP, STATUS)\n" +
////                    "    VALUES (?, ?, ?, ?)";
//
//    @Override
//    public List<Order> getOrdersByUsername(String username) {
//        List<Order> orderList = new ArrayList<>();
//        try {
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(getOrdersByUsernameString);
//            preparedStatement.setString(1,username);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Order order = new Order();
//                order.setOrderId(resultSet.getInt(1));
//                order.setUsername(resultSet.getString(2));
//                order.setOrderDate(resultSet.getDate(3));
//                order.setShipAddress1(resultSet.getString(4));
//                order.setShipAddress2(resultSet.getString(5));
//                order.setShipCity(resultSet.getString(6));
//                order.setShipState(resultSet.getString(7));
//                order.setShipZip(resultSet.getString(8));
//                order.setShipCountry(resultSet.getString(9));
//                order.setBillAddress1(resultSet.getString(10));
//                order.setBillAddress2(resultSet.getString(11));
//                order.setBillCity(resultSet.getString(12));
//                order.setBillState(resultSet.getString(13));
//                order.setBillZip(resultSet.getString(14));
//                order.setBillCountry(resultSet.getString(15));
//                order.setCourier(resultSet.getString(16));
//                order.setTotalPrice(resultSet.getBigDecimal(17));
//                order.setBillToFirstName(resultSet.getString(18));
//                order.setBillToLastName(resultSet.getString(19));
//                order.setShipToFirstName(resultSet.getString(20));
//                order.setShipToLastName(resultSet.getString(21));
//                order.setCreditCard(resultSet.getString(22));
//                order.setExpiryDate(resultSet.getString(23));
//                order.setCardType(resultSet.getString(24));
//                order.setLocale(resultSet.getString(25));
//                orderList.add(order);
//            }
//            DBUtil.closeResultSet(resultSet);
//            DBUtil.closePreparedStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return orderList;
//    }
//
//    @Override
//    public Order getOrder(int orderId) {
//        Order order  = null;
//        try{
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(getOrderString);
//            preparedStatement.setInt(1,orderId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                order = new Order();
//                order.setOrderId(resultSet.getInt(1));
//                order.setUsername(resultSet.getString(2));
//                order.setOrderDate(resultSet.getDate(3));
//                order.setShipAddress1(resultSet.getString(4));
//                order.setShipAddress2(resultSet.getString(5));
//                order.setShipCity(resultSet.getString(6));
//                order.setShipState(resultSet.getString(7));
//                order.setShipZip(resultSet.getString(8));
//                order.setShipCountry(resultSet.getString(9));
//                order.setBillAddress1(resultSet.getString(10));
//                order.setBillAddress2(resultSet.getString(11));
//                order.setBillCity(resultSet.getString(12));
//                order.setBillState(resultSet.getString(13));
//                order.setBillZip(resultSet.getString(14));
//                order.setBillCountry(resultSet.getString(15));
//                order.setCourier(resultSet.getString(16));
//                order.setTotalPrice(resultSet.getBigDecimal(17));
//                order.setBillToFirstName(resultSet.getString(18));
//                order.setBillToLastName(resultSet.getString(19));
//                order.setShipToFirstName(resultSet.getString(20));
//                order.setShipToLastName(resultSet.getString(21));
//                order.setCreditCard(resultSet.getString(22));
//                order.setExpiryDate(resultSet.getString(23));
//                order.setCardType(resultSet.getString(24));
//                order.setLocale(resultSet.getString(25));
//            }
//            DBUtil.closeResultSet(resultSet);
//            DBUtil.closePreparedStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return order;
//    }
//
//    @Override
//    public void insertOrder(Order order) {
//        try {
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(insertOrderString,Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1,order.getUsername());
//            preparedStatement.setTimestamp(2, new Timestamp(order.getOrderDate().getTime()));
//            preparedStatement.setString(3,order.getShipAddress1());
//            preparedStatement.setString(4,order.getShipAddress2());
//            preparedStatement.setString(5,order.getShipCity());
//            preparedStatement.setString(6,order.getShipState());
//            preparedStatement.setString(7,order.getShipZip());
//            preparedStatement.setString(8,order.getShipCountry());
//            preparedStatement.setString(9,order.getBillAddress1());
//            preparedStatement.setString(10,order.getBillAddress2());
//            preparedStatement.setString(11,order.getBillCity());
//            preparedStatement.setString(12,order.getBillState());
//            preparedStatement.setString(13,order.getBillZip());
//            preparedStatement.setString(14,order.getBillCountry());
//            preparedStatement.setString(15,order.getCourier());
//            preparedStatement.setBigDecimal(16,order.getTotalPrice());
//            preparedStatement.setString(17,order.getBillToFirstName());
//            preparedStatement.setString(18,order.getBillToLastName());
//            preparedStatement.setString(19,order.getShipToFirstName());
//            preparedStatement.setString(20,order.getShipToLastName());
//            preparedStatement.setString(21,order.getCreditCard());
//            preparedStatement.setString(22,order.getExpiryDate());
//            preparedStatement.setString(23,order.getCardType());
//            preparedStatement.setString(24,order.getLocale());
//
//            preparedStatement.executeUpdate();
//
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()){
//                order.setOrderId(resultSet.getInt(1));
//            }
//
//            DBUtil.closeResultSet(resultSet);
//            DBUtil.closePreparedStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//

}
