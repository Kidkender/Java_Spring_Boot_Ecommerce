package vn.sparkminds.tutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_item")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "skuCode")
    private String skuCode;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
}
