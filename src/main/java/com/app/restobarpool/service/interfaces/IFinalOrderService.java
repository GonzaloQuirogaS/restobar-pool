package com.app.restobarpool.service.interfaces;

import com.app.restobarpool.presentation.dto.finalOrder.FinalOrderDto;

import java.util.List;

public interface IFinalOrderService {

    List<FinalOrderDto> findAll();

    FinalOrderDto save(Long idFoodOrder, Long idTableOrder);

}
