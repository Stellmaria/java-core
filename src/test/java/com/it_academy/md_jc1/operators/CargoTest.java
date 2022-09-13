package com.it_academy.md_jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Cargo.")
class CargoTest {
    private static Cargo c;

    @BeforeAll
    static void init() {
        c = new Cargo();
    }

    static @NotNull Stream<Arguments> numberFullTrucksProvideArguments() {
        return of(
                Arguments.of(2, 2, 1),
                Arguments.of(9, 1, 9),
                Arguments.of(5, 2, 2),
                Arguments.of(20, 50, 0)
        );
    }

    @DisplayName("Test for method getNumberFullTrucks() from class Cargo.")
    @MethodSource("numberFullTrucksProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testNumberFullTrucks(int cargo, int carryingCapacity, int expected) {
        var actual = c.getNumberFullTrucks(cargo, carryingCapacity);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> amountRemainingCargoProvideArguments() {
        return of(
                Arguments.of(1, 2, 1),
                Arguments.of(2, 1, 0),
                Arguments.of(3, 2, 1),
                Arguments.of(20, 50, 20)
        );
    }

    @DisplayName("Test for method getAmountRemainingCargo() from class Cargo.")
    @MethodSource("amountRemainingCargoProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testAmountRemainingCargo(int cargo, int carryingCapacity, int expected) {
        var actual = c.getAmountRemainingCargo(cargo, carryingCapacity);

        assertEquals(expected, actual);
    }
}
