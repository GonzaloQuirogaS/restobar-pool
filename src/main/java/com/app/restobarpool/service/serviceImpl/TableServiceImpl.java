package com.app.restobarpool.service.serviceImpl;

import com.app.restobarpool.presentation.dto.table.SaveTableDto;
import com.app.restobarpool.presentation.dto.table.TableDto;
import com.app.restobarpool.util.mapper.TableMapper;
import com.app.restobarpool.persistence.entity.Table;
import com.app.restobarpool.persistence.repository.TableRepository;
import com.app.restobarpool.service.interfaces.ITableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements ITableService {

    private final TableRepository tableRepository;
    private final TableMapper mapper;

    public List<TableDto> findAllTables() {
        List<Table> tables = tableRepository.findAll();
        return tables.stream().map(mapper::mapToTableDto).collect(Collectors.toList());
    }

    @Override
    public TableDto saveTable(SaveTableDto saveTableDto) {
        Table table = new Table();
        table.setTable_number(saveTableDto.getTable_number());
        table.setPrice(saveTableDto.getPrice());
        tableRepository.save(table);
        return mapper.mapToTableDto(table);
    }

    @Override
    public TableDto findTableById(Long id) {
        Table table = tableRepository.findById(id).orElseThrow();
        return mapper.mapToTableDto(table);
    }

    @Override
    public TableDto deleteTableById(Long id) {
        Table table = tableRepository.findById(id).orElseThrow();
        tableRepository.deleteById(id);
        return mapper.mapToTableDto(table);
    }

    @Override
    public TableDto updateById(Long id, SaveTableDto saveTableDto) {
        Table table = tableRepository.findById(id).orElseThrow();
        table.setPrice(saveTableDto.getPrice());
        table.setTable_number(saveTableDto.getTable_number());

        tableRepository.save(table);

        return mapper.mapToTableDto(table);
    }

    @Override
    public Table setInitialTime(Long id) {
        Table table = tableRepository.findById(id).orElseThrow();
        table.setInitial_time(LocalDateTime.now());
        tableRepository.save(table);
        return table;
    }

    @Override
    public Table setFinalTime(Long id) {
        Table table = tableRepository.findById(id).orElseThrow();
        table.setFinal_time(LocalDateTime.now());
        tableRepository.save(table);
        return table;
    }


}
