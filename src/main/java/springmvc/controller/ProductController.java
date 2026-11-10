
package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;
import springmvc.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    // GET: Retrieve all products
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    // GET: Retrieve product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST: Add a new product with validation
    @PostMapping
    public ResponseEntity<?> addProduct(
            @Valid @RequestBody Product product,
            BindingResult result) {

        if (result.hasErrors()) {

            Map<String, String> errors = result.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                            error -> error.getField(),
                            error -> error.getDefaultMessage(),
                            (first, second) -> first
                    ));

            return ResponseEntity
                    .badRequest()
                    .body(errors);
        }

        products.add(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }
}
