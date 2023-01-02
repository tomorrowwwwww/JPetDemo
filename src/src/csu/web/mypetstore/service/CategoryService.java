package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.domain.Item;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.persistance.CategoryDao;
import csu.web.mypetstore.persistance.ItemDao;
import csu.web.mypetstore.persistance.ProductDao;
import csu.web.mypetstore.persistance.impl.CategoryDaoImpl;
import csu.web.mypetstore.persistance.impl.ItemDaoImpl;
import csu.web.mypetstore.persistance.impl.ProductDaoImpl;

import java.util.List;

public class CategoryService {
    private CategoryDao categoryDAO;
    private ProductDao productDAO;
    private ItemDao itemDAO;

    public CategoryService() {
        categoryDAO = new CategoryDaoImpl();
        productDAO = new ProductDaoImpl();
        itemDAO = new ItemDaoImpl();
    }

    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }
    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
