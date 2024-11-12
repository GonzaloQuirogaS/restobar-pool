package com.app.restobarpool.service.interfaces;

import com.app.restobarpool.presentation.dto.tableOrder.TableOrderDto;

import java.util.List;

public interface ITableOrderService {

    List<TableOrderDto> findAllTableOrder();

    TableOrderDto saveTableOrder(Long id);

}
