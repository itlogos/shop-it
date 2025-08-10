package ag.selm.catalogue.service;

import ag.selm.catalogue.entity.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    Product createProduct(String title, int price, String details);

    Optional<Product> findProduct(int productId);

    void updateProduct(Integer id, String title, Integer price, String details);

    void deleteProduct(Integer id);
}
