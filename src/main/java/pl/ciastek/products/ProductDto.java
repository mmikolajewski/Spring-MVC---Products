package pl.ciastek.products;

import java.util.List;

public class ProductDto {

    private List<Product> productList;
    private double sum;

    public ProductDto(List<Product> productList, double sum) {
        this.productList = productList;
        this.sum = sum;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
