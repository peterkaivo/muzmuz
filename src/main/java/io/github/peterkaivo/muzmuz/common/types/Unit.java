package io.github.peterkaivo.muzmuz.common.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for commonly used measurement units
 */
public enum Unit {
    MM("mm"),
    CM("cm"),
    M("m"),
    IN("in"),
    DEG("°"),
    PX("px"),
    UNDEFINED("undefined");

    private final String unit;
    private static final Map<String, Unit> VALUES = new HashMap<>();
    static {
        for (Unit unit : values()) {
            VALUES.put(unit.unit, unit);
        }
    }

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public Unit fromString(String unit) {
        return VALUES.get(unit);
    }

    @Override
    public String toString() {
        return this.unit;
    }
}
