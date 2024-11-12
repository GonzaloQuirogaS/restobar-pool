package com.app.restobarpool.util.mapper;

import com.app.restobarpool.presentation.dto.table.TableDto;
import com.app.restobarpool.persistence.entity.Table;
import org.springframework.stereotype.Service;

@Service
public class TableMapper {
    public TableDto mapToTableDto(Table table) {
        if (table == null) return null;
        TableDto tableDto = new TableDto();
        tableDto.setId(table.getId());
        tableDto.setTable_number(table.getTable_number());
        tableDto.setPrice(table.getPrice());

        return tableDto;
    }
}
