package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.persistance.ItemDao;
import csu.web.mypetstore.persistance.OrderDao;
import csu.web.mypetstore.persistance.impl.ItemDaoImpl;
import csu.web.mypetstore.persistance.impl.OrderDaoImpl;
import java.util.List;

public class OrderService {
    private OrderDao orderDao;

    public OrderService(){
        orderDao = new OrderDaoImpl();
    }

    public List<Order> getOrdersByUsername(String username){ return orderDao.getOrdersByUsername(username);}

    public Order getOrder(int orderId){ return  orderDao.getOrder(orderId);}

    public void insertOrder(Order order){ orderDao.insertOrder(order); }



}
