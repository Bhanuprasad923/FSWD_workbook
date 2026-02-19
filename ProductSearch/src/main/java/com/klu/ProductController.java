package com.klu;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductRepo repo;

    public ProductController(ProductRepo repo) {
        this.repo = repo;
    }

    // findBy
    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // And
    @GetMapping("/category/{category}/price/{price}")
    public List<Product> byCategoryAndPrice(@PathVariable String category,
                                            @PathVariable double price) {
        return repo.findByCategoryAndPriceGreaterThan(category, price);
    }

    // Or
    @GetMapping("/or")
    public List<Product> byCategoryOrName(@RequestParam String category,
                                          @RequestParam String name) {
        return repo.findByCategoryOrName(category, name);
    }

    // Between
    @GetMapping("/filter")
    public List<Product> between(@RequestParam double min,
                                 @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Like
    @GetMapping("/search")
    public List<Product> like(@RequestParam String keyword) {
        return repo.findByNameLike("%" + keyword + "%");
    }

    // GreaterThan
    @GetMapping("/expensive/{price}")
    public List<Product> greaterThan(@PathVariable double price) {
        return repo.findByPriceGreaterThan(price);
    }

    // countBy
    @GetMapping("/count/{category}")
    public long count(@PathVariable String category) {
        return repo.countByCategory(category);
    }

    // existsBy
    @GetMapping("/exists/{name}")
    public boolean exists(@PathVariable String name) {
        return repo.existsByName(name);
    }

    // deleteBy
    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable String name) {
        repo.deleteByName(name);
        return "Product deleted successfully";
    }

    // JPQL Sorting
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.sortByPrice();
    }
}
