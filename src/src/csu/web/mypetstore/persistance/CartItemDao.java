package csu.web.mypetstore.persistance;

import csu.web.mypetstore.domain.CartItem;

import java.util.List;

public interface CartItemDao {
    //1.获得该账户下的购物车
    List<CartItem> getCartByUsername(String username);

    //2.插入商品在购物车中
    void insertItem(CartItem cartItem);

    //3.删除商品在购物车中
    void removeItem(CartItem cartItem);

    //4.更新购物车
    void updateCart(CartItem cartItem);
}
