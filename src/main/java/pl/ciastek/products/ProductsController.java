package pl.ciastek.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", Category.values());
        return "index";
    }

    @GetMapping("/lista")
    public String list(@RequestParam (required = false, name = "kategoria") String category, Model model) {
        ProductDto productDto;

        if (category != null) {
            productDto = productService.findByCategory(category);

        } else {
            productDto = productService.findAll();
        }
        model.addAttribute("products", productDto);
        return "list";

    }

    @GetMapping("/dodaj")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/dodaj")
    public String add(Product product) {
        productService.add(product);
        return "redirect:/lista?kategoria=" + product.getCategory().getShortDeDescription();
    }


}
