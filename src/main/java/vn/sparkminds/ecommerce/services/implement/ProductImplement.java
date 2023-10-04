package vn.sparkminds.ecommerce.services.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.sparkminds.ecommerce.entities.Product;
import vn.sparkminds.ecommerce.repositories.ProductRepository;
import vn.sparkminds.ecommerce.services.ProductService;
import vn.sparkminds.ecommerce.services.dto.request.ProductRequest;
import vn.sparkminds.ecommerce.services.dto.response.ProductResponse;

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
    public void deleteProduct(Long id) {
       Optional<Product> product=productRepository.findById(id);
       if (product.isPresent()){
           productRepository.deleteById(id);
       }
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
