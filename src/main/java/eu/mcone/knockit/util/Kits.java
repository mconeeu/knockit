package eu.mcone.knockit.util;

import lombok.Getter;

public enum Kits {
    DEFAULT("DEFAULT"),
    ARCHER("ARCHER"),
    KNOCKBACK("KNOCKBACK"),
    GRAPPLING_HOOK("GRAPPLING_HOOK"),
    ENDERMAN("ENDERMAN");

    @Getter
    private final String name;

    Kits(final String name) {
        this.name = name;
    }
}
