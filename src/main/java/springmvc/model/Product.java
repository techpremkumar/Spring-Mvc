
package springmvc.model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import springmvc.validation.OnCreate;
import springmvc.validation.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import springmvc.validation.ValidProductName;

public class Product {

    @NotNull(message = "Product ID is required",
            groups = OnUpdate.class)
    @Positive(message = "Product ID must be positive",
            groups = OnUpdate.class)
    private Integer id;

    @NotBlank(message = "Product name is required",
            groups = OnCreate.class)
    private String name;

    @DecimalMin(value = "0.01",
            message = "Product price must be greater than zero",
            groups = OnCreate.class)
    private double price;
    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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
