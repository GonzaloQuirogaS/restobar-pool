package com.app.restobarpool.util.mapper;

import com.app.restobarpool.presentation.dto.finalOrder.FinalOrderDto;
import com.app.restobarpool.persistence.entity.FinalOrder;
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
