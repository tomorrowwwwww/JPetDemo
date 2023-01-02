package csu.web.mypetstore.persistance;

import csu.web.mypetstore.domain.Product;

import java.util.List;
public interface ProductDao {
    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);
    Product getProductByName(String name);
}
