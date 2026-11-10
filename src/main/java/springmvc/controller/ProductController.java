
package springmvc.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import springmvc.validation.OnCreate;
import springmvc.validation.OnUpdate;

import springmvc.model.Product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import springmvc.validation.OnCreate;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    // GET: Retrieve all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(products);
    }

    // GET: Retrieve product by ID
    @GetMapping("/header")
    public String getHeader(
            @RequestHeader("User-Agent") String userAgent) {

        return "Your client is: " + userAgent;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(
            @Validated(OnCreate.class)
            @RequestBody Product product) {

        products.add(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int id,
            @Validated(OnUpdate.class)
            @RequestBody Product product) {

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getId() == id) {

                product.setId(id);
                products.set(i, product);

                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
