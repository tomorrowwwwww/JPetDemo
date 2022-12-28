package csu.web.mypetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    private Item item;
    private int quantity;
    private boolean inStock;
    private BigDecimal total;
    private String username;

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Item getItem() {
        return item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setItem(Item item) {
        this.item = item;
        calculateTotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }

    public void incrementQuantity() {
        quantity++;
        calculateTotal();
    }

    private void calculateTotal() {
        if (item != null && item.getListPrice() != null) {
            total = item.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }


}
