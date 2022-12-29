package csu.web.mypetstore.persistance;

import csu.web.mypetstore.domain.Order;

import java.util.List;

public interface OrderDao {
    //获得该账户下的所有订单
    List<Order> getOrdersByUsername(String username);

    //根据订单id获得订单
    Order getOrder(int orderId);

    //插入订单
    void insertOrder(Order order);
}
