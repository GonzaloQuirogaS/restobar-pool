package com.app.restobarpool.services.servicesImpl;

import com.app.restobarpool.dto.finalOrder.FinalOrderDto;
import com.app.restobarpool.mapper.FinalOrderMapper;
import com.app.restobarpool.persistance.entities.FinalOrder;
import com.app.restobarpool.persistance.entities.FoodOrder;
import com.app.restobarpool.persistance.entities.TableOrder;
import com.app.restobarpool.persistance.repository.FinalOrderRepository;
import com.app.restobarpool.persistance.repository.FoodOrderRepository;
import com.app.restobarpool.persistance.repository.TableOrderRepository;
import com.app.restobarpool.services.IFinalOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinalOrderServiceImpl implements IFinalOrderService {

    private final FinalOrderRepository finalOrderRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final TableOrderRepository tableOrderRepository;
    private final FinalOrderMapper finalOrderMapper;

    @Override
    public List<FinalOrderDto> findAll() {
        List<FinalOrder> finalOrders = finalOrderRepository.findAll();
        return finalOrders.stream().map(finalOrderMapper::mapToFinalOrderDto).collect(Collectors.toList());
    }

    @Override
    public FinalOrderDto save(Long idFoodOrder, Long idTableOrder) {
        TableOrder tableOrder = tableOrderRepository.findById(idTableOrder).orElseThrow();
        FoodOrder foodOrder = foodOrderRepository.findById(idFoodOrder).orElseThrow();

        FinalOrder finalOrder = new FinalOrder();
        finalOrder.setTableOrder(tableOrder);
        finalOrder.setFoodOrder(foodOrder);
        finalOrder.setFinal_total(tableOrder.getTotal_price() + foodOrder.getTotal_foods());
        finalOrderRepository.save(finalOrder);
        return finalOrderMapper.mapToFinalOrderDto(finalOrder);

    }
}
