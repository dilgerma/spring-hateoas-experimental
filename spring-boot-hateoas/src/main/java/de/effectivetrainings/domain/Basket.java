package de.effectivetrainings.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

import java.util.*;

/**
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Basket {

    private Map<Long, List<Product>> basketItems = new HashMap();

    public void add(Product product) {
        final Long productId = product.getId();
        if (basketItems.get(productId) == null) {
            basketItems.put(productId, new ArrayList<Product>());
        }
        basketItems.get(productId).add(product);
    }

    public void remove(final Long id) {
        final List<Product> products = basketItems.get(id);
        if (products != null && !products.isEmpty()) {
            products.remove(0);
        }
    }

    public Map<Long, Integer> quantities() {
        Map<Long, Integer> quantities = new HashMap<>(basketItems.size());
        basketItems.forEach((productId, productList) -> {
            quantities.put(productId, productList.size());
        });
        return quantities;
    }

}
