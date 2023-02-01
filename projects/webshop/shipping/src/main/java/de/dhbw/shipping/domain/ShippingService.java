package de.dhbw.shipping.domain;

import de.dhbw.shipping.domain.db.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private final OrderRepo orderRepo;

    public ShippingService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}
