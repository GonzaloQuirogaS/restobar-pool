package com.app.restobarpool.services;

import com.app.restobarpool.dto.finalOrder.FinalOrderDto;

import java.util.List;

public interface IFinalOrderService {

    List<FinalOrderDto> findAll();

    FinalOrderDto save(Long idFoodOrder, Long idTableOrder);

}
