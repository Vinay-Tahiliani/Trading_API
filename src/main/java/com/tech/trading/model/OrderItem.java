package com.tech.trading.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Coin coin;
    private double quantity;
    private double buyPrice;
    private double sellPrice;
    @JsonIgnore
    @OneToOne
    private Order order;

}
