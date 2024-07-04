package it.raffo.raffopizza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull(message = "campo obbligatorio")
    @jakarta.validation.constraints.NotBlank(message = "campo obbligatorio")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull(message = "campo obbligatorio")
    @jakarta.validation.constraints.NotBlank(message = "campo obbligatorio")
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "campo obbligatorio")
    @jakarta.validation.constraints.NotBlank(message = "campo obbligatorio")
    @Column(name = "photo", nullable = false)
    private String photo;

    @NotNull(message = "campo obbligatorio")
    @jakarta.validation.constraints.NotBlank(message = "campo obbligatorio")
    @Column(name = "price", nullable = false)
    private String price;
    // --------------------------------------------
    // ------------ GETTERS & SETTERS -------------
    // --------------------------------------------

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
