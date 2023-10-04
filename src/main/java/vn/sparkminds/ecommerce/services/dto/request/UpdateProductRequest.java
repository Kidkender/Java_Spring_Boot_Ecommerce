package vn.sparkminds.ecommerce.services.dto.request;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private Long id;
    private String name;
    private String description;
    private String price;
}
