package vn.sparkminds.tutorial.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.sparkminds.tutorial.services.ProductService;
import vn.sparkminds.tutorial.services.dto.request.ProductRequest;
import vn.sparkminds.tutorial.services.dto.response.ProductResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> GetProducts(){
        return productService.getProducts();
    }

}
