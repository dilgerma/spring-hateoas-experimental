package de.effectivetrainings.rest;

import de.effectivetrainings.domain.Customer;
import de.effectivetrainings.domain.Order;
import de.effectivetrainings.domain.CheckoutProduct;
import de.effectivetrainings.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@RestController
@RequestMapping("/orders")
public class OrderResource {

    private OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResource submit(@RequestBody Order order){
        Order placedOrder = orderService.save(order);
        return new BaseResource(placedOrder);
    }
}
