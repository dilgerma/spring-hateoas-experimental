package de.effectivetrainings.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;
    private String email;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
