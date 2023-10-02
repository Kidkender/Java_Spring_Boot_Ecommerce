package vn.sparkminds.tutorial.services;

import vn.sparkminds.tutorial.services.dto.request.ProductRequest;
import vn.sparkminds.tutorial.services.dto.response.ProductResponse;

import java.util.List;


public interface ProductService {
    public void createProduct(ProductRequest request);

    public List<ProductResponse> getProducts();
    public void updateProduct(Long id,ProductRequest request);
}

