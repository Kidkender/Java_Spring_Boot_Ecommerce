package vn.sparkminds.tutorial.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.sparkminds.tutorial.services.dto.request.OrderRequest;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest){
return "Order Placed successfully";
    }
}
