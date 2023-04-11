package pl.ciastek.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {

    List<Product> products;

    public ProductsRepository() {
        products = new ArrayList<>();
        products.add(new Product("Mleko", 3.59, Category.FOOD));
        products.add(new Product("Masło", 6.49, Category.FOOD));
        products.add(new Product("Kinder Bueno", 2.99, Category.FOOD));
        products.add(new Product("Krzesło", 12.00, Category.HOME));
        products.add(new Product("Jajowar", 19.00, Category.HOME));
        products.add(new Product("Wiosło", 15.99, Category.OTHER));
        products.add(new Product("kultywator elektryczny", 30.00, Category.OTHER));
    }

    void add(Product product) {
        products.add(product);
    }


    List<Product> findAll() {
        return products;
    }

    List<Product> findByCategory(String category) {
        List<Product> sortedList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getShortDeDescription().equals(category)) {
                sortedList.add(product);
            }
        }
        return sortedList;
    }




}
