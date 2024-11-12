package com.app.restobarpool.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@jakarta.persistence.Table(name = "final_orders")
public class FinalOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private TableOrder tableOrder;
    @OneToOne
    private FoodOrder foodOrder;
    private Double final_total;

}
