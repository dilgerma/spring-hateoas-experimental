package de.effectivetrainings.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@Getter
@NoArgsConstructor
public class Order implements Identifiable {

    private Customer customer;
    private List<CheckoutProduct> products;

    private String id;

    public Order(Customer customer, List<CheckoutProduct> products) {
        id = UUID.randomUUID().toString();
        this.customer = customer;
        this.products = products;
    }

    @Override
    public String getId() {
        return id;
    }
}
