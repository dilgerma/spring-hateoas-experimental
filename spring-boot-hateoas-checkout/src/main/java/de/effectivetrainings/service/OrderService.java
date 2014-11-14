package de.effectivetrainings.service;

import de.effectivetrainings.domain.Customer;
import de.effectivetrainings.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private List<Order> placedOrders = new ArrayList<>();

    public Order save(Order order) {
        placedOrders.add(order);
        LOGGER.info("Storing Order {}", order);
        return order;
    }
}
