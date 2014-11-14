package de.effectivetrainings.rest;

import de.effectivetrainings.domain.Basket;
import de.effectivetrainings.domain.Product;
import de.effectivetrainings.products.ProductService;
import de.effectivetrainings.session.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@RestController
@RequestMapping("/basket")
@ExposesResourceFor(Basket.class)
public class BasketResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasketResource.class);

    private final ProductService productService;
    private final ProductResourceAssembler productResourceAssembler;
    private final BasketResourceAssembler basketResourceAssembler;
    //session scoped
    private UserSession userSession;

    @Autowired
    public BasketResource(UserSession userSession, ProductService productService, ProductResourceAssembler productResourceAssembler, BasketResourceAssembler basketResourceAssembler) {
        this.userSession = userSession;
        this.productService = productService;
        this.productResourceAssembler = productResourceAssembler;
        this.basketResourceAssembler = basketResourceAssembler;
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
    public BaseResource putToBasket(@PathVariable("productId") Long productId) {
        final Product product = productService.byId(productId);
        if(product == null) {
            throw new MissingResourceException();
        }
        userSession.getBasket().add(product);
        return basketResourceAssembler.toResource(userSession.getBasket());
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public void removeFromBasket(@PathVariable("productId") Long productId) {
        userSession.getBasket().remove(productId);
    }

    @RequestMapping(value = "/content")
    public Map<Long, Integer> quantities() {
       return userSession.getBasket().quantities();
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public void order() {
       LOGGER.info("Ordered {}", userSession.getBasket().getBasketItems());
    }
}
