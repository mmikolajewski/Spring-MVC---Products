package pl.ciastek.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {

    ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", Category.values());
        return "index";
    }

    @GetMapping("/lista")
    public String list(@RequestParam (required = false, name = "kategoria") String category, Model model) {
        List<Product> products;

        if (category != null) {
            products = productsRepository.findByCategory(category);

        } else {
            products = productsRepository.findAll();
        }
        model.addAttribute("products", products);

        double sum = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        model.addAttribute("priceSum", sum);
        return "list";

    }

    @GetMapping("/dodaj")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", Category.values());
        return "add";
    }

    @PostMapping("/dodaj")
    public String add(Product product) {
        productsRepository.add(product);
        return "redirect:/lista?kategoria=" + product.getCategory().getShortDeDescription();
    }


}
