package com.app.restobarpool.dto.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDto implements Serializable {
    private Long id;
    private Integer table_number;
    private Double price;

}
