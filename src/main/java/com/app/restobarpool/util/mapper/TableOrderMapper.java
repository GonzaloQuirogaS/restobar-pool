package com.app.restobarpool.util.mapper;

import com.app.restobarpool.presentation.dto.tableOrder.TableOrderDto;
import com.app.restobarpool.persistence.entity.TableOrder;
import org.springframework.stereotype.Service;

@Service
public class TableOrderMapper {

    public TableOrderDto mapToTableOrderDto(TableOrder tableOrder) {

        if (tableOrder == null) return null;
        TableOrderDto tableOrderDto = new TableOrderDto();
        tableOrderDto.setId(tableOrder.getId());
        tableOrderDto.setTime(tableOrder.getTime());
        tableOrderDto.setTotal_price(tableOrder.getTotal_price());

        return tableOrderDto;
    }


}
