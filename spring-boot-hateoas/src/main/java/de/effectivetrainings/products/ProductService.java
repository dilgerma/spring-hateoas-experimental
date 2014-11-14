package de.effectivetrainings.products;

import de.effectivetrainings.domain.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@Service
public class ProductService {

    private Map<Long, Product> availableProducts = new HashMap<>();

    public Product byId(Long id) {
        return availableProducts.get(id);
    }

    public Product remove(Long id) {
        return availableProducts.get(id);
    }

    public List<Product> catalog() {
        return new ArrayList<>(availableProducts.values());
    }

    public void newProduct(Product product) {
        availableProducts.put(product.getId(), product);
    }

    @PostConstruct
    protected void initProducts() {
        availableProducts.put(1L, product(1L, "Buch 1", 25d));
        availableProducts.put(2L, product(2L, "Buch 2", 13d));
        availableProducts.put(3L, product(3L, "Buch 3", 3d));
    }

    private Product product(long id, String title, double prize) {
        return new Product(id, title, prize);
    }

}
