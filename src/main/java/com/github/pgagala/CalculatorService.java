package com.github.pgagala;

import java.math.BigDecimal;

public class CalculatorService {

    public Number add(Number first, Number second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("null first or second");
        }
        if (first.getClass() != second.getClass()) {
            throw new IllegalArgumentException("different class first and second");
        }

        return switch (first) {
            case BigDecimal number -> number.add(new BigDecimal(second.toString()));
            case Integer number -> number + second.intValue();
            default -> throw new IllegalArgumentException("Number type not supported yet: " + first.getClass());
        };
    }
}
