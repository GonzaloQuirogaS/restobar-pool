package com.app.restobarpool.service.interfaces;


import com.app.restobarpool.presentation.dto.table.SaveTableDto;
import com.app.restobarpool.presentation.dto.table.TableDto;
import com.app.restobarpool.persistence.entity.Table;

import java.util.List;

public interface ITableService {

    List<TableDto> findAllTables();

    TableDto saveTable(SaveTableDto saveTableDto);

    TableDto findTableById(Long id);

    TableDto deleteTableById(Long id);

    TableDto updateById(Long id, SaveTableDto saveTableDto);

    Table setInitialTime(Long id);

    Table setFinalTime(Long id);

}
