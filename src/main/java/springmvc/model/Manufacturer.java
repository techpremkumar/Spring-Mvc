
package springmvc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Manufacturer {

    @NotBlank(message = "Manufacturer name cannot be empty")
    @Size(min = 2, max = 50,
            message = "Manufacturer name must contain 2 to 50 characters")
    private String name;

    @NotBlank(message = "Manufacturer email cannot be empty")
    @Email(message = "Enter a valid manufacturer email")
    private String email;

    public Manufacturer() {
    }

    public Manufacturer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
