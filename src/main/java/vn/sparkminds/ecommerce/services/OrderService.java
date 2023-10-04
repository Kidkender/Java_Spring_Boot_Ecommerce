package vn.sparkminds.ecommerce.services;

import vn.sparkminds.ecommerce.services.dto.request.OrderRequest;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest);
}
