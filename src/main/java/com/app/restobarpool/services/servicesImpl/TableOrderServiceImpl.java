package com.app.restobarpool.services.servicesImpl;

import com.app.restobarpool.dto.table.TableDto;
import com.app.restobarpool.dto.tableOrder.TableOrderDto;
import com.app.restobarpool.mapper.TableOrderMapper;
import com.app.restobarpool.persistance.entities.Table;
import com.app.restobarpool.persistance.entities.TableOrder;
import com.app.restobarpool.persistance.repository.TableOrderRepository;
import com.app.restobarpool.persistance.repository.TableRepository;
import com.app.restobarpool.services.ITableOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableOrderServiceImpl implements ITableOrderService {

    private final TableOrderRepository tableOrderRepository;
    private final TableRepository tableRepository;
    private final TableOrderMapper mapper;

    @Override
    public List<TableOrderDto> findAllTableOrder() {
        List<TableOrder> tableOrders = tableOrderRepository.findAll();
        return tableOrders.stream().map(mapper::mapToTableOrderDto).collect(Collectors.toList());
    }

    @Override
    public TableOrderDto saveTableOrder(Long id) {

        //Obtener datos de Table
        Table table = tableRepository.findById(id).orElseThrow();
        LocalDateTime initial = table.getInitial_time();
        LocalDateTime finalTime = table.getFinal_time();

        //Calcular diferencia entre la el tiempo inicial y el tiempo final
        Duration duration = Duration.between(initial, finalTime);

        // Crear un nuevo LocalDateTime que represente la diferencia
        LocalDateTime difference = LocalDateTime.of(1970, 1, 1, 0, 0, 0).plusSeconds(duration.getSeconds());

        // Obtener el tiempo de la diferencia
        LocalTime differenceLocalTime = difference.toLocalTime();

        // Formatear el tiempo de la diferencia como HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String differenceLocalTimeFormatted = differenceLocalTime.format(formatter);

        //Calcular milisegundos entre 2 datos
        long time = duration.toMillis();

        //Pasar de milisegundos a hora y redondear el resultado
        double timeHour = (double) time / 3600000;
        timeHour = (long) (timeHour * 100) / 100d;

        //Calcular el precio total de uso por hora y redondearlo
        double total_price = table.getPrice() * timeHour;
        total_price = (total_price * 100) / 100d;

        //Guardar TableOrder
        TableOrder tableOrder = new TableOrder();
        tableOrder.setTime(differenceLocalTimeFormatted);
        tableOrder.setTotal_price(total_price);
        tableOrderRepository.save(tableOrder);

        //Resetear valores de Table
        table.setInitial_time(null);
        table.setFinal_time(null);
        tableRepository.save(table);

        return mapper.mapToTableOrderDto(tableOrder);
    }
}
