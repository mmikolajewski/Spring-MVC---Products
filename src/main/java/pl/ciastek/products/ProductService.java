package pl.ciastek.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    void add(Product product) {
        productsRepository.add(product);
    }

    ProductDto findAll() {
        List<Product> products = productsRepository.findAll();
        double sum = calculateProductsSum(products);
        return new ProductDto(products,sum);
    }

    ProductDto findByCategory(String category) {
        List<Product> products = productsRepository.findByCategory(category);
        double sum = calculateProductsSum(products);
        return new ProductDto(products,sum);
    }

    private static double calculateProductsSum(List<Product> products) {
        return products.stream()
        .map(Product::getPrice)
        .reduce(0.0, Double::sum);
    }


}
