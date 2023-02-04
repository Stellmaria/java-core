package com.it.academy.md.jc1.decision_making_statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Damage.")
class DamageTest {
    private Damage damage;

    static @NotNull Stream<Arguments> getTotalDamageProvideArguments() {
        return Stream.of(
                Arguments.of(100, "UNDEAD", true, 150),
                Arguments.of(10, "ZOMBIE", true, 15),
                Arguments.of(90, "SAINT", true, 45),
                Arguments.of(15, "ANIMAL", true, 15),
                Arguments.of(25, "HUMANOID", true, 25),
                Arguments.of(1000, "PLANT", true, 1000),
                Arguments.of(100, "GHOST", true, 100)
        );
    }

    @BeforeEach
    void init() {
        damage = new Damage();
    }

    @ParameterizedTest(name = "Weapon damage and type mob: {0}")
    @MethodSource("getTotalDamageProvideArguments")
    @DisplayName("Test for method getTotalDamage() from class Damage.")
    void getTotalDamage(final int damages, final String typeMob, final boolean hasHolyAttribute, final int expected) {
        var totalDamage = damage.getTotalDamage(damages, typeMob, hasHolyAttribute);

        assertEquals(expected, totalDamage);
    }
}
