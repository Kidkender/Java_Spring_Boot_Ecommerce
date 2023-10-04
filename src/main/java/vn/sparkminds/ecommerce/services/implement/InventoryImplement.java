package vn.sparkminds.ecommerce.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.sparkminds.ecommerce.repositories.InventoryRepository;
import vn.sparkminds.ecommerce.services.InventoryService;
import vn.sparkminds.ecommerce.services.dto.response.InventoryResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryImplement implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInstock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream().map(inventory ->
                InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()
        ).toList();
    }
}
