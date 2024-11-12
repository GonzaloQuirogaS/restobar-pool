package com.app.restobarpool.presentation.dto.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveTableDto implements Serializable {
    private Integer table_number;
    private Double price;
}
