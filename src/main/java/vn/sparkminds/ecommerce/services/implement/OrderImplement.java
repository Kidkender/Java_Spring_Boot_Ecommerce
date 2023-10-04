package vn.sparkminds.ecommerce.services.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import vn.sparkminds.ecommerce.entities.Order;
import vn.sparkminds.ecommerce.entities.OrderLineItem;
import vn.sparkminds.ecommerce.repositories.OrderRepository;
import vn.sparkminds.ecommerce.services.OrderService;
import vn.sparkminds.ecommerce.services.dto.request.OrderLineItemDTO;
import vn.sparkminds.ecommerce.services.dto.request.OrderRequest;
import vn.sparkminds.ecommerce.services.dto.response.InventoryResponse;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderImplement implements OrderService {
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemsDTOList()
                .stream().map(this::mapToDto).toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes =
                order.getOrderLineItemsList().stream().map(OrderLineItem::getSkuCode).toList();

        InventoryResponse[] inventoryResponsesArray = webClient.get()
                .uri("http://localhost:8181/api/v1/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",
                                skuCodes).build())
                .retrieve().bodyToMono(InventoryResponse[].class).block();

        Boolean allProductsInStock=
                Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponse::isInStock);

        if (Boolean.TRUE.equals(allProductsInStock )) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, " +
                    "please try again");
        }
    }

    private OrderLineItem mapToDto(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItemDTO.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDTO.getSkuCode());
        return orderLineItem;
    }
}
