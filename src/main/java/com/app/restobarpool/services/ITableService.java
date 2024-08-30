package com.app.restobarpool.services;


import com.app.restobarpool.dto.table.SaveTableDto;
import com.app.restobarpool.dto.table.TableDto;

import java.util.List;

public interface ITableService {

    List<TableDto> findAllTables();

    TableDto saveTable(SaveTableDto saveTableDto);

    TableDto findTableById(Long id);

    TableDto deleteTableById(Long id);

    TableDto updateById(Long id, SaveTableDto saveTableDto);
}
