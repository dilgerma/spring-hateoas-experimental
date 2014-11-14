package de.effectivetrainings.rest;

import de.effectivetrainings.domain.Basket;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@Component
public class BasketResourceAssembler implements ResourceAssembler<Basket, BaseResource> {
    @Override
    public BaseResource toResource(Basket basket) {
        BaseResource baseResource = new BaseResource(basket);
        baseResource.add(linkTo(BasketResource.class).slash("order").withRel("order"));
        return baseResource;
    }
}
