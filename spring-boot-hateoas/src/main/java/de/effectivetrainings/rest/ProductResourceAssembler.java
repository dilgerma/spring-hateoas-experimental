package de.effectivetrainings.rest;

import de.effectivetrainings.domain.Product;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@Component
public class ProductResourceAssembler implements ResourceAssembler<Product, BaseResource<Product>> {
    @Override
    public BaseResource<Product> toResource(Product product) {
        BaseResource baseResource = new BaseResource(product);
        baseResource.add(linkTo(ProductResource.class).slash(product).withSelfRel());
        baseResource.add(linkTo(BasketResource.class).slash("products").slash(product).withRel("basket"));
        return baseResource;
    }
}
