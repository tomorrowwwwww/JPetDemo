package csu.web.mypetstore.persistance.impl;

import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.persistance.CartItemDao;
import csu.web.mypetstore.persistance.impl.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartItemDaoImpl implements CartItemDao {
    private static final String FIND_CART_BY_USERNAME =
            "select * from cartitem where username = ?";

    private static final String INSERT_ITEM =
            "insert into cartitem values(?,?,?)";

    private static final String REMOVE_ITEM =
            "delete from cartitem where itemid = ? AND username = ?";

    private static final String UPDATE_CART =
            "update cartitem set number = ? where itemid = ? AND username = ? ";

    @Override
    public List<CartItem> getCartByUsername(String username) {
        List<CartItem> cartItemList = new ArrayList<>();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CART_BY_USERNAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CartItem cartItem = new CartItem();
                cartItem.setItem(new ItemDaoImpl().getItem(resultSet.getString(1)));
                cartItem.setUsername(username);
                cartItem.setQuantity(resultSet.getInt(3));
                cartItemList.add(cartItem);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cartItemList;
    }

    @Override
    public void insertItem(CartItem cartItem) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM);

            preparedStatement.setString(1,cartItem.getItem().getItemId());
            preparedStatement.setString(2,cartItem.getUsername());
            preparedStatement.setInt(3,cartItem.getQuantity());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeItem(CartItem cartItem) {

        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ITEM);
            preparedStatement.setString(1,cartItem.getItem().getItemId());
            preparedStatement.setString(2,cartItem.getUsername());
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCart(CartItem cartItem) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART);
            preparedStatement.setInt(1,cartItem.getQuantity());
            preparedStatement.setString(2,cartItem.getItem().getItemId());
            preparedStatement.setString(3,cartItem.getUsername());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
