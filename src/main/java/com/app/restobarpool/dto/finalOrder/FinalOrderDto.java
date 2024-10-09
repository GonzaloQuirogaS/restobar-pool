package com.app.restobarpool.dto.finalOrder;

import com.app.restobarpool.persistance.entities.FoodOrder;
import com.app.restobarpool.persistance.entities.TableOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalOrderDto implements Serializable {

    private Long id;
    private TableOrder tableOrder;
    private FoodOrder foodOrder;
    private Double final_total;

}
