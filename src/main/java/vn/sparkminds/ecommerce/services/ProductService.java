package vn.sparkminds.ecommerce.services;

import vn.sparkminds.ecommerce.services.dto.request.ProductRequest;
import vn.sparkminds.ecommerce.services.dto.response.ProductResponse;

import java.util.List;


public interface ProductService {
    public void createProduct(ProductRequest request);

    public List<ProductResponse> getProducts();


    void deleteProduct(Long id);



    public void updateProduct(Long id, ProductRequest request);
}

