package com.app.restobarpool.mapper;

import com.app.restobarpool.dto.finalOrder.FinalOrderDto;
import com.app.restobarpool.persistance.entities.FinalOrder;
import org.springframework.stereotype.Service;

@Service
public class FinalOrderMapper {

    public FinalOrderDto mapToFinalOrderDto(FinalOrder finalOrder) {

        if (finalOrder == null) return null;
        FinalOrderDto finalOrderDto = new FinalOrderDto();
        finalOrderDto.setId(finalOrder.getId());
        finalOrderDto.setTableOrder(finalOrder.getTableOrder());
        finalOrderDto.setFoodOrder(finalOrder.getFoodOrder());
        finalOrderDto.setFinal_total(finalOrder.getFinal_total());

        return finalOrderDto;
    }


}
