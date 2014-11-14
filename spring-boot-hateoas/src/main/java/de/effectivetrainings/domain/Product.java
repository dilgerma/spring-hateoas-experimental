package de.effectivetrainings.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product implements Identifiable {

    private Long id;
    private String title;
    private Double prize;

    public Product(Product other) {
        this(other.id, other.title, other.prize);
    }
}
