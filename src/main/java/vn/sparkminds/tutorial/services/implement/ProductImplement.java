package vn.sparkminds.tutorial.services.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.sparkminds.tutorial.entities.Product;
import vn.sparkminds.tutorial.repositories.ProductRepository;
import vn.sparkminds.tutorial.services.ProductService;
import vn.sparkminds.tutorial.services.dto.request.ProductRequest;
import vn.sparkminds.tutorial.services.dto.request.UpdateProductRequest;
import vn.sparkminds.tutorial.services.dto.response.ProductResponse;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class ProductImplement implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName()).description(request.getDescription())
                .price(request.getPrice()).build();

        productRepository.save(product);
        log.info("Product {} saved successfully", product.getId());

    }

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse)
                .toList();
    }

    @Override
    public void updateProduct(Long id, ProductRequest request) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product product1 = Product.builder().name(request.getName())
                    .description(request.getDescription())
                    .price(request.getPrice())
                    .build();
            productRepository.save(product1);
            log.info("Update Product {} saved successfully", product1.getId());
        }

    }


    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName())
                .description(product.getDescription()).price(product.getPrice()).build();
    }


}
