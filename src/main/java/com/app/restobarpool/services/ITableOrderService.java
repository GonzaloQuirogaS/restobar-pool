package com.app.restobarpool.services;

import com.app.restobarpool.dto.tableOrder.TableOrderDto;

import java.util.List;

public interface ITableOrderService {

    List<TableOrderDto> findAllTableOrder();

    TableOrderDto saveTableOrder(Long id);

}
