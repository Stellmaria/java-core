package com.it.academy.md.jc1.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Fuel.")
class FuelTest {
    private Fuel fuel;

    @BeforeEach
    void init() {
        fuel = new Fuel();
    }

    static @NotNull Stream<Arguments> getNumberStationProvideArguments() {
        return Stream.of(
                Arguments.of(1, 2, 3, 1),
                Arguments.of(2, 1, 3, 2),
                Arguments.of(3, 2, 1, 3),
                Arguments.of(1, 1, 100, 1),
                Arguments.of(586, 0, 0, 2),
                Arguments.of(10, 12, 10, 1),
                Arguments.of(0, 0, 0, 1)
        );
    }

    @ParameterizedTest(name = "Fuel reserves: {0}")
    @MethodSource("getNumberStationProvideArguments")
    @DisplayName("Test for method getNumberStation() from class Fuel.")
    void getNumberStation(final int firstFuelReserves, final int secondFuelReserves, final int thirdFuelReserves,
                          final int expected) {
        var actual = fuel.getNumberStation(firstFuelReserves, secondFuelReserves, thirdFuelReserves);

        assertEquals(expected, actual);
    }
}
