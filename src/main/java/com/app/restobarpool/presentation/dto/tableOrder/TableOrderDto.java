package com.app.restobarpool.presentation.dto.tableOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableOrderDto implements Serializable {
    private Long id;
    private String time;
    private Double total_price;
}

