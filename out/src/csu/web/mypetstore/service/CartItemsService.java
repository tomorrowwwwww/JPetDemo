package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.persistance.CartItemDao;
import csu.web.mypetstore.persistance.impl.CartItemDaoImpl;

import java.util.List;

public class CartItemsService {
    private CartItemDao cartItemDAO;

    public CartItemsService(){ cartItemDAO = new CartItemDaoImpl(); }

    public List<CartItem> getCartByUsername(String username){ return cartItemDAO.getCartByUsername(username);}

    public  void insertItem(CartItem cartItem,String username){
        cartItem.setUsername(username);
        cartItemDAO.insertItem(cartItem);
    }

    public void removeItem(CartItem cartItem){
        cartItemDAO.removeItem(cartItem);
    }

    public void updateCart(CartItem cartItem){
        cartItemDAO.updateCart(cartItem);
    }
}
