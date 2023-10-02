package vn.sparkminds.tutorial.services.implement;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.sparkminds.tutorial.services.dto.request.OrderRequest;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderImplement implements Order {
    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
    }
}
