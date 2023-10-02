package vn.sparkminds.tutorial.services.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.sparkminds.tutorial.entities.OrderLineItem;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemDTO> orderLineItemsDTOList;
}
