package de.effectivetrainings.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@AllArgsConstructor
@Getter
public class BaseResource<T> extends ResourceSupport {

    private T content;
}
