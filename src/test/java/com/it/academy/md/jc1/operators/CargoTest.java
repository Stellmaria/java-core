package com.it.academy.md.jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Cargo.")
class CargoTest {
    private Cargo cargo;

    static @NotNull Stream<Arguments> amountRemainingCargoProvideArguments() {
        return Stream.of(
                Arguments.of(1, 2, 1),
                Arguments.of(2, 1, 0),
                Arguments.of(3, 2, 1),
                Arguments.of(20, 50, 20)
        );
    }

    static @NotNull Stream<Arguments> numberFullTrucksProvideArguments() {
        return Stream.of(
                Arguments.of(2, 2, 1),
                Arguments.of(9, 1, 9),
                Arguments.of(5, 2, 2),
                Arguments.of(20, 50, 0)
        );
    }

    @DisplayName("Test for method getNumberFullTrucks() from class Cargo.")
    @MethodSource("numberFullTrucksProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testNumberFullTrucks(final int cargos, final int carryingCapacity, final int expected) {
        var actual = cargo.getNumberFullTrucks(cargos, carryingCapacity);

        assertEquals(expected, actual);
    }

    @BeforeEach
    void init() {
        cargo = new Cargo();
    }

    @DisplayName("Test for method getAmountRemainingCargo() from class Cargo.")
    @MethodSource("amountRemainingCargoProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testAmountRemainingCargo(final int cargos, final int carryingCapacity, final int expected) {
        var actual = cargo.getAmountRemainingCargo(cargos, carryingCapacity);

        assertEquals(expected, actual);
    }
}
