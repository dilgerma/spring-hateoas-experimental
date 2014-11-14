package de.effectivetrainings.rest;

import de.effectivetrainings.domain.Order;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
public class OrderResourceAssembler implements ResourceAssembler<Order, BaseResource> {
    @Override
    public BaseResource toResource(Order entity) {
        BaseResource baseResource = new BaseResource(entity);
        baseResource.add(linkTo(OrderResource.class).slash(entity).withSelfRel());
        return baseResource;
    }
}
