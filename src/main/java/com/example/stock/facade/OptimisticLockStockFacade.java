package com.example.stock.facade;

import com.example.stock.service.OptimisticLockStockService;
import org.springframework.stereotype.Component;

@Component
public class OptimisticLockStockFacade {

  private final OptimisticLockStockService optimisticLockStockService;

  public OptimisticLockStockFacade(OptimisticLockStockService optimisticLockStockService) {
    this.optimisticLockStockService = optimisticLockStockService;
  }

  public void decrease(Long id, Long quality) throws InterruptedException {
    while (true) {
      try {
        optimisticLockStockService.decrease(id, quality);
        break;
      } catch (Exception e) {
        Thread.sleep(50);
      }
    }
  }
}
