package ag.selm.catalogue.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "catalogue", name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_title")
    @NotNull
    @Size(min = 3, max = 50)
    private String title;

    @Column(name = "c_price", nullable = false)
    @NotNull(message = "{catalogue.products.create.errors.price_is_null}")
    @Min(value = 0, message = "{catalogue.products.create.errors.price_min}")
    @Max(value = 5000, message = "{catalogue.products.create.errors.price_max}")
    private Integer price;

    @Column(name = "c_details")
    @Size(max = 1000)
    private String details;
}
