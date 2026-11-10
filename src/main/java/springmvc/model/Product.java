
package springmvc.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class Product {

    @PositiveOrZero(message = "Product ID cannot be negative")
    private int id;

    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 2, max = 100,
            message = "Product name must contain 2 to 100 characters")
    private String name;

    @DecimalMin(value = "0.01",
            message = "Product price must be greater than zero")
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
