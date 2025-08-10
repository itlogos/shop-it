package ag.selm.catalogue.controller.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProductDto(
        @NotNull(message = "{catalogue.products.update.errors.title_is_null}")
        @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_is_invalid}")
        String title,
        @NotNull(message="{catalogue.products.create.errors.price_is_null}")
        @Min(value=0, message="{catalogue.products.create.errors.price_min}")
        @Max(value=5000, message="{catalogue.products.create.errors.price_max}")
        Integer price,
        @Size(max = 1000, message = "{catalogue.products.update.errors.details_size_is_invalid}")
        String details) {
}
