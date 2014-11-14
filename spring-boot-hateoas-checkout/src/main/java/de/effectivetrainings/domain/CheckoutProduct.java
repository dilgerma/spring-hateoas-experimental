package de.effectivetrainings.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Simplified product view - checkout based.
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CheckoutProduct {

    @JsonProperty(value = "id")
    private Long id;
}
