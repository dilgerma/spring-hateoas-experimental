package de.effectivetrainings.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MissingResourceException extends RuntimeException {
}
