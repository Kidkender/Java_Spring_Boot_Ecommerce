package vn.sparkminds.ecommerce.services;

import vn.sparkminds.ecommerce.services.dto.response.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> isInstock(List<String> skuCode);
}
