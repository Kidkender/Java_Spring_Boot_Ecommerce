package vn.sparkminds.tutorial.services;

import vn.sparkminds.tutorial.entities.Order;
import vn.sparkminds.tutorial.services.dto.request.OrderRequest;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest);
}
